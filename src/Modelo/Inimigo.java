package Modelo;

public class Inimigo extends Personagem {
    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bMorrivel = true;
        this.bMortal = true;
        this.bTransponivel = false;
    }
}
