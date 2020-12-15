package Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Model.BO.ProdutosBO;
import Model.BO.TipoBO;
import Model.VO.ProdutosVO;
import Model.VO.TipoVO;
import View.Telas;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

public class ControllerEstoqueEdit implements Initializable {
	
    @FXML private ComboBox<String> nometipoEdit;
    @FXML private TextField precoEdit;  
    @FXML private TextField quantidadeEdit; 
    @FXML private TextField nomeEdit;
    @FXML private TextField marcaEdit;
    
    @FXML private Hyperlink sair; 
    @FXML private Hyperlink vendas;
    @FXML private Hyperlink inicio; 
    @FXML private Hyperlink estoque;
    @FXML private Hyperlink compras; 
    @FXML private Hyperlink funcionarios;
   
    @FXML private Label erro;
    @FXML private Label gerente; 
    @FXML private Label codtipo;
    @FXML private Label preco;
    @FXML private Label nometipo;
    @FXML private Label quantidade;
    @FXML private Label situacao;
    @FXML private Label codigo; 
    @FXML private Label nome;
    @FXML private Label formavenda; 
    @FXML private Label marca;
   
    @FXML private ImageView save;
    @FXML private ImageView edit;
    @FXML private ImageView volta;
    
    ProdutosVO pvo = Telas.getPsel();
    ProdutosBO pbo = new ProdutosBO();
    boolean edita = false;
    private static boolean adicionar = false;
    
    
	public static boolean getAdicionar() {
		return adicionar;
	}

	public static void setAdicionar(boolean adicionar) {
		ControllerEstoqueEdit.adicionar = adicionar;
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		erro.setVisible(false);
		gerente.setText(Telas.getUser().getNome());
		nometipoEdit.setVisible(false);
		
		Tooltip.install(edit, new Tooltip("editar"));
		Tooltip.install(save, new Tooltip("salvar"));
		Tooltip.install(volta, new Tooltip("voltar"));
		
		if(!adicionar) {
			voltar();
			
			codtipo.setText("" + pvo.getTipo().getCodigo());
			preco.setText("" + pvo.getPreco());
			nometipo.setText(pvo.getTipo().getNome());
			quantidade.setText("" + pvo.getQuantidadeEstoque());
			situacao.setText(pvo.getSituacao());
			codigo.setText("" + pvo.getCodigo());
			nome.setText(pvo.getNome());
			formavenda.setText(pvo.getTipo().getFormaDeVenda());
			marca.setText(pvo.getMarca());
			
		} else adicionar();
		
		box();
	}
	
	public void box() {
		List<String> lista = new ArrayList<String>();
		
		TipoBO t = new TipoBO();
		List<TipoVO> tipos = t.listar();
		
		for(int i = 0; i < tipos.size(); i++) 
			lista.add(tipos.get(i).getNome());
		
		nometipoEdit.setItems(FXCollections.observableList(lista));
	}
	
	@FXML
	public void voltar() {
		if(edita) {
			codtipo.setVisible(true);
			preco.setVisible(true);
			nometipo.setVisible(true);
			quantidade.setVisible(true);
			situacao.setVisible(true);
			codigo.setVisible(true);
			nome.setVisible(true);
			formavenda.setVisible(true);
			marca.setVisible(true);
			edit.setVisible(true);
			
			precoEdit.setVisible(false);
			nometipoEdit.setVisible(false);
			quantidadeEdit.setVisible(false);
			nomeEdit.setVisible(false);
			marcaEdit.setVisible(false);
			save.setVisible(false);
			
			edita = false;
		} else Telas.telaEstoque();
	}

	@FXML
	public void adicionar() {
		preco.setVisible(false);
		nometipo.setVisible(false);
		quantidade.setVisible(false);
		nome.setVisible(false);
		marca.setVisible(false);
		edit.setVisible(false);
		
		precoEdit.setVisible(true);
		nometipoEdit.setVisible(true);
		quantidadeEdit.setVisible(true);
		nomeEdit.setVisible(true);
		marcaEdit.setVisible(true);
		save.setVisible(true);
	}

	@FXML
	public void editar() {
		edita = true;
		
		preco.setVisible(false);
		nometipo.setVisible(false);
		quantidade.setVisible(false);
		nome.setVisible(false);
		marca.setVisible(false);
		edit.setVisible(false);
		
		precoEdit.setVisible(true);
		nometipoEdit.setVisible(true);
		quantidadeEdit.setVisible(true);
		nomeEdit.setVisible(true);
		marcaEdit.setVisible(true);
		save.setVisible(true);
		
		precoEdit.setText("" + pvo.getPreco());
		quantidadeEdit.setText("" + pvo.getQuantidadeEstoque());
		nomeEdit.setText(pvo.getNome());
		marcaEdit.setText(pvo.getMarca());
	}

	@FXML
	public void salvar() {
		String s = nometipoEdit.getSelectionModel().getSelectedItem();
		if(s == null)
			s = pvo.getTipo().getNome();
		
		if(precoEdit.getText() == null || quantidadeEdit.getText() == null || nomeEdit.getText() == null || marcaEdit.getText() == null) {
			erro.setText("preencha todos os campos");
			erro.setVisible(true);
		} else {
			if(adicionar) {
				pvo = new ProdutosVO();
				pvo.setMarca(marcaEdit.getText());
				pvo.setNome(nomeEdit.getText());
				pvo.setPreco(Double.parseDouble(precoEdit.getText()));
				pvo.setQuantidadeEstoque(Integer.parseInt(quantidadeEdit.getText()));
				
				TipoVO t = new TipoVO();
				TipoBO tbo = new TipoBO();
				t.setNome(s);
				t = tbo.buscarNome(t);
				
				pvo.setTipo(t);
				
				pbo.adicionar(pvo);
				ControllerEstoqueEdit.adicionar = false;
				Telas.telaEstoque();
			} else {
				ProdutosVO p = new ProdutosVO();
				p.setMarca(marcaEdit.getText());
				p.setNome(nomeEdit.getText());
				p.setPreco(Double.parseDouble(precoEdit.getText()));
				p.setQuantidadeEstoque(Integer.parseInt(quantidadeEdit.getText()));
				
				TipoVO t = new TipoVO();
				TipoBO tbo = new TipoBO();
				t.setNome(s);
				t = tbo.buscarNome(t);
				
				p.setTipo(t);
				
				pbo.atualizar(pvo, p);
				Telas.telaEstoque();
			}
		}
	}

    @FXML
    public void goVendas(ActionEvent event) {
    	Telas.telaVendas();
    }

    @FXML
    public void goInicio(ActionEvent event) {
    	Telas.telaInicial();
    }

    @FXML
    public void goFuncionarios(ActionEvent event) {
    	Telas.telaFuncionarios();
    }

    @FXML
    public void goEstoque(ActionEvent event) {
    	Telas.telaEstoque();
    }

    @FXML
    public void goCompras(ActionEvent event) {
    	Telas.telaCompras();
    }

    @FXML
    public void goLogin(ActionEvent event) {
    	Telas.telaLogin();
    }
}

