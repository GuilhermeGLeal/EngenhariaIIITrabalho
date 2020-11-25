package trabengIII.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class FXMLDocumentController implements Initializable 
{    
    private Label label;
    @FXML
    private Button btMinizar;
    @FXML
    private Button btFechar;
    @FXML
    private JFXComboBox<?> cbMarca;
    @FXML
    private JFXComboBox<?> cbTipo;
    @FXML
    private JFXComboBox<?> cbMedida;
    @FXML
    private JFXComboBox<?> cbRecipiente;
    @FXML
    private JFXButton btFavoritar;
    @FXML
    private JFXButton btInserir;
    @FXML
    private JFXButton btRemover;
    @FXML
    private TableView<?> tvLeite;
    @FXML
    private TableView<?> tvItensCompra;
    @FXML
    private JFXComboBox<?> cbTipoPagamento;
    @FXML
    private JFXButton btLimpar;
    @FXML
    private JFXButton btComprar;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void clkMinimiar(ActionEvent event) {
    }

    @FXML
    private void clkFechar(ActionEvent event) {
    }

    @FXML
    private void clkMarca(ActionEvent event) {
    }

    @FXML
    private void clkTipo(ActionEvent event) {
    }

    @FXML
    private void clkMedida(ActionEvent event) {
    }

    @FXML
    private void clkRecipiente(ActionEvent event) {
    }

    @FXML
    private void clkFavoritar(ActionEvent event) {
    }

    @FXML
    private void clkInserir(ActionEvent event) {
    }

    @FXML
    private void clkRemover(ActionEvent event) {
    }

    @FXML
    private void clkLimpar(ActionEvent event) {
    }

    @FXML
    private void clkComprar(ActionEvent event) {
    }
    
}
