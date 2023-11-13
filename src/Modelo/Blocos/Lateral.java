package Modelo.Blocos; 

import Auxiliar.Consts;

public class Lateral extends Estatico {
    
    /*Classe que herda de Estatico e define os icones
    imutaveis (nao-numeros) do Setup Lateral*/
    
    public Lateral(String sNomeImagemPNG, char tipoLateral){
        super(sNomeImagemPNG, 'l');

        /*As posicoes sao predefinas e o caractere indica
        qual o icone que esta sendo adicionado:

        h: imagem do heroi (vidas);
        t: imagem do tiro (moedas coletadas e tiros restantes);
        r: imagem do round (bloco da direita);
        l: imagem do round (bloco da esquerda).
        */
        
        switch (tipoLateral) {
            case 'h':
                setPosicao(5, Consts.RES - 3);
                break;

            case 't':
                setPosicao(6, Consts.RES - 3);
                break;

            case 'r':
                setPosicao(Consts.RES - 3, Consts.RES - 3);
                break;

            case 'l':
                setPosicao(Consts.RES - 3, Consts.RES - 2);
                break;
        
            default:
                break;
        }
    }
}
