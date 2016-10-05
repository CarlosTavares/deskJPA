/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view;

import dra.controle.PessoaControle;
import dra.model.Pessoa;
import dra.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class DetalhePessoaView {
    
    private final EntityManager em;
    private final PessoaControle controle;
    private Pessoa pessoa;

    public DetalhePessoaView() {
        this.em = new JPAUtil().getEntityManager();
        this.controle = new PessoaControle(em);
    }

    public void excluir() {
        this.controle.remover(this.pessoa);
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
