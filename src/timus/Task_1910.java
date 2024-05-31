package timus;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task_1910 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));

        int Size = in.nextInt();
        in.nextLine();

        int[] WallArray = new int[Size];
        for (int i = 0; i < Size; i++) {
            WallArray[i] = in.nextInt();
        }

        int sum = WallArray[0] + WallArray[1] + WallArray[2];
        int count = 2;

        for (int i = 2; i < (Size - 1); i++) {
            int sumTemp = WallArray[i - 1] + WallArray[i] + WallArray[i + 1];
            if (sumTemp > sum) {
                sum = sumTemp;
                count = i + 1;
            }
        }

        in.close();
        out.println(sum + " " + count);
        out.flush();
        out.close();
    }
}
