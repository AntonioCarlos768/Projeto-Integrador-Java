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

   @NamedQuery(name="Cliente.Todos", query="SELECT c FROM Cliente c"),
     @NamedQuery(name="Cliente.Nome", 
            query="SELECT c FROM Cliente c WHERE c.nome LIKE :NomeCliente"),
    
})


@Table(name="cliente")
@Entity
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="idcliente")
    private int idcliente;
    
    @Column (name="nome")
    private String nome;

    @Column (name="telefone")
    private String telefone;
            
    @Column (name="email")
   private String email;
    
    @Column (name="endereco")
    private String endereco;

    @Column (name="cidade")
    private String cidade;

    @Column (name="uf")
    private String uf;

    @Column (name="cep")
    private String cep;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
    
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    
    
 

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.idcliente;
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
        final Cliente other = (Cliente) obj;
        if (this.idcliente != other.idcliente) {
            return false;
        }
        return true;
    }

    
    

    @Override
    public String toString() {
        return "Cliente{" + "idcliente=" + idcliente + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + '}';
    }

    

            
}
