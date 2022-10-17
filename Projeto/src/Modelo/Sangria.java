/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.swing.JTextField;

/**
 *
 * @author Aluno
 */
@NamedQueries({
    @NamedQuery(name = "Sangria.Todos", query = "SELECT s FROM Sangria s")

})

@Entity
@Table(name = "sangria")
@IdClass(SangriaId.class)
public class Sangria implements Serializable{

    @Id
    @ManyToOne
    @JoinColumn(name="idDatacaixa", referencedColumnName = "idDatacaixa")
    private Caixa datacaixa;
    
    @Id
    @Column(name = "idsangria")
    private int idsangria;
    
    
    @Column(name = "valor")
    private float valor;
    @Column(name = "motivo")
    private String motivo;



    public int getIdsangria() {
        return idsangria;
    }

    public void setIdsangria(int idsangria) {
        this.idsangria = idsangria;
    }

    

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Caixa getDatacaixa() {
        return datacaixa;
    }

    public void setDatacaixa(Caixa datacaixa) {
        this.datacaixa = datacaixa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.datacaixa);
        hash = 43 * hash + this.idsangria;
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
        final Sangria other = (Sangria) obj;
        if (this.idsangria != other.idsangria) {
            return false;
        }
        if (!Objects.equals(this.datacaixa, other.datacaixa)) {
            return false;
        }
        return true;
        
      
    }

     


    @Override
    public String toString() {
        return "Sangria{" + "idDataCaixa=" + datacaixa + ", idsangria=" + idsangria + ", valor=" + valor + ", motivo=" + motivo + '}';
    }

  
    
    
}
