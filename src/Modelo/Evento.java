/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;
import org.json.simple.JSONObject;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.OneToMany;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;


/**
 *
 * @author Maycon
 */
@Entity
public class Evento extends ObjetoBase implements Serializable{
    
    private String nome;
    private String descricao;
    private int capacidade;
    private String local;
    private Date inicio;
    private Date termino;
    @OneToMany(mappedBy = "evento")
    private List<Inscricao> inscricoes;

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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }   

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }



    public ObjetoBase toObjeto(JSONObject jsonfile) {
        try {
            SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
            this.setId(Integer.parseInt(String.valueOf(jsonfile.get("id"))));
            this.setNome((String) jsonfile.get("nome"));
            this.setDescricao((String) jsonfile.get("descricao"));
            this.setCapacidade(Integer.parseInt((String) jsonfile.get("capacidade")));
            this.setLocal((String) jsonfile.get("local"));
            this.setInicio(ddMMyyyy.parse(jsonfile.get("inicio").toString()));
            this.setTermino(ddMMyyyy.parse(jsonfile.get("termino").toString()));
            
            return this;
        } catch (ParseException ex) {
            Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public JSONObject toJSONObject() {
        
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("id", this.getId());
        jsonfile.put("nome", this.getNome());
        jsonfile.put("descricao", this.getDescricao());
        jsonfile.put("capacidade", this.getCapacidade());
        jsonfile.put("local", this.getLocal());
        jsonfile.put("inicio", this.getInicio());
        jsonfile.put("termino", this.getTermino());
        
        return jsonfile;
    } 
}
