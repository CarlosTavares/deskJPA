/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Carlos.Tavares
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private long ID;

    @Column(nullable = false, unique = true, length = 100)
    private String nome;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar nascimento;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SexoEnum sexo;
    @Column(nullable = false)
    private String endereco;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Bairro bairro;
    @JoinColumn(nullable = false)
    @ManyToOne
    private EstadoCivil estadoCivil;

    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Telefone> telefones;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "pessoa_habilidades", joinColumns = {
        @JoinColumn(name = "pessoa_ID", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "habilidade_ID", nullable = false)})
    private List<Habilidade> habilidades;

    public Pessoa() {
        this.habilidades = new ArrayList<>();
        this.telefones = new ArrayList<>();
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public SexoEnum getSexo() {
        return sexo;
    }

    public void setSexo(SexoEnum sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
