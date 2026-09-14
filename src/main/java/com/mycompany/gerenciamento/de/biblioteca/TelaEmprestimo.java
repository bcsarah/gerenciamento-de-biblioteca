/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 *
 * @author Ifal
 */
public class TelaEmprestimo extends javax.swing.JPanel {

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Creates new form TelaEmpréstimo
     */
    public TelaEmprestimo() {
        initComponents();
        carregarDados();
    }

    private void carregarDados() {
        ComboBoxUsuário.removeAllItems();
        ComboBoxLivro.removeAllItems();

        List<Usuario> usuarios = TelaUsuarios.getUsuarios();
        for (Usuario u : usuarios) {
            ComboBoxUsuário.addItem(u.getNome() + " (CPF: " + u.getCpf() + ")");
        }

        List<Livro> livros = TelaLivros.getLivros();
        for (Livro l : livros) {
            if (l.isDisponivel()) {
                ComboBoxLivro.addItem(l.getNome() + " - " + l.getAutor());
            }
        }

        boolean temUsuarios = ComboBoxUsuário.getItemCount() > 0;
        boolean temLivros = ComboBoxLivro.getItemCount() > 0;
        Emprestar.setEnabled(temUsuarios && temLivros);
        Devolver.setEnabled(temUsuarios);

        // Preenche as datas padrão
        TextFieldDataEmprestimo.setText(LocalDate.now().format(FORMATO_DATA));
        TextFieldDataPrevista.setText(LocalDate.now().plusDays(7).format(FORMATO_DATA));
    }

    private Usuario getUsuarioSelecionado() {
        int index = ComboBoxUsuário.getSelectedIndex();
        if (index >= 0 && index < TelaUsuarios.getUsuarios().size()) {
            return TelaUsuarios.getUsuarios().get(index);
        }
        return null;
    }

