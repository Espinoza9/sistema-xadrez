
import java.util.InputMismatchException;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.XadrezException;
import xadrez.XadrezPosicao;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

        while (true) {
            try {
                UI.limpartela();
                UI.imprimirUmaPeca(partidaDeXadrez.getPecas());
                System.out.println();
                System.out.print("inicio:");
                XadrezPosicao fonte = UI.lerPosicaoDoChadrez(sc);

                System.out.println();
                System.out.print("destino:");
                XadrezPosicao destino = UI.lerPosicaoDoChadrez(sc);

                PecaDeXadrez capturarPeca = partidaDeXadrez.executaMovimentoDeXadrez(fonte, destino);
            } catch (XadrezException e) {
                System.out.println(e.getMessage());
                sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();

            }
        }
    }
}