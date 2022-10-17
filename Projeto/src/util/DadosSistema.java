/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Modelo.Caixa;

/**
 *
 * @author APARECIDO MARCOS
 */
public class DadosSistema {
    
    private static Caixa caixaAtualAberto = null;

    public static Caixa getCaixaAtualAberto() {
        return caixaAtualAberto;
    }

    public static void setCaixaAtualAberto(Caixa entrada) {
        caixaAtualAberto = entrada;
    }
    
    
}
