/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
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
 * @author Aluno
 */

@NamedQueries({
    @NamedQuery(name = "Pedido.Todos", query = "SELECT e FROM Pedido e"),
    
    @NamedQuery(name = "Pedido.Pagos" ,query = "SELECT p FROM Pedido p WHERE p.status = 'p'"),
       // SELECT * FROM projeto.pedido p WHERE p.status = 'p';  
      
    @NamedQuery(name = "Pedido.Pendentes" ,query = "SELECT p FROM Pedido p WHERE p.status != 'p'")
    
})

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @Column(name = "Idvenda")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "localidade")
    private String local;

    @Column(name = "dataentrega")
    @Temporal(TemporalType.DATE)
    private Date dataentrega;

    @Column(name = "datapedido")
    @Temporal(TemporalType.DATE)
    private Date datapedido;

    @Column(name = "valortotal")
    private Float valortotal;

    @Column(name = "status")
    private String status;
    

    @ManyToOne
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemEntrega> listapedido;

@ManyToOne
@JoinColumn(name = "idDataCaixa", referencedColumnName="idDataCaixa" )
private Caixa caixa;    

    public List<ItemEntrega> getListapedido() {
        return listapedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public void setListapedido(List<ItemEntrega> listapedido) {
        this.listapedido = listapedido;
    }

    public Pedido() {
    }

    public Pedido(int id, String local, Date dataentrega, Date datapedido, Float valortotal, Cliente cliente) {
        this.id = id;
        this.local = local;
        this.dataentrega = dataentrega;
        this.datapedido = datapedido;
        this.valortotal = valortotal;
      
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDataentrega() {
        return dataentrega;
    }

    public void setDataentrega(Date dataentrega) {
        this.dataentrega = dataentrega;
    }

    public Date getDatapedido() {
        return datapedido;
    }

    public void setDatapedido(Date datapedido) {
        this.datapedido = datapedido;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }

    //public int getIdproduto() {
    //  return Idproduto;
    // }
    //  public void setIdproduto(int Idproduto) {
    //     this.Idproduto = Idproduto;
    // }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.id;
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
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", local=" + local + ", dataentrega=" + dataentrega + ", datapedido=" + datapedido + ", valortotal=" + valortotal + ", cliente=" + cliente + ", listapedido=" + listapedido + ", caixa=" + caixa + '}';
    }

  

}
