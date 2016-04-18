
/**
 * Created by paulo on 18/04/2016.
 */
import java.util.*;

public class WhiteChapel {
     List<Integer>[]vertices;
     Map<Integer,Integer> hideoutDistances;

    public WhiteChapel(int numVertices){
        vertices = new LinkedList[numVertices];
        hideoutDistances=new HashMap<>();
    }

    public void addEdges(int vertex1, int vertex2){

        if(vertices[vertex1]==null)
            vertices[vertex1]=new LinkedList<>();

        if (vertices[vertex2]==null)
            vertices[vertex2]=new LinkedList<>();

        //Adds a vertex in the list of adjecent vertices
        vertices[vertex1].add(vertex2);
    }

    public void addHideoutclue(int crimeLoc , int hideoutDistance){
        hideoutDistances.put(crimeLoc,hideoutDistance);
    }
}
