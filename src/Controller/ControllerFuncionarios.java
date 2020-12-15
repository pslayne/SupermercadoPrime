package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
import Model.VO.*;
import Model.BO.*;

public class ControllerFuncionarios implements Initializable{
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
	@FXML private TableView <FuncionariosVO> tbfuncionarios;
	@FXML private TableColumn <FuncionariosVO, Integer> id_funcionario;
	@FXML private TableColumn <FuncionariosVO, String> cargo;
	@FXML private TableColumn <FuncionariosVO, String> cpf;
	@FXML private TableColumn <FuncionariosVO, String> nome;
	@FXML private TableColumn <FuncionariosVO, String> email;
	@FXML private Label erroSelec;
	@FXML private Label gerente;
	@FXML private ComboBox<String> pesquisac;
	
	ObservableList<FuncionariosVO> itens;
	FuncionariosBO bo = new FuncionariosBO();
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(pesquisab, new Tooltip("pesquisar"));
		Tooltip.install(delete, new Tooltip("excluir produto do estoque"));
		Tooltip.install(edit, new Tooltip("editar produto"));
		Tooltip.install(expandir, new Tooltip("ver detalhes"));
		
		gerente.setText(Telas.getUser().getNome());
		
		inTabela();	
		box();
	}
	
	public void inTabela() {
	    cpf.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, String>("cpf"));
	   	cargo.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, String>("cargoS"));
	   	nome.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, String>("nome"));
	   	email.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, String>("email"));
	    id_funcionario.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, Integer>("codigo"));
	    
	   	itens = FXCollections.observableArrayList(bo.listar());	
	   	tbfuncionarios.setItems(itens); 
	}
	
	public void box() {
		List<String> lista = new ArrayList<String>();
		lista.add("ID");
		lista.add("Nome");
		lista.add("Cargo");
		lista.add("CPF");
		
		ObservableList<String> ob = FXCollections.observableArrayList(lista);
		pesquisac.setItems(ob);
	}
	
	public void pesquisar(MouseEvent m){
		String selec = pesquisac.getSelectionModel().getSelectedItem();
		String pesq = pesquisa.getText();
		
		if(selec != null && pesq != null) {
			FuncionariosVO vo = new FuncionariosVO();
			if(selec.equals("ID")) {
				int id = Integer.parseInt(pesq);
				vo.setCodigo(id);
				itens = FXCollections.observableArrayList(bo.buscarID(vo));	
				tbfuncionarios.setItems(itens);
			} else if(selec.equals("Nome")) {
				vo.setNome(pesq);
				itens = FXCollections.observableArrayList(bo.buscarNome(vo));	
				tbfuncionarios.setItems(itens);
			} else if(selec.equals("Cargo")) {
				CargoVO c = new CargoVO();
				c.setNome(pesq);
				vo.setCargo(c);
				
				itens = FXCollections.observableArrayList(bo.buscarCargo(vo));	
				tbfuncionarios.setItems(itens);
			} else if(selec.equals("CPF")) {
				vo.setCpf(pesq);
				itens = FXCollections.observableArrayList(bo.buscarCPF(vo));	
				tbfuncionarios.setItems(itens);
			}
		} else {
			erroSelec.setText("selecione um tipo de pesquisa");
			erroSelec.setVisible(true);
		}
	}
	
	public void deletar(MouseEvent m){
		ControllerPopupConfirmar.setControl(1);
		Telas.setFsel(tbfuncionarios.getSelectionModel().getSelectedItem());
    	Telas.popupConfirmar();
	}
	
	public void editar(MouseEvent m){
		if(tbfuncionarios.getSelectionModel().getSelectedItem() != null) {
			Telas.setFsel(tbfuncionarios.getSelectionModel().getSelectedItem());
			Telas.telaFuncionariosEdit();
		} else {
			erroSelec.setText("selecione uma linha da tabela");
			erroSelec.setVisible(true);
		}
	}
	
	public void adicionar(MouseEvent m) {
		ControllerFuncionariosEdit.setAdicionar(true);
		Telas.telaFuncionariosEdit();
	}
	
	public void expandirFuncionario(MouseEvent m){
		if(tbfuncionarios.getSelectionModel().getSelectedItem() != null) {
			Telas.setFsel(tbfuncionarios.getSelectionModel().getSelectedItem());
			Telas.telaFuncionariosEdit();
		} else {
			erroSelec.setText("selecione uma linha da tabela");
			erroSelec.setVisible(true);
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
