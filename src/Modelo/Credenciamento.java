package Modelo;

import Controller.ControllerInscricao;
import Controller.ControllerPessoa;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.swing.JLabel;
import org.json.simple.JSONObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Credenciamento extends ObjetoBase {
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataC;
    private String horaAtual; 
    @ManyToOne
    private Inscricao inscricao;
    @ManyToOne
    private Pessoa pessoa;
    

    public Date getDataC() {
        return dataC;
    }

    public void setDataC(Date dataC) {
        this.dataC = dataC;
    }

    public Inscricao getInscricao() {
        return inscricao;
    }

    public void setInscricao(Inscricao inscricao) {
        this.inscricao = inscricao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public String getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(String horaAtual) {
        this.horaAtual = horaAtual;
    }

    @Override
    public ObjetoBase toObjeto(JSONObject jsonfile) {
        ControllerInscricao I = new ControllerInscricao();
        ControllerPessoa P = new ControllerPessoa();
        
        try {
            SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
            //this.setId(Integer.parseInt(String.valueOf(jsonfile.get("id"))));
            this.setDataC(ddMMyyyy.parse(jsonfile.get("data").toString()));
            this.setInscricao(I.ConsultaInscricao((String) jsonfile.get("inscricao")));
            this.setPessoa(P.ConsultaPessoa((String) jsonfile.get("pessoa")));
            this.setHoraAtual((String)jsonfile.get("horaatual"));
            return this;
        } catch (ParseException ex) {
            Logger.getLogger(Evento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public JSONObject toJSONObject() {
        JSONObject jsonfile = new JSONObject();
        jsonfile.put("id", this.getId());
        jsonfile.put("data", this.getDataC());
        jsonfile.put("inscricao", this.getInscricao());
        jsonfile.put("pessoa", this.getPessoa());
        jsonfile.put("horaatual", this.getHoraAtual());
        return jsonfile;
    }
}
