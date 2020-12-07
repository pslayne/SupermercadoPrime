package Controller;


import java.awt.event.ActionEvent;

import Model.BO.FuncionariosBO;
import Model.VO.FuncionariosVO;
import View.TelaInicial;
import View.TelaInicialCaixa;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField login;
    @FXML private TextField senha;
    @FXML private Label erroAutenticacao;
  
    
    
	public void autenticar(ActionEvent event) {
    	FuncionariosVO fvo = new FuncionariosVO();
    	fvo.setLogin(login.getText());
    	fvo.setSenha(senha.getText());
    	
    	FuncionariosBO fbo = new FuncionariosBO();
    	fvo = fbo.buscarLoginSenha(fvo);
    	
    	if(fvo != null) {
    		if(fvo.getCargo().getNome().equalsIgnoreCase("gerente")) {
    			TelaInicial.launch();
    		} else {
    			TelaInicialCaixa.launch();
    		}
    	} else {
    		erroAutenticacao.setText("Usuário ou senha inválidos");
    		erroAutenticacao.setVisible(true);
    	}
	}
}
