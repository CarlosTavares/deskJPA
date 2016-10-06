/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class PessoaControle {
    
    private EntityManager em;

    public PessoaControle(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Pessoa pessoa) {
        DAO<Pessoa> dao = new DAO(em,Pessoa.class);
        em.getTransaction().begin();
        dao.inserir(pessoa);
        em.getTransaction().commit();
    }

    public Pessoa consultar(Pessoa pessoa) {
        DAO<Pessoa> dao = new DAO(em,Pessoa.class);
        return dao.consultar(pessoa.getID());
    }
    
    public List<Pessoa> listarTodos() {
        DAO<Pessoa> dao = new DAO(em,Pessoa.class);
        return dao.listar();
    }
    
    public List<Pessoa> listarPorNome(String nome) {
        DAO<Pessoa> dao = new DAO(em,Pessoa.class);
        String query = "select o from Pessoa o where o.nome like '%"+nome+"%'";
        return dao.listarPorQuery(query);
    }

    public void alterar(Pessoa pessoa) {
        DAO<Pessoa> dao = new DAO(em,Pessoa.class);
        em.getTransaction().begin();
        dao.alterar(pessoa);
        em.getTransaction().commit();
    }

    public void remover(Pessoa pessoa) {
        DAO<Pessoa> dao = new DAO(em,Pessoa.class);
        em.getTransaction().begin();
        dao.remover(pessoa);
        em.getTransaction().commit();
    }
}
