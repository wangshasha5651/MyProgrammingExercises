/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */
 public String simplifyPath(String path) {
        if(path.length() == 0 || path == null){
            return path;
        }
        String[] str = path.split("/");
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < str.length; i++) {
            if(str[i].equals(".") || str[i].equals("")){
                continue;
            }else if(!str[i].equals("..")){
                stack.push(str[i]);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<String> tmp = new Stack<String>();
        while(!stack.isEmpty()){
            tmp.push(stack.pop());
        }
        while(!tmp.isEmpty()){
            sb.append("/");
            sb.append(tmp.pop());
        }
        if(sb.length() == 0){
            sb.append("/");
        }
        return sb.toString();
    }