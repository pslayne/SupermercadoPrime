package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import Model.VO.*;
import Model.BO.*;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerEstoque  implements Initializable{
	
	@FXML private TextField pesquisa;
	@FXML private ImageView pesquisab;
	@FXML private ImageView delete;
	@FXML private ImageView edit;
	@FXML private ImageView expandir;
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	@FXML private TableView <ProdutosVO> produtos;
	@FXML private TableColumn <ProdutosVO, Integer> codigo;
	@FXML private TableColumn <ProdutosVO, String> nome;
	@FXML private TableColumn <ProdutosVO, String> marca;
	@FXML private TableColumn <ProdutosVO, Integer> quantidade;
	@FXML private Label erroSelec;
	@FXML private Label gerente;
	 
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(pesquisab, new Tooltip("pesquisar"));
		Tooltip.install(delete, new Tooltip("excluir produto do estoque"));
		Tooltip.install(edit, new Tooltip("editar produto"));
		Tooltip.install(expandir, new Tooltip("ver detalhes"));
		
		gerente.setText(Telas.getUser().getNome());
		
		inTabela();
	}
	
	public void inTabela() {	

	   	nome.setCellValueFactory(new PropertyValueFactory<ProdutosVO, String>("nome"));
	   	marca.setCellValueFactory(new PropertyValueFactory<ProdutosVO, String>("marca"));
	   	quantidade.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("quantidadeEstoque"));	    
	   codigo.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("codigo"));
    	
	   	produtos.setItems(itens()); 	    	
	}
	
	public ObservableList<ProdutosVO> itens() {
		ProdutosBO bo = new ProdutosBO();
		return FXCollections.observableList(bo.listar());
	}
	
    public void pesquisar(MouseEvent m){
		
	}
    
    public void deletar(MouseEvent m){
		
   	}
    
    public void editar(MouseEvent m){
		
   	}
    
    public void adicionar(MouseEvent m){
		
   	}
    
    public void verDetalhes(MouseEvent m){
		
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
