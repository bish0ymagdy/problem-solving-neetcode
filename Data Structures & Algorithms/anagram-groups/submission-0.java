class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Sort characters to create a uniform key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = String.valueOf(chars);

            // Add the original string to its corresponding group
            map.putIfAbsent(sortedKey, new ArrayList<>());
            map.get(sortedKey).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
