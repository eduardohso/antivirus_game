# Antivírus por um Dia - Jogo de Tabuleiro

## Descrição do Projeto

Este projeto foi desenvolvido como parte da disciplina **Programação Orientada a Objetos** da **Universidade Federal de Viçosa**.

**Antivírus por um Dia** é um jogo de tabuleiro colaborativo para dois jogadores, onde o objetivo é percorrer os setores da memória de um computador infectados por vírus. Um dos jogadores assume o papel de um antivírus, e o outro pode ser um jogador de suporte. Eles devem trabalhar juntos para eliminar os vírus e chegar ao setor que contém a fonte da infecção. No entanto, os vírus atacam no caminho, e os jogadores devem ser cuidadosos para não serem destruídos.

## Regras do Jogo

1. **Jogadores**: 
   - Existem dois tipos de jogadores: **simples** e **de suporte**.
   - O jogador simples possui um ataque (ATK) de 2 e defesa (DEF) de 6.
   - O jogador de suporte tem um ataque de 1 e defesa de 7 e pode recuperar pontos de defesa (própria ou do outro jogador) quando estiverem no mesmo setor.
   - Os jogadores podem se movimentar, atacar e procurar no setor, com o jogador de suporte tendo a habilidade adicional de recuperar defesa.

2. **Inimigos (Vírus)**:
   - Os inimigos possuem ataque e defesa com valores entre 1 e 3, definidos aleatoriamente quando criados.
   - Eles só podem atacar e permanecem no setor onde foram gerados, não se movimentando.

3. **Tabuleiro**:
   - O tabuleiro é uma grade 5x5, onde os jogadores começam no centro (posição C), e a fonte de infecção (posição X) é gerada aleatoriamente.
   - Cada setor pode ter portas ou paredes, que são definidas aleatoriamente à medida que os jogadores avançam.

4. **Turnos**:
   - O jogo é baseado em turnos, alternando entre os jogadores e os vírus.
   - Cada jogador pode realizar duas ações por turno, como atacar ou procurar por itens no setor.
   - Os vírus atacam os jogadores quando estão no mesmo setor, mas somente após o turno de ambos os jogadores.

5. **Objetivo**:
   - O objetivo do jogo é que os jogadores eliminem os vírus e cheguem à fonte de infecção.
   - O jogo pode terminar quando:
     - Um jogador chega à fonte de infecção.
     - Os jogadores ultrapassam 25 ciclos.
     - Ambos os jogadores são eliminados pelos vírus.

## Estrutura do Projeto

Este projeto foi implementado utilizando os seguintes conceitos de Programação Orientada a Objetos:
- **Classes e Objetos**
- **Encapsulamento**
- **Herança**
- **Polimorfismo**
- **Tratamento de Exceção**
- **Coleções**

