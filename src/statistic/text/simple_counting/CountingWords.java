package statistic.text.simple_counting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class CountingWords {

    public Map<String, Integer> getStatistic(String text) {
	text = text.replaceAll("[^A-Za-z]", " ");
	text = text.replaceAll("[ ]+", " ");
	text = text.toLowerCase();
	String[] arr = text.split(" ");
	return getMap(arr);
    }

    private Map<String, Integer> getMap(String[] arr) {
	Map<String, Integer> result = new TreeMap<>();
	Integer first = 1;
	Integer index;
	for (String s : arr) {
	    if (result.containsKey(s)) {
		index = result.get(s);
		index++;
		result.put(s, index);
	    } else {
		result.put(s, first);
	    }
	}
	return result;
    }

    public Map<String, Integer> getSorted(Map<String, Integer> map) {
	List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

	Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
	    @Override
	    public int compare(Map.Entry<String, Integer> obj_1,
		    Map.Entry<String, Integer> obj_2) {
		return obj_2.getValue().compareTo(obj_1.getValue());
	    }
	});

	Map<String, Integer> res = new LinkedHashMap<>();

	for (Map.Entry<String, Integer> e : list) {
	    res.put(e.getKey(), e.getValue());
	}

	return res;
    }

    public Map<Integer, Integer> getCountReps(Map<String, Integer> map) {
	List<Integer> list = new ArrayList<>(map.values());
	Map<Integer, Integer> reps = new TreeMap<>();

	Integer first = 1;
	Integer current;

	for (Integer e : list) {
	    if (reps.containsKey(e)) {
		current = reps.get(e);
		current++;
		reps.put(e, current);
	    } else {
		reps.put(e, first);
	    }
	}

	return reps;
    }

    public Set<String> getWords(Map<String, Integer> map) {
	return map.keySet();
    }

}
