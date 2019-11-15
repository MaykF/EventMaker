package Controller;

import Modelo.Pessoa;

public class ControllerPessoa extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Pessoa();
    }
    
    
}
