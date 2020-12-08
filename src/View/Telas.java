package View;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage primaryStage;

	public static void main(String[] args) {
		launch();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Supermercado Prime");
		primaryStage.show();
		telaLogin();
	}
	
	public static void telaLogin() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaLogin.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaInicial(){
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaInicial.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaInicialCaixa() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaInicialCaixa.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaCaixaProduto() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaCaixaProduto.fxml"));
			Scene cena = new Scene(root);
		primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaCaixaVendas() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaCaixaVendas.fxml"));  
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void telaCompras() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaCompras.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaVendas() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaVendas.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaEstoque() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaEstoque.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void telaFuncionarios() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaFuncionarios.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
