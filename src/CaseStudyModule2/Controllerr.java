package CaseStudyModule2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField ProductNameTextfield;

    @FXML
    private TextField ProductPriceTextField;

    @FXML
    private TextField ProductIDTextField;

    @FXML
    private TextField ProductBrandTextField;

    @FXML
    private Button AddButton;

    @FXML
    private Button EditButton;

    @FXML
    private Button DelButton;

    @FXML
    private Button SaveButton;

    @FXML
    private TableView<?> ProductManagerTableview;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField SearchTextField;

    @FXML
    void backToMain(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ProductNameTextfield != null : "fx:id=\"ProductNameTextfield\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert ProductPriceTextField != null : "fx:id=\"ProductPriceTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert ProductIDTextField != null : "fx:id=\"ProductIDTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert ProductBrandTextField != null : "fx:id=\"ProductBrandTextField\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert AddButton != null : "fx:id=\"AddButton\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert EditButton != null : "fx:id=\"EditButton\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert DelButton != null : "fx:id=\"DelButton\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert SaveButton != null : "fx:id=\"SaveButton\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert ProductManagerTableview != null : "fx:id=\"ProductManagerTableview\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'QLSP.fxml'.";
        assert SearchTextField != null : "fx:id=\"SearchTextField\" was not injected: check your FXML file 'QLSP.fxml'.";

    }
}