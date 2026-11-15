package Questao_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static class No {
        int valor;
        int altura = 0; 
        No esquerda;
        No direita;

        No(int valor) {
            this.valor = valor;
        }
    }

    static class ArvoreAVL {
        private No raiz = null;
        
        private String caso;

        private int altura(No no) {
            return no == null ? -1 : no.altura;
        }

        private void atualizarAltura(No no) {
            no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        }

        private int fator(No no) {
            return altura(no.esquerda) - altura(no.direita);
        }

        
        private No rotacaoDireita(No y) {
            No x = y.esquerda;
            y.esquerda = x.direita;
            x.direita = y;
            atualizarAltura(y);
            atualizarAltura(x);
            return x;
        }

        
        private No rotacaoEsquerda(No x) {
            No y = x.direita;
            x.direita = y.esquerda;
            y.esquerda = x;
            atualizarAltura(x);
            atualizarAltura(y);
            return y;
        }

        private boolean contem(int x) {
            No atual = raiz;
            while (atual != null) {
                if (x == atual.valor) return true;
                atual = (x < atual.valor) ? atual.esquerda : atual.direita;
            }
            return false;
        }

        
        String inserir(int x) {
            if (contem(x)) return "REPETIDO";
            caso = "SEM ROTACAO";
            raiz = inserir(raiz, x);
            return caso;
        }

        private No inserir(No no, int x) {
            if (no == null) return new No(x);

            if (x < no.valor) {
                no.esquerda = inserir(no.esquerda, x);
            } else {
                no.direita = inserir(no.direita, x);
            }

            atualizarAltura(no);
            int f = fator(no);

            if (f > 1) { // lado esquerdo pesado
                if (fator(no.esquerda) >= 0) {
                    caso = "ESQUERDA-ESQUERDA";
                    return rotacaoDireita(no);
                } else {
                    caso = "ESQUERDA-DIREITA";
                    no.esquerda = rotacaoEsquerda(no.esquerda);
                    return rotacaoDireita(no);
                }
            }
            if (f < -1) { // lado direito pesado
                if (fator(no.direita) <= 0) {
                    caso = "DIREITA-DIREITA";
                    return rotacaoEsquerda(no);
                } else {
                    caso = "DIREITA-ESQUERDA";
                    no.direita = rotacaoDireita(no.direita);
                    return rotacaoEsquerda(no);
                }
            }
            return no;
        }

        int altura() {
            return altura(raiz);
        }

        String preOrdem() {
            StringBuilder sb = new StringBuilder();
            preOrdem(raiz, sb);
            return sb.length() == 0 ? "VAZIA" : sb.toString().trim();
        }

        private void preOrdem(No no, StringBuilder sb) {
            if (no == null) return;
            sb.append(no.valor).append(' ');
            preOrdem(no.esquerda, sb);
            preOrdem(no.direita, sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        ArvoreAVL arvore = new ArvoreAVL();
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
                saida.append(arvore.inserir(Integer.parseInt(partes[1]))).append('\n');
            } else if (comando.equals("PREORDEM")) {
                saida.append(arvore.preOrdem()).append('\n');
            } else if (comando.equals("ALTURA")) {
                saida.append(arvore.altura()).append('\n');
            }
        }

        System.out.print(saida);
    }
}
