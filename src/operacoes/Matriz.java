/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operacoes;

/**
 *
 * @author Eric Farias
 * @since 27/02/2016
 * 
 */

import java.util.Scanner;
import java.util.Random;
public class Matriz {
    private int matriz[][];
    public static final Scanner IN  = new Scanner(System.in);
    public static final Random ALEATORIO = new Random();
    
    /**
     * construtor da da classe Matriz
     * @param linha O número de linhas da matriz
     * @param coluna O número de colunas da matriz
     */
    public Matriz(int linha, int coluna){
        if(linha > Integer.MAX_VALUE || linha < Integer.MIN_VALUE){
            throw new NumberFormatException("Número de linhas fora dos limites permitidos pelo tipo inteiro.");
        }
        if(coluna > Integer.MAX_VALUE || coluna < Integer.MIN_VALUE){
            throw new NumberFormatException("Número de colunas fora dos limites permitidos pelo tipo inteiro.");
        }
        this.matriz = new int [linha][coluna];
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
                try {
                    this.matriz[i][j] = IN.nextInt();
                } catch(NumberFormatException e){
                    System.out.printf("Informe um valor valido pra inteiros algo entre %d e %d", Integer.MAX_VALUE, Integer.MIN_VALUE);
                }
            }
        }
    }
    
    public int[][] somar(Matriz m) {
       int result[][];
       if(this.matriz.length == m.getMatriz().length &&
                this.matriz[0].length == m.getMatriz()[0].length){
           result = new int[this.matriz.length][this.matriz[0].length];
           for(int i = 0; i < this.matriz.length; i++){
               for(int j = 0; j < this.matriz[0].length; j++){
                   result[i][j] = this.matriz[i][j] + m.getMatriz()[i][j];
               }
           }
       }else{
           System.out.println("Operação não pode ser realizada pois as matrizes dadas tem número de linhas ou números de colunas diferentes");
           return null;
       }
       return result;
    }
    
    public int [][] multiplicar(Matriz m){
        int [][]result;
        if(this.matriz[0].length == m.getMatriz().length){
            // nova matriz com o numero de linhas da primeira com o numero de colunas da segunda;
            result = new int[this.matriz.length][m.getMatriz()[0].length];
            for(int i = 0; i < this.matriz.length; i++){
                for(int j = 0; j < this.getMatriz()[0].length; j++){
                    for(int k = 0; k < this.matriz[0].length; k++){
                        result[i][j] += this.matriz[i][k] * m.getMatriz()[k][j];
                    }
                }
            }
        }else{
            throw new IllegalArgumentException("As marizes não atendem os requisitos pra a multiplicação A[x][c] * B[c][y] = C[x][y]");
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
