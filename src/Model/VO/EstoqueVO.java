package Model.VO;

public class EstoqueVO {
	
	private ProdutosVO produto;
	private int quantidade;
	private String situacao;

    // getters e setters
    
	public ProdutosVO getProduto() {
		return produto;
	}
	
	public void setProduto(ProdutosVO produto) {
		if(produto != null)
		  this.produto = produto;
		else
			System.out.println("Produto inválido");
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		if (quantidade >= 0) 
			this.quantidade = quantidade;
		else
			System.out.println("Quantidade inválida!");
	}
	
	public String getSituacao() {
		if (situacao == null)
			return "";
		else
			return situacao;
	}
	
	public void setSituacao(String situacao) {
		if (situacao != null && !situacao.isEmpty())
			this.situacao = situacao;
		else
			System.out.println("Situação inválida!");
	}
}
