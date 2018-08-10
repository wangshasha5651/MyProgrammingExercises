    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row == 0){
            return false;
        }
        int col = matrix[0].length;
        if(col == 0){
            return false;
        }
        int realrow = 0;
        for (int i = 0; i < row; i++) {
            if( target > matrix[i][col-1]){
                if(i < row-1)
                    continue;
                else
                    return false;
            }else if(target < matrix[i][col-1]){
                realrow = i;
                break;
            }else{
                return true;
            }
        }

        for (int j = 0; j < col; j++) {
            if(target == matrix[realrow][j]){
                return true;
            }else if(j == col-1){
                return false;
            }
        }
        return true;
    }