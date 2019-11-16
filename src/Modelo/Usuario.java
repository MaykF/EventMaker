/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
@Entity
public class Usuario extends ObjetoBase implements Serializable{
    
    private String nome;
    private String login;
    private String senha;
    private boolean isadmin;
    @OneToOne(mappedBy = "usuario")
    private Inscricao inscricao;

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
    
    public static String CriptografarSenha(String senha){
        
        String senhaCript = "";
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            
            try {
                byte message[] = md.digest(senha.getBytes("UTF-8"));
                
                StringBuilder sb = new StringBuilder();
                
                for(byte b : message){
                    sb.append(String.format("%02X", 0xFF & b));

                }
                senhaCript = sb.toString();
                
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return senhaCript;
        
    }

    @Override
    public ObjetoBase toObjeto(JSONObject jsonfile) {
        
        this.setNome((String) jsonfile.get("nome"));
        this.setLogin((String) jsonfile.get("login"));
        this.setSenha(CriptografarSenha((String) jsonfile.get("senha")));
        this.setIsadmin((boolean) jsonfile.get("isadmin"));
        
        return this;
    }

    @Override
    public JSONObject toJSONObject() {
        
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("id", this.getId());
        jsonfile.put("nome", this.getNome());
        jsonfile.put("login", this.getLogin());
        jsonfile.put("senha", this.getSenha());
        jsonfile.put("isadmin", this.isIsadmin());
        
        return jsonfile;
        
    }
    
    
    
}
