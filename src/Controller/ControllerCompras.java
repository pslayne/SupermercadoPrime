package Controller;

import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerCompras {
	@FXML private TextField pesquisar;
	@FXML private TextField pesquisa1;
	@FXML private ImageView pesquisa;
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	
public void pesquisa(MouseEvent m){
		
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
