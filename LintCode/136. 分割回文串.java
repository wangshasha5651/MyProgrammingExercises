/**
 * 给定一个字符串s，将s分割成一些子串，使每个子串都是回文串。
 *
 * 返回s所有可能的回文串分割方案。
 *
 * 给出 s = "aab"，返回
 * [
 *   ["aa", "b"],
 *   ["a", "a", "b"]
 * ]
 */

public List<List<String>> partition(String s) {
        List<List<String>> ret = new  ArrayList<List<String>>();
        if(s == null){
            return ret;
        }
        List<String> tmp = new ArrayList<String>();
        if(s.length() == 0){
            ret.add(tmp);
            return ret;
        }
        search(s, ret, tmp, 0);
        return ret;

    }
    public void search(String s, List<List<String>> ret, List<String> tmp, int start){
        if(start == s.length()){
            List<String> p = new ArrayList<String>(tmp);
            ret.add(p);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String now = s.substring(start, i+1);
            if(isPalindrome(now)){
                tmp.add(now);
                search(s, ret, tmp, i+1);
                tmp.remove(tmp.size()-1);
            }
        }

    }
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

