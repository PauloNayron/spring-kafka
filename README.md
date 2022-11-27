# spring-kafka



## USE CASE: New Order
```mermaid
sequenceDiagram
    autonumber
    actor C as client
    participant SS as shopping-server
    participant CS as customer-server
    participant AS as address-server
    participant DB as MongoDB
    
    C->>SS: POST /shopping-server/order
    activate SS
    SS->>CS: GET /customer-server/customer/{{document}}
    activate CS
    CS->>CS: recuperar informações da Larissa
    CS->>AS: me de informações de endereco da Larissa
    activate AS
    AS->>DB: recupera informações da Larissa
    activate DB
    DB-->>AS: {}: Endereco da Larissa
    deactivate DB
    AS-->>CS: {}: Endereco da Larissa
    deactivate AS
    CS-->>CS: montar as informações
    activate CS
    CS-->>SS: {}: Customer Larissa
    deactivate CS
    deactivate CS
    
    SS-->>SS: valida informações de cartão
    
    SS-->>C: Compra confirmada
    deactivate SS
```

### 1 - New Order

````shell
curl --location --request POST 'locahost:8080/shopping-server/order' \
--header 'Content-Type: application/json' \
--data-raw '{
    "document": "123121231",
    "card" : {
        "number": "1234XXXXX1234",
        "token":  "12312SCAS!23123",
        "Bandeira":  "Mastercard"
    },
    "address": {
        "default": true
    }
}'
````

### 2 - Get Customer info by Document
````shell
curl --location -g --request GET 'locahost:8080/customer-server/customer/{{document}}'
````