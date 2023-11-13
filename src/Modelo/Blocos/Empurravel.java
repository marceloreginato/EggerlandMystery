package Modelo.Blocos; 

import Modelo.Personagem;

public class Empurravel extends Personagem{
    
    /*Classe que herda de Personagem e define blocos
    que podem ser empurrados pelo heroi (caixas).*/
    
    public Empurravel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bEmpurravel = true; 
        this.bTransponivel = false;
    }
}
