package statistic.text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class WriteToFile
{
    private static final String path = "./texts/out.txt";

    public static void write(Map<String, Integer> map)
    {
        try (FileOutputStream fs = new FileOutputStream(new File(path)))
        {
            List<Integer> indexes = new ArrayList<Integer>();
            fs.write(("Total: " + map.size() + '\n').getBytes());
            for (Map.Entry<String, Integer> e : map.entrySet())
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
}
