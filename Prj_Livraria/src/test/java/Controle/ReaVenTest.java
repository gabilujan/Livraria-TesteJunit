package Controle;

import Conexao.conexao;
import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReaVenTest {

    private ReaVen reaVen;

    @BeforeAll
    void setupDatabaseConnection() {
        // Inicializa a conexão com o banco de dados antes de todos os testes
        reaVen = new ReaVen();
        reaVen.con_cliente = new conexao();
        reaVen.con_cliente.conecta();
    }

    @AfterAll
    void tearDown() throws SQLException {
        // Fecha a conexão com o banco de dados após todos os testes
        if (reaVen.con_cliente.con != null && !reaVen.con_cliente.con.isClosed()) {
            reaVen.con_cliente.con.close();
        }
    }

    @BeforeEach
    void setup() throws SQLException {
        // Limpa os dados da tabela `venda` antes de cada teste
        reaVen.con_cliente.statement.executeUpdate("DELETE FROM venda");
    }

    @Test
    void testCreateVenda() throws SQLException {
        // Configura os dados para inserir
        reaVen.tid_cli.setText("1");
        reaVen.tid_fun.setText("1");
        reaVen.tdatven.setText("01/01/2024");

        // Executa a gravação
        reaVen.Gvr.doClick();

        // Verifica se o dado foi inserido
        ResultSet rs = reaVen.con_cliente.statement.executeQuery("SELECT * FROM venda WHERE Id_Cli = '1'");
        assertTrue(rs.next());
        assertEquals("1", rs.getString("Id_Cli"));
        assertEquals("1", rs.getString("Id_Fun"));
        assertEquals("2024-01-01", rs.getString("Dt_Venda")); // Assumindo formato YYYY-MM-DD no banco
    }

    @Test
    void testReadVenda() throws SQLException {
        // Inserindo um registro diretamente
        reaVen.con_cliente.statement.executeUpdate(
            "INSERT INTO venda (Id_Cli, Id_Fun, Dt_Venda) VALUES ('1', '1', '2024-01-01')"
        );

        // Posiciona no primeiro registro
        reaVen.con_cliente.resultset = reaVen.con_cliente.statement.executeQuery("SELECT * FROM venda");
        reaVen.con_cliente.resultset.first();
        reaVen.mostrar_Dados();

        // Verifica se os dados são exibidos corretamente na interface
        assertEquals("1", reaVen.tcodigo.getText());
        assertEquals("1", reaVen.tid_cli.getText());
        assertEquals("1", reaVen.tid_fun.getText());
        assertEquals("01/01/2024", reaVen.tdatven.getText());
    }

    @Test
    void testUpdateVenda() throws SQLException {
        // Inserindo um registro diretamente
        reaVen.con_cliente.statement.executeUpdate(
            "INSERT INTO venda (Id_Cli, Id_Fun, Dt_Venda) VALUES ('1', '1', '2024-01-01')"
        );

        // Posiciona no primeiro registro e altera
        reaVen.con_cliente.resultset = reaVen.con_cliente.statement.executeQuery("SELECT * FROM venda");
        reaVen.con_cliente.resultset.first();
        reaVen.mostrar_Dados();

        // Altera os dados
        reaVen.tid_cli.setText("2");
        reaVen.tid_fun.setText("2");
        reaVen.tdatven.setText("02/02/2024");

        // Executa a alteração
        reaVen.alt.doClick();

        // Verifica se os dados foram atualizados no banco
        ResultSet rs = reaVen.con_cliente.statement.executeQuery("SELECT * FROM venda WHERE Id_Cli = '2'");
        assertTrue(rs.next());
        assertEquals("2", rs.getString("Id_Cli"));
        assertEquals("2", rs.getString("Id_Fun"));
        assertEquals("2024-02-02", rs.getString("Dt_Venda"));
    }

    @Test
    void testDeleteVenda() throws SQLException {
        // Inserindo um registro diretamente
        reaVen.con_cliente.statement.executeUpdate(
            "INSERT INTO venda (Id_Cli, Id_Fun, Dt_Venda) VALUES ('1', '1', '2024-01-01')"
        );

        // Posiciona no primeiro registro e apaga
        reaVen.con_cliente.resultset = reaVen.con_cliente.statement.executeQuery("SELECT * FROM venda");
        reaVen.con_cliente.resultset.first();
        reaVen.mostrar_Dados();

        // Executa a exclusão
        reaVen.Exc.doClick();

        // Verifica se o dado foi excluído do banco
        ResultSet rs = reaVen.con_cliente.statement.executeQuery("SELECT * FROM venda WHERE Id_Cli = '1'");
        assertFalse(rs.next());
    }
}
