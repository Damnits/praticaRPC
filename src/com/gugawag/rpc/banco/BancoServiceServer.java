package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

//    private Map<String, Double> saldoContas;
    private List<Conta> contasList;

    public BancoServiceServer() throws RemoteException {
        contasList = new ArrayList<>();
        contasList.add(new Conta("1", 100.0));
        contasList.add(new Conta("2", 156.0));
        contasList.add(new Conta("3", 950.0));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return contasList.stream().filter(x -> conta.equals(x.getNumero())).findAny().orElse(null).getSaldo();
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contasList.size();
    }

    @Override
    public void adicionarConta(String numero, double saldo) throws RemoteException {
        contasList.add(new Conta(numero, saldo));
    }
    @Override
    public Conta pesquisarConta(String conta) throws RemoteException{
        return contasList.stream().filter(x -> conta.equals(x.getNumero())).findAny().orElse(null);
    }
    @Override
    public void removerConta(String conta) throws RemoteException{
        contasList.remove(pesquisarConta(conta));
    }

}
