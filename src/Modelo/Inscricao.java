package Modelo;

import Controller.ControllerEvento;
import Controller.ControllerPessoa;
import Controller.ControllerUsuario;
import java.io.Serializable;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import org.json.simple.JSONObject;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.swing.JOptionPane;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Inscricao extends ObjetoBase implements Serializable{

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datainscricao;  // ARMAZENAR A DATA DE GRAVAÇÃO DO EVENTO
    @ManyToOne(fetch = FetchType.EAGER)
    private Evento evento;
    @ManyToOne(fetch = FetchType.EAGER)
    private Pessoa pessoa;  // PESSOA INSCRITA NO EVENTO  
    @ManyToOne
    private Usuario usuario; // USUARIO QUE REALIZADOU A INSCRICAO OU SEJA QUE FOI LOGADO   
    // O USUARIO FOI TROCADO PARA ARMAZENAR SOMENTE UM CODIGO

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
            this.setPessoa(P.ConsultaPessoa((String) jsonfile.get("codpessoa")));
            this.setEvento(E.ConsultaEvento((String) jsonfile.get("codevento")));
            this.setUsuario(ControllerUsuario.RecuperaPorLogin((String) jsonfile.get("usuario")));
            //JOptionPane.showMessageDialog(null, ddMMyyyy.parse(jsonfile.get("data").toString()));
            this.setDatainscricao(ddMMyyyy.parse(jsonfile.get("data").toString()));
            
            return this;
        } catch (ParseException ex) {
            Logger.getLogger(Inscricao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Erro durante construção do objeto inscrição " + ex);
            return null;
        }
    }

    @Override
    public JSONObject toJSONObject() {

        ControllerUsuario U = new ControllerUsuario();          // Cria um controllerUsuario para recuperar o usuario 
        //JSONObject jsonfileU = U.Recuperar(this.getUsuario());  // Joga o usuario retornado em um jsonfile
        
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("id", this.getId());
        jsonfile.put("codpessoa", this.getPessoa().getId());
        jsonfile.put("codevento", this.getEvento().getId());
        jsonfile.put("usuario", jsonfile.get("login") );    // retorna o LOGIN do usuario contido no json file
        jsonfile.put("data", this.datainscricao);
        
        return jsonfile;
    }
    

}
