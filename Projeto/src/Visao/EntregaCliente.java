/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControleCaixa;
import Controle.ControlePedido;
import Controle.ControleProduto;
import Controle.Controleitem;
import Modelo.Caixa;
import Modelo.Cliente;
import Modelo.ItemEntrega;
import Modelo.Pedido;
import Modelo.Produto;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DadosSistema;

/**
 *
 * @author APARECIDO MARCOS
 */
public class EntregaCliente extends javax.swing.JDialog {

    private ControleProduto controledao = new ControleProduto();
    private List<Produto> tabelalista = new ArrayList<>();
    private Produto produto;

    private List<ItemEntrega> lista = new ArrayList<>();
    private Controleitem cont = new Controleitem();

    private Cliente cliente;
    private Caixa caixa;
    private ControleCaixa contcaixa = new ControleCaixa();

    private ControlePedido contpedido = new ControlePedido();
    private Pedido pedido;
    private Pedido e = new Pedido();

    private List<Produto> listaProduto = new ArrayList<>();

    private boolean salvar = false;

    private Date dataPedido = new Date();

    boolean existe;
    float armazena = 0;
    int varpag = 0;

    public void verifica() {

        if (txtStatus.getText().equals("p")) {
            System.out.println("EXIBE:" + e.getStatus() + " " + " uhuu");
            System.out.println("EXIBE2:" + txtStatus + " " + " uhuu");
            desligarCampos();
        }

        System.out.println("FORA");
        System.out.println("statusss" + txtStatus);
    }

    public Pedido getEntrega() {

        if (!TXTid.getText().equals("")) {
            e.setId(Integer.parseInt(TXTid.getText()));
        }
        e.setLocal(TXTlocal.getText());
        
        e.setDataentrega(dataentrega.getDate());
        e.setDatapedido(dataPedido);
        e.setCliente(cliente);
        e.setDatapedido(new Date());
        e.setListapedido(lista);
        
        if (varpag == 1) {
            e.setStatus("p");
            e.setCaixa(DadosSistema.getCaixaAtualAberto());
            JOptionPane.showMessageDialog(null, "Pedido Pago");
            System.out.println("realizou");
        }

        System.out.println("entrega: " + e.toString());
        return e;

    }


    public void setEntrega(Pedido e) {

        
        dataPedido = e.getDatapedido();
        TXTlocal.setText(e.getLocal());
        dataentrega.setDate(e.getDataentrega());
        TXTid.setText(String.valueOf(e.getId()));
        TXTcliente.setText(e.getCliente().getNome());
        cliente = e.getCliente();
        txtTotal.setText(String.valueOf(e.getValortotal()));
        lista = e.getListapedido();
        txtStatus.setText(e.getStatus());
        atualizaTabela2(true);
    }

    public void setItem(ItemEntrega i) {
        lista.add(i);
        atualizaTabela2(true);

    }

    public void desligarCampos() {
        TXTcliente.setEditable(false);
        TXTid.setEditable(false);
        TXTlocal.setEditable(false);

        dataentrega.setEnabled(false);
        Salvar.setEnabled(false);
        Pesquisar.setEnabled(false);
        Passar.setEnabled(false);
        Remover.setEnabled(false);
        TabelaProduto.setEnabled(false);
        btPagamento.setEnabled(false);
    }

    public void desligaPag() {
        TXTcliente.setEditable(false);
        TXTid.setEditable(false);
        TXTlocal.setEditable(false);

        dataentrega.setEnabled(false);

        Pesquisar.setEnabled(false);
        Passar.setEnabled(false);
        Remover.setEnabled(false);
        TabelaProduto.setEnabled(false);
        btPagamento.setEnabled(false);
    }

    public void PermitePagamento() {
        btPagamento.setEnabled(true);
    }

    public void NegaPagamento() {
        btPagamento.setEnabled(false);
    }

