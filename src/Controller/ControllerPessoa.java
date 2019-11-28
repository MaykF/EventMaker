package Controller;

import Modelo.ObjetoBase;
import Modelo.Pessoa;
import Persistencia.PersistenciaJPA;

public class ControllerPessoa extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Pessoa();
    }
    
    public Pessoa ConsultaPessoa(String codigo){
        PersistenciaJPA<ObjetoBase> DAO = new PersistenciaJPA(classeObjetoControle);
        return (Pessoa) DAO.recuperar(Integer.valueOf(codigo));
    }
    
}
