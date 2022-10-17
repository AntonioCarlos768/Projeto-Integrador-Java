/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Caixa;
import Modelo.Sangria;
import java.text.SimpleDateFormat;
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
public class ControleCaixa {

    public List<Caixa> listarTodos() {

        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Caixa> consulta = gerente.createNamedQuery("Caixa.Todos", Caixa.class);

        return consulta.getResultList();

    }

    public Caixa existeCaixa(Date data) throws Exception {
        Caixa c = null;
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Caixa> consulta = gerente.createNamedQuery("Caixa.Data", Caixa.class);
        consulta.setParameter("datacaixa", data);
        c = consulta.getSingleResult();
        return c;
    }

    public Caixa caixaAtual(String tipo) throws Exception {
        Caixa c = null;
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Caixa> consulta = gerente.createNamedQuery("Caixa.Atual", Caixa.class);
        consulta.setParameter("tipo", tipo);
        c = consulta.getSingleResult();

        return c;
    }

    public void inserir(Caixa c) {

        List<Sangria> lista = c.getListaSangria();
        c.setListaSangria(null);

        EntityManager gerente = GerenciadorDeConexao.getGerente();

        gerente.getTransaction().begin();
        gerente.persist(c);

        for (Sangria sangria : lista) {
            sangria.setDatacaixa(c);

        }
        c.setListaSangria(lista);
    
        gerente.getTransaction().commit();
        this.alterar(c);
        gerente.close();
    }

    public void alterar(Caixa c) {
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        gerente.getTransaction().begin();
        gerente.merge(c);
        gerente.getTransaction().commit();
        gerente.close();
    }

    public void abrirCaixa(Caixa r) {
        r.setStatus("a");
        this.alterar(r);
    }

    public void fecharCaixa(Caixa r) {
        r.setStatus("f");
        this.alterar(r);
    }

    public Caixa buscaCaixa(Date dataProcurada) {
        List<Caixa> lista = new ArrayList<>();
        SimpleDateFormat formatar = new SimpleDateFormat("yyyy-MM-dd");
        String data = formatar.format(dataProcurada);
        EntityManager gerente = GerenciadorDeConexao.getGerente();
        TypedQuery<Caixa> consulta = gerente.createNamedQuery("Caixa.Data", Caixa.class);
        try {
            consulta.setParameter("datacaixa", formatar.parse(data));
        } catch (Exception e) {
        }
        lista = consulta.getResultList();
        if (lista.size() == 1) {
            return lista.get(0);
        } else {
            return null;
        }
    }

}
