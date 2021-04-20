import java.io.*;

class fileReader
{
    static void read(String file, BinarySearchTree t){
        FileInputStream fStrm = null;
        InputStreamReader rdr;
        BufferedReader bfrR;
        String line;

        try{
            fStrm = new FileInputStream(file);
            rdr = new InputStreamReader(fStrm);
            bfrR = new BufferedReader(rdr);
            line = bfrR.readLine();
            while(line != null){
                processLine(line,t);
                line = bfrR.readLine();
            }
            fStrm.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }

    static void processLine(String line, BinarySearchTree t){
        String sep[] = line.split(",");
        t.insert(sep[0],sep[1]);
    }

    static void toCsv(String file,DSAQueue order){
        FileOutputStream toFile = null;
        PrintWriter write;
        try{
            toFile = new FileOutputStream(file);
            write = new PrintWriter(file);
            while(!order.isEmpty()){
                write.println(order.deQueue());
            }
            write.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
