package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import View.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControllerPopupCancelar implements Initializable{


    @FXML private ImageView cancelar;
    @FXML private ImageView ok;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(cancelar, new Tooltip("cancelar"));
		Tooltip.install(ok, new Tooltip("confirmar"));
	}
    
    @FXML
    void ok(MouseEvent event) {
    	Telas.telaInicialCaixa();
    	Telas.getPopup().close();
    }

    @FXML
    void cancelar(MouseEvent event) {
    	Telas.getPopup().close();
    }

}
