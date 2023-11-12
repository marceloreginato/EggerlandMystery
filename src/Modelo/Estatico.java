package Modelo;
    
public class Estatico extends Personagem {
    public Estatico(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bTransponivel = false;
        this.bEstatico = true;          
    }
}
