package Model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.DAO.VendasDAO;
import Model.VO.FuncionariosVO;
import Model.VO.ProdutosVO;
import Model.VO.VendasVO;

public class VendasBO implements InterVendasBO{
	VendasDAO dao = new VendasDAO();
	
	public void adicionar(VendasVO venda) {
		if(venda != null) {
			List<VendasVO> resultado = buscarID(venda);
			if(resultado.isEmpty()) {
				dao.inserir(venda);
				ProdutosBO estoque = new ProdutosBO();
				estoque.atualizar(venda.getProdutos(), "venda");
			} else System.out.println("Esta venda já existe");
		} else System.out.println("Venda inválida");
	}

	public void remover(VendasVO venda) {
		if(venda != null) {
			List<VendasVO> resultado = buscarID(venda);
			if(!resultado.isEmpty()) {
				dao.remover(venda);
			} else System.out.println("Esta venda não existe");
		} else System.out.println("Venda inválida");
	}

	public List<VendasVO> buscarID(VendasVO venda) {
		List<VendasVO> lista = listar();
		ArrayList<VendasVO> busca = new ArrayList<VendasVO>();
		
		Iterator<VendasVO> iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			VendasVO c = iterator.next();
			
			if(c.getCodigo() == venda.getCodigo())
				busca.add(c);
		}
		
		return busca;
	}

	public List<VendasVO> buscarCaixaNome(VendasVO venda) {
		ArrayList<VendasVO> retorno = new ArrayList<VendasVO>();
		
		FuncionariosBO func = new FuncionariosBO();
		List<FuncionariosVO> f = func.buscarNome(venda.getCaixa());
		Iterator<FuncionariosVO> it = f.iterator();
		
		while(it.hasNext()) {
			venda.setCaixa(it.next());
			retorno.addAll(buscarCaixaID(venda));
		}
		
		return retorno;
	}

	public List<VendasVO> buscarCaixaID(VendasVO venda) {
		List<VendasVO> lista = listar();
		ArrayList<VendasVO> busca = new ArrayList<VendasVO>();
		
		Iterator<VendasVO> iterator = lista.iterator();
		
		while(iterator.hasNext()) {
			VendasVO c = iterator.next();
			
			if(c.getCaixa().getCodigo() == venda.getCaixa().getCodigo())
				busca.add(c);
		}
		
		return busca;
	}

	public List<VendasVO> buscarData(VendasVO venda) {
		ResultSet rs = dao.buscarData(venda);
		ArrayList<VendasVO> vendas = new ArrayList<VendasVO>();
		
		int ultimoId = 0, cont = -1;
		try {
			while(rs.next()) {
				VendasVO v = new VendasVO();
				
				if(ultimoId != rs.getInt("id_venda")) {
					ultimoId = rs.getInt("id_venda");
					v.setCodigo(rs.getInt("id_venda")); 
					
					String d = rs.getString("datavenda");
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
					
					v.setData(d);
					v.setHora(rs.getString("hora"));
					
					FuncionariosBO func = new FuncionariosBO();
					FuncionariosVO f = new FuncionariosVO();
					f.setCodigo(rs.getInt("id_func"));
					f = func.buscarID(f);
					v.setCaixa(f);
					
					ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
					ProdutosVO prod = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prod.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prod);
					prod = resultadop.get(0);
					prod.setQuantidadePedido(rs.getInt("quant_produtos"));
					produtos.add(prod);
					
					v.setProdutos(produtos);
					
					cont++;
					vendas.add(v);
				} else {
					ProdutosVO prodt = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prodt.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prodt);
					prodt = resultadop.get(0);
					prodt.setQuantidadePedido(rs.getInt("quant_produtos"));
					vendas.get(cont).getProdutos().add(prodt);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<VendasVO> iterator = vendas.iterator();
		ArrayList<VendasVO> vendasR = new ArrayList<VendasVO>();
		
		while(iterator.hasNext()) {
			VendasVO c = iterator.next();
			Iterator<ProdutosVO> iteratorp = c.getProdutos().iterator();
			double valor = 0.0;
			
			while(iteratorp.hasNext()) {
				ProdutosVO produto = iteratorp.next();
				valor += produto.getPreco() * produto.getQuantidadePedido();
			}
			
			c.setValor(valor);
			vendasR.add(c);
		}
			
		return vendasR;
	}
	
	public List<VendasVO> listar(){
		ResultSet rs = dao.listar();
		ArrayList<VendasVO> vendas = new ArrayList<VendasVO>();
		
		int ultimoId = 0, cont = -1;
		try {
			while(rs.next()) {
				VendasVO v = new VendasVO();
				
				if(ultimoId != rs.getInt("id_venda")) {
					ultimoId = rs.getInt("id_venda");
					v.setCodigo(rs.getInt("id_venda")); 
					
					String d = rs.getString("datavenda");
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
					
					v.setData(d);
					v.setHora(rs.getString("hora"));
					
					FuncionariosBO func = new FuncionariosBO();
					FuncionariosVO f = new FuncionariosVO();
					f.setCodigo(rs.getInt("id_func"));
					f = func.buscarID(f);
					v.setCaixa(f);
					
					ArrayList<ProdutosVO> produtos = new ArrayList<ProdutosVO>();
					ProdutosVO prod = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prod.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prod);
					prod = resultadop.get(0);
					prod.setQuantidadePedido(rs.getInt("quant_produtos"));
					produtos.add(prod);
					
					v.setProdutos(produtos);
					
					cont++;
					vendas.add(v);
				} else {
					ProdutosVO prodt = new ProdutosVO(); 
					ProdutosBO pbo = new ProdutosBO();
					prodt.setCodigo(rs.getInt("cod_produto"));
					ArrayList<ProdutosVO> resultadop = pbo.buscarID(prodt);
					prodt = resultadop.get(0);
					prodt.setQuantidadePedido(rs.getInt("quant_produtos"));
					vendas.get(cont).getProdutos().add(prodt);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Iterator<VendasVO> iterator = vendas.iterator();
		ArrayList<VendasVO> vendasR = new ArrayList<VendasVO>();
		
		while(iterator.hasNext()) {
			VendasVO c = iterator.next();
			Iterator<ProdutosVO> iteratorp = c.getProdutos().iterator();
			double valor = 0.0;
			
			while(iteratorp.hasNext()) {
				ProdutosVO produto = iteratorp.next();
				valor += produto.getPreco() * produto.getQuantidadePedido();
			}
			
			c.setValor(valor);
			vendasR.add(c);
		}
			
		return vendasR;
	}
	
	public void mostrar(List<VendasVO> vendas) {
		Iterator<VendasVO> iterator = vendas.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}
	

}
