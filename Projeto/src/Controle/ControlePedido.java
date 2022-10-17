/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Caixa;
import Modelo.ItemEntrega;
import Modelo.Pedido;
import Modelo.Produto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.GerenciadorDeConexao;

/**
 *
 * @author Aluno
 */
public class ControlePedido {

    List<Pedido> lista = new ArrayList<>();
    List<ItemEntrega> listaItem = new ArrayList<>();
    
    public List<Pedido> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Pedido> consulta = gerente.createNamedQuery("Pedido.Todos", Pedido.class);

        return consulta.getResultList();

    }

    public List<Pedido> listarPagos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Pedido> consulta = gerente.createNamedQuery("Pedido.Pagos", Pedido.class);
        // consulta.setParameter("datacaixa", data);

        return consulta.getResultList();

    }

     public List<Pedido> listarPendentes() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Pedido> consulta = gerente.createNamedQuery("Pedido.Pendentes", Pedido.class);

        return consulta.getResultList();

    }
    
    
     public List<ItemEntrega> listarItens() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<ItemEntrega> consulta = gerente.createNamedQuery("Item.Todos", ItemEntrega.class);


        return consulta.getResultList();

    }
    
    
    public void inserir(Pedido e) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(e);

        for (ItemEntrega itemEntrega : e.getListapedido()) {
            Produto produto = itemEntrega.getProduto();
            produto.setQuantidade(produto.getQuantidade() - itemEntrega.getQuantidade());
            e.setValortotal(itemEntrega.getPreco());
            gerente.merge(produto);
        }

        gerente.getTransaction().commit();
        gerente.close();
    }

    public void alterar(Pedido e) {
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(e);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void excluir(Pedido e) {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        Pedido respExcluir = gerente.find(Pedido.class, e.getId());
        gerente.getTransaction().begin();
        gerente.remove(respExcluir);
        gerente.getTransaction().commit();
    }

    public int compara(Pedido e, Caixa c, Date data) {
        int a = 0;

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Pedido> consulta = gerente.createNamedQuery("Pedido.comparados", Pedido.class);

        if (consulta.equals(c.getDatacaixa())) {
            a = e.getId();
            return a;
        }

        if (c.getDatacaixa().equals(null)) {
            System.out.println("vazio");
        } else {
            if (e.getDatapedido().equals(c.getDatacaixa())) {
                a = e.getId();
                return a;
            }

        }
        return a;

    }

}
