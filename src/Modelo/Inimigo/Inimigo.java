package Modelo.Inimigo;

import java.util.ArrayList;

import Auxiliar.Posicao;
import Modelo.Personagem;

public abstract class Inimigo extends Personagem {

    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'i'); 
        this.bTransponivel = false;
    }

    @Override
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p) {
        return false;
    }
    
}
