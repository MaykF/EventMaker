/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import org.json.simple.JSONObject;


/**
 *
 * @author Maycon
 */
@Entity
public class Pessoa extends ObjetoBase implements Serializable{
    
    private String nome;
    private String CPF;
    private String RG;
    private String endereco;
    private String cidade;
    private String telefone;
    private String email;
    private String numMatricula;
    @OneToMany(mappedBy = "pessoa")
    private List<Inscricao> inscricoes;

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
        //this.setId((int) jsonfile.get("id"));
        this.setNome((String) jsonfile.get("nome"));
        this.setCPF((String) jsonfile.get("CPF"));
        this.setRG((String) jsonfile.get("RG"));
        this.setCidade((String) jsonfile.get("cidade"));
        this.setEmail((String) jsonfile.get("email"));
        this.setEndereco((String) jsonfile.get("endereco"));
        this.setTelefone((String) jsonfile.get("telefone"));
        this.setNumMatricula((String) jsonfile.get("nummatricula"));
        
        return this;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("id", this.getId());
        jsonfile.put("nome", this.getNome());
        jsonfile.put("CPF", this.getCPF());
        jsonfile.put("RG", this.getRG());
        jsonfile.put("cidade", this.getCidade());
        jsonfile.put("email", this.getEmail());
        jsonfile.put("endereco", this.getEndereco());
        jsonfile.put("telefone", this.getTelefone());
        jsonfile.put("nummatricula", this.getNumMatricula());
        
        return jsonfile;
        
    }
    
    
    
}
