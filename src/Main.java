import Entities.Human;
import JsonWorker.JsonWorker;
import java.util.stream.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        var humans = JsonWorker.readPeople("C:\\Users\\Kokor\\IdeaProjects\\JavaPracticeTask4\\src\\peoplejson.json");
        printHumans(humans);
        System.out.println();
        demoMap(humans);
        System.out.println();
        demoFilter(humans);
        System.out.println();
        demoForEach(humans);
        System.out.println();
        demoSorted(humans);
    }

    public static void  printHumans(ArrayList<Human> humans){
        for (var human :humans) {
            System.out.println(human._name);
            System.out.println(human._surname);
            System.out.println(human._sex);
            System.out.println(human._age);
        }
    }


    public static void demoMap(ArrayList<Human> humans){
        var col = humans.stream()
                .map(human -> {
                    human._age *= 2;
                    return human;
                })
                .collect(Collectors.toCollection(ArrayList::new));
        printHumans(col);
    }

    public static void demoFilter(ArrayList<Human> humans){
        var col = humans.stream()
                .filter(human -> human._sex.equals("male"))
                .collect(Collectors.toCollection(ArrayList::new));
        printHumans(col);
    }

    public static void demoForEach(ArrayList<Human> humans){
        humans.forEach(human-> System.out.println(human._surname));
    }

    public static void demoSorted(ArrayList<Human> humans){
        var col = humans.stream()
                .sorted((Human a,Human b) -> a._age > b._age ? 1 :-1)
                .collect(Collectors.toCollection(ArrayList::new));
        printHumans(col);
    }
}