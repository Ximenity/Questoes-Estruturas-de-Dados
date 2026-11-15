# Questão 9 — Triagem no Pronto-Socorro

## Objetivo
O objetivo da questão é criar um sistema de atendimento de pacientes utilizando um Heap Máximo, dando prioridade aos casos mais graves.

Quando dois pacientes possuem a mesma prioridade, o atendimento respeita a ordem de chegada.

## Como o código funciona

Foram criadas duas classes principais:

- `Paciente`: armazena o nome, a prioridade e a ordem de chegada de cada paciente.
- `HeapMaximo`: organiza os pacientes em um vetor, mantendo aquele que deve ser atendido primeiro na posição inicial.

O Heap Máximo considera primeiro a maior prioridade. Quando existe empate, utiliza a ordem de chegada para decidir quem será atendido antes.

## Métodos utilizados

- `estaVazio()`: verifica se existem pacientes aguardando.
- `vemAntes()`: compara dois pacientes para identificar qual possui prioridade no atendimento.
- `trocar()`: troca a posição de dois pacientes no vetor.
- `subir()`: reorganiza o heap após uma inserção.
- `descer()`: reorganiza o heap após uma remoção.
- `inserir()`: adiciona um novo paciente.
- `proximo()`: consulta o paciente que será atendido primeiro.
- `remover()`: remove o paciente que está na primeira posição do heap.

## Comandos do programa

- `CHEGAR NOME P`: registra um paciente com nome e prioridade.
- `ATENDER`: remove e mostra o paciente que será atendido.
- `PROXIMO`: mostra o próximo paciente sem removê-lo.

Se não houver pacientes aguardando, os comandos `ATENDER` e `PROXIMO` retornam `VAZIA`.

## Funcionamento do atendimento

Quando um paciente chega, ele recebe um número de ordem de chegada.

O programa compara os pacientes considerando dois critérios:

1. Maior prioridade de atendimento.
2. Menor número de ordem de chegada, em caso de empate.

Assim, os pacientes mais graves são atendidos primeiro, sem desrespeitar a ordem de chegada entre pacientes com a mesma prioridade.

## Leitura e saída

O programa utiliza `BufferedReader` para ler os comandos e `StringBuilder` para armazenar os resultados antes de imprimir.

## Complexidade

- Inserção: O(log N).
- Remoção: O(log N).
- Consulta do próximo paciente: O(1).

O Heap Máximo permite encontrar rapidamente o paciente que deve ser atendido, sem precisar percorrer todos os elementos.

## Conclusão

O Heap Máximo foi utilizado para organizar os pacientes de acordo com suas prioridades. Dessa forma, o sistema consegue atender primeiro os casos mais graves e manter a ordem de chegada quando as prioridades são iguais.