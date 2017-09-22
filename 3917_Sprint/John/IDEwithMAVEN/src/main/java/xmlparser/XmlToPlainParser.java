package xmlparser;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.*;
import org.xml.sax.*;
import org.w3c.dom.*;

public class XmlToPlainParser {
    private Map<String, String> stringResourceMap = new HashMap<>();
    private String currentFileName = null;

    public void parse(String filename, PrintStream logStream)
    {
        try {
            currentFileName = filename;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document dom = db.parse(filename);
            Element doc = dom.getDocumentElement();

            for (Node node = doc.getFirstChild(); node != null; node = node.getNextSibling()) {
                // filter from intermediete #text nodes
                if (node.getNodeType() != Node.ELEMENT_NODE) { continue; }

                switch (node.getNodeName()) {
                    case "string":
                        processNodeString(node, logStream);
                        break;
                    case "plurals":
                        processNodePlural(node, logStream);
                        break;
                    default:
                        logStream.println("WARNIGN!!! Unknown node type " + node.getNodeName());
                        break;
                }
            }
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println("Something went wrong :( " + e.getMessage());
        }
    }


    public void print(PrintStream out) {
        stringResourceMap.forEach((k,v) -> {
            out.println(k + " = " + adaptText(v));
        });
        // replaceAll()
    }


    public void reset() {
        stringResourceMap.clear();
        currentFileName = null;
    }


    private String adaptText(String strIn) {
        String regex1 = "%d";
        String regex2 = "%(\\d)\\$\\w";
        if (!strIn.matches(".*(" + regex1 + "|" + regex2 + ").*")) {
            return strIn;
        }
        // here I suppose that special combination "%d" and "%\d$\w" appear only
        // separately (in different records). And they are!

        StringBuffer sbuf = new StringBuffer();
        if (strIn.matches(".*" + regex1 + ".*")) {
            Matcher mInput = Pattern.compile(regex1, Pattern.DOTALL).matcher(strIn);
            for (int i = 0; mInput.find(); i++) {
                mInput.appendReplacement(sbuf, "{" + i + "}");
            }
            mInput.appendTail(sbuf);
        }
        else if (strIn.matches(".*" + regex2 + ".*")) {
            Matcher mInput = Pattern.compile(regex2, Pattern.DOTALL).matcher(strIn);
            while (mInput.find()) {
                mInput.appendReplacement(sbuf, "{" + (char)(mInput.group(1).charAt(0) - 1) + "}");
            }
            mInput.appendTail(sbuf);
        }

        return sbuf.toString();
    }

    private void processNodeString(Node node, PrintStream logStream) {
        String leftStr = node.getAttributes().getNamedItem("name").getNodeValue();
        String rightStr = node.getFirstChild().getNodeValue();

        store(leftStr, rightStr, logStream);
    }

    private void processNodePlural(Node node, PrintStream logStream) {
        Node attribute = node.getAttributes().getNamedItem("name");
        String leftStrBase = attribute.getNodeValue();

        for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
            // filter from intermediete #text nodes
            if (child.getNodeType() != Node.ELEMENT_NODE) { continue; }

            String leftStrSuffix = child.getAttributes().getNamedItem("quantity").getNodeValue();
            String leftStr = leftStrBase + "_" + leftStrSuffix;
            String rightStr = child.getFirstChild().getNodeValue();

            store(leftStr, rightStr, logStream);
        }
    }


    private void store(String leftStr, String rightStr, PrintStream logStream) {
        boolean isDuplicate = null != stringResourceMap.putIfAbsent(leftStr, rightStr);
        if (isDuplicate) {
            // entry with name leftStr appeared earlier. Ignore new value.
            //  Write warning with some usefull info to console.
            String oldRightStr = stringResourceMap.get(leftStr);
            if (oldRightStr.equals(rightStr)) {
                logStream.println("!Duplication for entry: \"" + leftStr
                        + "\"\t in file " + currentFileName);
            } else {
                logStream.println("WARNING! Different values for entry: \""
                        + leftStr + "\"\n"
                        + "\t version one: \"" + oldRightStr + "\"\n"
                        + "\t version two: \"" + rightStr + "\"\t location: " + currentFileName);
            }
        }
    }
}

