/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Producao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.GerenciadorDeConexao;

/**
 *
 * @author APARECIDO MARCOS
 */
public class ControleProducao {
    
    
    List<Producao> lista = new ArrayList<>();

    

    public List<Producao> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Producao> consulta = gerente.createNamedQuery("Producao.Todos", Producao.class);
        
        return consulta.getResultList();

    }
    
     public List<Producao> listarAbaixo() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Producao> consulta = gerente.createNamedQuery("Producao.Abaixo", Producao.class);
        
        return consulta.getResultList();

    }

 public void inserir(Producao p){
    
        EntityManager gerente = GerenciadorDeConexao.getGerente();
    gerente.getTransaction().begin();
    gerente.persist(p);
    gerente.getTransaction().commit();
    gerente.close();
    }
    
     public void alterar(Producao p) {
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(p);
        gerente.getTransaction().commit();
        gerente.close();
    }
 
  public void excluir (Producao p){
    
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        Producao respExcluir= gerente.find(Producao.class, p.getIdproducao());
        gerente.getTransaction().begin();
        gerente.remove(respExcluir);
        gerente.getTransaction().commit();
    }
 
}
