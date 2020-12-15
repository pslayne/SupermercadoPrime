package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import Model.BO.VendasBO;
import Model.DAO.VendasDAO;
import Model.VO.ProdutosVO;
import Model.VO.Util;
import Model.VO.VendasVO;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
//import javafx.event.ActionEvent;

public class ControllerInicioCaixa implements Initializable{
	
	@FXML private TableView<VendasVO> vendas;
    @FXML private TableColumn<VendasVO, Integer> idvenda;  
    @FXML private TableColumn<VendasVO, String> hora;
    @FXML private TableColumn<VendasVO, Double> valor;
    @FXML private TableColumn<VendasVO, Integer> numitens;
    @FXML private ImageView adicionar;
    @FXML private ImageView sair;
    @FXML private ImageView expandir;
    @FXML private Label erroSelec;
  
    @FXML private Label dataNomeCaixa;
//    @FXML private TableColumn<VendasVO, VendasVO> columnEdit;
//	@FXML private TableColumn<VendasVO, VendasVO> columnDelete;
//	
//	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
//	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String nome = Telas.getUser().getNome();
		Calendar data = Calendar.getInstance();
		String d = Util.formataData(data);
		String datanome = d + " - " + nome;
		
		dataNomeCaixa.setText(datanome);
		
		Tooltip.install(adicionar, new Tooltip("realizar venda"));
		Tooltip.install(sair, new Tooltip("sair"));
		Tooltip.install(expandir, new Tooltip("ver itens"));
		
		inTabela();
	}
    
    public void inTabela() {
    	idvenda.setCellValueFactory(new PropertyValueFactory<VendasVO, Integer>("codigo"));
    	hora.setCellValueFactory(new PropertyValueFactory<VendasVO, String>("horaS"));
    	valor.setCellValueFactory(new PropertyValueFactory<VendasVO, Double>("valor"));
    	numitens.setCellValueFactory(new PropertyValueFactory<VendasVO, Integer>("quantidade"));
    	vendas.setItems(itens());
    	
    	if(itens().isEmpty()) {
    		vendas.setVisible(false);
    		erroSelec.setText("não existem linhas na tabela");
    	} else {
    		vendas.setVisible(true);
    		erroSelec.setText("selecione uma linha da tabela");
    	}
    	
//    	Utils.initButtons(columnEdit, 15, PEN_SOLID, "svg-gray", (VendasVO vendasvo, ActionEvent event) -> {
//			System.out.println("Você clicou para editar as informações de: " + vendasvo.getCodigo());
//			// Aqui vai toda a lógica para editar a pessoa
//		});
//		Utils.initButtons(columnDelete, 15, TRASH_SOLID, "svg-red", (VendasVO vendasvo, ActionEvent event) -> {
//			System.out.println("Você clicou para deletar as informações de: " + vendasvo.getCodigo());
//			// Aqui vai toda a lógica para deletar a pessoa
//		});
    }
    
    public ObservableList<VendasVO> itens(){
    	VendasBO vbo = new VendasBO();
    	VendasVO v = new VendasVO();
    	v.setCaixa(Telas.getUser());
    	v.setData();
    	return FXCollections.observableList(vbo.buscaCaixaData(v));
    }

    @FXML
    void adicionar(MouseEvent event) {
    	VendasVO novaVenda = new VendasVO();
		novaVenda.setCaixa(Telas.getUser());
		novaVenda.setData();
		
		List<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
		novaVenda.setProdutos(produtos);
		
		Telas.setVenda(novaVenda);
    	Telas.telaCaixaProduto();
    }

    @FXML
    void sair(MouseEvent event) {
    	VendasDAO dao = new VendasDAO();
    	dao.closeConnection();
    	Telas.telaLogin();
    }

    @FXML
    void expandirItens(MouseEvent event) {
    	VendasVO venda = vendas.getSelectionModel().getSelectedItem();
    	if(venda != null) {
    		Telas.setVenda(venda);
    		Telas.telaCaixaItens();
    	} else erroSelec.setVisible(true);
    }
}