# TaskSync: sistema de gestão de projetos

## Projeto web focado na demostração do uso de relacionamentos de banco de dados relacional, com operações básicas de CRUD disponibilizadas em endpoints para consumo do front-end.

# Passos para colocar o servidor em execução

- Fazer download do Java 21
- Fazer download do PostgreSQL versão 16
- Criar um database chamado “tasksync”, onde ficarão as informações persistidas pela aplicação
- Colocar, no arquivo application.properties:
    - Usuário (o qual fará a manipulação do banco pelo servidor);
    - Senha do usuário
    - URL na qual estará disponível o banco de dados;

##### Executando:
  - Utilizar uma IDE para executar o projeto, tendo em vista que o método main se encontra na classe principal ApiApplication
  - Fazer download do Apache Maven (processo descrito [aqui](https://maven.apache.org/install.html)) e configurar o path
###### Ou
  - Executar o projeto com o comando `mvn spring-boot:run` no terminal
