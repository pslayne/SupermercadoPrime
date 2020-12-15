package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import Model.VO.*;
import Model.BO.*;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
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
	@FXML private ImageView expand;
	@FXML private ImageView add;
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
	@FXML private Label erro;
	@FXML private ComboBox<String> pesquisac;
	
	ProdutosBO bo = new ProdutosBO();
	ProdutosVO prod = new ProdutosVO();
	ObservableList<ProdutosVO> itens = FXCollections.observableList(bo.listar()); 
	 
	public void initialize(URL arg0, ResourceBundle arg1) {
		erro.setVisible(false);
		
		Tooltip.install(pesquisab, new Tooltip("pesquisar"));
		Tooltip.install(delete, new Tooltip("excluir produto do estoque"));
		Tooltip.install(edit, new Tooltip("editar produto"));
		Tooltip.install(expand, new Tooltip("ver detalhes"));
		
		gerente.setText(Telas.getUser().getNome());
		
		inTabela();
		box();
	}
	
	public void inTabela() {	
	   	nome.setCellValueFactory(new PropertyValueFactory<ProdutosVO, String>("nome"));
	   	marca.setCellValueFactory(new PropertyValueFactory<ProdutosVO, String>("marca"));
	   	quantidade.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("quantidadeEstoque"));	    
	    codigo.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("codigo"));
    	
	   	produtos.setItems(itens); 	    	
	}
	
	public void box(){
		List<String> lista = new ArrayList<String>();
		lista.add("Código");
		lista.add("Marca");
		lista.add("Nome");
		
		pesquisac.setItems(FXCollections.observableList(lista));
	}
	
    public void pesquisar(MouseEvent m){
    	List<ProdutosVO> l;
		String selec = pesquisac.getSelectionModel().getSelectedItem();
		String pesq = pesquisa.getText();
		
		if(selec != null && pesq != null) {
			if(selec.equals("Código")) {
				prod.setCodigo(Integer.parseInt(pesq));
				prod = bo.buscarID(prod);
				
				l = new ArrayList<ProdutosVO>();
				l.add(prod);
				
				itens = FXCollections.observableList(l);
				produtos.setItems(itens);
			} else if (selec.equals("Marca")) {
				prod.setMarca(pesq);
				l = bo.buscarMarca(prod);
				itens = FXCollections.observableList(l);
				produtos.setItems(itens);
			} else if (selec.contentEquals("Nome")) {
				prod.setNome(pesq);
				l = bo.buscarNome(prod);
				itens = FXCollections.observableList(l);
				produtos.setItems(itens);
			}
		} else {
			erro.setText("selecione o tipo de pesquisa");
			erro.setVisible(true);
		}
	}
    
    public void deletar(MouseEvent m){
    	prod = produtos.getSelectionModel().getSelectedItem();
    	
    	if(prod != null) {
    		Telas.setPsel(prod);
    		ControllerPopupConfirmar.setControl(2);
    		Telas.popupConfirmar();
    	} else {
    		erro.setText("selecione uma linha da tabela");
    		erro.setVisible(true);
    	}
   	}
    
    public void editar(MouseEvent m){
    	prod = produtos.getSelectionModel().getSelectedItem();
    	if(prod != null) {
			Telas.setPsel(prod);
			Telas.telaEstoqueEdit();
    	} else {
    		erro.setText("selecione uma linha da tabela");
    		erro.setVisible(true);
    	}
   	}
    
    public void adicionar(MouseEvent m){
    	ControllerEstoqueEdit.setAdicionar(true);
    	Telas.telaEstoqueEdit();
   	}
    
    public void verDetalhes(MouseEvent m){
    	prod = produtos.getSelectionModel().getSelectedItem();
    	if(prod != null) {
			Telas.setPsel(prod);
			Telas.telaEstoqueEdit();
    	} else {
    		erro.setText("selecione uma linha da tabela");
    		erro.setVisible(true);
    	}
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
