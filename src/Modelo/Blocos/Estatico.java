package Modelo.Blocos; 

import Modelo.Personagem;
    
public class Estatico extends Personagem {
    public Estatico(String sNomeImagemPNG, char tipoEstatico){
        super(sNomeImagemPNG, tipoEstatico);
        this.bTransponivel = false;
        this.bEstatico = true;          
    }
}
