package Modelo.Blocos; 

import Auxiliar.Consts;

public class Lateral extends Estatico {
    public Lateral(String sNomeImagemPNG, char tipoLateral){
        super(sNomeImagemPNG, 'l');

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
