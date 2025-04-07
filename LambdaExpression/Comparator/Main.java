package LambdaExpression.Comparator;
import java.util.*;

class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //getter
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }
}

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Edwin",38));
        people.add(new Person("Alice", 29));
        people.add(new Person("Bob", 32));
        people.add(new Person("Charle", 34));

        //Sort berdasarkan umur
        // people.sort(new Comparator<Person>() {
        //     @Override
        //     public int compare(Person p1, Person p2){
        //         return Integer.compare(p1.getAge(), p2.getAge());
        //     }
        // });

        // Atau pakai lambda (Java 8+)
        // Sort berdasarkan ascending
        people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Sort berdasarkan nama (Alphabetical)
        // people.sort(p1 ,p2) -> p1.getName().compareTo(p2.getName());

        // Sort by umur lalu kriteria
        // people.sort((p1, p2) -> {
        //     int result = Integer.compare(p1.getAge(), p2.getAge());
        //     if(result == 0){
        //         return p1.getName().compareTo(p2.getName());
        //     }
        //     return result;
        // });

        // Comparator.comparing() (lebih clean & Modern)
        // Sort by name
        // people.sort(Comparator.comparing(Person::getName));
        // Sort by age descending
        // people.sort(Comparator.comparing(Person::getAge).reserved());

        // cetak hasil  
        for(Person p : people){
            System.out.println(p.getName() + " - " + p.getAge());
        }
    }
}

