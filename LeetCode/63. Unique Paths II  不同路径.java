/**
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */


// 增加判断条件，判断为障碍物时，辅助数组当前坐标上的值为0
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] nums = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(obstacleGrid[i][j] == 0){
                    if(i == 0 && j == 0){
                        nums[i][j] = 1;
                    }else if(i == 0){
                        nums[i][j] = nums[i][j-1];
                    }else if(j == 0){
                        nums[i][j] = nums[i-1][j];
                    }else{
                        nums[i][j] = nums[i-1][j] + nums[i][j-1];
                    }

                }else{
                    nums[i][j] = 0;
                }
            }
        }
        return nums[rowLen-1][colLen-1];
    }