import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.util.Collections;
import java.io.InputStream;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        // begin daze!
        ArrayList<ArrayList<Integer>> graphVertex = new ArrayList<ArrayList<Integer>>();
        GraphNode graphNodes[];
        // add a guard value
        GraphNode guardNode = new GraphNode(0, 0, 0, 0);
        graphVertex.add(new ArrayList<Integer>());
    
        int totalVal = 0;
        int res = Integer.MAX_VALUE;

        // input number of node
        int n = in.nextInt();
        graphNodes = new GraphNode[n+1];
        graphNodes[0] = guardNode;
        // input each node value
        for (int i=1; i<=n; i++) {
            int val = in.nextInt();
            GraphNode graphNode = new GraphNode(i, val, 0, 0);
            graphNodes[i] = graphNode;
            totalVal += val;
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            graphVertex.add(tempList);
        }
        for (int i=1; i<=n-1; i++) {
            int vi = in.nextInt();
            int vj = in.nextInt();
            graphVertex.get(vi).add(vj);
            graphVertex.get(vj).add(vi);
            //out.println(Arrays.toString(graphVertex.get(vi).toArray()));
            
        }
        Solver solver = new Solver();
        solver.dfs(1, graphNodes, graphVertex);
        for(int i=1; i<=n; i++) {
            int temp = Math.abs(totalVal - graphNodes[i].nodeAccVal - graphNodes[i].nodeAccVal);
            if (temp < res) {
                res = temp;
            }
        }        
        out.println(res);
        // end
        out.close();

    }

    static class Solver {

        void solve() {
            

        }

        int dfs(int nodeId, GraphNode[] graphNodes, ArrayList<ArrayList<Integer>> graphVertex) {

            int ret = 0;
            graphNodes[nodeId].visited = 1;
            int verLen = graphVertex.get(nodeId).size();
            //System.out.println(Arrays.toString(graphVertex.get(nodeId).toArray()));
            //System.out.format("vertex size: %d\n", verLen);
            for (int i=0; i<verLen; i++) {
                //System.out.format("vertex of node: %d\n", graphVertex.get(nodeId).get(i));
                //System.out.format("visited of vertex node: %d\n", graphNodes[graphVertex.get(nodeId).get(i)].visited);
                if (graphNodes[graphVertex.get(nodeId).get(i)].visited == 0) {
                    ret += dfs(graphVertex.get(nodeId).get(i), graphNodes, graphVertex);
                }
            }
            graphNodes[nodeId].nodeAccVal += graphNodes[nodeId].nodeVal;
            graphNodes[nodeId].nodeAccVal += ret;
            //System.out.println(graphNodes[nodeId].nodeAccVal);
            return graphNodes[nodeId].nodeAccVal;
        }
    }

    static class GraphNode {

        public int nodeId;
        public int visited;
        public int nodeVal;
        public int nodeAccVal;

        GraphNode(int nodeId_, int nodeVal_, int visited_, int nodeAccVal_) {
            this.nodeId = nodeId;
            this.visited = visited_;
            this.nodeVal = nodeVal_;
            this.nodeAccVal = nodeAccVal_;
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }




    

}
