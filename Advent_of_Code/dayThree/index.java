package Advent_of_Code.dayThree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class index {
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner File input
        Scanner sc = new Scanner(new FileReader(
                "C:\\Users\\marc.french\\Desktop\\ReLearning_JS&Java\\Advent_of_Code\\dayThree\\input.txt"));
        
        // String Builder reads each line and appends them together
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        String str = sb.toString();
        
        // regex
        String regex = "\\([0-9]+,[0-9]+\\)";
        Pattern pattern = Pattern.compile(regex);
        int total = 0;
        boolean toggle = true;
        
        // loop through the string
        for (int i = 0; i < str.length(); i++) {
            // Check for do()
            if (str.startsWith("do()", i)) {
                toggle = true;
            }
            // Check for don't()
            if (str.startsWith("don't()", i)) {
                toggle = false;
            }
            if (toggle == true) {
                // Check for mul
                if (str.startsWith("mul", i)) {
                    // check if format after mul matches regex
                    int endIndex = Math.min(str.length(), i + 12);
                    Matcher matcher = pattern.matcher(str.substring(i + 3, endIndex));
                    if (matcher.find()) {
                        // Get the numbers from the regex match and remove the ()
                        String found = (matcher.group().replace("(", "").replace(")", ""));
                        System.out.println(found);
                        String[] result = found.split(",");
                        int x = Integer.parseInt(result[0]);
                        int y = Integer.parseInt(result[1]);
                        int z = x * y;
                        total += z;
                    }

                }
            }
        }
        sc.close();
        System.out.println(total);
    }
}