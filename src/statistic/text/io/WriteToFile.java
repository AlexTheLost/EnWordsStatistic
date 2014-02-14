package statistic.text.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class WriteToFile
{
    private static final String path = "./texts/out.txt";

    public static void write(Map<String, Integer> info)
    {
        try (FileOutputStream fs = new FileOutputStream(new File(path)))
        {
            List<Integer> indexes = new ArrayList<>();
            fs.write(("Total: " + info.size() + '\n').getBytes());
            for (Map.Entry<String, Integer> e : info.entrySet())
            {
                indexes.add(e.getValue());
                fs.write((e.toString() + '\n').getBytes());
            }
            fs.write(indexes.toString().getBytes());            
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void write(String info)
    {
        try (FileOutputStream fs = new FileOutputStream(new File(path)))
        {
            fs.write(info.getBytes());         
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void write(List<String> info)
    {
        try (FileOutputStream fs = new FileOutputStream(new File(path)))
        {
            String result_str = String.valueOf(info.size()) + '\n';
            result_str += info.toString();
            fs.write(result_str.getBytes());         
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void write(Set<String> info)
    {
        try (FileOutputStream fs = new FileOutputStream(new File(path)))
        {
            String result_str = String.valueOf(info.size()) + '\n';
            result_str += info.toString();
            fs.write(result_str.getBytes());         
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
