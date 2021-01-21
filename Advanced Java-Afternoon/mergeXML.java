import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class mergeXML {
  public static void main(String[] args) {
    String File1 = "license_data1.xml";
    String File2 = "license_data1.xml";
    
    
    String File3 = "merged.xml";
    mergeFiles(File1, File2, File3);
    
  
    validateFile(File3, true, "valid.xml");
    
    
    validateFile(File3, false, "invalid.xml");
  }

	
	public static void makeFile(Document targetDocument, String targetfilename) 
	{
		try
		{
			TransformerFactory tFactory = TransformerFactory.newInstance();
	        Transformer transformer = tFactory.newTransformer();
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	        DOMSource source = new DOMSource(targetDocument);
	        StreamResult result = new StreamResult(new StringWriter());
	        transformer.transform(source, result);

	        Writer output = new BufferedWriter(new FileWriter(targetfilename));
	        String xmlOutput = result.getWriter().toString();
	        output.write(xmlOutput);
	        output.close();
		}
		catch (Exception e) 
		{

            e.printStackTrace();
        }
  }
  

  public static boolean isSameLicenseDetails(Element detail1Element, Element detail2Element)
	{
		
		return (
			(detail1Element.getAttribute("Date_Status_Effective").equals(detail2Element.getAttribute("Date_Status_Effective")))
                	&& (detail1Element.getAttribute("State_Code").equals(detail2Element.getAttribute("State_Code")))
                	&& (detail1Element.getAttribute("License_Number").equals(detail2Element.getAttribute("License_Number")))
                	);
	}
	
    public static void mergeFiles(String file1, String file2, String file3){
        
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document1 = builder.parse(new File(file1));
            Document document2 = builder.parse(new File(file2));

            NodeList nlist1 = document1.getElementsByTagName("CSR_Producer");
            NodeList nlist2 = document2.getElementsByTagName("CSR_Producer");

            for(int i = 0; i < nlist1.getLength(); i++) 
            {
                Node CSR1 = nlist1.item(i);
                Element csr1Element = (Element) CSR1;
                boolean sameNIPR = false;

                for (int j = 0; j < nlist1.getLength(); j++) 
                {
                    Node CSR2 = nlist2.item(j);
                    Element csr2Element = (Element) CSR2;

                    if (csr1Element.getAttribute("NIPR_Number").equals(csr2Element.getAttribute("NIPR_Number"))) 
                    {

                        sameNIPR = true;
                        NodeList csr1ElementDetails = csr1Element.getChildNodes();
                        NodeList csr2ElementDetails = csr2Element.getChildNodes();

                        for (int k = 0; k < csr1ElementDetails.getLength(); k++) 
                        {
                            Node detail1 = csr1ElementDetails.item(k);
                            boolean licenseMatched = false;

                            if(detail1.getNodeType() == Node.ELEMENT_NODE) 
                            {
                                Element detail1Element = (Element) detail1;
                                for (int l = 0; l < csr2ElementDetails.getLength(); l++) 
                                {
                                    Node detail2 = csr2ElementDetails.item(l);
                                    if (detail2.getNodeType() == Node.ELEMENT_NODE) 
                                    {
                                        Element detail2Element = (Element) detail2;
                                        if (isSameLicenseDetails(detail1Element, detail2Element)) 
                                        {

                                            licenseMatched = true;
                                            NodeList childNodes = detail2.getChildNodes();
                                            for (int m = 0; m < childNodes.getLength(); m++) 
                                            {
                                                Node n = (Node) document1.importNode(childNodes.item(m),true);
                                                detail1Element.appendChild(n);
                                            }
                                        }

                                    }
                                }
                                if(licenseMatched == false)
                                {
                                    detail1.getParentNode().removeChild(detail1);
                                }
                            }

                        }
                    }

                }
                if(sameNIPR==false)
                {
                	CSR1.getParentNode().removeChild(CSR1);
                }
            }
            
            makeFile(document1, file3);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void validateFile(String file, boolean findValid, String file3)
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try 
        {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(file));
            NodeList nlist1 = doc.getElementsByTagName("License");

            for(int i = 0; i <nlist1.getLength(); i++) 
            {
                Node license = nlist1.item(i);
                Element licenseElement = (Element) license;

                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String d = licenseElement.getAttribute("License_Expiration_Date");
                LocalDate licenseDate = LocalDate.parse(d, myFormatObj);

                LocalDate today = LocalDate.now();

                int diff = today.compareTo(licenseDate);
                if((diff > 0 && findValid == true) || (diff < 0 && findValid == false)) 
                {
                    licenseElement.getParentNode().removeChild(licenseElement);
                }               
            }

            makeFile(doc, file3);
        }
        catch (Exception e) {

            e.printStackTrace();
        }
    }

    
}