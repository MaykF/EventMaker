package Util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xml {
    
    public static boolean GeraArquivoConexao(String Servidor, int porta, String nomeBD, String Usuario, String Senha) throws TransformerConfigurationException{
        
        
        
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            
            Document docXML = docBuilder.newDocument();
            
            Element persistenceunit = docXML.createElement("persistence-unit");
            Attr attpersistenceunit = docXML.createAttribute("transaction-type");
            attpersistenceunit.setValue("RESOURCE_LOCAL");
            Attr attnamepersistence = docXML.createAttribute("name");
            attnamepersistence.setValue("eventmakerpu");
            persistenceunit.setAttributeNode(attpersistenceunit);
            persistenceunit.setAttributeNode(attnamepersistence);
            docXML.appendChild(persistenceunit);
            
                Element provider = docXML.createElement("provider");
                provider.appendChild(docXML.createTextNode("org.hibernate.ejb.HibernatePersistence"));
                persistenceunit.appendChild(provider);

                    Element properties = docXML.createElement("properties");
                    provider.appendChild(properties);
                        // NO DA TAG SERVIDOR
                        Element propertyServidor = docXML.createElement("property");
                        Attr valueServidor = docXML.createAttribute("value");
                        valueServidor.setValue("jdbc:mysql://" + Servidor + ":" + porta + "/" + nomeBD);
                        Attr nameServidor = docXML.createAttribute("name");
                        nameServidor.setValue("javax.persistence.jdbc.url");

                        propertyServidor.setAttributeNode(nameServidor);
                        propertyServidor.setAttributeNode(valueServidor);
                        properties.appendChild(propertyServidor);

                        // NO DA TAG USUARIO
                        Element propertyUsuario = docXML.createElement("property");
                        Attr valueUsuario = docXML.createAttribute("value");
                        valueUsuario.setValue(Usuario);
                        Attr nameUsuario = docXML.createAttribute("name");
                        nameUsuario.setValue("javax.persistence.jdbc.user");

                        propertyUsuario.setAttributeNode(nameUsuario);
                        propertyUsuario.setAttributeNode(valueUsuario);
                        properties.appendChild(propertyUsuario);


                        // NO DA TAG DRIVER
                        Element propertyDriver = docXML.createElement("property");
                        Attr valueDriver = docXML.createAttribute("value");
                        valueDriver.setValue("com.mysql.jdbc.Driver");
                        Attr nameDriver = docXML.createAttribute("name");
                        nameDriver.setValue("javax.persistence.jdbc.driver");

                        propertyDriver.setAttributeNode(nameDriver);
                        propertyDriver.setAttributeNode(valueDriver);
                        properties.appendChild(propertyDriver);


                        // NO DA TAG SENHA
                        Element propertySenha = docXML.createElement("property");
                        Attr valueSenha = docXML.createAttribute("value");
                        valueSenha.setValue(Senha);
                        Attr nameSenha = docXML.createAttribute("name");
                        nameSenha.setValue("javax.persistence.jdbc.password");

                        propertySenha.setAttributeNode(nameSenha);
                        propertySenha.setAttributeNode(valueSenha);
                        properties.appendChild(propertySenha);

                        // NO DA TAG PROVIDER
                        Element propertyProvider = docXML.createElement("property");
                        Attr valueProvider = docXML.createAttribute("value");
                        valueProvider.setValue("org.hibernate.cache.NoCacheProvider");
                        Attr nameProvider = docXML.createAttribute("name");
                        nameProvider.setValue("hibernate.cache.provider_class");

                        propertyProvider.setAttributeNode(nameProvider);
                        propertyProvider.setAttributeNode(valueProvider);
                        properties.appendChild(propertyProvider);

                        // NO DA TAG DIALECT
                        Element propertyDialect = docXML.createElement("property");
                        Attr valueDialect = docXML.createAttribute("value");
                        valueDialect.setValue("org.hibernate.dialect.MySQL5InnoDBDialect");
                        Attr nameDialect = docXML.createAttribute("name");
                        nameDialect.setValue("hibernate.dialect");

                        propertyDialect.setAttributeNode(nameDialect);
                        propertyDialect.setAttributeNode(valueDialect);
                        properties.appendChild(propertyDialect);

                        // NO DA TAG AUTO
                        Element propertyAuto = docXML.createElement("property");
                        Attr valueAuto = docXML.createAttribute("value");
                        valueAuto.setValue("update");
                        Attr nameAuto = docXML.createAttribute("name");
                        nameAuto.setValue("hibernate.hbm2ddl.auto");

                        propertyAuto.setAttributeNode(nameAuto);
                        propertyAuto.setAttributeNode(valueAuto);
                        properties.appendChild(propertyAuto);
            
            
            TransformerFactory transfFactory = TransformerFactory.newInstance();
            Transformer transf = transfFactory.newTransformer();
            
            DOMSource docFonte = new DOMSource(docXML);
            
            StreamResult docFinal = new StreamResult(new File("build\\classes\\META-INF\\persistence.xml"));
            
            transf.transform(docFonte, docFinal);
                    
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        
        return true;
    
    }
    
    //INCOMPLETO
    public static Map ImportaXML(){
    
        Map <String, String> properties = new HashMap<String, String>();
        
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            
            Document docXML = docBuilder.parse("ConfigCnx.xml");
            
            NodeList listProperties = docXML.getElementsByTagName("property");
            int tamproperty = listProperties.getLength();
            
            
                
            Node noProperties = listProperties.item(0);                
            
            Element elementProperties = (Element) noProperties;
            
            
            

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return properties;
    }
}
