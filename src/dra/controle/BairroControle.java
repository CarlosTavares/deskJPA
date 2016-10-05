/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.Bairro;
import dra.model.Cidade;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class BairroControle {
    
    private EntityManager em;

    public BairroControle(EntityManager em) {
        this.em = em;
    }
    
    public void inserir(Bairro bairro) {
        DAO<Bairro> dao = new DAO(em,Bairro.class);
        em.getTransaction().begin();
        dao.inserir(bairro);
        em.getTransaction().commit();
        em.close();
    }

    public Bairro consultar(Bairro bairro) {
        DAO<Bairro> dao = new DAO(em,Bairro.class);
        return dao.consultar(bairro.getID());
    }
    
    public List<Bairro> listarTodos() {
        DAO<Bairro> dao = new DAO(em,Bairro.class);
        return dao.listar();
    }

    public List<Bairro> listarPorCidade(Cidade cidade) {
        return cidade.getBairros();
    }
}
