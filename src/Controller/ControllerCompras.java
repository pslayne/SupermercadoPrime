package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import View.Telas;
import Model.VO.ComprasVO;
import Model.VO.FuncionariosVO;
import Model.VO.ProdutosVO;
import Model.BO.ComprasBO;
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

public class ControllerCompras implements Initializable{
	@FXML private TextField pesquisa;
	@FXML private ImageView pesquisab;
	@FXML private ImageView expandir;
	@FXML private ImageView ok;
	@FXML private ImageView add;
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	@FXML private TableView <ComprasVO> tbcompras;
    @FXML private TableColumn<ComprasVO, Integer> idcompra;  
    @FXML private TableColumn<ComprasVO, Integer> quantidade;
    @FXML private TableColumn<ComprasVO, String> hora;
    @FXML private TableColumn<ComprasVO, String> data;
    @FXML private TableColumn<ComprasVO, Double> valor;
    @FXML private TableColumn<ComprasVO, String> funcionario;
	@FXML private Label erroSelec;
	@FXML private Label gerente;
	@FXML private ComboBox<String> pesquisac;
	@FXML private ComboBox<String> tempo;
	
	ComprasBO bo = new ComprasBO();
	ComprasVO vo = new ComprasVO();
	ObservableList<ComprasVO> lista = FXCollections.observableList(bo.listar());
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		erroSelec.setVisible(false);
		gerente.setText(Telas.getUser().getNome());
		
		Tooltip.install(pesquisab, new Tooltip("pesquisar"));
		Tooltip.install(expandir, new Tooltip("ver detalhes da compra"));
		
		inTabela();
		boxes();
	}
	
		
	public void inTabela() {
		quantidade.setCellValueFactory(new PropertyValueFactory<ComprasVO, Integer>("quantidadeProdutos"));
		valor.setCellValueFactory(new PropertyValueFactory<ComprasVO, Double>("valor"));
		data.setCellValueFactory(new PropertyValueFactory<ComprasVO, String>("dataS"));
		hora.setCellValueFactory(new PropertyValueFactory<ComprasVO, String>("horaS"));
		funcionario.setCellValueFactory(new PropertyValueFactory<ComprasVO, String>("gerenteS"));
		idcompra.setCellValueFactory(new PropertyValueFactory<ComprasVO, Integer>("codigo"));
		
		tbcompras.setItems(lista); 
	}
	
	public void boxes() {
		List<String> lista = new ArrayList<String>();
		lista.add("Hoje");
		lista.add("Esta semana");
		lista.add("Este mês");
		lista.add("Este ano");
		lista.add("Todas");
		
		ObservableList<String> ob = FXCollections.observableList(lista);
		tempo.setItems(ob);
		
		lista = new ArrayList<String>();
		
		lista.add("ID");
		lista.add("Data");
		lista.add("Gerente");
		
		ob = FXCollections.observableList(lista);
		pesquisac.setItems(ob);
	}
	
	public void pesquisar(MouseEvent m){
		if(pesquisac.getSelectionModel().getSelectedItem() != null && pesquisa.getText() != null) {
			String pesq = pesquisac.getSelectionModel().getSelectedItem();
			String txt = pesquisa.getText();
			if(pesq.equalsIgnoreCase("ID")) {
				List<ComprasVO> list = new ArrayList<ComprasVO>();
				vo.setCodigo(Integer.parseInt(txt));
				list.add(bo.buscarID(vo));
				lista = FXCollections.observableList(list);
				tbcompras.setItems(lista);
			} else if(pesq.equalsIgnoreCase("Data")) {
				pesquisa.setPromptText("dd/mm/aaaa");
				vo.setData(txt);
				lista = FXCollections.observableList(bo.buscarData(vo));
				tbcompras.setItems(lista);
			} else if(pesq.equalsIgnoreCase("Caixa")) {
				pesquisa.setPromptText("nome do caixa");
				
				FuncionariosVO f = new FuncionariosVO();
				f.setNome(txt);
				vo.setGerente(f);
				
				lista = FXCollections.observableList(bo.buscarGerenteNome(vo));
				tbcompras.setItems(lista);
			}
		} else {
			erroSelec.setText("selecione um tipo de pesquisa");
			erroSelec.setVisible(true);
		}
	}
	
	public void atualizar(MouseEvent m){
		if (tempo.getSelectionModel().getSelectedItem() != null) {
			String selec = tempo.getSelectionModel().getSelectedItem();
			vo.setData();
			if(selec.equalsIgnoreCase("hoje")) {
				List<ComprasVO> v = bo.buscarData(vo);
				lista = FXCollections.observableList(v); 
				tbcompras.setItems(lista);
			} else if(selec.equalsIgnoreCase("esta semana")) {
				lista = FXCollections.observableList(bo.buscarData(vo, "semana"));
				tbcompras.setItems(lista);
			} else if(selec.equalsIgnoreCase("este mês")) {
				lista = FXCollections.observableList(bo.buscarData(vo, "mês"));
				tbcompras.setItems(lista);
			} else if(selec.equalsIgnoreCase("este ano")) {
				lista = FXCollections.observableList(bo.buscarData(vo, "ano"));
				tbcompras.setItems(lista);
			}
		} else {
			erroSelec.setText("selecione um filtro de tempo");
			erroSelec.setVisible(true);
		} 

	}
	
	public void adicionar() {
		ComprasVO compra = new ComprasVO();
		compra.setData();
		compra.setGerente(Telas.getUser());
		
		List<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		compra.setProdutos(produtos);
		
		Telas.setCompra(compra);
		ControllerCaixaProduto.setCom(true);
		ControllerCaixaProduto.setControl(0);
		Telas.telaCaixaProduto();
	}
	
	public void expandirCompra(MouseEvent m){
		vo = tbcompras.getSelectionModel().getSelectedItem();
		if(vo != null) {
			Telas.setCompra(vo);
			ControllerComprasItens.setExpand(true);
			Telas.telaComprasItens();
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
