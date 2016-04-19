
/**
 * Created by paulo on 18/04/2016.
 */
import java.util.*;

public class WhiteChapel {
     List<Integer>[]graph;
     int[] hideoutDistances;

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
        hideoutDistances=new int[numClues];
    }

    public void addHideoutclue(int crimeLoc , int hideoutDistance){
        hideoutDistances[crimeLoc] = hideoutDistance;
    }

    public int[] problem(){

        boolean [] found = new boolean[graph.length];
        boolean [] intersection = new boolean[graph.length];

        for(int i = 0;i<hideoutDistances.length;i++){
            if(!found[i]){
                bfsExplore(found,intersection,i);
            }
        }

        return null;
    }

    private void bfsExplore(boolean[] found, boolean[] intersection, int root) {
        Queue<Integer> waiting = new LinkedList<>();
        int roads = 0;
        waiting.add(root);
        found[root]=true;

        do{
                int node = waiting.remove();
                roads++;
                for(Integer vertex : graph[node]){
                    if(!found[vertex]){

                        if(roads==hideoutDistances[root]){

                        }

                        waiting.add(vertex);
                        found[vertex]=true;

                    }
                }
        }while(!waiting.isEmpty());

    }
}
