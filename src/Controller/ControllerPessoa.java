/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Pessoa;

/**
 *
 * @author Maycon
 */
public class ControllerPessoa extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Pessoa();
    }
    
    
}
