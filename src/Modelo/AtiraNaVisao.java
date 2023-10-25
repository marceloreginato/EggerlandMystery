package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;


public class AtiraNaVisao extends InimigoAtirador implements Serializable{
    
    private Hero hero;
    private int stopLinha = 0;
    private int stopColuna = 0;

    public AtiraNaVisao(String sNomeImagePNG, Hero hero) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.hero = hero;
    }
    
    public void autoDesenho(){
        super.autoDesenho();

        if(hero.pPosicao.getLinha() != this.pPosicao.getLinha())
            stopLinha = 0;

        if(hero.pPosicao.getLinha() == this.pPosicao.getLinha() && stopLinha != 1){
            stopLinha = 1;
            if(hero.pPosicao.getColuna() > this.pPosicao.getColuna())
                super.atiraRight();
            else if(hero.pPosicao.getColuna() < this.pPosicao.getColuna())
                super.atiraLeft();
        }       

        if(hero.pPosicao.getColuna() != this.pPosicao.getColuna())
            stopColuna = 0;

        if(hero.pPosicao.getColuna() == this.pPosicao.getColuna() && stopColuna != 1){
            stopColuna = 1;
            if(hero.pPosicao.getLinha() > this.pPosicao.getLinha())
                super.atiraDown();
            if(hero.pPosicao.getLinha() < this.pPosicao.getLinha())
                super.atiraUp();
        }
    }           

}       

