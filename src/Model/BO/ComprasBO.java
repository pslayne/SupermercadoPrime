package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.DAO.ComprasDAO;
import Model.VO.ComprasVO;
import Model.VO.FuncionariosVO;
import Model.VO.ProdutosVO;

public class ComprasBO implements InterComprasBO{
	ComprasDAO dao = new ComprasDAO();
	
	public void adicionar(ComprasVO compra) {
		if(compra != null) {
			
			FuncionariosBO func = new FuncionariosBO();
			FuncionariosVO f = func.buscarID(compra.getGerente());
			if(f != null && f.getCargo().getNome().equalsIgnoreCase("gerente")) {
				dao.inserir(compra);
				ProdutosBO estoque = new ProdutosBO();
				estoque.atualizar(compra.getProdutos(), "compra");
			} else System.out.println("Funcionário inválido");
		} else System.out.println("Compra inválida");
	}
	
	public void remover(ComprasVO compra) {
		if(compra != null) {
			List<ComprasVO> resultado = buscarID(compra);
			if(!resultado.isEmpty()) 
				dao.remover(compra);
			else System.out.println("Esta compra não existe");
		} else System.out.println("Compra inválida");
	}
	
	public List<ComprasVO> buscarID(ComprasVO compra) {
		List<ComprasVO> lista = listar();
		ArrayList<ComprasVO> busca = new ArrayList<ComprasVO>();
		
		Iterator<ComprasVO> iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			ComprasVO c = iterator.next();
			
			if(c.getCodigo() == compra.getCodigo())
				busca.add(c);
		}
		
