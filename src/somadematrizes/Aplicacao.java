package somadematrizes;

/**
 *
 * @author Eric Farias
 * @version 1.0
 * 
 */

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int linhas;
        int colunas;
        System.out.print("Informe o número de linhas da matriz: ");
        linhas = input.nextInt();
        System.out.print("Informe o número de colunas da matriz: ");
        colunas = input.nextInt();
        
        Matriz m1 = new Matriz(linhas, colunas);
        Matriz m2 = new Matriz(linhas, colunas);
        
        System.out.print("Deseja preencher a matriz Randomicamente(1) ou Manualmente(2)?: ");
        byte opcao = input.nextByte();
        
        if(opcao == 1){
            m1.preencherRandomicamente();
            m2.preencherRandomicamente();
        }else{
            m1.preencherManualmente();
            System.out.println();
            m2.preencherManualmente();
        }
        
        Matriz result = new Matriz(Matriz.somar(m1, m2));
        result.escrevaMatriz();
    }
    
}
