package Model.VO;

//import Model.VO.ProdutosVO;
import java.util.Calendar;

public class VendasVO {
	private int codigo;
	private Calendar data;
	private Calendar hora;
	private int quantidadeProdutos;
	private double valor;
	private FuncionariosVO funcionario;
	private ProdutosVO produtos[];
	
    // getters e setters
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
		else 
			System.out.println("C�digo inv�lido");
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		if(data != null)
			this.data = data;
		else
			System.out.println("Data inv�lida!");
	}
	
	//hora
	
	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	
	public void setQuantidadeProdutos(int quantidadeProdutos) {
		if (quantidadeProdutos >= 0) 
			this.quantidadeProdutos = quantidadeProdutos;
		else
			System.out.println("Quantidade inv�lida!");
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor > 0) 
			this.valor = valor;
		else
			System.out.println("Valor inv�lido!");
	}
	
	public FuncionariosVO getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(FuncionariosVO funcionario) {
		if (funcionario != null) 
			this.funcionario = funcionario;
		else
			System.out.println("Funcion�rio inv�lido!");
	}
	
	public ProdutosVO[] getProduto() {
		return produtos;
	}
	
	public void setProduto(ProdutosVO[] produtos) {
		if (produtos != null)
			this.produtos = produtos;
		else
			System.out.println("C�digo inv�lido!");
	}
	
}
