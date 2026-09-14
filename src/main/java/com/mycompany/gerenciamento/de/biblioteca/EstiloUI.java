package com.mycompany.gerenciamento.de.biblioteca;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * Classe utilitária para padronizar o estilo visual das telas.
 *
 * @author Ifal
 */
public class EstiloUI {

    public static final Font FONTE_TITULO = new Font("Segoe UI", Font.BOLD, 22);
    public static final Font FONTE_SUBTITULO = new Font("Segoe UI", Font.BOLD, 14);
    public static final Font FONTE_NORMAL = new Font("Segoe UI", Font.PLAIN, 13);
    public static final Font FONTE_BOTAO = new Font("Segoe UI", Font.PLAIN, 13);

    public static void aplicarTitulo(JLabel label) {
        label.setFont(FONTE_TITULO);
    }

    public static void aplicarSubtitulo(JLabel label) {
        label.setFont(FONTE_SUBTITULO);
    }

    public static void aplicarNormal(JLabel label) {
        label.setFont(FONTE_NORMAL);
    }

    public static void aplicarBotaoGrande(JButton botao) {
        botao.setFont(FONTE_BOTAO);
        botao.setPreferredSize(new java.awt.Dimension(140, 40));
    }

    public static void aplicarBotaoMedio(JButton botao) {
        botao.setFont(FONTE_BOTAO);
        botao.setPreferredSize(new java.awt.Dimension(120, 36));
    }
}