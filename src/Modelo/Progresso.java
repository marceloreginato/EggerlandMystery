package Modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;    
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Auxiliar.Desenho;
import Controler.Tela;

public class Progresso {
    Tela tela;
    String file;
    int currentfase;
    int currentvidas;

    public Progresso(Tela tela){
        this.tela = tela;
        file = ".." + File.separator + "save.dat";
        currentfase = 1;
        currentvidas = 5;
    }
    
    public void salvamento() {
        if (tela.getFase() == 5 || tela.getFase() == 0)
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
        tela.setVida(currentvidas);
    }
}
