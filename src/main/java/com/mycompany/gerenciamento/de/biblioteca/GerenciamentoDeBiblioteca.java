/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciamento.de.biblioteca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author Ifal
 */
public class GerenciamentoDeBiblioteca extends JFrame {
    
    public GerenciamentoDeBiblioteca() {
        // Configurações da janela
        setTitle("Gerenciamento de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Tamanho maior, mas ainda podendo ser redimensionado
        setSize(900, 600);
        setMinimumSize(new Dimension(700, 500)); // não deixa encolher demais
        setLocationRelativeTo(null);
        
        // Layout que faz o painel ocupar toda a janela
        getContentPane().setLayout(new BorderLayout());
        
        // Adiciona dados padrão
        adicionarDadosPadrao();
        
        // Mostra a tela inicial
        mostrarTela(new TelaInicial());
    }
    
    private void adicionarDadosPadrao() {
        Usuario usuarioPadrao = new Usuario(
            "Sarah Aurora", 
            "15204408479", 
            "82994126136", 
            "bcsarah@proton.me"
        );
        TelaUsuarios.adicionarUsuario(usuarioPadrao);
        
        Livro livroPadrao = new Livro(
            "Revolução dos Bichos",
            "George Orwell",
            1945,
            123456789
        );
        TelaLivros.adicionarLivro(livroPadrao);
    }
    
    // Método para trocar telas (redimensiona o painel junto com a janela)
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