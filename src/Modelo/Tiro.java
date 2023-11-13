package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Tiro extends Personagem implements Serializable {

    private char c;
 
    public Tiro(String sNomeImagePNG, char c) {
        super(sNomeImagePNG, 't');  
        this.bMortal = true;               //variavel booleana para definir que o tiro mata o Hero
        this.bTiro = true;                 //variavel para verificar em controleDoJogo se o pIesimoPersonagem é um tiro
        this.c = c;                        //caracter que define direcao do tiro
    }   

    public void autoDesenho() {
        super.autoDesenho();
        if(this.c == 'r'){                 //caso o caracter de definicao do tiro seja r, o tiro irá para a direita
            if(!moveRight())               //tiro se move para a direita até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);     
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't')) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this));  //caso nao seja valida remove o tiro
        }
        if(this.c == 'l'){                 //caso caracter de definicao do tiro sera l, o tiro irá para a esquerda
            if(!moveLeft())                //tiro se move para a esquerda até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't')) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this));  //caso nao seja valida remove o tiro
        }
        if(this.c == 'u'){                  //caso caracter de definicao do tiro sera u, o tiro irá para cima
            if(!moveUp())                   //tiro se move para cima até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't')) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this));   //caso nao seja valida remove o tiro
        }
        if(this.c == 'd'){                  //caso caracter de definicao do tiro sera d, o tiro irá para baixo
            if(!moveDown())                 //tiro se move para baixo até a resolucao da tela, sendo removido ao fim
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't')) //verifica se a proxima posicao em que o tiro se move é valida
                Desenho.acessoATelaDoJogo().removePersonagem((this)); //caso nao seja valida remove o tiro
        }
    }   

}   
