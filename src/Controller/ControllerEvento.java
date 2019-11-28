package Controller;

import Modelo.Evento;
import Modelo.ObjetoBase;
import Persistencia.FuncoesJPA;
import Persistencia.PersistenciaJPA;
import org.json.simple.JSONObject;

public class ControllerEvento extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Evento();
    }
    
    public Evento ConsultaEvento(String codigo){
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        return (Evento) DAO.recuperar(Integer.valueOf(codigo));
    }
}
