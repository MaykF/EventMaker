/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
@Entity
public class Usuario extends ObjetoBase implements Serializable{
    
    String nome;
    String login;
    String senha;
    boolean isadmin;

    
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

    @Override
    public ObjetoBase toObjeto(JSONObject jsonfile) {
        
        this.setNome((String) jsonfile.get("nome"));
        this.setLogin((String) jsonfile.get("login"));
        this.setSenha((String) jsonfile.get("senha"));
        this.setIsadmin((boolean) jsonfile.get("isadmin"));
        
        return this;
    }

    @Override
    public JSONObject toJSONObject() {
        
        JSONObject jsonfile = new JSONObject();
        
        jsonfile.put("nome", this.getNome());
        jsonfile.put("login", this.getLogin());
        jsonfile.put("senha", this.getSenha());
        jsonfile.put("isadmin", this.isIsadmin());
        
        return jsonfile;
        
    }
    
    
    
}
