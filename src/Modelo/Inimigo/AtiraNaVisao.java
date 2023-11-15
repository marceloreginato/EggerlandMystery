package Modelo.Inimigo;

import Auxiliar.Desenho;
import Modelo.Hero;
import Modelo.Tiro; 

public class AtiraNaVisao extends InimigoAtirador{
    
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
                this.atiraRight();
            else if(hero.getPosicao().getColuna() < this.pPosicao.getColuna())
                this.atiraLeft();
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
                this.atiraDown();
            if(hero.getPosicao().getLinha() < this.pPosicao.getLinha())
                this.atiraUp();
        }
    }
    
    /*Polimorfismo metodos atirar */

    @Override
    public void atiraRight(){
            Tiro t1 = new Tiro("TiroHorizontalPlantinha.png", 'r'); //instancia objeto tiro
            t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t1); //adiciona tiro no array de personagens
    }

    @Override
    public void atiraLeft(){
            Tiro t2 = new Tiro("TiroHorizontalPlantinha.png", 'l'); //instancia objeto tiro
            t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t2); //adiciona tiro no array de personagens
    }

    @Override
    public void atiraUp(){
            Tiro t3 = new Tiro("TiroHorizontalVertical.png", 'u');  //instancia objeto tiro
            t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t3); //adiciona tiro no array de personagens
    }

    @Override
    public void atiraDown(){
            Tiro t4 = new Tiro("TiroHorizontalVertical.png", 'd'); //instancia objeto tiro
            t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()); //define posicao inicial
            Desenho.acessoATelaDoJogo().addPersonagem(t4); //adiciona tiro no array de personagens
    }

}       

