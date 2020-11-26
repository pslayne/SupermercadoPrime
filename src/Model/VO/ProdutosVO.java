package Model.VO;

import java.util.concurrent.atomic.AtomicInteger;

public class ProdutosVO {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private String nome;
	private int codigo;
	private TipoVO tipo;
	private double preco;
	private float quantidadeEstoque;
	private float quantidadePedido;
	
	public ProdutosVO() {
		setCodigo();
	}
    
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
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo() {
		codigo = count.incrementAndGet();
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
	
	public float getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	
	public void setQuantidadeEstoque(float quantidadeEstoque) {
		if (quantidadeEstoque >= 0)
			this.quantidadeEstoque = quantidadeEstoque;
		else 
			System.out.println("Quantidade inválida");
	}
	
	public float getQuantidadePedido() {
		return quantidadePedido;
	}
	
	public void setQuantidadePedido(float quantidadePedido) {
		if (quantidadePedido >= 0)
			this.quantidadePedido = quantidadePedido;
		else 
			System.out.println("Quantidade inválida");
	}
}
