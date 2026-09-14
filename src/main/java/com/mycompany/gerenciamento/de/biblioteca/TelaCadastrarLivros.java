/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Ifal
 */
public class TelaCadastrarLivros extends javax.swing.JPanel {

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaCadastrarLivros() {
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
        AutorLabel = new javax.swing.JLabel();
        AnoLabel = new javax.swing.JLabel();
        ISBNLabel = new javax.swing.JLabel();
        DataLabel = new javax.swing.JLabel();
        TextFieldNome = new javax.swing.JTextField();
        TextFieldAutor = new javax.swing.JTextField();
        TextFieldAno = new javax.swing.JTextField();
        TextFieldISBN = new javax.swing.JTextField();
        TextFieldData = new javax.swing.JTextField();
        DicaData = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        Adicionar = new javax.swing.JButton();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Informativo.setText("Cadastro de Livros");

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

        AutorLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AutorLabel.setText("Autor:");

        AnoLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AnoLabel.setText("Ano:");

        ISBNLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ISBNLabel.setText("ISBN:");

        DataLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        DataLabel.setText("Data Cadastro:");

        TextFieldNome.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        TextFieldAutor.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        TextFieldAno.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        TextFieldISBN.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        TextFieldData.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TextFieldData.setToolTipText("Formato: dd/mm/aaaa");

        DicaData.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        DicaData.setText("(dd/mm/aaaa - vazio = hoje)");

        javax.swing.GroupLayout PainelFormularioLayout = new javax.swing.GroupLayout(PainelFormulario);
        PainelFormulario.setLayout(PainelFormularioLayout);
        PainelFormularioLayout.setHorizontalGroup(
            PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(PainelFormularioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(NomeLabel)
                    .addComponent(AutorLabel)
                    .addComponent(AnoLabel)
                    .addComponent(ISBNLabel)
                    .addComponent(DataLabel))
                .addGap(18, 18, 18)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DicaData))
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
                    .addComponent(AutorLabel)
                    .addComponent(TextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnoLabel)
                    .addComponent(TextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ISBNLabel)
                    .addComponent(TextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataLabel)
                    .addComponent(TextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DicaData)
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
            String autor = TextFieldAutor.getText().trim();
            String anoStr = TextFieldAno.getText().trim();
            String isbnStr = TextFieldISBN.getText().trim();
            String dataStr = TextFieldData.getText().trim();

            if (nome.isEmpty() || autor.isEmpty() || anoStr.isEmpty() || isbnStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int ano = Integer.parseInt(anoStr);
            int isbn = Integer.parseInt(isbnStr);

            LocalDate dataCadastro;
            if (dataStr.isEmpty()) {
                dataCadastro = LocalDate.now();
            } else {
                try {
                    dataCadastro = LocalDate.parse(dataStr, FORMATO_DATA);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            Livro novoLivro = new Livro(nome, autor, ano, isbn);
            novoLivro.setDataCadastro(dataCadastro);

            TelaLivros.adicionarLivro(novoLivro);

            TextFieldNome.setText("");
            TextFieldAutor.setText("");
            TextFieldAno.setText("");
            TextFieldISBN.setText("");
            TextFieldData.setText("");

            JOptionPane.showMessageDialog(this, "Livro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ano e ISBN devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AdicionarActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaLivros());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JLabel AnoLabel;
    private javax.swing.JLabel AutorLabel;
    private javax.swing.JLabel DataLabel;
    private javax.swing.JLabel DicaData;
    private javax.swing.JLabel ISBNLabel;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelFormulario;
    private javax.swing.JTextField TextFieldAno;
    private javax.swing.JTextField TextFieldAutor;
    private javax.swing.JTextField TextFieldData;
    private javax.swing.JTextField TextFieldISBN;
    private javax.swing.JTextField TextFieldNome;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton Voltar;
    // End of variables declaration//GEN-END:variables
}