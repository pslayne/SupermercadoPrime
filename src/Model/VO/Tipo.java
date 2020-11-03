package Model.VO;

public class Tipo {

	private String nome;
	private String formaDeVenda;
	private int codigo;

    // getters e setters
    
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getFormaDeVenda() {
		return formaDeVenda;
	}
	
	public void setFormaDeVenda(String formaDeVenda) {
		this.formaDeVenda = formaDeVenda;
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
	
}
