//Class for reading CSV files of student information in RandomNames7000.csv

import java.util.*;
import java.io.*;

public class FileIO
{
    //File reader 
    public static void readFile(String file, Storage studentInfo)
    {
        FileInputStream strm = null;
        InputStreamReader read;
        BufferedReader bufferRead;
        String line;

        try
        {
            strm = new FileInputStream(file);
            read = new InputStreamReader(strm);
            bufferRead = new BufferedReader(read);
            line = bufferRead.readLine();

            while(line != null)
            {
                try
                {
                    readCSV(line, studentInfo);
                }
                catch(IllegalArgumentException e)
                {
                    e.printStackTrace();
                }
                line = bufferRead.readLine();
            }
            strm.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    //Reads a csv file line
    public static void readCSV(String line, Storage storeInfo)
    {
        String[] info = line.split(",");
        if(info.length == 2)
        {
            try
            {
                int num = Integer.parseInt(info[0]);
                String name = info[1];
                Student newStudent = new Student(num,name);
                storeInfo.addStudent(newStudent);
            }
            catch(NumberFormatException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            throw new StringIndexOutOfBoundsException("Array index out of bounds exception caught");
        }
    }

    //used to export student information to a file
    public static void exportFile(String file, Storage studentList)
    {
        String[] str = studentList.csvString();
        FileOutputStream toFile = null;
        PrintWriter printer;
        try
        {
            toFile = new FileOutputStream(file);
            printer = new PrintWriter(toFile);
            for(int i=0;i<str.length;i++)
            {
                printer.println(str[i]);
            }
            printer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
