/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Caixa.Todos", query = "SELECT c FROM Caixa c"),
    @NamedQuery(name = "Caixa.Atual", query = "SELECT c FROM Caixa c where c.status= :tipo"),
    @NamedQuery(name = "Caixa.Data", query = "SELECT c FROM Caixa c where c.datacaixa=:datacaixa"),})

@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

    @Id
    @Column(name = "idDataCaixa")
    @Temporal(TemporalType.DATE)
    private Date datacaixa;

    @Column(name = "valorentregas")
    private float valorentregas;

    @Column(name = "valorabertura")
    private float valorabertura;

    @Column(name = "totalentrada")
    private float totalentrada;

    @Column(name = "totalsaida")
    private float totalsaida;

    @Column(name = "status")
    private String status;
                                                                     //provavelmente errado "datacaixa", troque por caixa
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "datacaixa")
    List<Sangria> listaSangria = new ArrayList<>();

    public List<Sangria> getListaSangria() {
        return listaSangria;
    }

    public void setListaSangria(List<Sangria> listaSangria) {
        this.listaSangria = listaSangria;
    }

    public Date getDatacaixa() {
        return datacaixa;
    }

    public void setDatacaixa(Date datacaixa) {
        this.datacaixa = datacaixa;
    }

    public float getValorentregas() {
        return valorentregas;
    }

    public void setValorentregas(float valorentregas) {
        this.valorentregas = valorentregas;
    }

    public float getValorabertura() {
        return valorabertura;
    }

    public void setValorabertura(float valorabertura) {
        this.valorabertura = valorabertura;
    }

    public float getTotalentrada() {
        return totalentrada;
    }

    public void setTotalentrada(float totalentrada) {
        this.totalentrada = totalentrada;
    }

    public float getTotalsaida() {
        return totalsaida;
    }

    public void setTotalsaida(float totalsaida) {
        this.totalsaida = totalsaida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.datacaixa);
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
        final Caixa other = (Caixa) obj;
        if (!Objects.equals(this.datacaixa, other.datacaixa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa{" + "datacaixa=" + datacaixa + ", valorentregas=" + valorentregas + ", valorabertura=" + valorabertura + ", totalentrada=" + totalentrada + ", totalsaida=" + totalsaida + ", status=" + status + ", listaSangria=" + listaSangria + '}';
    }

}
