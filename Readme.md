# Projeto Fábrica de Software 2023 - 2

## Ambiente
[Java 17](https://adoptium.net/download/)
[Maven](https://maven.apache.org/download.cgi)
[VSCode](https://code.visualstudio.com/Download)

### Extensões do VSCode
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Spring Boot Extension Pack](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-boot-dev-pack)

## Diagrama de Entidades

![Diagrama de Entidades](/diagramas/diagramaentidades.png)


## Validação de campos
- Alterar o arquivo pom.xml para incluir a dependência da biblioteca de validação
```
    <dependency> 
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-validation</artifactId> 
    </dependency> 
```
- Alterar as entidades para incluir as anotações sobre o campo para validar
```
    @NotBlank(message = "Campo nome não pode ser em branco")
    private String nome;
```
- Alterar o código do controlador para no método SAVE habilitar a validação e em caso de erro retornar o usuário para a tela de formulário
```
    @PostMapping
    public ModelAndView save(@Valid Cliente cliente, 
                BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            HashMap<String,Object> dados = new HashMap<>();
            var listaCidades = cidadeService.getAll();
            dados.put("cliente",cliente);
            dados.put("listaCidades",listaCidades);
            return new ModelAndView("cliente/form", dados);
        }
        service.save(cliente);
        return new ModelAndView("redirect:/clientes");

    }
```
- Alterar o código HTML do formulário para incluir um TAG para mostrar a mensagem de erro.
```
<div class="form-group">
    <label for="txtNome">Nome</label>
    <input type="text" class="form-control"
        th:field="*{nome}" id="txtNome">
    <p th:if="${#fields.hasErrors('nome')}"
        th:errors="*{nome}"
        class="alert alert-danger"></p>
</div>
```