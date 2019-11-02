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
public class Evento extends ObjetoBase implements Serializable{
    
    String nome;
    String descricao;
    int capacidade;
    String endereco;
    /// DATA E HORA INICIO E TERMINO

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }   

    public ObjetoBase toObjeto(JSONObject jsonfile) {
        
        this.setNome((String) jsonfile.get("nome"));
        this.setDescricao((String) jsonfile.get("descricao"));
        this.setCapacidade((int) jsonfile.get("capacidade"));
        this.setEndereco((String) jsonfile.get("endereco"));
        
        return this;
    }

    
    public JSONObject toJSONObject() {
        
        JSONObject jsonfile = new JSONObject();
        
        jsonfile.put("nome", this.getNome());
        jsonfile.put("descricao", this.getDescricao());
        jsonfile.put("capacidade", this.getCapacidade());
        jsonfile.put("enredeco", this.getEndereco());
        
        return jsonfile;
    }
    
    
    
    
}
