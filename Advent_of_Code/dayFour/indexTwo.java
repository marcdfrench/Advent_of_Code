package Advent_of_Code.dayFour;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class indexTwo {
    public class Globals {
        public static int count = 0;
        public static int mas = 0;
        public static int maxLength = 140;
        public static String searchWord = "XMAS";
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Scanner File input
        Scanner sc = new Scanner(new FileReader("C:\\Users\\marc.french\\Desktop\\ReLearning_JS&Java\\Advent_of_Code\\dayFour\\input.txt"));
        ArrayList<String> matrix = new ArrayList<String>();

        while (sc.hasNextLine()) {
            String array = sc.nextLine();
            matrix.add(array);
        }
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).length(); j++) {
                if (matrix.get(i).charAt(j) == 'X') {
                    checkDirections(matrix, i, j);
                }
                else if (matrix.get(i).charAt(j) == 'A') {
                    xmasCheck(matrix, i, j);
                }
            }
        }
        sc.close();
        System.out.println(Globals.count + " XMAS Found");
        System.out.println(Globals.mas + " MAS Found");
    }

    public static boolean checkSequence(ArrayList<String> matrix, int row, int col, int drow, int dcol) {
        // for each letter in the searchWord, see if too short or not a match for the letter
        for (int letter = 0; letter < Globals.searchWord.length(); letter++) {
            int nrow = row + drow * letter; //row +- direction * char count
            int ncol = col + dcol * letter; //col +- direction * char count

            // Bounds check
            if (nrow < 0 || nrow >= Globals.maxLength || ncol < 0 || ncol >= Globals.maxLength) { return false;}
            // Match check
            if (matrix.get(nrow).charAt(ncol) != Globals.searchWord.charAt(letter)) { return false;}
        }
        return true;
    }
    public static void checkDirections(ArrayList<String> matrix, int row, int col) {
        int[][] directions = {
            {1, 0},   // down
            {-1, 0},  // up
            {0, -1},  // left
            {0, 1},   // right
            {-1, -1}, // up-left
            {-1, 1},  // up-right
            {1, -1},   // down-left
            {1, 1}   // down-right
        };

        //for each direction in directions, check if it spells the searchWord
        for (int[] dir : directions) { 
            if (checkSequence(matrix, row, col, dir[0], dir[1])) {
                System.out.println("Found " + Globals.searchWord + " at (" + row + "," + col + ")");
                Globals.count++;
            }
        }
    }
    private static boolean checkX(ArrayList<String> matrix, int row, int col, char tl, char tr, char bl, char br) {
        // Checks letters where i,j is 'A' in the middle of the X
        return  matrix.get(row - 1).charAt(col - 1)  == tl &&
                matrix.get(row - 1).charAt(col + 1)  == tr &&
                matrix.get(row + 1).charAt(col - 1)  == bl &&
                matrix.get(row + 1).charAt(col + 1)  == br;
    } 
    public static void xmasCheck(ArrayList<String> matrix, int row, int col) {
        // Bounds check
        if (row - 1 < 0 || col - 1 < 0 || row + 1 >= Globals.maxLength || col + 1 >= Globals.maxLength) {return;}

        //topleft, topright, bottomleft, bottomright
        char[][] options = {
            {'M', 'M', 'S', 'S'}, // left-down, right-down
            {'M', 'S', 'M', 'S'}, // left-down, right-up
            {'S', 'M', 'S', 'M'}, // left-up, right-down
            {'S', 'S', 'M', 'M'}  // left-up, right-up
        };

        for (char[] option : options) {
            if (checkX(matrix, row, col, option[0], option[1], option[2], option[3])) {
                System.out.println("X Found");
                Globals.mas++;
            }
        }
    }
}