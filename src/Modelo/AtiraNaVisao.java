package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;


public class AtiraNaVisao extends Personagem implements Serializable{
    
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

        if(this.pPosicao.getLinha() != hero.pPosicao.getLinha())
            stopLinha = 0;

        if(this.pPosicao.getLinha() == hero.pPosicao.getLinha() && stopLinha != 1){
            stopLinha = 1;
            if(hero.pPosicao.getColuna() < this.pPosicao.getColuna()){
                Tiro t1 = new Tiro("fire.png");
                t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()-2);
                Desenho.acessoATelaDoJogo().addPersonagem(t1);
            }
            else if(hero.pPosicao.getColuna() > this.pPosicao.getColuna()){
                Tiro t1 = new Tiro("fire.png");
                t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
                Desenho.acessoATelaDoJogo().addPersonagem(t1);
            }
        }

        if(this.pPosicao.getColuna() != hero.pPosicao.getColuna())
            stopColuna = 0;

        if(this.pPosicao.getColuna() == hero.pPosicao.getColuna() && stopColuna != 1){
            stopColuna = 1;
            if(hero.pPosicao.getLinha() < this.pPosicao.getLinha()){
                Tiro t2 = new Tiro("fire.png");
                t2.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(t2);
            }
            else if(hero.pPosicao.getLinha() > this.pPosicao.getLinha()){
                Tiro t2 = new Tiro("fire.png");
                t2.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                Desenho.acessoATelaDoJogo().addPersonagem(t2);
            }
        }

    }

} 
