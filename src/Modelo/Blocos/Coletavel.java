package Modelo.Blocos; 

public class Coletavel extends Estatico {
    
    /*Classe que herda de Personagem e define blocos
    que podem ser coletados pelo heroi (moedas).*/
    
    public Coletavel(String sNomeImagemPNG){
        super(sNomeImagemPNG, 'z');
        this.bColetavel = true;
        this.bTransponivel = true;
    }
} 