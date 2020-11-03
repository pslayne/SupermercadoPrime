package Model.VO;

public class Estoque {
	
	private int codigoProduto;
	private int quantidade;
	private String situacao;
	private int codigo;

    // getters e setters
    
	public int getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(int codigoProduto) {
		if(codigoProduto>0)
		  this.codigoProduto = codigoProduto;
		else
			System.out.println("Código inválido");
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getSituacao() {
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
