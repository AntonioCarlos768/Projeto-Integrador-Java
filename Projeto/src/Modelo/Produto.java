/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.Table;

/**
 *
 * @author Aluno
 */

@NamedQueries({

   @NamedQuery(name="Produto.Todos", query="SELECT p FROM Produto p"),
 
  
    
    @NamedQuery(name="Produto.Nome", 
            query="SELECT p FROM Produto p WHERE p.nome_salgado LIKE :NomeProduto"),
    
     @NamedQuery(name="Produto.Id", 
            query="SELECT p FROM Produto p WHERE p.id = :IdProduto"),

        @NamedQuery(name="Produto.Abaixo", query="SELECT p FROM Produto p WHERE p.quantidade <= 5  " )




})

@Entity
@Table (name="produto")
public class Produto implements Serializable {
    
    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
   private int id;
   
    @Column (name="nomeproduto")
    private String nome_salgado;

    @Column (name="quantidade")
    private int quantidade;
    
    @Column (name="valor")
    private float valor;
    
    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_salgado() {
        return nome_salgado;
    }

    public void setNome_salgado(String nome_salgado) {
        this.nome_salgado = nome_salgado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.id;
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
        final Produto other = (Produto) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome_salgado=" + nome_salgado + ", quantidade=" + quantidade + ", valor=" + valor + '}';
    }

    
    




   
    
   
}
