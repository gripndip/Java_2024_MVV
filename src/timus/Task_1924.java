package timus;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task_1924 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));

        int a = in.nextInt();
        in.nextLine();
        in.close();

        int sum = (a * (a + 1)) / 2;

        String res = (sum % 2 == 0) ? "black" : "grimy";

        out.println(res);
        out.flush();
        out.close();
    }
}
