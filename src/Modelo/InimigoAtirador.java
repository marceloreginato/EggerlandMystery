package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class InimigoAtirador extends Personagem implements Serializable {
    private int iContaIntervalos;
    
    public InimigoAtirador(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bTransponivel = false;
        this.iContaIntervalos = 0;
    }

    public void autoDesenho() {
        super.autoDesenho();

        this.iContaIntervalos++;
        if(this.iContaIntervalos == Consts.TIMER){
            this.iContaIntervalos = 0;
            Tiro t = new Tiro("fire.png");
            //t.setPosicao(pPosicao.getLinha(),pPosicao.getColuna()+1);
            Desenho.acessoATelaDoJogo().addPersonagem(t);
        }
    }  
}
