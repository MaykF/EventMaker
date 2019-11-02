/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.json.simple.JSONObject;

/**
 *
 * @author Maycon
 */
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