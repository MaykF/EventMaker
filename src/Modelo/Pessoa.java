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
public class Pessoa extends ObjetoBase implements Serializable{
    
    String nome;
    String CPF;
    String RG;
    String endereco;
    String cidade;
    String telefone;
    String email;
    String numMatricula;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public ObjetoBase toObjeto(JSONObject jsonfile) {
        this.setNome((String) jsonfile.get("nome"));
        this.setCPF((String) jsonfile.get("CPF"));
        this.setRG((String) jsonfile.get("RG"));
        this.setCidade((String) jsonfile.get("cidade"));
        this.setEmail((String) jsonfile.get("email"));
        this.setTelefone((String) jsonfile.get("telefone"));
        this.setNumMatricula((String) jsonfile.get("nummatricula"));
        
        return this;
    }

    @Override
    public JSONObject toJSONObject() {
        
        JSONObject jsonfile = new JSONObject();
        
        jsonfile.put("nome", this.getNome());
        jsonfile.put("CPF", this.getCPF());
        jsonfile.put("RG", this.getRG());
        jsonfile.put("cidade", this.getCidade());
        jsonfile.put("email", this.getEmail());
        jsonfile.put("telefone", this.getTelefone());
        jsonfile.put("nummatricula", this.getNumMatricula());
        
        return jsonfile;
        
    }
    
    
    
}
