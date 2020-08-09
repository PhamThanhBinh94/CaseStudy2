package CaseStudyModule2;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlData {
    private static ProductManager productManager = null;
    private static ArrayList<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        productManager = new ProductManager();
        URL url;
        try {
            url = new URL ("https://mediamart.vn/tivi/");
            Scanner scanner;
            scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            content = content.replaceAll("\\s+"," ");
            Pattern p = Pattern.compile("pl18-item-brand\"> (.*?) <span>(.*?)</span> </p> <p class=\"pl18-item-name\"> <a href=\"(.*?).htm\" title=\"(.*?) inch (.*?)(.*?)\">(.*?)</a> </p> <p><span class=\"product-id hidden\" style=\"display:none!important;\">(.*?)</span></p> <div class=\"pl18-item-pbuy\">(.*?)<span>đ");
            Matcher m = p.matcher(content);
            while (m.find()){
                String price = m.group(9).replaceAll("\\.","");
                price = price.replaceAll(" ","");
                double priceDouble = Double.parseDouble(price);
                Random random = new Random();
                Product product = new Product(m.group(2),m.group(8),priceDouble,m.group(1), random.nextInt(35)+5);
                products.add(product);
                if (products.size()>=40) break;
            }
            productManager.writeProductList(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}