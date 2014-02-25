package download_contect.from_net.service_classes;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;

public class TreeURLsCategories {

    private Node root = null;
    private Node current = null;
    private LinkedList<Node> processingSequence = new LinkedList<Node>();
    private LinkedList<Node> allNodes = new LinkedList<Node>();

    private class Node {
	public Node parentNode = null;
	public String url;
	public List<String> articles = null;
	public List<Node> subNodes = null;

	public Node(String url, Node parentNode) {
	    this.url = url;
	    this.parentNode = parentNode;
	}

	public String toString() {
	    return url;
	}
    }

    public TreeURLsCategories(String rootURL) {
	root = new Node(rootURL, null);
	current = root;
	allNodes.add(root);
	processingSequence.add(root);
    }

    public String getCurrent() {
	return this.current.url;
    }

    /**
     * set new "current"
     */
    public void formedCurrent(List<String> articles, List<String> subNodes) {
	current.articles = new ArrayList<String>(articles);
	current.subNodes = createSubNodes(subNodes, current);
	
	processingSequence.addAll(current.subNodes);
	
	this.processingSequence.removeFirst();
	this.current = processingSequence.getFirst();
    }

    private List<Node> createSubNodes(List<String> subNodes, Node parent) {
	List<Node> nodes = new ArrayList<Node>();
	Node node;
	for (String s : subNodes) {
	    node = new Node(s, parent);
	    nodes.add(node);
	    allNodes.add(node);
	}
	return nodes;
    }

    public String toString() {
	return allNodes.toString();
    }

    public static void main(String[] args) {
	TreeURLsCategories tuc = new TreeURLsCategories("t0");

	String[] art_s = { "t0.0.1", "t0.0.2", "t0.0.3", "t0.0.4", "t0.0.5" };
	String[] sub_n = { "t0.1.1", "t0.1.2", "t0.1.3", "t0.1.4", "t0.1.5" };
	tuc.formedCurrent(Arrays.asList(art_s), Arrays.asList(sub_n));

	System.out.println(tuc);
    }

}
