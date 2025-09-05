package Advent_of_Code.dayFive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class indexPartOne {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(
                "C:\\Users\\marc.french\\Desktop\\ReLearning_JS&Java\\Advent_of_Code\\dayFive\\input.txt"));
        ArrayList<String> ruleList = new ArrayList<String>();
        ArrayList<String> arrayList = new ArrayList<String>();

        while (sc.hasNextLine()) {
            String rule = sc.nextLine();
            ruleList.add(rule);
            if (rule.equals("")) {
                ruleList.remove(rule);
                break;
            }
        }
        while (sc.hasNextLine()) {
            String array = sc.nextLine();
            arrayList.add(array);
        }

        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (String input : ruleList) {
            String[] split = input.split("\\|");
            map.computeIfAbsent(split[1], test -> new ArrayList<String>()).add(split[0]);
        }
        int total = 0;
        for (String array : arrayList) {
            String[] elements = array.split(",");
            String[] elementsClone = elements.clone();
            ArrayList<String> elementList = new ArrayList<>(Arrays.asList(elements));
            ArrayList<String> temp = new ArrayList<>(Arrays.asList(elementsClone));
            outerloop: for (int i = 0; i < elementList.size(); i++) {
                temp.remove(0);
                for (String t : temp) {
                    if (map.get(elementList.get(i)) != null && map.get(elementList.get(i)).contains(t)) {
                        // elementList = reOrder(elementList, t);
                        elementList.clear();
                        break outerloop;
                    }
                }
            }
            // elementList = checker(elementList, map);
            System.out.println(elementList);

            if (!elementList.isEmpty()) {
                int middleIndex = elementList.size() / 2;
                String middleElement = elementList.get(middleIndex);
                total += Integer.parseInt(middleElement);
            }

        }
        System.out.println(total);
        sc.close();
    }

}