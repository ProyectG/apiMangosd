package cl.voidkey.mangosd.api.parameter;

public class Parameters {
	
	final static String soapMessage = "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/1999/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/1999/XMLSchema\" xmlns:ns1=\"urn:MaNGOS\"><SOAP-ENV:Body><ns1:executeCommand><command>{comando}</command></ns1:executeCommand></SOAP-ENV:Body></SOAP-ENV:Envelope>";
	static String user = "";
	static String pass = "";
	static String url = "";
	static String port = "";
	static String protocol = "";
	
	
	public static String getSoapmessage() {
		return soapMessage;
	}
	public static String getUser() {
		return user;
	}
	public static void setUser(String user) {
		Parameters.user = user;
	}
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		Parameters.pass = pass;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Parameters.url = url;
	}
	public static String getPort() {
		return port;
	}
	public static void setPort(String port) {
		Parameters.port = port;
	}
	public static String getProtocol() {
		return protocol;
	}
	public static void setProtocol(String protocol) {
		Parameters.protocol = protocol;
	}
	
	

}
