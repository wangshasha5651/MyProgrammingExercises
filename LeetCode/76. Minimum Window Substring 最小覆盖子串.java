


https://www.jianshu.com/p/92bec8fbe72e


/* 法二（超时） */
public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        int index;
        for (int i = t.length(); i <= s.length(); i++) { // 滑动窗口大小，逐渐增大
            for (int j = 0; i+j <= s.length(); j++) { // 滑动的过程
                String tmp = s.substring(j, j+i);
                StringBuilder sb = new StringBuilder(tmp);
                int count = 0;
                for (int k = 0; k < t.length(); k++) {
                    index = sb.indexOf(String.valueOf(t.charAt(k)));
                    if(index != -1){
                        sb.deleteCharAt(index);
                        count++;
                    }
                }
                if(count == t.length()){
                    return tmp;
                }
            }
        }
        return "";
    }

/* 法三（超时）*/
public String minWindow(String s, String t) {
        String res = new String("");
        int slen = s.length();
        int[] num = new int[slen];

        List<Character> list = new LinkedList<Character>();
        for (int i = 0; i < t.length(); i++) {
            list.add(t.charAt(i));
        }

        int sum = 0;
        int index;
        for (int i = 0; i < slen; i++) {
             num[i] = t.indexOf(s.charAt(i));
        }
        for (int i = 0; i < slen; i++) {
            if(num[i] != -1){
                List<Character> tmplist = new LinkedList<Character>(list);
                ((LinkedList<Character>) tmplist).removeFirstOccurrence(s.charAt(i));
                if(tmplist.size() == 0){
                    res = String.valueOf(s.charAt(i));
                }
                for (int j = i+1; j < slen; j++) {
                    if(num[j] != -1){
                        if(tmplist.contains(s.charAt(j))){
                            ((LinkedList<Character>) tmplist).removeFirstOccurrence(s.charAt(j));
                        }else{
                            continue;
                        }
                    }else{
                        continue;
                    }
                    if(tmplist.size() == 0){
                        int nowlen = j - i + 1;
                        if(res.equals("") || nowlen < res.length()){
                            res = s.substring(i, j+1);
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }