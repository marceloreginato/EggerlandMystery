package Controler;
    
import Modelo.Personagem;
import Modelo.Hero;
import java.util.ArrayList; 
import Auxiliar.Consts;
import Auxiliar.Desenho;
import Auxiliar.Posicao;

public class ControleDeJogo {

    /*A desenha tudo foi alterada para que os personagens que atiram sejam desenhados por
     * ultimo de maneira que o tiro saia por baixo dele, para que o tiro consiga atingir 
     * um bloco, por exemplo, exatamente na frente do personagem atirador
     */

    public void desenhaTudo(ArrayList<Personagem> e) {
        for (int i = 1; i < e.size(); i++) {
            e.get(i).autoDesenho();
        }
        e.get(0).autoDesenho();
        if(Desenho.acessoATelaDoJogo().tamanhoFase() > Consts.TAM_FASE){
            e.get(Consts.TAM_FASE).autoDesenho();
            e.get(Consts.TAM_FASE + 1).autoDesenho();
            e.get(Consts.TAM_FASE + 2).autoDesenho();
            e.get(Consts.TAM_FASE + 3).autoDesenho();
        }
    }

    /*Processa tudo verifica se o personagem encostado pelo hero pode matar ele, removendo uma vida do hero e reiniciando a fase
     * caso um coletavel ou um tiro encoste no hero esse elemento eh removido da tela
    */

    public void processaTudo(ArrayList<Personagem> umaFase) {
        Hero hero = (Hero) umaFase.get(0);
        Personagem pIesimoPersonagem;   
        int i = 0;
        for (i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);
            if (hero.getPosicao().igual(pIesimoPersonagem.getPosicao())){
                if(pIesimoPersonagem.isbMortal()){
                    Desenho.acessoATelaDoJogo().removeVidas();
                    Desenho.acessoATelaDoJogo().criaFase();
                }
                if (pIesimoPersonagem.isbColetavel() || pIesimoPersonagem.isbTiro())
                    umaFase.remove(pIesimoPersonagem);
            }
        }
    }

}
