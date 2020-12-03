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
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import trabengIII.Control.ControlCliente;
import trabengIII.Control.ControlTipoProduto;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.Favorito;
import trabengIII.Entity.TipoProduto;

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
    private JFXComboBox<Cliente> cbCliente;
    @FXML
    private JFXComboBox<TipoProduto> cbTipoProd;
    @FXML
    private JFXButton btFavoritar;
    @FXML
    private TableView<Favorito> tvItensCompra;
    @FXML
    private JFXButton btRemover;
    @FXML
    private JFXComboBox<TipoProduto> cbtpProduto;
    @FXML
    private JFXTextField txtDesconto;
    @FXML
    private JFXButton btDesconto;
    
    private ControlTipoProduto controlTipo;
    private ControlCliente controlCli;
    @FXML
    private TableColumn<Favorito, String> colCli;
    @FXML
    private TableColumn<Favorito, String> colTipo;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        controlTipo = new ControlTipoProduto();
        controlCli = new ControlCliente();
        
        carregarComboBox();
    }    

    public void carregarComboBox(){
        
        cbTipoProd.setItems(controlTipo.retornarTipos());
        cbCliente.setItems(controlCli.retornarLista());
        cbtpProduto.setItems(controlTipo.retornarTipos());
    }
    
    public void carregarTabela(){
        
       colCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTip().getTip_descricao()));
       colTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCli().getCli_nome()));     
       
    }
            
            
    @FXML
    private void clkMinimiar(ActionEvent event) {
    }

    @FXML
    private void clkFechar(ActionEvent event) {
    }

    @FXML
    private void CarregaFavoritos(ActionEvent event) {
        
         tvItensCompra.setItems(FXCollections.observableArrayList(controlTipo.retornarListFav(cbTipoProd.getSelectionModel().getSelectedIndex())));
    }

    @FXML
    private void clkFavoritar(ActionEvent event) {
        
        controlTipo.adicionarFavorito(cbTipoProd.getSelectionModel().getSelectedIndex(), cbCliente.getSelectionModel().getSelectedItem());
        CarregaFavoritos(event);
    }

    @FXML
    private void clkRemover(ActionEvent event) {
        
        Favorito fav = tvItensCompra.getSelectionModel().getSelectedItem();
        controlTipo.removerFavorito(fav.getTip(), fav.getCli());
         CarregaFavoritos(event);
    }

    @FXML
    private void clkDarDesconto(ActionEvent event) {
        
        Alert a;
        
        String mensagem = controlTipo.notificaTodos(cbtpProduto.getSelectionModel().getSelectedIndex());
        
        a = new Alert(Alert.AlertType.INFORMATION, mensagem, ButtonType.OK);
        
        a.showAndWait();
    }
    
}
