# Questão 7 — Catálogo de Livros

## Objetivo
O objetivo da questão é criar um sistema para armazenar e organizar códigos de livros utilizando uma Árvore Binária de Busca.

A estrutura permite inserir, buscar, remover e mostrar os códigos cadastrados.

## Como o código funciona

Foi criada uma classe chamada `No`, que representa cada elemento da árvore. Cada nó possui um código e duas referências: uma para o filho da esquerda e outra para o filho da direita.

A árvore segue uma regra: valores menores ficam à esquerda e valores maiores ficam à direita. Códigos repetidos são ignorados.

## Métodos utilizados

- `inserir()`: adiciona um novo código na posição correta da árvore.
- `contem()`: verifica se determinado código existe.
- `buscar()`: procura um código e mostra o caminho percorrido.
- `remover()`: remove um código da árvore, considerando os casos de remoção.
- `emOrdem()`: mostra os códigos em ordem crescente.
- `preOrdem()`: mostra primeiro a raiz e depois seus filhos.
- `altura()`: calcula a altura da árvore.

## Comandos do programa

- `INSERIR X`: adiciona o código X.
- `BUSCAR X`: procura o código X e mostra o caminho percorrido.
- `REMOVER X`: remove o código X.
- `EMORDEM`: mostra os códigos em ordem crescente.
- `PREORDEM`: mostra os códigos no percurso pré-ordem.
- `ALTURA`: informa a altura da árvore.

Se um código não existir durante uma remoção, o programa imprime `ERRO`. Quando a árvore está vazia, os percursos retornam `VAZIA`.

## Funcionamento da remoção

A remoção considera três situações:

- Quando o nó não possui filhos, ele é removido diretamente.
- Quando possui apenas um filho, esse filho ocupa seu lugar.
- Quando possui dois filhos, é utilizado o sucessor, que é o menor valor da subárvore direita.

## Leitura e saída

O programa utiliza `BufferedReader` para ler os comandos e `StringBuilder` para armazenar os resultados antes de imprimir.

Também foi utilizada uma `Thread` com uma pilha maior para ajudar a suportar árvores muito desbalanceadas durante os percursos recursivos.

## Complexidade

As operações de inserção, busca e remoção dependem da altura da árvore. Em uma árvore equilibrada, possuem complexidade O(log N). No pior caso, quando a árvore fica desbalanceada, podem chegar a O(N).

Os percursos e o cálculo da altura possuem complexidade O(N), pois precisam visitar os nós da árvore.

## Conclusão

A Árvore Binária de Busca permite organizar os códigos de forma hierárquica, facilitando as operações de busca, inserção e remoção. Além disso, o percurso em ordem permite exibir os códigos em ordem crescente.