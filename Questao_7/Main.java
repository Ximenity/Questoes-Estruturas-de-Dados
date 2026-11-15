package Questao_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static class No {
        int codigo;
        No esquerda;
        No direita;

        No(int codigo) {
            this.codigo = codigo;
        }
    }

    static class ArvoreBinariaBusca {
        private No raiz = null;

       
        boolean contem(int x) {
            No atual = raiz;
            while (atual != null) {
                if (x == atual.codigo) return true;
                atual = (x < atual.codigo) ? atual.esquerda : atual.direita;
            }
            return false;
        }

        
        void inserir(int x) {
            if (raiz == null) {
                raiz = new No(x);
                return;
            }
            No atual = raiz;
            while (true) {
                if (x == atual.codigo) return;
                if (x < atual.codigo) {
                    if (atual.esquerda == null) {
                        atual.esquerda = new No(x);
                        return;
                    }
                    atual = atual.esquerda;
                } else {
                    if (atual.direita == null) {
                        atual.direita = new No(x);
                        return;
                    }
                    atual = atual.direita;
                }
            }
        }

        
        String buscar(int x) {
            StringBuilder sb = new StringBuilder();
            No atual = raiz;
            while (atual != null) {
                sb.append(atual.codigo).append(' ');
                if (x == atual.codigo) {
                    sb.append("SIM");
                    return sb.toString();
                }
                atual = (x < atual.codigo) ? atual.esquerda : atual.direita;
            }
            sb.append("NAO");
            return sb.toString();
        }

        
        boolean remover(int x) {
            if (!contem(x)) return false;
            raiz = remover(raiz, x);
            return true;
        }

        private No remover(No no, int x) {
            if (no == null) return null;

            if (x < no.codigo) {
                no.esquerda = remover(no.esquerda, x);
            } else if (x > no.codigo) {
                no.direita = remover(no.direita, x);
            } else {
                
                if (no.esquerda == null) return no.direita;
                if (no.direita == null) return no.esquerda;

                
                No sucessor = no.direita;
                while (sucessor.esquerda != null) {
                    sucessor = sucessor.esquerda;
                }
                no.codigo = sucessor.codigo;
                no.direita = remover(no.direita, sucessor.codigo);
            }
            return no;
        }

        String emOrdem() {
            StringBuilder sb = new StringBuilder();
            emOrdem(raiz, sb);
            return sb.length() == 0 ? "VAZIA" : sb.toString().trim();
        }

        private void emOrdem(No no, StringBuilder sb) {
            if (no == null) return;
            emOrdem(no.esquerda, sb);
            sb.append(no.codigo).append(' ');
            emOrdem(no.direita, sb);
        }

        String preOrdem() {
            StringBuilder sb = new StringBuilder();
            preOrdem(raiz, sb);
            return sb.length() == 0 ? "VAZIA" : sb.toString().trim();
        }

        private void preOrdem(No no, StringBuilder sb) {
            if (no == null) return;
            sb.append(no.codigo).append(' ');
            preOrdem(no.esquerda, sb);
            preOrdem(no.direita, sb);
        }

        
        int altura() {
            return altura(raiz);
        }

        private int altura(No no) {
            if (no == null) return -1;
            return 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }
    }

    static void resolver() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
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

            if (comando.equals("INSERIR")) {
                arvore.inserir(Integer.parseInt(partes[1]));
            } else if (comando.equals("BUSCAR")) {
                saida.append(arvore.buscar(Integer.parseInt(partes[1]))).append('\n');
            } else if (comando.equals("REMOVER")) {
                if (!arvore.remover(Integer.parseInt(partes[1]))) {
                    saida.append("ERRO\n");
                }
            } else if (comando.equals("EMORDEM")) {
                saida.append(arvore.emOrdem()).append('\n');
            } else if (comando.equals("PREORDEM")) {
                saida.append(arvore.preOrdem()).append('\n');
            } else if (comando.equals("ALTURA")) {
                saida.append(arvore.altura()).append('\n');
            }
        }

        System.out.print(saida);
    }

    public static void main(String[] args) throws InterruptedException {
        // pilha de 128 MB para suportar árvores muito desbalanceadas
        Thread thread = new Thread(null, () -> {
            try {
                resolver();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }, "solucao", 1L << 27);
        thread.start();
        thread.join();
    }
}