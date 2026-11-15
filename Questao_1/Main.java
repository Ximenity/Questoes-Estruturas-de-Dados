package Questao_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static class Fila {
        private final int[] dados;
        private int inicio = 0;   
        private int tamanho = 0;  

        Fila(int capacidade) {
            dados = new int[capacidade];
        }

        boolean estaVazia() {
            return tamanho == 0;
        }

        void enfileirar(int x) {
            int fim = (inicio + tamanho) % dados.length;
            dados[fim] = x;
            tamanho++;
        }

        int primeiro() {
            return dados[inicio];
        }

        int desenfileirar() {
            int x = dados[inicio];
            inicio = (inicio + 1) % dados.length;
            tamanho--;
            return x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        
        Fila fila = new Fila(n + 1);
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String linha = br.readLine();
            if (linha == null) break;
            linha = linha.trim();
            if (linha.isEmpty()) {
                i--; 
                continue;
            }

            String[] partes = linha.split("\\s+");
            String comando = partes[0];

            if (comando.equals("CHEGAR")) {
                fila.enfileirar(Integer.parseInt(partes[1]));
            } else if (comando.equals("ATENDER")) {
                if (fila.estaVazia()) {
                    saida.append("VAZIA\n");
                } else {
                    saida.append(fila.desenfileirar()).append('\n');
                }
            } else if (comando.equals("PROXIMO")) {
                if (fila.estaVazia()) {
                    saida.append("VAZIA\n");
                } else {
                    saida.append(fila.primeiro()).append('\n');
                }
            }
        }

        System.out.print(saida);
    }
}