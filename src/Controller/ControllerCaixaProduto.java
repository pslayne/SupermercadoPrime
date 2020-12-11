package Controller;

import java.util.List;
import java.util.ArrayList;
import java.net.URL;
import java.util.ResourceBundle;
import Model.VO.*;
import Model.BO.*;
import View.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCaixaProduto implements Initializable{
	@FXML private TextField codigoProduto;
	@FXML private TextField quantidade;
	@FXML private ImageView ok;
	@FXML private ImageView cancelar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(cancelar, new Tooltip("cancelar"));
		Tooltip.install(ok, new Tooltip("confirmar"));
	}
	
	public void ok(MouseEvent m){
		ProdutosVO produto = new ProdutosVO();
		
		int cod = Integer.parseInt(codigoProduto.getText());
		produto.setCodigo(cod);
		
		ProdutosBO pbo = new ProdutosBO();
		produto = pbo.buscarID(produto);
		
		int quant = Integer.parseInt(quantidade.getText());
		produto.setQuantidadePedido(quant);
		
		Telas.getVenda().getProdutos().add(produto);
		Telas.telaCaixaVendas();
	}
	
	public void cancelar(MouseEvent m){
		Telas.telaInicialCaixa();
	}

	
}
