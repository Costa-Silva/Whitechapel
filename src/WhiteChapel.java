
/**
 * Created by paulo on 18/04/2016.
 */
import java.util.Set;
import java.util.TreeSet;

public class WhiteChapel {
    private Set<Integer>[]vertices;
    private long[] hideoutDistances;

    public WhiteChapel(int numVertices){
        vertices = new TreeSet[numVertices];

    }

    public void addEdges(int vertex1, int vertex2){

        if(vertices[vertex1]==null)
            vertices[vertex1]=new TreeSet<>();

        if (vertices[vertex2]==null)
            vertices[vertex2]=new TreeSet<>();

        //Adds a vertex in the list of adjecent vertices
        vertices[vertex1].add(vertex2);
        vertices[vertex2].add(vertex1);
    }

    public void initHideout(int numDistancecClue){
        hideoutDistances=new long[numDistancecClue];
    }

    public void addHideoutclue(int crimeLoc , long hideoutDistance){
        hideoutDistances[crimeLoc] = hideoutDistance;
    }
}
