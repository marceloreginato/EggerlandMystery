package Modelo.Blocos; 

import java.util.ArrayList;

import Auxiliar.Posicao;
import Modelo.Personagem;   
        
public abstract class Estatico extends Personagem { 
    
    /*Classe abstrata que herda de Personagem e define blocos
    que podem ser nao podem ser ultrapassados pelo heroi.*/
    
    protected Estatico(String sNomeImagemPNG, char tipoEstatico){
        super(sNomeImagemPNG, tipoEstatico);
        this.bTransponivel = false;
        this.bEstatico = true;          
    }

    @Override
    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p) {
        return false;
    }
}
