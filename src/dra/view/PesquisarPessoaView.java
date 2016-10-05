/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view;

import dra.controle.PessoaControle;
import dra.model.Pessoa;
import dra.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class PesquisarPessoaView {

    private final EntityManager em;
    private final PessoaControle controle;
    private String nome;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;

    public PesquisarPessoaView() {
        this.em = new JPAUtil().getEntityManager();
        this.controle = new PessoaControle(em);
        this.pessoa = new Pessoa();
    }

    public void pesquisar() {
        if (this.nome.isEmpty()) {
            this.pessoas = this.controle.listarTodos();
        } else {
            this.pessoas = this.controle.listarPorNome(this.nome);
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
}
