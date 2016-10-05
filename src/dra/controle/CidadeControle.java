/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.Bairro;
import dra.model.Cidade;
import dra.model.Estado;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class CidadeControle {
    
    private EntityManager em;

    public CidadeControle(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Cidade cidade) {
        DAO<Cidade> dao = new DAO(em,Cidade.class);
        em.getTransaction().begin();
        dao.inserir(cidade);
        em.getTransaction().commit();
        em.close();
    }

    public Cidade consultar(Cidade cidade) {
        DAO<Cidade> dao = new DAO(em,Cidade.class);
        return dao.consultar(cidade.getID());
    }
    
    public List<Cidade> listarTodos() {
        DAO<Cidade> dao = new DAO(em,Cidade.class);
        return dao.listar();
    }

    public List<Cidade> listarPorEstado(Estado estado) {
        return estado.getCidades();
    }
}
