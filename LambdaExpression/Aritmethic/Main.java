package LambdaExpression.Aritmethic;

interface Operasi {
    int hitung(int a, int b);
}
public class Main {
    public static void main(String[] args){
        Operasi tambah = (a, b) -> a + b;
        Operasi kali = (a, b) -> a * b;

        System.out.println("Tambah: " + tambah.hitung(3, 5));
        System.out.println("Kali: " + kali.hitung(3, 5));
    }
}
