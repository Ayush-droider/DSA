class Solution {
    //n emp hai sbki unique id jisme head ki headId given hai
    //har employee ka manager hai per head ka koi manager nahi
    //level by level info jayegi har level per jaane ke liye info[i] time lagega
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> children=new ArrayList<>();
        for(int i=0;i<n;i++){
            children.add(new ArrayList<>());
        }
        //samasya hai adjacency list kaise banau
        //dhyaan se dekh manager[i] ith employe ka manager hai
        for(int i=0;i<n;i++){
            //example 2 dekh agar is case ko hata dun to 2<-->2 link ho jaayenge
            if(manager[i]!=-1){
                children.get(manager[i]).add(i);
            }
        }
        //simple dfs ya bfs maarde
        //headId source hai
        return dfs(headID,children,informTime);
    }
    private int dfs(int employee,List<List<Integer>> children,int[] informTime){
        int time=0;
        for(int child:children.get(employee)){
            time=Math.max(time,dfs(child,children,informTime));
        }
        return informTime[employee]+time;
    }
}