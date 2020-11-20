package Model.VO;

import java.util.ArrayList;
import java.util.Calendar;

public class ComprasVO {
	private int codigo;
	private Calendar data;
	private Calendar hora;
	private int quantidadeProdutos;
	private ArrayList <ProdutosVO> produtos;
	private double valor;
	private GerenteVO gerente;
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo(int codigo) {
		if (codigo > 0)
			this.codigo = codigo;
		else 
			System.out.println("Código inválido");
	}
	
	public String getData() {
		String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
		return d;
	}
	
	public void setData() {
		data = Calendar.getInstance();
	}
	
	public String getHora() {
		String h = hora.get(Calendar.HOUR) + ":" + hora.get(Calendar.MINUTE) + ":" + hora.get(Calendar.SECOND);
		return h;
	}
	
	public void setHora() {
		hora = Calendar.getInstance();
	}
	
	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}
	
	public void setQuantidadeProdutos(int quantidadeProdutos) {
		if (quantidadeProdutos >= 0) 
			this.quantidadeProdutos = quantidadeProdutos;
		else
			System.out.println("Quantidade inválida!");
	}
	
	public ArrayList <ProdutosVO> getProduto() {
		return produtos;
	}
	
	public void setProduto(ArrayList <ProdutosVO> produtos) {
		if (!produtos.isEmpty())
			this.produtos = produtos;
		else
			System.out.println("Produtos inválidos!");
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor > 0) 
			this.valor = valor;
		else
			System.out.println("Valor inválido!");
	}
	
	public GerenteVO getGerente() {
		return gerente;
	}
	
	public void setGerente(GerenteVO gerente) {
		if (gerente != null) 
			this.gerente = gerente;
		else
			System.out.println("Gerente inválido!");
	}
}
