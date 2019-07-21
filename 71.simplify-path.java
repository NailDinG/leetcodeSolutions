import java.util.Stack;

/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */
class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.equals("") || path.equals("/")) {
            return "/";
        }
        Stack<String> stack = new Stack<>();
        String[] routes = path.split("/");

        for(String route: routes) {
            if(route.equals(".") || route.equals("")) {
                continue;
            }
            if (route.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push("/" + route);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        if (res.equals("")) {
            res = "/";
        }
        return res;
    }
}

