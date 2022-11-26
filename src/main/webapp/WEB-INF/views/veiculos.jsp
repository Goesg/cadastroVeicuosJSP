<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="v" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Lista de Veículos</title>
  </head>
  <body>
    <div class="container">
      <div >
        <h1>Lista de Veículo</h1>
        <table border="1">
        <thead>
         <tr>
            <td>Id</td>
            <td>Placa</td>
            <td>Modelo</td>
            <td>Marca</td>
            <td>Lugares</td>
            <td>Valor do Aluguel</td>
            <td>Atualizar dados</td>
            <td>Excluir dados</td>
         </tr>
         </thead>
         <tbody>
            <v:forEach var="veiculo" items="${veiculos}">
                <tr>
                    <td> ${veiculo.id} </td>
                    <td> ${veiculo.placa} </td>
                    <td> ${veiculo.modelo} </td>
                    <td> ${veiculo.marca} </td>
                    <td> ${veiculo.lugares} </td>
                    <td> ${veiculo.valorAluguel} </td>
                    <td> <a target="_blank" href="http://localhost:8080/cadastroveiculo/FrmCadastroVeiculo-jsp?id=${veiculo.id}"> http://localhost:8080/cadastroveiculo/FrmCadastroVeiculo-jsp?id=${veiculo.id} </a> </td>
                    <td> <a href="http://localhost:8080/cadastroveiculo/ExcluirVeiculo?id=${veiculo.id}"> http://localhost:8080/cadastroveiculo/ExcluirVeiculo?id=${veiculo.id} </a> </td>
                </tr>
            </v:forEach>
         </tbody>
       </table>
       <div class="containerBtn">
       <button class="btnCadastrar"> <a href="http://localhost:8080/"> Cadastrar </a> </button>
       </div>

      </div>
  </body>
  <script>
           let status = ${status}
                   if(status == 500){
                      alert("Ocorreu um erro inesperado ao excluir veículo.")
                   }else if(status == 200) alert("Veículo excluido com sucesso.")
    </script>
</html>

<style>
  .container {
    padding: 1rem;
  }

.containerBtn{
    width: 100%;
    margin-top: 70px;
    text-align: center;
}

.btnCadastrar a{
     text-decoration: none;
     color: black;
 }

  .container h1 {
    margin-bottom: 15px ;
    text-align: center;
  }

  table {
    margin: 0 auto;
  }

  td {
    padding: 8px;
  }

</style>