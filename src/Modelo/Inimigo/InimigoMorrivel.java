package Modelo.Inimigo;

import Modelo.Personagem;

public class InimigoMorrivel extends Personagem {

    /*Classe que herda de Personagem e define
    Inimigos simples. O Hero nao morre ao encostar
    neles, e eles so morrem com tiro do Hero*/

    public InimigoMorrivel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'i'); 
        this.bTransponivel = false;
        this.bMorrivel = true;
    }
}
