package Questao_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static class No {
        long matricula;
        String nome;
        No proximo;

        No(long matricula, String nome) {
            this.matricula = matricula;
            this.nome = nome;
        }
    }

    static class TabelaHash {
        private static final int CAPACIDADE_INICIAL = 16;
        private static final double FATOR_DE_CARGA_MAXIMO = 0.75;

        private No[] tabela = new No[CAPACIDADE_INICIAL];
        private int quantidade = 0;

        int total() {
            return quantidade;
        }

        private int indice(long matricula, int capacidade) {
            long h = matricula * 0x9E3779B97F4A7C15L;
            h ^= (h >>> 32);
            return (int) ((h & 0x7FFFFFFFL) % capacidade);
        }

        
        boolean cadastrar(long matricula, String nome) {
            int i = indice(matricula, tabela.length);

            for (No atual = tabela[i]; atual != null; atual = atual.proximo) {
                if (atual.matricula == matricula) {
                    atual.nome = nome;
                    return false;
                }
            }

            No novo = new No(matricula, nome);
            novo.proximo = tabela[i];
            tabela[i] = novo;
            quantidade++;

            if ((double) quantidade / tabela.length > FATOR_DE_CARGA_MAXIMO) {
                redimensionar();
            }
            return true;
        }

        
        String buscar(long matricula) {
            int i = indice(matricula, tabela.length);
            for (No atual = tabela[i]; atual != null; atual = atual.proximo) {
                if (atual.matricula == matricula) {
                    return atual.nome;
                }
            }
            return null;
        }

       
        boolean remover(long matricula) {
            int i = indice(matricula, tabela.length);
            No anterior = null;
            No atual = tabela[i];

            while (atual != null) {
                if (atual.matricula == matricula) {
                    if (anterior == null) {
                        tabela[i] = atual.proximo;
                    } else {
                        anterior.proximo = atual.proximo;
                    }
                    quantidade--;
                    return true;
                }
                anterior = atual;
                atual = atual.proximo;
            }
            return false;
        }

        
        private void redimensionar() {
            No[] nova = new No[tabela.length * 2];

            for (int b = 0; b < tabela.length; b++) {
                No atual = tabela[b];
                while (atual != null) {
                    No proximo = atual.proximo; // guarda antes de religar o nó
                    int i = indice(atual.matricula, nova.length);
                    atual.proximo = nova[i];
                    nova[i] = atual;
                    atual = proximo;
                }
            }
            tabela = nova;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        TabelaHash tabela = new TabelaHash();
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

            if (comando.equals("CADASTRAR")) {
                long matricula = Long.parseLong(partes[1]);
                boolean nova = tabela.cadastrar(matricula, partes[2]);
                saida.append(nova ? "CADASTRADO" : "ATUALIZADO").append('\n');
            } else if (comando.equals("BUSCAR")) {
                String nome = tabela.buscar(Long.parseLong(partes[1]));
                saida.append(nome == null ? "NAO ENCONTRADO" : nome).append('\n');
            } else if (comando.equals("REMOVER")) {
                boolean removido = tabela.remover(Long.parseLong(partes[1]));
                saida.append(removido ? "REMOVIDO" : "NAO ENCONTRADO").append('\n');
            } else if (comando.equals("TOTAL")) {
                saida.append(tabela.total()).append('\n');
            }
        }

        System.out.print(saida);
    }
}
