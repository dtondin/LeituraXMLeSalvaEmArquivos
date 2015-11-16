package xml;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

public class XML_V5{
    
    private static String resultSent;
    private static String resultText;

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        
        try {

            doc = builder.build("TecnoCorpus.xml");

        } catch (Exception e) {

            e.printStackTrace();

        }

        Element agenda = doc.getRootElement();
        
        List<String> listNegativos = new ArrayList<>();
        List<String> listPositivos = new ArrayList<>();
        List<String> listNeutros = new ArrayList<>();

        List<Element> lista = agenda.getChildren();

        for (Element e : lista) {
            resultSent = e.getChildText("sent");
            resultText = e.getChildText("frase");
            if (resultSent.equals("1")) {
                listPositivos.add(resultText);
                //System.out.println("Sent: " + listNegativos.toString());                
            } else if(resultSent.equals("-1")) {
                listNegativos.add(resultText);
                //System.out.println("Sent: " + listPositivos.toString()); 
            } else{
                listNeutros.add(resultText);
                //System.out.println("Sent: " + listNeutros.toString());  
            }
        }
        
        try{
            PrintWriter positivos = new PrintWriter("Positivos.txt");

            for (int i = 0; i < listPositivos.size(); i++) {
                positivos.println(listPositivos.get(i));
            }
            positivos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
        try{
            PrintWriter negativos = new PrintWriter("Negativos.txt");
            for (int i = 0; i < listNegativos.size(); i++) {
                negativos.println(listNegativos.get(i));
            }
            negativos.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
        try{
            PrintWriter neutros = new PrintWriter("Neutros.txt");
            for (int i = 0; i < listNeutros.size(); i++) {
                neutros.println(listNeutros.get(i));
            }
            neutros.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

        System.out.println("Arquivos Gerados!");
        
    }
}
