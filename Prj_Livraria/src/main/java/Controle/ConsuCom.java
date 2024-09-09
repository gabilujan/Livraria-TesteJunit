package Controle;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import Conexao.conexao;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
        
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;        
        
public class ConsuCom extends JFrame {
    
    conexao con_cliente;
    JButton voltar, pesquisar;
    JLabel fil, Con;
    JTextField filtro;
    JTable tblClientes; // Datagrid
    JScrollPane scp_tabela; // Container para a datagrid
    public ConsuCom(){
        Container tela = getContentPane();        
        tela.setLayout(null);
        tela.setBackground(new Color(58,58,58));
        
        ImageIcon icone = new ImageIcon("src/image/livro3.png");
        setIconImage(icone.getImage());

        con_cliente = new conexao(); // Inicialização do objeto
        con_cliente.conecta();
        voltar = new JButton("Voltar");
        voltar.setBounds(450, 650, 120, 20);
       
      
        voltar.setFont(new Font("Arial",Font.BOLD,12));
        voltar.setBackground(new Color(58,58,58));
        voltar.setForeground(Color.white);
        voltar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        Con = new JLabel("Consultar Compras ");  
        Con.setBounds(410, -60, 220, 200);
        Con.setFont(new Font("Arial",Font.BOLD,20));
        Con.setForeground(Color.white);
        
        fil = new JLabel("Pesquisar Código de Compra: ");
        fil.setBounds(180, -20, 220, 200);
        fil.setFont(new Font("Arial",Font.BOLD,14));
        fil.setBackground(Color.white);
        fil.setForeground(Color.white);
        
        filtro = new JTextField(23);
        filtro.setBounds(390, 70, 220, 20);
        filtro.setFont(new Font("Arial",Font.BOLD,14));
        filtro.setBackground(Color.white);
        
        pesquisar = new JButton("Pesquisar");
        pesquisar.setBounds(620, 70, 100, 20);
        pesquisar.setFont(new Font("Arial",Font.BOLD,12));
       pesquisar.setBackground(new Color(58,58,58));
        pesquisar.setForeground(Color.white);
        pesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        tblClientes = new javax.swing.JTable();
        scp_tabela = new javax.swing.JScrollPane();
        scp_tabela.setBounds(80,120,800,500);
        tblClientes.setBounds(80,120,900,500);
        
        voltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
               Menu app = new Menu();
               app.setVisible(true);
               dispose();
            }
        });
        pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
                try {
                    String pesquisa = "select * from compra where Cod_Comp = '" + filtro.getText() + "%'";
                    con_cliente.executaSQL(pesquisa);
                    
                    if(con_cliente.resultset.first()){
                        preencherTabela();
                    }else{
                         JOptionPane.showMessageDialog(null, "Não existem dados com este paramêtro!" ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                    }
                }catch (SQLException errossql) {
                    JOptionPane.showMessageDialog(null, "Os dados digitados não foram localizados: " + errossql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        tblClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblClientes.setFont(new java.awt.Font("Arial", 1, 12));

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null },
                        { null, null, null, null, null }
                },
                new String[]{"Cod compra", "Id venda", "Id livro", "Quantidade"}) {
            boolean[] canEdit = new boolean[] { false, false, false, false, false };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tblClientes.setAutoCreateRowSorter(true);

        // Adicione a tabela ao JScrollPane
        scp_tabela.setViewportView(tblClientes);

        // Adicione o JScrollPane ao conteúdo da tela
        tela.add(scp_tabela);
        tela.add(filtro);
        tela.add(pesquisar);
        tela.add(fil);
        tela.add(voltar);
        tela.add(Con);
        

        con_cliente.executaSQL("select * from compra order by Cod_Comp");
        preencherTabela();
        posicionarRegistro();

        setTitle("Consulta dos Dados das Compras");
        setResizable(false);
        setSize(1000, 750);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     *
     */
    public void preencherTabela() {
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(65);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(105);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[] {
                        con_cliente.resultset.getString("Cod_Comp"),
                        con_cliente.resultset.getString("Id_Ven"),
                        con_cliente.resultset.getString("Id_Liv"), 
                        con_cliente.resultset.getString("Qtd_com"),
                });
            }
        }catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!!" + erro, "Mesangem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void posicionarRegistro() {
        try{
            con_cliente.resultset.first();            
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
    
