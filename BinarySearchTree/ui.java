import java.util.*;
import java.io.*;
class ui
{
    private BinarySearchTree t;
    public ui()
    {
        t = new BinarySearchTree();
        int userChoice = 0;
        while(userChoice != 6) {
            System.out.println("1) Read CSV file");
            System.out.println("2) Read a serialized file");
            System.out.println("3) display the tree");
            System.out.println("4) Write a CSV file");
            System.out.println("5) Write a serialized file");
            System.out.println("6) Exit");
            userChoice = input();
            option(userChoice);
        }
    }

    void option(int i){
        switch(i)
        {
            case 1: fileToTree(fileInput()); break;
            case 2: t = t.load(fileInput()); break;
            case 3: display(); break;
            case 4: writeToCSV(); break;
            case 5: t.save(fileInput()); break;
            default:
        }
    }

    void fileToTree(String file){
        try {
            t.read(file,t);
        }
        catch(Exception e) {
            e.printStackTrace();
            System.out.println("File not found.");
        }
    }

    String fileInput(){
        System.out.print("Enter file name: ");
        Scanner sc = new Scanner(System.in);
        String file = sc.nextLine();

        return file;
    }

    int input(){
        Scanner sc = new Scanner(System.in);
        int input = 0;
        try {
            input = sc.nextInt();
        }
        catch(InputMismatchException e) {
            System.out.println("Enter: 1,2,3,4,5,6");
        }
        return input;
    }
    
    void writeToCSV() {
        DSAQueue order = new Queue();
        String file = fileInput();
        order = traverse();
        t.toCsv(file,order);
    }

    void display()
    {
        DSAQueue order = new Queue();
        order = traverse();
        Iterator it = order.iterator();
        for(Object e:order)
        {
            System.out.println(it.next());
        }
    }

    DSAQueue traverse()
    {
        System.out.println("1) In-order traversal");
        System.out.println("2) Pre-order traversal");
        System.out.println("3) Post-order traversal");
        DSAQueue traverse = new Queue();
        int option = input();
        switch(option)
        {
            case 1: traverse = t.inOrder(); break;
            case 2: traverse = t.preOrder(); break;
            case 3: traverse = t.postOrder(); break;
            default: System.out.println("Exited");
        }
        return traverse;
    }
}
