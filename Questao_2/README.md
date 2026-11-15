# Questão 2 — Manobra dos Vagões

## Objetivo
O objetivo da questão é verificar se uma determinada ordem de saída dos vagões pode ser realizada utilizando um desvio ferroviário. Para isso, foi utilizada a estrutura de dados Pilha.

## Como o código funciona

Foi criada uma classe chamada `Pilha`, que utiliza um vetor de inteiros para armazenar os vagões.

A pilha segue o princípio LIFO (*Last In, First Out*), ou seja, o último elemento que entra é o primeiro que sai.

As principais variáveis utilizadas são:

- `dados`: armazena os números dos vagões.
- `tamanho`: controla a quantidade de elementos na pilha.

## Métodos utilizados

- `estaVazia()`: verifica se a pilha está vazia.
- `empilhar()`: adiciona um vagão ao desvio.
- `topo()`: consulta o último vagão que entrou na pilha.
- `desempilhar()`: remove o vagão que está no topo.

## Funcionamento do programa

O programa primeiro lê a quantidade de casos de teste e, em seguida, a quantidade de vagões de cada caso.

A variável `proximoVagao` controla qual é o próximo vagão que ainda precisa entrar no desvio.

Para cada vagão da sequência desejada, o programa coloca os vagões no desvio até alcançar o número solicitado. Depois, verifica se esse vagão está no topo da pilha.

- Se estiver, ele é removido e pode seguir para a saída.
- Se não estiver, significa que aquela ordem não pode ser realizada.

Ao final de cada caso, o programa imprime `SIM` quando a sequência é possível ou `NAO` quando não é possível.

## Leitura e saída

Foram utilizados `BufferedReader` e `StringTokenizer` para facilitar a leitura dos números, mesmo quando estão separados em diferentes linhas.

O `StringBuilder` guarda os resultados dos casos de teste antes de imprimir tudo no final.

## Complexidade

Cada vagão entra e sai do desvio no máximo uma vez. Por isso, o processamento de cada caso possui complexidade O(N), com espaço O(N) para armazenar a pilha.

## Conclusão

A pilha foi utilizada para representar o desvio ferroviário, pois permite que somente o último vagão colocado seja retirado primeiro. Dessa forma, o programa consegue verificar se a ordem de saída solicitada é possível.