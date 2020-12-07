import Model.VO.*;

import java.util.ArrayList;

import Model.BO.*;
import Model.DAO.*;

public class Principal {
	public static void main(String args[]) {
		FuncionariosBO fbo = new FuncionariosBO();
		fbo.mostrar(fbo.listar());
	}
}
