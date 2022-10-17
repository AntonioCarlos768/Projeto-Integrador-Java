/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author APARECIDO MARCOS
 */
public class ItemEntregaId implements Serializable {

    private int pedido;

    private int produto;


    
    
    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.pedido;
        hash = 53 * hash + this.produto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemEntregaId other = (ItemEntregaId) obj;
        if (this.pedido != other.pedido) {
            return false;
        }
        if (this.produto != other.produto) {
            return false;
        }
        return true;
    }

    
    

}
