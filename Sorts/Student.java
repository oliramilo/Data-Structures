//Class that holds information of student's ID and name
public class Student
{
    private int id;
    private String name;
    
    //Standard constructor
    public Student(int id, String name)
    {
        setState(id,name);
    }

    //Standard setter
    public void setState(int id, String name)
    {
        if(id > 0 && (!name.trim().equals("") || !name.trim().equals(null)))
        {
            this.id = id;
            this.name = name;
        }
        else
        {
            throw new IllegalArgumentException("Invalid values");
        }
    }

    //Return id of the student 
    public int getID()
    {
        return this.id;
    }

    //Return name of student
    public String getName()
    {
        return this.name;
    }

    //Returns both information
    public String returnInfo()
    {
        String infoToString = ("ID: " + id + " NAME: " + name);
        return (infoToString);
    }

    //used for csv export
    public String toString()
    {
        return (id + "," + name);
    }
}
