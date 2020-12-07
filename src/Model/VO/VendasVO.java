package Model.VO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VendasVO {
	
	private int codigo;
	private Calendar data;
	private Calendar hora;
	private double valor;
	private FuncionariosVO caixa;
	private ArrayList <ProdutosVO> produtos;
	
    // getters e setters
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public Calendar getData() {
		return data;
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
			Calendar data = new GregorianCalendar();
			
			int dia = Integer.parseInt(d.substring(0, 2));
			int mes = Integer.parseInt(d.substring(3, 5));
			int ano = Integer.parseInt(d.substring(6, 10));
			
			if(dia > 0 && dia <= 31 && mes > 0 && mes <= 12)
				if (mes == 2 && dia > 28)
					System.out.println("Data de nascimento inválida!");
				else {
					data.set(ano, mes, dia);
					this.data = data;
				}
		}
	}
	
	public Calendar getHora() {
		return hora;
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
			System.out.println("Valor inválido!");
	}
	
	public FuncionariosVO getCaixa() {
		return caixa;
	}
	
	public void setCaixa(FuncionariosVO caixa) {
		if (caixa != null) 
			this.caixa = caixa;
		else
			System.out.println("Caixa inválido!");
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
