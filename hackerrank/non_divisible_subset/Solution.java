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
import java.io.InputStream;
import java.util.*;
import java.math.*;

public class Solution {


    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);


        // input
        int n = in.nextInt();
        int k = in.nextInt();
        int[] modK = new int[k];
        int lenRes = 0;

        for (int i=0; i<k; i++) {
            modK[i] = 0;
        }
        for (int i=0; i<n; i++) {
            int v = in.nextInt();
            modK[v%k] += 1;
        }
        for (int i=0; i<(k/2)+1; i++) {
            if (i==0) {
                lenRes += Math.min(1, modK[i]);
            } else {
                int ki = i;
                int kj = k-i;
                if (ki == kj) {
                    // side condition
                    lenRes += Math.min(1, modK[ki]);
                } else {
                    lenRes += Math.max(modK[ki], modK[kj]);
                }
            }
        }

        out.println(lenRes);
        out.close();
        //
    } // end maine

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
