/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */

class Solution {
    public int trap(int[] height){
            if(height.length == 0 || height == null){
                return 0;
            }
            int len = height.length;

            int[] leftmax = new int[len];
            int tmpLeftMax = height[0];
            for (int i = 0; i < len; i++) {
                if(height[i] > tmpLeftMax){
                    leftmax[i] = height[i];
                    tmpLeftMax = height[i];
                }else{
                    leftmax[i] = tmpLeftMax;
                }
            }
            int[] rightmax = new int[len];
            int tmpRightMax = height[len-1];
            for (int i = len-1; i >= 0; i--) {
                if(height[i] > tmpRightMax){
                    rightmax[i] = height[i];
                    tmpRightMax = height[i];
                }else{
                    rightmax[i] = tmpRightMax;
                }
            }

            int sum = 0;
            int maxLeft, maxRight;
            for (int i = 1; i < len-1; i++) {
                maxLeft = leftmax[i-1];
                maxRight = rightmax[i+1];
                int delta = Math.min(maxLeft, maxRight) - height[i];
                if(delta > 0){
                    sum += delta;
                }
            }
            return sum;
        }
}