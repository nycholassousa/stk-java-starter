Para usar a implementação, basta criar uma nova interface dentro do package "mapper", localizado nos adapters.
Nesta interface, você deve adicionar a seguinte anotação do java, no topo da interface:

```java
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
```

Essa anotação permite que seja utilizado o mapstruct para aquela interface.

Dentro da interface, talvez seja necessário fazer um de-para entre o source e o target, apenas se o nome deles não forem iguais, assim sendo, segue o exemplo caso o nome seja igual e caso não seja igual:

1. Caso o target e source possuam nomes diferentes
```java
    @Mapping(target = "name", source = "car_name")
    CarEntity fromRequestToEntity(CarRequest request);
```

1. Caso o target e source possuam nomes iguais
```java
    CarEntity fromRequestToEntity(CarRequest request);
```

Como pode ser visto, caso os nomes sejam iguais, apenas será feito a assinatura do método, o mapstruct irá cuidar do resto (validação de casos nulos, conversões).

Um exemplo completo de como uma classe pode ficar, com mais possibilidades do mapstruct, seria da seguinte forma:

```java
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, imports = LocalDateTime.class)
public interface LoginMapper {
    @Mapping(target = "expirationDate", expression = "java(LocalDateTime.now().plusSeconds(result.getAuthenticationResult().getExpiresIn()))")
    @Mapping(target = "tokenType", source = "authenticationResult.tokenType")
    @Mapping(target = "refreshToken", source = "authenticationResult.refreshToken")
    @Mapping(target = "idToken", source = "authenticationResult.idToken")
    @Mapping(target = "expiresIn", ignone = true)
    @Mapping(target = "creationDate", expression = "java(LocalDateTime.now())")
    @Mapping(target = "accessToken", source = "authenticationResult.accessToken")
    LoginResponse fromRequestToResponse(AdminInitiateAuthResult result);
}
```

Neste exemplo, podemos notar:
- Adicionamos um import ao @Mapper, informando que a classe gerada deverá importar essa classe
- Usamos expressões java no lugar do source
- Podemos ignorar algum target
- Podemos fazer um get dentro do objeto para buscarmos o dado exato que queremos que seja mapeado