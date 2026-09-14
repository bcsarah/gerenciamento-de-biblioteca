/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.JOptionPane;

/**
 *
 * @author Ifal
 */
public class TelaCadastrarUsuarios extends javax.swing.JPanel {

    public TelaCadastrarUsuarios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topo = new javax.swing.JPanel();
        Voltar = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        PainelFormulario = new javax.swing.JPanel();
        NomeLabel = new javax.swing.JLabel();
        CPFLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        TelefoneLabel = new javax.swing.JLabel();
        TextFieldNome = new javax.swing.JTextField();
        TextFieldCPF = new javax.swing.JTextField();
        TextFieldEmail = new javax.swing.JTextField();
        TextFieldTelefone = new javax.swing.JTextField();
        DicaCPF = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        Adicionar = new javax.swing.JButton();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Informativo.setText("Cadastro de Usuários");

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

        NomeLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        NomeLabel.setText("Nome:");

        CPFLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        CPFLabel.setText("CPF:");

        EmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        EmailLabel.setText("Email:");

        TelefoneLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TelefoneLabel.setText("Telefone:");

        TextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        TextFieldCPF.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TextFieldCPF.setToolTipText("Apenas números");

        TextFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        TextFieldTelefone.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        DicaCPF.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        DicaCPF.setText("(somente números)");

        javax.swing.GroupLayout PainelFormularioLayout = new javax.swing.GroupLayout(PainelFormulario);
        PainelFormulario.setLayout(PainelFormularioLayout);
        PainelFormularioLayout.setHorizontalGroup(
            PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(PainelFormularioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NomeLabel)
                    .addComponent(CPFLabel)
                    .addComponent(EmailLabel)
                    .addComponent(TelefoneLabel))
                .addGap(18, 18, 18)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DicaCPF))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelFormularioLayout.setVerticalGroup(
            PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFormularioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeLabel)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CPFLabel)
                    .addComponent(TextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DicaCPF)
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmailLabel)
                    .addComponent(TextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TelefoneLabel)
                    .addComponent(TextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        Adicionar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.addActionListener(this::AdicionarActionPerformed);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Topo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PainelFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        try {
            String nome = TextFieldNome.getText().trim();
            String cpf = TextFieldCPF.getText().trim();
            String telefone = TextFieldTelefone.getText().trim();
            String email = TextFieldEmail.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!cpf.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "CPF deve conter apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Usuario novoUsuario = new Usuario(nome, cpf, telefone, email);
            TelaUsuarios.adicionarUsuario(novoUsuario);

            TextFieldNome.setText("");
            TextFieldCPF.setText("");
            TextFieldTelefone.setText("");
            TextFieldEmail.setText("");

            JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AdicionarActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaUsuarios());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JLabel CPFLabel;
    private javax.swing.JLabel DicaCPF;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelFormulario;
    private javax.swing.JLabel TelefoneLabel;
    private javax.swing.JTextField TextFieldCPF;
    private javax.swing.JTextField TextFieldEmail;
    private javax.swing.JTextField TextFieldNome;
    private javax.swing.JTextField TextFieldTelefone;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton Voltar;
    // End of variables declaration//GEN-END:variables
}