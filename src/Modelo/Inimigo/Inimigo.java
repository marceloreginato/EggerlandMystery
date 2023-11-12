package Modelo.Inimigo;

import Modelo.Personagem;

public class Inimigo extends Personagem {

    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'i'); 
        this.bTransponivel = false;
        this.bMorrivel = true;
    }

}
