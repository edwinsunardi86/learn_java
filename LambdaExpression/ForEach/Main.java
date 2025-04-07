package LambdaExpression.ForEach;
import java.util.*;
public class Main {
    public static void main(String[] args){
        List<String> buah = Arrays.asList("Jeruk", "Apel", "Anggur", "Manggis");
        buah.forEach(b -> System.out.println("Buah: " + b));
    }
}
