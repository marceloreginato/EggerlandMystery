package Modelo;

import Auxiliar.Desenho;

public class Hero extends Personagem {

    private int iUp = 0;            // bloco de variaveis para tratar 
    private int iDown = 0;          // a sensação de movimento do heroi
    private int iRight = 0;
    private int iLeft = 0;
    private char lastMovment;       //char que retorna ultima direcao de movimento do heroi
    
    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG, 'h');
        this.bMorrivel = true;           //define heroi com possibilidade de morrer
    }

    /*get para variavel lastMovment */

    public char getLastMovment() {     
        return lastMovment;
    }

    // public void setLastMovment(char lastMovment) {
    //     this.lastMovment = lastMovment;
    // }

    /*funcao que seta o heroi para a posicao antiga */

    private void voltaAUltimaPosicao(){
        this.pPosicao.volta();  
    }
    
    /*funcao para setar posicao do heroi verificando se a posicao a
     * ser setada é valida ou nao, caso for invalida retorna a 
     * ultima posicao*/

    public boolean setPosicao(int linha, int coluna){
        if(this.pPosicao.setPosicao(linha, coluna)){
            if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), 'z', 'h')) {
                this.voltaAUltimaPosicao();
            }
            return true;
        }
        return false;       
    }

    /*este metodo valida a posicao do heroi e volta para a ultima
     *posicao caso a posicao que o heroi esta seja invalida*/

    private boolean validaPosicao(char c){
        if (!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 'h')) {
            this.voltaAUltimaPosicao();
            return false;
        }
        return true;         
    }
    
    /* move o heroi para cima 
     * foram criadas variaveis para verificar qual skin deve ser aplicada ao heroi
     * as variaveis sao utilizadas para reconhecer em que movimento o herois está
     * e dependendo do valor delas uma determinada skin vai ser utilizada
     * esse tratamento foi criado para dar sensação de movimento ao heroi*/

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

    /*move o heroi para baixo, com o mesmo tratamento para
     * dar a sensação de movimento ao heroi
     */
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

    /*move o heroi para direita, com o mesmo tratamento para
     * dar a sensação de movimento ao heroi
     */

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

    /*move o heroi para esquerda, com o mesmo tratamento para
     * dar a sensação de movimento ao heroi
     */

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

    /*metodo atirar do heroi, que recebe a direcao do tiro e envia ela para o 
     * instanciamento do tiro*/

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