package statistic.text.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class LoadTexts implements Iterable<String> {
    private String path_to_dir = "./texts/files/";
    private List<File> files;

    public LoadTexts() {
	files = getFiles();
    }

    public void setPath(String path) {
	path_to_dir = path;
	files = getFiles();
    }

    private List<File> getFiles() {
	File folder = new File(path_to_dir);
	return new ArrayList<File>(Arrays.asList(folder.listFiles()));
    }

    @Override
    public Iterator<String> iterator() {
	return new TextIterator();
    }

    private class TextIterator implements Iterator<String> {
	private Iterator<File> iterator = files.iterator();

	@Override
	public String next() {
	    StringBuilder text = new StringBuilder("");
	    File file = iterator.next();
	    try (FileInputStream in = new FileInputStream(file)) {
		int c;
		while ((c = in.read()) != -1) {
		    text.append((char) c);
		}

	    } catch (IOException e) {
		e.printStackTrace();
	    }
	    return text.toString();
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext();
	}

	@Override
	public void remove() {
	}
    }

    public static void main(String[] args) {
	LoadTexts lf = new LoadTexts();
	for (String text : lf) {
	    System.out.println(text);
	}

    }

}
