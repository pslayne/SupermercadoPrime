package Model.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class ComprasVO {
	private int codigo;
	private Calendar data;
	private Calendar hora;
	private double valor;
	private ArrayList<ProdutosVO> produtos;
	private FuncionariosVO gerente;
	private int quantidadeProdutos;
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public String getData(Calendar data) {
		return Util.formataData(data);
	}
	
	public Calendar getData() {
		return data;
	}
	
	public void setData() {
		data = Calendar.getInstance();
	}
	
	public void setData(Calendar data) {
		if(data != null)
			this.data = data;
		else
			System.out.println("Data Inválida!");
	}
	
	public void setData(String d) {
		if (d != null && !d.isEmpty()) {
			Calendar data = Util.formataData(d);
			if(data != null)		
				this.data = data;
			else System.out.println("Data inválida!");
		} else System.out.println("Data inválida!");
	}
	
	public String getHora(Calendar hora) {
		return Util.formataHora(hora);
	}
	
	public Calendar getHora() {
		return hora;
	}
	
	public void setHora() {
		hora = Calendar.getInstance();
	}
	
	public void setHora(Calendar hora) {
		if(hora != null)
			this.hora = hora;
		else
			System.out.println("Hora Inválida!");
	}
	
	public void setHora(String h) {
		if (h!= null && !h.isEmpty()) {
			Calendar hora = Util.formataHora(h);
			if(hora != null)		
				this.hora = hora;
			else System.out.println("Hora inválida!");
		} else System.out.println("Hora inválida!");
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
	
	public FuncionariosVO getGerente() {
		return gerente;
	}
	
	public void setGerente(FuncionariosVO gerente) {
		if (gerente != null) 
			this.gerente = gerente;
		else
			System.out.println("Gerente inválido!");
	}
	
	public ArrayList <ProdutosVO> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ArrayList <ProdutosVO> produtos) {
		if (!produtos.isEmpty())
			this.produtos = produtos;
		else
			System.out.println("Produtos inválidos!");
	}
	
	public int getQuantidadeProdutos(){
		return quantidadeProdutos;
	}
    
	public void setQuantidadeProdutos(int qnt) {
		quantidadeProdutos = qnt;
	}
	
	public String toString(){
		String s = "ID: " + getCodigo() + " Valor: " + getValor() + " Funcionario: " + getGerente().getCodigo() + "\t" + getData(data) + " " + getHora(hora);
		ArrayList <ProdutosVO> produtos = getProdutos();
		Iterator<ProdutosVO> iterator = produtos.iterator();
		while (iterator.hasNext()) 
			s += "\n" + iterator.next();
		return s;
	}
	
}
