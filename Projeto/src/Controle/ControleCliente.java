/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;


import Modelo.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.GerenciadorDeConexao;

/**
 *
 * @author Aluno
 */
public class ControleCliente {
    
    
     public List<Cliente> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Cliente> consulta = gerente.createNamedQuery("Cliente.Todos", Cliente.class);
        
        return consulta.getResultList();

    }

     public void inserir(Cliente c){
    
        EntityManager gerente = GerenciadorDeConexao.getGerente();
    gerente.getTransaction().begin();
    gerente.persist(c);
    gerente.getTransaction().commit();
    gerente.close();
    }
    
    
   public void alterar(Cliente c){
     EntityManager gerente = GerenciadorDeConexao.getGerente();
      gerente.getTransaction().begin();
      gerente.merge(c);
      gerente.getTransaction().commit();
    gerente.close();
    }
    
    public void excluir (Cliente c){
    
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        Cliente respExcluir= gerente.find(Cliente.class, c.getIdcliente());
        gerente.getTransaction().begin();
        gerente.remove(respExcluir);
        gerente.getTransaction().commit();
    }
     
     
     public List<Cliente> listarPorNome(String nome)
    {
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        
        // criar um objeto do tipo Consulta
        TypedQuery<Cliente> consulta = gerente.createNamedQuery("Cliente.Nome", Cliente.class);
        consulta.setParameter("NomeCliente","%"+nome+"%");
     
        return consulta.getResultList();
        
    }    
}
