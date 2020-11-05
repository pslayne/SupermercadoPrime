package Model.VO;

public class Produtos {
	
	private String nome;
	private int codigo;
	private Tipo tipo;
	private double preco;
    
    // getters e setters
    
	public String getNome() {
		if (nome == null)
			return "";
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome != null && !nome.isEmpty()) {
			this.nome = nome;
		} else {
			System.out.println("Nome inv�lido!");
		}
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
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
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
}
