# PED_II_Projeto2

A Tarefa 2 consiste em escrever um programa (usando OBRIGATORIAMENTE a estrutura de State/Solver passada em aula) para resolver um problema de logística de cargas.  

O problema consiste em dispor N itens de diferentes volumes em C containers de volume máximo V.

O programa precisa ser genérico, aceitando como entrada as especificações dos valores N, C e V, além dos volumes individuais de cada item. Volumes são quantidades reais, ou seja, expressas por variáveis do tipo double.

O estado inicial, portanto, são C containers vazios.
O programa deve então encontrar o melhor empacotamento, definido como a alocação de exatamente todos os itens (sem repetição, tendo um ou mais item em cada container) e ainda maximizando o volume não ocupado do último container.