    private Livro getLivroSelecionado() {
        int index = ComboBoxLivro.getSelectedIndex();
        if (index >= 0) {
            List<Livro> livros = TelaLivros.getLivros();
            int contador = 0;
            for (Livro l : livros) {
                if (l.isDisponivel()) {
                    if (contador == index) return l;
                    contador++;
                }
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Informativo = new javax.swing.JLabel();
        Emprestar = new javax.swing.JButton();
        Devolver = new javax.swing.JButton();
        Voltar = new javax.swing.JButton();
        Usuário = new javax.swing.JLabel();
        Livro = new javax.swing.JLabel();
        ComboBoxUsuário = new javax.swing.JComboBox<>();
        ComboBoxLivro = new javax.swing.JComboBox<>();
        DataEmprestimoLabel = new javax.swing.JLabel();
        TextFieldDataEmprestimo = new javax.swing.JTextField();
        DataPrevistaLabel = new javax.swing.JLabel();
        TextFieldDataPrevista = new javax.swing.JTextField();
        DicaData = new javax.swing.JLabel();

        Informativo.setText("Empréstimo");

        Emprestar.setText("Emprestar");
        Emprestar.addActionListener(this::EmprestarActionPerformed);

        Devolver.setText("Devolver");
        Devolver.addActionListener(this::DevolverActionPerformed);

        Voltar.setText("Voltar");
        Voltar.addActionListener(this::VoltarActionPerformed);

        Usuário.setText("Usuário:");

        Livro.setText("Livro:");

        ComboBoxUsuário.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        ComboBoxLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        DataEmprestimoLabel.setText("Data Empréstimo:");

        DataPrevistaLabel.setText("Devolução Prevista:");

        DicaData.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        DicaData.setText("(formato dd/mm/aaaa)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Voltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Emprestar)
                                .addGap(70, 70, 70)
                                .addComponent(Devolver))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Usuário)
                                    .addComponent(Livro)
                                    .addComponent(DataEmprestimoLabel)
                                    .addComponent(DataPrevistaLabel))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboBoxUsuário, 0, 170, Short.MAX_VALUE)
                                    .addComponent(ComboBoxLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TextFieldDataEmprestimo)
                                    .addComponent(TextFieldDataPrevista)
                                    .addComponent(DicaData)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(Informativo)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Informativo)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Usuário)
                    .addComponent(ComboBoxUsuário, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Livro)
                    .addComponent(ComboBoxLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataEmprestimoLabel)
                    .addComponent(TextFieldDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataPrevistaLabel)
                    .addComponent(TextFieldDataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(DicaData)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Emprestar)
                    .addComponent(Devolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(Voltar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmprestarActionPerformed
        Usuario usuario = getUsuarioSelecionado();
        Livro livro = getLivroSelecionado();

        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (livro == null) {
            JOptionPane.showMessageDialog(this, "Selecione um livro disponível!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (usuario.getEmprestimos() >= 3) {
            JOptionPane.showMessageDialog(this, "O usuário já atingiu o limite de 3 livros emprestados!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDate dataEmp, dataPrev;
        try {
            dataEmp = LocalDate.parse(TextFieldDataEmprestimo.getText().trim(), FORMATO_DATA);
            dataPrev = LocalDate.parse(TextFieldDataPrevista.getText().trim(), FORMATO_DATA);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Datas inválidas! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (dataPrev.isBefore(dataEmp)) {
            JOptionPane.showMessageDialog(this, "A data de devolução prevista não pode ser antes da data de empréstimo!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Emprestimo emp = new Emprestimo(livro, usuario, dataEmp, dataPrev);
        usuario.adicionarEmprestimo(emp);
        livro.setDisponivel(false);

        JOptionPane.showMessageDialog(this,
            "Livro \"" + livro.getNome() + "\" emprestado para " + usuario.getNome() + "!\n" +
            "Empréstimo: " + dataEmp.format(FORMATO_DATA) + "\n" +
            "Devolução prevista: " + dataPrev.format(FORMATO_DATA),
            "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        carregarDados();
    }//GEN-LAST:event_EmprestarActionPerformed

    private void DevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DevolverActionPerformed
        Usuario usuario = getUsuarioSelecionado();

        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Emprestimo> ativos = usuario.getEmprestimosAtivos();
        if (ativos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Este usuário não possui livros emprestados!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String[] opcoes = new String[ativos.size()];
        for (int i = 0; i < ativos.size(); i++) {
            Emprestimo e = ativos.get(i);
            opcoes[i] = e.getLivro().getNome() + " (prev.: " + e.getDataPrevistaDevolucao().format(FORMATO_DATA) + ")";
        }

        String selecao = (String) JOptionPane.showInputDialog(
            this, "Selecione o livro para devolver:", "Devolução",
            JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (selecao == null) return;

        int idx = 0;
        for (int i = 0; i < opcoes.length; i++) {
            if (opcoes[i].equals(selecao)) { idx = i; break; }
        }
        Emprestimo emp = ativos.get(idx);

        String dataDevStr = JOptionPane.showInputDialog(
            this,
            "Data da devolução (dd/mm/aaaa):",
            LocalDate.now().format(FORMATO_DATA)
        );

        if (dataDevStr == null) return;

        LocalDate dataDev;
        try {
            dataDev = LocalDate.parse(dataDevStr.trim(), FORMATO_DATA);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        emp.setDataDevolucao(dataDev);
        emp.getLivro().setDisponivel(true);

        String msg = "Livro \"" + emp.getLivro().getNome() + "\" devolvido em " + dataDev.format(FORMATO_DATA) + "!";
        if (dataDev.isAfter(emp.getDataPrevistaDevolucao())) {
            msg += "\nAtencao: devolucao em atraso (prevista: " + emp.getDataPrevistaDevolucao().format(FORMATO_DATA) + ")";
        }

        JOptionPane.showMessageDialog(this, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        carregarDados();
    }//GEN-LAST:event_DevolverActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        TelaUsuarios telaUsuarios = new TelaUsuarios();
        parent.add(telaUsuarios);
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxLivro;
    private javax.swing.JComboBox<String> ComboBoxUsuário;
    private javax.swing.JLabel DataEmprestimoLabel;
    private javax.swing.JLabel DataPrevistaLabel;
    private javax.swing.JButton Devolver;
    private javax.swing.JLabel DicaData;
    private javax.swing.JButton Emprestar;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel Livro;
    private javax.swing.JTextField TextFieldDataEmprestimo;
    private javax.swing.JTextField TextFieldDataPrevista;
    private javax.swing.JLabel Usuário;
    private javax.swing.JButton Voltar;
    // End of variables declaration//GEN-END:variables
}