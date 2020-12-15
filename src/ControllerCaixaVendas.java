//package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Controller.ControllerCaixaProduto;
import Model.VO.ProdutosVO;
import Model.VO.Util;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class ControllerCaixaVendas implements Initializable{

    @FXML private ImageView adicionar;
    @FXML private ImageView sair;
    @FXML private ImageView ok;
    @FXML private ImageView edit;
    @FXML private ImageView delete;
    @FXML private Label total;
    @FXML private TableView<ProdutosVO> produtos;
    @FXML private TableColumn<ProdutosVO, Integer> ID; 
    @FXML private TableColumn<ProdutosVO, String> produto;
    @FXML private TableColumn<ProdutosVO, Integer> quantidade;
    @FXML private TableColumn<ProdutosVO, Double> valorUnitario;
    @FXML private TableColumn<ProdutosVO, Double> valorTotal;
    @FXML private Label dataNomeCaixa;
    @FXML private Label erroSelec;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Tooltip.install(sair, new Tooltip("cancelar"));
		Tooltip.install(adicionar, new Tooltip("adicionar produto"));
		Tooltip.install(ok, new Tooltip("confirmar venda"));
		
    	String nome = Telas.getUser().getNome();
		Calendar data = Calendar.getInstance();
		String d = Util.formataData(data);
		String datanome = d + " - " + nome;
		
		dataNomeCaixa.setText(datanome);
    	
    	initTabela();
	}
	
	public void initTabela() {
	   	ID.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("codigo"));
	   	produto.setCellValueFactory(new PropertyValueFactory<ProdutosVO, String>("nome"));
	   	quantidade.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Integer>("quantidadePedido"));
	   	valorUnitario.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Double>("preco"));
	    valorTotal.setCellValueFactory(new PropertyValueFactory<ProdutosVO, Double>("precoTotal"));
	    produtos.setItems(itens());
	    
	}
	    
	public ObservableList<ProdutosVO> itens(){
		List<ProdutosVO> p = Telas.getVenda().getProdutos();
		Iterator<ProdutosVO> i = p.iterator();
		List<ProdutosVO> r = new ArrayList<ProdutosVO>();
		double t = 0.0;
		
		while(i.hasNext()) {
			ProdutosVO vo = i.next();
			double precoTotal = vo.getQuantidadePedido() * vo.getPreco();
			t += precoTotal;
			vo.setPrecoTotal(precoTotal);
			r.add(vo);
		}
		total.setText("R$" + t);
	    return FXCollections.observableList(r);
	}
	
    @FXML
    void adicionar(MouseEvent event) {
    	Telas.telaCaixaProduto();
    }

    @FXML
    void ok(MouseEvent event) {
    	Telas.popupConfirmar();
    }
    
    @FXML
    void editar(MouseEvent event) {
    	ProdutosVO p = produtos.getSelectionModel().getSelectedItem();
    	if (p!=null) {
	    	ControllerCaixaProduto.setProd(p);
	    	ControllerCaixaProduto.setControl(1);
	    	Telas.telaCaixaProduto();
    	} else erroSelec.setVisible(true);
    }
    
    @FXML
    void deletar(MouseEvent event) {
    	ProdutosVO p = produtos.getSelectionModel().getSelectedItem();
    	Telas.getVenda().getProdutos().remove(p);
    	Telas.telaCaixaVendas();
    }

    @FXML
    void sair(MouseEvent event) {
    	Telas.popupCancelar();
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
			Paragraph tex = new Paragraph("Venda: " + Telas.getVenda().getCodigo());
			doc.add(tex);

			for(ProdutosVO produto : Telas.getVenda().getProdutos()){
				Paragraph prod = new Paragraph("Item: " + produto.getNome() 
							+ "\nQuantidade: " + produto.getQuantidadePedido()
							+ "\nValor: " + produto.getPreco() + "\n\n");
				doc.add(prod);
			}
			Paragraph valFim = new Paragraph("Valor total da compra: " + Telas.getVenda().getValor());
			doc.add(valFim);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			doc.close();
		}
	    }
	}
}
