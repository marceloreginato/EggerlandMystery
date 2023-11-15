package Modelo.Inimigo;

public class InimigoMorrivel extends Inimigo {

    /*Classe que herda de Inimigo e define
    Inimigos que morrem por tiros. O Hero nao morre ao encostar
    neles, e eles so morrem com tiro do Hero*/

    public InimigoMorrivel(String sNomeImagemPNG){
        super(sNomeImagemPNG); 
        this.bMorrivel = true;
    }
}
