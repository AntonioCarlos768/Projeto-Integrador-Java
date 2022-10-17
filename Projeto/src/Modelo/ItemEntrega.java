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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author APARECIDO MARCOS
 */
@NamedQueries({
    @NamedQuery(name = "Item.Todos", query = "SELECT i FROM ItemEntrega i")

})

@Entity
@Table(name = "itementrega")
@IdClass(ItemEntregaId.class)
public class ItemEntrega implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "idVenda", referencedColumnName = "idvenda")
    private Pedido pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "idProduto", referencedColumnName = "id")
    private Produto produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco")
    private float preco;

    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

  

    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.nome);
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
        final ItemEntrega other = (ItemEntrega) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
//
//    @Override
//    public String toString() {
//        return "ItemEntrega{" + "pedido=" + pedido + ", produto=" + produto + ", cod=" + cod + ", quantidade=" + quantidade + ", preco=" + preco + ", nome=" + nome + '}';
//    }
//


   

}
