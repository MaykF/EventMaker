package Modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.swing.JLabel;
import org.json.simple.JSONObject;

public class Credenciamento extends ObjetoBase {
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataC;
    private JLabel horaAtual; 
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
    
    public JLabel getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(JLabel horaAtual) {
        this.horaAtual = horaAtual;
    }

    @Override
    public ObjetoBase toObjeto(JSONObject jsonfile) {
        try {
            SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
            //this.setId(Integer.parseInt(String.valueOf(jsonfile.get("id"))));
            this.setDataC(ddMMyyyy.parse(jsonfile.get("data").toString()));
            this.setInscricao((Inscricao) jsonfile.get("inscricao"));
            this.setPessoa((Pessoa) jsonfile.get("pessoa"));
            this.setHoraAtual((JLabel)jsonfile.get("horaatual"));
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
        jsonfile.put("horaatual", this.horaAtual);
        return jsonfile;
    }
}
