package latihan_java.Exception_Handling;

import java.util.Scanner;

class AritmeticDivision {
    private final double a;
    private final double b;
    public AritmeticDivision(double a, double b){
        this.a = a;
        this.b = b;
    }

    public String result(){
        try {
            double division = a / b;
            return String.valueOf(division);
        } catch (ArithmeticException e) {
            return "Terjadi kesalahan: tidak bisa membagi dengan nol";
        }
    }
}

class InvalidAgeException extends Exception{
    public InvalidAgeException(String pesan){
        super(pesan);
    }
}
public class Main {
    public static double checkValidationAge(double age) throws InvalidAgeException{
        if(age < 15){
                throw new InvalidAgeException("Umur harus minimal 15 tahun");
        }
        return age;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukan angka ke-1 : ");
            double angka1 = Double.parseDouble(scanner.nextLine());
            
            System.out.print("Masukan angka ke-2 : ");
            double angka2 = Double.parseDouble(scanner.nextLine());

            AritmeticDivision div = new AritmeticDivision(angka1,angka2);

            if(!div.result().contains("Terjadi kesalahan: tidak bisa membagi dengan nol")){
                double divDouble = Double.parseDouble(div.result());
                System.out.println(checkValidationAge(divDouble));
            }

        } catch (NumberFormatException e) {
            System.out.println("Bukan format angka : " + e.getMessage());
        } catch (InvalidAgeException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
