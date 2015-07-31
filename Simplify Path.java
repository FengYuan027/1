public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        if (path == null || path.length() == 0) {
            return "/";
        }
        Stack<String> parents = new Stack<String>();
        for (int i = 0; i < path.length(); i++) {
            int start = i;
            while (start < path.length() && path.charAt(start) == '/') {
                start++;
            }
            int end = start;
            while (end < path.length() && path.charAt(end) != '/') {
                end++;
            }
            String p = path.substring(start, end);
            if (p.equals("..")){
                if(!parents.empty()) {
                    parents.pop();
                }
            }
            else if (!p.equals("") && !p.equals(".")) {
                parents.push(p);
            }
            i = end - 1;
        }
        if (parents.empty()) return "/";
        String simplified = "";
        while (!parents.empty()) {
            String parent = parents.pop();
            simplified = "/" + parent + simplified; 
        }
        return simplified;
    }
}
