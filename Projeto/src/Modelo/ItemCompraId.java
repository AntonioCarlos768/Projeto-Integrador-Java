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
public class ItemCompraId implements Serializable {

    private int compra;

    private int producao;

    public int getCompra() {
        return compra;
    }

    public void setCompra(int compra) {
        this.compra = compra;
    }

    public int getProducao() {
        return producao;
    }

    public void setProducao(int producao) {
        this.producao = producao;
    }

    public ItemCompraId() {
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.compra;
        hash = 89 * hash + this.producao;
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
        final ItemCompraId other = (ItemCompraId) obj;
        if (this.compra != other.compra) {
            return false;
        }
        if (this.producao != other.producao) {
            return false;
        }
        return true;
    }

    

}
