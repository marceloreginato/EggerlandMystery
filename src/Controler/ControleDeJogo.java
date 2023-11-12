package Controler;
    
import Modelo.Personagem;
import Modelo.Tiro;
import Modelo.Hero;
import Auxiliar.Posicao;
import java.util.ArrayList;
import Auxiliar.Consts;
import Auxiliar.Desenho;

public class ControleDeJogo {
    public void desenhaTudo(ArrayList<Personagem> e) {
        for (int i = 1; i < e.size(); i++) {
            e.get(i).autoDesenho();
        }
        e.get(0).autoDesenho();
        e.get(Consts.TAM_FASE).autoDesenho();
        e.get(Consts.TAM_FASE + 1).autoDesenho();
        e.get(Consts.TAM_FASE + 2).autoDesenho();
        e.get(Consts.TAM_FASE + 3).autoDesenho();
    }

    public void processaTudo(ArrayList<Personagem> umaFase) {
        Hero hero = (Hero) umaFase.get(0);
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);
            if (hero.getPosicao().igual(pIesimoPersonagem.getPosicao())){
                if(pIesimoPersonagem.isbMortal()){
                    Desenho.acessoATelaDoJogo().removeVidas();
                    Desenho.acessoATelaDoJogo().criaFase();
                }
                if (pIesimoPersonagem.isbColetavel() || pIesimoPersonagem.isbTiro())
                    /* TO-DO: verificar se o personagem eh mortal antes de retirar */
                    umaFase.remove(pIesimoPersonagem);
            }
        }
    }

    /*
     * Retorna true se a posicao p é válida para Hero com relacao a todos os
     * personagens no array 
     */
    // public boolean ehPosicaoValida_Antigo(ArrayList<Personagem> umaFase, Posicao p) {
    //     Personagem pIesimoPersonagem;
    //     for (int i = 1; i < umaFase.size(); i++) {
    //         pIesimoPersonagem = umaFase.get(i);
    //         if (!pIesimoPersonagem.isbTransponivel())
    //             if (pIesimoPersonagem.getPosicao().igual(p))
    //                 return false;
    //     }
    //     return true;    
    // }

    public boolean processaEmpurravel(char sentidoMovimento, Personagem personagemEmpurravel, ArrayList<Personagem> umaFase){
        int linha = personagemEmpurravel.getPosicao().getLinha();
        int coluna = personagemEmpurravel.getPosicao().getColuna();

        switch (sentidoMovimento) {
            case 'u':
                Posicao posicaoU = new Posicao(linha - 1, coluna);
                if(!this.ehPosicaoValida(umaFase, posicaoU, 'u', 'e'))
                    return false;
                personagemEmpurravel.moveUp();
                break;

            case 'd':
                Posicao posicaoD = new Posicao(linha + 1, coluna);
                if(!this.ehPosicaoValida(umaFase, posicaoD, 'd', 'e'))
                    return false;
                personagemEmpurravel.moveDown();
                break;

            case 'l':
                Posicao posicaoL = new Posicao(linha, coluna - 1);
                if(!this.ehPosicaoValida(umaFase, posicaoL, 'l', 'e'))
                    return false;
                personagemEmpurravel.moveLeft();
                break;

            case 'r':
                Posicao posicaoR = new Posicao(linha - 1, coluna + 1);
                if(!this.ehPosicaoValida(umaFase, posicaoR, 'r', 'e'))
                    return false;    
                personagemEmpurravel.moveRight();
                break;

            default:
                break;
        }
        return true;
    }

    public boolean ehPosicaoValida(ArrayList<Personagem> umaFase, Posicao p, char sentidoMovimento, char tipoPersonagem) {
        Personagem pIesimoPersonagem;
        for (int i = 1; i < umaFase.size(); i++) {
            pIesimoPersonagem = umaFase.get(i);

            if (pIesimoPersonagem.getPosicao().igual(p)) {
                if (tipoPersonagem == 't') {
                    if (pIesimoPersonagem.isbMorrivel()) {
                        umaFase.remove(pIesimoPersonagem);
                        return false;
                    }
                    if(pIesimoPersonagem.isbEmpurravel() || pIesimoPersonagem.isbColetavel() || pIesimoPersonagem.isbPorta() || !pIesimoPersonagem.isbTransponivel())
                        return false;
                    // if(pIesimoPersonagem.isbTransponivel())
                    //     return false;
                    // if(pIesimoPersonagem.isbMortal())
                    //     return false;
                    return true;
                }   
                if (!pIesimoPersonagem.isbTransponivel()) {
                    if (pIesimoPersonagem.isbEmpurravel())
                        return processaEmpurravel(sentidoMovimento, pIesimoPersonagem, umaFase);
                    return false;
                }
                if(pIesimoPersonagem.isbColetavel()){
                    if(tipoPersonagem != 'h')
                        return false;
                    Desenho.acessoATelaDoJogo().addMoedas();
                    Desenho.acessoATelaDoJogo().addMoedasColetadas();
                }
                return true;
            }
        }
        return true;
    }

    public boolean ehValidoZigueZague(ArrayList<Personagem> umaFase, Posicao p){
        Personagem pIesimoPersonagem;
        for(int i = 1; i < umaFase.size(); i++){
            pIesimoPersonagem = umaFase.get(i);
            if(pIesimoPersonagem.isbEstatico() ||pIesimoPersonagem.isbColetavel() || pIesimoPersonagem.isbEmpurravel() || pIesimoPersonagem.isbPorta()){
                if(pIesimoPersonagem.getPosicao().igual(p)){
                    return false;   
                }   
            }
        }
        return true; 
    }
}
