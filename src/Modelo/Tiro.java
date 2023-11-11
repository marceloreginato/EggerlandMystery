package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Tiro extends Personagem implements Serializable {

    private char c;
 
    public Tiro(String sNomeImagePNG, char c) {
        super(sNomeImagePNG, 't');
        this.bMortal = true;    
        this.c = c;
    }

    public void autoDesenho() {
        super.autoDesenho();
        if(this.c == 'r'){
            if(!moveRight())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
        if(this.c == 'l'){
            if(!moveLeft())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
        if(this.c == 'u'){
            if(!moveUp())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
        if(this.c == 'd'){
            if(!moveDown())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
    }   

}   
