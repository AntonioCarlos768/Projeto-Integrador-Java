/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Aluno
 */


@NamedQueries({

   
   @NamedQuery(name="Fornecedor.Todos", query="SELECT f FROM Fornecedor f"),
        @NamedQuery(name="Cliente.Nome", 
            query="SELECT c FROM Cliente c WHERE c.nome LIKE :NomeCliente"),
        
})


@Entity
@Table(name="fornecedor")
public class Fornecedor implements Serializable {
      
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idfornecedor")
    private int codigoFornecedor;
    
    @Column(name="nome")
    private String nomeEmpresa;
    
    @Column(name="valor_a_ser_pago")
    private float valorASerPago;
    
    @Column(name="data_entrega")
    @Temporal (TemporalType.DATE)
    private Date dataEntrega;
    
    @Column(name="cidade")
    private String cidade; 
    
    @Column(name="endereco")
    private String endereco;
    
    @Column(name="telefone")
    private String telefone;
    
    @Column(name="email")
    private String email;
    
    @Column(name="cep")
    private String cep;

    @Column(name="uf")
    private String uf;

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
   
    public int getCodigoFornecedor() {
        return codigoFornecedor;
    }

    public void setCodigoFornecedor(int codigoFornecedor) {
        this.codigoFornecedor = codigoFornecedor;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public float getValorASerPago() {
        return valorASerPago;
    }

    public void setValorASerPago(float valorASerPago) {
        this.valorASerPago = valorASerPago;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.codigoFornecedor;
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
        final Fornecedor other = (Fornecedor) obj;
        if (this.codigoFornecedor != other.codigoFornecedor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "codigoFornecedor=" + codigoFornecedor + ", nomeEmpresa=" + nomeEmpresa + ", valorASerPago=" + valorASerPago + ", dataEntrega=" + dataEntrega + ", cidade=" + cidade + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", cep=" + cep + '}';
    }




}
