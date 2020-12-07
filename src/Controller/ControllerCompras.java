package Controller;

import View.TelaCompras;
import View.TelaEstoque;
import View.TelaFuncionarios;
import View.TelaInicial;
import View.TelaLogin;
import View.TelaVendas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ControllerCompras {
	@FXML private TextField pesquisar;
	@FXML private TextField pesquisa;
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	
public void pesquisa(MouseEvent m){
		
	}
	
	public void goInicio(ActionEvent e) {
		TelaInicial.launch();
	}
	
	public void goVendas(ActionEvent e) {
		TelaVendas.launch();
	}
	
	public void goFuncionarios(ActionEvent e) {
		TelaFuncionarios.launch();
	}
	
	public void goEstoque(ActionEvent e) {
		TelaEstoque.launch();
	}
	
	public void goCompras(ActionEvent e) {
		TelaCompras.launch();
	}
	
	public void goLogin(ActionEvent e) {
		TelaLogin.launch();
	}
}
