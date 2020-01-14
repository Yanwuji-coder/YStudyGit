import java.util.Scanner;

public class Main{
    /**
     * test
     * @param args
     */
    public static void main (String[]  args){
        Scanner scanner = new Scanner(System.in);
        double m = scanner.nextDouble();
        String x = scanner.next();
        double n = scanner.nextDouble();
        if (x.equals("*")){
            System.out.println(m * n);
        }else if(x.equals("/")){
            System.out.println(m / n);
        }else if(x.equals("+")){
            System.out.println(m + n);
        }else if(x.equals("-")){
            System.out.println(m - n);
        }
    }

}