/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos.Tavares
 */
public class JPAUtil {

    private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ex1PU");

    public EntityManager getEntityManager() {
        return fabrica.createEntityManager();
    }

    public void close(EntityManager em) {
        em.close();
    }
}
