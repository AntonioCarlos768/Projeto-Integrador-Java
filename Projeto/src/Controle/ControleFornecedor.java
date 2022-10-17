/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Fornecedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.GerenciadorDeConexao;

/**
 *
 * @author Aluno
 */
public class ControleFornecedor {

    List<Fornecedor> lista = new ArrayList<>();

    public List<Fornecedor> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Fornecedor> consulta = gerente.createNamedQuery("Fornecedor.Todos", Fornecedor.class);

        return consulta.getResultList();

    }

    public void inserir(Fornecedor f) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(f);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(Fornecedor f) {
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(f);
        
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void excluir(Fornecedor f) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        Fornecedor respExcluir = gerente.find(Fornecedor.class, f.getCodigoFornecedor());
        gerente.getTransaction().begin();
        gerente.remove(respExcluir);
        gerente.getTransaction().commit();
    }

      public List<Fornecedor> listarPorNome(String nome)
    {
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        
        // criar um objeto do tipo Consulta
        TypedQuery<Fornecedor> consulta = gerente.createNamedQuery("Fornecedor.Nome", Fornecedor.class);
        consulta.setParameter("NomeFornecedor","%"+nome+"%");
     
        return consulta.getResultList();
        
    }    
    
    
}
