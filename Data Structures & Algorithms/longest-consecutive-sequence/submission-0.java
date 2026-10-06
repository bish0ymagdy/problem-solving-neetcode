class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int maxLength = 0;
        for (int num : nums){
            if (!numSet.contains(num-1)){
                int length = 1;
                int currentNum = num;

                while (numSet.contains(currentNum + 1)){
                    currentNum++;
                    length++;
                }

                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength; 
    }
}
