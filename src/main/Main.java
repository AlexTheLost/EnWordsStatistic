package main;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import statistic.text.io.LoadTexts;
import statistic.text.io.WriteToFile;
import statistic.text.simple_counting.CountingWords;

public class Main {

    public static void main(String[] args) {

	long start_time = System.currentTimeMillis();
	
	CountingWords cw = new CountingWords();
	LoadTexts texts = new LoadTexts();

	Iterator<String> iter = texts.iterator();

	Map<String, Integer> stat = cw.getStatistic(iter.next());
	Set<String> res_list = cw.getWords(stat);

	
	
	while (iter.hasNext()) {
	    stat = cw.getStatistic(iter.next());
	    
	    res_list.retainAll(cw.getWords(stat));

	}

	WriteToFile.write(res_list);
	
	long end_time = System.currentTimeMillis();
	
	
	
	System.out.println("End, time: " + (end_time - start_time));

    }
}
