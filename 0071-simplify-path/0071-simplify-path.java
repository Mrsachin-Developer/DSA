class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (int i = 0; i < parts.length; i++) {

            if (parts[i].equals("") || parts[i].equals(".")) {
                continue;
            }

            else if (parts[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }

            else {
                stack.push(parts[i]);
            }
        }

        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}