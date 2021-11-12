package cl.voidkey.mangosd.api.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cl.voidkey.mangosd.api.dto.Configure;
import cl.voidkey.mangosd.api.dto.Execute;
import cl.voidkey.mangosd.api.logic.ApiLogic;

@Path("/api/v1/mangos/")
public class SoapClient extends ApiLogic{
	
	@POST
	@Path("execute")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response executeCommand(Execute comando) {
		
		return Response.ok(execute(comando),MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("configure")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response configure(Configure configure) {
		return Response.ok(configureApi(configure), MediaType.APPLICATION_JSON).build();
	}
	
	
	@POST
	@Path("infoconf")
	@Produces(MediaType.APPLICATION_JSON)
	public Response info()
	{
		return Response.ok().build();
	}
}
