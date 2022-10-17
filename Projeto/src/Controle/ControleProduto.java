/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.GerenciadorDeConexao;

/**
 *
 * @author Aluno
 */
public class ControleProduto {

    List<Produto> lista = new ArrayList<>();

    public ControleProduto() {
    }

    public List<Produto> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Produto> consulta = gerente.createNamedQuery("Produto.Todos", Produto.class);

        return consulta.getResultList();

    }

    public List<Produto> listarAbaixo() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Produto> consulta = gerente.createNamedQuery("Produto.Abaixo", Produto.class);

        return consulta.getResultList();

    }

    public List<Produto> listarPorNome(String nome) {
        // criar uma conexao com o banco
        EntityManager gerente = GerenciadorDeConexao.getGerente();

        // criar um objeto do tipo Consulta
        TypedQuery<Produto> consulta = gerente.createNamedQuery("Produto.Nome", Produto.class);
        consulta.setParameter("NomeProduto", "%" + nome + "%");

        return consulta.getResultList();

    }

//    public List<Produto> listarPorNome(String nome)
//    {
//        // criar uma conexao com o banco
//        EntityManager gerente = GerenciadorDeConexao.getGerente();
//        
//        // criar um objeto do tipo Consulta
//        TypedQuery<Produto> consulta = gerente.createNamedQuery("Produto.Nome", Produto.class);
//        consulta.setParameter("NomeProduto", "%"+nome+"%");
//     
//        return consulta.getResultList();
//        
//    }    
    public void inserir(Produto p) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(p);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(Produto s) {
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(s);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void excluir(Produto p) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        Produto respExcluir = gerente.find(Produto.class, p.getId());
        gerente.getTransaction().begin();
        gerente.remove(respExcluir);
        gerente.getTransaction().commit();
    }

}
