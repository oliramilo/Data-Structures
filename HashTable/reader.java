import java.io.*;

public class reader
{
    public static void readFile(String file, HashTable t)
    {
        FileInputStream strm = null;
        InputStreamReader rdr = null;
        BufferedReader bfr = null;
        String line = null;

        try
        {
            strm = new FileInputStream(file);
            rdr = new InputStreamReader(strm);
            bfr = new BufferedReader(rdr);
            line = bfr.readLine();
            int i =0;
            while(line != null)
            {
                System.out.println("Times added: "+i);
                processLine(line,t);
                line = bfr.readLine();
                i++;
            }
            strm.close();
        }

        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void processLine(String line,HashTable t)
    {
        String[] s = line.split(",");
        if(s.length != 2)
        {
            throw new IllegalArgumentException("Invalid format");
        }
        else
        {
            t.add(s[1],s[0]);
        }
    }

    public static void saveTable(String file, HashTable t)
    {
        FileOutputStream out = null;
        PrintWriter pw;
        int i=0;
        try
        {
            String[] s = t.csvString();
            out = new FileOutputStream(file);
            pw = new PrintWriter(out);
            while(i<s.length)
            {
                pw.println(s[i]);
                i++;
            }
            pw.close();
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
