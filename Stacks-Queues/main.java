//Driver class for Equation solver
import java.util.*;
import java.io.*;
public class main
{
    public static void main(String[] args)
    {
        double result;
        EquationSolver basicArithmetic = new EquationSolver();
        //String equation = "( 10.3 * ( 14 + 3.2 ) ) / ( 5 + 2 - 4 * 3 )";
        //String equation = "1 + 1 + 1 + 1 + 1";
        //String equation = "-1 - ( - 5 )";
        System.out.print("Enter Simple equation: ");
        String equation = input();
        result = basicArithmetic.solve(equation);
    }

    public static String input()
    {
        Scanner sc = new Scanner(System.in);
        String equation = sc.nextLine();
        return equation;
    }
}
