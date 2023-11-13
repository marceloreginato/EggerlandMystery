package Modelo;

import Auxiliar.Desenho;

public class Hero extends Personagem {

    private int iUp = 0;
    private int iDown = 0;
    private int iRight = 0;
    private int iLeft = 0;
    private char lastMovment;
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG, 'h');
        this.bMorrivel = true;
    }

    public char getLastMovment() {
        return lastMovment;
    }

    // public void setLastMovment(char lastMovment) {
    //     this.lastMovment = lastMovment;
    // }

    private void voltaAUltimaPosicao(){
        this.pPosicao.volta();  
    }
    
    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), 'z', 'h')) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    /*TO-DO: este metodo pode ser interessante a todos os personagens que se movem*/
    private boolean validaPosicao(char c){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 'h')) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;         
    }
    
    public boolean moveUp() {
        iLeft = 0;
        iDown = 0;
        iRight = 0;
        lastMovment = 'u';
        if(super.moveUp()){
            if(iUp == 0){
                this.SkinPersonagem("HeroEstaticBack.png", 'h');
                iUp++;
            }
            else if(iUp == 1){
                this.SkinPersonagem("HeroMovingBack-1.png", 'h');
                iUp++;
            }
            else if(iUp == 2){
                this.SkinPersonagem("HeroMovingBack-2.png", 'h');
                iUp = 0;
            }
            return validaPosicao('u');
        }
        return false;
    }

    public boolean moveDown() {
        iLeft = 0;
        iUp = 0;
        iRight = 0;
        lastMovment = 'd';
        if(super.moveDown()){
            if(iDown == 0){
                this.SkinPersonagem("HeroEstaticFace.png", 'h');
                iDown++;
            }
            else if(iDown == 1){
                this.SkinPersonagem("HeroEstaticFace-1.png", 'h');
                iDown++;
            }
            else if(iDown == 2){
                this.SkinPersonagem("HeroEstaticFace-2.png", 'h');
                iDown = 0;
            }
            return validaPosicao('d');
        }
        return false;
    }

    public boolean moveRight() {
        iLeft = 0;
        iDown = 0;
        iUp = 0;
        lastMovment = 'r';
        if(super.moveRight()){
            if(iRight == 0){
                this.SkinPersonagem("HeroEstaticRight.png", 'h');
                iRight++;
            }
            else if(iRight == 1){
                this.SkinPersonagem("HeroMovingRight.png", 'h');
                iRight = 0;
            }
            return validaPosicao('r');
        }
        return false;
    }

    public boolean moveLeft() {
        iDown = 0;
        iUp = 0;
        iRight = 0;
        lastMovment = 'l';
        if(super.moveLeft()){
            if(iLeft == 0){
                this.SkinPersonagem("HeroEstaticLeft.png", 'h');
                iLeft++;
            }
            else if(iLeft == 1){
                this.SkinPersonagem("HeroMovingLeft.png", 'h');
                iLeft = 0;
            }
            return validaPosicao('l');
        }
        return false;
    }


    public void atira(char direcaoTiro){
        
        if(direcaoTiro == 'r'){
        Tiro t1 = new Tiro("TiroHorizontal.png", 'r');
        t1.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
        Desenho.acessoATelaDoJogo().addPersonagem(t1);
        }
         
        if(direcaoTiro == 'l'){
        Tiro t2 = new Tiro("TiroHorizontal.png", 'l');
        t2.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
        Desenho.acessoATelaDoJogo().addPersonagem(t2);
        }

        if(direcaoTiro == 'u'){
        Tiro t3 = new Tiro("TiroVertical.png", 'u');
        t3.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
        Desenho.acessoATelaDoJogo().addPersonagem(t3);
        }

        if(direcaoTiro == 'd'){
        Tiro t4 = new Tiro("TiroVertical.png", 'd');
        t4.setPosicao(pPosicao.getLinha(),pPosicao.getColuna());
        Desenho.acessoATelaDoJogo().addPersonagem(t4);
        }
    }    

}