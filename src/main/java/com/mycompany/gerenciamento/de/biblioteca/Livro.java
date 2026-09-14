package com.mycompany.gerenciamento.de.biblioteca;

import java.time.LocalDate;

/**
 *
 * @author Ifal
 */
public class Livro {
    private String nome;
    private String autor;
    private int ano;
    private int isbn;
    private boolean disponivel;
    private LocalDate dataCadastro;

    public Livro(String nome, String autor, int ano, int isbn) {
        this.nome = nome;
        this.autor = autor;
        this.ano = ano;
        this.isbn = isbn;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public int getIsbn() { return isbn; }
    public void setIsbn(int isbn) { this.isbn = isbn; }

    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }
}