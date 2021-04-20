public class TestHarnessStack
{
    public static void main(String[] args)
    {
        Stack stack = new Stack(4);
        int num = 50;
        double real = 4.5;
        String str = "Spegg";
        char chr = 'i';

        System.out.println("Created stack of size 4");
        
        System.out.println("Pushing integer value 50 to stack");
        stack.push(num);
        System.out.println("Current stack count: " + stack.getCount());
        System.out.println("Current stack top: " + stack.peek());

        System.out.println("\nPushing double value " + real + " to stack");
        stack.push(real);
        System.out.println("Current stack count: " + stack.getCount());
        System.out.println("Current stack top: " + stack.peek());

        System.out.println("\nPushing String " + str + " to the Stack");
        stack.push(str);
        System.out.println("Current stack count: " + stack.getCount());
        System.out.println("Current stack top: " + stack.peek());

        System.out.println("\nPushing Character " + "'" +chr + "'" + " to the Stack");
        stack.push(chr);
        System.out.println("Current stack count: " + stack.getCount());
        System.out.println("Current stack top: " + stack.peek());

        System.out.println("\nPopping the stack until empty.");
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }

        System.out.println("Current stack count is now " + stack.getCount());
            
        System.out.println("Stack is empty: " + stack.isEmpty());
        System.out.println("Stack is full: " + stack.isFull());

    }
}
