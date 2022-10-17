/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author APARECIDO MARCOS
 */

@NamedQueries({

   
   @NamedQuery(name="Compra.Todos", query="SELECT c FROM Compra c") 
})


@Entity
@Table(name = "compra")
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCompra")
    private int idcompra;

    @Column(name = "valortotal")
    private float valor;

    
//    @Column(name = "data")
//    @Temporal(TemporalType.DATE)
//    private Date data;
    
    @ManyToOne
    @JoinColumn(name = "idfornecedor", referencedColumnName = "idfornecedor")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name = "idDataCaixa", referencedColumnName = "idDataCaixa")
    private Caixa caixa;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "compra")
    private List<ItemCompra> listacompra = new ArrayList<>();

    public List<ItemCompra> getListaCompra() {
        return listacompra;
    }

    public void setListacompra(List<ItemCompra> listacompra) {
        this.listacompra = listacompra;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

//    public Date getData() {
//        return data;
//    }
//
//    public void setData(Date data) {
//        this.data = data;
//    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.idcompra;
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
        final Compra other = (Compra) obj;
        if (this.idcompra != other.idcompra) {
            return false;
        }
        return true;
    }

////    @Override
////    public String toString() {
////        return "Compra{" + "idcompra=" + idcompra + ", valor=" + valor + ", data=" + data + ", fornecedor=" + fornecedor + ", caixa=" + caixa + ", listacompra=" + listacompra + '}';
////    }

    @Override
    public String toString() {
        return "Compra{" + "idcompra=" + idcompra + ", valor=" + valor + ", fornecedor=" + fornecedor + ", caixa=" + caixa + '}';
    }

    

    

}
