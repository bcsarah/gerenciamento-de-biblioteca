package com.mycompany.gerenciamento.de.biblioteca;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ifal
 */
public class Usuario {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private List<Emprestimo> emprestimos;

    public Usuario(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Emprestimo> getEmprestimosLista() { return emprestimos; }

    // Retorna apenas os empréstimos ativos (não devolvidos)
    public List<Emprestimo> getEmprestimosAtivos() {
        List<Emprestimo> ativos = new ArrayList<>();
        for (Emprestimo e : emprestimos) {
            if (!e.isDevolvido()) ativos.add(e);
        }
        return ativos;
    }

    // Conta empréstimos ativos
    public int getEmprestimos() {
        return getEmprestimosAtivos().size();
    }

    public void adicionarEmprestimo(Emprestimo e) {
        emprestimos.add(e);
    }

    public void removerEmprestimo(Emprestimo e) {
        emprestimos.remove(e);
    }
}