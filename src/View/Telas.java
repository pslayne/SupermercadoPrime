package View;

import java.io.IOException;

import Model.VO.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage primaryStage;
	private static Stage popup;
	private static FuncionariosVO user;
	private static FuncionariosVO fsel;
	private static VendasVO venda;
	private static ComprasVO compra;
	private static ProdutosVO psel;
	
	public static ComprasVO getCompra() {
		return compra;
	}

	public static void setCompra(ComprasVO compra) {
		Telas.compra = compra;
	}

	public static ProdutosVO getPsel() {
		return psel;
	}

	public static void setPsel(ProdutosVO psel) {
		Telas.psel = psel;
	}

	public static FuncionariosVO getUser() {
		return user;
	}

	public static void setFsel(FuncionariosVO fsel) {
		Telas.fsel = fsel;
	}
	
	public static FuncionariosVO getFsel() {
		return fsel;
	}

	public static void setUser(FuncionariosVO user) {
		Telas.user = user;
	}
	
	public static VendasVO getVenda() {
		return venda;
	}

	public static void setVenda(VendasVO venda) {
		Telas.venda = venda;
	}

	public static void main(String[] args) {
		launch();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	public static Stage getPopup() {
		return popup;
	}
	
	public static void setPopup(Stage popup) {
		Telas.popup = popup;
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
		popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("Adicionar Produtos");
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaCaixaProduto.fxml"));
			Scene cena = new Scene(root);
			popup.setScene(cena);
			popup.showAndWait();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public static void popupConfirmar() {
		popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("Adicionar Produtos");
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("PopupConfirmar.fxml"));
			Scene cena = new Scene(root);
			popup.setScene(cena);
			popup.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public static void popupCancelar() {
		popup = new Stage();
		popup.initModality(Modality.APPLICATION_MODAL);
		popup.setTitle("Adicionar Produtos");
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("PopupCancelar.fxml"));
			Scene cena = new Scene(root);
			popup.setScene(cena);
			popup.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	public static void telaCaixaItens() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaCaixaItens.fxml"));  
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
	
	public static void telaComprasItens() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaComprasItens.fxml"));
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
	
	public static void telaVendasItens() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaVendasItens.fxml"));
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
	
	public static void telaEstoqueEdit() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaEstoqueEdit.fxml"));
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
	
	public static void telaFuncionariosEdit() {
		Parent root;
		try {
			root = FXMLLoader.load(Telas.class.getResource("TelaFuncionariosEdit.fxml"));
			Scene cena = new Scene(root);
			primaryStage.setScene(cena);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
