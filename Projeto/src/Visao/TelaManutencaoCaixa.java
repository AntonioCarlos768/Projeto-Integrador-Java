/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControleCaixa;
import Controle.ControlePedido;
import Modelo.Caixa;
import Modelo.Pedido;
import Modelo.Sangria;
import java.awt.Color;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DadosSistema;

/**
 *
 * @author Aluno
 */
public class TelaManutencaoCaixa extends javax.swing.JDialog {

    float valorAbertura;
    float calculo;

    private ControleCaixa controledao = new ControleCaixa();
    private ControlePedido controlepedido = new ControlePedido();

    private List<Caixa> tabelalista = new ArrayList<>();
    private List<Sangria> listaSangria = new ArrayList<>();
    private List<Pedido> listaPedido = new ArrayList<>();

    boolean VALatualizaTabela = false;
    boolean VALatualizaSangria = false;

    // Caixa f = new Caixa() ; 
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

    private boolean salvar = false;

    /**
     * Creates new form TelaManutencaoCaixa
     */
    public TelaManutencaoCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        try {
            DadosSistema.setCaixaAtualAberto(controledao.existeCaixa(new Date()));
        } catch (Exception ex) {
            Logger.getLogger(TelaManutencaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
            DadosSistema.setCaixaAtualAberto(null);
        }

        if (DadosSistema.getCaixaAtualAberto() == null) {

            txtStatus.setText("NULO");
            txtStatus.setForeground(Color.DARK_GRAY);
            fecharCaixa.setEnabled(false);
            BTsangria.setEnabled(false);

        } else {

            Caixa caixaAberto = DadosSistema.getCaixaAtualAberto();

            if (caixaAberto.getStatus().equals("a")) {
                JOptionPane.showMessageDialog(this, "O caixa está Aberto");
                AbrirCaixa.setEnabled(false);
                fecharCaixa.setEnabled(true);
                BTsangria.setEnabled(true);
                TXTdata.setText(formato.format(caixaAberto.getDatacaixa()));
                txtSaldoAtual.setText("" + caixaAberto.getValorabertura());
                txtStatus.setText("ABERTO");
                txtStatus.setForeground(Color.GREEN);
                atualizaTabela(true);
                atualizaSangria(true);
                System.out.println("Status:" + caixaAberto.getStatus());
            }

            if (caixaAberto.getStatus().equals("f")) {
                JOptionPane.showMessageDialog(this, "O caixa está Fechado");
                fecharCaixa.setEnabled(false);
                BTsangria.setEnabled(false);
                AbrirCaixa.setEnabled(true);
                VALatualizaTabela = false;
                txtStatus.setText("FECHADO");
                txtStatus.setForeground(Color.RED);
                atualizaTabela(VALatualizaTabela = false);
            }
            //atualizaSangria(true);

        }

    }

    public void atualizaTabela(boolean VALatualizaTabela) {

        if (VALatualizaTabela == true) {

            DefaultTableModel modelo = (DefaultTableModel) TabelaCaixa.getModel();

            while (modelo.getRowCount() > 0) {
                modelo.removeRow(0);
            }

            listaPedido.clear();
            //listaPedido.addAll(controlepedido.listarPagos(DadosSistema.getCaixaAtualAberto().getDatacaixa()));
            //ERROO
            listaPedido.addAll(controlepedido.listarPagos());
            for (Pedido p : listaPedido) {

                //  controlepedido.compara(p, f , DadosSistema.getCaixaAtualAberto().getDatacaixa()); 
                //  JOptionPane.showMessageDialog(null,"o que passou:"+ controlepedido.compara(p, f , DadosSistema.getCaixaAtualAberto().getDatacaixa()));
                // if (DadosSistema.getCaixaAtualAberto().getDatacaixa().equals(controlepedido.listarPagos(DadosSistema.getCaixaAtualAberto().getDatacaixa()))) {
                modelo.addRow(new Object[]{p.getId(), p.getDatapedido(), p.getCliente(), p.getValortotal()
                //p.getValortotal(), formato.format(p.getDataentrega()),
                //controlepedido.listarPagos(DadosSistema.getCaixaAtualAberto().getDatacaixa())

                });
                //}
            }

        }
    }

