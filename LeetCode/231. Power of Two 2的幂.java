    
    /* 递归除以2 */
     public boolean isPowerOfTwo(int n) {
         if(n <= 0){
             return false;
         }
         if(n == 1){
             return true;
         }
         if(n%2 != 0){
             return false;
         }
         return isPowerOfTwo(n/2);
     }

    /* 2的幂最高位都是1 */
     public boolean isPowerOfTwo(int n) {
         if(n <= 0)
             return false;
         return (n&(n-1)) == 0;
     }

    /* 数二进制中1的个数 */
     public boolean isPowerOfTwo(int n) {
         if(n <= 0)
             return false;

         int ones = Integer.bitCount(n);
         if(ones == 1)
             return true;
         else
             return false;

     }