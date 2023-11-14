package Modelo.Inimigo;

import Modelo.Personagem;

public abstract class InimigoAtirador extends Personagem{
    
    public InimigoAtirador(String sNomeImagePNG) {
        super(sNomeImagePNG, 'i');  
        this.bTransponivel = false;              //define que inimigosatiradoes nao sao transponiveis
    }

    public abstract void atiraRight();
    public abstract void atiraLeft();
    public abstract void atiraUp();
    public abstract void atiraDown();
}           


