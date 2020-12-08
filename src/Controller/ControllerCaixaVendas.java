package Controller;
import View.Telas;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCaixaVendas {
	@FXML private ImageView ok;
	@FXML private ImageView adicionar;
	@FXML private ImageView sair;
	
	public void ok(MouseEvent m){
		Telas.telaInicialCaixa();
	}
	
	public void adicionar(MouseEvent m){
		Telas.telaCaixaProduto();
	}
	
	public void sair(MouseEvent m){
		Telas.telaInicialCaixa();
	}
}
