class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
    List<List<Integer>> reverse = new ArrayList<>();

        int V= graph.length;

        for(int i=0;i<V;i++){
            reverse.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int i=0;i<V;i++){

            for(int it:graph[i]){
                reverse.get(it).add(i);
                indegree[i]++;
                
            }
        }

        Queue<Integer>q= new LinkedList<>();
for(int i=0;i<V;i++){
if(indegree[i]==0){
    q.offer(i);
}
}
 List<Integer> safeNodes = new ArrayList<>();

 while(!q.isEmpty()){
    int node=q.peek();
    q.remove();

    safeNodes.add(node);

    for(int it:reverse.get(node)){
         indegree[it]--;
        if(indegree[it]==0){
            q.offer(it);
        }
    }
 }

  Collections.sort(safeNodes);

        return safeNodes;
        
    }
}