package Model.BO;

import Model.VO.*;
//import Model.BO.*;

public class GerenteBO extends FuncionariosBO{
	GerenteVO gerente = new GerenteVO();
	
	public static void adicionar(GerenteVO gerente) {
		//chama o adicionar da super e acrescenta o cargo
	}
	
	public static void editar(GerenteVO gerente) {
		//chama o editar da super e adiciona a atualização do cargo
	}
	
	public static void buscar(GerenteVO gerente) {
		//busca entre os gerente no banco de dados
	}
	
	public static void listar() {
		//lista todos os gerentes que resultaram da busca
	}
	
	public static void verFuncionarios() {
		FuncionariosBO.listar();
	}
	
	public static void adicionarTipo(TipoVO tipo) {
		TipoBO.adicionar(tipo);
	}
	
	public static void editarTipo(TipoVO tipo) {
		TipoBO.editar(tipo);
	}
	
	public static void removerTipo(TipoVO tipo) {
		TipoBO.remover(tipo);
	}
	
	public static void realizarCompra(ComprasVO compra) {
		ComprasBO.adicionar(compra);
	}
	
	public static void cancelarVenda(VendasVO venda) {
		VendasBO.cancelar(venda);
	}
	
	public static void verVendas() {
		VendasBO.listar();
	}
	
	public static void verCompras() {
		ComprasBO.listar();
	}
}
