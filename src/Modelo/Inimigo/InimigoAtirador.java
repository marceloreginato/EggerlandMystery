package Modelo.Inimigo;

import Auxiliar.Posicao;

public abstract class InimigoAtirador extends Inimigo{
    
    public InimigoAtirador(String sNomeImagePNG) {
        super(sNomeImagePNG);  
    }

    public abstract void atiraRight();
    public abstract void atiraLeft();
    public abstract void atiraUp();
    public abstract void atiraDown();

    @Override
    /*Metodo que verifica se a posicao que objeto esta se movendo eh possivel.*/
    public boolean ehPosicaoValida(Posicao p) {
        return false;       /*Personagem nao pode se mover.*/
    }
}           


