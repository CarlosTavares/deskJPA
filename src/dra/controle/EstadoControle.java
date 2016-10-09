/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.Cidade;
import dra.model.Estado;
import dra.model.Pais;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class EstadoControle {
    
    private EntityManager em;

    public EstadoControle(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Estado estado) {
        DAO<Estado> dao = new DAO(em,Estado.class);
        em.getTransaction().begin();
        dao.inserir(estado);
        em.getTransaction().commit();
        em.close();
    }

    public Estado consultar(Estado estado) {
        DAO<Estado> dao = new DAO(em,Estado.class);
        return dao.consultar(estado.getID());
    }
    
    public List<Estado> listarTodos() {
        DAO<Estado> dao = new DAO(em,Estado.class);
        return dao.listar();
    }

    public List<Estado> listarPorPais(Pais pais) {
        return pais.getEstados();
    }
}
