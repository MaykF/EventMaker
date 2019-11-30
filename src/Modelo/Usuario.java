package Modelo;

import Controller.ControllerUsuario;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

@Entity
public class Usuario extends ObjetoBase implements Serializable{
    @Column(unique=true)
    private String nome;
    @Column(unique=true)
    private String login;
    private String senha;
    private boolean isadmin;
    //@OneToMany
    //private List<Inscricao> inscricao;

    
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
        this.setSenha(ControllerUsuario.CriptografarSenha((String) jsonfile.get("senha")));
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
