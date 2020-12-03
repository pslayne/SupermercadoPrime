package Model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import Model.DAO.FuncionariosDAO;
import Model.VO.CargoVO;
import Model.VO.FuncionariosVO;

public class FuncionariosBO implements InterFuncionariosBO{
	FuncionariosDAO dao = new FuncionariosDAO();
	
	public void adicionar(FuncionariosVO funcionario) {
		if(funcionario != null) {
			List<FuncionariosVO> resultado = buscarCPF(funcionario);
			if(resultado.isEmpty()) 
				dao.inserir(funcionario);
			else System.out.println("Este funcionário já existe");
		} else System.out.println("Funcionário inválido");
	}

	public void remover(FuncionariosVO funcionario) {
		if(funcionario != null) {
			List<FuncionariosVO> resultado = buscarCPF(funcionario);
			if(!resultado.isEmpty()) 
				dao.remover(funcionario);
			else System.out.println("Este funcionário não existe");
		} else System.out.println("Funcionário inválido");
	}

	public void editar(FuncionariosVO funcionario, FuncionariosVO novoFuncionario) {
		if(funcionario != null && novoFuncionario != null) {
			List<FuncionariosVO> resultado = buscarCPF(funcionario);
			if(!resultado.isEmpty()) 
				dao.atualizar(funcionario, novoFuncionario);
			else System.out.println("Este funcionário não existe");
		} else System.out.println("Funcionário inválido");
	}

	public FuncionariosVO buscarID(FuncionariosVO funcionario) {
		ResultSet rs = dao.buscarID(funcionario);
		FuncionariosVO f = new FuncionariosVO();
		
		try {
			if(rs.next()) {
				f.setCodigo(rs.getInt("id_func"));
				
				CargoBO cargo = new CargoBO();
				CargoVO c = new CargoVO();
				c.setCodigo(rs.getInt("id_cargo"));
				c = cargo.buscarID(c);	
				
				f.setCargo(c);
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				
				String d = rs.getString("data_nasc");
				
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
				
				f.setDataNascimento(d);
				f.setSalario(rs.getDouble("salario"));
				f.setLogin(rs.getString("login"));
				f.setSenha(rs.getString("senha"));
				
				//System.out.println(f);
			} else f = null;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

	public List<FuncionariosVO> buscarCPF(FuncionariosVO funcionario) {
		ResultSet rs = dao.buscarCPF(funcionario);
		ArrayList<FuncionariosVO> funcionarios = new ArrayList<FuncionariosVO>();
		CargoBO cbo = new CargoBO();
		
		try {
			while(rs.next()) {
				FuncionariosVO f = new FuncionariosVO();
				f.setCodigo(rs.getInt("id_func"));
				
				CargoVO cvo = new CargoVO();
				cvo.setCodigo(rs.getInt("id_cargo"));
				cvo = cbo.buscarID(cvo);
				
				f.setCargo(cvo);
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				
				String d = rs.getString("data_nasc");
				
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
				
				f.setDataNascimento(d);
				f.setSalario(rs.getDouble("salario"));
				f.setLogin(rs.getString("login"));
				f.setSenha(rs.getString("senha"));
				
				//System.out.println(f);
				
				funcionarios.add(f);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funcionarios;
	}

	public List<FuncionariosVO> buscarNome(FuncionariosVO funcionario) {
		ResultSet rs = dao.buscarNome(funcionario);
		ArrayList<FuncionariosVO> funcionarios = new ArrayList<FuncionariosVO>();
		CargoBO cbo = new CargoBO();
		
		try {
			while(rs.next()) {
				FuncionariosVO f = new FuncionariosVO();
				f.setCodigo(rs.getInt("id_func"));
				
				CargoVO cvo = new CargoVO();
				cvo.setCodigo(rs.getInt("id_cargo"));
				cvo = cbo.buscarID(cvo);
				
				f.setCargo(cvo);
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				
				String d = rs.getString("data_nasc");
				
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
				
				f.setDataNascimento(d);
				f.setSalario(rs.getDouble("salario"));
				f.setLogin(rs.getString("login"));
				f.setSenha(rs.getString("senha"));
				
				//System.out.println(f);
				
				funcionarios.add(f);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return funcionarios;
	}
	
	public List<FuncionariosVO> listar() {
		ResultSet rs = dao.listar();
		ArrayList<FuncionariosVO> funcionarios = new ArrayList<FuncionariosVO>();
		CargoBO cbo = new CargoBO();
		
		try {
			while(rs.next()) {
				FuncionariosVO f = new FuncionariosVO();
				f.setCodigo(rs.getInt("id_func"));
				
				CargoVO cvo = new CargoVO();
				cvo.setCodigo(rs.getInt("id_cargo"));
				cvo = cbo.buscarID(cvo);
				
				f.setCargo(cvo);
				f.setNome(rs.getString("nome"));
				f.setCpf(rs.getString("cpf"));
				f.setEndereco(rs.getString("endereco"));
				f.setEmail(rs.getString("email"));
				
				String d = rs.getString("data_nasc");
				
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
				
				f.setDataNascimento(d);
				f.setSalario(rs.getDouble("salario"));
				f.setLogin(rs.getString("login"));
				f.setSenha(rs.getString("senha"));
				
				//System.out.println(f);
				
				funcionarios.add(f);
			}
			
			return funcionarios;
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public void mostrar(List<FuncionariosVO> funcionarios) {
		Iterator<FuncionariosVO> iterator = funcionarios.iterator();
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
	}

}
