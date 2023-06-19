import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Posicao;
import xadrez.PecaDeXadrez;
import xadrez.XadrezPosicao;

public class UI {
public static XadrezPosicao lerPosicaoDoChadrez(Scanner sc){
    try{
    String s = sc.nextLine();
    char coluna = s.charAt(0);
    int linha = Integer.parseInt(s.substring(1));
    return new XadrezPosicao(coluna, linha);
    }
    catch(RuntimeException e){
        throw new InputMismatchException("Erro lendo posicao de xadrez:valores validos sao de a1 a h8");
    }
}

    public static void imprimirUmaPeca(PecaDeXadrez[][] pecas) {
        for(int i = 0; i<pecas.length; i++){
            System.out.print((8 - i) + " " );
        for(int j=0; j<pecas.length; j++){
            imprimirUmaPeca(pecas[i][j]);
        }
     System.out.println();
    } 
    System.out.println("  a b c d e f g h");
    }
    private static void imprimirUmaPeca(PecaDeXadrez peca) {
        if(peca == null){
            System.out.print("-");

        }else{
            System.out.print(peca);
        }
            System.out.print(" ");
    }
    
}
