package Modelo.Blocos; 

import Auxiliar.Consts;

public class Numero extends Estatico {
    int numero;
    String Nomepng;

    public Numero(int numero, char tipoNumero){
        super(Integer.toString(numero) + ".png", 'l');

        switch (tipoNumero) {
            case 'v':
                setPosicao(5, Consts.RES-2);
                break;
            case 'm':
                setPosicao(6, Consts.RES-2);
                break;
            case 'f':
                setPosicao(Consts.RES - 2, Consts.RES - 2);
                break;
            default:
                break;
        }
    }
}
