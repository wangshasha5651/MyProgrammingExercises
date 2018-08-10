    // curReach:用于记录在当前位置能跳跃到的最大下标 （注意，是下标）
    // lastReachMax: 用于记录上一个位置能够跳跃到的最大下标
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int curReach = nums[0];
        int lastReachMax = 0;
        int step = 0;

        // 这里 i <= curReach 就是用于控制在当前位置可以跳跃到的最大下标（和nums[i]有关）
        for (int i = 1; i <= curReach && i < nums.length; i++) {
            // 如果当前下标大于上一个位置能跳到的最大下标，说明从上一位置到这一位置还需要再跳一步（因为i每次+1），因此这里step要加一
            if (i > lastReachMax) {
                step++;
                lastReachMax = curReach;
            }
            // 当前能跳到的最大下标，是在“上一次当前能跳到的最大下标”和“当前位置下标加上当前位置能跳的最大步数”中取最大值
            curReach = Math.max(curReach, i+nums[i]);
        }
        // 如果到最后 还是不能跳到终点，返回0
        if (curReach < nums.length-1) return 0;
        return step;
    }