/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package somadematrizes;

/**
 *
 * @author Eric Farias
 * @version 1.0
 */

import java.util.Scanner;
import java.util.Random;
public class Matriz {
    private int matriz[][];
    public static final Scanner IN  = new Scanner(System.in);
    public static final Random ALEATORIO = new Random();
    /**
     * @param ordem indica a ordem a matriz ex.: 2x2, 3x3, 5x5 ... 
     */
    
    public Matriz(int linha, int coluna){
        this.matriz = new int[linha][coluna];
    }
    
    public Matriz(int m[][]){
        this.matriz = m;
    }
    
    /**
     * Preenche a matriz com números aleatórios de 0(zero) a 100(cem).
     */
    public void preencherRandomicamente(){
        for(int i = 0; i < this.matriz.length; i++){
            for(int j = 0; j < this.matriz[i].length; j++){
                this.matriz[i][j] = ALEATORIO.nextInt(101);
            }
        }
    }
    
    /**
     * Preenche manualmente a matriz, ou seja o usuario vai querer setar valor a valor da matriz.
     */
    public void preencherManualmente(){
        for(int i = 0; i < this.matriz.length;i++){
            for(int j = 0; j < this.matriz[i].length; j++){
                System.out.printf("Elemento da posição [%d][%d]: ", i, j);
                this.matriz[i][j] = IN.nextInt();
            }
        }
    }
    
    public static int[][] somar(Matriz m1, Matriz m2) {
       int result[][];
       if(m1.matriz.length == m2.getMatriz().length &&
                m1.matriz[0].length == m2.getMatriz()[0].length){
           
           result = new int[m1.matriz.length][m1.matriz[0].length];
           for(int i = 0; i < m1.getMatriz().length; i++){
               for(int j = 0; j < m1.getMatriz()[i].length; j++){
                   result[i][j] = m1.getMatriz()[i][j] + m2.getMatriz()[i][j];
               }
           }
       }else{
           System.out.println("Operação não pode ser realizada pois as matrizes dadas tem número de linhas ou números de colunas diferentes");
           return null;
       }
       return result;
    }
    
    // Outras operações serão implementadas
    
    public int [][] getMatriz(){
        return this.matriz;
    }
    
    /**
     * Metodo que rescreve os elementos de uma martriz.
     */
    public void escrevaMatriz(){
        for(int []vetor : this.matriz){
            System.out.print("[ ");
            for(int elemento: vetor){
                System.out.print(elemento+" ");
            }
            System.out.print("]\n");
        }
    } 
}
