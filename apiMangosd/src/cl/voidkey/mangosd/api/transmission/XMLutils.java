package cl.voidkey.mangosd.api.transmission;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLutils {

	public String parseXML(String xml) {
		String response = "";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(response)));

			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath path = xPathFactory.newXPath();
			XPathExpression expr = path.compile("//result/text()");

			NodeList res = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int x = 0; x < res.getLength(); x++) {
				response = res.item(x).getNodeValue();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return response;
	}

}
