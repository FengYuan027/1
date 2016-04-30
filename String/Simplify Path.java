public class Solution {
    public String simplifyPath(String path) {
        if (path.length() == 0 || path.charAt(0) != '/') return "/";
        Stack<String> folders = new Stack<String>();
        int index = 0;
        while (index < path.length()) {
            int start = index + 1, end = start;
            while (end < path.length() && path.charAt(end) != '/') end++;
            String folder = path.substring(start, end);
            if (folder.length() != 0) {
                if (folder.equals("..")) {
                    if (!folders.isEmpty()) folders.pop();
                }
                else if (!folder.equals(".")) folders.push(folder);
            }
            index = end;
        }
        String simplified = "";
        while (!folders.isEmpty()) simplified = "/" + folders.pop() + simplified;
        if (simplified.length() == 0) return "/";
        return simplified;
    }
}
