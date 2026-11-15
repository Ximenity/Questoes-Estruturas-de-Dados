package Questao_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static class No {
        int codigo;
        No proximo;

        No(int codigo) {
            this.codigo = codigo;
        }
    }

    static class ListaEncadeada {
        private No inicio = null;
        private int tamanho = 0;

        
        private No noNaPosicao(int p) {
            No atual = inicio;
            for (int i = 1; i < p; i++) {
                atual = atual.proximo;
            }
            return atual;
        }

        boolean inserir(int p, int x) {
            if (p < 1 || p > tamanho + 1) return false;
            No novo = new No(x);
            if (p == 1) {
                novo.proximo = inicio;
                inicio = novo;
            } else {
                No anterior = noNaPosicao(p - 1);
                novo.proximo = anterior.proximo;
                anterior.proximo = novo;
            }
            tamanho++;
            return true;
        }

        
        int remover(int p) {
            if (p < 1 || p > tamanho) return -1;
            int codigo;
            if (p == 1) {
                codigo = inicio.codigo;
                inicio = inicio.proximo;
            } else {
                No anterior = noNaPosicao(p - 1);
                codigo = anterior.proximo.codigo;
                anterior.proximo = anterior.proximo.proximo;
            }
            tamanho--;
            return codigo;
        }

        
        int consultar(int p) {
            if (p < 1 || p > tamanho) return -1;
            return noNaPosicao(p).codigo;
        }

        String listar() {
            if (tamanho == 0) return "VAZIA";
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

        ListaEncadeada lista = new ListaEncadeada();
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

            if (comando.equals("I")) {
                int p = Integer.parseInt(partes[1]);
                int x = Integer.parseInt(partes[2]);
                if (!lista.inserir(p, x)) {
                    saida.append("ERRO\n");
                }
            } else if (comando.equals("R")) {
                int p = Integer.parseInt(partes[1]);
                int removido = lista.remover(p);
                saida.append(removido == -1 ? "ERRO" : String.valueOf(removido)).append('\n');
            } else if (comando.equals("C")) {
                int p = Integer.parseInt(partes[1]);
                int codigo = lista.consultar(p);
                saida.append(codigo == -1 ? "ERRO" : String.valueOf(codigo)).append('\n');
            } else if (comando.equals("L")) {
                saida.append(lista.listar()).append('\n');
            }
        }

        System.out.print(saida);
    }
}
