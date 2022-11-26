<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-BR"  >
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cadastro de Automoveis</title>
  </head>

  <body>
    <form method="post" action='/AlterarVeiculo?id=${veiculo.id}'>
      <div class="container">
        <h1>Dados de Veículo</h1>
        <div class="container-input">
          <label for="placa">Placa:</label>
          <input value="${veiculo.placa}" type="text" name="placa" id="placa" required/>
        </div>

        <div class="container-input">
          <label for="modelo">Modelo:</label>
          <input value="${veiculo.modelo}" type="text" name="modelo" id="modelo" required/>
        </div>

        <div class="container-input">
          <label for="marca">Marca:</label>
          <input value="${veiculo.marca}" type="text" name="marca" id="marca" required/>
        </div>

        <div class="container-input">
          <label for="lugares">Lugares:</label>
          <input value="${veiculo.lugares}" type="text" name="lugares" id="lugares" required/>
        </div>

        <div class="container-input">
          <label for="valorAluguel">Valor do Aluguel:</label>
          <input value="${veiculo.valorAluguel}" type="text" name="valorAluguel" id="valorAluguel" required/>
        </div>

        <div>
          <input id="btnLimpar" type="submit" value="Limpar" />
          <button type="submit">Atualizar</button>
        </div>
      </div>

    </form>
  </body>

    <script>
      document.getElementById("btnLimpar").addEventListener("click", function(event){
           event.preventDefault()
           document.getElementById("placa").value= null
           document.getElementById("modelo").value= null
           document.getElementById("marca").value= null
           document.getElementById("lugares").value= null
           document.getElementById("valorAluguel").value= null
      });
    </script>

   <script>
        let status = ${status}
         if(status == 500){
            let id = ${id}
            alert("Ocorreu um erro inesperado ao atualizar. Verifique os dados de entrada, se o problema persistir, nos avise.")
            location.href='/cadastroveiculo/FrmCadastroVeiculo-jsp?id='+id;
         }
   </script>

</html>

<style>
  form {
    width: 100vw;
    height: 100vh;
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