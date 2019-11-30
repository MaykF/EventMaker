
package Util;

import Visao.TelaConfiguracao;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json {
    
    public static Map ImportaJSON(Map properties) throws org.json.simple.parser.ParseException{
    
        JSONObject jsonfile;
        JSONParser parser = new JSONParser();

        //Map<integer, string=""> mapaNomes = new HashMap<integer, string="">(); 
        
        try {
            
            jsonfile = (JSONObject) parser.parse(new FileReader("configbd.json"));
            JOptionPane.showMessageDialog(null, "jdbc:mysql://" + jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            properties.put("javax.persistence.jdbc.url", "jdbc:mysql://" + jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            JOptionPane.showMessageDialog(null,(String) jsonfile.get("usuariobd"));
            properties.put("javax.persistence.jdbc.user", (String) jsonfile.get("usuariobd"));
            JOptionPane.showMessageDialog(null,(String) jsonfile.get("senhabd"));
            properties.put("javax.persistence.jdbc.password", (String) jsonfile.get("senhabd"));
//
            JOptionPane.showMessageDialog(null,"com.mysql.jdbc.Driver");
            properties.put("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
            JOptionPane.showMessageDialog(null,"org.hibernate.cache.NoCacheProvider");
            properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            JOptionPane.showMessageDialog(null,"org.hibernate.dialect.MySQL5InnoDBDialect");
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
            JOptionPane.showMessageDialog(null,"update");
            properties.put("hibernate.hbm2ddl.auto", "update");
            JOptionPane.showMessageDialog(null,"true");
            properties.put("hibernate.show_sql", "true");
            properties.put("hibernate.format_sql", "true");
//
            //jTextFieldResultadoConexao.setText((String) jsonfile.get("servidor") + ":" + jsonfile.get("porta") + "/" + jsonfile.get("nomebd"));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return properties;
        
    }
    
    public static void GeraJSON(JSONObject jsonfile){
                
        try {
            FileWriter writefile = null;            
            
            writefile = new FileWriter("configbd.json");
            writefile.write(jsonfile.toJSONString());
            writefile.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
        public static void GeraJSON(String NomeArquivo, JSONArray jsonfile){
                
        try {
            FileWriter writefile = null;            
                       
            writefile = new FileWriter(NomeArquivo);
    
            writefile.write(jsonfile.toJSONString());
            
            writefile.close();
        } catch (IOException ex) {
            Logger.getLogger(TelaConfiguracao.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
