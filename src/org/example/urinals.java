package org.example;
import java.io.IOException;
import java.io.FileReader;
import java.io.*;

public class urinals {

    //author - Alpuri Akhil Sai (Asurite ID - aalpuri)

    public static void main(String[] args) throws IOException {

        urinals obj = new urinals();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("How would you like to give your input? 1.Keyboard 2. Dat file input");
        int input123 = Integer.parseInt(br.readLine());
        String inp234 = "";
        if (input123 == 1) {
            System.out.println("Give your input");
            inp234 = br.readLine();

        } else if (input123 == 2) {
            try {
                obj.openFile("src/org.example/urinals.dat");
            } catch (Exception e) {
                System.out.println("Unable to open file");
                e.printStackTrace();
            }

        }
        int urinalCount = obj.countUrinals(inp234);
        if (urinalCount == -1)
            System.out.println("Invalid string");
        else
            System.out.println(urinalCount);
    }

    boolean getString(String input123) {
        String[] inp234 = input123.split("");
        boolean validCheck123 = true;
        int l = inp234.length;
        for (int k = 0; k < l - 1; k++) {
            String s123 = String.valueOf(inp234[k]);
            int x = Integer.parseInt(s123);
            String s234 = String.valueOf(inp234[k + 1]);
            int y = Integer.parseInt(s234);
            if (x == 1 && y == 1) {
                validCheck123 = false;
                break;
            }
        }
        return validCheck123;
    }

    public int countUrinals(String input123) {
        int inpLength = input123.length();
        urinals u = new urinals();
        if (inpLength > 20 || inpLength < 0 || input123 == null) {
            return -1;
        }
        boolean validCheck123 = u.getString(input123);
        if (validCheck123 == false)
            return -1;
        else if (input123.contains("11")) {
            return -1;
        }
        else if (inpLength == 1) {
            String z = "";
            if (input123.contains("0")) {
                return 1;
            } else if (input123.contains("1")) {
                return 0;
            }
        }
        char[] urinal = input123.toCharArray();
        int x = 0;
        if (urinal[0] == '0' && urinal[1] == '0') {
            urinal[0] = '1';
            x++;
        }
        for (int k = 1; k < inpLength - 1; k++) {
            if (urinal[k] == '0' && urinal[k - 1] == '0' && urinal[k + 1] == '0') {
                urinal[k] = 1;
                x++;
            }
        }
        if (urinal[inpLength - 1] == '0' && urinal[inpLength - 2] == '0') {
            x++;
        }
        return x;
    }


    public int openFile(String filepath) throws IOException {

        urinals obj = new urinals();
        File file = new File(filepath);

        if (file == null) {
            throw new IOException();
        }
        String x;
        BufferedReader sc = new BufferedReader(new FileReader(file));
        while ((x = sc.readLine()) != null) {
            System.out.println(x);
            if (x.equals("-1")) {
                break;
            }
            int urinalsLeft = obj.countUrinals(x);
            System.out.println(urinalsLeft);
        }
        return 1;


    }
}