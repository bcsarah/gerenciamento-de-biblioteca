/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Ifal
 */
public class TelaRelatorios extends javax.swing.JPanel {

    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public TelaRelatorios() {
        initComponents();
        atualizarResumo();
        carregarTodosEmprestimos(); // já mostra todos ao abrir
    }

    private void atualizarResumo() {
        int totalLivros = TelaLivros.getLivros().size();
        int totalUsuarios = TelaUsuarios.getUsuarios().size();

        int disponiveis = 0, emprestados = 0;
        for (Livro l : TelaLivros.getLivros()) {
            if (l.isDisponivel()) disponiveis++;
            else emprestados++;
        }

        LabelTotalLivros.setText("Total de livros: " + totalLivros);
        LabelDisponiveis.setText("Disponíveis: " + disponiveis);
        LabelEmprestados.setText("Emprestados: " + emprestados);
        LabelTotalUsuarios.setText("Total de usuários: " + totalUsuarios);
    }

    // Preenche a tabela com TODOS os empréstimos ativos
    private void carregarTodosEmprestimos() {
        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Livro", "Usuário", "Data Empréstimo", "Devolução Prevista"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        List<Usuario> usuarios = TelaUsuarios.getUsuarios();
        for (Usuario u : usuarios) {
            for (Emprestimo e : u.getEmprestimosAtivos()) {
                modelo.addRow(new Object[]{
                    e.getLivro().getNome(),
                    u.getNome(),
                    e.getDataEmprestimo().format(FORMATO_DATA),
                    e.getDataPrevistaDevolucao().format(FORMATO_DATA)
                });
            }
        }

        jTable1.setModel(modelo);
    }

