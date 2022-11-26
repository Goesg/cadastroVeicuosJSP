package gustavo.frez.cadastroDeAutomoveis.controller;

import gustavo.frez.cadastroDeAutomoveis.repository.VeiculoRepository;
import gustavo.frez.cadastroDeAutomoveis.model.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Controller
public class HomeServelet extends HttpServlet {

    private VeiculoRepository veiculoRepository = new VeiculoRepository();

    @RequestMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @RequestMapping("/inserirVeiculo")
    public void inserirveiculo(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            String placa = request.getParameter("placa");
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            int lugares = Integer.parseInt(request.getParameter("lugares"));
            double valorAluguel = Double.parseDouble(request.getParameter("valorAluguel"));
            Veiculo novoVeiculo = new Veiculo(null, placa, modelo, marca, lugares, valorAluguel);

            veiculoRepository.inserir(novoVeiculo);

            response.sendRedirect("/veiculos");
        }catch (Exception e){
            request.setAttribute("status",500);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cadastro.jsp");
            view.forward(request, response);

            PrintWriter out = response.getWriter();
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }

    }

    @RequestMapping("/veiculos")
    public void veiculos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("veiculos", veiculoRepository.listar());

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/veiculos.jsp");
            view.forward(request, response);
        }catch (Exception e){
            request.setAttribute("status", 500);
        }finally {
            PrintWriter out = response.getWriter();
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }

    @RequestMapping("/cadastroveiculo/FrmCadastroVeiculo-jsp")
    public void updateForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            request.setAttribute("veiculo", veiculoRepository.obter(id));
        }catch (Exception e){
            request.setAttribute("status", 500);
        }finally {
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
            view.forward(request, response);

            PrintWriter out = response.getWriter();
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }

    @RequestMapping("/AlterarVeiculo")
    public void updateVeiculo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Long id = Long.valueOf(request.getParameter("id"));
        try {
            String placa = request.getParameter("placa");
            String modelo = request.getParameter("modelo");
            String marca = request.getParameter("marca");
            int lugares = Integer.parseInt(request.getParameter("lugares"));
            double valorAluguel = Double.parseDouble(request.getParameter("valorAluguel"));
            Veiculo updateVeiculo = new Veiculo(id, placa, modelo, marca, lugares, valorAluguel);

            veiculoRepository.atualizar(updateVeiculo);

            response.sendRedirect("/veiculos");
        }catch (Exception e){
            request.setAttribute("status", 500);
            request.setAttribute("id", id);

            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/update.jsp");
            view.forward(request, response);

            PrintWriter out = response.getWriter();
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }

    @RequestMapping("/cadastroveiculo/ExcluirVeiculo")
    public void excluirVeiculo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        try {
            Long id = Long.valueOf(request.getParameter("id"));
            veiculoRepository.deletar(id);
            request.setAttribute("status", 200);

            response.getWriter().append("Served at: ").append(request.getContextPath());
        }catch (Exception e){
            request.setAttribute("status", 500);
        }finally {
            request.setAttribute("veiculos", veiculoRepository.listar());
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/veiculos.jsp");
            view.forward(request, response);
            PrintWriter out = response.getWriter();
        }
    }

}
