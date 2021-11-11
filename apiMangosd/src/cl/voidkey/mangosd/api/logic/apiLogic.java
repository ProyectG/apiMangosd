package cl.voidkey.mangosd.api.logic;

import javax.xml.soap.SOAPMessage;

import cl.voidkey.mangosd.api.dto.Configure;
import cl.voidkey.mangosd.api.dto.ConfigureResponse;
import cl.voidkey.mangosd.api.dto.Execute;
import cl.voidkey.mangosd.api.dto.ExecuteResponse;
import cl.voidkey.mangosd.api.parameter.Parameters;
import cl.voidkey.mangosd.api.transmission.SoapUtils;

public class apiLogic extends Parameters{
	
	public ConfigureResponse configureApi(Configure input)
	{
		ConfigureResponse response = new ConfigureResponse();
		
		//Validar el objeto
		
		setPass(input.getPass());
		setPort(input.getPort());
		setProtocol(input.getProtocol());
		setUrl(input.getUrl());
		setUser(input.getUrl());
		
		response.setCod("00");
		response.setDsc("Configuracion exitosa, puedes comenzar a usarla");
		
		return response;
	}
	
	public ExecuteResponse execute(Execute input)
	{
		ExecuteResponse respuesta = new ExecuteResponse();
		SoapUtils soap = new SoapUtils();
		try  {
			String res = soap.sendMessage(soap.generateSoapMessage(input.getCommand()));
			
			respuesta.setCod("00");
			respuesta.setDsc("Comando ejecutado exitosamente");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
	}

}
