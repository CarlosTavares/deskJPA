/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Carlos.Tavares
 */
public class DAO<tipo> {
    
    private EntityManager em;
    private Class<tipo> classe;

    public DAO(EntityManager em, Class<tipo> classe) {
        this.em = em;
        this.classe = classe;
    }
    
    public void inserir(tipo o) {
        em.persist(o);
    }
    
    public tipo consultar(Long id) {
        return em.find(classe, id);
    }
    
    public void remover(tipo o) {
        em.remove(o);
    }
    
    public List<tipo> listar() {
        Query consulta = em.createQuery("select o from "+classe.getName()+" o");
        return consulta.getResultList();
    }
    
    public List<tipo> listarPorQuery(String query) {
        Query consulta = em.createQuery(query);
        return consulta.getResultList();
    }
    
    public void alterar(tipo o) {
        em.merge(o);
    }
}
