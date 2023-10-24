package Modelo;

import Auxiliar.Desenho;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Tiro extends Personagem implements Serializable {
    public Tiro(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.bMortal = true;
    }

    public void autoDesenho() {
        super.autoDesenho();
        if(!this.moveRight())
            Desenho.acessoATelaDoJogo().removePersonagem(this);
    }
}
