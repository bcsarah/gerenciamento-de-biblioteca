/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
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
    private TableRowSorter<DefaultTableModel> sorter;
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

        sorter = new TableRowSorter<>(modeloTabela);
        jTable1.setRowSorter(sorter);
        aplicarFiltro();
    }

    private void aplicarFiltro() {
        String texto = TextFieldBusca.getText().trim();
        if (texto.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(texto)));
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        atualizarTabela();
    }

    private void removerUsuarioSelecionado() {
        int linhaView = jTable1.getSelectedRow();
        if (linhaView == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para remover!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int linhaModelo = jTable1.convertRowIndexToModel(linhaView);
        String nomeUsuario = (String) jTable1.getModel().getValueAt(linhaModelo, 0);

        int confirmacao = JOptionPane.showConfirmDialog(this,
            "Tem certeza que deseja remover o usuário \"" + nomeUsuario + "\"?",
            "Confirmar Remoção", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            usuarios.remove(linhaModelo);
            atualizarTabela();
            JOptionPane.showMessageDialog(this, "Usuário removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void editarUsuarioSelecionado() {
        int linhaView = jTable1.getSelectedRow();
        if (linhaView == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para editar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int linhaModelo = jTable1.convertRowIndexToModel(linhaView);
        Usuario usuario = usuarios.get(linhaModelo);

        String novoNome = JOptionPane.showInputDialog(this, "Nome:", usuario.getNome());
        if (novoNome == null) return;

        String novoCpf = JOptionPane.showInputDialog(this, "CPF:", usuario.getCpf());
        if (novoCpf == null) return;

        String novoTelefone = JOptionPane.showInputDialog(this, "Telefone:", usuario.getTelefone());
        if (novoTelefone == null) return;

        String novoEmail = JOptionPane.showInputDialog(this, "Email:", usuario.getEmail());
        if (novoEmail == null) return;

        usuario.setNome(novoNome.trim());
        usuario.setCpf(novoCpf.trim());
        usuario.setTelefone(novoTelefone.trim());
        usuario.setEmail(novoEmail.trim());

        atualizarTabela();
        JOptionPane.showMessageDialog(this, "Usuário atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private void verHistoricoSelecionado() {
        int linhaView = jTable1.getSelectedRow();
        if (linhaView == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um usuário para ver o histórico!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int linhaModelo = jTable1.convertRowIndexToModel(linhaView);
        Usuario usuario = usuarios.get(linhaModelo);

        java.awt.Container parent = this.getParent();
        parent.remove(this);
        parent.add(new TelaHistorico(usuario));
        parent.revalidate();
        parent.repaint();
    }

    private void RemoverActionPerformed(java.awt.event.ActionEvent evt) {
        removerUsuarioSelecionado();
    }

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {
        editarUsuarioSelecionado();
    }

    private void HistoricoActionPerformed(java.awt.event.ActionEvent evt) {
        verHistoricoSelecionado();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            editarUsuarioSelecionado();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Topo = new javax.swing.JPanel();
        Voltar = new javax.swing.JButton();
        Informativo = new javax.swing.JLabel();
        PainelBusca = new javax.swing.JPanel();
        BuscaLabel = new javax.swing.JLabel();
        TextFieldBusca = new javax.swing.JTextField();
        PainelBotoes = new javax.swing.JPanel();
        Cadastrar = new javax.swing.JButton();
        Editar = new javax.swing.JButton();
        Remover = new javax.swing.JButton();
        Historico = new javax.swing.JButton();
        Empréstimo = new javax.swing.JButton();
        ListaLabel = new javax.swing.JLabel();
        TabelaUsuários = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        Informativo.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        Informativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        BuscaLabel.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        BuscaLabel.setText("Buscar:");

        TextFieldBusca.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        TextFieldBusca.setToolTipText("Digite para filtrar por nome, CPF, email ou telefone");
        TextFieldBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextFieldBuscaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout PainelBuscaLayout = new javax.swing.GroupLayout(PainelBusca);
        PainelBusca.setLayout(PainelBuscaLayout);
        PainelBuscaLayout.setHorizontalGroup(
            PainelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBuscaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(BuscaLabel)
                .addGap(10, 10, 10)
                .addComponent(TextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBuscaLayout.setVerticalGroup(
            PainelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BuscaLabel)
                .addComponent(TextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Cadastrar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Cadastrar.setText("Cadastrar");
        Cadastrar.addActionListener(this::CadastrarActionPerformed);

        Editar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Editar.setText("Editar");
        Editar.addActionListener(this::EditarActionPerformed);

        Remover.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Remover.setText("Remover");
        Remover.addActionListener(this::RemoverActionPerformed);

        Historico.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Historico.setText("Histórico");
        Historico.addActionListener(this::HistoricoActionPerformed);

        Empréstimo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        Empréstimo.setText("Empréstimo");
        Empréstimo.addActionListener(this::EmpréstimoActionPerformed);

        javax.swing.GroupLayout PainelBotoesLayout = new javax.swing.GroupLayout(PainelBotoes);
        PainelBotoes.setLayout(PainelBotoesLayout);
        PainelBotoesLayout.setHorizontalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Historico, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(Empréstimo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PainelBotoesLayout.setVerticalGroup(
            PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Remover, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Historico, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(Empréstimo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(PainelBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(PainelBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(PainelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(ListaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabelaUsuários, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );

        this.setPreferredSize(new java.awt.Dimension(800, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldBuscaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFieldBuscaKeyReleased
        aplicarFiltro();
    }//GEN-LAST:event_TextFieldBuscaKeyReleased

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
    private javax.swing.JLabel BuscaLabel;
    private javax.swing.JButton Cadastrar;
    private javax.swing.JButton Editar;
    private javax.swing.JButton Empréstimo;
    private javax.swing.JButton Historico;
    private javax.swing.JLabel Informativo;
    private javax.swing.JLabel ListaLabel;
    private javax.swing.JPanel PainelBotoes;
    private javax.swing.JPanel PainelBusca;
    private javax.swing.JButton Remover;
    private javax.swing.JScrollPane TabelaUsuários;
    private javax.swing.JTextField TextFieldBusca;
    private javax.swing.JPanel Topo;
    private javax.swing.JButton Voltar;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}