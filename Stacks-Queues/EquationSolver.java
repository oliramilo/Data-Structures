import java.util.*;
import java.io.*;
public class EquationSolver
{
    public EquationSolver() {}

    //Wrapper method for solving equation
    public double solve(String equation)
    {
        double ans = 0;
        DSAQueue postfix = parseInfixToPostfix(equation);
        ans = evalPostfix(postfix);
        return ans;
    }

    //Evaluates the postfix queue
    private double evalPostfix(DSAQueue postfix)
    {
        DSAStack postEval = new Stack(postfix.getCount());
        char opType='n';
        double op1=0,op2=0;
        double ans = 0;
        double finalAns = 0.0;
        //Loop until everything in the postfix queue is flushed out
        while(!postfix.isEmpty())
        {
            //Take the dequeueing element in postfix out
            String element = String.valueOf(postfix.deQueue());

            //Check is the element is an operator
            if(isOperator(element) && !postEval.isEmpty())
            {
                try
                {
                    opType = element.charAt(0);
                    op1 = Double.valueOf(String.valueOf(postEval.pop()));
                    op2 = Double.valueOf(String.valueOf(postEval.pop()));
                    ans = execOp(opType, op1,op2);
                    postEval.push(ans);
                }
                catch(StackEmptyException e)
                {
                    System.out.println("Invalid Operation for " + element);
                }
            }

            else if(!element.equals("-") || !element.equals("+") ||
                            !element.equals("/") || !element.equals("*"))
            {
                try
                {
                    double toStack = Double.valueOf(element);
                    postEval.push(toStack);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("No such value for " + element);
                }
            }
        }
        if(!postEval.isEmpty())
        {
             finalAns = Double.valueOf(String.valueOf(postEval.pop()));
        }
        return finalAns;
    }

    private double execOp(char opType, double op1,double op2)
    {
        double execAns = 0;
        switch(opType)
        {
            case '*':
            {
                execAns = op1*op2;
                System.out.println(execAns);
            }
            break;

            case '/':
            {
                execAns = op2/op1;
                System.out.println(execAns);
            }
            break;

            case '-':
            {
                execAns = op2-op1;
                System.out.println(execAns);
            }
            break;

            case '+':
            {
                execAns = op1+op2;
                System.out.println(execAns);
            }
            break;
        }
        return execAns;
    }

    private DSAQueue parseInfixToPostfix(String equation)
    {
        String[] arr = equation.split(" ");
        DSAStack opStack = new Stack(arr.length+1);
        DSAQueue postfix = new CircQueue(arr.length+1);
        int iter = 0;
        while(iter < arr.length)
        {
            //Push "(" to Operator stack 
            if(arr[iter].equals("("))
            {
                opStack.push(arr[iter]);
            }

            else if (!isOperator(arr[iter]) && !arr[iter].equals(")") &&
                            !arr[iter].equals("("))
            {
                postfix.enQueue(arr[iter]);
            }          

            //For when we find ")" pop all operators from opStack and transfer
            //to postfix queue. "(" Is not transferred, it is popped.
            else if(arr[iter].equals(")"))
            {
                while(!opStack.peek().equals("("))
                {
                    Object transfer = opStack.pop();
                    postfix.enQueue(transfer);
                }
                if(!opStack.isEmpty() && opStack.peek().equals("("))
                {
                    opStack.pop();
                }
            }

            //Kick start the stack pushing for when the current stack is empty
            //In the beginning
            else if(opStack.isEmpty() && (isOperator(arr[iter]) ||
                        (arr[iter].equals("(") || !arr[iter].equals(")"))))
            {
                opStack.push(arr[iter]);
            }
            

            //Operators only, they will go to stack or postfix depending on
            //precedence
            else if(isOperator(arr[iter]))
            {
                while(!opStack.isEmpty() && !opStack.peek().equals("(") &&
                        valuePrecedence(String.valueOf(opStack.peek())) >=
                                valuePrecedence(arr[iter]))
                {
                    Object c = opStack.pop();
                    postfix.enQueue(c);
                }
                opStack.push(arr[iter]);
            }
            //Only put numbers here, checks if arr[iter] is not an operator or
            //"(" or ")"
            //else if (!isOperator(arr[iter]) && !arr[iter].equals(")") &&
            //                    !arr[iter].equals("("))
            //{
              //  postfix.enQueue(arr[iter]);
            //}
            iter++;

        }

        //Remainder operators on stack
        while(!opStack.isEmpty())
        {
            Object c = opStack.pop();
            postfix.enQueue(c);
        }
        return postfix;
    }

    private int valuePrecedence(String part)
    {
        int value =0;
        char prec = part.charAt(0);
        switch(prec)
        {
            case '+': case '-':
            {
                value = 0;
            }
            break;

            case '*': case '/':
            {   
                value = 1;
            }
            break;

            default:
            {
                value = -1;
            }
        }
        return value;
    }

    //Check if the part is a operator
    private boolean isOperator(String part)
    {
        boolean isOperator = false;
        char op = part.charAt(0);
        if(op == '/' || op == '-' || op == '+' || op == '*')
        {
            isOperator = true;
        }

        return isOperator;
    }
}
