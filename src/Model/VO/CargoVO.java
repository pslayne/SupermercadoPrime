package Model.VO;

import java.util.concurrent.atomic.AtomicInteger;

public class CargoVO {
	private static final AtomicInteger count = new AtomicInteger(0);
	private String nome;
	private int codigo;
	
    // getters e setters
    
	public CargoVO() {
		setCodigo();
	}
	
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
}
