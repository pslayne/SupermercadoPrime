package Model.VO;

import java.util.Calendar;

public class Vendas {
	private Calendar data;
	private int quantidadeItens;
	private double valor;
	private Funcionarios funcionario;
	private Produtos produto;
	
    // getters e setters
    
	public Calendar getData() {
		return data;
	}
	
	public void setData(Calendar data) {
		if(data != null) { 
			this.data = data;
		} else {
			System.out.println("Data inválida!");
			
		}
	}
	
	public int getQuantidadeItens() {
		return quantidadeItens;
	}
	
	public void setQuantidadeItens(int quantidadeItens) {
		if (quantidadeItens >= 0) 
			this.quantidadeItens = quantidadeItens;
		else
			System.out.println("Quantidade inválida!");
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor >= 0) 
			this.valor = valor;
		else
			System.out.println("Valor inválido!");
	}
	
	public Funcionarios getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(Funcionarios funcionario) {
		if (funcionario != null) 
			this.funcionario = funcionario;
		else
			System.out.println("Código inválido!");
	}
	
	public Produtos getProduto() {
		return produto;
	}
	
	public void setProduto(Produtos produto) {
		if (produto != null)
			this.produto = produto;
		else
			System.out.println("Código inválido!");
	}
	
}
