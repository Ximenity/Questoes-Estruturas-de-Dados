package Questao_5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br;
    static StringTokenizer st;

    
    static int proximoInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int n = proximoInt();
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = proximoInt();
        }

        int q = proximoInt();
        StringBuilder saida = new StringBuilder();

        while (q-- > 0) {
            int alvo = proximoInt();

            
            int posicao = -1;
            int comparacoesLinear = 0;
            for (int i = 0; i < n; i++) {
                comparacoesLinear++;
                if (v[i] == alvo) {
                    posicao = i;
                    break;
                }
            }

            
            int comparacoesBinaria = 0;
            int inicio = 0;
            int fim = n - 1;
            while (inicio <= fim) {
                comparacoesBinaria++;
                int meio = inicio + (fim - inicio) / 2;
                if (v[meio] == alvo) {
                    break;
                } else if (v[meio] < alvo) {
                    inicio = meio + 1;
                } else {
                    fim = meio - 1;
                }
            }

            saida.append(posicao).append(' ')
                 .append(comparacoesLinear).append(' ')
                 .append(comparacoesBinaria).append('\n');
        }

        System.out.print(saida);
    }
}