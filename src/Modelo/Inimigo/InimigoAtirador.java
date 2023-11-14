package Modelo.Inimigo;

public abstract class InimigoAtirador extends Inimigo{
    
    public InimigoAtirador(String sNomeImagePNG) {
        super(sNomeImagePNG);  
    }

    public abstract void atiraRight();
    public abstract void atiraLeft();
    public abstract void atiraUp();
    public abstract void atiraDown();
}           


