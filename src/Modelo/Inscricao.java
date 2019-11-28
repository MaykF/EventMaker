package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import org.json.simple.JSONObject;

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
        
        return this;
    }

    @Override
    public JSONObject toJSONObject() {
        
        
        JSONObject jsonfile = new JSONObject();
        
        return jsonfile;
    }
}
