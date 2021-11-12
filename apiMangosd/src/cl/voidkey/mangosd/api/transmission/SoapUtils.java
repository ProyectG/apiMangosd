package cl.voidkey.mangosd.api.transmission;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Base64;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.apache.log4j.Logger;

import cl.voidkey.mangosd.api.parameter.Parameters;


public class SoapUtils extends Parameters {

	private Logger logger = Logger.getLogger(SoapUtils.class);
	
	public String sendMessage(SOAPMessage mensaje) {
		try {
			URL endpoint = new URL(getUrl());
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = soapConnectionFactory.createConnection();
			SOAPMessage response = connection.call(mensaje, endpoint);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			response.writeTo(out);
			String strMsg = new String(out.toByteArray());
			return strMsg;
		} catch (UnsupportedOperationException e) {
			logger.error("Error operacion no soportada ", e);
		} catch (SOAPException e) {
			logger.error("SOAP Exception ", e);
		} catch (IOException e) {
			logger.error("IO Error ", e);
		}
		return null;
	}

	public SOAPMessage generateSoapMessage(String comando) throws IOException, SOAPException {
		try {
			InputStream is = new ByteArrayInputStream(getSoapmessage().getBytes());
			SOAPMessage message = MessageFactory.newInstance().createMessage(null, is);
			MimeHeaders headers = message.getMimeHeaders();
			headers.addHeader("Authorization", "Basic " + base64Authorization());
			message.saveChanges();
			return message;
		} catch (IOException e) {
			logger.error("IO Error ", e);
		} catch (SOAPException e) {
			logger.error("SOAP Exception ", e);
		}
		return null;
	}

	protected String base64Authorization() {
		String userAndPassword = String.format("%s:%s", getUser(), getPass());
		String basicAuth = Base64.getEncoder().encodeToString(userAndPassword.getBytes());
		return basicAuth;
	}

}
