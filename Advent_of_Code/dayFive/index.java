package Advent_of_Code.dayFive;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class index {
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
                        elementList = reOrder(elementList, t);
                        break outerloop;
                    }
                }
            }
            elementList = checker(elementList, map);
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

    public static class UniqueArray {
        public UUID id;
        public ArrayList<String> array;

        public UniqueArray(UUID id, ArrayList<String> array) {
            this.id = id;
            this.array = array;
        }
    }

    public static UniqueArray createUniqueArrayWithID(ArrayList<String> elementList) {
        UUID uniqueId = UUID.randomUUID();
        ArrayList<String> newTemp = new ArrayList<>(elementList);
        return new UniqueArray(uniqueId, newTemp);
    }

    public static ArrayList<String> reOrder(ArrayList<String> elementList, String t) {
        int index = elementList.indexOf(t);
        elementList.remove(index);
        elementList.add(0, t);
        return elementList;
    }

    public static ArrayList<String> checker(ArrayList<String> elementList, HashMap<String, ArrayList<String>> map) {
        boolean repeat = true;
        while (repeat) {
            UniqueArray uniqueArray = createUniqueArrayWithID(elementList);
            ArrayList<String> newTemp = new ArrayList<>(uniqueArray.array);
            repeat = false;
            outerlooptwo: for (int i = 0; i < elementList.size(); i++) {
                newTemp.remove(0);
                for (String t : newTemp) {
                    if (map.get(elementList.get(i)) != null && map.get(elementList.get(i)).contains(t)) {
                        elementList = reOrder(elementList, t);
                        repeat = true;
                        break outerlooptwo;
                    }
                }
            }
        }
        return elementList;
    }
}
