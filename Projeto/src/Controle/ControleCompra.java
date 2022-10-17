/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controle;

import Modelo.Compra;
import Modelo.ItemCompra;
import Modelo.Pedido;
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
public class ControleCompra {

    public void inserir(Compra c) {
        List<ItemCompra> lista = new ArrayList<>();
        lista.addAll(c.getListaCompra());
        c.setListacompra(null);
        
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.persist(c);

//        for (ItemCompra itemcompra : c.getListaCompra()) {
//            itemcompra.setCompra(c);
//            Producao producao = itemcompra.getProducao();
//            producao.setQuantidade(itemcompra.getQuantidade());
//            c.setValor(itemcompra.getPreco());
//            gerente.merge(producao);
//        }
        for (ItemCompra itemCompra : lista) {
            itemCompra.setCompra(c);
        }
       // c.setIdcompra(1);
       // c.setCaixa(c.getCaixa());
        c.setListacompra(lista);
        gerente.merge(c); 
        gerente.getTransaction().commit();
        gerente.close();

    }

    
     List<Compra> lista = new ArrayList<>();

    public List<Compra> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Compra> consulta = gerente.createNamedQuery("Compra.Todos", Compra.class);

        return consulta.getResultList();

    }
    
}
