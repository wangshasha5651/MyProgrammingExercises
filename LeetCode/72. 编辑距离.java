
/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 *
 * 【示例】
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 */

public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] matrix = new int[m+1][n+1];

        for (int i = 0; i < n+1; i++) {
            matrix[0][i] = i;
        }
        for (int i = 0; i < m+1; i++) {
            matrix[i][0] = i;
        }
        int cost, tmp;
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                cost = word1.charAt(i-1) == word2.charAt(j-1)? 0:1;
                tmp = Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1);
                matrix[i][j] = Math.min( matrix[i-1][j-1]+cost, tmp);
            }
        }
        return matrix[m][n];
    }