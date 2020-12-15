package Controller;

import java.util.List;
import java.net.URL;
import java.util.ResourceBundle;
import Model.VO.*;
import Model.BO.*;
import View.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCaixaProduto implements Initializable{
	@FXML private TextField codigoProduto;
	@FXML private TextField quantidade;
	@FXML private ImageView ok;
	@FXML private ImageView cancelar;
	@FXML private Label codigo;
	@FXML private Label qntd;
	
	private static int control = 0;
	
	public static int getControl() {
		return control;
	}
	
	public static void setControl(int control) {
		ControllerCaixaProduto.control = control;
	}
	
	private static ProdutosVO prod; 
	
	public static ProdutosVO getProd() {
		return prod;
	}
	
	public static void setProd(ProdutosVO prod) {
		ControllerCaixaProduto.prod = prod;
	}
	
	private static boolean com = false;
	
	public static boolean isCom() {
		return com;
	}

	public static void setCom(boolean com) {
		ControllerCaixaProduto.com = com;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(cancelar, new Tooltip("cancelar"));
		Tooltip.install(ok, new Tooltip("confirmar"));
	}
	
	public void ok(){
		if (control == 0) { //adicionar
			qntd.setVisible(false);
			codigo.setVisible(false);
			List<ProdutosVO> produtos;
			
			if(!com)
				produtos = Telas.getVenda().getProdutos();
			else
				produtos = Telas.getCompra().getProdutos();
			
			ProdutosVO produto = new ProdutosVO();
			
			int cod = Integer.parseInt(codigoProduto.getText());
			produto.setCodigo(cod);
			
			ProdutosBO pbo = new ProdutosBO();
			produto = pbo.buscarID(produto);
			
			if (produto != null) {
				int quant = Integer.parseInt(quantidade.getText());
				
				if(quant <= 0) qntd.setVisible(true);
				else {
					produto.setQuantidadePedido(quant);
					produtos.add(produto);
					
					if(!com) {
						Telas.getVenda().setProdutos(produtos);
						Telas.telaCaixaVendas();
						Telas.getPopup().close();
					} else {
						Telas.getCompra().setProdutos(produtos);
						Telas.telaComprasItens();
						Telas.getPopup().close();
						com = false;
					}
				}
			
			} else codigo.setVisible(true);
		
		} else if (control == 1) { //editar
			qntd.setVisible(false);
			codigo.setVisible(false);
			
			codigoProduto.setText(prod.getCodigo() + "");
			quantidade.setText(prod.getQuantidadePedido() + "");
			
			List<ProdutosVO> produtos;
			if(!com)
				produtos = Telas.getVenda().getProdutos();
			else
				produtos = Telas.getCompra().getProdutos();
			
			ProdutosVO produto = new ProdutosVO();
			
			int cod = Integer.parseInt(codigoProduto.getText());
			produto.setCodigo(cod);
			
			ProdutosBO pbo = new ProdutosBO();
			produto = pbo.buscarID(produto);
			
			if (produto != null) {
				int quant = Integer.parseInt(quantidade.getText());
				
				if(quant <= 0) qntd.setVisible(true);
				else {
					produto.setQuantidadePedido(quant);
					produtos.remove(produtos.indexOf(prod));
					produtos.add(produto);
						
					if(!com) {
						Telas.getVenda().setProdutos(produtos);
						Telas.telaCaixaVendas();
						Telas.getPopup().close();
					} else {
						Telas.getCompra().setProdutos(produtos);
						Telas.telaComprasItens();
						Telas.getPopup().close();
						com = false;
					}
				}
			
			} else codigo.setVisible(true);
			control = 0;
		}
	}
	
	public void cancelar(MouseEvent m){
		Telas.getPopup().close();
	}

	
}
