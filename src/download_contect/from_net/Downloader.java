package download_contect.from_net;

import download_contect.from_net.service_classes.TreeURLsCategories;

public class Downloader {
    private String default_url = "https://en.wikipedia.org/wiki/Portal:Computer_science";
    
    public Downloader() {
	TreeURLsCategories treeURLs = new TreeURLsCategories(default_url);
	String url = treeURLs.getCurrent();	
    }
    
    public Downloader(String url) {
	default_url = url;
    }
    
    public static void main(String[] args) {
	Downloader ud = new Downloader();
    }    

}
