package Questao_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static final long BASE = 1_000_000L;

    static BufferedReader br;
    static StringTokenizer st;

   
    static int proximoInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    
    static void mergeSort(long[] v, long[] aux, int inicio, int fim) {
        if (inicio >= fim) return;

        int meio = inicio + (fim - inicio) / 2;
        mergeSort(v, aux, inicio, meio);
        mergeSort(v, aux, meio + 1, fim);
        intercalar(v, aux, inicio, meio, fim);
    }

    
    static void intercalar(long[] v, long[] aux, int inicio, int meio, int fim) {
        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while (i <= meio && j <= fim) {
            if (v[i] <= v[j]) {
                aux[k++] = v[i++];
            } else {
                aux[k++] = v[j++];
            }
        }
        while (i <= meio) {
            aux[k++] = v[i++];
        }
        while (j <= fim) {
            aux[k++] = v[j++];
        }

        for (k = inicio; k <= fim; k++) {
            v[k] = aux[k];
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = proximoInt();
        long[] chaves = new long[n];
        for (int i = 0; i < n; i++) {
            long peito = proximoInt();
            long tempo = proximoInt();
            chaves[i] = tempo * BASE + peito;
        }

        mergeSort(chaves, new long[n], 0, n - 1);

        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long tempo = chaves[i] / BASE;
            long peito = chaves[i] % BASE;
            saida.append(i + 1).append(' ')
                 .append(peito).append(' ')
                 .append(tempo).append('\n');
        }

        System.out.print(saida);
    }
}
