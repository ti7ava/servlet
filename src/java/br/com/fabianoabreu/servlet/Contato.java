/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet;

import java.util.Calendar;

/**
 *
 * @author Renato
 */
public class Contato {
   
  private Long id;
  private String nome;
  private String email;
  private String endereco;
  private Calendar dataNascimento;
  private String login;
  private String Senha;

  // métodos get e set para id, nome, email, endereço e dataNascimento

  public String getNome() {
    return this.nome;
  }
  public void setNome(String novo) {
    this.nome = novo;
  }

  public String getEmail() {
    return this.email;
  }
  public void setEmail(String novo) {
    this.email = novo;
  }

  public String getEndereco() {
    return this.endereco;
  }
  public void setEndereco(String novo) {
    this.endereco = novo;
  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long novo) {
    this.id = novo;
  }

  public Calendar getDataNascimento() {
    return this.dataNascimento;
  }
  public void setDataNascimento(Calendar dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the Senha
     */
    public String getSenha() {
        return Senha;
    }

    /**
     * @param Senha the Senha to set
     */
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
}
