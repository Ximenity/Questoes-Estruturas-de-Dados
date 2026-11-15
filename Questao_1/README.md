# Questão 1 — Fila de Senhas de Atendimento

## Objetivo
O objetivo da questão é criar um sistema de atendimento utilizando uma fila, respeitando a ordem de chegada dos pacientes.

## Como o código funciona

Foi criada uma classe chamada `Fila`, que utiliza um vetor de inteiros para armazenar as senhas.

A fila segue o princípio FIFO (*First In, First Out*), ou seja, o primeiro elemento que entra é o primeiro que sai.

Foram utilizadas três variáveis principais:

- `dados`: armazena as senhas.
- `inicio`: indica a posição da primeira senha.
- `tamanho`: informa quantas senhas estão na fila.

Também foi utilizada uma fila circular, que permite reaproveitar os espaços do vetor depois que uma senha é atendida.

## Métodos utilizados

- `estaVazia()`: verifica se a fila está vazia.
- `enfileirar()`: adiciona uma nova senha ao final da fila.
- `primeiro()`: consulta a próxima senha sem removê-la.
- `desenfileirar()`: remove e retorna a primeira senha da fila.

## Comandos do programa

- `CHEGAR X`: adiciona a senha X na fila.
- `ATENDER`: remove e mostra a primeira senha.
- `PROXIMO`: mostra a próxima senha sem removê-la.

Quando não existem senhas aguardando, os comandos `ATENDER` e `PROXIMO` retornam `VAZIA`.

## Leitura e saída

O programa utiliza `BufferedReader` para ler os comandos informados pelo usuário e `StringBuilder` para guardar os resultados antes de exibi-los.

## Complexidade

As operações de inserção, consulta, remoção e verificação da fila possuem complexidade O(1), pois são realizadas diretamente pelas posições do vetor, sem precisar percorrer seus elementos.

## Conclusão

A implementação utiliza uma fila circular para organizar as senhas de atendimento. Dessa forma, o sistema consegue respeitar a ordem de chegada dos pacientes e realizar as operações de maneira eficiente.