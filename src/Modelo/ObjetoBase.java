package Modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.json.simple.JSONObject;

@MappedSuperclass
public abstract class ObjetoBase{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int codigo) {
        this.id = codigo;
    }
    
    public abstract ObjetoBase toObjeto(JSONObject jsonfile);
    public abstract JSONObject toJSONObject();
    
}