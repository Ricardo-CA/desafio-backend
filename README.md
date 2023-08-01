Desafio Backend Orla Digital
Este projeto é uma API REST que fornece um sistema de gerenciamento para Projetos e Funcionários.

Requisitos
Java 11
Maven
MySQL
API Endpoints
Aqui estão os principais endpoints da API:

Funcionários:

GET /v1/funcionarios: Retorna uma lista de todos os funcionários.
GET /v1/funcionarios/{id}: Retorna os detalhes de um funcionário específico.
POST /v1/funcionarios: Cria um novo funcionário.
PUT /v1/funcionarios/{id}: Atualiza um funcionário existente.
DELETE /v1/funcionarios/{id}: Exclui um funcionário.
Projetos:

GET /v1/projetos: Retorna uma lista de todos os projetos.
GET /v1/projetos/{id}: Retorna os detalhes de um projeto específico.
POST /v1/projetos: Cria um novo projeto.
PUT /v1/projetos/{id}: Atualiza um projeto existente.
DELETE /v1/projetos/{id}: Exclui um projeto.
Instalação e execução
Para executar este projeto localmente, siga estas etapas:

Clone o repositório:

bash
Copy code
git clone https://github.com/your-username/desafiobackend.git
cd desafiobackend
Compile e empacote o aplicativo usando Maven:

bash
Copy code
mvn clean install
Execute o aplicativo:

bash
Copy code
java -jar target/desafiobackend-0.0.1-SNAPSHOT.jar
Agora, o servidor deve estar rodando em http://localhost:8080.

Testes
Para rodar os testes, use o seguinte comando Maven:

bash
Copy code
mvn test
Contribuição
Contribuições são bem-vindas! Por favor, leia as diretrizes de contribuição antes de fazer qualquer alteração.

Licença
Este projeto está licenciado sob a MIT License. Veja o arquivo LICENSE para mais detalhes.
