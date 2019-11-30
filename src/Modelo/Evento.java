package Modelo;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Entity;
import org.json.simple.JSONObject;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.swing.JOptionPane;
import javax.swing.plaf.RootPaneUI;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Evento extends ObjetoBase implements Serializable{
    
    private String nome;
    private String descricao;
    private int capacidade;
    private String local;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date inicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date termino;
    private String horaInicio;
    private String horaFim;
    @OneToMany(mappedBy = "evento")
    private List<Inscricao> inscricoes;


    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

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
            //this.setId(Integer.parseInt(String.valueOf(jsonfile.get("id"))));
            this.setNome((String) jsonfile.get("nome"));
            this.setDescricao((String) jsonfile.get("descricao"));
            this.setCapacidade(Integer.parseInt((String) jsonfile.get("capacidade")));
            this.setLocal((String) jsonfile.get("local"));
            this.setInicio(ddMMyyyy.parse(jsonfile.get("inicio").toString()));
            this.setTermino(ddMMyyyy.parse(jsonfile.get("termino").toString()));
            this.setHoraInicio((String) jsonfile.get("horainicio"));
            this.setHoraFim((String) jsonfile.get("horafim"));
            
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
        jsonfile.put("horainicio", this.getHoraInicio());
        jsonfile.put("horafim", this.getHoraFim());
        
        return jsonfile;
    } 
}
