# Spring Security

Módulo do spring dedicado a segurança da aplicação.
A segurança é feita através de filtros, que são executados antes de cada requisição.

## Objetivos 

* Autenticação
* Autorização (Controle de acesso)
* Proteção contra ataques (CSRF, clickjacking, etc)

## Atenção!

Autenticação em aplicação web é **diferente** de autenticação em API.

## Como funciona a Autenticação

Utiliza-se tokens, nesse caso o JWT (JSON Web Token). O token é enviado no header da requisição, e o servidor valida o token e permite ou não o acesso. 

1. O cliente faz uma requisição para a API
2. A API valida a requisição no banco de dados
3. Quando a requisição é válida, a API gera um token
4. O token é devolvido na resposta da requisição

## Como funciona a Autorização

A autorização utiliza o token gerado na autenticação para liberar o acesso a determinados recursos.

1. O cliente faz uma requisição para a API, enviando o token no header
2. A API valida se o token é válido e foi gerado por ela
3. Se o token for válido, a API libera o acesso