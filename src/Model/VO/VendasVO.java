package Model.VO;

import java.util.List;
import java.util.Calendar;

public class VendasVO {
	
	private int codigo;
	private int quantidade;
	private Calendar data;
	private String dataS;
	private Calendar hora;
	private String horaS;
	private double valor;
	private FuncionariosVO caixa;
	private String caixaS;
	private List <ProdutosVO> produtos;
	
    // getters e setters
	
	public int getCodigo(){
		return codigo;
	}
    
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public int getQuantidade(){
		return quantidade;
	}
    
	public void setQuantidade(int quantidade) {
		if(quantidade > 0)
			this.quantidade = quantidade;
		else
			System.out.println("quantidade inválida");
	}
	
	public Calendar getData() {
		return data;
	}
	
	public String getData(Calendar data) {
		return Util.formataData(data);
	}
	
	public void setData() {
		data = Calendar.getInstance();
	}
	
	public void setData(Calendar data) {
		if(data != null) {
			this.data = data;
			setDataS();
		} else
			System.out.println("Data Inválida!");
	}
	
	public void setData(String d) {
		if (d != null && !d.isEmpty()) {
			Calendar data = Util.formataData(d);
			if(data != null) {		
				this.data = data;
				setDataS();
			} else System.out.println("Data inválida!");
		} else System.out.println("Data inválida!");
	}
	
	public String getDataS() {
		return dataS;
	}
	
	public void setDataS() {
		dataS = getData(getData());
	}
	
	public Calendar getHora() {
		return hora;
	}
	
	public void setHora() {
		hora = Calendar.getInstance();
		setHoraS(hora);
	}
	
	public void setHora(Calendar hora) {
		if(hora != null) {
			this.hora = hora;
			setHoraS(hora);
		} else
			System.out.println("Hora Inválida!");
	}
	
	public void setHora(String h) {
		if (h!= null && !h.isEmpty()) {
			Calendar hora = Util.formataHora(h);
			if(hora != null) {		
				this.hora = hora;
				setHoraS(hora);
			} else System.out.println("Hora inválida!");
		} else System.out.println("Hora inválida!");
	}
	
	public String getHoraS() {
		return horaS;
	}
	
	public void setHoraS(Calendar hora) {
		horaS = Util.formataHora(hora);
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
		if (caixa != null) {
			this.caixa = caixa;
			setCaixaS(caixa.getNome());
		} else
			System.out.println("Caixa inválido!");
	}
	
	public String getCaixaS() {
		return caixaS;
	}
	
	public void setCaixaS(String caixaS) {
		this.caixaS = caixaS;
	}
	
	public List <ProdutosVO> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List <ProdutosVO> produtos) {
			this.produtos = produtos;
	}
	
	public String toString() {
		String r = getCodigo() + " " + getData(getData()) + " " + getHoraS() + "\n";
		r = r + getCaixa().getNome() + " " + getValor() + " " + getQuantidade(); 
		return r;
	}
}
