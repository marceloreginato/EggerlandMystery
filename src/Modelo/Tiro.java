package Modelo;
    
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Tiro extends Personagem implements Serializable {

    private char direcao;
 
    public Tiro(String sNomeImagePNG, char direcao) {
        super(sNomeImagePNG, 't');
        this.bMortal = true;    
        this.bTiro = true;    
        this.direcao = direcao;
    }   

    public void autoDesenho() {
        super.autoDesenho();
        if(this.direcao == 'r'){
            if(!moveRight())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
        if(this.direcao == 'l'){
            if(!moveLeft())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
        if(this.direcao == 'u'){
            if(!moveUp())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
        if(this.direcao == 'd'){
            if(!moveDown())
                Desenho.acessoATelaDoJogo().removePersonagem(this);
            if(!Desenho.acessoATelaDoJogo().ehPosicaoValida(this.getPosicao(), c, 't'))
                Desenho.acessoATelaDoJogo().removePersonagem((this));
        }
    }   

}   
