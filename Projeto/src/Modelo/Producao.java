/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
 * @author APARECIDO MARCOS
 */


@NamedQueries({

   @NamedQuery(name="Producao.Todos", query="SELECT p FROM Producao p"),

     @NamedQuery(name="Producao.Abaixo", query="SELECT p FROM Producao p WHERE p.quantidade <= p.minimo")

})

@Entity
@Table(name = "producao")
public class Producao implements Serializable {
            
  
    @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idproducao")
   private int idproducao;
    
     @Column(name="nome")
   private String nome;

     @Column(name="quantidade")
     private int quantidade;
     
      @Column(name = "preco")
    private float preco;
      
      @Column(name="minimo")
      private int minimo;

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }
      
      

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
      
      

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdproducao() {
        return idproducao;
    }

    public void setIdproducao(int idproducao) {
        this.idproducao = idproducao;
    }
     
     
     
   

    public String getNome() {
        return nome;
    }

   

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.idproducao;
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
        final Producao other = (Producao) obj;
        if (this.idproducao != other.idproducao) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return "Producao{" + "idproducao=" + idproducao + ", nome=" + nome + ", quantidade=" + quantidade + '}';
    }

    
    
     
     
}
