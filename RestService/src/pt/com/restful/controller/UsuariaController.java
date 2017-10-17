package pt.com.restful.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import pt.com.restful.dao.UsuariaDAO;
import pt.com.restful.model.Usuaria;

public class UsuariaController {
	
	public ArrayList<Usuaria> listarTodas(){
		 return UsuariaDAO.getInstance().listarTodas();
	}
 
	public void inserirUsuaria(Usuaria usuaria) throws SQLException{
		  UsuariaDAO.getInstance().inserirUsuaria(usuaria);
	}

}
