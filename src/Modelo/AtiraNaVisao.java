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
    private int SkinPlantaLinha = 0;
    private int SkinPlantaColuna = 0;

    public AtiraNaVisao(String sNomeImagePNG, Hero hero) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.hero = hero;
    }   
    
    public void autoDesenho(){
        super.autoDesenho();

        if(hero.pPosicao.getLinha() != this.pPosicao.getLinha()){
            SkinPlantaLinha = 0;
            if(SkinPlantaColuna == 0)
                super.SkinPersonagem("PlantinhaDormindo.png", 'i');
            stopLinha = 0;
        }

        if(hero.pPosicao.getLinha() == this.pPosicao.getLinha() && stopLinha != 1){
            SkinPlantaLinha = 1;
            super.SkinPersonagem("PlantinhaPistola.png", 'i');
            stopLinha = 1;
            if(hero.pPosicao.getColuna() > this.pPosicao.getColuna())
                super.atiraRight('v');
            else if(hero.pPosicao.getColuna() < this.pPosicao.getColuna())
                super.atiraLeft('v');
        }       

        if(hero.pPosicao.getColuna() != this.pPosicao.getColuna()){
            SkinPlantaColuna = 0;
            if(SkinPlantaLinha == 0)
                super.SkinPersonagem("PlantinhaDormindo.png", 'i');
            stopColuna = 0;
        }       

        if(hero.pPosicao.getColuna() == this.pPosicao.getColuna() && stopColuna != 1){
            SkinPlantaColuna = 1;
            super.SkinPersonagem("PlantinhaPistola.png", 'i');
            stopColuna = 1;
            if(hero.pPosicao.getLinha() > this.pPosicao.getLinha())
                super.atiraDown('v');
            if(hero.pPosicao.getLinha() < this.pPosicao.getLinha())
                super.atiraUp('v');
        }
    }           

}       

