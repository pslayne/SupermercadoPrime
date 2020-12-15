package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Model.BO.FuncionariosBO;
import Model.BO.VendasBO;
import View.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ControllerPopupConfirmar implements Initializable{
	
	@FXML private Label msg;
    @FXML private ImageView cancelar;
    @FXML private ImageView ok;
    
    private static int control = 0;
    
    public static int getControl() {
		return control;
	}

	public static void setControl(int control) {
		ControllerPopupConfirmar.control = control;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(cancelar, new Tooltip("cancelar"));
		Tooltip.install(ok, new Tooltip("confirmar"));
		
		if (control == 0)
			msg.setText("Confirmar venda?");
		if (control == 1) {
    		msg.setText("excluir este funcionário?");
		}
	}
	
	public void gerarPdf(){
		Document doc = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
			doc.open();
			
			Paragraph par = new Paragraph("--- Nota Fiscal ---");
			par.setAlignment(1);
			doc.add(par);
			Paragraph tex = new Paragraph("Venda: " + Telas.getVenda());
			doc.add(tex);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			doc.close();
	
	}
		 }
	}
    
    @FXML
    void ok(MouseEvent event) {
    	if(control == 0) {
	    	VendasBO vbo = new VendasBO();
	    	Telas.getVenda().setHora();
	    	vbo.adicionar(Telas.getVenda());
	    	gerarPdf();
	    	Telas.getPopup().close();
	    	Telas.telaInicialCaixa();
    	} else if (control == 1) {
    		FuncionariosBO fbo = new FuncionariosBO();
    		fbo.remover(Telas.getFsel());
    		Telas.getPopup().close();
    		Telas.telaFuncionarios();
    	}
    }

    @FXML
    void cancelar(MouseEvent event) {
    	Telas.getPopup().close();
    }
}