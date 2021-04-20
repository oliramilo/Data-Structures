public class Storage
{
    public static final int LIMIT = 7000;
    private Student[] collection;
    private int count;

    //Setting array size to the maximum
    public Storage()
    {
        this.collection = new Student[7000];
        this.count = 0;
    }

    //Adding student info to be stored in array
    public void addStudent(Student info)
    {
        if(info instanceof Student)
        {
            if(info != null && count <= LIMIT)
            {
                collection[count] = info;
                count +=1;
            }
            else
            {
                throw new NullPointerException("Object null");
            }
        }
        else
        {
            throw new IllegalArgumentException("Not a student object");
        }
    }

    //A toString method
    public String[] listCollection()
    {
        String[] infoList = new String[count];
        for(int i=0;i<count;i++)
        {
            infoList[i] = collection[i].returnInfo();
        }

        return infoList;
    }

    //Return the array of Student ID's
    public int[] getIDList()
    {
        int[] idList = new int[count];
        for(int i=0;i<count;i++)
        {
            idList[i] = collection[i].getID();
        }

        return idList;
    }

    //Return the array of student information in object arrays
    public Student[] getStudentCollection()
    {
        return this.collection;
    }

    public int getCounter()
    {
        return this.count;
    }

    //Returns the student object at the specific point in the array
    public Student getObjectAtIndex(int i)
    {
        return collection[i];
    }

    //toString method for exporting sorted array to csv file
    public String[] csvString()
    {
        String[] csvLines = new String[count];
        for(int i =0;i<count;i++)
        {
            csvLines[i] = collection[i].toString();
        }
        return csvLines;
    }
}
