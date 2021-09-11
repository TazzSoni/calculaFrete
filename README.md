
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

**DDESCRIÇÃO DA API**<br>

API desenvolvida em Java (Spring Boot). Para esta aplicação foram criados pacotes Model, Repository, Resources e Services, seguindo o padrão MVC. No pacote Model ficam as classes modelo do projeto obtendo Produto (persistida) e Endereço (não persistida) e para persistência utilizei o banco de dados PostgresSQL. Optei pela criação da Classe Endereço, sem persisti-la em banco de dados, apenas para armazenar as informações vindas dos CEPs informados. Criei a classe CepService.Java, para buscar as informações na api ViaCep, nesta classe utilizei o padrão Singleton para manter apenas uma instância dela no projeto, tendo em vista que ela será utilizada apenas para obter informações de endereços, não sendo necessário instanciar um novo objeto a cada requisição. No pacote Resources fica a classe responsável pelas persistências e requisições no banco de dados, ProdutoResource.Java, com sua carga de métodos para busca e persistência em bando de dados. Por opção, coloquei como notnull a coluna “data_prevista_entrega”, para que possa ser verificado se ela está nula, assim podendo retornar informação de erro caso o cep não exista. E finalizando, optei pelo uso da notação @RestController ao invés de @Controller, pelo fato de @RestController ser o equivalente a @Controller e @ResponseBody juntos.

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

