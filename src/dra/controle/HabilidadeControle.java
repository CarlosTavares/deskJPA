/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.Habilidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class HabilidadeControle {
    
    private EntityManager em;

    public HabilidadeControle(EntityManager em) {
        this.em = em;
    }

    public void inserir(Habilidade habilidade) {
        DAO<Habilidade> dao = new DAO(em, Habilidade.class);
        em.getTransaction().begin();
        dao.inserir(habilidade);
        em.getTransaction().commit();
    }

    public List<Habilidade> listarTodos() {
        DAO<Habilidade> dao = new DAO(em, Habilidade.class);
        return dao.listar();
    }
}
