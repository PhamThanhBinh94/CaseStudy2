package CaseStudyModule2;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {
//    private ArrayList<Product> products;
    public ProductManager() {
    }
    public void displayProducts(ArrayList<Product> products) {
        System.out.printf("%-30s%-20s%-20s%-15s\n","Name products","Code products", "Price products ", "Brand products");
        System.out.printf("------------------------------------------------------------------------------------");
        System.out.println();
        for(Product product: products)
            System.out.printf("%-30s%-20s%-20s%-15s\n",product.getName(),product.getId(),product.getPrice(),product.getBrand());
    }
    public static void sortByName(ArrayList<Product> products) {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        });
//        System.out.println(products);
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
//        System.out.println(products);
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
//        System.out.println(products);
    }
    public static void editProductByName(ArrayList<Product> products){
        boolean isExist =false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id2 = scanner2.nextLine();;
        for (int i=0; i < products.size(); i++){
            if (id2.equals(products.get(i).getId())){
                isExist = true;
                System.out.println("Please enter new name: ");
                String name = scanner2.nextLine();
                products.get(i).setName(name);
                System.out.println(products);
            }
        }
        if (!isExist){
            System.out.println("Please enter again!!!");
        }
    }
    public static void editProductById(ArrayList<Product> products){
        boolean isExist =false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id2 = scanner2.nextLine();
        for (int i=0; i < products.size(); i++){
            if (id2.equals(products.get(i).getId())){
                isExist = true;
                System.out.println("Please enter new id: ");
                String id = scanner2.nextLine();
                products.get(i).setId(id);
                System.out.println(products);
            }
        }
        if (!isExist){
            System.out.println("Please enter again!!!");
        }
    }
    public static void editProductByPrice(ArrayList<Product> products){
        boolean isExist =false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id2 = scanner2.nextLine();;
        for (int i=0; i < products.size(); i++){
            if (id2.equals(products.get(i).getId())){
                isExist = true;
                System.out.println("Please enter new price: ");
                Double price = scanner2.nextDouble();
                products.get(i).setPrice(price);
                System.out.println(products);
            }
        }
        if (!isExist){
            System.out.println("Please enter again!!!");
        }
    }
    public static void editProductByBrand(ArrayList<Product> products){
        boolean isExist =false;
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id2 = scanner2.nextLine();
        for (int i=0; i < products.size(); i++){
            if (id2.equals(products.get(i).getId())){
                isExist = true;
                System.out.println("Please enter new brand: ");
                String brand = scanner2.nextLine();
                products.get(i).setBrand(brand);
                System.out.println(products);
            }
        }
        if (!isExist){
            System.out.println("Please enter again!!!");
        }
    }
    public static void searchProduct(ArrayList<Product> products) {
        Scanner scanner4 = new Scanner(System.in);
        System.out.println("Please enter id that you want to search: ");
        String id4 = scanner4.nextLine();
        for (Product pro4 : products) {
            if (pro4.getId().equals(id4)) {
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
                products.remove(products.indexOf(pro));
                break;
            }
        }
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
//        System.out.println(products);
    }
    public void writeProductList(ArrayList<Product> products) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        try {
            readWriteFile.writeObjectFile("C:\\Users\\LENOVO\\IdeaProjects\\Case2\\src\\File\\Product.txt",products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Product> readProductList(String path) {
        ReadWriteFile readWriteFile = new ReadWriteFile();
        ArrayList<Product> products = null;
        try {
            products = readWriteFile.readObjectFile(path);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return products;
    }
}