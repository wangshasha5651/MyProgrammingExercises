    /**
     * @param A: an array
     * @return: total of reverse pairs
     */
    public long reversePairs(int[] A) {
        // write your code here
        long ret = 0;
        int len = A.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if(A[i] > A[j]){
                    ret++;
                }
            }
        }
        return ret;
    }