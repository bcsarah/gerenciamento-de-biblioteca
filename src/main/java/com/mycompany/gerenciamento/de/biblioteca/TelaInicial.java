/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

/**
 *
 * @author Ifal
 */
public class TelaInicial extends javax.swing.JPanel {

    public TelaInicial() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Informativo = new javax.swing.JLabel();
        Subtitulo = new javax.swing.JLabel();
        LivrosButton = new javax.swing.JButton();
        UsuariosButton = new javax.swing.JButton();
        RelatoriosButton = new javax.swing.JButton();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setText("Gerenciamento de Biblioteca");

        Subtitulo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Subtitulo.setText("Escolha uma opção para começar");

        LivrosButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        LivrosButton.setText("Livros");
        LivrosButton.addActionListener(this::LivrosButtonActionPerformed);

        UsuariosButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        UsuariosButton.setText("Usuários");
        UsuariosButton.addActionListener(this::UsuariosButtonActionPerformed);

        RelatoriosButton.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        RelatoriosButton.setText("Relatórios");
        RelatoriosButton.addActionListener(this::RelatoriosButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Informativo)
                    .addComponent(Subtitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LivrosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(UsuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(RelatoriosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(Informativo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Subtitulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LivrosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsuariosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RelatoriosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void LivrosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LivrosButtonActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaLivros());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_LivrosButtonActionPerformed

    private void UsuariosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosButtonActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaUsuarios());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_UsuariosButtonActionPerformed

    private void RelatoriosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriosButtonActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaRelatorios());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_RelatoriosButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Informativo;
    private javax.swing.JButton LivrosButton;
    private javax.swing.JButton RelatoriosButton;
    private javax.swing.JLabel Subtitulo;
    private javax.swing.JButton UsuariosButton;
    // End of variables declaration//GEN-END:variables
}