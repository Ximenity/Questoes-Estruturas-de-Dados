# Questão 3 — Sequência de Robôs

## Objetivo
O objetivo da questão é criar um sistema para organizar uma sequência de robôs, permitindo inserir, remover, consultar e listar seus códigos em diferentes posições.

## Como o código funciona

Foi utilizada uma **Lista Simplesmente Encadeada**, implementada por meio de nós que armazenam o código de cada robô e uma referência para o próximo elemento.

A classe `No` representa cada elemento da lista, enquanto a classe `ListaEncadeada` controla toda a estrutura.

As principais variáveis são:

- `inicio`: aponta para o primeiro elemento da lista.
- `tamanho`: guarda a quantidade de robôs cadastrados.
- `proximo`: aponta para o próximo nó da sequência.

## Métodos utilizados

- `noNaPosicao()`: percorre a lista até encontrar uma determinada posição.
- `inserir()`: adiciona um novo robô na posição indicada.
- `remover()`: remove um robô e retorna seu código.
- `consultar()`: mostra o código de um robô sem removê-lo.
- `listar()`: percorre a lista e mostra todos os códigos cadastrados.

## Comandos do programa

- `I P X`: insere o robô X na posição P.
- `R P`: remove e mostra o robô da posição P.
- `C P`: consulta o robô da posição P.
- `L`: mostra toda a sequência de robôs.

O programa também verifica se as posições informadas são válidas. Caso uma operação de inserção, remoção ou consulta seja inválida, imprime `ERRO`. Se a lista estiver vazia ao executar `L`, imprime `VAZIA`.

## Leitura e saída

Foi utilizado `BufferedReader` para receber os comandos e `StringBuilder` para armazenar os resultados antes de exibi-los.

## Complexidade

As operações de inserção, remoção e consulta podem ter complexidade O(N), pois é necessário percorrer a lista até encontrar a posição desejada.

A listagem também possui complexidade O(N), pois percorre todos os elementos.

## Conclusão

A lista simplesmente encadeada permite organizar os robôs em sequência e realizar alterações em diferentes posições. Sua utilização facilita a inserção e remoção de elementos sem precisar deslocar os demais, como aconteceria em um vetor.