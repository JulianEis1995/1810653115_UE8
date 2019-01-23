package Aufgabe_5;

import java.io.*;
import java.util.Random;

class NumberFindOuter
{
    private String path = "C:/temp/counter.txt";

    int counter(int number)
    {
        BufferedReader br = null;
        int counter = 0;

        try
        {
            br = new BufferedReader(new FileReader(path));

            String line;
            while((line = br.readLine()) != null)
            {
                int temp = Integer.parseInt(line);
                if(temp == number)
                {
                    counter ++;
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            } catch(IOException ex)
            {
                ex.printStackTrace();
            }
        }
        return counter;
    }

    void fillFile()
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));

            for(int i = 0; i < 50; i++)
            {
                Random random = new Random();
                int counter = random.nextInt(50);
                bw.write(counter + System.getProperty("line.separator"));
            }
            bw.close();
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }

}
