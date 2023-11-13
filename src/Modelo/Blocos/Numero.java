package Modelo.Blocos; 

import Auxiliar.Consts;

public class Numero extends Estatico {

    /*Classe que herda de Estatico e define os 
    icones mutaveis (numeros) do Setup Lateral*/

    int numero;
    String Nomepng;

    public Numero(int numero, char tipoNumero){

        /*Transforma o inteiro da quantidade recebida em
        string para pegar a imagem correspondente*/

        super(Integer.toString(numero) + ".png", 'l');

        /*As posicoes sao predefinas e o caractere indicam
        qual o icone que esta sendo adicionado:

        v: contador de vida;
        m: contador de moeda;
        f: contador de fase.
        */

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
