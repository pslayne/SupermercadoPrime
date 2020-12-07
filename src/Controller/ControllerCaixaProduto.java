package Controller;

import View.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCaixaProduto {
	@FXML private TextField codigoProduto;
	@FXML private TextField quantidade;
	@FXML private ImageView ok;
	@FXML private ImageView cancelar;
	
	public void ok(MouseEvent m){
		
	}
	
	public void cancelar(MouseEvent m){
		TelaInicialCaixa.launch();
	}
}
