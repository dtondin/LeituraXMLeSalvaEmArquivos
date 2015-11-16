package xml;

import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XML_V4 {

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        
        try {

            doc = builder.build("arquivo.xml");

        } catch (Exception e) {

            e.printStackTrace();

        }

        Element agenda = doc.getRootElement();

        List<Element> lista = agenda.getChildren();

        for (Element e : lista) {

            System.out.println("Contato: " + e.getAttributeValue("id"));

            System.out.println("Nome: " + e.getChildText("nome"));

            System.out.println("Telefone: " + e.getChildText("telefone"));

            System.out.println("Endereço: " + e.getChildText("endereco"));

            System.out.println("E-mail: " + e.getChildText("email"));

        }

    }

}
