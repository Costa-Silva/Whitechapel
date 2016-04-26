import package1.WhiteChapel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int numVertices = Integer.parseInt(in.readLine());

            WhiteChapel whiteChapel = new WhiteChapel(numVertices);

            for (int vertexOut=0 ; vertexOut<numVertices ; vertexOut++){
                String[] numbers = in.readLine().split("\\s");
                for(int j=0 ; j<numbers.length;j++){
                    int vertexIn = Integer.parseInt(numbers[j])-1;
                    if (vertexIn>=0){
                        whiteChapel.addEdges(vertexOut,vertexIn);
                    }
                }
            }
            int numClues = Integer.parseInt(in.readLine());
            whiteChapel.initHideout(numClues);
            for (int i=0;i<numClues;i++){
                String[] clue = in.readLine().split("\\s");
                whiteChapel.addHideoutclue(i,Integer.parseInt(clue[0])-1,Integer.parseInt(clue[1])-1);
            }
            boolean[] output = whiteChapel.problem();
            if(output==null){
                System.out.println("NO SOLUTION");
            }else{
                for(int i=0;i<output.length;i++){
                    if(output[i]) {
                        if (i == output.length-1) {
                            System.out.print(i + 1);
                        } else System.out.print((i + 1) +" ");
                    }
                }
                System.out.println("");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
