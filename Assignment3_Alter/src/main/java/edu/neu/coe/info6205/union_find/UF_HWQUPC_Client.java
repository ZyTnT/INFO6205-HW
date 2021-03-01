package edu.neu.coe.info6205.union_find;

/*
* @Author:Yutong Zhen
* @Version:1.0.0
* @Description:
 */

import java.util.Random;
import java.util.Scanner;
import java.io.*;

public class UF_HWQUPC_Client {

    public static int[] count(final int N) {
        UF_HWQUPC uf_HWQUPC = new UF_HWQUPC(N, false);
        Random random = new Random();

        int connectionNum = 0;
        int generateNum = 0;
        int[] result = new int[2];

        while (uf_HWQUPC.components() != 1) {
            int i = random.nextInt(N);
            int j = random.nextInt(N);
            generateNum++;

            if (uf_HWQUPC.connected(i, j) == false) {
                uf_HWQUPC.connect(i, j);
                connectionNum++;
            }


        }
        result[0] = generateNum;
        result[1] = connectionNum;

        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input N:");
        int N = input.nextInt();

        int[] resultStep2 = UF_HWQUPC_Client.count(N);
        System.out.println("The site number is " + N + ", total generate number is " + resultStep2[0] + ", total connection number is " + resultStep2[1] + ".");

        //This part is output result to .txt for analysing in Python.
        File file = new File("F:\\Assignment3\\generationNum.txt");
        FileWriter out =new FileWriter(file);
        for (int i=N; i>0;i--){
            int[] resultStep3 = UF_HWQUPC_Client.count(i);
            String content = resultStep3[0] + ",";
            out.write(content);
        }
        out.close();
    }
}
