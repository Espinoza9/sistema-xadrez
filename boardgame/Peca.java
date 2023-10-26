package boardgame;

public abstract class Peca {
    protected Posicao posicao;
    private Tabuleiro tabuleiro;

    public Peca(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
        posicao = null;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract boolean[][] possivelmovimento();

    // gancho da sub-class

    public boolean possivelmovimento(Posicao posicao) {

        return possivelmovimento()[posicao.getLinha()][posicao.getColuna()];

    }

    public boolean existeAlgumPossivelMovimento(){
        boolean[][]mat = possivelmovimento();
        for(int i=0; i<mat.length; i++) {
        for (int j=0; j<mat.length; j++){
                if(mat[i][j]){
                   return true;
                }
            }
        }
          return false;
    }
}
