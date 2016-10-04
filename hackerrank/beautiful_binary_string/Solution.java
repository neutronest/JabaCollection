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

        int lenOfStr = in.nextInt();
        String str = in.next();
        int res = 0;
        int cur = 0;


        while (cur < str.length()) {
            //out.println(cur);
            if (cur > lenOfStr - 3) {
                break;
            }
            if(str.substring(cur, cur+3).equals("010")) {
                if (cur > lenOfStr - 5) {
                    res += 1;
                    cur += 2;
                    continue;
                } else if(str.substring(cur, cur+5).equals("01010")) {
                    res += 1;
                    cur += 4;
                } else {
                    res += 1;
                    cur += 2;
                }
            } else {
                cur += 1;
            }
        }
        
        out.println(res);

        // end
        out.close();
    }

    static class Solver {


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
