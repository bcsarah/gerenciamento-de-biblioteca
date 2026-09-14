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
public class TelaUsuarios extends javax.swing.JPanel {

    private static List<Usuario> usuarios = new ArrayList<>();
    private DefaultTableModel modeloTabela;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaUsuarios() {
        initComponents();
        atualizarTabela();

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
    }

    public static void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    private void atualizarTabela() {
        modeloTabela = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Nome", "CPF", "Telefone", "Email", "Empréstimos Ativos"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Usuario usuario : usuarios) {
            StringBuilder sb = new StringBuilder();
            for (Emprestimo e : usuario.getEmprestimosAtivos()) {
                if (sb.length() > 0) sb.append("; ");
                sb.append(e.getLivro().getNome())
                  .append(" (até ").append(e.getDataPrevistaDevolucao().format(FORMATO_DATA)).append(")");
            }
            String texto = sb.length() > 0 ? sb.toString() : "Nenhum";

            modeloTabela.addRow(new Object[]{
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getTelefone(),
                usuario.getEmail(),
                texto
            });
        }

        jTable1.setModel(modeloTabela);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        atualizarTabela();
    }

    private void removerUsuarioSelecionado() {
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para remover!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nomeUsuario = (String) jTable1.getValueAt(linhaSelecionada, 0);
        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja remover o usuário \"" + nomeUsuario + "\"?",
            "Confirmar Remoção", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            usuarios.remove(linhaSelecionada);
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Usuário removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {
        removerUsuarioSelecionado();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            removerUsuarioSelecionado();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topo = new javax.swing.JPanel();
        Voltar = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        Cadastrar = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        Empréstimo = new javax.swing.JButton();
        ListaLabel = new javax.swing.JLabel();
        TabelaUsuários = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Informativo.setText("Usuários");

        Voltar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Voltar.setText("← Voltar");
        Voltar.addActionListener(this::VoltarActionPerformed);

        javax.swing.GroupLayout TopoLayout = new javax.swing.GroupLayout(Topo);
        Topo.setLayout(TopoLayout);
        TopoLayout.setHorizontalGroup(
            TopoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopoLayout.createSequentialGroup()
                .addComponent(Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Informativo)
                .addGap(0, 0, Short.MAX_VALUE))
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

        Cadastrar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(this::CadastrarActionPerformed);

        Remover.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Remover.setText("Remover");
        Remover.addActionListener(this::RemoverActionPerformed);

        Empréstimo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Empréstimo.setText("Empréstimo");
        Empréstimo.addActionListener(this::EmpréstimoActionPerformed);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Empréstimo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Empréstimo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        ListaLabel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        ListaLabel.setText("Usuários Cadastrados");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Email", "Empréstimos Ativos"
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
        TabelaUsuários.setViewportView(jTable1);

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
                    .addComponent(TabelaUsuários, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(TabelaUsuários, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaCadastrarUsuarios());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_CadastrarActionPerformed

    private void EmpréstimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmpréstimoActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaEmprestimo());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_EmpréstimoActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaInicial());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton Empréstimo;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel ListaLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JButton Remover;
    private javax.swing.JScrollPane TabelaUsuários;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton Voltar;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}