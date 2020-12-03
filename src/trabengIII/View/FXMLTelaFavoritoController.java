package trabengIII.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import trabengIII.Control.ControlCliente;
import trabengIII.Control.ControlTipoProduto;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.Favorito;
import trabengIII.Entity.TipoProduto;


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
        carregarTabela();
        
        cbCliente.getSelectionModel().select(0);
        cbTipoProd.getSelectionModel().select(0);
        cbtpProduto.getSelectionModel().select(0);
        
        CarregaFavoritos(null);
        
        
    }    

    public void carregarComboBox(){
        
        cbTipoProd.setItems(controlTipo.retornarTipos());
        cbCliente.setItems(controlCli.retornarLista());
        cbtpProduto.setItems(controlTipo.retornarTipos());
    }
    
    public void carregarTabela(){
        
       colCli.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCli().getCli_nome()));
       colTipo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTip().getTip_descricao()));     
    
    }
            
            
    @FXML
    private void clkMinimiar(ActionEvent event) {
         ((Stage)(btMinizar.getParent().getScene().getWindow())).setIconified(true);
    }

    @FXML
    private void clkFechar(ActionEvent event) {
           try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLTelaFavorito.fxml"));
            FXMLDocumentController.bpprin.setCenter(root);
        
        }
        catch(IOException exc) {System.out.println(exc);}
    }

    @FXML
    private void CarregaFavoritos(ActionEvent event) {
       
         ObservableList<Favorito> favs;
      
        
        favs = controlTipo.retornarListFav(cbTipoProd.getSelectionModel().getSelectedItem());
        
         tvItensCompra.setItems(favs);
    }

    @FXML
    private void clkFavoritar(ActionEvent event) {
        
        boolean res;
        res = controlTipo.adicionarFavorito(cbTipoProd.getSelectionModel().getSelectedItem(), cbCliente.getSelectionModel().getSelectedItem());
        
        if(!res){
            Alert a = new Alert(Alert.AlertType.ERROR, "Tipo: "+cbTipoProd.getSelectionModel().getSelectedItem().getTip_descricao()+" e Cliente: "+
                    cbCliente.getSelectionModel().getSelectedItem().getCli_nome()+" já estão favoritados!!"
                    , ButtonType.OK);
            
            a.showAndWait();
        }
        else{
            CarregaFavoritos(event); 
            cbtpProduto.setItems(controlTipo.retornarTipos());
        }
        
    }

    @FXML
    private void clkRemover(ActionEvent event) {
        
        Favorito fav = tvItensCompra.getSelectionModel().getSelectedItem();
        controlTipo.removerFavorito(fav.getTip(), fav.getCli());
        CarregaFavoritos(event);
          cbtpProduto.setItems(controlTipo.retornarTipos());
    }

    @FXML
    private void clkDarDesconto(ActionEvent event) {
        
        Alert a;
        
        String mensagem = controlTipo.notificaTodos(cbtpProduto.getSelectionModel().getSelectedItem(), Double.parseDouble(txtDesconto.getText()));
        
        a = new Alert(Alert.AlertType.INFORMATION, mensagem, ButtonType.OK);
        
        a.showAndWait();
    }
    
}
