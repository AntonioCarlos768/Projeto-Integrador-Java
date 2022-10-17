/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;


import Modelo.ItemEntrega;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.GerenciadorDeConexao;

/**
 *
 * @author APARECIDO MARCOS
 */
public class Controleitem {
    
    public List<ItemEntrega> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<ItemEntrega> consulta = gerente.createNamedQuery("Item.Todos", ItemEntrega.class);
        
        return consulta.getResultList();

    }

 public void inserir(ItemEntrega i) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(i);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(ItemEntrega i) {
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(i);
        gerente.getTransaction().commit();
        gerente.close();
    }

   public void excluir (ItemEntrega i){
    
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        ItemEntrega respExcluir= gerente.find(ItemEntrega.class, i.getNome());
        gerente.getTransaction().begin();
        gerente.remove(respExcluir);
        gerente.getTransaction().commit();
    }
    

}
