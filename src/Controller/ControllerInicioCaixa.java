package Controller;

import View.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerInicioCaixa {
	@FXML private ImageView adicionar;
	@FXML private ImageView sair;
	
	public void adicionar(MouseEvent m){
		TelaCaixaProduto.launch();
	}
	
	public void sair(MouseEvent m){
		TelaLogin.launch();
	}
	
}
