package com.gugawag.rpc.banco;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AppClienteBanco {

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        // procura o serviço no RMI Registry local. Perceba que o cliente não connhece a implementação do servidor,
        // apenas a interface
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        BancoServiceIF banco = (BancoServiceIF) registry.lookup("BancoService");

        menu();
        Scanner entrada = new Scanner(System.in);
        int opcao = entrada.nextInt();

        while(opcao != 9) {
            switch (opcao) {
                case 1: {
                    System.out.println("Digite o número da conta:");
                    String conta = entrada.next();
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.saldo(conta));
                }
                case 2: {
                    //chamada ao método remoto, como se fosse executar localmente
                    System.out.println(banco.quantidadeContas());
                }
                case 3:{
                    System.out.println("Digite o número da conta para cadastrar");
                    String conta = entrada.next();
                    System.out.println("Digite o saldo para cadastrar");
                    double saldo = entrada.nextDouble();
                    banco.adicionarConta(conta, saldo);
                    System.out.println("Conta cadastrada com sucesso!");
                }
                case 4:{
                    System.out.println("Digite o número da conta para procurar");
                    String conta = entrada.next();
                    Conta contaObjeto =  banco.pesquisarConta(conta);
                    System.out.println("Número da conta: "+ contaObjeto.getNumero()+"\n Conta Saldo:" + contaObjeto.getSaldo() );
                }
                case 5:{
                    System.out.println("Digite o número da conta a ser removida");
                    String conta = entrada.next();
                    banco.removerConta(conta);
                    System.out.println("Conta "+ conta +"removida com sucesso.");
                }
            }
            menu();
            opcao = entrada.nextInt();
        }
    }

    public static void menu() {
        System.out.println("Pablo  Fernandes Santos de Aragão Téjo");
        System.out.println("\n=== BANCO RMI (ou FMI?!) ===");
        System.out.println("1 - Saldo da conta");
        System.out.println("2 - Quantidade de contas");
        System.out.println("3 - Cadastro de nova conta");
        System.out.println("4 - Pesquisar conta");
        System.out.println("5 - Remover conta");
        System.out.println("9 - Sair");
    }

}
