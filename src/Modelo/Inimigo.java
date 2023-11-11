package Modelo;

public class Inimigo extends Personagem {
    public Inimigo(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bTransponivel = true;
        this.bMorrivel = true;
    }
}
