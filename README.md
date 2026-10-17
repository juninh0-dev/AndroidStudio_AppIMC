# ImcApp - Calculadora de IMC

## Conceito do projeto

Este projeto é um aplicativo Android desenvolvido em Java para calcular o Índice de Massa Corporal (IMC) de uma pessoa.

O usuário informa seu peso, em quilogramas, e sua altura, em metros. O aplicativo calcula o IMC, apresenta uma classificação e informa se há necessidade de fazer regime.

A fórmula utilizada é:

```text
IMC = peso / (altura × altura)
```

## Funcionalidades

- Entrada de peso e altura;
- Validação para campos vazios e valores inválidos;
- Cálculo do IMC;
- Classificação do resultado;
- Exibição de altura, peso, IMC e classificação;
- Recomendação visual:
  - Vermelho: “Sim é necessário fazer regime.”
  - Verde: “Não precisa fazer regime.”
- Confirmação ao sair do aplicativo;
- Seta para voltar da tela de resultados para a tela inicial.

## Telas do aplicativo

### EntradaActivity

É a primeira tela do aplicativo.

O usuário preenche:

```text
Peso (Kg)
Altura (m)
```

Ao tocar no botão **Calcular IMC**, os valores são enviados para a tela de resultado.

Também existe um `AlertDialog` ao pressionar o botão Voltar:

```text
Deseja sair do aplicativo?
Sim / Não
```

### ResultadoActivity

É a tela que recebe os dados digitados na primeira tela.

Nela, o aplicativo:

1. Recebe peso e altura;
2. Calcula o IMC;
3. Classifica o resultado;
4. Exibe a recomendação;
5. Permite retornar à primeira tela pela seta da `Toolbar`.

## Comunicação entre as telas

Os dados são enviados da `EntradaActivity` para a `ResultadoActivity` usando `Intent` e `Bundle`.

O pacote de dados utilizado chama-se:

```java
meusDadosIMC
```

Ele contém:

```java
peso
altura
```

## Classificação do IMC

| Faixa de IMC | Classificação |
|---|---|
| Menor que 18,5 | Abaixo do peso |
| De 18,5 até 24,9 | Peso normal |
| De 25 até 29,9 | Sobrepeso |
| De 30 até 34,9 | Obesidade Grau I |
| De 35 até 39,9 | Obesidade Grau II |
| 40 ou mais | Obesidade Grau III |

## Estrutura principal do projeto

```text
app/src/main/
├── java/br/edu/fatecjahu/imcapp/
│   ├── EntradaActivity.java
│   └── ResultadoActivity.java
│
├── res/
│   ├── layout/
│   │   ├── activity_entrada.xml
│   │   └── activity_resultado.xml
│   │
│   └── values/
│       └── colors.xml
│
└── AndroidManifest.xml
```

## Tecnologias utilizadas

```text
Android Studio
Java
XML
Android SDK API 24
ConstraintLayout
Intent
Bundle
AlertDialog
Toolbar
```

## Requisitos atendidos

- Projeto Android em Java;
- SDK mínimo API 24;
- Tela de entrada de dados;
- Tela de resultados;
- Uso de `float` para peso e altura;
- Uso de `Intent` e `Bundle`;
- Método `calcularIMC(float peso, float altura)`;
- Método `classificarIMC(double imc)`;
- Alerta para sair;
- Recomendação com cores;
- Navegação de retorno com seta na `Toolbar`.
