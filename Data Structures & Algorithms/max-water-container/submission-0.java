class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int best = 0;

        while (left < right){
            int min = Math.min(heights[left], heights[right]);
            best = Math.max(min * (right - left), best);
            
            if (heights[left] < heights[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return best;
    }
}
