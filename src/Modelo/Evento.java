/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import org.json.simple.JSONObject;
import java.util.*;


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
    GregorianCalendar inicio;
    GregorianCalendar termino;

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

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public void setInicio(GregorianCalendar inicio) {
        this.inicio = inicio;
    }

    public GregorianCalendar getTermino() {
        return termino;
    }

    public void setTermino(GregorianCalendar termino) {
        this.termino = termino;
    }



    public ObjetoBase toObjeto(JSONObject jsonfile) {
        
        this.setNome((String) jsonfile.get("nome"));
        this.setDescricao((String) jsonfile.get("descricao"));
        this.setCapacidade((int) jsonfile.get("capacidade"));
        this.setEndereco((String) jsonfile.get("endereco"));
        this.setInicio((GregorianCalendar) jsonfile.get("inicio"));
        this.setTermino((GregorianCalendar) jsonfile.get("termino"));
        
        return this;
    }

    
    public JSONObject toJSONObject() {
        
        JSONObject jsonfile = new JSONObject();
        
        jsonfile.put("nome", this.getNome());
        jsonfile.put("descricao", this.getDescricao());
        jsonfile.put("capacidade", this.getCapacidade());
        jsonfile.put("enredeco", this.getEndereco());
        jsonfile.put("inicio", this.getInicio());
        jsonfile.put("termino", this.getTermino());
        
        return jsonfile;
    }
    
    
    
    
}
