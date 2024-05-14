package com.jocrol;

import javax.xml.parsers.DocumentBuilderFactory;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class CarregadorXML {
    public static List<Personatge> carregarPersonatges(String rutaXML) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(rutaXML);

        NodeList personatges = document.getElementsByTagName("personatge");
        List<Personatge> llistaPersonatges = new ArrayList<>();

        for (int i = 0; i < personatges.getLength(); i++) {
            Node node = personatges.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String nom = element.getElementsByTagName("nom").item(0).getTextContent();
                int nivell = Integer.parseInt(element.getElementsByTagName("nivell").item(0).getTextContent());
                int puntsDeVida = Integer.parseInt(element.getElementsByTagName("puntsDeVida").item(0).getTextContent());
                int puntsDeMana = Integer.parseInt(element.getElementsByTagName("puntsDeMana").item(0).getTextContent());
                String arma = element.getElementsByTagName("arma").item(0).getTextContent();
                String armadura = element.getElementsByTagName("armadura").item(0).getTextContent();

                Personatge personatge = new Personatge(nom, nivell, puntsDeVida, puntsDeMana, arma, armadura);
                llistaPersonatges.add(personatge);
            }
        }

        return llistaPersonatges;
    }
}
