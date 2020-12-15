package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.VO.ProdutosVO;
import Model.VO.VendasVO;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerVendasItens implements Initializable {
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	@FXML private TableColumn<ProdutosVO, Integer> ID; 
	@FXML private TableColumn<ProdutosVO, String> produto;
	@FXML private TableColumn<ProdutosVO, Integer> quantidade;
	@FXML private TableColumn<ProdutosVO, Double> valorUnitario;
	@FXML private TableColumn<ProdutosVO, Double> valorTotal;
	@FXML private TableView<ProdutosVO> produtos;
	@FXML private Label dataNomeCaixa;
	@FXML private Label total;
	@FXML private Label gerente;
	@FXML private ImageView exit;
	
	VendasVO vvo = Telas.getVenda();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dataNomeCaixa.setText(vvo.getCaixa().getNome() + "         " + vvo.getDataS() + " - " + vvo.getHoraS());
		gerente.setText(Telas.getUser().getNome());
		
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
    	double t = 0.0;
    	for(int i = 0; i < vvo.getProdutos().size(); i++) 
    		t += vvo.getProdutos().get(i).getPrecoTotal();
    	total.setText("R$" + t);
    	
    	return FXCollections.observableList(vvo.getProdutos());
    }
    
    public void sair(MouseEvent e) {
    	Telas.telaVendas();
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
