package Modelo;

public class Coletavel extends Personagem {
    public Coletavel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        super.bMortal = true;
        super.bColetavel = true;
    }
}
