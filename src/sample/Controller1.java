package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Controller1 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane khungduoi;

    @FXML
    private AnchorPane khungtren;

    @FXML
    private Label qlsp;

    @FXML
    private Label tendangnhap;

    @FXML
    private AnchorPane vienduoi;

    @FXML
    private TextField getUsername;

    @FXML
    private TextField getPass;

    @FXML
    private Label userName;

    @FXML
    private Label password;

    @FXML
    private Button loginButton;

    @FXML
    void loginAdmin(MouseEvent event) throws IOException {
        String username = getUsername.getText();
        String password = getPass.getText();

        if (username.equals("admin") && password.equals("admin")) {
            Parent root = FXMLLoader.load(getClass().getResource("../View/QLSP.fxml"));

            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            System.out.println("ReEnter");
        }
    }

    @FXML
    void initialize() {
        assert khungduoi != null : "fx:id=\"khungduoi\" was not injected: check your FXML file 'Login.fxml'.";
        assert khungtren != null : "fx:id=\"khungtren\" was not injected: check your FXML file 'Login.fxml'.";
        assert qlsp != null : "fx:id=\"qlsp\" was not injected: check your FXML file 'Login.fxml'.";
        assert tendangnhap != null : "fx:id=\"tendangnhap\" was not injected: check your FXML file 'Login.fxml'.";
        assert vienduoi != null : "fx:id=\"vienduoi\" was not injected: check your FXML file 'Login.fxml'.";
        assert getUsername != null : "fx:id=\"getUsername\" was not injected: check your FXML file 'Login.fxml'.";
        assert getPass != null : "fx:id=\"getPass\" was not injected: check your FXML file 'Login.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file 'Login.fxml'.";
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'Login.fxml'.";

    }
}