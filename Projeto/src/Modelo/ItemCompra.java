/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author APARECIDO MARCOS
 */
@Entity
@Table(name = "itemcompra")
@IdClass(ItemCompraId.class)
public class ItemCompra implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    private Compra compra;

    @Id
    @ManyToOne
    @JoinColumn(name = "idproducao", referencedColumnName = "idproducao")
    private Producao producao;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private float preco;

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Producao getProducao() {
        return producao;
    }

    public void setProducao(Producao producao) {
        this.producao = producao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

//    @Column(name = "preco")
//    private float preco;
    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

//    public float getPreco() {
//        return preco;
//    }
//
//    public void setPreco(float preco) {
//        this.preco = preco;
//    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.compra);
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
        final ItemCompra other = (ItemCompra) obj;
        if (!Objects.equals(this.compra, other.compra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItemCompra{" + "compra=" + compra + ", quantidade=" + quantidade + '}';
    }

}
