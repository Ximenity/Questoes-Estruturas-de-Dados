# Questão 4 — Central de Suporte

## Objetivo
O objetivo da questão é criar um sistema de atendimento de solicitações utilizando três estruturas de dados: Fila, Pilha e Lista Encadeada.

O sistema possui solicitações normais, que são atendidas por ordem de chegada, e solicitações urgentes, que possuem prioridade e são atendidas primeiro.

## Como o código funciona

Foram criadas três estruturas diferentes:

- **Fila:** armazena as solicitações normais, seguindo a ordem de chegada (FIFO).
- **Pilha:** armazena as solicitações urgentes, atendendo primeiro a última que foi recebida (LIFO).
- **Lista Encadeada:** armazena o histórico dos atendimentos realizados.

## Métodos utilizados

### Fila
- `estaVazia()`: verifica se existem solicitações normais.
- `enfileirar()`: adiciona uma solicitação ao final da fila.
- `desenfileirar()`: remove a primeira solicitação.

### Pilha
- `estaVazia()`: verifica se existem solicitações urgentes.
- `empilhar()`: adiciona uma solicitação urgente.
- `desempilhar()`: remove a última solicitação adicionada.

### Histórico
- `estaVazio()`: verifica se existe algum atendimento registrado.
- `adicionarNoFinal()`: adiciona um atendimento ao histórico.
- `listar()`: mostra todos os atendimentos realizados.

## Comandos do programa

- `NORMAL X`: registra uma solicitação normal.
- `URGENTE X`: registra uma solicitação urgente.
- `ATENDER`: atende uma solicitação, dando prioridade às urgentes.
- `RELATORIO`: mostra o histórico dos atendimentos.

Quando não existem solicitações aguardando, o comando `ATENDER` retorna `VAZIA`. Se ainda não houver atendimentos realizados, `RELATORIO` retorna `VAZIO`.

## Leitura e saída

O programa utiliza `BufferedReader` para ler os comandos e `StringBuilder` para armazenar os resultados antes de exibi-los.

## Complexidade

As operações de inserção e remoção da fila e da pilha possuem complexidade O(1).

No histórico, a inserção no final também possui complexidade O(1), pois a estrutura mantém uma referência para o último nó. Já a listagem possui complexidade O(N), pois percorre todos os atendimentos registrados.

## Conclusão

A questão utiliza três estruturas de dados trabalhando juntas. A fila organiza as solicitações normais, a pilha controla as urgentes e a lista encadeada registra os atendimentos realizados. Assim, o sistema consegue respeitar as prioridades e manter um histórico dos serviços.