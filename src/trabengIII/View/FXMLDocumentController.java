package trabengIII.View;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import trabengIII.Control.ControlCliente;
import trabengIII.Control.ControlMarcaProduto;
import trabengIII.Control.ControlMedidaProduto;
import trabengIII.Control.ControlOperacao;
import trabengIII.Control.ControlRecipienteProduto;
import trabengIII.Control.ControlTipoProduto;
import trabengIII.DAL.DALCliente;
import trabengIII.DAL.DALMedida;
import trabengIII.DAL.DALRecepiente;
import trabengIII.DAL.DALTipo;
import trabengIII.Entity.Cliente;
import trabengIII.Entity.ItensVenda;
import trabengIII.Entity.MarcaProduto;
import trabengIII.Entity.Produto;
import trabengIII.Entity.RecipienteProduto;
import trabengIII.Entity.TipoProduto;
import trabengIII.Entity.UnidadeMedida;

public class FXMLDocumentController implements Initializable 
{    
    private Label label;
    @FXML
    private Button btMinizar;
    @FXML
    private Button btFechar;
    @FXML
    private JFXButton btFavoritar;
    @FXML
    private TableView<ItensVenda> tvItensCompra;
    @FXML
    private JFXComboBox<MarcaProduto> cbMarca;
    @FXML
    private JFXComboBox<TipoProduto> cbTipo;
    @FXML
    private JFXComboBox<UnidadeMedida> cbMedida;
    @FXML
    private JFXComboBox<RecipienteProduto> cbRecipiente;
    @FXML
    private JFXComboBox<Cliente> cbCliente;
    @FXML
    private JFXButton btInserir;
    @FXML
    private JFXButton btRemover;
    @FXML
    private TableView<Produto> tvLeite;
    @FXML
    private JFXComboBox<String> cbTipoPagamento;
    @FXML
    private JFXButton btLimpar;
    @FXML
    private JFXButton btComprar;
    @FXML
    private BorderPane bpPrincipal;
    @FXML
    private TableColumn<Produto, String> colNome;
    @FXML
    private TableColumn<Produto, Double> colPreco;
    @FXML
    private TableColumn<Produto, String> colMarca;
    @FXML
    private TableColumn<Produto, String> colTipo;
    @FXML
    private TableColumn<Produto, String> colRecipiente;
    @FXML
    private TableColumn<ItensVenda, String> colNomeC;
    @FXML
    private TableColumn<ItensVenda, Integer> colQuantidadeC;
    
    ControlMarcaProduto ctrlMar;
    ControlMedidaProduto ctrlMed;
    ControlRecipienteProduto ctrlRec;
    ControlTipoProduto ctrlTip;
    ControlCliente ctrlCli;
    ControlOperacao ctrlOpe;
    
    private void inicializarCBs() {
        
        ArrayList<String> tp = new ArrayList<>();
        tp.add("Crédito");
        tp.add("Débito");
        tp.add("Boleto");
        cbTipoPagamento.setItems(FXCollections.observableArrayList(tp));
        
        cbMarca.setItems(FXCollections.observableArrayList(ctrlMar.getMarcaTodos()));
        cbTipo.setItems(FXCollections.observableArrayList(new DALTipo().get("")));
        cbMedida.setItems(FXCollections.observableArrayList(new DALMedida().get("")));
        cbRecipiente.setItems(FXCollections.observableArrayList(new DALRecepiente().get("")));
        cbCliente.setItems(FXCollections.observableArrayList(new DALCliente().get("")));
        
        cbMarca.getSelectionModel().select(0);
        cbTipo.getSelectionModel().select(0);
        cbMedida.getSelectionModel().select(0);
        cbRecipiente.getSelectionModel().select(0);
        cbCliente.getSelectionModel().select(0);
    }
    
    private void iniciarTable() {
        colNome.setCellValueFactory(new PropertyValueFactory("pro_nome"));
        colPreco.setCellValueFactory(new PropertyValueFactory("pro_preco"));
        colMarca.setCellValueFactory((TableColumn.CellDataFeatures<Produto, String> p) -> new SimpleStringProperty(p.getValue().getMar_pro().getMar_descricao()));
        colTipo.setCellValueFactory((TableColumn.CellDataFeatures<Produto, String> p) -> new SimpleStringProperty(p.getValue().getTip_pro().getTip_descricao()));
        colRecipiente.setCellValueFactory((TableColumn.CellDataFeatures<Produto, String> p) -> new SimpleStringProperty(p.getValue().getRec_pro().getRec_descricao()));
        
        colQuantidadeC.setCellFactory(new PropertyValueFactory("qtd"));
        colNomeC.setCellValueFactory((TableColumn.CellDataFeatures<ItensVenda, String> p) -> new SimpleStringProperty(p.getValue().getProd().getPro_nome()));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ctrlMar = new ControlMarcaProduto();
        ctrlCli = new ControlCliente();
        ctrlMed = new ControlMedidaProduto();
        ctrlRec = new ControlRecipienteProduto();
        ctrlTip = new ControlTipoProduto();
        ctrlOpe = new ControlOperacao();
        
        inicializarCBs();
        iniciarTable();
    }    

    @FXML
    private void clkMinimiar(ActionEvent event) {
        ((Stage)(btMinizar.getParent().getScene().getWindow())).setIconified(true);
    }

    @FXML
    private void clkFechar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void clkFavoritar(ActionEvent event) {
        try {
            Parent root;
            root = FXMLLoader.load(getClass().getResource("FXMLTelaFavorito.fxml"));
            bpPrincipal.setCenter(root);
        }
        catch(IOException exc) {System.out.println(exc);}
    }

    @FXML
    private void clkMarca(ActionEvent event) {
        tvLeite.setItems(FXCollections.observableArrayList(ctrlMar.dalP(cbMarca.getSelectionModel().getSelectedItem(), cbRecipiente.getSelectionModel().getSelectedItem(), cbTipo.getSelectionModel().getSelectedItem(), cbMedida.getSelectionModel().getSelectedItem())));
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
    private void clkCliente(ActionEvent event) {
    }

    @FXML
    private void clkInserir(ActionEvent event) {
        int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade:"));
        Produto pro = tvLeite.getSelectionModel().getSelectedItem();
        ctrlOpe.adicionarItemVenda(qtd, pro);
        
        tvItensCompra.setItems(FXCollections.observableArrayList(ctrlOpe.retornarItensVenda()));
    }

    @FXML
    private void clkRemover(ActionEvent event) {
    }

    @FXML
    private void clkLimpar(ActionEvent event) {
        tvItensCompra.getItems().clear();
    }

    @FXML
    private void clkComprar(ActionEvent event) {
    }

    
}
