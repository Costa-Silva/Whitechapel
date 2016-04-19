
/**
 * Created by paulo on 18/04/2016.
 */
import java.util.*;

public class WhiteChapel {
     List<Integer>[]graph;
     Clue[] hideoutDistances;

    public WhiteChapel(int numVertices){
        graph = new LinkedList[numVertices];
    }

    public void addEdges(int vertex1, int vertex2){

        if(graph[vertex1]==null)
            graph[vertex1]=new LinkedList<>();
        //Adds a vertex in the list of adjecent vertices
        graph[vertex1].add(vertex2);
    }

    public void initHideout(int numClues){
        hideoutDistances=new Clue[numClues];
    }

    public void addHideoutclue(int i , int crimeLoc , int hideoutDistance){
        hideoutDistances[i] = new Clue(crimeLoc,hideoutDistance);
    }

    public List problem(){

        boolean [] found = new boolean[graph.length];
        boolean [][] intersection = new boolean[hideoutDistances.length][graph.length];
        List<Integer> list=new LinkedList<>();
        for(int i = 0;i<hideoutDistances.length;i++){
            if((bfsExplore(found,intersection,hideoutDistances[i],i).size()==0)){
                return null;
            }
        }

        return list;
    }

    private List<Integer> bfsExplore(boolean[] found, boolean[][] intersection, Clue root,int matrixLine) {
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Integer> adjacentNodes = new LinkedList<>();
        List<Integer> list=new LinkedList<>();
        waiting.add(root.getCrimeLoc());
        found[root.getCrimeLoc()]=true;


            for (int i = 0; i < root.getRoadClue(); i++) {


                while (!waiting.isEmpty()) {

                    for (int node : graph[waiting.remove()]) {

                        if (!found[node]) {
                            if (i == root.getRoadClue() - 1) {
                                if (matrixLine > 0) {
                                    if (intersection[matrixLine - 1][node]) {
                                        intersection[matrixLine][node] = intersection[matrixLine - 1][node];
                                        list.add(node);
                                    }

                                } else intersection[matrixLine][node] = true;

                            }
                            found[node] = true;
                            adjacentNodes.add(node);
                        }

                    }
                }
                waiting.addAll(adjacentNodes);
                adjacentNodes.clear();
            }
            return list;
             /*
             do{roads++;
                int numberOfAdj = graph[node].size();
                for(Integer vertex : graph[node]){
                    if(!found[vertex]){

                        if(roads==root.getRoadClue()){
                            if(matrixLine>0){
                                if(!intersection[matrixLine-1][vertex]){
                                    numberOfAdj--;

                                    if (numberOfAdj==0) return null;
                                }
                                else {
                                    intersection[matrixLine][vertex]=intersection[matrixLine-1][vertex];
                                    list.add(vertex);
                                }
                            }else intersection[matrixLine][vertex]=true;

                            stop=true;
                        }

                        waiting.add(vertex);
                        found[vertex]=true;
                    }
                }

        }while(!waiting.isEmpty() && !stop);
        return list;
    */
    }
}
