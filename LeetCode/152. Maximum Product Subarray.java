    /**
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
    
    // 动态规划版
    // 正数乘以正数为正数，负数乘以负数为正数。如果当前累积乘积为正数，则乘以正数才会更大。如果当前累积乘积为负数，则乘以负数才会得到更大的值。
    // 代码中有两个变量 maxPro 和 minPro。
    // maxPro用于记录走到当前位置，之前连续累积起来的最大正数值
    // （注意，这个是连续的，如果在累积的过程中出现负数，导致断开，则乘积又会重新下一次第一个出现的正数开始往后累积）
    // minPro用于记录走到当前位置，之前连续累积起来的最小负数值，如果在累积过程中出现一个负数乘起来变成正数，则会在下一次遇到负数时继续记录
    // t1 和 t2 不是固定代表两者中更大或者更小的，所以累积的最大正数值和累积的最小负数值都一直被记录着
    public int maxProduct1(int[] nums){
        int maxPro= nums[0];
        int minPro = nums[0];
        int res = nums[0];

        int n = nums.length;
        for(int i = 1 ;i < n; i++){
            int t1 = maxPro*nums[i];
            int t2 = minPro*nums[i];
            maxPro = Math.max(Math.max(t1,t2),nums[i]);
            minPro = Math.min(Math.min(t1,t2),nums[i]);
            res = Math.max(maxPro,res);
        }

        return res;
    }

    // 朴素版
    public int maxProduct2(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        for (int i = 0; i < len; i++) {
            int last = nums[i];
            if(last > max){
                max = last;
            }
            for (int j = i+1; j < len; j++) {
                int tmp = last * nums[j];
                if(tmp > max){
                    max = tmp;
                }
                last = tmp;
            }
        }
        return max;
    }