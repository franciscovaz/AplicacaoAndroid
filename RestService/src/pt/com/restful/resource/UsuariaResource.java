package pt.com.restful.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pt.com.restful.controller.UsuariaController;
import pt.com.restful.model.Usuaria;

@Path("/cliente")
public class UsuariaResource {

	@GET
	@Path("/listarTodas")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Usuaria> listarTodas() {

		return new UsuariaController().listarTodas();
	}


	@POST
	 @Path("/inserirUsuaria")
	 @Produces(MediaType.APPLICATION_JSON)
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void inserirUsuaria(Usuaria usuaria) throws SQLException{
	  
	  new UsuariaController().inserirUsuaria(usuaria);
	 }
}