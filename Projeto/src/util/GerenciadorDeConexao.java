/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class GerenciadorDeConexao {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getFabrica() {
        if (emf == null) {

            emf = Persistence.createEntityManagerFactory("ProjetoPU");

        }

        return emf;

    }

    public static EntityManager getGerente() {
        return getFabrica().createEntityManager();
    }

}
