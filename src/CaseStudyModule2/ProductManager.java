package CaseStudyModule2;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {



    public static void sortByName(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
        System.out.println(products);
    }

    public static void editProduct(ArrayList<Product> products){
        boolean isExist = true;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id2 = scanner2.nextLine();
        for (int i=0; i < products.size() && isExist; i++){
            if (id2.equals(products.get(i).getId())){
                System.out.println("Please enter new id: ");
                String id = scanner2.nextLine();
                products.get(i).setId(id);
                System.out.println(products);
            }
        }
    }

    public static void sortPriceFromLowToHigh(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice())
                    return 1;
                if (o1.getPrice() == o2.getPrice())
                    return 0;
                return -1;
            }
        });
        System.out.println(products);
    }

    public static void sortPriceFromHighToLow(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice())
                    return -1;
                if (o1.getPrice() == o2.getPrice())
                    return 0;
                return 1;
            }
        });
        System.out.println(products);
    }

    public static void searchProduct(ArrayList<Product> products) {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter name that you want to search: ");
        String name4 = scanner4.nextLine();
        for (Product pro4 : products) {
            if (pro4.getName().equals(name4)) {
                System.out.println(pro4);
            }
        }
    }

    public static void deleteProduct(ArrayList<Product> products) {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id3 = scanner3.nextLine();
        for (Product pro : products) {
            if (pro.getId().equals(id3)) {
                products.remove(pro);
            }
        }
        System.out.println(products);
    }

    public void addProduct(ArrayList<Product> products) {
        Product product = new Product();
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Please enter a name");
        String name = scanner1.nextLine();
        product.setName(name);
        System.out.println("Please enter a id");
        String id = scanner1.nextLine();
        product.setId(id);
        System.out.println("Please enter a price");
        Double price = scanner1.nextDouble();
        product.setPrice(price);
        System.out.println("Please enter a brand");
        String brand = scanner1.next();
        product.setBrand(brand);
        products.add(product);
        System.out.println(products);
    }
}
