package cl.voidkey.mangosd.api.dto;

import cl.voidkey.mangosd.api.exception.ConfigureException;
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
	
	
	public boolean validateConfigure() throws ConfigureException {
		
		if(!Protocol.HTTP.getInfoProtocol().equalsIgnoreCase(getProtocol()) && !Protocol.HTTPS.getInfoProtocol().equalsIgnoreCase(getProtocol())) {
			throw new ConfigureException("Protocolo no aceptado");
		}
		
		if(getPass().length() <= 0 || getPass().length() > 25)
		{
			throw new ConfigureException("Password no valida");
		}
		
		if(getUser().length() <= 0 || getPass().length() > 25) {
			throw new ConfigureException("Usuario no valido");
		}
		
		if(getPort().length() <= 0)
		{
			throw new ConfigureException("Usuario no valido");
		}
		
		try {
			Integer.parseInt(getPort());
		}catch(Exception e)
		{
			throw new ConfigureException("puerto no valido");
		}
		
		if(getUrl().length() <= 0)
		{
			throw new ConfigureException("Url no valida");
		}
		
		return true;
		
	}
	

}
