/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabengIII.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Guilherme Azevedo
 */
public class FXMLTelaFavoritoController implements Initializable {

    @FXML
    private Button btMinizar;
    @FXML
    private Button btFechar;
    @FXML
    private JFXComboBox<?> cbCliente;
    @FXML
    private JFXComboBox<?> cbTipoProd;
    @FXML
    private JFXButton btFavoritar;
    @FXML
    private TableView<?> tvItensCompra;
    @FXML
    private JFXButton btRemover;
    @FXML
    private JFXComboBox<?> cbtpProduto;
    @FXML
    private JFXTextField txtDesconto;
    @FXML
    private JFXButton btDesconto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkMinimiar(ActionEvent event) {
    }

    @FXML
    private void clkFechar(ActionEvent event) {
    }

    @FXML
    private void CarregaFavoritos(ActionEvent event) {
    }

    @FXML
    private void clkFavoritar(ActionEvent event) {
    }

    @FXML
    private void clkRemover(ActionEvent event) {
    }

    @FXML
    private void clkDarDesconto(ActionEvent event) {
    }
    
}
