class Solution {

    public boolean dfs(int node,
            List<List<Integer>> graph,
            int[] visited,
            int[] pathVisited,
            Stack<Integer> st) {

        visited[node] = 1;
        pathVisited[node] = 1;

        for (int adjNode : graph.get(node)) {

            if (visited[adjNode] == 0) {

                if (dfs(adjNode, graph, visited, pathVisited, st)) {
                    return true;
                }

            } else if (pathVisited[adjNode] == 1) {
                return true; // cycle found
            }
        }

        pathVisited[node] = 0;

        // Add after processing all neighbors
        st.push(node);

        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {

            if (visited[i] == 0) {

                if (dfs(i, graph, visited, pathVisited, st)) {
                    return new int[0]; //cycle exist to return an empty array
                }
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        while (!st.isEmpty()) {
            ans[idx++] = st.pop();
        }

        return ans;
    }
}