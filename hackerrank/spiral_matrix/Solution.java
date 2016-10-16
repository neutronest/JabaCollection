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

        // Stdin Stdout ready
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int row = in.nextInt();
        int col = in.nextInt();

        int matrix[][] = new int[row][col];

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                matrix[i][j] = in.nextInt();
            }
        }

        Solver solver = new Solver();
        int spiralNums[] = new int[row * col];
        spiralNums = solver.solve(matrix, row, col);
        for (int i=0; i<spiralNums.length-1; i++) {
            out.format("%d,", spiralNums[i]);
        }
        out.format("%d", spiralNums[spiralNums.length-1]);
        out.println("\n");
        out.close();

        
    }

    static class Solver {

        

        public int[] solve(int[][] matrix, int row, int col) {

            int res[] = new int[row*col];
            int cur = 0;
            int rowOffset = row-1;
            int colOffset = col-1;
            int curRow = 0;
            int curCol = 0;
            while(rowOffset >= 0 && colOffset >= 0) {
                int[] tempRes = getCircleNum(matrix,
                                             curRow,
                                             curCol,
                                             rowOffset,
                                             colOffset);
                System.out.println(Arrays.toString(tempRes));
                for (int i=0; i<tempRes.length; i++) {
                    res[cur] = tempRes[i];
                    cur +=1;
                }
                curRow += 1;
                curCol += 1;
                rowOffset -= 2;
                colOffset -= 2;
            }
            return res;
        }
        public int[] getCircleNum(int[][] matrix,
                                  int startRow,
                                  int startCol,
                                  int rowOffset,
                                  int colOffset) {
            int res[];
            int cur = 0;
            // side condition
            /*
            if (rowOffset == 1 && colOffset == 1) {
                res = new int[1];
                res[0] = matrix[startRow][startCol];
                return res;
            }
            if (rowOffset == 0) {
                // only one row
                res = new int[colOffset+1];
                for(int i=0; i<=colOffset; i++) {
                    res[i] = matrix[startRow][startCol+i];
                }
            }
            */
            // side condition
            if (rowOffset == 0 && colOffset == 0) {
                res = new int[1];
                res[0] = matrix[startRow][startCol];
                return res;
            }
            if (rowOffset !=0 && colOffset !=0) {
                res = new int[2*rowOffset + 2*colOffset];
                // move left
                for(int i=0; i<=colOffset; i++) {
                    res[cur] = matrix[startRow][startCol+i];
                    cur += 1;
                }
                // move down
                for(int i=1; i<=rowOffset; i++) {
                    res[cur] = matrix[startRow+i][startCol+colOffset];
                    cur += 1;
                }
                // move right
                for(int i=1; i<=colOffset; i++) {
                    res[cur] = matrix[startRow+rowOffset][startCol+colOffset-i];
                    cur += 1;
                }
                // move up
                for(int i=1; i< rowOffset; i++) {
                    res[cur] = matrix[startRow+rowOffset-i][startCol];
                    cur += 1;
                }
            } else if (rowOffset == 0) {
                // only move left
                res = new int[colOffset+1];
                for(int i=0; i<=colOffset; i++) {
                    res[cur] = matrix[startRow][startCol+i];
                    cur += 1;
                }
            } else {
                // colOffset == 0
                // only move down
                res = new int[rowOffset+1];
                for(int i=0; i<=rowOffset; i++) {
                    res[cur] = matrix[startRow+i][startCol];
                    cur += 1;
                } 
            }
            return res;
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
                    tokenizer = new StringTokenizer(reader.readLine(), ",");
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
