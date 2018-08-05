/**
 * Example:
 *
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 *
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 */

public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'O') {
                    if(i == 0 || i == row-1 || j == 0 || j == col-1){
                        BFS(i, j, board);
                    }
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    // 之前有一个方案，是新建一个Node类，类属性包含i, j，队列中就存储Node类型，但是因为要频繁新建Node入栈，会导致超时。
    // 这里改进的方案，是将横纵坐标融入进一个整数，最后通过整除和mod两种方式来获得对应行和列
    public void BFS(int i, int j, char[][] board){
        if(board[i][j] != 'O')
            return;
        board[i][j] = '#';
        LinkedList<Integer> queue = new LinkedList();
        int index = i * board[0].length + j;
        queue.offer(index);
        while(!queue.isEmpty()) {
            index = queue.poll();
            int row = index / board[0].length;
            int col = index % board[0].length;
            if(row - 1 >= 0 && board[row - 1][col] == 'O') {
                board[row - 1][col] = '#';
                queue.offer((row - 1) * board[0].length + col);
            }
            if(row + 1 < board.length && board[row + 1][col] == 'O') {
                board[row + 1][col] = '#';
                queue.offer((row + 1) * board[0].length + col);
            }
            if(col - 1 >= 0 && board[row][col - 1] == 'O') {
                board[row][col - 1] = '#';
                queue.offer(row * board[0].length + (col - 1));
            }
            if(col + 1 < board[0].length && board[row][col + 1] == 'O') {
                board[row][col + 1] = '#';
                queue.offer(row * board[0].length + (col + 1));
            }
        }
    }