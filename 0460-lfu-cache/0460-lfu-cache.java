import java.util.*;

class LFUCache {

    int capacity, minFreq = 0;

    HashMap<Integer, Integer> values = new HashMap<>();
    HashMap<Integer, Integer> freq = new HashMap<>();
    HashMap<Integer, LinkedHashSet<Integer>> groups = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }

        updateFreq(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (values.containsKey(key)) {
            values.put(key, value);
            updateFreq(key);
            return;
        }

        if (values.size() == capacity) {
            LinkedHashSet<Integer> set = groups.get(minFreq);
            int removeKey = set.iterator().next();

            set.remove(removeKey);
            values.remove(removeKey);
            freq.remove(removeKey);
        }

        values.put(key, value);
        freq.put(key, 1);

        groups.computeIfAbsent(1, x -> new LinkedHashSet<>()).add(key);
        minFreq = 1;
    }

    private void updateFreq(int key) {
        int oldFreq = freq.get(key);

        LinkedHashSet<Integer> oldSet = groups.get(oldFreq);
        oldSet.remove(key);

        if (oldFreq == minFreq && oldSet.isEmpty()) {
            minFreq++;
        }

        int newFreq = oldFreq + 1;
        freq.put(key, newFreq);

        groups.computeIfAbsent(newFreq, x -> new LinkedHashSet<>()).add(key);
    }
}