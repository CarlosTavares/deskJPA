/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.controle;

import dra.dao.DAO;
import dra.model.EstadoCivil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class EstadoCivilControle {

    private EntityManager em;

    public EstadoCivilControle(EntityManager em) {
        this.em = em;
    }

    public void inserir(EstadoCivil estadoCivil) {
        DAO<EstadoCivil> dao = new DAO(em, EstadoCivil.class);
        em.getTransaction().begin();
        dao.inserir(estadoCivil);
        em.getTransaction().commit();
        em.close();
    }

    public List<EstadoCivil> listarTodos() {
        DAO<EstadoCivil> dao = new DAO(em, EstadoCivil.class);
        return dao.listar();
    }
}
