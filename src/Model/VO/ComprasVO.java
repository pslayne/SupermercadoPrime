package Model.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;

public class ComprasVO {
	private static final AtomicInteger count = new AtomicInteger(0);
	private int codigo;
	private Calendar data;
	private Calendar hora;
	private double valor;
	private ArrayList<ProdutosVO> produtos;
	private FuncionariosVO gerente;
	
	public ComprasVO() {
		setCodigo();
	}
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo() {
		codigo = count.incrementAndGet();
	}
	
	public String getData() {
		String d = data.get(Calendar.DATE) + "/" + data.get(Calendar.MONTH) + "/" + data.get(Calendar.YEAR);
		return d;
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
	
	public String getHora() {
		String h = hora.get(Calendar.HOUR) + ":" + hora.get(Calendar.MINUTE) + ":" + hora.get(Calendar.SECOND);
		return h;
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
}
