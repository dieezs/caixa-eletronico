package br.com.bank.online.cliente;

import br.com.bank.online.Utilitarios;
import br.com.bank.online.cliente.cartao.Credito;
import br.com.bank.online.cliente.cartao.Debito;
import br.com.bank.online.cliente.conta.Conta;
import br.com.bank.online.cliente.conta.Corrente;
import br.com.bank.online.cliente.conta.Poupanca;
import jdk.jshell.execution.Util;

import java.util.Scanner;

public class Cliente {

    private String nome;
    private String cpf;
    private String rg;
    private String login;
    private String senha;
    private Debito cartaoDebito;
    private Credito cartaoCredito;
    private Corrente contaCorrente = new Corrente();
    private Poupanca contaPoupanca = new Poupanca();

    public Cliente(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Cliente(){

    }

    @Override
    public String toString() {
        return "cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public boolean validaCliente(String senha){
        if(senha.equals(this.senha)){
            return true;
        }else{
            return false;
        }
    }

    public void menuCliente(){
        Utilitarios.limpaTela();
        System.out.println("MENU DO CLIENTE "+this.nome+" NO BANK ONLINE!");
        Scanner leia = new Scanner(System.in);
        boolean rep = true;

        do{
            System.out.println(" 1 - Extrato Bancário");
            System.out.println(" 2 - Saldo");
            System.out.println(" 3 - Saque");
            System.out.println(" 4 - Transferência");
            System.out.println(" 5 - Sair");
            int opcao = leia.nextInt();

            switch (opcao){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("ATENÇÂO: LIMITE DE 5 SAQUES REALIZADOS POR DIA PARA CADA TIPO DE CONTA!");
                    System.out.println("Escolha qual conta ira ser debitado o SAQUE");
                    System.out.println(" 1 - CONTA CORRENTE");
                    System.out.println(" 2 - CONTA POUPANÇA");
                    opcao = leia.nextInt();

                    switch (opcao) {
                        case 1:
                            if(getContaCorrente().getNumSaquesEfetuados() >= Conta.getLimiteDeSaques()){
                                System.out.println("LIMITE DE "+ 5 + " SAQUES DIARIOS REALIZADOS");
                                System.out.println("VOLTE UM OUTRO DIA");
                            }else{
                                getContaCorrente().saqueConta();
                            }
                            break;
                        case 2:
                            if(getContaPoupanca().getNumSaquesEfetuados() >= Conta.getLimiteDeSaques()){
                                System.out.println("LIMITE DE "+ 5 + " SAQUES DIARIOS REALIZADOS");
                                System.out.println("VOLTE UM OUTRO DIA");
                            }else{
                                getContaPoupanca().saqueConta();
                            }
                            break;
                    }
                    break;
                case 4:
                    break;
                case 5:
                    rep = false;
                    break;
            }

        }while(rep == true);

    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Debito getCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(Debito cartaoDebito) {
        this.cartaoDebito = cartaoDebito;
    }

    public Credito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(Credito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Corrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(Corrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public Poupanca getContaPoupanca() {
        return contaPoupanca;
    }

    public void setContaPoupanca(Poupanca contaPoupanca) {
        this.contaPoupanca = contaPoupanca;
    }
}
