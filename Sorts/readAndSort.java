import java.util.*;
public class readAndSort
{

    private Storage studentCollection;

    public readAndSort()
    {
        studentCollection = new Storage();
    }

    public void start()
    {
        String file = "RandomNames7000.csv";
        //Call the file reader and store into object array for student
        //information
        FileIO.readFile(file,studentCollection);
        
        //Finds the index in the array that contains the largest number
        int j = findLargest(studentCollection);

        System.out.println("The largest number in the array is at position " 
                        + j + "info of student "
                        + studentCollection.getObjectAtIndex(j).returnInfo());

        //Sorts the object array into position from smallest to largest
        byInsertionSort(studentCollection.getStudentCollection());
        String[] arr = studentCollection.listCollection();

        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

        //Checks if the array is sorted
        if(isSorted(studentCollection.getIDList()))
        {
            System.out.println("Array is sorted");
        }

        //Finds the index with the largest number in the array that is sorted
        int i = findLargest(studentCollection);
        System.out.println("Highest ID is at postion " + i);
        System.out.println("This person's details are " +
                        studentCollection.getObjectAtIndex(i).returnInfo());

        //Return sorted array of objects to a csv file named "Sorted.csv"
        String file2 = "Sorted.csv";
        FileIO.exportFile(file2, studentCollection);
    }

    //Takes in object Student[] array and sorts their positions by 
    //their id number from smallest to highest
    public void byInsertionSort(Student[] studentObject)
    {
        for(int i=1;i<studentObject.length;i++)
        {
            int j = i-1;
            Student temp = studentObject[i];
            while(j>= 0 && studentObject[j].getID() > temp.getID())
            {
                studentObject[j+1] = studentObject[j];
                j -=1;
            }
            studentObject[j+1] = temp;
        }
    }

    //Checks if the array is arranged using linear searching
    //Returns a boolean
    public boolean isSorted(int[] arr)
    {
        //Assumed that the array is not sorted initially
        boolean sorted = false;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i] < arr[i+1])
            {
                sorted = true;
            }
        }
        return sorted;
    }

    //Finds the largest id in the array and returns the index position
    public int findLargest(Storage studentArr)
    {
        int[] id = studentArr.getIDList();
        int i = 0;
        //let pos be the index we search for the largest number
        int pos = 0;
        //Assume the largest number is the first index initially
        int largest = id[i];
        for(i = 1;i<id.length;i++)
        {
            if(id[i] > largest)
            {
                largest = id[i];
                pos = i;
            }
        }
        return pos;
    }

}
