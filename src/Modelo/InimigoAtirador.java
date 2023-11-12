package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class InimigoAtirador extends Personagem{
    
    public InimigoAtirador(String sNomeImagePNG) {
        super(sNomeImagePNG, 'i');  
        this.bTransponivel = false;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public void atiraRight(){
        Tiro t1 = new Tiro("TiroHorizontal.png", 'r');
        t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
        Desenho.acessoATelaDoJogo().addPersonagem(t1);      
    }

    public void atiraLeft(){
        Tiro t2 = new Tiro("TiroHorizontal.png", 'l');
        t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()-1);
        Desenho.acessoATelaDoJogo().addPersonagem(t2);
    }

    public void atiraUp(){
        Tiro t3 = new Tiro("TiroVertical.png", 'u');
        t3.setPosicao(pPosicao.getLinha()-1,pPosicao.getColuna());
        Desenho.acessoATelaDoJogo().addPersonagem(t3);
    }

    public void atiraDown(){
        Tiro t4 = new Tiro("TiroVertical.png", 'd');
        t4.setPosicao(pPosicao.getLinha()+1,pPosicao.getColuna());
        Desenho.acessoATelaDoJogo().addPersonagem(t4);
    }       

}           


