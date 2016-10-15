/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Carlos.Tavares
 */
@Entity
public class Telefone implements Serializable {

    @Id
    @GeneratedValue
    private long ID;
    
    private String area;
    private String numero;
    private TipoFoneEnum tipoFone;
    @ManyToOne
    private Pessoa pessoa;

    public Telefone() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoFoneEnum getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(TipoFoneEnum tipoFone) {
        this.tipoFone = tipoFone;
    }

    @Override
    public String toString() {
        return this.getArea()+"-"+this.getNumero();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
