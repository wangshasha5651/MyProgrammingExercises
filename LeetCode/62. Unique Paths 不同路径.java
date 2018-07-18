/**
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 */

/*法1 动态规划使用一个二维数组,来记忆起点到达当前每一点可行的走法总数 */
    public int uniquePaths(int m, int n) {
        int[][] nums = new int[n][m];
        for (int i = 0 ;i < n;i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0){
                    nums[i][j] = 1;
                }else if(i == 0){
                    nums[i][j] = nums[i][j - 1];
                }else if(j ==0){
                    nums[i][j] = nums[i - 1][j];
                }else{
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }

            }
        }
        return nums[n - 1][m - 1];
    }


/*法2 递归 会有格子被重复计算（会超时）*/
class Node{
        int x;
        int y;
        public Node(){
            this.x = 0;
            this.y = 0;
        }
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return 0;
        }
        Node start = new Node(0, 0);
        Node end = new Node(n-1, m-1);
        return findPaths(start, end);
    }
    public int findPaths(Node now, Node end){
        if(now.x == end.x && now.y == end.y){
            return 1;
        }
        int right = 0, down = 0;
        if(now.y < end.y){
            right = findPaths(new Node(now.x, now.y+1), end);
        }
        if(now.x < end.x){
            down = findPaths(new Node(now.x+1, now.y), end);
        }
        return right+down;
    }