# Questão 10 — Cadastro de Matrículas

## Objetivo
O objetivo da questão é criar um sistema de cadastro de alunos utilizando uma Tabela Hash, permitindo cadastrar, buscar, atualizar e remover matrículas.

## Como o código funciona

Foi criada uma classe chamada `No`, que armazena a matrícula, o nome do aluno e uma referência para o próximo elemento.

Também foi criada a classe `TabelaHash`, responsável por organizar os cadastros em um vetor.

Como as matrículas são números grandes, foi utilizada uma função hash para transformar cada matrícula em um índice do vetor.

Quando duas matrículas são direcionadas para a mesma posição, é utilizado o encadeamento, que permite armazenar vários elementos na mesma posição por meio de uma lista encadeada.

## Métodos utilizados

- `total()`: retorna a quantidade de alunos cadastrados.
- `indice()`: calcula a posição da matrícula na tabela.
- `cadastrar()`: adiciona um novo aluno ou atualiza seu nome caso a matrícula já exista.
- `buscar()`: procura uma matrícula e retorna o nome do aluno.
- `remover()`: remove um aluno da tabela.
- `redimensionar()`: aumenta o tamanho da tabela quando o fator de carga ultrapassa 0,75.

## Comandos do programa

- `CADASTRAR M NOME`: cadastra um aluno ou atualiza seu nome.
- `BUSCAR M`: procura o aluno pela matrícula.
- `REMOVER M`: remove o aluno cadastrado.
- `TOTAL`: mostra a quantidade de alunos cadastrados.

O programa informa `CADASTRADO` para novas matrículas e `ATUALIZADO` quando o nome de uma matrícula existente é alterado. Também informa quando uma matrícula não é encontrada.

## Funcionamento da tabela

A tabela começa com capacidade de 16 posições.

Quando o fator de carga ultrapassa 0,75, seu tamanho é dobrado. Os elementos são então reorganizados de acordo com os novos índices calculados pela função hash.

Isso ajuda a manter as operações eficientes mesmo com o aumento da quantidade de alunos cadastrados.

## Leitura e saída

O programa utiliza `BufferedReader` para receber os comandos e `StringBuilder` para armazenar os resultados antes de imprimir.

As matrículas são armazenadas utilizando o tipo `long`, pois podem possuir valores maiores que os suportados pelo tipo `int`.

## Complexidade

As operações de cadastro, busca e remoção possuem complexidade média O(1).

No pior caso, quando muitos elementos ficam na mesma posição, essas operações podem chegar a O(N).

O redimensionamento possui custo O(N), pois precisa reorganizar os elementos da tabela.

## Conclusão

A Tabela Hash foi utilizada para permitir o acesso rápido aos dados dos alunos. Com o uso de encadeamento e redimensionamento automático, o sistema consegue lidar com colisões e manter um bom desempenho conforme novos cadastros são realizados.