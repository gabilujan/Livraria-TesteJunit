package Controle;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CadCliTest {

    private CadCli cadCli;

    @BeforeEach
    void setUp() {
        cadCli = new CadCli();
    }

    @AfterEach
    void tearDown() {
        cadCli = null;
    }

    @Test
    void testInsertClient() throws SQLException {
        // Simulação de inserir um cliente
        cadCli.tnome.setText("Test Client");
        cadCli.dat.setText("123.456.789-00");
        cadCli.tel.setText("(12) 34567-8900");
        cadCli.temail.setText("test@test.com");

        cadCli.Gvr.doClick(); // Simula o clique no botão "Gravar"

        // Verifica se o cliente foi inserido
        cadCli.con_cliente.executaSQL("SELECT * FROM cliente WHERE Nome_Cli = 'Test Client'");
        ResultSet resultSet = cadCli.con_cliente.resultset;
        assertTrue(resultSet.next(), "O cliente deve estar presente no banco de dados");
        assertEquals("Test Client", resultSet.getString("Nome_Cli"));
    }

    @Test
    void testUpdateClient() throws SQLException {
        // Simulação de atualizar um cliente
        cadCli.tcodigo.setText("1"); // Assumindo que o cliente com código 1 existe
        cadCli.tnome.setText("Updated Client");
        cadCli.dat.setText("987.654.321-00");
        cadCli.tel.setText("(21) 76543-2100");
        cadCli.temail.setText("updated@test.com");

        cadCli.alt.doClick(); // Simula o clique no botão "Alterar"

        // Verifica se o cliente foi atualizado
        cadCli.con_cliente.executaSQL("SELECT * FROM cliente WHERE Cod_Cli = 1");
        ResultSet resultSet = cadCli.con_cliente.resultset;
        assertTrue(resultSet.next(), "O cliente deve estar presente no banco de dados");
        assertEquals("Updated Client", resultSet.getString("Nome_Cli"));
    }

    @Test
    void testDeleteClient() throws SQLException {
        // Simulação de deletar um cliente
        cadCli.tcodigo.setText("1"); // Assumindo que o cliente com código 1 existe

        cadCli.Exc.doClick(); // Simula o clique no botão "Excluir"

        // Verifica se o cliente foi excluído
        cadCli.con_cliente.executaSQL("SELECT * FROM cliente WHERE Cod_Cli = 1");
        ResultSet resultSet = cadCli.con_cliente.resultset;
        assertFalse(resultSet.next(), "O cliente não deve estar presente no banco de dados");
    }

    @Test
    void testSearchClient() throws SQLException {
        // Simulação de pesquisar um cliente
        cadCli.filtro.setText("Test");

        cadCli.pesquisar.doClick(); // Simula o clique no botão "Pesquisar"

        // Verifica se o cliente foi encontrado
        ResultSet resultSet = cadCli.con_cliente.resultset;
        assertTrue(resultSet.next(), "Deve haver clientes com o nome que começa com 'Test'");
        assertTrue(resultSet.getString("Nome_Cli").startsWith("Test"));
    }
}
