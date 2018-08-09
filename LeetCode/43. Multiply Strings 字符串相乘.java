// 由于是字符串的值相乘，因此相乘后很容易就超过int型的范围，因此此题的模仿高精度乘法
    // 让一个乘数的各个位上的数分别乘以另一个乘数各位上的数
    // 注意： 1、进位  2、错位相加
    public String multiply(String num1, String num2) {
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int m = nums1.length;
        int n = nums2.length;
        int[] result = new int[m + n];
        for (int i = 0; i < m; i++) {
            nums1[i] -= '0';
        }
        for (int i = 0; i < n; i++) {
            nums2[i] -= '0';
        }
        int i,j,k;
        // i j都是从字符串的最低位开始，实际上在数字中却是最高位，因此要在里面用m-1-i和n-1-j
        for (i = 0; i < m; i++) {
            int carry = 0;
            for (j = 0; j < n; j++) {
                int n1 = nums1[m - 1 -i];
                int n2 = nums2[n - 1 -j];
                // 这一步实际上同时实现了进位和错位相加，进位是靠carry，错位相加是靠i+j
                result[i+j] = result[i+j] + n1 * n2 + carry;
                carry = result[i+j] / 10;
                result[i+j] = result[i+j] % 10;
            }
            // 下面是处理最高位的进位情况
            k = i + j;
            while(carry != 0){
                result[k] = result[k] +carry;
                carry = result[k] / 10;
                result[k] = result[k] % 10;
                k++;
            }
        }

        //开始连接成字符串，从上面的result中倒着来添加
        int p = m + n - 1;
        StringBuilder sb = new StringBuilder(p);
        //去除没有用到的空间中的0
        while(p > 0 && result[p] == 0){
            p--;
        }
        while(p >= 0){
            sb.append(result[p]);
            p--;
        }
        return sb.toString();

    }