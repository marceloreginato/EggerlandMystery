package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;    
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Controler.Tela;

public class Progresso { 

    /*Classe para salvar o progresso em um arquivo binario. As 
    informacoes necessarias para restaurar o estado do jogo sao: 
    o numero da fase em que o jogador esta e aquantidade de vidas, 
    pois as moedas resetam a cada inicio de fase.*/

    protected Tela tela;
    protected String file;
    protected int currentfase;
    protected int currentvidas;

    public Progresso(Tela tela){

        /*Acessa a tela, define um arquivo binario e 
        define as constantes iniciais de fase e vidas.*/

        this.tela = tela;
        file = ".." + File.separator + "save.dat";
        currentfase = 1;
        currentvidas = 5;
    }
    
    public void salvamento() {

        /*Metodo para salvar o progresso no jogo. Pega a fase e as vidas
        atuais da tela [se a fase nao for uma jogavel (tela de inico, fim ou
        gameover), define-se como fase 1]. Escreve os dois valores no arquivo.
        Ao escrever, sobrescreve os dados anteriores.*/

        if (tela.getFase() > 4 || tela.getFase() == 0)
            currentfase = 1;
        else
            currentfase = tela.getFase();

        currentvidas = tela.getVidas();

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeInt(currentfase);
            dataOutputStream.writeInt(currentvidas);
            dataOutputStream.close();
            // System.out.println("Jogo salvo com sucesso");
        } catch (IOException e) {
            System.err.println("Erro no salvamento do jogo: " + e.getMessage());
        }
    }

    public void restaurar(){

        /*Metodo para restaurar o progresso no jogo. Le os dois valores do
        arquivo (fase e vidas, respectivamente) e envia eles para a tela.*/

        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            currentfase = dataInputStream.readInt();
            currentvidas = dataInputStream.readInt();
            // System.out.println("Jogo restaurado com sucesso");
            dataInputStream.close();
        } catch (IOException e) {
            System.err.println("Erro ao restaurar o jogo: " + e.getMessage());
        }
        tela.setFase(currentfase);
        tela.setVidas(currentvidas);
    }

    public void limpar(){

        /*Metodo para limpar o progresso no jogo. Define a fase e as vidas
        como as inicias (1 e 5, respectivamente) e as escreve no arquivo.
        Ao escrever, sobrescreve os dados anteriores.*/

        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            dataOutputStream.writeInt(1);
            dataOutputStream.writeInt(5);
            dataOutputStream.close();
            // System.out.println("Jogo salvo com sucesso");
        } catch (IOException e) {
            System.err.println("Erro no salvamento do jogo: " + e.getMessage());
        }
    }
}
