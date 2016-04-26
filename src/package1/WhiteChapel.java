package package1;

import java.util.*;

public class WhiteChapel {
     private List<Integer>[]graph;
     private Clue[] hideoutDistances;
     private boolean[][] intersection;

    @SuppressWarnings("unchecked")
    public WhiteChapel(int numVertices){
        graph = new List[numVertices];

    }

    public void addEdges(int vertex1, int vertex2){

        if(graph[vertex1]==null)
            graph[vertex1]=new LinkedList<>();
        //Adds a vertex in the list of adjecent vertices
        graph[vertex1].add(vertex2);
    }

    public void initHideout(int numClues){
        hideoutDistances=new Clue[numClues];
        intersection = new boolean[hideoutDistances.length][graph.length];
    }

    public void addHideoutclue(int i , int crimeLoc , int hideoutDistance){
        hideoutDistances[i] = new Clue(crimeLoc,hideoutDistance);
    }

    public boolean[] problem(){
        for(int i = 0;i<hideoutDistances.length;i++){
            if(!bfsExplore(hideoutDistances[i],i)){
                return null;
            }
        }
        return intersection[hideoutDistances.length-1];
    }

    private boolean bfsExplore( Clue root,int matrixLine) {
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> adjacentNodes = new LinkedList<>();

        boolean [] found = new boolean[graph.length];
        boolean hasIntersection = false;

        waiting.add(root.getCrimeLoc());
        found[root.getCrimeLoc()]=true;


            for (int i = 0; i <= root.getRoadClue(); i++) {


                while (!waiting.isEmpty()) {

                    for (int node : graph[waiting.remove()]) {

                        if (!found[node]) {
                            if (i == root.getRoadClue()) {
                                if (matrixLine > 0) {
                                    if (intersection[matrixLine - 1][node]) {
                                        intersection[matrixLine][node] = intersection[matrixLine - 1][node];
                                        hasIntersection=true;
                                    }

                                } else {intersection[matrixLine][node] = true;
                                    hasIntersection=true;
                                }
                            }
                            found[node] = true;
                            adjacentNodes.add(node);
                        }

                    }
                }
                waiting.addAll(adjacentNodes);
                adjacentNodes.clear();
            }
            return hasIntersection;
    }
}
