package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Model.BO.ComprasBO;
import Model.VO.ComprasVO;
import Model.VO.ProdutosVO;
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

public class ControllerComprasItens implements Initializable{
	
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
	@FXML private Label total;
	@FXML private Label gerente;
	@FXML private Label erroSelec;
	@FXML private ImageView cancel;
	@FXML private ImageView add;
	@FXML private ImageView ok;
	
	ComprasVO vo = Telas.getCompra();
	ComprasBO bo = new ComprasBO();
	
	private static boolean expand = false;
	
	public static boolean isExpand() {
		return expand;
	}

	public static void setExpand(boolean expand) {
		ControllerComprasItens.expand = expand;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gerente.setText(Telas.getUser().getNome());
		
		if(expand) {
			add.setVisible(false);
			ok.setVisible(false);
		}
		
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
			List<ProdutosVO> p = vo.getProdutos();
			Iterator<ProdutosVO> i = p.iterator();
			List<ProdutosVO> r = new ArrayList<ProdutosVO>();
			double t = 0.0;
			
			while(i.hasNext()) {
				ProdutosVO vo = i.next();
				double precoTotal = vo.getQuantidadePedido() * vo.getPreco();
				t += precoTotal;
				vo.setPrecoTotal(precoTotal);
				r.add(vo);
			}
			total.setText("R$" + t);
		    return FXCollections.observableList(r);
		}
	
	public void confirmar() {
		Telas.getCompra().setHora();
		bo.adicionar(Telas.getCompra());
		Telas.telaCompras();
	}
	
	public void adicionar() {
		ControllerCaixaProduto.setCom(true);
		ControllerCaixaProduto.setControl(0);
		Telas.telaCaixaProduto();
	}
	
	public void cancelar() {
		Telas.telaCompras();
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
