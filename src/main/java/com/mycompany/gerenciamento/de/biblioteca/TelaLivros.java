/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ifal
 */
public class TelaLivros extends javax.swing.JPanel {

    private static List<Livro> livros = new ArrayList<>();
    private DefaultTableModel modeloTabela;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaLivros() {
        initComponents();
        atualizarTabela();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
    }

    public static void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public static List<Livro> getLivros() {
        return livros;
    }

    private void atualizarTabela() {
        modeloTabela = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Título", "Autor", "Ano", "ISBN", "Status", "Data Cadastro"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Livro livro : livros) {
            String status = livro.isDisponivel() ? "Disponível" : "Emprestado";
            String data = livro.getDataCadastro() != null ? livro.getDataCadastro().format(FORMATO_DATA) : "";
            modeloTabela.addRow(new Object[]{
                livro.getNome(),
                livro.getAutor(),
                livro.getAno(),
                livro.getIsbn(),
                status,
                data
            });
        }

        jTable1.setModel(modeloTabela);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        atualizarTabela();
    }

    private void removerLivroSelecionado() {
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um livro para remover!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nomeLivro = (String) jTable1.getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja remover o livro \"" + nomeLivro + "\"?",
            "Confirmar Remoção", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            livros.remove(linhaSelecionada);
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Livro removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void RemoverButtonActionPerformed(java.awt.event.ActionEvent evt) {
        removerLivroSelecionado();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            removerLivroSelecionado();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topo = new javax.swing.JPanel();
        VoltarButton = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        CadastrarButton = new javax.swing.JButton();
        RemoverButton = new javax.swing.JButton();
        ListaLabel = new javax.swing.JLabel();
        TabelaLivros = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Informativo.setText("Livros");

        VoltarButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        VoltarButton.setText("← Voltar");
        VoltarButton.addActionListener(this::VoltarButtonActionPerformed);

        javax.swing.GroupLayout TopoLayout = new javax.swing.GroupLayout(Topo);
        Topo.setLayout(TopoLayout);
        TopoLayout.setHorizontalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addComponent(VoltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Informativo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        TopoLayout.setVerticalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VoltarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Informativo))
                .addGap(10, 10, 10))
        );

        CadastrarButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CadastrarButton.setText("Cadastrar");
        CadastrarButton.addActionListener(this::CadastrarButtonActionPerformed);

        RemoverButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        RemoverButton.setText("Remover");
        RemoverButton.addActionListener(this::RemoverButtonActionPerformed);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addComponent(CadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(RemoverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CadastrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RemoverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        ListaLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        ListaLabel.setText("Livros Cadastrados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título", "Autor", "Ano", "ISBN", "Status", "Data Cadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class,
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(24);
        TabelaLivros.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListaLabel)
                    .addComponent(TabelaLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ListaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabelaLivros, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarButtonActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaCadastrarLivros());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_CadastrarButtonActionPerformed

    private void VoltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarButtonActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaInicial());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarButton;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel ListaLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JButton RemoverButton;
    private javax.swing.JScrollPane TabelaLivros;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton VoltarButton;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}