package cl.voidkey.mangosd.api.parameter;

public enum Protocol {
	HTTP("http"),HTTPS("https");
	
	private final String info;
	
	Protocol(String info){
		this.info = info;
	}
	
	public String getInfoProtocol() {
		return this.info;
	}
	
}






