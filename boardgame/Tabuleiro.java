package boardgame;

import javax.swing.text.Position;

import pecadexadrez.TabuleiroException;
import xadrez.PecaDeXadrez;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if (linhas < 1 || colunas < 1) {
            throw new TabuleiroException("Erro criando tabuleiro: necessario pelomenos 1 linha e uma coluna ");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public Peca peca(int linha, int coluna) {
        if (!posicaoExistente(linha, coluna)) {
            throw new TabuleiroException("posiçao nao existente no tabuleiro");
        }
        return pecas[linha][coluna];
    }

    public Peca peca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("posiçao nao existente no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    public void posicaoPeca(Peca peca, Posicao posicao) {
        if (aUmaPeca(posicao)) {
            throw new TabuleiroException("já existe uma peça uma peça na posição" + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    public Peca removerPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("nao existe essa osiaçao no tabuleiro");
        }
        if (peca(posicao) == null) {
            return null;
        }
        Peca aux = peca(posicao);
        aux.posicao =  null;
        pecas[posicao.getLinha()][posicao.getColuna()]= null;
        return aux;
    }

    private boolean posicaoExistente(int linha, int coluna) {
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    public boolean posicaoExistente(Posicao posicao) {
        return posicaoExistente(posicao.getLinha(), posicao.getColuna());
    }

    public boolean aUmaPeca(Posicao posicao) {
        if (!posicaoExistente(posicao)) {
            throw new TabuleiroException("posiçao nao existente no tabuleiro");
        }

        return peca(posicao) != null;
    }

}
