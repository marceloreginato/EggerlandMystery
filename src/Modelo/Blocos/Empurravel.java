package Modelo.Blocos; 

import Modelo.Personagem;

public class Empurravel extends Personagem{          
    public Empurravel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bEmpurravel = true; 
        this.bTransponivel = false;
    }
}
