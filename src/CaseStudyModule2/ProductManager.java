package CaseStudyModule2;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManager {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();

        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("ProductManager");
            System.out.println("1. Add products");
            System.out.println("2. Edit products");
            System.out.println("3. Delete products");
            System.out.println("4. Search products");
            System.out.println("5. Display products");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();

            switch (choice) {
                case 1:
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
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Please enter id that you want to search: ");
                    String id3 = scanner3.nextLine();
                    for (Product pro : products) {
                        if (pro.getId().equals(id3)) {
                            products.remove(pro);
                        }
                    }
                    System.out.println(products);
                    break;
                case 4:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Please enter name that you want to search: ");
                    String name4 = scanner4.nextLine();
                    for (Product pro4 : products) {
                        if (pro4.getName().equals(name4)) {
                            System.out.println(pro4);
                        }
                    }
                    break;
                case 5:
                    int choice1 = -1;
                    Scanner input1 = new Scanner(System.in);
                    while (choice1 != 0) {
                        System.out.println("Options");
                        System.out.println("1. Sort by price from high to low");
                        System.out.println("2. Sort by price from low to high");
                        System.out.println("3. Sort by name");
                        System.out.println("Enter your choice");
                        choice1 = input1.nextInt();

                        switch (choice1) {
                            case 1:
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
                                break;
                            case 2:
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
                                break;

                            case 3:
                                Collections.sort(products, new Comparator<Product>() {
                                    @Override
                                    public int compare(Product o1, Product o2) {
                                        return (o1.getName().compareTo(o2.getName()));
                                    }
                                });
                                System.out.println(products);
                                break;
                            case 0:
                                System.exit(0);
                            default:
                                System.out.println("No choice!");
                        }
                    }
            }
        }
    }
}
