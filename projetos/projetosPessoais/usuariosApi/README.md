
📦 **API de Gerenciamento de Usuários**

- Esta é uma API RESTful desenvolvida em Java Spring Boot para operações de gerenciamento de usuários (CRUD). A aplicação não possui front-end, sendo focada exclusivamente no back-end.

🚀 **Funcionalidades**

**Método HTTP	       Endpoint	                       Descrição**
  POST	        /usuario/cadastrar	         Cadastra um novo usuário
  PUT	          /usuario/atualizarUsuario	   Atualiza os dados de um usuário
  DELETE	      /usuario/excluir/{id}	       Exclui um usuário por ID
  GET	          /usuario/{login}	           Busca um usuário pelo login
  
🛠️ **Tecnologias Utilizadas**

- Java 17
- Spring Boot 3.x
- Spring Web MVC
- Maven (gerenciamento de dependências)
- DTO Pattern (Data Transfer Object)

📁 **Estrutura do Projeto**

<img width="712" height="344" alt="image" src="https://github.com/user-attachments/assets/8bcf7831-bd46-428f-aca6-f0b926451ea6" />



🔌** Como Usar os Endpoints**

**1.** Cadastrar Usuário
http
POST /usuario/cadastrar
Content-Type: application/json

{
  "login": "joao.silva",
  "nome": "João Silva",
  "email": "joao@email.com"
}

**2**. Atualizar Usuário
http
PUT /usuario/atualizarUsuario
Content-Type: application/json

{
  "id": 1,
  "login": "joao.silva",
  "nome": "João Silva Atualizado",
  "email": "joao.novo@email.com"
}

**3**. Excluir Usuário
http
DELETE /usuario/excluir/1

**4.** Buscar Usuário por Login
http
GET /usuario/joao.silva

⚙️** Pré-requisitos**

- Java 17 ou superior
- Maven 3.6+
- IDE de sua preferência (IntelliJ, Eclipse, VS Code)

🚀 **Como Executar**

Clone o repositório:

bash
git clone https://github.com/seu-usuario/api-usuarios.git
cd api-usuarios
Compile o projeto:

bash
mvn clean compile
Execute a aplicação:

bash
mvn spring-boot:run
Acesse a API:

A aplicação estará rodando em http://localhost:8080

📦** Possíveis Melhorias Futuras**

- Integração com banco de dados (ex: PostgreSQL, MySQL)
- Autenticação e autorização com Spring Security
- Validação de dados de entrada

🤝 **Contribuição**

Contribuições são bem-vindas! Sinta-se à vontade para:

Fork o projeto:

Criar uma branch para sua feature (git checkout -b feature/nova-feature)
Commit suas mudanças (git commit -m 'Adiciona nova feature')
Push para a branch (git push origin feature/nova-feature)
Abrir um Pull Request

📄 **Licença**
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.

👨‍💻 **Autor**
Desenvolvido por [Seu Nome] – Entre em contato pelo LinkedIn ou GitHub!

⚠️ Nota: Esta é uma versão inicial da API. Novas funcionalidades e melhorias serão implementadas em versões futuras.

