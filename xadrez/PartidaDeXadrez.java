package xadrez;

import boardgame.Peca;
import boardgame.Posicao;
import boardgame.Tabuleiro;
import pecadexadrez.Rei;
import pecadexadrez.Torre;

public class PartidaDeXadrez {
    private Tabuleiro tabuleiro;

    public PartidaDeXadrez() {
        tabuleiro = new Tabuleiro(8, 8);
        iniarPartida();
    }

    public PecaDeXadrez[][] getPecas() {
        PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    public PecaDeXadrez executaMovimentoDeXadrez(XadrezPosicao fontePosicao, XadrezPosicao posicaoDestino) {
        Posicao fonte = fontePosicao.toPosicao();
        Posicao destino = posicaoDestino.toPosicao();

        validarFontePosicao(fonte);
        Peca capturarPeca = fazerMover(fonte, destino);
        return (PecaDeXadrez) capturarPeca;
    }
    private Peca fazerMover(Posicao fonte, Posicao destino){
        Peca p = tabuleiro.removerPeca(fonte);
        Peca capturarPeca = tabuleiro.removerPeca(destino);
        tabuleiro.posicaoPeca(p,destino);
        return capturarPeca;
        
    }

    private void validarFontePosicao(Posicao posicao) {
        if (!tabuleiro.aUmaPeca(posicao)) {
            throw new XadrezException("não há peça na posição de origem");
        }
        if(tabuleiro.peca(posicao).existeAlgumPossivelMovimento()){
            throw new XadrezException("não há movimentação possível para a peça escolhida");

        }
    }

    private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
        tabuleiro.posicaoPeca(peca, new XadrezPosicao(coluna, linha).toPosicao());
    }

    private void iniarPartida() {
        colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
    }
}
