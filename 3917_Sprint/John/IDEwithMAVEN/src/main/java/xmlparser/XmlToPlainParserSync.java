package xmlparser;


import java.io.*;
import java.util.*;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class XmlToPlainParserSync {

    public Map<String, String> parse(String filename) {
        Map<String, String> resources = new HashMap<>();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(filename);
            Element doc = dom.getDocumentElement();

            for (Node node = doc.getFirstChild(); node != null; node = node.getNextSibling()) {
                // filter from intermediete #text nodes
                if (node.getNodeType() != Node.ELEMENT_NODE) { continue; }

                switch (node.getNodeName()) {
                    case "string":
                        processNodeString(node, resources);
                        break;
                    case "plurals":
                        processNodePlural(node, resources);
                        break;
                    default:
                        System.out.println("WARNIGN!!! Unknown node type " + node.getNodeName());
                        break;
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Something went wrong :( " + e.getMessage());
        }

        return resources;
    }


    private void processNodeString(Node node, Map<String,String> resources) {
        String leftStr = node.getAttributes().getNamedItem("name").getNodeValue();
        String rightStr = node.getFirstChild().getNodeValue();

        resources.putIfAbsent(leftStr, rightStr);
    }

    private void processNodePlural(Node node,  Map<String,String> resources) {
        Node attribute = node.getAttributes().getNamedItem("name");
        String leftStrBase = attribute.getNodeValue();

        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
            // filter from intermediete #text nodes
            if (child.getNodeType() != Node.ELEMENT_NODE) { continue; }

            String leftStrSuffix = child.getAttributes().getNamedItem("quantity").getNodeValue();
            String leftStr = leftStrBase + "_" + leftStrSuffix;
            String rightStr = child.getFirstChild().getNodeValue();

            resources.putIfAbsent(leftStr, rightStr);
        }
    }
}