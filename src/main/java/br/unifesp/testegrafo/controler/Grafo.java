/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unifesp.testegrafo.controler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Array;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author paulo.dias
 */
public class Grafo {

    /**
     * Metodo que le o arquivo e conta o numero de linhas
     *
     * @param nomeArq
     * @return numero de vertice
     */
    public int getNumeroVetice(String nomeArq) {
        int nVertice = 0;

        try {
            FileReader arq = new FileReader(nomeArq);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine(); // lê a primeira linha

            // a variável "linha" recebe o valor "null" quando o processo de repetição atingir o final do arquivo texto
            while (linha != null) {
                //System.out.printf("%s\n", linha);
                linha = lerArq.readLine(); // lê da segunda até a última linha

                // contando o numero de linhas para saber quantos vertices
                nVertice++;
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        return nVertice;
    }

    /**
     * Metodo que le o arquivo para montar a matriz
     *
     * @param nomeArq
     * @param nVertice
     * @return matriz preenchida
     */
    public int[][] getMatrizPeloArquivo(String nomeArq, int nVertice) {
        Scanner file = null;
        try {
            file = new Scanner(new File(nomeArq));
        } catch (FileNotFoundException ex) {
            System.out.println("Erro na abertura do arquivo");
        }

        int[][] m = new int[nVertice][nVertice];
        for (int i = 0; i < nVertice; i++) {
            for (int j = 0; j < nVertice; j++) {
                m[i][j] = file.nextInt();
            }
        }

        for (int i = 0; i < nVertice; i++) {
            for (int j = 0; j < nVertice; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        return m;
    }

    /**
     * Metodo para calcular o grau de cada vertice
     *
     * @param m Matriz do arquivo
     * @param nVertice
     * @return grau de cada vertice
     */
    public int[] calcGrau(int m[][]) {
        int grau[] = new int[m.length];
        for (int i = 0; i < m.length; i++) {
            grau[i] = 0;
            int cont = 0;
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 1) {
                    cont += 1;
                    grau[i] = cont;
                }
            }
        }
        return grau;
    }

    /**
     * Metodo para pegar o numero de Arestas da matriz
     *
     * @param m matriz
     * @return numero de arestas
     */
    public int getNumeroArestas(int m[][]) {
        int cont = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == 1) {
                    cont += 1;
                }
            }
        }
        return cont / 2;
    }

    /**
     * Metodo para calcular a media do grau <K>
     *
     * @param grau
     * @return media do grau
     */
    public int getMediaGrau(int grau[]) {
        int media = 0;
        for (int h : grau) {
            media += h;
        }
        media = media / grau.length;
        return media;
    }

    /**
     * Metodo para imprimir a lista
     *
     * @param matriz
     * @return
     */
    public String getListaAdj(int matriz[][]) {
        String resultList = "";
        int lista[][] = null;

        int vertce1[] = new int[matriz.length];
        int vertce2[] = new int[matriz.length];

        int cont = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = i; j < matriz.length; j++) {

                if (matriz[i][j] == 1) {
                    vertce1[cont] = i;
                    vertce2[cont] = j;
                    cont++;
                    resultList += i + " " + j + "\n";
                    System.out.print(i + " " + j + "\n");
                }
            }

        }
        return resultList;
    }

}
