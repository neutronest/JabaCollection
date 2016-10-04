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
        Solve solve = new Solve();

        int q = in.nextInt();
        for (int seri=0; seri<q; seri++) {
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> mat = new ArrayList<ArrayList<Integer>>();
            for (int i=0; i<2*n; i++) {
                ArrayList<Integer> tempRowNumbers = new ArrayList<Integer>();
                for (int j=0; j<2*n; j++) {
                    int c = in.nextInt();
                    tempRowNumbers.add(c);
                }
                mat.add(tempRowNumbers);
            }
            int maxValue = 0;
            maxValue = solve.getAccSum(mat,
                                       2*n,
                                       2*n);
            out.println(maxValue);

        }
        // end
        out.close();

    }

    static class Solve {
        public int getAccSum(ArrayList<ArrayList<Integer>> mat,
                                int row,
                                int col) {
        
            int maxVal = 0;
            for (int r=0; r<(row-1)/2+1; r++) {
                for (int c=0; c<(col-1)/2+1; c++) {
                    maxVal += getSymetryMaxValue(mat,
                                                 row,
                                                 col,
                                                 r,
                                                 c);
                }
            }
            return maxVal;
        }
        
        public int getSymetryMaxValue(ArrayList<ArrayList<Integer>> mat,
                                      int row,
                                      int col,
                                      int rowCur,
                                      int colCur) {
            
            int maxVal = 0;
            int rowHalf = (row-1)/2;
            int colHalf = (col-1)/2;

            int rowSymetry = rowCur + 2 * (rowHalf - rowCur) + 1;
            int colSymetry = colCur + 2 * (colHalf - colCur) + 1;
            List<Integer> pairNumbers = new ArrayList<Integer>();
            pairNumbers.add(mat.get(rowCur).get(colCur));
            pairNumbers.add(mat.get(rowCur).get(colSymetry));
            pairNumbers.add(mat.get(rowSymetry).get(colSymetry));
            pairNumbers.add(mat.get(rowSymetry).get(colCur));
            maxVal = Collections.max(pairNumbers);
            return maxVal;
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
