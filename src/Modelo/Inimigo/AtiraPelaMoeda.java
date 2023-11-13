package Modelo.Inimigo;

import Auxiliar.Consts;
import Auxiliar.Desenho;    
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import Modelo.Hero;

public class AtiraPelaMoeda extends InimigoAtirador{

    private String sNomeImagePNG;
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
                    super.atiraRight('m');  
                tiroD++;
            }
            else if(tiroD != 0 && this.sNomeImagePNG.equals("MonstroRoxoDireita.png")){
                super.SkinPersonagem("MonstroRoxoDireitaAcordado.png", 'i');
                if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && hero.getPosicao().getColuna() > this.pPosicao.getColuna() && stopLinha != 1){                    stopLinha = 1;
                    super.atiraRight('m');
                }
                else if(hero.getPosicao().getLinha() != this.pPosicao.getLinha())
                    stopLinha = 0;
            }   

            if(tiroE == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png"))
                    super.atiraLeft('m');
                tiroE++;
            }
            else if(tiroE != 0 && this.sNomeImagePNG.equals("MonstroRoxoEsquerda.png")){
                super.SkinPersonagem("MonstroRoxoEsquerdaAcordado.png", 'i');
                if(hero.getPosicao().getLinha() == this.pPosicao.getLinha() && hero.getPosicao().getColuna() < this.pPosicao.getColuna() && stopLinha != 1){
                    stopLinha = 1;
                    super.atiraLeft('m');
                }
                else if(hero.getPosicao().getLinha() != this.pPosicao.getLinha())
                    stopLinha = 0;
            }

            if(tiroT == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoTras.png"))
                    super.atiraUp('m');
                tiroT++;
            }
            else if(tiroT != 0 && this.sNomeImagePNG.equals("MonstroRoxoTras.png")){
                super.SkinPersonagem("MonstroRoxoTras.png", 'i');
                if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && hero.getPosicao().getLinha() < this.pPosicao.getLinha() && stopColuna != 1){
                    stopColuna = 1;
                    super.atiraUp('m');
                }
                else if(hero.getPosicao().getColuna() != this.pPosicao.getColuna())
                    stopColuna = 0;
            }

            if(tiroF == 0){
                if(this.sNomeImagePNG.equals("MonstroRoxoFrente.png"))
                    super.atiraDown('m');
                tiroF++;
            }
            else if(tiroF != 0 && this.sNomeImagePNG.equals("MonstroRoxoFrente.png")){
                super.SkinPersonagem("MonstroRoxoFrenteAcordado.png", 'i');
                if(hero.getPosicao().getColuna() == this.pPosicao.getColuna() && hero.getPosicao().getLinha() > this.pPosicao.getLinha() && stopColuna != 1){
                    stopColuna = 1;
                    super.atiraDown('m');      
                }
                else if(hero.getPosicao().getColuna() != this.pPosicao.getColuna())
                    stopColuna = 0;
            }
        }
    }
}