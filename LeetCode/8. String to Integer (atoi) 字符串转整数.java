    public int myAtoi(String str) {

        int len = str.length();
        // 是否空串
        if(len == 0){
            return 0;
        }
        int notNullIndex = 0;
        while(notNullIndex >= 0 && notNullIndex < len && str.charAt(notNullIndex) == ' '){  // 过滤掉空格
            notNullIndex++;
        }

        int predix = 1;  // 记录符号正负
        if (notNullIndex >= len) {
            return 0;
        }
        char firstchar = str.charAt(notNullIndex);

        if(firstchar == '-'){  // 第一个非空字符表示符号
            predix = -1;
        } else if(firstchar == '+'){
            predix = 1;
        } else if(firstchar < '0' || firstchar > '9'){   // 第一个非空字符非符号位，也非数字
            return 0;
        }

        long res = 0;
        if(firstchar == '-' || firstchar == '+'){ // 如果存在符号位，则第一个数字位在下一位
            notNullIndex++;
        }
        for (int i = notNullIndex; i < str.length(); i++) {
            char nowchar = str.charAt(i);
            if( nowchar >= '0' && nowchar <= '9'){
                res = res * 10 + (nowchar - '0');   // 从最高位依次乘以10，这样就不需要再用一个循环来计算数字的值了
                if(predix == 1 && res*predix > Integer.MAX_VALUE){ //超过int型范围
                    return Integer.MAX_VALUE;
                }
                if(predix == -1 && res*predix < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        return (int)res*predix;
    }