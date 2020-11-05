package Model.VO;

public class Estoque {
	
	private Produtos produto;
	private int quantidade;
	private String situacao;

    // getters e setters
    
	public Produtos getProduto() {
		return produto;
	}
	
	public void setProduto(Produtos produto) {
		if(produto != null)
		  this.produto = produto;
		else
			System.out.println("Produto inv�lido");
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		if (quantidade >= 0) 
			this.quantidade = quantidade;
		else
			System.out.println("Quantidade inv�lida!");
	}
	
	public String getSituacao() {
		if (situacao == null)
			return "";
		return situacao;
	}
	
	public void setSituacao(String situacao) {
		if (situacao != null && !situacao.isEmpty()) {
			this.situacao = situacao;
		} else {
			System.out.println("Situa��o inv�lida!");
		}
	}
}
