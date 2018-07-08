import java.util.*;
class Solution {
    private static String[] arr  = new String[] {"","","abc","def",
            "ghi","jkl","mno","pqrs","tuv","wxyz"};
    private static StringBuffer sb = new StringBuffer();

    public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits.length() == 0) {
            return ret;
        }


        // 深度遍历
        traverse(digits , 0 , ret);
        return ret;
    }

    private static void traverse(String digits, int n, List<String> ret){
        if(n == digits.length()){
            ret.add(sb.toString());
            return;
        }
        for (int i = 0; i < arr[digits.charAt(n)-'0'].length(); i++) {
            sb.append(arr[digits.charAt(n)-'0'].charAt(i));
            traverse(digits, n + 1, ret);
            sb.deleteCharAt(sb.length()-1);  //回溯，删去刚刚加进去的那个字符
        }
    }
}