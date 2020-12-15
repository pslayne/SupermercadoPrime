package Controller;
import Model.BO.FuncionariosBO;
import Model.VO.FuncionariosVO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML private TextField login;
    @FXML private PasswordField senha;
    @FXML private Label erroAutenticacao;
    @FXML private Hyperlink esqueceuSenha;
    @FXML private Button BotaoLogin;
    
    
	public void autenticar(ActionEvent event) {
		erroAutenticacao.setVisible(false);
    	FuncionariosVO fvo = new FuncionariosVO();
    	fvo.setLogin(login.getText());
    	fvo.setSenha(senha.getText());
    	
    	FuncionariosBO fbo = new FuncionariosBO();
    	fvo = fbo.buscarLoginSenha(fvo);
    	
    	if(fvo != null) {
    		if(fvo.getCargo().getNome().equalsIgnoreCase("gerente")) {
    			Telas.setUser(fvo);
    			Telas.telaInicial();
    		} else {
    			Telas.setUser(fvo);
    			Telas.telaInicialCaixa();
    		}
    	} else {
    		erroAutenticacao.setVisible(true);
    	}
	}
}
