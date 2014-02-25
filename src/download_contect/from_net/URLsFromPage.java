package download_contect.from_net;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.BufferedInputStream;

public class URLsFromPage {
    private final String urlPattern = "(href=\"/wiki/[^\".]+\")";

    public Set<String> getURLs(String url) throws IOException {
	Set<String> urls = new HashSet<>();
	String content = getURLContent(url);
	Matcher m = Pattern.compile(urlPattern).matcher(content);
	while (m.find()) {
	    urls.add(m.group());
	}
	return urls;
    }

    private String getURLContent(String url) throws IOException {
	StringBuilder str = new StringBuilder();
	HttpURLConnection conn = (HttpURLConnection) new URL(url)
		.openConnection();
	try (BufferedInputStream in = new BufferedInputStream(
		conn.getInputStream())) {
	    int c;
	    while ((c = in.read()) != -1) {
		str.append((char) c);
	    }
	}
	return str.toString();
    }

//    public static void main(String[] args) throws IOException {
//	GetUrlsFromPage gufp = new GetUrlsFromPage();
//	String url = "https://en.wikipedia.org/wiki/Category:Computing";
//	System.out.println(gufp.getURLs(url));
//    }
}
