package Modelo.Blocos; 

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
    /*Metodo que verifica se a posicao que objeto esta se movendo eh possivel.*/
    public boolean ehPosicaoValida(Posicao p) {
        return false;       /*Personagem nao pode se mover.*/
    }
}
