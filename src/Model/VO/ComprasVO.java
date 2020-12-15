package Model.VO;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class ComprasVO {
	private int codigo;
	private Calendar data;
	private String dataS;
	private Calendar hora;
	private String horaS;
	private double valor;
	private List<ProdutosVO> produtos;
	private FuncionariosVO gerente;
	private String gerenteS;
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
		setDataS();
	}
	
	public void setData(Calendar data) {
		if(data != null) {
			this.data = data;
			setDataS();
		} else
			System.out.println("Data Inválida!");
	}
	
	public String getDataS() {
		return dataS;
	}
	
	public void setDataS() {
		dataS = getData(getData());
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
	
	public String getHora(Calendar hora) {
		return Util.formataHora(hora);
	}
	
	public Calendar getHora() {
		return hora;
	}
	
	public void setHora() {
		hora = Calendar.getInstance();
		setHoraS();
	}
	
	public void setHora(Calendar hora) {
		if(hora != null) {
			this.hora = hora;
			setHoraS();
		} else
			System.out.println("Hora Inválida!");
	}
	
	public void setHora(String h) {
		if (h!= null && !h.isEmpty()) {
			Calendar hora = Util.formataHora(h);
			if(hora != null) {		
				this.hora = hora;
				setHoraS();
			} else System.out.println("Hora inválida!");
		} else System.out.println("Hora inválida!");
	}
	
	public String getHoraS() {
		return horaS;
	}
	
	public void setHoraS() {
		horaS = getHora(getHora());
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
		if (gerente != null) {
			this.gerente = gerente;
			setGerenteS(gerente.getNome());
		} else
			System.out.println("Gerente inválido!");
	}
	
	public List <ProdutosVO> getProdutos() {
		return produtos;
	}
	
	public void setProdutos(List <ProdutosVO> produtos) {
		this.produtos = produtos;
	}
	
	public String getGerenteS() {
		return gerenteS;
	}
	
	public void setGerenteS(String gerenteS) {
		this.gerenteS = gerenteS;
	}
	
	public int getQuantidadeProdutos(){
		return quantidadeProdutos;
	}
    
	public void setQuantidadeProdutos(int qnt) {
		quantidadeProdutos = qnt;
	}
	
	public String toString(){
		String s = "ID: " + getCodigo() + " Valor: " + getValor() + " Funcionario: " + getGerente().getCodigo() + "\t" + getData(data) + " " + getHora(hora);
		List <ProdutosVO> produtos = getProdutos();
		Iterator<ProdutosVO> iterator = produtos.iterator();
		while (iterator.hasNext()) 
			s += "\n" + iterator.next();
		return s;
	}
	
}
