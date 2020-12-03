package Model.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
		String d;
		int ano = data.get(Calendar.YEAR);
		int mes = data.get(Calendar.MONTH);
		int dia = data.get(Calendar.DATE);
		
		if (dia < 10 && mes < 10)
			d = 0 + "" + dia + "/" + 0 + "" + mes + "/" + ano;
		else if (dia < 10)
			d = 0 + "" + dia + "/" + mes + "/" + ano;
		else if (mes < 10)
			d = dia + "/" + 0 + "" + mes + "/" + ano;
		else 
			d = dia + "/" + mes + "/" + ano;
		
		return d;
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
			System.out.println("Data Inv�lida!");
	}
	
	public void setData(String d) {
		if (d != null && !d.isEmpty()) {
			Calendar data = new GregorianCalendar();
			
			int dia = Integer.parseInt(d.substring(0, 2));
			int mes = Integer.parseInt(d.substring(3, 5));
			int ano = Integer.parseInt(d.substring(6, 10));
			
			if(dia > 0 && dia <= 31 && mes > 0 && mes <= 12)
				if (mes == 2 && dia > 28)
					System.out.println("Data de nascimento inv�lida!");
				else {
					data.set(ano, mes, dia);
					this.data = data;
				}
		}
	}
	
	public String getHora(Calendar hora) {
		int h = hora.get(Calendar.HOUR);
		int m = hora.get(Calendar.MINUTE);
		int s = hora.get(Calendar.SECOND);
		
		String r;
		
		if (h < 10 && m < 10 && s < 10)
			r = "0" + h + ":" + "0" + m + ":" + "0" + s;
		else if(h < 10 && m > 9 && s > 9)
			r = "0" + h + ":" + m + ":" + s;
		else if(h < 10 && m < 10 && s > 9)
			r = "0" + h + ":" + "0" + m + ":" + s;
		else if (h > 9 && m > 9 && s < 10)
			r = h + ":" + m + ":" + "0" + s;
		else if (h > 9 && m < 10 && s < 10)
			r = h + ":" + "0" + m + ":" + "0" + s;
		else if (h > 9 && m < 10 && s > 9)
			r = h + ":" + "0" + m + ":" + s;
		else
			r = h + ":" + m + ":" + s;
		
		return r;
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
			System.out.println("Hora Inv�lida!");
	}
	
	public void setHora(String h) {
		if (h != null && !h.isEmpty()) {
			Calendar hora = new GregorianCalendar();
			
			int hr = Integer.parseInt(h.substring(0, 2));
			int m = Integer.parseInt(h.substring(3, 5));
			int s = Integer.parseInt(h.substring(6, 8));
			
			if(hr >= 0 && hr <= 24 && m >= 0 && m <= 59 && s >= 0 && s <= 59) {
				hora.set(1, 1, 1, hr, m, s);
				this.hora = hora;
			}
		}
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		if (valor > 0) 
			this.valor = valor;
		else
			System.out.println("Valor inv�lido!");
	}
	
	public FuncionariosVO getGerente() {
		return gerente;
	}
	
	public void setGerente(FuncionariosVO gerente) {
		if (gerente != null) 
			this.gerente = gerente;
		else
			System.out.println("Gerente inv�lido!");
	}
	
	public ArrayList <ProdutosVO> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(ArrayList <ProdutosVO> produtos) {
		if (!produtos.isEmpty())
			this.produtos = produtos;
		else
			System.out.println("Produtos inv�lidos!");
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
