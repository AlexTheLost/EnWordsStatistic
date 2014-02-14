package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import statistic.text.io.LoadTexts;
import statistic.text.io.WriteToFile;
import statistic.text.simple_counting.CountingWords;

public class Main {

    public static void main(String[] args) {
	// ----time-----
	long start = System.currentTimeMillis();

	CountingWords cw = new CountingWords();
	LoadTexts lt = new LoadTexts();

	List<Set<String>> total_list = new ArrayList<>();

	// ----time-----
	long end = System.currentTimeMillis();

	System.out.println("Continue loadings..., time= " + (end - start));

	// ----time-----
	start = System.currentTimeMillis();

	// ----time-----
	long res_sub_time = 0;

	Iterator<String> it = lt.iterator();

	Map<String, Integer> st = cw.getStatistic(it.next());
	Set<String> res_list = cw.getWords(st);

	while (it.hasNext()) {
	    st = cw.getStatistic(it.next());
	    res_list.retainAll(cw.getWords(st));
	}

	// Set<String> res_list = cw.getStatistic(lt);

	// for (String text : lt) {
	// // ----time-----
	// long sub_start = System.currentTimeMillis();
	//
	// st = cw.getStatistic(text);
	//
	// // ----time-----
	// long sub_end = System.currentTimeMillis();
	//
	// res_sub_time += sub_end - sub_start;
	//
	// total_list.add(cw.getWords(st));
	//
	// }

	// ----time-----
	end = System.currentTimeMillis();

	System.out.println("Continue separate calculation..., time= "
		+ (end - start) + ", sub_time= " + res_sub_time);

	// ----time-----
	// start = System.currentTimeMillis();

	// = total_list.get(0);
	// for (Set<String> sub_list : total_list) {
	// res_list.retainAll(sub_list);
	// }

	// ----time-----
	// end = System.currentTimeMillis();

//	System.out.println("Result..., time= " + (end - start));

	WriteToFile.write(res_list);

	// System.out.println(res_list);

	// long end = System.currentTimeMillis();
	// System.out.println("Time: " + (end - start));

	// System.out.println(words);
    }
}
