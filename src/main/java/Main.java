import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        ontarioWorksCrawler();
        cityOfTorontoCrawler();
    }

    public static void ontarioWorksCrawler() throws IOException {
        Document doc = Jsoup.connect("https://eos.toronto.ca/ontarioworks/search/?createNewAlert=false&q=&optionsFacetsDD_department=").get();
        Elements jobsList = doc.select("#job-tile-list li");
        for (Element job: jobsList) {
            String jobTitle = job.select(".jobTitle-link").first().html();
            System.out.println(jobTitle);
        }
    }

    public static void cityOfTorontoCrawler() throws IOException {
//        Document doc = Jsoup.connect("https://jobs.toronto.ca/jobsatcity/search/?createNewAlert=false&q=").get();
//        Elements jobsList = doc.select("#job-tile-list li");
//        for (Element job: jobsList) {
//            String jobTitle = job.select(".jobTitle-link").first().html();
//            System.out.println(jobTitle);
//        }
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("https://jobs.toronto.ca/jobsatcity/search/?createNewAlert=false&q=");
            System.out.println(page.getElementsById("job-tile-list"));
        }
    }
}
