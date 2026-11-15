# Questão 8 — Diário de Rotações

## Objetivo
O objetivo da questão é implementar uma Árvore AVL, capaz de inserir valores e realizar rotações automaticamente para manter a árvore balanceada.

O programa também informa qual tipo de rotação foi realizada após cada inserção.

## Como o código funciona

Foi criada uma classe chamada `No`, que representa cada elemento da árvore. Cada nó armazena um valor, sua altura e referências para os filhos da esquerda e da direita.

A árvore AVL funciona de maneira semelhante a uma Árvore Binária de Busca, mas possui uma diferença: ela verifica seu equilíbrio após cada inserção e realiza rotações quando necessário.

## Métodos utilizados

- `altura()`: retorna a altura de um nó.
- `atualizarAltura()`: atualiza a altura de acordo com seus filhos.
- `fator()`: calcula o fator de equilíbrio do nó.
- `rotacaoDireita()`: realiza uma rotação para a direita.
- `rotacaoEsquerda()`: realiza uma rotação para a esquerda.
- `contem()`: verifica se um valor já existe na árvore.
- `inserir()`: adiciona um novo valor e verifica se é necessário realizar alguma rotação.
- `preOrdem()`: mostra os valores da árvore no percurso pré-ordem.

## Tipos de rotação

O programa identifica quatro casos de desequilíbrio:

- `ESQUERDA-ESQUERDA`: realiza uma rotação à direita.
- `DIREITA-DIREITA`: realiza uma rotação à esquerda.
- `ESQUERDA-DIREITA`: realiza duas rotações, primeiro à esquerda e depois à direita.
- `DIREITA-ESQUERDA`: realiza duas rotações, primeiro à direita e depois à esquerda.

Se nenhuma rotação for necessária, o programa imprime `SEM ROTACAO`. Caso o valor já exista na árvore, imprime `REPETIDO`.

## Comandos do programa

- `INSERIR X`: insere o valor X na árvore.
- `PREORDEM`: mostra os valores no percurso pré-ordem.
- `ALTURA`: informa a altura atual da árvore.

## Leitura e saída

O programa utiliza `BufferedReader` para receber os comandos e `StringBuilder` para armazenar as respostas antes de imprimir.

## Complexidade

Por ser uma árvore balanceada, as operações de inserção e busca possuem complexidade O(log N).

O percurso pré-ordem possui complexidade O(N), pois visita todos os nós da árvore. A consulta da altura da raiz é O(1), pois sua altura já fica armazenada.

## Conclusão

A Árvore AVL permite manter os dados organizados e equilibrados durante as inserções. Com as rotações, evita que a árvore fique muito desbalanceada, tornando as operações mais eficientes.