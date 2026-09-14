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
        Renovar.setEnabled(temUsuarios);

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

        Topo = new javax.swing.JPanel();
        Voltar = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        PainelFormulario = new javax.swing.JPanel();
        UsuárioLabel = new javax.swing.JLabel();
        LivroLabel = new javax.swing.JLabel();
        DataEmprestimoLabel = new javax.swing.JLabel();
        DataPrevistaLabel = new javax.swing.JLabel();
        ComboBoxUsuário = new javax.swing.JComboBox<>();
        ComboBoxLivro = new javax.swing.JComboBox<>();
        TextFieldDataEmprestimo = new javax.swing.JTextField();
        TextFieldDataPrevista = new javax.swing.JTextField();
        DicaData = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        Emprestar = new javax.swing.JButton();
        Renovar = new javax.swing.JButton();
        Devolver = new javax.swing.JButton();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Informativo.setText("Empréstimo");

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

        UsuárioLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        UsuárioLabel.setText("Usuário:");

        LivroLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        LivroLabel.setText("Livro:");

        DataEmprestimoLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        DataEmprestimoLabel.setText("Data Empréstimo:");

        DataPrevistaLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        DataPrevistaLabel.setText("Devolução Prevista:");

        ComboBoxUsuário.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ComboBoxUsuário.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        ComboBoxLivro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        ComboBoxLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        TextFieldDataEmprestimo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TextFieldDataPrevista.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N

        DicaData.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        DicaData.setText("(formato dd/mm/aaaa)");

        javax.swing.GroupLayout PainelFormularioLayout = new javax.swing.GroupLayout(PainelFormulario);
        PainelFormulario.setLayout(PainelFormularioLayout);
        PainelFormularioLayout.setHorizontalGroup(
            PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(PainelFormularioLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(UsuárioLabel)
                    .addComponent(LivroLabel)
                    .addComponent(DataEmprestimoLabel)
                    .addComponent(DataPrevistaLabel))
                .addGap(18, 18, 18)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComboBoxUsuário, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextFieldDataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DicaData))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelFormularioLayout.setVerticalGroup(
            PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFormularioLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsuárioLabel)
                    .addComponent(ComboBoxUsuário, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LivroLabel)
                    .addComponent(ComboBoxLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataEmprestimoLabel)
                    .addComponent(TextFieldDataEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(PainelFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DataPrevistaLabel)
                    .addComponent(TextFieldDataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DicaData)
                .addGap(10, 10, 10))
        );

        Emprestar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Emprestar.setText("Emprestar");
        Emprestar.addActionListener(this::EmprestarActionPerformed);

        Renovar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Renovar.setText("Renovar");
        Renovar.addActionListener(this::RenovarActionPerformed);

        Devolver.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Devolver.setText("Devolver");
        Devolver.addActionListener(this::DevolverActionPerformed);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Emprestar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Renovar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Devolver, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Emprestar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Renovar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Devolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void RenovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RenovarActionPerformed
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
            this, "Selecione o livro para renovar:", "Renovação",
            JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (selecao == null) return;

        int idx = 0;
        for (int i = 0; i < opcoes.length; i++) {
            if (opcoes[i].equals(selecao)) { idx = i; break; }
        }
        Emprestimo emp = ativos.get(idx);

        String dataStr = JOptionPane.showInputDialog(
            this,
            "Nova data de devolução (dd/mm/aaaa):",
            emp.getDataPrevistaDevolucao().plusDays(7).format(FORMATO_DATA)
        );

        if (dataStr == null) return;

        LocalDate novaData;
        try {
            novaData = LocalDate.parse(dataStr.trim(), FORMATO_DATA);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/mm/aaaa.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (novaData.isBefore(emp.getDataPrevistaDevolucao())) {
            JOptionPane.showMessageDialog(this, "A nova data deve ser posterior à atual (" + emp.getDataPrevistaDevolucao().format(FORMATO_DATA) + ").", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        emp.setDataPrevistaDevolucao(novaData);

        JOptionPane.showMessageDialog(this,
            "Empréstimo renovado!\nNova devolução prevista: " + novaData.format(FORMATO_DATA),
            "Sucesso", JOptionPane.INFORMATION_MESSAGE);

        carregarDados();
    }//GEN-LAST:event_RenovarActionPerformed

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
            String atraso = e.isAtrasado() ? " [ATRASADO]" : "";
            opcoes[i] = e.getLivro().getNome() + " (prev.: " + e.getDataPrevistaDevolucao().format(FORMATO_DATA) + ")" + atraso;
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
            msg += "\nAtenção: devolução em atraso (prevista: " + emp.getDataPrevistaDevolucao().format(FORMATO_DATA) + ")";
        }

        JOptionPane.showMessageDialog(this, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        carregarDados();
    }//GEN-LAST:event_DevolverActionPerformed

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaUsuarios());
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
    private javax.swing.JLabel LivroLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelFormulario;
    private javax.swing.JButton Renovar;
    private javax.swing.JTextField TextFieldDataEmprestimo;
    private javax.swing.JTextField TextFieldDataPrevista;
    private javax.swing.JPanel Topo;
    private javax.swing.JLabel UsuárioLabel;
    private javax.swing.JButton Voltar;
    // End of variables declaration//GEN-END:variables
}