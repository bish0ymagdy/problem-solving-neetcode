class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length];

        for (int num : countMap.keySet()) {
            int freq = countMap.get(num);
            int index = freq - 1;
            
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--){
            if (buckets[i] != null){
                for (int num : buckets[i]){
                    result[index++] = num;
                    if (index == k){
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
