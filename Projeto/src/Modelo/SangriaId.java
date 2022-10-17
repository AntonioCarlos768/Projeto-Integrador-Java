/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Aluno
 */
public class SangriaId {
   
    private Date datacaixa;
    
    private int idsangria;

    public Date getDate() {
        return datacaixa;
    }

    public void setDate(Date Date) {
        this.datacaixa = Date;
    }

    public int getIdsangria() {
        return idsangria;
    }

    public void setIdsangria(int idsangria) {
        this.idsangria = idsangria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.datacaixa);
        hash = 97 * hash + this.idsangria;
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
        final SangriaId other = (SangriaId) obj;
        if (this.idsangria != other.idsangria) {
            return false;
        }
        if (!Objects.equals(this.datacaixa, other.datacaixa)) {
            return false;
        }
        return true;
    }

    
    
}
