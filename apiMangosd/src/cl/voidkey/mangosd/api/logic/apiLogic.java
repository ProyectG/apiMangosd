package cl.voidkey.mangosd.api.logic;

import cl.voidkey.mangosd.api.dto.Configure;
import cl.voidkey.mangosd.api.dto.ConfigureResponse;
import cl.voidkey.mangosd.api.dto.Execute;
import cl.voidkey.mangosd.api.dto.ExecuteResponse;
import cl.voidkey.mangosd.api.exception.ConfigureException;
import cl.voidkey.mangosd.api.parameter.Parameters;
import cl.voidkey.mangosd.api.transmission.SoapUtils;
import cl.voidkey.mangosd.api.transmission.XMLutils;

public class apiLogic extends Parameters{
	
	public ConfigureResponse configureApi(Configure input)
	{
		ConfigureResponse response = new ConfigureResponse();
		try {
			if(input.validateConfigure()) {
			setPass(input.getPass());
			setPort(input.getPort());
			setProtocol(input.getProtocol());
			setUrl(input.getUrl());
			setUser(input.getUrl());
			
			response.setCod("00");
			response.setDsc("Configuracion exitosa, puedes comenzar a usarla");
			}
		} catch (ConfigureException e) {
			response.setCod("01");
			response.setDsc(e.getMessage());
		}
		return response;
	}
	
	public ExecuteResponse execute(Execute input)
	{
		ExecuteResponse respuesta = new ExecuteResponse();
		SoapUtils soap = new SoapUtils();
		XMLutils xml = new XMLutils();
		try  {
			String res = soap.sendMessage(soap.generateSoapMessage(input.getCommand()));
			String soapResponse = xml.parseXML(res);
			if(soapResponse != "")
			{
				respuesta.setCod("00");
				respuesta.setDsc("Comando ejecutado exitosamente");
			}else
			{
				respuesta.setCod("01");
				respuesta.setDsc("El comando no pudo ser ejecutado");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return respuesta;
	}

}
