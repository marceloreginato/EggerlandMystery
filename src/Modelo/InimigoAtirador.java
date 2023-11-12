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

    public void atiraRight(char c){
        if(c == 'v'){
            Tiro t1 = new Tiro("TiroPlantinhaHorizontal.png", 'r');
            t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t1);
        }
        else if(c == 'm'){
            Tiro t1 = new Tiro("TiroMonstroRoxoDireita.png", 'r');
            t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t1);
        }      
    }

    public void atiraLeft(char c){
        if(c == 'v'){
            Tiro t2 = new Tiro("TiroPlantinhaHorizontal.png", 'l');
            t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t2);
        }
        else if(c == 'm'){
            Tiro t2 = new Tiro("TiroMonstroRoxoEsquerda.png", 'l');
            t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t2);
        }
    }

    public void atiraUp(char c){
        if(c == 'v'){
            Tiro t3 = new Tiro("TiroPlantinhaVertical.png", 'u');
            t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t3);
        }
        else if(c == 'm'){
            Tiro t3 = new Tiro("TiroMonstroRoxoCima.png", 'u');
            t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t3);
        }
    }

    public void atiraDown(char c){
        if(c == 'v'){
            Tiro t4 = new Tiro("TiroPlantinhaVertical.png", 'd');
            t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t4);
        }
        else if(c == 'm'){
            Tiro t4 = new Tiro("TiroMonstroRoxoBaixo.png", 'd');
            t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
            Desenho.acessoATelaDoJogo().addPersonagem(t4);
        }
    }       

}           


