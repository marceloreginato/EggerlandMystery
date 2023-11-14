package Modelo.Inimigo;

import Auxiliar.Posicao;
import Modelo.Personagem;

public abstract class Inimigo extends Personagem {

    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'i'); 
        this.bTransponivel = false;
    }

    @Override
    /*Metodo que verifica se a posicao que objeto esta se movendo eh possivel.*/
    public boolean ehPosicaoValida(Posicao p) {
        return false;       /*Personagem nao pode se mover.*/
    }
    
}
