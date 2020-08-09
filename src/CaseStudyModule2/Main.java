package CaseStudyModule2;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        CrawlData crawlData = new CrawlData();
        ArrayList<Product> products = new ArrayList<>();

        int choice = -1;
        Scanner input = new Scanner(System.in);
        while (choice != 0) {
            System.out.println("ProductManager");
            System.out.println("1. Add products");
            System.out.println("2. Edit products");
            System.out.println("3. Delete products");
            System.out.println("4. Search products");
            System.out.println("5. Sort products");
            System.out.println("6. Save products to file");
            System.out.println("7. Load products from file");
            System.out.println("8. Display products");
            System.out.println("0. Exit");
            System.out.println("Enter your choice");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    productManager.addProduct(products);
                    break;
                case 2:
                    int choice2 = -1;
                    Scanner input2 = new Scanner(System.in);
                    while (choice2 != 0) {
                        System.out.println("Options");
                        System.out.println("1. Edit name products");
                        System.out.println("2. Edit id products");
                        System.out.println("3. Edit price products");
                        System.out.println("4. Edit brand products");
                        System.out.println("0. Back to options");
                        System.out.println("Enter your choice");
                        choice2 = input2.nextInt();

                        switch (choice2) {
                            case 1:
                                productManager.editProductByName(products);
                                break;
                            case 2:
                                productManager.editProductById(products);
                                break;
                            case 3:
                                productManager.editProductByPrice(products);
                                break;
                            case 4:
                                productManager.editProductByBrand(products);
                                break;
                            case 0:
                                choice2 =0;break;
                            default:
                                System.out.println("No choice!");
                        }
                    }
                    break;
                case 3:
                    productManager.deleteProduct(products);
                    break;
                case 4:
                    productManager.searchProduct(products);
                    break;
                case 5:
                    int choice5 = -1;
                    Scanner input5 = new Scanner(System.in);
                    while (choice5 != 0) {
                        System.out.println("Options");
                        System.out.println("1. Sort by price from high to low");
                        System.out.println("2. Sort by price from low to high");
                        System.out.println("3. Sort by name");
                        System.out.println("0. Back to options");
                        System.out.println("Enter your choice");
                        choice5 = input5.nextInt();

                        switch (choice5) {
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
                                choice5 = 0;
                                break;
                            default:
                                System.out.println("No choice!");
                        }
                    }
                    break;
                case 6:
                    productManager.writeProductList(products);
                    break;
                case 7:
                    products = productManager.readProductList("C:\\Users\\LENOVO\\IdeaProjects\\Case2\\src\\File\\Product.txt");
                    break;
                case 8:
                    productManager.displayProducts(products);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
