package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaEstoque extends Application {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	      Parent root = FXMLLoader.load(getClass().getResource("TelaEstoque.fxml"));
	      
	      Scene cena = new Scene(root);
	      
	      primaryStage.setTitle("Supermercado Prime");
	      primaryStage.setScene(cena);
	      primaryStage.show();
	      
	}

}