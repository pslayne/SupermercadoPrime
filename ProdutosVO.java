package Model.VO;

public class ProdutosVO {
	
	private String nome;
	private int codigo;
	private TipoVO tipo;
	private double preco;
	private float quantidadeEstoque;
	private float quantidadePedido;
	
    
    // getters e setters
    
	public String getNome() {
		if (nome == null)
			return "";
		else
			return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty())
			this.nome = nome;
		else
			System.out.println("Nome inv�lido!");
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		if(codigo>0)
		    this.codigo = codigo;
		else
			System.out.println("C�digo inv�lido");
	}
	
	public TipoVO getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoVO tipo) {
		if(tipo != null)
		   this.tipo = tipo;
		else
			System.out.println("Tipo inv�lido");
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		if(preco>0)
		  this.preco = preco;
		else
			System.out.println("Pre�o inv�lido");
	}
	
	public float getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(float quantidadeEstoque) {
		if (quantidadeEstoque >= 0)
			this.quantidadeEstoque = quantidadeEstoque;
		else 
			System.out.println("Quantidade inv�lida");
	}
	
	public float getQuantidadePedido() {
		return quantidadePedido;
	}
	
	public void setQuantidadePedido(float quantidadePedido) {
		if (quantidadePedido >= 0)
			this.quantidadePedido = quantidadePedido;
		else 
			System.out.println("Quantidade inv�lida");
	}
}
