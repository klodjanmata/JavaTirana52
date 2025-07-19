package JavaAdvCoding.Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Create a method that takes a string list as a parameter,
// then returns the list sorted alphabetically from Z to A.
public class ExerciseOne {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");
        fruits.add("Watermelon");
        fruits.add("pear");
        fruits.add("Grape");
        fruits.add("avocado");
        fruits.add("Mango");
        List<String> ordersList = reverseOrderListCaseInsensitive(fruits);

        ordersList.forEach(System.out::println);

//        for (String s : ordersList) {
//            System.out.println(s);
//        }
    }

    public static List<String> reverseOrderList(List<String> list){
        return list.stream().sorted(Comparator.reverseOrder()).toList();
    }

    public static List<String> reverseOrderListCaseInsensitive(List<String> list){
        List<String> upperCaseList = new ArrayList<>();
        for(String s : list){
            upperCaseList.add(s.toUpperCase());
        }
        upperCaseList = reverseOrderList(upperCaseList);
        List<String> resultList = new ArrayList<>();
        for(String s : upperCaseList){
            resultList.add(
                    list.stream()
                    .filter(l -> l.equalsIgnoreCase(s)).findFirst().get()
            );
        }
        return resultList;
    }

}
