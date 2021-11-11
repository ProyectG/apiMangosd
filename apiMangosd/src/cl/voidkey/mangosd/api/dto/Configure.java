package cl.voidkey.mangosd.api.dto;

import cl.voidkey.mangosd.api.parameter.Protocol;

public class Configure {
	
	String pass = "";
	String user = "";
	String url = "";
	String port = "";
	String protocol = "";
	
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	
	public ErrorObject validateConfigure() {
		ErrorObject response = new ErrorObject();
		
		if(!Protocol.HTTP.getInfoProtocol().equalsIgnoreCase(getProtocol()) && !Protocol.HTTPS.getInfoProtocol().equalsIgnoreCase(getProtocol())) {
			response.setClase(this.getClass().getName());
			response.setError("Protocolo no aceptado");
		}
		
		if(getPass().length() <= 0)
		{
			response.setClase(this.getClass().getName());
			response.setError("Contraseña no valida");
		}
		
		if(getUser().length() <= 0) {
			response.setClase(this.getClass().getName());
			response.setError("Usuario no valido");
		}
		
		if(getPort().length() <= 0)
		{
			response.setClase(this.getClass().getName());
			response.setError("Puerto no valido");
		}
		
		
		return response;
		
	}
	

}
