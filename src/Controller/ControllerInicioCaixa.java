package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import Model.BO.VendasBO;
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