    /**
     * Creates new form EntregaCliente
     */
    public EntregaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        atualizaTabela(true);

    }

    public boolean isSalvar() {
        return salvar;
    }

    public void setSalvar(boolean salvar) {
        this.salvar = salvar;
    }

    public void atualizaTabela(boolean flag) {
        DefaultTableModel modelo = (DefaultTableModel) TabelaProduto.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        tabelalista.clear();
        tabelalista.addAll(controledao.listarTodos());

        for (Produto d : tabelalista) {

            modelo.addRow(new Object[]{d.getId(), d.getNome_salgado(), d.getQuantidade(), d.getValor()});
        }
    }

    public void atualizaTabela2(boolean a) {

        DefaultTableModel modelo = (DefaultTableModel) TabelaPedido.getModel();

        modelo.setNumRows(0);

        for (ItemEntrega i : lista) {
            modelo.addRow(new Object[]{i.getNome(), i.getQuantidade(), i.getPreco()
            });
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
        jLabel2 = new javax.swing.JLabel();
        TXTcliente = new javax.swing.JTextField();
        Pesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Salvar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        TXTlocal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaPedido = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaProduto = new javax.swing.JTable();
        Passar = new javax.swing.JButton();
        dataentrega = new com.toedter.calendar.JDateChooser();
        TXTid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Remover = new javax.swing.JButton();
        btPagamento = new javax.swing.JButton();
        txtTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setText("INFORMAÇÕS PARA ENTREGA");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cliente:");

        TXTcliente.setEditable(false);
        TXTcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTclienteActionPerformed(evt);
            }
        });

        Pesquisar.setText("Pesquisar");
        Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        Salvar.setBackground(new java.awt.Color(0, 0, 0));
        Salvar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Salvar.setForeground(new java.awt.Color(0, 204, 255));
        Salvar.setText("SALVAR");
        Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarActionPerformed(evt);
            }
        });
        jPanel1.add(Salvar);

        Cancelar.setBackground(new java.awt.Color(204, 51, 0));
        Cancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Cancelar.setText("CANCELAR");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Local da entrega:");

        TXTlocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXTlocalActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Data:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setText("PEDIDOS:");

        TabelaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NOME", "QUANTIDADE", "VALOR TOTAl"
            }
        ));
        jScrollPane1.setViewportView(TabelaPedido);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setText("PRODUTOS:");

        TabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NOME", "QUANTIDADE", "VALOR"
            }
        ));
        jScrollPane2.setViewportView(TabelaProduto);

        Passar.setText("Passar");
        Passar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassarActionPerformed(evt);
            }
        });

        TXTid.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("codigo:");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/intercambio (1).png"))); // NOI18N

        Remover.setText("Remover");
        Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverActionPerformed(evt);
            }
        });

        btPagamento.setBackground(new java.awt.Color(204, 51, 0));
        btPagamento.setText("PAGAMENTO");
        btPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPagamentoActionPerformed(evt);
            }
        });

        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 153, 51));
        txtTotal.setText("VALOR");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("TOTAL");

        jLabel10.setText("SATUS");

        txtStatus.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXTcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Pesquisar)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel5)
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 10, Short.MAX_VALUE)
                                                        .addComponent(Passar)
                                                        .addGap(18, 18, 18))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Remover)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(TXTlocal, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel3))
                                                    .addComponent(dataentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(TXTid, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btPagamento))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pesquisar)
                    .addComponent(TXTcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel10)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(Passar)
                        .addGap(18, 18, 18)
                        .addComponent(Remover)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(dataentrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TXTlocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(TXTid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btPagamento)
                            .addComponent(jLabel4)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void TXTclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTclienteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_TXTclienteActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        this.salvar = false;
        dispose();
    }//GEN-LAST:event_CancelarActionPerformed


    private void PassarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PassarActionPerformed
        // TODO add your handling code here:

        int nrItem = TabelaProduto.getSelectedRow();
        if (nrItem == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum produto foi selecionada");

        } else {

            ItemEntrega i = new ItemEntrega();

            String qtde;
            qtde = JOptionPane.showInputDialog("Informe a quantidade:");

            Produto p = tabelalista.get(nrItem);
            int a = p.getId();

            if (Float.parseFloat(qtde) <= p.getQuantidade() && Float.parseFloat(qtde) >= 1) {

                for (int j = 0; j < lista.size(); j++) {

                    if (lista.get(j).getProduto().equals(p)) {

                        int f = JOptionPane.showConfirmDialog(this, Passar);
                        if (f == 0) {
                            lista.get(j).setQuantidade(lista.get(j).getQuantidade() + Integer.parseInt(qtde));
                            lista.get(j).setPreco(lista.get(j).getPreco() + (tabelalista.get(nrItem).getValor() * Integer.parseInt(qtde)));
                            atualizaTabela2(false);
                            existe = true;
                        } else {
                        }

                    } else {
                        existe = false;
                    }

                }

                if (!existe) {
                    // i.setProduto
                    i.setPedido(e);
                    i.setProduto(p);
                    lista.add(i);
                }

                i.setQuantidade(Integer.parseInt(qtde));
                i.setNome(p.getNome_salgado());

                float calc = p.getValor() * Float.parseFloat(qtde) + armazena;

                armazena = calc;
                txtTotal.setText(String.valueOf(armazena));

////                 float preco = p.getValor() * Float.parseFloat(qtde);
////                i.setPreco(preco);
                i.setPreco(armazena);

                System.out.println("Valor E:" + armazena);

                for (ItemEntrega it : lista) {

                    if (it.getPedido().equals(it.getPedido())) {

                        // e.setValortotal(it.getPreco());
                        e.setValortotal(armazena);
                        System.out.println("Valor DEntro:" + armazena);
                    }

                }

                atualizaTabela2(true);
                atualizaTabela(true);
            } else {
                JOptionPane.showMessageDialog(null, "O valor ultrapassou a quantidade em estoque "
                        + "ou é Negativo");
            }

        }


    }//GEN-LAST:event_PassarActionPerformed

    private void TXTlocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXTlocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXTlocalActionPerformed

    private void PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarActionPerformed
        // TODO add your handling code here:

        PesCliente tela = new PesCliente(null, true);
        tela.setVisible(true);

        TXTcliente.setText(tela.getcliente().getNome());
        this.cliente = tela.getcliente();

        System.out.println(cliente.toString());

    }//GEN-LAST:event_PesquisarActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        // TODO add your handling code here:

        if (TXTlocal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Um Local deve ser digitado");
            TXTlocal.requestFocus();
        } else if (TXTcliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Um cliente deve ser selecionado");
        } else if (dataentrega.getDateFormatString().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Uma Data deve ser selecionada");

        } else {
            this.salvar = true;
            setVisible(false);
        }

    }//GEN-LAST:event_SalvarActionPerformed

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverActionPerformed
        // TODO add your handling code here:

        int nrItem = TabelaPedido.getSelectedRow();
        if (nrItem == -1) {
            JOptionPane.showMessageDialog(this, "Nenhum produto foi selecionada");

        } else {

            int certeza = JOptionPane.showConfirmDialog(null, "Deseja remover da lita",
                    "Remover", JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

            if (certeza == JOptionPane.YES_OPTION) {

                ItemEntrega Item = lista.get(nrItem);
                lista.remove(nrItem);
               
                atualizaTabela2(true);
            }

        }

    }//GEN-LAST:event_RemoverActionPerformed

    private void btPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPagamentoActionPerformed
        // TODO add your handling code here:
        btPagamento.setBackground(Color.GREEN);
        desligaPag();
        varpag = 1;

    }//GEN-LAST:event_btPagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(EntregaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntregaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntregaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntregaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EntregaCliente dialog = new EntregaCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Passar;
    private javax.swing.JButton Pesquisar;
    private javax.swing.JButton Remover;
    private javax.swing.JButton Salvar;
    private javax.swing.JTextField TXTcliente;
    private javax.swing.JTextField TXTid;
    private javax.swing.JTextField TXTlocal;
    private javax.swing.JTable TabelaPedido;
    private javax.swing.JTable TabelaProduto;
    private javax.swing.JButton btPagamento;
    private com.toedter.calendar.JDateChooser dataentrega;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables

    private void atualizatabela2(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
