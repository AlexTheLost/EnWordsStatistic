package statistic.text.io;

import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;

public class LoadText
{
    private String path = "./texts/test_text.txt";

    public void setPath(String path)
    {
        this.path = path;
    }

    public String getText()
    {
        StringBuffer sb = new StringBuffer();
        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream(new File(path))))
        {
            int c;
            while ((c = in.read()) != -1)
            {
                sb.append((char) c);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return sb.toString();
    }

    /*
     * public static void main(String[] args) { LoadText lt = new LoadText();
     * System.out.println(lt.getText()); }
     */
}
