package Modelo.Blocos; 

import Modelo.Personagem;

public class Coletavel extends Personagem {
    
    /*Classe que herda de Personagem e define blocos
    que podem ser coletados pelo heroi (moedas).*/
    
    public Coletavel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bColetavel = true;
        this.bTransponivel = true;
    }
}
