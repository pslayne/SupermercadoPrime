package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import View.Telas;
import Model.VO.ComprasVO;
import Model.BO.ComprasBO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCompras {
	@FXML private TextField pesquisa;
	@FXML private ImageView pesquisab;
	@FXML private ImageView expandir;
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	@FXML private TableView <ComprasVO> tabelaCompras;
	@FXML private TableColumn <ComprasVO, Integer> id_compra;
	@FXML private TableColumn <ComprasVO, Integer> codProduto;
	@FXML private TableColumn <ComprasVO, Integer> quantidade;
	@FXML private TableColumn <ComprasVO, Double> valor;
	@FXML private TableColumn <ComprasVO, String> dataS;
	@FXML private TableColumn <ComprasVO, String> horaS;
	@FXML private TableColumn <ComprasVO, Integer> ID_Funcionario;
	@FXML private Label erroSelec;
	@FXML private Label gerente;
	
	
	ComprasBO bo = new ComprasBO();
	void initialize(URL arg0, ResourceBundle arg1) {
		gerente.setText(Telas.getUser().getNome());
		Tooltip.install(pesquisab, new Tooltip("pesquisar"));
		Tooltip.install(expandir, new Tooltip("ver detalhes da compra"));
		inTabela();
	}
		
	public void inTabela() {
			ObservableList<ComprasVO> compras = FXCollections.observableArrayList(bo.listar());
			
	    	id_compra.setCellValueFactory(new PropertyValueFactory<ComprasVO, Integer>("codigo"));
		    codProduto.setCellValueFactory(new PropertyValueFactory<ComprasVO, Integer>("produtos"));
		    quantidade.setCellValueFactory(new PropertyValueFactory<ComprasVO, Integer>("quantidadeProdutos"));
		    valor.setCellValueFactory(new PropertyValueFactory<ComprasVO, Double>("valor"));
		    dataS.setCellValueFactory(new PropertyValueFactory<ComprasVO, String>("dataS"));
		    horaS.setCellValueFactory(new PropertyValueFactory<ComprasVO, String>("horaS"));
		    ID_Funcionario.setCellValueFactory(new PropertyValueFactory<ComprasVO, Integer>("gerente"));
		    tabelaCompras.setItems(compras); 
	}
	
	public void pesquisar(MouseEvent m){
		
	}
	
	public void expandirCompra(MouseEvent m){
		
	}
	
	public void goInicio(ActionEvent e) {
		Telas.telaInicial();
	}
	
	public void goVendas(ActionEvent e) {
		Telas.telaVendas();
	}
	
	public void goFuncionarios(ActionEvent e) {
		Telas.telaFuncionarios();
	}
	
	public void goEstoque(ActionEvent e) {
		Telas.telaEstoque();
	}
	
	public void goCompras(ActionEvent e) {
		Telas.telaCompras();
	}
	
	public void goLogin(ActionEvent e) {
		Telas.telaLogin();
	}
}
