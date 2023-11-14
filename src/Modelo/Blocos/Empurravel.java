package Modelo.Blocos; 

import java.util.ArrayList;

import Auxiliar.Posicao;
import Modelo.Personagem;

public class Empurravel extends Personagem{
    
    /*Classe que herda de Personagem e define blocos
    que podem ser empurrados pelo heroi (caixas).*/
    
    public Empurravel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bEmpurravel = true; 
        this.bTransponivel = false;
    }

    @Override
    /*Metodo que verifica se a posicao que objeto esta se movendo eh possivel.*/
    public boolean ehPosicaoValida(Posicao p) {
        ArrayList<Personagem> umaFase = getFaseAtual();
        Personagem pIesimoPersonagem;

        /*Percorre o array do ambiente da fase (desconsiderando o Hero) e
        verifica se ha algum Personagem na posicao a ser movimentada.*/
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);

            if (pIesimoPersonagem.getPosicao().igual(p)) {
                /*Tratamento para se o objeto que esta se movendo eh um Empurravel.
                Empurravel nao se move se tiver outro Personagem no lugar.*/
                return false;    
            }
        }
        /*Retorna true se nao for conflitante*/
        return true;
    }
}
