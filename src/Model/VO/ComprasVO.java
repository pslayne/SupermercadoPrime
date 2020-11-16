package Model.VO;

import java.util.Calendar;

public class ComprasVO {
	private int codigo;
	private Calendar data;
	private Calendar hora;
	private int quantidadeProdutos;
	private ProdutosVO[] produtos;
	private double valor;
	private GerenteVO gerente;
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
		else 
			System.out.println("C�digo inv�lido");
	}
	
	//data e hora
	
	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	
	public void setQuantidadeProdutos(int quantidadeProdutos) {
		if (quantidadeProdutos >= 0) 
			this.quantidadeProdutos = quantidadeProdutos;
		else
			System.out.println("Quantidade inv�lida!");
	}
	
	//produtos
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor > 0) 
			this.valor = valor;
		else
			System.out.println("Valor inv�lido!");
	}
	
	public GerenteVO getGerente() {
		return gerente;
	}
	
	public void setGerente(GerenteVO gerente) {
		if (gerente != null) 
			this.gerente = gerente;
		else
			System.out.println("Gerente inv�lido!");
	}
}
