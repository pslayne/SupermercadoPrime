package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import Model.VO.*;
import Model.BO.*;

public class ControllerFuncionarios implements Initializable{
	@FXML private TextField pesquisa;
	@FXML private ImageView pesquisab;
	@FXML private ImageView delete;
	@FXML private ImageView edit;
	@FXML private ImageView add;
	@FXML private ImageView out;
	@FXML private ImageView print;
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
	@FXML private TableView <FuncionariosVO> tbEx;
	@FXML private TableColumn <FuncionariosVO, Integer> idEx;
	@FXML private TableColumn <FuncionariosVO, String> nomeEx;
	@FXML private TableColumn <FuncionariosVO, String> dataDemissao;
	@FXML private Label erroSelec;
	@FXML private Label gerente;
	@FXML private ComboBox<String> pesquisac;
	@FXML private Button exfunc;
	@FXML private Button atual;
	@FXML private TableView<Atualizacao> atualizacoes;
	@FXML private TableColumn<Atualizacao, String> dataAt;
	@FXML private TableColumn<Atualizacao, String> modificacao;
	
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
	   	
	   	nomeEx.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, String>("nome"));
		idEx.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, Integer>("codigo"));
		dataDemissao.setCellValueFactory(new PropertyValueFactory<FuncionariosVO, String>("dataDemissao"));
		
		tbEx.setItems(FXCollections.observableArrayList(bo.listarEx()));
		
		dataAt.setCellValueFactory(new PropertyValueFactory<Atualizacao, String>("data"));
		modificacao.setCellValueFactory(new PropertyValueFactory<Atualizacao, String>("operacao"));
		
		atualizacoes.setItems(FXCollections.observableArrayList(bo.listarAt()));
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
	
	public void showExfunc(ActionEvent e) {
		tbEx.setVisible(true);
		out.setVisible(true);
		
		pesquisa.setVisible(false);
		pesquisab.setVisible(false);
		pesquisac.setVisible(false);
		delete.setVisible(false);
		edit.setVisible(false);
		expandir.setVisible(false);
		tbfuncionarios.setVisible(false);
		exfunc.setVisible(false);
		add.setVisible(false);
		print.setVisible(false);
		atualizacoes.setVisible(false);
		atual.setVisible(false);
	}
	
	public void showAtual(ActionEvent e) {
		atualizacoes.setVisible(true);
		out.setVisible(true);
		
		
		pesquisa.setVisible(false);
		pesquisab.setVisible(false);
		pesquisac.setVisible(false);
		delete.setVisible(false);
		edit.setVisible(false);
		expandir.setVisible(false);
		tbfuncionarios.setVisible(false);
		exfunc.setVisible(false);
		add.setVisible(false);
		print.setVisible(false);
		tbEx.setVisible(false);
		atual.setVisible(false);
	}
	
	
	public void voltar() {
		tbEx.setVisible(false);
		out.setVisible(false);
		atualizacoes.setVisible(false);
		
		atual.setVisible(true);
		pesquisa.setVisible(true);
		pesquisab.setVisible(true);
		pesquisac.setVisible(true);
		delete.setVisible(true);
		edit.setVisible(true);
		expandir.setVisible(true);
		tbfuncionarios.setVisible(true);
		exfunc.setVisible(true);
		add.setVisible(true);
		print.setVisible(true);
	}
	
	public void relatCargos(){
		List <FuncionariosVO> funcionarios = bo.listar();
		Document doc = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
			
		if (file != null) {	
			try {
				PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
				doc.open();
				
				Paragraph par = new Paragraph("--- Relação de funcionários por cargo ---");
				par.setAlignment(1);
				doc.add(par);

				for(FuncionariosVO funcionario : funcionarios){
					Paragraph v = new Paragraph("Nome:" + funcionario.getNome() 
								+ "\nCargo " + funcionario.getCargo().getNome() + "\n\n");
					
					doc.add(v);
				}
				
							
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			} finally {
				doc.close();
			}
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
