package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Model.BO.CargoBO;
import Model.BO.FuncionariosBO;
import Model.VO.CargoVO;
import Model.VO.FuncionariosVO;
import View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class ControllerFuncionariosEdit implements Initializable {

    @FXML private Hyperlink sair;
    @FXML private Hyperlink funcionarios; 
    @FXML private Hyperlink inicio;
    @FXML private Hyperlink vendas;
    @FXML private Hyperlink estoque;
    @FXML private Hyperlink compras;
    
    @FXML private ImageView edit;
    @FXML private ImageView save;
    @FXML private ImageView volta;
    @FXML private ImageView add;
    
    @FXML private Label cargo; 
    @FXML private Label email;
    @FXML private Label gerente;
    @FXML private Label cpf; 
    @FXML private Label nome;
    @FXML private Label codigo;
    @FXML private Label endereco;
    @FXML private Label login;
    @FXML private Label senha;
    @FXML private Label datanascimento;
    @FXML private Label salario;
    @FXML private Label erro;
   
    @FXML private TextField emailEdit;   
    @FXML private TextField nomeEdit;
    @FXML private TextField cpfEdit;
    @FXML private TextField cargoEdit;
    @FXML private TextField enderecoEdit;
    @FXML private TextField loginEdit;
    @FXML private TextField senhaEdit;
    @FXML private TextField datanascimentoEdit;
    @FXML private TextField salarioEdit;
   
    FuncionariosVO fvo = Telas.getFsel();
    boolean edita = false;
    private static boolean adicionar = false;
    
    
	public static boolean getAdicionar() {
		return adicionar;
	}

	public static void setAdicionar(boolean adicionar) {
		ControllerFuncionariosEdit.adicionar = adicionar;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		erro.setVisible(false);
		
		
		Tooltip.install(edit, new Tooltip("editar"));
		Tooltip.install(save, new Tooltip("salvar"));
		Tooltip.install(volta, new Tooltip("voltar"));
		
		gerente.setText(Telas.getUser().getNome());
		
		if(!adicionar) {
			voltar();
			
			cargo.setText(fvo.getCargoS());
			email.setText(fvo.getEmail());
			cpf.setText(fvo.getCpf());
			nome.setText(fvo.getNome());
			codigo.setText("" + fvo.getCodigo());
			endereco.setText(fvo.getEndereco());
			login.setText(fvo.getLogin());
			senha.setText(fvo.getSenha());
			datanascimento.setText(fvo.getDataNascimento(fvo.getDataNascimento()));
			salario.setText("" + fvo.getSalario());
		} else adicionar();
	}

    @FXML
    void goInicio(ActionEvent e) {
    	Telas.telaInicial();
    }

    @FXML
    void goVendas(ActionEvent e) {
    	Telas.telaVendas();
    }

    @FXML
    void goFuncionarios(ActionEvent e) {
    	Telas.telaFuncionarios();
    }

    @FXML
    void goEstoque(ActionEvent e) {
    	Telas.telaEstoque();
    }

    @FXML
    void goCompras(ActionEvent e) {
    	Telas.telaCompras();
    }

    @FXML
    void goLogin(ActionEvent e) {
    	Telas.telaLogin();
    }

    @FXML
    void voltar() {
    	if(edita) {
	    	cargo.setVisible(true);
			email.setVisible(true);
			cpf.setVisible(true);
			nome.setVisible(true);
			endereco.setVisible(true);
			login.setVisible(true);
			senha.setVisible(true);
			datanascimento.setVisible(true);
			salario.setVisible(true);
			edit.setVisible(true);
			
			cargoEdit.setVisible(false);
			emailEdit.setVisible(false);
			cpfEdit.setVisible(false);
			nomeEdit.setVisible(false);
			enderecoEdit.setVisible(false);
			loginEdit.setVisible(false);
			senhaEdit.setVisible(false);
			datanascimentoEdit.setVisible(false);
			salarioEdit.setVisible(false);
			save.setVisible(false);
			
			edita = false;
    	} else {
    		Telas.telaFuncionarios();
    	}
    }

    @FXML
    void editar() {
    	edita = true;
    			
    	cargo.setVisible(false);
		email.setVisible(false);
		cpf.setVisible(false);
		nome.setVisible(false);
		endereco.setVisible(false);
		login.setVisible(false);
		senha.setVisible(false);
		datanascimento.setVisible(false);
		salario.setVisible(false);
		edit.setVisible(false);
		
    	cargoEdit.setVisible(true);
		emailEdit.setVisible(true);
		cpfEdit.setVisible(true);
		nomeEdit.setVisible(true);
		enderecoEdit.setVisible(true);
		datanascimentoEdit.setVisible(true);
		loginEdit.setVisible(true);
		senhaEdit.setVisible(true);
		salarioEdit.setVisible(true);
		save.setVisible(true);
		
		cargoEdit.setText(fvo.getCargoS());
		emailEdit.setText(fvo.getEmail());
		cpfEdit.setText(fvo.getCpf());
		nomeEdit.setText(fvo.getNome());
		enderecoEdit.setText(fvo.getEndereco());
		loginEdit.setText(fvo.getLogin());
		senhaEdit.setText(fvo.getSenha());
		datanascimentoEdit.setText(fvo.getDataNascimento(fvo.getDataNascimento()));
		salarioEdit.setText("" + fvo.getSalario());
    }

    @FXML
    void salvar() {
    	FuncionariosVO f = new FuncionariosVO();
    	FuncionariosBO fbo = new FuncionariosBO();
    	
    	CargoVO c = new CargoVO();
    	c.setNome(cargoEdit.getText());
    	
    	CargoBO cb = new CargoBO();
    	f.setCargo(cb.buscarNome(c));
    	
    	if(emailEdit.getText() == null || cpfEdit.getText() == null || nomeEdit.getText() == null || enderecoEdit.getText() == null || loginEdit.getText() == null || senhaEdit.getText() == null || datanascimentoEdit.getText() == null || salarioEdit.getText() == null) {
    		erro.setText("preencha todos os campos");
    		erro.setVisible(true);
    	} else {
		    if(!adicionar) {	
    			f.setEmail(emailEdit.getText());
		    	f.setCpf(cpfEdit.getText());
		    	f.setNome(nomeEdit.getText());
		    	f.setEndereco(enderecoEdit.getText());
		    	f.setLogin(loginEdit.getText());
		    	f.setSenha(senhaEdit.getText());
		    	f.setDataNascimento(datanascimentoEdit.getText());
		    	
		    	double s = Double.parseDouble(salarioEdit.getText());
		    	if(s < 0) {
		    		erro.setText("salário negativo ou zerado");
		    		erro.setVisible(true);
		    	} else {
		    		f.setSalario(s);
		    		fbo.editar(fvo, f);
		    		Telas.telaFuncionarios();
		    	}
		    } else {
		    	f.setEmail(emailEdit.getText());
		    	f.setCpf(cpfEdit.getText());
		    	f.setNome(nomeEdit.getText());
		    	f.setEndereco(enderecoEdit.getText());
		    	f.setLogin(loginEdit.getText());
		    	f.setSenha(senhaEdit.getText());
		    	f.setDataNascimento(datanascimentoEdit.getText());
		    	
		    	double s = Double.parseDouble(salarioEdit.getText());
		    	if(s < 0) {
		    		erro.setText("salário negativo ou zerado");
		    		erro.setVisible(true);
		    	} else {
		    		f.setSalario(s);
		    		fbo.adicionar(f);
		    		ControllerFuncionariosEdit.setAdicionar(false);
		    		Telas.telaFuncionarios();
		    	}
		    }
    	}
    	
    }
    
    public void adicionar() {
    	cargo.setVisible(false);
		email.setVisible(false);
		cpf.setVisible(false);
		nome.setVisible(false);
		endereco.setVisible(false);
		login.setVisible(false);
		senha.setVisible(false);
		datanascimento.setVisible(false);
		salario.setVisible(false);
		edit.setVisible(false);
		
    	cargoEdit.setVisible(true);
		emailEdit.setVisible(true);
		cpfEdit.setVisible(true);
		nomeEdit.setVisible(true);
		enderecoEdit.setVisible(true);
		datanascimentoEdit.setVisible(true);
		loginEdit.setVisible(true);
		senhaEdit.setVisible(true);
		salarioEdit.setVisible(true);
		save.setVisible(true);
    }

}