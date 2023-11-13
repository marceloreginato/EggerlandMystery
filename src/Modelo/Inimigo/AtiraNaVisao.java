package Modelo.Inimigo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;  
import java.awt.Graphics;
import java.io.Serializable;
import Modelo.Hero;

public class AtiraNaVisao extends InimigoAtirador implements Serializable{
    
    private Hero hero;
    private int stopLinha = 0;              //bloco de variaveis utilizado para fazer com que inimigo de apenas um tiro por condicao satisfeita
    private int stopColuna = 0;
    private int SkinPlantaLinha = 0;        //bloco de variaveis para auxiliar na troca de skin do inimigo
    private int SkinPlantaColuna = 0;

    public AtiraNaVisao(String sNomeImagePNG, Hero hero) {
        super(sNomeImagePNG);
        this.bTransponivel = false;        //determina Atiranavisao nao transponivel
        this.hero = hero;
    }   
    
    public void autoDesenho(){
        super.autoDesenho();

        if(hero.getPosicao().getLinha() != this.pPosicao.getLinha()){   //caso heroi e inimigos nao estejam na mesma linha
            SkinPlantaLinha = 0;
            if(SkinPlantaColuna == 0)                                   //caso heroi e inimigos nao estejam na mesma coluna
                super.SkinPersonagem("PlantinhaDormindo.png", 'i');  //skin nao ativada do inimigo
            stopLinha = 0;
        }

        if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && stopLinha != 1){ //caso heroi e inimigo estejam na mesma linha
            SkinPlantaLinha = 1;
            super.SkinPersonagem("PlantinhaPistola.png", 'i');  //altera para skin ativada do inimigo
            stopLinha = 1;                                                      //altera variavel para verificar que um tiro ja foi dado
            if(hero.getPosicao().getColuna() > this.pPosicao.getColuna())       //verificacoes de coluna entre heroi e inimigo para definir sentido do tiro
                super.atiraRight('v');
            else if(hero.getPosicao().getColuna() < this.pPosicao.getColuna())
                super.atiraLeft('v');
        }       

        if(hero.getPosicao().getColuna() != this.pPosicao.getColuna()){   //caso heroi e inimigos nao estejam na mesma coluna
            SkinPlantaColuna = 0;
            if(SkinPlantaLinha == 0)                                      //caso heroi e inimigos nao estejam na mesma linha
                super.SkinPersonagem("PlantinhaDormindo.png", 'i'); //skin nao ativada inimigo
            stopColuna = 0;
        }       

        if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && stopColuna != 1){ //caso heroi e inimigo estejam na mesma coluna
            SkinPlantaColuna = 1;                                                       //altera variavel para verificar que um tiro ja foi dado
            super.SkinPersonagem("PlantinhaPistola.png", 'i');          //altera skin para inimigo ativado
            stopColuna = 1;
            if(hero.getPosicao().getLinha() > this.pPosicao.getLinha())                 //verificacoes de linha entre heroi e inimigo para definir sentido do tiro
                super.atiraDown('v');
            if(hero.getPosicao().getLinha() < this.pPosicao.getLinha())
                super.atiraUp('v');
        }
    }           

}       

