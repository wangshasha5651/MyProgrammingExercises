    
    // 两个数如果不能对齐，则高位补0
    // 每次相加结果都用insert方法插入到字符串的第0位
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int maxlen = Math.max(a.length(), b.length());

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < maxlen; i++) {
            int numa = i < lena? a.charAt(lena - i - 1) - '0' : 0;
            int numb = i < lenb? b.charAt(lenb - i - 1) - '0' : 0;
            int res = (numa + numb + carry) % 2;
            carry = numa + numb + carry > 1? 1:0;
            sb.insert(0, res);
        }
        if(carry == 1) // 如果最高位有进位，则最高位还要加一位 1
            sb.insert(0, 1);
        return sb.toString();
    }