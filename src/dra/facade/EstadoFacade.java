/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.facade;

import dra.controle.EstadoControle;
import dra.model.Estado;
import dra.model.Pais;
import dra.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class EstadoFacade {
    
    
    private final EntityManager em;
    private final EstadoControle controle;
    private String nome;
    private Estado estado;
    private List<Estado> estados;
    private List<Pais> paises;

    public EstadoFacade() {
        this.em = new JPAUtil().getEntityManager();
        this.controle = new EstadoControle(em);
    }

    public void pesquisar() {
        if (this.nome.isEmpty()) {
            this.estados = this.controle.listarTodos();
        } else {
            this.estados = this.controle.listarPorNome(this.nome);
        }
    }

    public void consultar(int linha) {
        Estado aux = this.estados.get(linha);
        this.estado = this.controle.consultar(aux);
    }

    public void detalhar(String nome) {
        this.novoEstado();
        for (Estado estado : this.estados) {
            if (nome.equalsIgnoreCase(estado.getNome())) {
                this.estado = estado;
                break;
            }
        }
    }

    public void excluir() {
        this.controle.remover(this.estado);
    }

    public void salvar() {
        if (this.estado.getID() == 0) {
            this.controle.inserir(this.estado);
        } else {
            this.controle.alterar(this.estado);
        }
    }

    public void novoEstado() {
        this.estado = new Estado();
    }

    public void fechar() {
        new JPAUtil().close(this.em);
    }

    public void preencheDadosEstado(String nome, Pais pais) {
        this.estado.setNome(nome);
    }
    
    private void listarPaises() {
        //this.paises = this.controleEstadoCivil.listarTodos();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
}
