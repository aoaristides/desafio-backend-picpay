# Desafio Back-end PicPay

Para um maior entendimento do desafio segue o repositório [aqui](https://github.com/PicPay/picpay-desafio-backend).

# Objetivo: PicPay Simplificado

O PicPay Simplificado é uma plataforma de pagamentos simplificada. Nela é possível depositar e realizar transferências
de dinheiro entre usuários. Temos 2 tipos de usuários, os comuns e lojistas, ambos têm carteira com dinheiro e realizam
transferências entre eles.

## Requisitos

A seguir estão algumas regras de negócio que são importantes para o funcionamento do PicPay Simplificado:

- Para ambos tipos de usuário, precisamos do Nome Completo, CPF, e-mail e Senha. CPF/CNPJ e e-mails devem ser únicos no
  sistema. Sendo assim, seu sistema deve permitir apenas um cadastro com o mesmo CPF ou endereço de e-mail;

- Usuários podem enviar dinheiro (efetuar transferência) para lojistas e entre usuários;

- Lojistas só recebem transferências, não enviam dinheiro para ninguém;

- Validar se o usuário tem saldo antes da transferência;

- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo, use este
  mock https://util.devi.tools/api/v2/authorize para simular o serviço utilizando o verbo GET;

- A operação de transferência deve ser uma transação (ou seja, revertida em qualquer caso de inconsistência) e o
  dinheiro deve voltar para a carteira do usuário que envia;

- No recebimento de pagamento, o usuário ou lojista precisa receber notificação (envio de email, sms) enviada por um
  serviço de terceiro e eventualmente este serviço pode estar indisponível/instável. Use este
  mock https://util.devi.tools/api/v1/notify)) para simular o envio da notificação utilizando o verbo POST;

- Este serviço deve ser RESTFul.

> Tente ser o mais aderente possível ao que foi pedido, mas não se preocupe se não conseguir atender a todos os
> requisitos. Durante a entrevista vamos conversar sobre o que você conseguiu fazer e o que não conseguiu.

## Endpoint de transferência

Você pode implementar o que achar conveniente, porém vamos nos atentar somente ao fluxo de transferência entre dois
usuários. A implementação deve seguir o contrato abaixo.

```
POST /transfer
Content-Type: application/json

{
  "value": 100.0,
  "payer": 4,
  "payee": 15
}
```

## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Postgres
- Docker
- Spring Cloud Open Feign
- ControllerAdvice & Problem Details
- Hibernate Validator

🔍 Baixe o projeto e teste você mesmo na prática.
