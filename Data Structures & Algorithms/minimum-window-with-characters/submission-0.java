class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0
            || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                char leftChar = s.charAt(l);

                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    minLeft = l;
                }

                windowCounts.put(leftChar, windowCounts.get(leftChar) - 1);
                if (dictT.containsKey(leftChar)
                    && windowCounts.get(leftChar) < dictT.get(leftChar)) {
                    formed--;
                }

                l++;
            }

            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}