package statistic.text.multi_texts_operation;

import java.util.ArrayList;
import java.util.List;

public class Complement {

    public static List<String> complement(List<String> list_1,
	    List<String> list_2) {
	List<String> result_list = new ArrayList<>();
	for (String element : list_1) {
	    if (list_2.contains(element)) {
		result_list.add(element);
	    }
	}
	return result_list;
    }

    // public static void main(String[] args) {
    // List<String> list_1 = new ArrayList<String>();
    // list_1.add("a");
    // list_1.add("abc");
    // list_1.add("bcd");
    //
    // List<String> list_2 = new ArrayList<String>();
    // list_2.add("a");
    // list_2.add("bcd");
    // list_2.add("cde");
    //
    // List<String> result_list = Complement.complement(list_1, list_2);
    //
    // System.out.println(result_list);
    // }

}
