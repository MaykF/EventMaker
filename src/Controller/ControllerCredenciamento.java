/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Credenciamento;

/**
 *
 * @author Maycon
 */
public class ControllerCredenciamento extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        objetoControle = new Credenciamento();
    }
    
}