    private File escolherArquivo(String nomeSugerido) {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Salvar relatório");
        chooser.setSelectedFile(new File(nomeSugerido));
        int result = chooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    private void escreverArquivo(File arquivo, String conteudo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(arquivo))) {
            pw.print(conteudo);
            JOptionPane.showMessageDialog(this, "Relatório salvo com sucesso em:\n" + arquivo.getAbsolutePath(),
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo: " + ex.getMessage(),
                "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void exportarUsuarios() {
        File f = escolherArquivo("relatorio_usuarios.txt");
        if (f == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("       RELATÓRIO DE USUÁRIOS CADASTRADOS\n");
        sb.append("       Emitido em: ").append(LocalDate.now().format(FORMATO_DATA)).append("\n");
        sb.append("==================================================\n\n");

        List<Usuario> lista = TelaUsuarios.getUsuarios();
        sb.append("Total de usuários: ").append(lista.size()).append("\n\n");

        int i = 1;
        for (Usuario u : lista) {
            sb.append(i++).append(". ").append(u.getNome()).append("\n");
            sb.append("   CPF: ").append(u.getCpf()).append("\n");
            sb.append("   Telefone: ").append(u.getTelefone()).append("\n");
            sb.append("   Email: ").append(u.getEmail()).append("\n");
            sb.append("   Empréstimos ativos: ").append(u.getEmprestimos()).append("\n");
            if (!u.getEmprestimosAtivos().isEmpty()) {
                for (Emprestimo e : u.getEmprestimosAtivos()) {
                    sb.append("      - ").append(e.getLivro().getNome())
                      .append(" (devolver até ").append(e.getDataPrevistaDevolucao().format(FORMATO_DATA)).append(")\n");
                }
            }
            sb.append("\n");
        }

        escreverArquivo(f, sb.toString());
    }

    private void exportarLivros() {
        File f = escolherArquivo("relatorio_livros.txt");
        if (f == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("       RELATÓRIO DE LIVROS CADASTRADOS\n");
        sb.append("       Emitido em: ").append(LocalDate.now().format(FORMATO_DATA)).append("\n");
        sb.append("==================================================\n\n");

        List<Livro> lista = TelaLivros.getLivros();
        int disponiveis = 0, emprestados = 0;
        for (Livro l : lista) {
            if (l.isDisponivel()) disponiveis++;
            else emprestados++;
        }

        sb.append("Total de livros: ").append(lista.size()).append("\n");
        sb.append("Disponíveis: ").append(disponiveis).append("\n");
        sb.append("Emprestados: ").append(emprestados).append("\n\n");

        int i = 1;
        for (Livro l : lista) {
            sb.append(i++).append(". ").append(l.getNome()).append("\n");
            sb.append("   Autor: ").append(l.getAutor()).append("\n");
            sb.append("   Ano: ").append(l.getAno()).append("\n");
            sb.append("   ISBN: ").append(l.getIsbn()).append("\n");
            sb.append("   Status: ").append(l.isDisponivel() ? "Disponível" : "Emprestado").append("\n");
            if (l.getDataCadastro() != null) {
                sb.append("   Cadastrado em: ").append(l.getDataCadastro().format(FORMATO_DATA)).append("\n");
            }
            sb.append("\n");
        }

        escreverArquivo(f, sb.toString());
    }

    // Exporta empréstimos; se mes == -1, exporta TODOS
    private void exportarEmprestimos(int mes, int ano) {
        String nomeArquivo;
        String periodoTexto;

        if (mes == -1) {
            nomeArquivo = "relatorio_emprestimos_todos.txt";
            periodoTexto = "TODOS OS PERÍODOS";
        } else {
            nomeArquivo = String.format("relatorio_emprestimos_%02d_%d.txt", mes, ano);
            periodoTexto = String.format("%02d/%d", mes, ano);
        }

        File f = escolherArquivo(nomeArquivo);
        if (f == null) return;

        StringBuilder sb = new StringBuilder();
        sb.append("==================================================\n");
        sb.append("       RELATÓRIO DE EMPRÉSTIMOS\n");
        sb.append("       Período: ").append(periodoTexto).append("\n");
        sb.append("       Emitido em: ").append(LocalDate.now().format(FORMATO_DATA)).append("\n");
        sb.append("==================================================\n\n");

        int contador = 0;
        List<Usuario> usuarios = TelaUsuarios.getUsuarios();

        for (Usuario u : usuarios) {
            for (Emprestimo e : u.getEmprestimosAtivos()) {

                boolean incluir;
                if (mes == -1) {
                    incluir = true;
                } else {
                    incluir = (e.getDataPrevistaDevolucao().getMonthValue() == mes
                            && e.getDataPrevistaDevolucao().getYear() == ano);
                }

                if (incluir) {
                    contador++;
                    sb.append(contador).append(". Livro: ").append(e.getLivro().getNome()).append("\n");
                    sb.append("   Usuário: ").append(u.getNome()).append("\n");
                    sb.append("   Data do empréstimo: ").append(e.getDataEmprestimo().format(FORMATO_DATA)).append("\n");
                    sb.append("   Devolução prevista: ").append(e.getDataPrevistaDevolucao().format(FORMATO_DATA)).append("\n");
                    sb.append("   Status: ").append(e.isDevolvido() ? "Devolvido" : "Em aberto").append("\n\n");
                }
            }
        }

        sb.append("--------------------------------------------------\n");
        sb.append("Total de empréstimos: ").append(contador).append("\n");

        escreverArquivo(f, sb.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topo = new javax.swing.JPanel();
        Voltar = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        PainelResumo = new javax.swing.JPanel();
        LabelTotalLivros = new javax.swing.JLabel();
        LabelDisponiveis = new javax.swing.JLabel();
        LabelEmprestados = new javax.swing.JLabel();
        LabelTotalUsuarios = new javax.swing.JLabel();
        Separador1 = new javax.swing.JSeparator();
        TituloExportar = new javax.swing.JLabel();
        PainelBotoes = new javax.swing.JPanel();
        BtnRelUsuarios = new javax.swing.JButton();
        BtnRelLivros = new javax.swing.JButton();
        Separador2 = new javax.swing.JSeparator();
        TituloEmprestimos = new javax.swing.JLabel();
        PainelFiltro = new javax.swing.JPanel();
        MesLabel = new javax.swing.JLabel();
        TextFieldMes = new javax.swing.JTextField();
        AnoLabel = new javax.swing.JLabel();
        TextFieldAno = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        BtnExportarEmp = new javax.swing.JButton();
        BtnMostrarTodos = new javax.swing.JButton();
        Instrucao = new javax.swing.JLabel();
        Aviso = new javax.swing.JLabel();
        TabelaScroll = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Informativo.setText("Relatórios");

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

        LabelTotalLivros.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalLivros.setText("Total de livros: 0");

        LabelDisponiveis.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LabelDisponiveis.setText("Disponíveis: 0");

        LabelEmprestados.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        LabelEmprestados.setText("Emprestados: 0");

        LabelTotalUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelTotalUsuarios.setText("Total de usuários: 0");

        javax.swing.GroupLayout PainelResumoLayout = new javax.swing.GroupLayout(PainelResumo);
        PainelResumo.setLayout(PainelResumoLayout);
        PainelResumoLayout.setHorizontalGroup(
            PainelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelResumoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelTotalLivros)
                .addGap(30, 30, 30)
                .addComponent(LabelDisponiveis)
                .addGap(30, 30, 30)
                .addComponent(LabelEmprestados)
                .addGap(30, 30, 30)
                .addComponent(LabelTotalUsuarios)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelResumoLayout.setVerticalGroup(
            PainelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelResumoLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PainelResumoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelTotalLivros)
                    .addComponent(LabelDisponiveis)
                    .addComponent(LabelEmprestados)
                    .addComponent(LabelTotalUsuarios))
                .addGap(5, 5, 5))
        );

        TituloExportar.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        TituloExportar.setText("Exportar relatórios em arquivo .txt");

        BtnRelUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BtnRelUsuarios.setText("Relatório de Usuários");
        BtnRelUsuarios.addActionListener(this::BtnRelUsuariosActionPerformed);

        BtnRelLivros.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BtnRelLivros.setText("Relatório de Livros");
        BtnRelLivros.addActionListener(this::BtnRelLivrosActionPerformed);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BtnRelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(BtnRelLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BtnRelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BtnRelLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TituloEmprestimos.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        TituloEmprestimos.setText("Empréstimos por período (devolução prevista)");

        MesLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        MesLabel.setText("Mês:");

        AnoLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        AnoLabel.setText("Ano:");

        TextFieldMes.setToolTipText("Ex: 9");

        TextFieldAno.setToolTipText("Ex: 2026");

        BtnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(this::BtnBuscarActionPerformed);

        BtnExportarEmp.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BtnExportarEmp.setText("Exportar período");
        BtnExportarEmp.addActionListener(this::BtnExportarEmpActionPerformed);

        BtnMostrarTodos.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BtnMostrarTodos.setText("Mostrar todos");
        BtnMostrarTodos.addActionListener(this::BtnMostrarTodosActionPerformed);

        Instrucao.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        Instrucao.setText("(mês de 1 a 12, ano com 4 dígitos)");

        Aviso.setFont(new java.awt.Font("Segoe UI", 2, 10)); // NOI18N
        Aviso.setForeground(new java.awt.Color(120, 120, 120));
        Aviso.setText("Deixe o mês/ano em branco e clique em Exportar para gerar o relatório de TODOS os empréstimos.");

        javax.swing.GroupLayout PainelFiltroLayout = new javax.swing.GroupLayout(PainelFiltro);
        PainelFiltro.setLayout(PainelFiltroLayout);
        PainelFiltroLayout.setHorizontalGroup(
            PainelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFiltroLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PainelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelFiltroLayout.createSequentialGroup()
                        .addComponent(MesLabel)
                        .addGap(5, 5, 5)
                        .addComponent(TextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(AnoLabel)
                        .addGap(5, 5, 5)
                        .addComponent(TextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BtnExportarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(BtnMostrarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(Instrucao))
                    .addComponent(Aviso))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelFiltroLayout.setVerticalGroup(
            PainelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelFiltroLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PainelFiltroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MesLabel)
                    .addComponent(TextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnoLabel)
                    .addComponent(TextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnExportarEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnMostrarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Instrucao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Aviso)
                .addGap(5, 5, 5))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Livro", "Usuário", "Data Empréstimo", "Devolução Prevista"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
                    .addComponent(PainelResumo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Separador1)
                    .addComponent(TituloExportar)
                    .addComponent(PainelBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Separador2)
                    .addComponent(TituloEmprestimos)
                    .addComponent(PainelFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Topo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(PainelResumo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Separador1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(TituloExportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Separador2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(TituloEmprestimos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VoltarActionPerformed
        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaInicial());
        parent.revalidate();
        parent.repaint();
    }//GEN-LAST:event_VoltarActionPerformed

    private void BtnRelUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRelUsuariosActionPerformed
        exportarUsuarios();
    }//GEN-LAST:event_BtnRelUsuariosActionPerformed

    private void BtnRelLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRelLivrosActionPerformed
        exportarLivros();
    }//GEN-LAST:event_BtnRelLivrosActionPerformed

    private void BtnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMostrarTodosActionPerformed
        TextFieldMes.setText("");
        TextFieldAno.setText("");
        carregarTodosEmprestimos();
    }//GEN-LAST:event_BtnMostrarTodosActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        String mesStr = TextFieldMes.getText().trim();
        String anoStr = TextFieldAno.getText().trim();

        // Se ambos vazios, mostra todos
        if (mesStr.isEmpty() && anoStr.isEmpty()) {
            carregarTodosEmprestimos();
            return;
        }

        if (mesStr.isEmpty() || anoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o mês E o ano, ou deixe ambos em branco para mostrar todos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int mes, ano;
        try {
            mes = Integer.parseInt(mesStr);
            ano = Integer.parseInt(anoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mês e ano devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (mes < 1 || mes > 12) {
            JOptionPane.showMessageDialog(this, "Mês deve estar entre 1 e 12!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DefaultTableModel modelo = new DefaultTableModel(
            new Object[][]{},
            new String[]{"Livro", "Usuário", "Data Empréstimo", "Devolução Prevista"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        int contador = 0;
        for (Usuario u : TelaUsuarios.getUsuarios()) {
            for (Emprestimo e : u.getEmprestimosAtivos()) {
                if (e.getDataPrevistaDevolucao().getMonthValue() == mes
                        && e.getDataPrevistaDevolucao().getYear() == ano) {
                    modelo.addRow(new Object[]{
                        e.getLivro().getNome(),
                        u.getNome(),
                        e.getDataEmprestimo().format(FORMATO_DATA),
                        e.getDataPrevistaDevolucao().format(FORMATO_DATA)
                    });
                    contador++;
                }
            }
        }

        jTable1.setModel(modelo);

        if (contador == 0) {
            JOptionPane.showMessageDialog(this,
                "Nenhuma devolução prevista para " + String.format("%02d/%d", mes, ano) + ".",
                "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnExportarEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExportarEmpActionPerformed
        String mesStr = TextFieldMes.getText().trim();
        String anoStr = TextFieldAno.getText().trim();

        // Se ambos vazios → exportar TODOS
        if (mesStr.isEmpty() && anoStr.isEmpty()) {
            exportarEmprestimos(-1, -1);
            return;
        }

        if (mesStr.isEmpty() || anoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha o mês E o ano, ou deixe ambos em branco para exportar todos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int mes, ano;
        try {
            mes = Integer.parseInt(mesStr);
            ano = Integer.parseInt(anoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Mês e ano devem ser números!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (mes < 1 || mes > 12) {
            JOptionPane.showMessageDialog(this, "Mês deve estar entre 1 e 12!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        exportarEmprestimos(mes, ano);
    }//GEN-LAST:event_BtnExportarEmpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnoLabel;
    private javax.swing.JLabel Aviso;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnExportarEmp;
    private javax.swing.JButton BtnMostrarTodos;
    private javax.swing.JButton BtnRelLivros;
    private javax.swing.JButton BtnRelUsuarios;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel Instrucao;
    private javax.swing.JLabel LabelDisponiveis;
    private javax.swing.JLabel LabelEmprestados;
    private javax.swing.JLabel LabelTotalLivros;
    private javax.swing.JLabel LabelTotalUsuarios;
    private javax.swing.JLabel MesLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelFiltro;
    private javax.swing.JPanel PainelResumo;
    private javax.swing.JSeparator Separador1;
    private javax.swing.JSeparator Separador2;
    private javax.swing.JScrollPane TabelaScroll;
    private javax.swing.JTextField TextFieldAno;
    private javax.swing.JTextField TextFieldMes;
    private javax.swing.JLabel TituloEmprestimos;
    private javax.swing.JLabel TituloExportar;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton Voltar;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}