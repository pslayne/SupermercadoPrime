package Model.VO;

public class Produtos {
	
	private String nome;
	private int codigo;
	private int codigoTipo;
	private double preco;
    
    // getters e setters
    
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		if(codigo>0)
		    this.codigo = codigo;
		else
			System.out.println("Código inválido");
	}
	
	public int getCodigoTipo() {
		return codigoTipo;
	}
	
	public void setCodigoTipo(int codigoTipo) {
		if(codigoTipo>0)
		   this.codigoTipo = codigoTipo;
		else
			System.out.println("Código inválido");
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
}
