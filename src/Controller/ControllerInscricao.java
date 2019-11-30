/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Inscricao;
import Modelo.ObjetoBase;

/**
 *
 * @author Maycon
 */
public class ControllerInscricao extends ControllerBase{

    @Override
    public void CriarObjetoControle() {
        
        objetoControle = new Inscricao();
    }
    
}
