package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class AtiraPelaMoeda extends InimigoAtirador{

    private String sNomeImagePNG;
    int aguardaTodosAtirar = 0;
    int tiroD = 0;
    int tiroE = 0;
    int tiroF = 0;
    int tiroT = 0;
    int stopLinha = 0;
    int stopColuna = 0;
    Hero hero;

    public AtiraPelaMoeda(String sNomeImagePNG, Hero hero){
        super(sNomeImagePNG);
        this.sNomeImagePNG = sNomeImagePNG;
        this.hero = hero;
    }

    public void autoDesenho(){
        super.autoDesenho();

        if(Desenho.acessoATelaDoJogo().getMoedas() != 0){

            if(tiroD == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoDireita.png"))
                    super.atiraRight();
                tiroD++;
            }
            else if(tiroD != 0 && this.sNomeImagePNG.equals("MonstroRoxoDireita.png")){
                if(hero.pPosicao.getLinha() == this.pPosicao.getLinha() && hero.pPosicao.getColuna() > this.pPosicao.getColuna() && stopLinha != 1){
                    super.SkinPersonagem("MonstroRoxoDireita.png", 'i');
                    stopLinha = 1;
                    super.atiraRight();
                }
                else if(hero.pPosicao.getLinha() != this.pPosicao.getLinha())
                    stopLinha = 0;
            }   

            if(tiroE == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png"))
                    super.atiraLeft();
                tiroE++;
            }
            else if(tiroE != 0 && this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png")){
                if(hero.pPosicao.getLinha() == this.pPosicao.getLinha() && hero.pPosicao.getColuna() < this.pPosicao.getColuna() && stopLinha != 1){
                    super.SkinPersonagem("MonstroRoxoEsquerda.png", 'i');
                    stopLinha = 1;
                    super.atiraLeft();
                }
                else if(hero.pPosicao.getLinha() != this.pPosicao.getLinha())
                    stopLinha = 0;
            }

            if(tiroT == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoTras.png"))
                    super.atiraUp();
                tiroT++;    
            }
            else if(tiroT != 0 && this.sNomeImagePNG.equals("MonstroRoxoTras.png")){
                if(hero.pPosicao.getColuna() == this.pPosicao.getColuna() && hero.pPosicao.getLinha() < this.pPosicao.getLinha() && stopColuna != 1){
                    super.SkinPersonagem("MonstroRoxoTras.png", 'i');
                    stopColuna = 1;
                    super.atiraUp();
                }
                else if(hero.pPosicao.getColuna() != this.pPosicao.getColuna())
                    stopColuna = 0;
            }

            if(tiroF == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoFrente.png"))
                    super.atiraDown();
                tiroF++;   
            }
            else if(tiroF != 0 && this.sNomeImagePNG.equals("MonstroRoxoFrente.png")){
                if(hero.pPosicao.getColuna() == this.pPosicao.getColuna() && hero.pPosicao.getLinha() > this.pPosicao.getLinha() && stopColuna != 1){
                    super.SkinPersonagem("MonstroRoxoFrente.png", 'i');
                    stopColuna = 1;
                    super.atiraDown();      
                }
                else if(hero.pPosicao.getColuna() != this.pPosicao.getColuna())
                    stopColuna = 0;
            }
            aguardaTodosAtirar++;

            if(aguardaTodosAtirar == 3)
                Desenho.acessoATelaDoJogo().addMoedas();
        }
    }

}