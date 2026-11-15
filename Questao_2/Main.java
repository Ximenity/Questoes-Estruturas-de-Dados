package Questao_2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Pilha {
        private final int[] dados;
        private int tamanho = 0;

        Pilha(int capacidade) {
            dados = new int[capacidade];
        }

        boolean estaVazia() {
            return tamanho == 0;
        }

        void empilhar(int x) {
            dados[tamanho++] = x;
        }

        int topo() {
            return dados[tamanho - 1];
        }

        int desempilhar() {
            return dados[--tamanho];
        }
    }

    static BufferedReader br;
    static StringTokenizer st;

    // lê o próximo número, mesmo que a entrada esteja quebrada em linhas diferentes
    static int proximoInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = proximoInt();
        StringBuilder saida = new StringBuilder();

        while (t-- > 0) {
            int n = proximoInt();
            Pilha desvio = new Pilha(n);
            int proximoVagao = 1; 
            boolean possivel = true;

            for (int i = 0; i < n; i++) {
                int desejado = proximoInt();
                if (!possivel) continue; 

                
                while (proximoVagao <= desejado) {
                    desvio.empilhar(proximoVagao++);
                }

                
                if (!desvio.estaVazia() && desvio.topo() == desejado) {
                    desvio.desempilhar();
                } else {
                    possivel = false;
                }
            }

            saida.append(possivel ? "SIM" : "NAO").append('\n');
        }

        System.out.print(saida);
    }
}