# Questão 6 — Classificação da Corrida

## Objetivo
O objetivo da questão é organizar os atletas de acordo com seus tempos de corrida, do menor para o maior. Quando dois atletas possuem o mesmo tempo, fica na frente aquele que tem o menor número de peito.

## Como o código funciona

Foi utilizado o algoritmo **Merge Sort**, que divide o vetor em partes menores, organiza essas partes e depois junta tudo novamente em ordem crescente.

Os dados dos atletas são armazenados em um vetor do tipo `long`, utilizando uma chave que combina o tempo e o número de peito.

## Métodos utilizados

- `proximoInt()`: realiza a leitura dos números informados na entrada.
- `mergeSort()`: divide o vetor em partes menores até chegar a elementos individuais.
- `intercalar()`: junta as partes do vetor, colocando os valores na ordem correta.

## Funcionamento da ordenação

O programa recebe o número de peito e o tempo de cada atleta.

Para organizar os dados, utiliza a seguinte expressão:

`tempo * BASE + peito`

A constante `BASE` é utilizada para combinar as duas informações em um único número, permitindo ordenar primeiro pelo tempo e depois pelo número de peito.

Depois que o Merge Sort termina a ordenação, o programa recupera os valores originais e imprime a classificação de cada atleta, começando pela posição 1.

## Saída

Para cada atleta, o programa imprime três informações:

- Posição na classificação.
- Número de peito.
- Tempo de corrida.

## Complexidade

O Merge Sort possui complexidade O(N log N) no melhor, médio e pior caso. Ele também utiliza um vetor auxiliar durante a ordenação, ocupando espaço O(N).

## Conclusão

O Merge Sort foi escolhido porque consegue ordenar grandes quantidades de dados de maneira eficiente. Com ele, o programa organiza os atletas pelo tempo e resolve os empates utilizando o número de peito.