
package pecadexadrez;

import boardgame.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez{

    public Torre(Tabuleiro tabuleiro, Cor cor) {
        super(tabuleiro, cor);
       
    }
    @Override
    public String toString(){
        return"R";
    }
    @Override
    public boolean[][] possivelmovimento() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        return mat;

    }
    
    
}
