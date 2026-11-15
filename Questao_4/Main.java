package Questao_4;

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
            dados[(inicio + tamanho) % dados.length] = x;
            tamanho++;
        }

        int desenfileirar() {
            int x = dados[inicio];
            inicio = (inicio + 1) % dados.length;
            tamanho--;
            return x;
        }
    }


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

        int desempilhar() {
            return dados[--tamanho];
        }
    }

    static class No {
        int codigo;
        No proximo;

        No(int codigo) {
            this.codigo = codigo;
        }
    }

    static class Historico {
        private No inicio = null;
        private No fim = null;

        boolean estaVazio() {
            return inicio == null;
        }

        void adicionarNoFinal(int codigo) {
            No novo = new No(codigo);
            if (inicio == null) {
                inicio = novo;
            } else {
                fim.proximo = novo;
            }
            fim = novo;
        }

        String listar() {
            if (inicio == null) return "VAZIO";
            StringBuilder sb = new StringBuilder();
            No atual = inicio;
            while (atual != null) {
                sb.append(atual.codigo);
                if (atual.proximo != null) sb.append(' ');
                atual = atual.proximo;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

      
        Fila normais = new Fila(n + 1);
        Pilha urgentes = new Pilha(n + 1);
        Historico historico = new Historico();
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

            if (comando.equals("NORMAL")) {
                normais.enfileirar(Integer.parseInt(partes[1]));
            } else if (comando.equals("URGENTE")) {
                urgentes.empilhar(Integer.parseInt(partes[1]));
            } else if (comando.equals("ATENDER")) {
                int codigo;
                if (!urgentes.estaVazia()) {
                    codigo = urgentes.desempilhar(); // urgente tem prioridade
                } else if (!normais.estaVazia()) {
                    codigo = normais.desenfileirar();
                } else {
                    saida.append("VAZIA\n");
                    continue;
                }
                historico.adicionarNoFinal(codigo);
                saida.append(codigo).append('\n');
            } else if (comando.equals("RELATORIO")) {
                saida.append(historico.listar()).append('\n');
            }
        }

        System.out.print(saida);
    }
}
