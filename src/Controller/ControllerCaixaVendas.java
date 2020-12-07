package Controller;

import View.TelaCaixaProduto;
import View.TelaInicialCaixa;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCaixaVendas {
	@FXML private ImageView ok;
	@FXML private ImageView adicionar;
	@FXML private ImageView sair;
	
	public void ok(MouseEvent m){
		TelaInicialCaixa.launch();
	}
	
	public void adicionar(MouseEvent m){
		TelaCaixaProduto.launch();
	}
	
	public void sair(MouseEvent m){
		TelaInicialCaixa.launch();
	}
}
