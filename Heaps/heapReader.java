import java.io.*;
class heapReader
{
    public static void fileToHeap(String file, Heap h)
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
                lineRead(line,h);
                line = bfr.readLine();
                i++;
            }
            strm.close();
        }

        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void lineRead(String line,Heap h)
    {
        String[] s = line.split(",");
        if(s.length != 2)
        {
            throw new IllegalArgumentException("Invalid format");
        }
        else
        {
            try
            {
                int num = Integer.parseInt(s[0]);
                h.add(num,s[1]);
            }
            catch(NumberFormatException e)
            {
                System.out.println("Invalid Number format");
            }

        }
    }


}
