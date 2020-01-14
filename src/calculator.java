import java.util.Scanner;

public class calculator {
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        String n = scanner.next();
        double b = scanner.nextDouble();
        if (n.equals("+")){
            System.out.print(a + b);
        }else if (n.equals("-")){
            System.out.print(a - b);
        }else if (n.equals("*")){
            System.out.print(a * b);
        }else if (n.equals("/")){
            System.out.print(a / b);
        }
    }
}
