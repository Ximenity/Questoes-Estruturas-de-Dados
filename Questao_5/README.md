# Questão 5 — Linear contra Binária

## Objetivo
O objetivo da questão é comparar a quantidade de comparações realizadas pela busca linear e pela busca binária em um vetor ordenado.

## Como o código funciona

Primeiro, o programa lê a quantidade de números e armazena os valores em um vetor. Depois, recebe a quantidade de consultas e verifica cada valor solicitado utilizando os dois métodos de busca.

## Métodos utilizados

- `proximoInt()`: realiza a leitura dos números da entrada, mesmo quando estão distribuídos em linhas diferentes.
- **Busca linear:** percorre o vetor elemento por elemento até encontrar o valor procurado ou chegar ao final.
- **Busca binária:** utiliza os limites de início e fim para procurar o valor, verificando sempre o elemento que está no meio do intervalo.

## Funcionamento das buscas

Na busca linear, cada elemento verificado aumenta o contador `comparacoesLinear`. Quando o valor é encontrado, sua posição é armazenada. Caso não seja encontrado, a posição permanece como `-1`.

Na busca binária, o programa compara o valor procurado com o elemento do meio do vetor. Dependendo do resultado, continua a busca na metade esquerda ou direita. Cada verificação aumenta o contador `comparacoesBinaria`.

## Saída

Para cada consulta, o programa imprime três informações:

- A posição do valor no vetor, ou `-1` se ele não existir.
- A quantidade de comparações realizadas pela busca linear.
- A quantidade de comparações realizadas pela busca binária.

O `StringBuilder` é utilizado para guardar os resultados antes de imprimir tudo no final.

## Complexidade

- **Busca linear:** O(N), pois pode precisar percorrer todos os elementos.
- **Busca binária:** O(log N), pois reduz o intervalo de busca pela metade a cada comparação.

## Observação

A busca linear pode realizar menos comparações em alguns casos, principalmente quando o valor procurado está no início do vetor. Isso não contradiz a análise de complexidade, pois ela considera o comportamento do algoritmo em relação ao tamanho da entrada, e não apenas um caso específico.

## Conclusão

A questão demonstra a diferença entre dois métodos de busca. A busca linear é mais simples, mas pode precisar verificar muitos elementos. Já a busca binária aproveita o fato de o vetor estar ordenado para encontrar os valores com menos comparações.