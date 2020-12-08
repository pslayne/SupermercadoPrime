package Controller;

import View.Telas;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerInicioCaixa {
	@FXML private ImageView adicionar;
	@FXML private ImageView sair;
	
	public void adicionar(MouseEvent m){
		Telas.telaCaixaProduto();
	}
	
	public void sair(MouseEvent m){
		Telas.telaLogin();
	}
	
}
