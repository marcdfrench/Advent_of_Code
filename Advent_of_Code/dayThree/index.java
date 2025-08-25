package Advent_of_Code.dayThree;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class index {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(
                "C:\\Users\\marc.french\\Desktop\\ReLearning_JS&Java\\Advent_of_Code\\dayThree\\input.txt"));
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextLine()) {
            sb.append(sc.nextLine());
        }
        String str = sb.toString();
        String regex = "\\([0-9]+,[0-9]+\\)";
        Pattern pattern = Pattern.compile(regex);
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'm' && str.charAt(i + 1) == 'u' && str.charAt(i + 2) == 'l') {
                Matcher matcher = pattern.matcher(str.substring(i + 3, i + 12));
                if (matcher.find()) {
                    String found = (matcher.group().replace("(", "").replace(")", ""));
                    String[] result = found.split(",");
                    int x = Integer.parseInt(result[0]);
                    int y = Integer.parseInt(result[1]);
                    int z = x * y;
                    total += z;
                }
            } 
        }
        sc.close();
        System.out.println(total);
    }

}