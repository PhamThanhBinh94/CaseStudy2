package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import CaseStudyModule2.Product;
import CaseStudyModule2.ProductManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller  implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane background;

    @FXML
    private AnchorPane header;

    @FXML
    private Label labelQLSP;

    @FXML
    private Button AddButton1;

    @FXML
    private TextField ProductNameTextfield;

    @FXML
    private TextField ProductPriceTextField;

    @FXML
    private TextField ProductIDTextField;

    @FXML
    private TextField ProductBrandTextField;

    @FXML
    private TextField ProductAmountTextField;

    @FXML
    private Button AddButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button DelButton;

    @FXML
    private Button SaveButton;

    @FXML
    private TableView<Product> ProductManagerTableview;

    @FXML
    private TableColumn<Product, String> nameProductColumn;

    @FXML
    private TableColumn<Product, String> idProductColumn;

    @FXML
    private TableColumn<Product, String> brandProductColumn;

    @FXML
    private TableColumn<Product, Double> priceProductColumn;

    @FXML
    private TableColumn<Product, Integer> amountProductColumn;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    private ObservableList<Product> products;

    private ArrayList<Product> listProduct = new ArrayList<>();
    private ProductManager productManager = new ProductManager();
    private final String path = "C:\\Users\\LENOVO\\IdeaProjects\\Case2\\src\\File\\Product.txt";

//    @FXML
//    void initialize() {
//        assert background != null : "fx:id=\"background\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert header != null : "fx:id=\"header\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert labelQLSP != null : "fx:id=\"labelQLSP\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert AddButton1 != null : "fx:id=\"AddButton1\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert ProductNameTextfield != null : "fx:id=\"ProductNameTextfield\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert ProductPriceTextField != null : "fx:id=\"ProductPriceTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert ProductIDTextField != null : "fx:id=\"ProductIDTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert ProductBrandTextField != null : "fx:id=\"ProductBrandTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert EditButton != null : "fx:id=\"EditButton\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert DelButton != null : "fx:id=\"DelButton\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert SaveButton != null : "fx:id=\"SaveButton\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert ProductManagerTableview != null : "fx:id=\"ProductManagerTableview\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert nameProductColumn != null : "fx:id=\"nameProductColumn\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert idProductColumn != null : "fx:id=\"idProductColumn\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert brandProductColumn != null : "fx:id=\"brandProductColumn\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert priceProductColumn != null : "fx:id=\"priceProductColumn\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'QLSP.fxml'.";
//        assert SearchTextField != null : "fx:id=\"SearchTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
//
//    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProductManagerTableview.setEditable(true);

        nameProductColumn.setCellValueFactory(new PropertyValueFactory<Product ,String >("name"));
        nameProductColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        idProductColumn.setCellValueFactory(new PropertyValueFactory<Product ,String >("id"));
        idProductColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        brandProductColumn.setCellValueFactory(new PropertyValueFactory<Product ,String >("brand"));
        brandProductColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        priceProductColumn.setCellValueFactory(new PropertyValueFactory<Product ,Double >("price"));
//        priceProductColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());
        amountProductColumn.setCellValueFactory(new PropertyValueFactory<Product ,Integer >("amount"));
//        amountProductColumn.setCellFactory(TextFieldTableCell.<Product>forTableColumn());

        nameProductColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> event)-> {
            TablePosition<Product, String> pos = event.getTablePosition();

            String newProductName = event.getNewValue();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row);

            product.setName(newProductName);
        });
        idProductColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> event)-> {
            TablePosition<Product, String> pos = event.getTablePosition();

            String newProductId = event.getNewValue();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row);

            product.setId(newProductId);
        });
        brandProductColumn.setOnEditCommit((TableColumn.CellEditEvent<Product, String> event)-> {
            TablePosition<Product, String> pos = event.getTablePosition();

            String newProductBrand = event.getNewValue();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row);

            product.setBrand(newProductBrand);
        });

        listProduct = productManager.readProductList(path);
        products = FXCollections.observableArrayList(listProduct);
        ProductManagerTableview.setItems(products);
        ProductManagerTableview.getColumns().addAll(nameProductColumn,idProductColumn,brandProductColumn,priceProductColumn,amountProductColumn);
    }

    public void addProduct(MouseEvent mouseEvent) {
        String name = ProductNameTextfield.getText();
        String id = ProductIDTextField.getText();
        String brand = ProductBrandTextField.getText();
        String price = ProductPriceTextField.getText();
        String amount = ProductAmountTextField.getText();
        Product product = new Product(name,id,Double.parseDouble(price),brand,Integer.parseInt(amount));

        listProduct.add(product);
        products = FXCollections.observableArrayList(listProduct);
        ProductManagerTableview.setItems(products);
    }

    public void deleteProduct(MouseEvent mouseEvent) {
        Product product = ProductManagerTableview.getSelectionModel().getSelectedItem();
        listProduct.remove(product);
        products = FXCollections.observableArrayList(listProduct);
        ProductManagerTableview.setItems(products);
    }

    public void saveToFile(MouseEvent mouseEvent) {
        productManager.writeProductList(listProduct);
    }

    public void editProduct(MouseEvent mouseEvent) {
        Product product = ProductManagerTableview.getSelectionModel().getSelectedItem();
        ProductNameTextfield.setText(product.getName());
        ProductIDTextField.setText(product.getId());
        ProductBrandTextField.setText(product.getBrand());
        ProductPriceTextField.setText(String.valueOf(product.getPrice()));
    }

    public void backToMain(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));

        Stage primaryStage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void searchProduct(MouseEvent mouseEvent) {
        String id = SearchTextField.getText();

        for (Product product: listProduct){
            if (id.equals(product.getId())){
                products = FXCollections.observableArrayList(product);
                ProductManagerTableview.setItems(products);
            }
        }
    }

    public void startSearch(MouseEvent mouseEvent) {
        listProduct = productManager.readProductList(path);
        products = FXCollections.observableArrayList(listProduct);
        ProductManagerTableview.setItems(products);
    }
}
