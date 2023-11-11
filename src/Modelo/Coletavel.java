package Modelo;

public class Coletavel extends Personagem {
    public Coletavel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bColetavel = true;
        this.bTransponivel = true;
        // this.bMortal = true;
    }
}
