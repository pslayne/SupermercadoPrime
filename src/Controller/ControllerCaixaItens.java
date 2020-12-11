package Controller;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;

import Model.VO.*;
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

public class ControllerCaixaItens implements Initializable{
    @FXML private ImageView sair; 
    @FXML private TableColumn<ProdutosVO, Integer> ID; 
    @FXML private TableColumn<ProdutosVO, String> produto;
    @FXML private TableColumn<ProdutosVO, Integer> quantidade;
    @FXML private TableColumn<ProdutosVO, Double> valorUnitario;
    @FXML private TableColumn<ProdutosVO, Double> valorTotal;
    @FXML private TableView<ProdutosVO> produtos;
    @FXML private Label dataNomeCaixa;
	
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	Tooltip.install(sair, new Tooltip("sair"));
    	
    	String nome = Telas.getUser().getNome();
		Calendar data = Calendar.getInstance();
		String d = Util.formataData(data);
		String datanome = d + " - " + nome;
		
		dataNomeCaixa.setText(datanome);
    	
    	initTabela();
	}
    
    public void initTabela() {
    	ID.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("codigo"));
    	produto.setCellValueFactory(new PropertyValueFactory<ProdutosVO, String>("nome"));
    	quantidade.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("quantidadePedido"));
    	valorUnitario.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Double>("preco"));
    	valorTotal.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Double>("precoTotal"));
    	produtos.setItems(itens());
    }
    
    public ObservableList<ProdutosVO> itens(){
    	return FXCollections.observableList(Telas.getVenda().getProdutos());
    }
	
	public void sair(MouseEvent m){
		Telas.telaInicialCaixa();
	}

	
}
