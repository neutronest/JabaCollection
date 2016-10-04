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

        int t = in.nextInt();
        int epoch = 0;
        Solver S = new Solver();
        while(epoch < t) {

            int lenOfArr = in.nextInt();
            int[] arr = new int[lenOfArr];
            for (int i=0; i<lenOfArr; i++) {
                int c = in.nextInt();
                arr[i] = c;
            }
            String res = S.solve(arr, lenOfArr);
            // end of this epoch
            out.println(res);
            epoch += 1;
        }

        // end
        out.close();
    }

    static class Solver {

        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        String solve(int[] arr,
                   int lenOfArr) {

            int left = 0;
            int right = lenOfArr - 1;
            String res = binarySearch(arr,
                                      lenOfArr,
                                      left,
                                      right,
                                      -1,
                                      0,
                                      0);
            return res;
        }

        String binarySearch(int[] arr,
                            int lenOfArr,
                            int left,
                            int right,
                            int oldMiddle,
                            int oldLeftSum,
                            int oldRightSum) {

            int newLeftSum = 0;
            int newRightSum = 0;
            int newLeft = 0;
            int newRight = 0;
            int newOldMiddle = 0;
            int newMiddle = 0;
            int partSum = 0;
            //out.print(left);
            //out.print("");
            //out.println(right);

            // side condition
            if (lenOfArr == 1) {
                return "YES";
            }
            if (lenOfArr == 2) {
                return "NO";
            }


            if (left >= right) {
                return "NO";
            }

            if (oldMiddle == -1) {
                newMiddle = (left + right) / 2;
                // init case
                // oldLeftSum = oldRightSum = 0
                for (int i=0; i<newMiddle; i++) {
                    newLeftSum += arr[i];
                }
                for (int i=newMiddle+1; i<lenOfArr; i++) {
                    newRightSum += arr[i];
                }
            } // end if
            else {
                //
                if (right == oldMiddle) {
                    // move left from last step
                    // newMiddle < OldMiddle

                    newMiddle = (left + right) / 2;
                    partSum = 0;
                    for (int i=newMiddle+1; i<oldMiddle; i++) {
                        partSum += arr[i];
                    }
                    newLeftSum = oldLeftSum - partSum - arr[newMiddle];
                    newRightSum = oldRightSum + partSum + arr[oldMiddle];
                } else {
                    // left == oldMiddle is True
                    // move right from last step
                    // newMiddle > OldMiddle
                    newMiddle = (left + right) / 2;
                    partSum = 0;
                    for (int i=oldMiddle+1; i<newMiddle; i++) {
                        partSum += arr[i];
                    }

                    newLeftSum = oldLeftSum + partSum + arr[oldMiddle];
                    newRightSum = oldRightSum - partSum - arr[newMiddle];
                } // end else
            } // end else

            if (newLeftSum == newRightSum) {
                    return "YES";
            } // end if
            else if (newLeftSum > newRightSum) {
                // 
                newLeft = left;
                newRight = (left + right) / 2;
                newOldMiddle = newRight;
                return binarySearch(arr,
                                    lenOfArr,
                                    newLeft,
                                    newRight,
                                    newOldMiddle,
                                    newLeftSum,
                                    newRightSum);
            } // endf else if
            else {
                newLeft = (left + right) / 2;
                newRight = right;
                newOldMiddle = newLeft;
                return binarySearch(arr,
                                    lenOfArr,
                                    newLeft,
                                    newRight,
                                    newOldMiddle,
                                    newLeftSum,
                                    newRightSum);
            } // end else
        } // end binarySearch
    } // end class Solver

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
