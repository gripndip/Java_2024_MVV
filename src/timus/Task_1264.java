package timus;

import java.io.*;

public class Task_1264 {
    StreamTokenizer in;
    PrintWriter out;

    public static void main(String[] args) throws IOException {
        new Task_1264().run();
    }

    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();
        out.println(n * (m + 1));
    }

    void run() throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
}
