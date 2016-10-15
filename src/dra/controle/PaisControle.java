/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.Pais;
import dra.model.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class PaisControle {
    
    private EntityManager em;

    public PaisControle(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Pais pais) {
        DAO<Pais> dao = new DAO(em, Pais.class);
        em.getTransaction().begin();
        dao.inserir(pais);
        em.getTransaction().commit();
    }

    public Pais consultar(Pais pais) {
        DAO<Pais> dao = new DAO(em,Pais.class);
        return dao.consultar(pais.getID());
    }
    
    public List<Pais> listarTodos() {
        DAO<Pais> dao = new DAO(em, Pais.class);
        return dao.listar();
    }

    public List<Pais> listarPorNome(String nome) {
        DAO<Pais> dao = new DAO(em,Pais.class);
        String query = "select o from Pais o where o.descricao like '%"+nome+"%'";
        return dao.listarPorQuery(query);
    }

    public void alterar(Pais pais) {
        DAO<Pais> dao = new DAO(em,Pais.class);
        em.getTransaction().begin();
        dao.alterar(pais);
        em.getTransaction().commit();
    }

    public void remover(Pais pais) {
        DAO<Pais> dao = new DAO(em,Pais.class);
        em.getTransaction().begin();
        dao.remover(pais);
        em.getTransaction().commit();
    }
}
