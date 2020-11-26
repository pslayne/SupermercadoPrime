package Model.VO;

import java.util.concurrent.atomic.AtomicInteger;

public class TipoVO {
	
	private static final AtomicInteger count = new AtomicInteger(0);
	private String nome;
	private String formaDeVenda;
	private int codigo;

	public TipoVO() {
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
	
	public String getFormaDeVenda() {
		if (formaDeVenda == null)
			return "";
		else
			return formaDeVenda;
	}
	
	public void setFormaDeVenda(String formaDeVenda) {
		if (formaDeVenda != null && !formaDeVenda.isEmpty())
			this.formaDeVenda = formaDeVenda;
		else System.out.println("Forma de venda inválida!");
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo() {
		codigo = count.incrementAndGet();
	}
	
}
