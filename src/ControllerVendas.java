//package Controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import Model.BO.VendasBO;
import Model.VO.VendasVO;
import Model.VO.FuncionariosVO;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ControllerVendas implements Initializable{
	@FXML private TextField pesquisa;
	@FXML private ImageView pesquisab;
	@FXML private ImageView ok;
	@FXML private ImageView expand;
	@FXML private Hyperlink inicio;
	@FXML private Hyperlink vendas;
	@FXML private Hyperlink funcionarios;
	@FXML private Hyperlink estoque;
	@FXML private Hyperlink compras;
	@FXML private Hyperlink sair;
	@FXML private Label gerente;
	@FXML private Label erroSelec;
	@FXML private TableView<VendasVO> tbvendas;
    @FXML private TableColumn<VendasVO, Integer> idvenda;  
    @FXML private TableColumn<VendasVO, Integer> quantidade;
    @FXML private TableColumn<VendasVO, String> hora;
    @FXML private TableColumn<VendasVO, String> data;
    @FXML private TableColumn<VendasVO, Double> valor;
    @FXML private TableColumn<VendasVO, String> funcionario;
    @FXML private ComboBox <String> tempo;
    @FXML private ComboBox <String> pesquisac;
    
    ObservableList<VendasVO> itens;
    VendasBO vbo = new VendasBO();
    VendasVO vvo = new VendasVO();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		erroSelec.setVisible(false);
		gerente.setText(Telas.getUser().getNome());
		initTabela();
		boxes();
	}
	
	public void initTabela() {
		
		quantidade.setCellValueFactory(new PropertyValueFactory<VendasVO, Integer>("quantidade"));
    	hora.setCellValueFactory(new PropertyValueFactory<VendasVO, String>("horaS"));
    	data.setCellValueFactory(new PropertyValueFactory<VendasVO, String>("dataS"));
    	valor.setCellValueFactory(new PropertyValueFactory<VendasVO, Double>("valor"));
    	funcionario.setCellValueFactory(new PropertyValueFactory<VendasVO, String>("caixaS"));
    	idvenda.setCellValueFactory(new PropertyValueFactory<VendasVO, Integer>("codigo"));
    	
		itens = FXCollections.observableList(vbo.listar());
    	
    	tbvendas.setItems(itens);
	}
	
	public void boxes() {
		List<String> lista = new ArrayList<String>();
		lista.add("Hoje");
		lista.add("Esta semana");
		lista.add("Este mês");
		lista.add("Este ano");
		lista.add("Todas");
		
		ObservableList<String> ob = FXCollections.observableList(lista);
		tempo.setItems(ob);
		
		lista = new ArrayList<String>();
		
		lista.add("ID");
		lista.add("Data");
		lista.add("Caixa");
		
		ob = FXCollections.observableList(lista);
		pesquisac.setItems(ob);
	}
	
	public void pesquisar(MouseEvent m){
		if(pesquisac.getSelectionModel().getSelectedItem() != null && pesquisa.getText() != null) {
			String pesq = pesquisac.getSelectionModel().getSelectedItem();
			String txt = pesquisa.getText();
			if(pesq.equalsIgnoreCase("ID")) {
				List<VendasVO> lista = new ArrayList<VendasVO>();
				vvo.setCodigo(Integer.parseInt(txt));
				lista.add(vbo.buscarID(vvo));
				itens = FXCollections.observableList(lista);
				tbvendas.setItems(itens);
			} else if(pesq.equalsIgnoreCase("Data")) {
				pesquisa.setPromptText("dd/mm/aaaa");
				vvo.setData(txt);
				itens = FXCollections.observableList(vbo.buscarData(vvo));
				tbvendas.setItems(itens);
			} else if(pesq.equalsIgnoreCase("Caixa")) {
				pesquisa.setPromptText("nome do caixa");
				
				FuncionariosVO f = new FuncionariosVO();
				f.setNome(txt);
				vvo.setCaixa(f);
				
				itens = FXCollections.observableList(vbo.buscarCaixaNome(vvo));
				tbvendas.setItems(itens);
			}
		} else {
			erroSelec.setText("selecione um tipo de pesquisa");
			erroSelec.setVisible(true);
		}
	}
	
	public void gerarPdf(List <VendasVO> vendas){
		Document doc = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(file.getAbsolutePath()));
			doc.open();
			Paragraph par = new Paragraph();
			doc.add(par);
			par = new Paragraph(" ");
			doc.add(par);
			for(VendasVO venda : vendas){
    				Paragraph tex = new Paragraph("Código da venda: " + venda.getCodigo()
    						+ "\nValor(R$) :" + venda.getValor() 
						+ "\nData: " + venda.getDataS() 
						+ "\nHorário: " + venda.getHoraS() 
						+ "\nCaixa: " + venda.getCaixaS() + "\n\n");
				doc.add(tex);
			}
			doc.add(par);
					
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			doc.close();
	
	}
		 }
}
	
	public void expandir(MouseEvent m){
		vvo = tbvendas.getSelectionModel().getSelectedItem();
		if(vvo != null) {
			Telas.setVenda(vvo);
			Telas.telaVendasItens();
		} else {
			erroSelec.setText("selecione uma linha da tabela");
			erroSelec.setVisible(true);
		}
	}
	
	public void atualizar(MouseEvent m){
		if (tempo.getSelectionModel().getSelectedItem() != null) {
			String selec = tempo.getSelectionModel().getSelectedItem();
			vvo.setData();
			if(selec.equalsIgnoreCase("hoje")) {
				List<VendasVO> v = vbo.buscarData(vvo);
				itens = FXCollections.observableList(v); 
				tbvendas.setItems(itens);
				gerarPdf(v);
			} else if(selec.equalsIgnoreCase("esta semana")) {
				itens = FXCollections.observableList(vbo.buscarData(vvo, "semana"));
				tbvendas.setItems(itens);
			} else if(selec.equalsIgnoreCase("este mês")) {
				itens = FXCollections.observableList(vbo.buscarData(vvo, "mês"));
				tbvendas.setItems(itens);
			} else if(selec.equalsIgnoreCase("este ano")) {
				itens = FXCollections.observableList(vbo.buscarData(vvo, "ano"));
				tbvendas.setItems(itens);
			}
		} else {
			erroSelec.setText("selecione um filtro de tempo");
			erroSelec.setVisible(true);
		} 

	}
	
	public void goInicio(ActionEvent e) {
		Telas.telaInicial();
	}
	
	public void goVendas(ActionEvent e) {
		Telas.telaVendas();
	}
	
	public void goFuncionarios(ActionEvent e) {
		Telas.telaFuncionarios();
	}
	
	public void goEstoque(ActionEvent e) {
		Telas.telaEstoque();
	}
	
	public void goCompras(ActionEvent e) {
		Telas.telaCompras();
	}
	
	public void goLogin(ActionEvent e) {
		Telas.telaLogin();
	}

}
