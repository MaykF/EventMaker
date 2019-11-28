package Modelo;

import Controller.ControllerEvento;
import Controller.ControllerPessoa;
import Controller.ControllerUsuario;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;

@Entity
public class Inscricao extends ObjetoBase implements Serializable{

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datainscricao;  // ARMAZENAR A DATA DE GRAVAÇÃO DO EVENTO
    @ManyToOne
    private Evento evento;
    @ManyToOne
    private Pessoa pessoa;  // PESSOA INSCRITA NO EVENTO
    @OneToOne
    private Usuario usuario; // USUARIO QUE REALIZADOU A INSCRICAO OU SEJA QUE FOI LOGADO

    public Date getDatainscricao() {
        return datainscricao;
    }

    public void setDatainscricao(Date datainscricao) {
        this.datainscricao = datainscricao;
    }   

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    @Override
    public ObjetoBase toObjeto(JSONObject jsonfile) {
        try {
            ControllerEvento E = new ControllerEvento();
            ControllerPessoa P = new ControllerPessoa();
            
            SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
            JOptionPane.showMessageDialog(null, (String) jsonfile.get("codpessoa"));
            this.setPessoa(P.ConsultaPessoa((String) jsonfile.get("codpessoa")));
            this.setEvento(E.ConsultaEvento((String) jsonfile.get("codevento")));           
            this.setUsuario(ControllerUsuario.RecuperaPorLogin((String) jsonfile.get("usuario")));  // RECUPERA O USUARIO DE ACORDO COM O NOME
            this.setDatainscricao(ddMMyyyy.parse(jsonfile.get("data").toString()));
            
            return this;
        } catch (ParseException ex) {
            Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public JSONObject toJSONObject() {
   
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("codpessoa", this.getPessoa().getId());
        jsonfile.put("codevento", this.getEvento().getId());
        jsonfile.put("usuario", this.getUsuario().getNome());
        jsonfile.put("data", this.datainscricao);
        
        return jsonfile;
    }
    
    
    
}
