/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.time.LocalDate;

/**
 *
 * @author Ifal
 */
public class GerenciamentoDeBiblioteca extends JFrame {

    public GerenciamentoDeBiblioteca() {
        setTitle("Gerenciamento de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(950, 620);
        setMinimumSize(new Dimension(750, 520));
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        adicionarDadosPadrao();

        mostrarTela(new TelaInicial());
    }

    private void adicionarDadosPadrao() {
        // ----------------------------------------------------
        // USUÁRIOS
        // ----------------------------------------------------
        Usuario u1 = new Usuario("Ana Beatriz Souza", "12345678901", "11987654321", "ana.souza@email.com");
        Usuario u2 = new Usuario("Carlos Eduardo Lima", "23456789012", "21998765432", "carlos.lima@email.com");
        Usuario u3 = new Usuario("Mariana Ferreira Alves", "34567890123", "31987651234", "mariana.alves@email.com");
        Usuario u4 = new Usuario("Rafael Monteiro Costa", "45678901234", "41996543210", "rafael.costa@email.com");
        Usuario u5 = new Usuario("Juliana Pereira Rocha", "56789012345", "51991234567", "juliana.rocha@email.com");

        TelaUsuarios.adicionarUsuario(u1);
        TelaUsuarios.adicionarUsuario(u2);
        TelaUsuarios.adicionarUsuario(u3);
        TelaUsuarios.adicionarUsuario(u4);
        TelaUsuarios.adicionarUsuario(u5);

        // ----------------------------------------------------
        // LIVROS
        // ----------------------------------------------------
        Livro l1 = new Livro("Dom Casmurro", "Machado de Assis", 1899, 9788535910663L > 0 ? 853591066 : 0);
        Livro l2 = new Livro("1984", "George Orwell", 1949, 9780451524935L > 0 ? 452152493 : 0);
        Livro l3 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 1954, 9780618640157L > 0 ? 618640157 : 0);
        Livro l4 = new Livro("Cem Anos de Solidão", "Gabriel García Márquez", 1967, 9788535907176L > 0 ? 853590717 : 0);
        Livro l5 = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997, 9788532511010L > 0 ? 853251101 : 0);

        TelaLivros.adicionarLivro(l1);
        TelaLivros.adicionarLivro(l2);
        TelaLivros.adicionarLivro(l3);
        TelaLivros.adicionarLivro(l4);
        TelaLivros.adicionarLivro(l5);

        // ----------------------------------------------------
        // EMPRÉSTIMOS (dois usuários com empréstimos)
        // Ana Beatriz → 2 livros (Dom Casmurro e 1984)
        // Carlos Eduardo → 1 livro (O Senhor dos Anéis)
        // ----------------------------------------------------
        LocalDate hoje = LocalDate.now();

        // Ana Beatriz — 2 empréstimos
        Emprestimo emp1 = new Emprestimo(l1, u1, hoje.minusDays(3), hoje.plusDays(4));
        u1.adicionarEmprestimo(emp1);
        l1.setDisponivel(false);

        Emprestimo emp2 = new Emprestimo(l2, u1, hoje.minusDays(1), hoje.plusDays(6));
        u1.adicionarEmprestimo(emp2);
        l2.setDisponivel(false);

        // Carlos Eduardo — 1 empréstimo
        Emprestimo emp3 = new Emprestimo(l3, u2, hoje.minusDays(5), hoje.plusDays(2));
        u2.adicionarEmprestimo(emp3);
        l3.setDisponivel(false);
    }

    public void mostrarTela(JPanel tela) {
        getContentPane().removeAll();
        getContentPane().add(tela, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new GerenciamentoDeBiblioteca().setVisible(true);
        });
    }
}