		return busca;
	}
	
	public List<ComprasVO> buscarGerenteNome(ComprasVO compra){
		ArrayList<ComprasVO> retorno = new ArrayList<ComprasVO>();
		
		FuncionariosBO func = new FuncionariosBO();
		List<FuncionariosVO> f = func.buscarNome(compra.getGerente());
		Iterator<FuncionariosVO> it = f.iterator();
		
		while(it.hasNext()) {
			compra.setGerente(it.next());
			retorno.addAll(buscarGerenteID(compra));
		}
		
		return retorno;
	}
	
	public List<ComprasVO> buscarGerenteID(ComprasVO compra){
		List<ComprasVO> lista = listar();
		ArrayList<ComprasVO> busca = new ArrayList<ComprasVO>();
		
		Iterator<ComprasVO> iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			ComprasVO c = iterator.next();
			
			if(c.getGerente().getCodigo() == compra.getGerente().getCodigo())
				busca.add(c);
		}
		
		return busca;
	}
	
	public List<ComprasVO> buscarData(ComprasVO compra){
		ResultSet rs = dao.buscarData(compra);
		ArrayList<ComprasVO> compras = new ArrayList<ComprasVO>();
		
		int ultimoId = 0, cont = -1;
		try {
			while(rs.next()) {
				ComprasVO c = new ComprasVO();
				
				if(ultimoId != rs.getInt("id_compra")) {
					ultimoId = rs.getInt("id_compra");
					c.setCodigo(rs.getInt("id_compra")); 
					
					String d = rs.getString("datacompra");
					int ano = Integer.parseInt(d.substring(0, 4));
					int mes = Integer.parseInt(d.substring(5, 7));
					int dia = Integer.parseInt(d.substring(8, 10));
					
					if (dia < 10 && mes < 10)
						d = 0 + "" + dia + "/" + 0 + "" + mes + "/" + ano;
					else if (dia < 10)
						d = 0 + "" + dia + "/" + mes + "/" + ano;
					else if (mes < 10)
						d = dia + "/" + 0 + "" + mes + "/" + ano;
					else 
						d = dia + "/" + mes + "/" + ano;
					
					c.setData(d);
					c.setHora(rs.getString("hora"));
					
					FuncionariosBO func = new FuncionariosBO();
					FuncionariosVO f = new FuncionariosVO();
					f.setCodigo(rs.getInt("id_func"));
					f = func.buscarID(f);
					c.setGerente(f);
					
					ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
					ProdutosVO prod = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prod.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prod);
					prod = resultadop.get(0);
					prod.setQuantidadePedido(rs.getInt("quant_produtos"));
					produtos.add(prod);
					
					c.setProdutos(produtos);
					
					cont++;
					compras.add(c);
				} else {
					ProdutosVO prodt = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prodt.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prodt);
					prodt = resultadop.get(0);
					prodt.setQuantidadePedido(rs.getInt("quant_produtos"));
					compras.get(cont).getProdutos().add(prodt);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<ComprasVO> iterator = compras.iterator();
		ArrayList<ComprasVO> comprasR = new ArrayList<ComprasVO>();
		
		while(iterator.hasNext()) {
			ComprasVO c = iterator.next();
			Iterator<ProdutosVO> iteratorp = c.getProdutos().iterator();
			double valor = 0.0;
			
			while(iteratorp.hasNext()) {
				ProdutosVO produto = iteratorp.next();
				valor += produto.getPreco() * produto.getQuantidadePedido();
			}
			
			c.setValor(valor);
			comprasR.add(c);
		}
			
		return comprasR;
	}
	
	public List<ComprasVO> listar(){
		ResultSet rs = dao.listar();
		ArrayList<ComprasVO> compras = new ArrayList<ComprasVO>();
		
		int ultimoId = 0, cont = -1;
		try {
			while(rs.next()) {
				ComprasVO c = new ComprasVO();
				
				if(ultimoId != rs.getInt("id_compra")) {
					ultimoId = rs.getInt("id_compra");
					c.setCodigo(rs.getInt("id_compra")); 
					
					String d = rs.getString("datacompra");
					int ano = Integer.parseInt(d.substring(0, 4));
					int mes = Integer.parseInt(d.substring(5, 7));
					int dia = Integer.parseInt(d.substring(8, 10));
					
					if (dia < 10 && mes < 10)
						d = 0 + "" + dia + "/" + 0 + "" + mes + "/" + ano;
					else if (dia < 10)
						d = 0 + "" + dia + "/" + mes + "/" + ano;
					else if (mes < 10)
						d = dia + "/" + 0 + "" + mes + "/" + ano;
					else 
						d = dia + "/" + mes + "/" + ano;
					
					c.setData(d);
					c.setHora(rs.getString("hora"));
					
					FuncionariosBO func = new FuncionariosBO();
					FuncionariosVO f = new FuncionariosVO();
					f.setCodigo(rs.getInt("id_func"));
					f = func.buscarID(f);
					
					ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
					ProdutosVO prod = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prod.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prod);
					prod = resultadop.get(0);
					prod.setQuantidadePedido(rs.getInt("quant_produtos"));
					produtos.add(prod);
					
					c.setProdutos(produtos);
					c.setGerente(f);
					cont++;
					compras.add(c);
				} else {
					ProdutosVO prodt = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prodt.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prodt);
					prodt = resultadop.get(0);
					prodt.setQuantidadePedido(rs.getInt("quant_produtos"));
					compras.get(cont).getProdutos().add(prodt);
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Iterator<ComprasVO> iterator = compras.iterator();
		ArrayList<ComprasVO> comprasR = new ArrayList<ComprasVO>();
		
		while(iterator.hasNext()) {
			ComprasVO compra = iterator.next();
			Iterator<ProdutosVO> iteratorp = compra.getProdutos().iterator();
			double valor = 0.0;
			
			while(iteratorp.hasNext()) {
				ProdutosVO produto = iteratorp.next();
				valor += produto.getPreco() * produto.getQuantidadePedido();
			}
			
			compra.setValor(valor);
			comprasR.add(compra);
		}
			
		return comprasR;
	}
	
	public void mostrar(List<ComprasVO> compras) {
		Iterator<ComprasVO> iterator = compras.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
