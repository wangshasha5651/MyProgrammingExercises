/**
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 *
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

int numDecodings(String s) {
        int len = s.length();
        if(len == 0)
            return 0;

        int current;
        if(s.charAt(0) == '0'){
            current = 0;
        }else{
            current = 1;
        }
        int last = 1;
        for (int i = 1; i < len; i++) {
            // 记录下上一个位置的个数，因为之后会有变化，在这里先记录
            int tmp = current;
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2'){
                    current = last;
                }else{
                    return 0;
                }
            }else if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6'){
                    current = current + last;
            }
            last = tmp;
        }
        return current;
    }
