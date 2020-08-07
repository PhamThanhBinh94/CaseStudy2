package CaseStudyModule2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
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
                    productManager.addProduct(products);
                    break;
                case 2:
                    productManager.editProduct(products);
                    break;
                case 3:
                    productManager.deleteProduct(products);
                    break;
                case 4:
                    productManager.searchProduct(products);
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
                                productManager.sortPriceFromHighToLow(products);
                                break;
                            case 2:
                                productManager.sortPriceFromLowToHigh(products);
                                break;

                            case 3:
                                productManager.sortByName(products);
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
