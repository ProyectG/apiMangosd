package cl.voidkey.mangosd.api;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import cl.voidkey.mangosd.api.controller.SoapClient;

public class Core extends Application{
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> empty = new HashSet<>();
	
	public Core()
	{
		singletons.add(new SoapClient());
	}
	
	@Override
	public Set<Class<?>> getClasses()
	{
		return empty;
	}
	
	@Override
	public Set<Object> getSingletons()
	{
		return singletons;
	}

}