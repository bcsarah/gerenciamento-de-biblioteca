/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.table.DefaultTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Ifal
 */
public class TelaHistorico extends javax.swing.JPanel {

    private Usuario usuario;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaHistorico(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        carregarHistorico();
    }

    private void carregarHistorico() {
        LabelUsuario.setText("Histórico de: " + usuario.getNome());

        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Livro", "Data Empréstimo", "Devolução Prevista", "Devolução Real", "Status"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Junta ativos + histórico (todos os empréstimos daquele usuário)
        List<Emprestimo> todos = usuario.getEmprestimosLista();

        for (Emprestimo e : todos) {
            String dataDev = e.getDataDevolucao() != null ? e.getDataDevolucao().format(FORMATO_DATA) : "—";
            String status;
            if (e.isDevolvido()) {
                status = "Devolvido";
            } else if (e.isAtrasado()) {
                status = "Em atraso";
            } else {
                status = "Em aberto";
            }

            modelo.addRow(new Object[]{
                e.getLivro().getNome(),
                e.getDataEmprestimo().format(FORMATO_DATA),
                e.getDataPrevistaDevolucao().format(FORMATO_DATA),
                dataDev,
                status
            });
        }

        jTable1.setModel(modelo);

        if (todos.isEmpty()) {
            LabelResumo.setText("Este usuário não possui empréstimos registrados.");
        } else {
            long ativos = usuario.getEmprestimosAtivos().size();
            long devolvidos = usuario.getHistorico().size();
            LabelResumo.setText("Total: " + todos.size() + "   |   Ativos: " + ativos + "   |   Devolvidos: " + devolvidos);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topo = new javax.swing.JPanel();
        Voltar = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        LabelResumo = new javax.swing.JLabel();
        TabelaScroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Informativo.setText("Histórico");

        Voltar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Voltar.setText("← Voltar");
        Voltar.addActionListener(this::VoltarActionPerformed);

        javax.swing.GroupLayout TopoLayout = new javax.swing.GroupLayout(Topo);
        Topo.setLayout(TopoLayout);
        TopoLayout.setHorizontalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Informativo)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGap(110, 110, 110))
        );
        TopoLayout.setVerticalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Informativo))
                .addGap(10, 10, 10))
        );

        LabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelUsuario.setText("Histórico de: ");

        LabelResumo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LabelResumo.setText("Total: 0");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Data Empréstimo", "Devolução Prevista", "Devolução Real", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class,
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        TabelaScroll.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LabelUsuario)
                    .addComponent(LabelResumo)
                    .addComponent(TabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(LabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelResumo)
                .addGap(15, 15, 15)
                .addComponent(TabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaUsuarios());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel LabelResumo;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JScrollPane TabelaScroll;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton Voltar;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}