class Solution {

    public boolean dfsCheck(int node,
            List<List<Integer>> graph,
            int[] visited,
            int[] pathVisited) {

        visited[node] = 1;
        pathVisited[node] = 1;

        for (int adjNode : graph.get(node)) {

            if (visited[adjNode] == 0) {

                if (dfsCheck(adjNode, graph, visited, pathVisited)) {
                    return true;
                }

            } else if (pathVisited[adjNode] == 1) {
                return true;
            }
        }

        pathVisited[node] = 0;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph: prerequisite -> course
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);
        }

        int[] visited = new int[numCourses];
        int[] pathVisited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (visited[i] == 0) {

                if (dfsCheck(i, graph, visited, pathVisited)) {
                    return false;
                }
            }
        }

        return true;
    }
}