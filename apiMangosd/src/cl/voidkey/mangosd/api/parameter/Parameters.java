package cl.voidkey.mangosd.api.parameter;

public class Parameters {

	final static String SOAPMESSAGE = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\" xmlns:ns1=\"urn:MaNGOS\"><SOAP-ENV:Body><ns1:executeCommand><command>{comando}</command></ns1:executeCommand></SOAP-ENV:Body></SOAP-ENV:Envelope>";
	String user = "";
	String pass = "";
	String url = "";
	String port = "";
	String protocol = "";

	public String getSoapmessage() {
		return SOAPMESSAGE;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

}