    public void atualizaSangria(boolean flag) {

        if (flag = true) {

            DefaultTableModel mod = (DefaultTableModel) TabelaSangria.getModel();

            while (mod.getRowCount() > 0) {
                mod.removeRow(0);
            }
            listaSangria = (DadosSistema.getCaixaAtualAberto().getListaSangria());

            for (Sangria s : listaSangria) {
               
                mod.addRow(new Object[]{s.getIdsangria(), s.getValor(), s.getMotivo(),});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaCaixa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        AbrirCaixa = new javax.swing.JButton();
        fecharCaixa = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSaldoAtual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXTdata = new javax.swing.JTextField();
        BTsangria = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaSangria = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("CAIXA");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("PAGAMENTOS RECEBIDOS");

        TabelaCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "CODIGO", "DATA DO PEDIDO", "CLENTE", "VALOR"
            }
        ));
        jScrollPane2.setViewportView(TabelaCaixa);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        AbrirCaixa.setBackground(new java.awt.Color(0, 0, 0));
        AbrirCaixa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        AbrirCaixa.setForeground(new java.awt.Color(0, 204, 255));
        AbrirCaixa.setText("ABRIR CAIXA");
        AbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirCaixaActionPerformed(evt);
            }
        });
        jPanel1.add(AbrirCaixa);

        fecharCaixa.setBackground(new java.awt.Color(0, 0, 0));
        fecharCaixa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fecharCaixa.setForeground(new java.awt.Color(0, 204, 255));
        fecharCaixa.setText("FECHAR CAIXA");
        fecharCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharCaixaActionPerformed(evt);
            }
        });
        jPanel1.add(fecharCaixa);

        fechar.setBackground(new java.awt.Color(204, 51, 0));
        fechar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fechar.setText("FECHAR");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });
        jPanel1.add(fechar);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/caixa-registradora.png"))); // NOI18N

        txtSaldoAtual.setEditable(false);
        txtSaldoAtual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSaldoAtual.setForeground(new java.awt.Color(0, 153, 51));
        txtSaldoAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoAtualActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("SALDO ATUAL:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("DATA:");

        TXTdata.setEditable(false);
        TXTdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTdataActionPerformed(evt);
            }
        });

        BTsangria.setBackground(new java.awt.Color(153, 0, 0));
        BTsangria.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BTsangria.setText("Sangria");
        BTsangria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTsangriaActionPerformed(evt);
            }
        });

        TabelaSangria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID ", "VALOR", "MOTIVO", "DATA"
            }
        ));
        jScrollPane1.setViewportView(TabelaSangria);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("SANGRIAS");

        txtStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXTdata, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(216, 216, 216)
                                .addComponent(jLabel6))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)
                                        .addComponent(BTsangria, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(15, 15, 15)
                        .addComponent(txtStatus))
                    .addComponent(TXTdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTsangria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharActionPerformed
        // TODO add your handling code here:
        dispose();

    }//GEN-LAST:event_fecharActionPerformed

    private void AbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirCaixaActionPerformed
        // TODO add your handling code here:
        System.out.println("1");
        if (DadosSistema.getCaixaAtualAberto() == null) {
            System.out.println("1");
            txtStatus.setText("ABERTO");
            txtStatus.setForeground(Color.GREEN);

            Caixa c = new Caixa();
            JOptionPane.showMessageDialog(null, "Caixa ABERTO");

            fecharCaixa.setEnabled(true);
            BTsangria.setEnabled(true);
            AbrirCaixa.setEnabled(false);

            c.setDatacaixa(new Date());
            TXTdata.setText(formato.format(new Date()));

            valorAbertura = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor de abertura do CAIXA?"));

            c.setValorabertura(valorAbertura);
            c.setStatus("a");

            txtSaldoAtual.setText(String.valueOf((valorAbertura)));

            controledao.inserir(c);

            DadosSistema.setCaixaAtualAberto(c);

            atualizaTabela(true);
            atualizaSangria(true);
        } else {

            if (DadosSistema.getCaixaAtualAberto().getStatus().equals("f")) {

                txtStatus.setText("REABERTO");
                txtStatus.setForeground(Color.GREEN);

                fecharCaixa.setEnabled(true);
                BTsangria.setEnabled(true);
                AbrirCaixa.setEnabled(false);

                Caixa caixaAberto = DadosSistema.getCaixaAtualAberto();

                txtSaldoAtual.setText(String.valueOf((caixaAberto.getValorabertura())));
                DadosSistema.getCaixaAtualAberto().setStatus("a");
                controledao.alterar(DadosSistema.getCaixaAtualAberto());

                TXTdata.setText(formato.format(DadosSistema.getCaixaAtualAberto().getDatacaixa()));

                controledao.alterar(DadosSistema.getCaixaAtualAberto());

                atualizaTabela(true);
                atualizaSangria(true);
            }
//             else {
//
//                txtStatus.setText("ABERTO");
//                txtStatus.setForeground(Color.GREEN);
//
//                fecharCaixa.setEnabled(true);
//                BTsangria.setEnabled(true);
//                AbrirCaixa.setEnabled(false);
//
//                Caixa caixaAberto = DadosSistema.getCaixaAtualAberto();
//
//                txtSaldoAtual.setText(String.valueOf((caixaAberto.getValorabertura())));
//                DadosSistema.getCaixaAtualAberto().setStatus("a");
//                controledao.inserir(DadosSistema.getCaixaAtualAberto());
//
//                TXTdata.setText(formato.format(DadosSistema.getCaixaAtualAberto().getDatacaixa()));
//
//                controledao.alterar(DadosSistema.getCaixaAtualAberto());
//
//                atualizaTabela(true);
//                atualizaSangria(true);
//
//            }

        }


    }//GEN-LAST:event_AbrirCaixaActionPerformed


    private void fecharCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharCaixaActionPerformed
        // TODO add your handling code here:

        if (DadosSistema.getCaixaAtualAberto().getStatus().equals("a")) {

            txtStatus.setText("FECHADO");
            txtStatus.setForeground(Color.RED);

            TXTdata.setText("");
            txtSaldoAtual.setText("FECHADO");

            AbrirCaixa.setEnabled(true);
            BTsangria.setEnabled(false);
            fecharCaixa.setEnabled(false);

            VALatualizaTabela = false;
            VALatualizaSangria = false;
            atualizaTabela(false);
            atualizaSangria(false);

            controledao.fecharCaixa(DadosSistema.getCaixaAtualAberto());
            JOptionPane.showMessageDialog(fechar, "O Caixa Foi Fechado");
            // DadosSistema.setCaixaAtualAberto(null);

        }

    }//GEN-LAST:event_fecharCaixaActionPerformed

    private void BTsangriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTsangriaActionPerformed
        // TODO add your handling code here:

        TelaSangria tela = new TelaSangria(null, true);
        tela.setVisible(true);

        int posicao = listaSangria.size();
        if (tela.isSalvar()) {
            Caixa c = DadosSistema.getCaixaAtualAberto();
            Sangria s = tela.getSangria();
            posicao += 1;
            s.setIdsangria(posicao);
            s.setDatacaixa(DadosSistema.getCaixaAtualAberto()); // EStá duplicando a chave     
            listaSangria.add(s);
            c.setListaSangria(listaSangria);
            controledao.alterar(c);

            // c.setTotalsaida(c.getTotalsaida() + s.getValor());
            //controledao.alterar(c);
            atualizaSangria(true);

        } else {

            JOptionPane.showMessageDialog(null, "Caixa é nulo");

//            Sangria s = tela.getSangria();
//            posicao += 1;
//            s.setIdsangria(posicao);
//            s.setDatacaixa(caixaAberto);
//
//            controlesangria.alterar(s);
//            listaSangria.add(s);
//            atualizaSangria(true);
        }


    }//GEN-LAST:event_BTsangriaActionPerformed

    private void TXTdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTdataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTdataActionPerformed

    private void txtSaldoAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoAtualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoAtualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaManutencaoCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaManutencaoCaixa dialog = new TelaManutencaoCaixa(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AbrirCaixa;
    private javax.swing.JButton BTsangria;
    private javax.swing.JTextField TXTdata;
    private javax.swing.JTable TabelaCaixa;
    private javax.swing.JTable TabelaSangria;
    private javax.swing.JButton fechar;
    private javax.swing.JButton fecharCaixa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtSaldoAtual;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
