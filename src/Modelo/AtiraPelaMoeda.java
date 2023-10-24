package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class AtiraPelaMoeda extends InimigoAtirador implements Serializable {

    private String sNomeImagePNG;

    public AtiraPelaMoeda(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.sNomeImagePNG = sNomeImagePNG;
        this.bTransponivel = false;
    }

    public void autoDesenho(){
        super.autoDesenho();

        if(this.sNomeImagePNG.equals("AtiraPelaMoedaRight")){
            super.atiraRight();
        }

        if(this.sNomeImagePNG.equals("AtiraPelaMoedaLeft")){
            super.atiraLeft();
        }

        if(this.sNomeImagePNG.equals("AtiraPelaMoedaUp")){
            super.atiraUp();
        }

        if(this.sNomeImagePNG.equals("AtiraPelaMoedaDown")){
            super.atiraDown();
        }
    }

}
