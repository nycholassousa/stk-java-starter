A ideia da stack é simplificar a inicialização de um novo projeto, acelerando o desenvolvimento. Isso é feito através de um código simples seguindo uma boa padronização, onde já estão adicinados configurações básicas, bem como o uso de dependências, propriedades, classes e alguns testes.

Ao utilizar esta stack, você poderá ter os seguintes resultados:
- Código padronizado, através de uma arquitetura próximo ao hexagonal, de forma mais amigável;
- Uso de profiles, deixando assim a separação de ambientes e propriedades mais robustas;
- Plugins com casos de uso e testes funcionais, trazendo um exemplo básico de como pode ser usado;
- Observabilidade, trazendo mais confiança ao código;

### Usando nossa stack

Para criar uma aplicação usando nossa stack, você deve seguir estes passos:

Considerando que você já importou nossa stack, agora você deve criar uma aplicação usando nosso template básico, o boilerplate.

```bash
stk create app <app-name> -t java-starter/boilerplate
```

Após o comando, preencha os dados pedidos de acordo com o que você deseja.