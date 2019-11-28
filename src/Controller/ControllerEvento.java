package Controller;

import Modelo.Evento;

public class ControllerEvento extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Evento();
    }
    
    
}
