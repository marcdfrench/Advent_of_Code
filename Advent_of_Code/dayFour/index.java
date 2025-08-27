package Advent_of_Code.dayFour;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class index {
    public class Globals {
        public static boolean top = true;
        public static boolean bottom = true;
        public static boolean left = true;
        public static boolean right = true;
        public static boolean xCheck = true;
        public static int count = 0;
        public static int mas = 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner File input
        Scanner sc = new Scanner(new FileReader(
                "C:\\Users\\marc.french\\Desktop\\ReLearning_JS&Java\\Advent_of_Code\\dayFour\\input.txt"));
        ArrayList<String> matrix = new ArrayList<String>();

        while (sc.hasNextLine()) {
            String array = sc.nextLine();
            matrix.add(array);
        }
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).length(); j++) {
                downCheck(i, matrix, j);
                upCheck(i, matrix, j);
                backCheck(i, matrix, j);
                forwardsCheck(i, matrix, j);
                downLeftDiagonalCheck(i, matrix, j);
                downRightDiagonalCheck(i, matrix, j);
                upLeftDiagonalCheck(i, matrix, j);
                upRightDiagonalCheck(i, matrix, j);
                xmasCheck(i, matrix, j);
            }
        }
        sc.close();
        System.out.println(Globals.count + " XMAS Found");
        System.out.println(Globals.mas + " MAS Found");
    }

    public static void downCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (bottomCheck(i)) {
                Globals.bottom = false;
            }
            if (Globals.bottom == true &&
                    matrix.get(i + 1).charAt(j) == 'M' &&
                    matrix.get(i + 2).charAt(j) == 'A' &&
                    matrix.get(i + 3).charAt(j) == 'S') {
                System.out.println("Down XMAS Found");
                Globals.count++;
            }
        }
        Globals.bottom = true;
    }

    static public boolean bottomCheck(int i) {
        if (i + 3 >= 140) {
            return true;
        } else {
            return false;
        }
    }

    public static void upCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (topCheck(i)) {
                Globals.top = false;
            }
            if (Globals.top == true &&
                    matrix.get(i - 1).charAt(j) == 'M' &&
                    matrix.get(i - 2).charAt(j) == 'A' &&
                    matrix.get(i - 3).charAt(j) == 'S') {
                System.out.println("Up XMAS Found");
                Globals.count++;
            }
        }
        Globals.top = true;
    }

    static public boolean topCheck(int i) {
        if (i - 3 < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void backCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (leftCheck(j)) {
                Globals.left = false;
            }
            if (Globals.left == true &&
                    matrix.get(i).charAt(j - 1) == 'M' &&
                    matrix.get(i).charAt(j - 2) == 'A' &&
                    matrix.get(i).charAt(j - 3) == 'S') {
                System.out.println("Left XMAS Found");
                Globals.count++;
            }
        }
        Globals.left = true;
    }

    static public boolean leftCheck(int j) {
        if (j - 3 < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void forwardsCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (rightCheck(j)) {
                Globals.right = false;
            }
            if (Globals.right == true &&
                    matrix.get(i).charAt(j + 1) == 'M' &&
                    matrix.get(i).charAt(j + 2) == 'A' &&
                    matrix.get(i).charAt(j + 3) == 'S') {
                System.out.println("Right XMAS Found");
                Globals.count++;
            }
        }
        Globals.right = true;
    }

    static public boolean rightCheck(int j) {
        if (j + 3 >= 140) {
            return true;
        } else {
            return false;
        }
    }

    public static void upLeftDiagonalCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (topLeftCheck(i, j)) {
                Globals.top = false;
            }
            if (Globals.top == true &&
                    matrix.get(i - 1).charAt(j - 1) == 'M' &&
                    matrix.get(i - 2).charAt(j - 2) == 'A' &&
                    matrix.get(i - 3).charAt(j - 3) == 'S') {
                System.out.println("Up Left XMAS Found");
                Globals.count++;
            }
        }
        Globals.top = true;
    }

    static public boolean topLeftCheck(int i, int j) {
        if (i - 3 < 0 || j - 3 < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void upRightDiagonalCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (topRightCheck(i, j)) {
                Globals.top = false;
            }
            if (Globals.top == true &&
                    matrix.get(i - 1).charAt(j + 1) == 'M' &&
                    matrix.get(i - 2).charAt(j + 2) == 'A' &&
                    matrix.get(i - 3).charAt(j + 3) == 'S') {
                System.out.println("Up Right XMAS Found");
                Globals.count++;
            }
        }
        Globals.top = true;
    }

    static public boolean topRightCheck(int i, int j) {
        if (i - 3 < 0 || j + 3 >= 140) {
            return true;
        } else {
            return false;
        }
    }

    public static void downLeftDiagonalCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (bottomLeftCheck(i, j)) {
                Globals.bottom = false;
            }
            if (Globals.bottom == true &&
                    matrix.get(i + 1).charAt(j - 1) == 'M' &&
                    matrix.get(i + 2).charAt(j - 2) == 'A' &&
                    matrix.get(i + 3).charAt(j - 3) == 'S') {
                System.out.println("Down Left XMAS Found");
                Globals.count++;
            }
        }
        Globals.bottom = true;
    }

    static public boolean bottomLeftCheck(int i, int j) {
        if (i + 3 >= 140 || j - 3 < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void downRightDiagonalCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'X') {
            if (bottomRightCheck(i, j)) {
                Globals.bottom = false;
            }
            if (Globals.bottom == true &&
                    matrix.get(i + 1).charAt(j + 1) == 'M' &&
                    matrix.get(i + 2).charAt(j + 2) == 'A' &&
                    matrix.get(i + 3).charAt(j + 3) == 'S') {
                System.out.println("Down Right XMAS Found");
                Globals.count++;
            }
        }
        Globals.bottom = true;
    }

    static public boolean bottomRightCheck(int i, int j) {
        if (i + 3 >= 140 || j + 3 >= 140) {
            return true;
        } else {
            return false;
        }
    }

    public static void xmasCheck(int i, ArrayList<String> matrix, int j) {
        if (matrix.get(i).charAt(j) == 'A') {
            if (xCheck(i, j)) {
                Globals.xCheck = false;
            }
            if (Globals.xCheck == true &&
                    matrix.get(i - 1).charAt(j - 1) == 'M' &&
                    matrix.get(i + 1).charAt(j + 1) == 'S' &&
                    matrix.get(i - 1).charAt(j + 1) == 'M' &&
                    matrix.get(i + 1).charAt(j - 1) == 'S') {  
                        System.out.println("MAS Found");
                        Globals.mas++;           
            }
            if (Globals.xCheck == true &&
                    matrix.get(i - 1).charAt(j - 1) == 'S' &&
                    matrix.get(i + 1).charAt(j + 1) == 'M' &&
                    matrix.get(i + 1).charAt(j - 1) == 'S' &&
                    matrix.get(i - 1).charAt(j + 1) == 'M') {  
                        System.out.println("MAS Found");
                        Globals.mas++;           
            }
            if (Globals.xCheck == true &&
                    matrix.get(i - 1).charAt(j - 1) == 'M' &&
                    matrix.get(i + 1).charAt(j + 1) == 'S' &&
                    matrix.get(i - 1).charAt(j + 1) == 'S' &&
                    matrix.get(i + 1).charAt(j - 1) == 'M') {  
                        System.out.println("MAS Found");
                        Globals.mas++;           
            }
            if (Globals.xCheck == true &&
                    matrix.get(i - 1).charAt(j - 1) == 'S' &&
                    matrix.get(i + 1).charAt(j + 1) == 'M' &&
                    matrix.get(i + 1).charAt(j - 1) == 'M' &&
                    matrix.get(i - 1).charAt(j + 1) == 'S') {  
                        System.out.println("MAS Found");
                        Globals.mas++;           
            }
        }
        Globals.xCheck = true;
    }
    static public boolean xCheck(int i, int j) {
        if (i - 1 < 0 || j - 1 < 0 || i + 1 >= 140 || j + 1 >= 140) {
            return true;
        } else {
            return false;
        }
    }

}