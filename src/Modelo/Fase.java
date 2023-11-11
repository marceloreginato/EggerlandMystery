package Modelo;
import java.util.ArrayList;

abstract public class Fase {
    ArrayList<Personagem> fase = new ArrayList<Personagem>();
    // Hero hero = new Hero("HeroEstaticFace.png");

    public ArrayList<Personagem> getFase(){
        return fase;
    }
}
