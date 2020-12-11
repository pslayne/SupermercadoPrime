package Model.VO;

public class ProdutosVO {
	
	private String nome;
	private String marca;
	private int codigo;
	private TipoVO tipo;
	private double preco;
	private double precoTotal;
	private int quantidadeEstoque;
	private int quantidadePedido;
	
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
			System.out.println("Nome inválido!");
	}
	
	public String getMarca() {
		if (marca == null)
			return "";
		else
			return marca;
	}
	
	public void setMarca(String marca) {
		if (marca != null && !marca.isEmpty())
			this.marca = marca;
		else
			System.out.println("Marca inválida!");
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public TipoVO getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoVO tipo) {
		if(tipo != null)
		   this.tipo = tipo;
		else
			System.out.println("Tipo inválido");
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) {
		if(preco>0) 
		  this.preco = preco;
		else
			System.out.println("Preço inválido");
	}
	
	public double getPrecoTotal() {
		return precoTotal;
	}
	
	public void setPrecoTotal(double precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		if (quantidadeEstoque >= 0)
			this.quantidadeEstoque = quantidadeEstoque;
		else 
			System.out.println("Quantidade inválida");
	}
	
	public int getQuantidadePedido() {
		return quantidadePedido;
	}
	
	public void setQuantidadePedido(int quantidadePedido) {
		if (quantidadePedido >= 0)
			this.quantidadePedido = quantidadePedido;
		else 
			System.out.println("Quantidade inválida");
	}
	
	public String toString() {
		String s = getCodigo() + " " + getNome() + " " + getMarca();
		return s;
	}
}
