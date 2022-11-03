package Homework26;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class PlantidSum {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        xmlAtribToString("test2.xml");

        System.out.println();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("C:\\Users\\Dime3\\IdeaProjects\\JavaHomeworks\\test.xml"));
        Element root = doc.getDocumentElement();
        NodeList plantNodeList = root.getElementsByTagName("PLANT");

 //       System.out.println(priceNode.getAttributes().item(0).getTextContent());
        double sum = 0;
        String s;
        for(int i = 0; i < plantNodeList.getLength(); i++)
        {
            Node plantNode = plantNodeList.item(i);
            s = plantNode.getAttributes().item(0).getTextContent();
            sum += Integer.parseInt(s);
        }
        System.out.println("Summa PLANT elements = " + sum);
    }


    public static void xmlAtribToString (String file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(file));
        Element root = doc.getDocumentElement();
        NodeList listNodeList = root.getElementsByTagName("author");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < listNodeList.getLength() ; i++) {
            Node authNode = listNodeList.item(i);
            stringBuilder.append(authNode.getTextContent()).append("; ");
        }
        System.out.println(stringBuilder);
    }
}
