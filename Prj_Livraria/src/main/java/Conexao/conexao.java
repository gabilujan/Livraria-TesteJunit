/*
 *Esta classe será responsável pela conexão com o MySql e terá 3 métodos:
 * -- método 1: abertura da conexão
 * -- método 2: fecham,ento da conexão
 * -- método 3: execução de comandos SQL
*/
package Conexao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; //para execução de comandos sql no ambiente java

public class conexao {
    final private String driver = "com.mysql.cj.jdbc.Driver"; //definição de driver MySql para acesso aos dados
    final private String url = "jdbc:mysql://localhost/livraria"; // acesso ao bd "clientes" no servidor (myAdmin)
    final private String usuario = "root"; // usuário do MySql
    final private String senha = ""; // senha do MySql
    private Connection conexao; //variável qye armazenará a conexão aberta
    public Statement statement; // variável para execução dos comandos SQL dentro do ambiente Java
    public ResultSet resultset; // variável que armazenará o resultadi da execução de um comando SQL
    public Connection connection;
    public Connection con;
    
    

    public boolean conecta() {
        boolean result = true;
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url,usuario,senha);
           
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null, "Driver não localizado", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch(SQLException Fonte){
            JOptionPane.showMessageDialog(null, "Fonte de Dados não localizado", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        result = false;
        }

        return result;

    } 
  
    public void desconecta() {
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null, "Conexão com o banco fechada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException fecha) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar o banco", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
      public void executaSQL(String sql){
        try{
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        }catch(SQLException excecao){
            JOptionPane.showMessageDialog(null,"Erro no comando SQL \n Erro:"+excecao, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
        // Método para executar comandos SQL que retornam ResultSet (ex: SELECT)
    public void executaQuery(String sql) {
        try {
            statement = conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL \nErro: " + excecao, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Método para executar comandos SQL que não retornam ResultSet (ex: INSERT, UPDATE, DELETE)
    public int executaUpdate(String sql) {
        try {
            statement = conexao.createStatement();
            return statement.executeUpdate(sql); // Retorna o número de linhas afetadas
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null, "Erro no comando SQL \nErro: " + excecao, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            return -1; // Retorna -1 em caso de erro
        }
    }
}
