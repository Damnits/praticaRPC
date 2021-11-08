package com.gugawag.rpc.banco;

public class Conta {
    String numero;
    double saldo;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Conta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }
}
