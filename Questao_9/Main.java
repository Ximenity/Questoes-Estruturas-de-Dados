package Questao_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static class Paciente {
        String nome;
        int prioridade;
        int ordem; 

        Paciente(String nome, int prioridade, int ordem) {
            this.nome = nome;
            this.prioridade = prioridade;
            this.ordem = ordem;
        }
    }

    static class HeapMaximo {
        private final Paciente[] dados;
        private int tamanho = 0;

        HeapMaximo(int capacidade) {
            dados = new Paciente[capacidade];
        }

        boolean estaVazio() {
            return tamanho == 0;
        }

        // true se a deve ser atendido antes de b
        private boolean vemAntes(Paciente a, Paciente b) {
            if (a.prioridade != b.prioridade) {
                return a.prioridade > b.prioridade;
            }
            return a.ordem < b.ordem;
        }

        private void trocar(int i, int j) {
            Paciente aux = dados[i];
            dados[i] = dados[j];
            dados[j] = aux;
        }

        private void subir(int i) {
            while (i > 0) {
                int pai = (i - 1) / 2;
                if (vemAntes(dados[i], dados[pai])) {
                    trocar(i, pai);
                    i = pai;
                } else {
                    break;
                }
            }
        }

        private void descer(int i) {
            while (true) {
                int esquerda = 2 * i + 1;
                int direita = 2 * i + 2;
                int melhor = i;

                if (esquerda < tamanho && vemAntes(dados[esquerda], dados[melhor])) {
                    melhor = esquerda;
                }
                if (direita < tamanho && vemAntes(dados[direita], dados[melhor])) {
                    melhor = direita;
                }
                if (melhor == i) break;

                trocar(i, melhor);
                i = melhor;
            }
        }

        void inserir(Paciente p) {
            dados[tamanho] = p;
            subir(tamanho);
            tamanho++;
        }

        Paciente proximo() {
            return dados[0];
        }

        Paciente remover() {
            Paciente topo = dados[0];
            tamanho--;
            dados[0] = dados[tamanho];
            dados[tamanho] = null;
            if (tamanho > 0) {
                descer(0);
            }
            return topo;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        HeapMaximo heap = new HeapMaximo(n);
        int ordemChegada = 0;
        StringBuilder saida = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String linha = br.readLine();
            if (linha == null) break;
            linha = linha.trim();
            if (linha.isEmpty()) {
                i--; // ignora linhas em branco
                continue;
            }

            String[] partes = linha.split("\\s+");
            String comando = partes[0];

            if (comando.equals("CHEGAR")) {
                ordemChegada++;
                heap.inserir(new Paciente(partes[1], Integer.parseInt(partes[2]), ordemChegada));
            } else if (comando.equals("ATENDER")) {
                if (heap.estaVazio()) {
                    saida.append("VAZIA\n");
                } else {
                    Paciente p = heap.remover();
                    saida.append(p.nome).append(' ').append(p.prioridade).append('\n');
                }
            } else if (comando.equals("PROXIMO")) {
                if (heap.estaVazio()) {
                    saida.append("VAZIA\n");
                } else {
                    Paciente p = heap.proximo();
                    saida.append(p.nome).append(' ').append(p.prioridade).append('\n');
                }
            }
        }

        System.out.print(saida);
    }
}
    
