
# Teste de seleção para vaga de Java

Atividade desenvolvida para a disciplina de Desenvolvimento de Sistemas Paralelos e Distribuídos do [Centro de Educação Superior do Alto Vale do Itajaí (CEAVI/UDESC)](https://www.udesc.br/ceavi)<br>

# Sumário
* [Equipe](#equipe)
* [Atividade](#atividade)
* [Especificações](#especificações)
* [Diagramas](#diagramas)

## [Equipe](#equipe)
 - [**Rodrigo Souza Tassoni**](mailto:tazzsoni@gmail.com) - [GitHub](https://github.com/tazzsoni)
 
## [Atividade](#atividade)

**OBJETIVO**<br>

Implementar para empresa de transporte de cargas SigaBem o endpoint para o cálculo do preço do frete.

## [Especificações](#especificações)

Requisitos do sistema

1.	REQUISITOS FUNCIONAIS (RF) 
 
- RF1: Desenvolver uma api para calculo de valor total de frete e data pravista para entrega;

- RF2: O Sistema deve calcular o valor total do frete e a data prevista da entrega;

-	RF3: O Sistema deve permitir o registro de Produtos.
- RF3.1: Dados de Produtos: <br>
•	Nome do Destinatário<br>
•	Peso<br>
•	Cep Origem<br>
•	Cep Destino<br>
•	Valor Total do Frete<br>
•	Data Prevista de Entrega<br>
•	Data da Consulta<br>

- RF4: Seu input de entrada deve ser “peso”, “cepOrigem”, “cepDestino” e “nomeDestinatario“;

-	RF5: Response/Output deve possuir: “vlTotalFrete” e “dataPrevistaEntrega”, “cepOrigem” e “cepDestino”;

-	RF6: Deve ser persistido no banco os valores da cotação os valores consultados: “peso”, “cepOrigem”, “cepDestino”, “nomeDestinatario”, “vlTotalFrete”, “dataPrevistaEntrega” e “dataConsulta”


2.	REQUISITOS NÂO FUNCIONAIS (RNF) 
-	RNF1: Endpoint pode ser público;

3.	REGRAS DE NEGÓCIO

-	RN1: CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia;

-	RN2: CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias;

-	RN3: CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias;

-	RN4: O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00;


## [Diagramas](#diagramas)

*DIAGRAMA DE CLASSES*

![image](https://user-images.githubusercontent.com/45270751/132961105-0f5e391a-33b0-4565-9b20-b88f676cd42d.png)

