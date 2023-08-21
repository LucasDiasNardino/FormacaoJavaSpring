# Alguns Códigos do Protocolo HTTP

O **protocolo HTTP** é o protocolo responsável por fazer a comunicação entre o cliente, que normalmente é um browser, e o servidor. Desta forma, a cada requisição feita pelo cliente, o servidor responde com um **código de status** HTTP, que **indica o que aconteceu com a requisição feita**.

<br>

## Categoria de códigos

Os códigos de status HTTP possuem três dígitos, sendo que o primeiro dígito significa a classificação dentro das possíveis cinco categorias:

* **1XX**: Informativo - A solicitação foi aceita ou o processo continua em andamento;

* **2XX**: Confirmação - A solicitação foi concluída ou entendida;

* **3XX**: Redirecionamento - Indica que algo mais precisa ser feito ou precisou ser feito para completar a solicitação;

* **4XX**: Erro do cliente - A solicitação possui algum erro de sintaxe ou não pode ser completada;

* **5XX**: Erro do servidor - O servidor falhou ao completar a solicitação.

<br>

## Principais códigos de Erro

### 403

O código 403 é o erro "proibido". Significa que o servidor entendeu a requisição, mas se recusa a processá-la, pois o cliente não possui autorização para isso.

### 404

Quando o servidor não encontra o recurso solicitado, ele retorna o código 404, que significa "não encontrado".

### 500

É um erro menos comum, mas de vez em quando ele aparece. Esse erro significa que há um problema com alguma das bases que faz uma aplicação rodar. Pode ser um problema no banco de dados, por exemplo.

### 503

O erro 503 significa que o serviço acessado está temporariamente indisponível. Causas comuns são um servidor em manutenção ou sobrecarregado.