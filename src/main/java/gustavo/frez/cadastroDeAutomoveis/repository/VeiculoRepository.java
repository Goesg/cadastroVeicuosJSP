package gustavo.frez.cadastroDeAutomoveis.repository;

import gustavo.frez.cadastroDeAutomoveis.config.Conexao;
import gustavo.frez.cadastroDeAutomoveis.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VeiculoRepository {

    public VeiculoRepository() {
    }

    public void inserir(Veiculo veiculo) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();

            st = con.prepareStatement(
                    "INSERT INTO veiculo"
                            + "(placa,modelo,marca,lugares,valorAluguel)"
                            + "VALUES"
                            + "(?,?,?,?,?)"
            );
            st.setString(1, veiculo.getPlaca());
            st.setString(2, veiculo.getModelo());
            st.setString(3, veiculo.getMarca());
            st.setInt(4, veiculo.getLugares());
            st.setDouble(5, veiculo.getValorAluguel());

            int rowsAffected = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            assert st != null;
            st.close();
        }
    }

    public List<Veiculo> listar() throws SQLException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM veiculo");

            List<Veiculo> veiculosList = new ArrayList<>();

            while (rs.next()) {
                long id = rs.getLong("veiculoID");
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int lugares = rs.getInt("lugares");
                double valorAlguel = rs.getDouble("valorAluguel");

                Veiculo veiculo = new Veiculo(id, placa, modelo, marca, lugares, valorAlguel);
                veiculosList.add(veiculo);
            }

            return veiculosList;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            rs.close();
        }
        return null;
    }

    public Veiculo obter(Long id) throws SQLException {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            con = Conexao.conectar();
            st = con.createStatement();
            String sql = "SELECT * FROM veiculo "
                    + "WHERE veiculoID = " + id;

            rs = st.executeQuery(sql);

            if(rs.next()){
                String placa = rs.getString("placa");
                String modelo = rs.getString("modelo");
                String marca = rs.getString("marca");
                int lugares = rs.getInt("lugares");
                double valorAlguel = rs.getDouble("valorAluguel");

                return new Veiculo(id, placa, modelo, marca, lugares, valorAlguel);
            }else {
                return null;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            assert rs != null;
            rs.close();
        }
        return null;
    }

    public void atualizar(Veiculo veiculo) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            con = Conexao.conectar();
            st = con.prepareStatement(
                    "UPDATE veiculo "
                            + "SET "
                            + "placa = ?, "
                            + "modelo = ?, "
                            + "marca = ?, "
                            + "lugares = ?, "
                            + "valorAluguel = ? "
                    + "WHERE "
                    + "veiculoID = ?");

            st.setString(1, veiculo.getPlaca());
            st.setString(2, veiculo.getModelo());
            st.setString(3, veiculo.getMarca());
            st.setInt(4, veiculo.getLugares());
            st.setDouble(5, veiculo.getValorAluguel());
            st.setLong(6, veiculo.getId());

            int rowsAffected = st.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert st != null;
            st.close();
        }
    }

    public void deletar(Long id) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            con = Conexao.conectar();
            st = con.prepareStatement(
                    "DELETE FROM veiculo WHERE veiculoID = " + id);

            int rowsAffected = st.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            assert st != null;
            st.close();
        }
    }

}
