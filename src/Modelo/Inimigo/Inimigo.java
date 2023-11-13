package Modelo.Inimigo;

import Modelo.Personagem;

public class Inimigo extends Personagem {

    /*Classe que herda de Personagem e define
    Inimigos simples. O Hero nao morre ao encostar
    neles, e eles so morrem com tiro do Hero*/

    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'i'); 
        this.bTransponivel = false;
        this.bMorrivel = true;
    }
}
