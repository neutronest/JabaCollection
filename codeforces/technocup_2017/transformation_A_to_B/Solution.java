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

        int a = in.nextInt();
        int b = in.nextInt();

        boolean ifPossible = false;
        List<Integer> traSeq = new ArrayList<Integer>();
        int t = b;
        traSeq.add(t);
        while (t > a) {
            if ( t %10 == 1) {
                t = (t-1) / 10;
                traSeq.add(t);
            }
            else if (t % 2 == 0) {
                t =  t/2;
                traSeq.add(t);
            }
            else {
                break;
            }
        }
        if (t == a) {
            out.println("YES");
            int lenOfSeq = traSeq.size();
            out.println(lenOfSeq);
            for (int i=lenOfSeq-1; i>=1; i--) {
                out.format("%d ", traSeq.get(i));
            }
            out.println(traSeq.get(0));
        }
        else {
            out.println("NO");
        }



        // end
        out.close();

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
