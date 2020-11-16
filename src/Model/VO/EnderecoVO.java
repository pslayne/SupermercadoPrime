package Model.VO;

public class EnderecoVO {
	private static String pais = "Brasil";
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private String complemento;
	
	public EnderecoVO(String estado, String cidade, String bairro, String rua, int numero, String complemento) {
		setEstado(estado);
		setCidade(cidade);
		setBairro(bairro);
		setRua(rua);
		setNumero(numero);
		setComplemento(complemento);
	}
	
	public EnderecoVO(String estado, String cidade, String bairro, String rua, int numero) {
		setEstado(estado);
		setCidade(cidade);
		setBairro(bairro);
		setRua(rua);
		setNumero(numero);
	}
	
	public String getEstado() {
		if (estado == null)
			return "";
		else
			return estado;
	}
	
	public void setEstado(String estado) {
		if (estado != null && !estado.isEmpty()) {
			this.estado = estado.toUpperCase();
		} else 
			System.out.println("Estado inv�lido!");
	}
	
	public String getCidade() {
		if (cidade == null)
			return "";
		else
			return cidade;
	}
	
	public void setCidade(String cidade) {
		if (cidade != null && !cidade.isEmpty()) {
			this.cidade = cidade.toUpperCase();
		} else 
			System.out.println("Cidade inv�lido!");
	}
	
	public String getBairro() {
		if (bairro == null)
			return "";
		else
			return bairro;
	}
	
	public void setBairro(String bairro) {
		if (bairro != null && !bairro.isEmpty()) {
			this.bairro = bairro.toUpperCase();
		} else 
			System.out.println("Bairro inv�lido!");
	}
	
	public String getRua() {
		if (rua == null)
			return "";
		else
			return rua;
	}
	
	public void setRua(String rua) {
		if (rua != null && !rua.isEmpty()) {
			this.rua = rua.toUpperCase();
		} else 
			System.out.println("Rua inv�lida!");
	}
	
	public int getNumero() {
			return numero;
	}
	
	public void setNumero(int numero) {
		if (numero > 0) {
			this.numero = numero;
		} else 
			System.out.println("N�mero inv�lido!");
	}
	
	public String getComplemento() {
		if (complemento == null)
			return "";
		else
			return complemento;
	}
	
	public void setComplemento(String complemento) {
		if (complemento != null && !complemento.isEmpty()) {
			this.complemento = complemento.toUpperCase();
		} else 
			System.out.println("Complemento inv�lido!");
	}
}