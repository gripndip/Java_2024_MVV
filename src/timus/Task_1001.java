package timus;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_1001 {
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in, "ISO-8859-1");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, "ISO-8859-1"));
        ArrayList<Long> nums= new ArrayList<>();
        long p;
        try{
            while(in.hasNextLong()){
                p=in.nextLong();
                nums.add(p);
            }}
        finally{in.close();}
        for (int i = nums.size() - 1; i >= 0; i--) {
            System.out.printf("%.4f", Math.sqrt((double) nums.get(i)));System.out.println();
        }
        out.flush();
    }
}
