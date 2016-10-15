/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.facade;

import dra.controle.PaisControle;
import dra.model.Pais;
import dra.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class PaisFacade {
    
    private final EntityManager em;
    private final PaisControle controle;
    private String nome;
    private Pais pais;
    private List<Pais> paises;

    public PaisFacade() {
        this.em = new JPAUtil().getEntityManager();
        this.controle = new PaisControle(em);
    }

    public void pesquisar() {
        if (this.nome.isEmpty()) {
            this.paises = this.controle.listarTodos();
        } else {
            this.paises = this.controle.listarPorNome(this.nome);
        }
    }

    public void consultar(int linha) {
        Pais aux = this.paises.get(linha);
        this.pais = this.controle.consultar(aux);
    }

    public void detalhar(String nome) {
        this.novoPais();
        for (Pais p : this.paises) {
            if (nome.equalsIgnoreCase(p.getDescricao())) {
                this.pais = p;
                break;
            }
        }
    }

    public void excluir() {
        this.controle.remover(this.pais);
    }

    public void salvar() {
        if (this.pais.getID() == 0) {
            this.controle.inserir(this.pais);
        } else {
            this.controle.alterar(this.pais);
        }
    }

    public void novoPais() {
        this.pais = new Pais();
    }

    public void fechar() {
        new JPAUtil().close(this.em);
    }

    public void preencheDadosPais(String descricao) {
        this.pais.setDescricao(descricao);
    }
    private void listasPaises() {
        this.paises = this.controle.listarTodos();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }
}
