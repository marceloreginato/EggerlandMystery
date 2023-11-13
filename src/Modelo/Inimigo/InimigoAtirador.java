package Modelo.Inimigo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import Modelo.Personagem;
import Modelo.Tiro;

public class InimigoAtirador extends Personagem{
    
    public InimigoAtirador(String sNomeImagePNG) {
        super(sNomeImagePNG, 'i');  
        this.bTransponivel = false;              //define que inimigosatiradoes nao sao transponiveis
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public void atiraRight(char c){              //recebe caracter para determinar qual skin de tiro utilizar, pois temos dois atiradores que herdam desta classe
        if(c == 'v'){                            //caracter v pata atiranaVisao e m para atirapelaMoeda
            Tiro t1 = new Tiro("TiroPlantinhaHorizontal.png", 'r'); //instancia objeto tiro
            t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t1); //adiciona tiro no array de personagens
        }
        else if(c == 'm'){
            Tiro t1 = new Tiro("TiroMonstroRoxoDireita.png", 'r');  //instancia objeto tiro
            t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t1); //adiciona tiro no array de personagens
        }      
    }

    public void atiraLeft(char c){
        if(c == 'v'){
            Tiro t2 = new Tiro("TiroPlantinhaHorizontal.png", 'l'); //instancia objeto tiro
            t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t2); //adiciona tiro no array de personagens
        }
        else if(c == 'm'){
            Tiro t2 = new Tiro("TiroMonstroRoxoEsquerda.png", 'l');  //instancia objeto tiro
            t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t2); //adiciona tiro no array de personagens
        }
    }

    public void atiraUp(char c){
        if(c == 'v'){
            Tiro t3 = new Tiro("TiroPlantinhaVertical.png", 'u');  //instancia objeto tiro
            t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t3); //adiciona tiro no array de personagens
        }
        else if(c == 'm'){
            Tiro t3 = new Tiro("TiroMonstroRoxoCima.png", 'u'); //instancia objeto tiro
            t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t3); //adiciona tiro no array de personagens
        }
    }

    public void atiraDown(char c){
        if(c == 'v'){
            Tiro t4 = new Tiro("TiroPlantinhaVertical.png", 'd'); //instancia objeto tiro
            t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t4); //adiciona tiro no array de personagens
        }
        else if(c == 'm'){
            Tiro t4 = new Tiro("TiroMonstroRoxoBaixo.png", 'd'); //instancia objeto tiro
            t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t4); //adiciona tiro no array de personagens
        }
    }       

}           


