<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR"  >
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro de Automoveis</title>
  </head>

  <body>
    <form method="post" action='./inserirVeiculo'>
      <div class="container">
        <h1>Dados de Veículo</h1>
        <div class="container-input">
          <label for="placa">Placa:</label>
          <input type="text" name="placa" id="placa" required/>
        </div>

        <div class="container-input">
          <label for="modelo">Modelo:</label>
          <input type="text" name="modelo" id="modelo" required/>
        </div>

        <div class="container-input">
          <label for="marca">Marca:</label>
          <input type="text" name="marca" id="marca" required/>
        </div>

        <div class="container-input">
          <label for="lugares">Lugares:</label>
          <input type="text" name="lugares" id="lugares" required/>
        </div>

        <div class="container-input">
          <label for="valorAluguel">Valor do Aluguel:</label>
          <input type="text" name="valorAluguel" id="valorAluguel"/>
        </div>

        <div>
          <button id="btnLimpar" type="reset">Limpar</button>
          <button type="submit">Cadastrar</button>
        </div>

      </div>
    </form>
    <div class="containerBtn">
       <button class="btnListar"> <a href="http://localhost:8080/veiculos"> Listagem de veículos </a> </button>
    </div>
    <script>
        let status = ${status}
        if(status == 500){
           alert("Ocorreu um erro inesperado ao cadastrar. Verifique os dados de entrada, se o problema persistir, nos avise.")
        }
    </script>
  </body>

</html>

<style>

.containerBtn{
    width: 100%;
    text-align: center;
}

.btnListar a{
     text-decoration: none;
     color: black;
 }

  form {
    width: 100vw;
    height: 60vh;
    display: flex;
    align-items: center;
    justify-content: center;
  }

  .container {
    width: 368px;
    border: 3px solid #000;
    border-radius: 5px;
    padding: 1rem;
    display: flex;
    flex-direction: column;
  }

  .container h1 {
    margin: 0;
    text-align: center;
  }

  .container-input {
    margin: 15px 0;
    width: 100%;
  }
</style>