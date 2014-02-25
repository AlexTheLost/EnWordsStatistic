package download_contect.from_net.service_classes;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.lang.Iterable;

public class OLD_TreeCatecoriesURLs {

    private Node root;
    private Node current;

    OLD_TreeCatecoriesURLs(String rootURL) {
	root = new Node(rootURL, null);
	current = root;
    }

    private class Node {
	private Node parent;
	private String url;
	private List<String> articles = new ArrayList<String>();
	private List<Node> subNode = new ArrayList<Node>();

	public Node(String url, Node parent) {
	    this.url = url;
	    this.parent = parent;
	}

	public Node getParent() {
	    return this.parent;
	}

	public String getURL() {
	    return this.url;
	}

	public void setArticles(List<String> articles) {
	    this.articles = articles;
	}

	public void seSubNode(List<Node> subNode) {
	    this.subNode = subNode;
	}
    }

    public String next() {
	String url = null;
	Node parent = current.getParent();
	if (parent != null) {
	    int lenght = current.subNode.size();
	    Node next = null;
	    for (int i = 0; i < lenght; i++) {
		if (current.getURL().equals(next = current.subNode.get(i))) {
		    return next.getURL();
		}
	    }

	} else {

	}

	return url;
    }

    public String getCurrent() {
	return current.getURL();
    }

    public void formedCurrent(List<String> articles, List<Node> subNode) {
	this.current.setArticles(articles);
	this.current.seSubNode(subNode);
    }

}
