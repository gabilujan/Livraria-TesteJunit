package Controle;

import javax.swing.*;
import java.awt.*;
import Conexao.conexao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
              
        
public class ReaCom extends JFrame {
    
    conexao con_cliente;

    JLabel codigo, idvenda, idlivro, compra, fil,fundo,Con, imagem;
    JTextField tcodigo, tidvenda, tidlivro,tquantidade, filtro;
    ImageIcon pesq;
    JButton Prx, Ant, Pmr, ult, limpar, Gvr, alt, Exc, pesquisar, sair;
    JTable tblClientes; // Datagrid
    JScrollPane scp_tabela; // Container para a datagrid
    ButtonGroup grupo;
    public ReaCom(){
        Container tela = getContentPane();        
        tela.setLayout(null);
        
        
        ImageIcon icone = new ImageIcon("src/image/livro3.png");
        setIconImage(icone.getImage());

        ImageIcon icone1 = new ImageIcon("src/image/carrinho-de-compras1.png");
        imagem = new JLabel(icone1);     
        imagem.setBounds(655, -25,300,300);

        con_cliente = new conexao(); // Inicialização do objeto
        con_cliente.conecta();

        setTitle("Realizar Compra");
        setResizable(false);

    
        codigo = new JLabel("Codigo Compra");
        idvenda = new JLabel("Id Venda");
        idlivro = new JLabel("Id Livro");
        compra = new JLabel("Quantidade Comprada");

        fil = new JLabel("Pesquisar código da Compra: ");
        
        Con = new JLabel("Manter Compra ");  
        Con.setFont(new Font("Arial",Font.BOLD,17));
        
        tcodigo = new JTextField(11);
        tquantidade = new JTextField(11);
        tidvenda = new JTextField(11);
        tidlivro = new JTextField(11);
        filtro = new JTextField(23);
        

        Prx = new JButton("Próximo");
        Ant = new JButton("Anterior");
        Pmr = new JButton("Primeiro");
        ult = new JButton("Último");
        limpar = new JButton("Limpar");
        Gvr = new JButton("Gravar");
        alt = new JButton("Alterar");
        Exc = new JButton("Excluir");
        pesquisar = new JButton("Pesquisar");
        sair = new JButton("Voltar");
 
        
        codigo.setBounds(90, -20, 100, 200);
        idvenda.setBounds(90, 15, 100, 200);
        idlivro.setBounds(90, 50, 100, 200);
        compra.setBounds(90, 90, 150, 200);
        fil.setBounds(200, 150, 220, 200);
        Con.setBounds(410, -60, 220, 200);
        
        
        codigo.setForeground(Color.white);
        idvenda.setForeground(Color.white);
        idlivro.setForeground(Color.white);
        compra.setForeground(Color.white);
        fil.setForeground(Color.white);
        Con.setForeground(Color.white);
        

        tcodigo.setBounds(250, 70, 180, 20);        
        tidvenda.setBounds(250, 105, 180, 20);
        tidlivro.setBounds(250, 140, 180, 20);
        tquantidade.setBounds(250, 180, 180, 20);
        filtro.setBounds(390, 240, 180, 20);

        Ant.setBounds(250, 400, 100, 20);
        ult.setBounds(370, 400, 100, 20);
        Pmr.setBounds(490, 400, 100, 20);
        Prx.setBounds(610, 400, 100, 20);
        limpar.setBounds(250, 450, 100, 20);
        Gvr.setBounds(370, 450, 100, 20);
        alt.setBounds(490, 450, 100, 20);
        Exc.setBounds(610, 450, 100, 20);
        pesquisar.setBounds(580, 240, 100, 20);
        sair.setBounds(431, 500, 100, 20);
        
        Prx.setFont(new Font("Arial",Font.BOLD,13));
        Prx.setBackground(new Color(58,58,58));
        Prx.setForeground(Color.white);
        Prx.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

        Ant.setFont(new Font("Arial",Font.BOLD,13));
        Ant.setBackground(new Color(58,58,58));
        Ant.setForeground(Color.white);
        Ant.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        Pmr.setFont(new Font("Arial",Font.BOLD,13));
        Pmr.setBackground(new Color(58,58,58));
        Pmr.setForeground(Color.white);
        Pmr.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        ult.setFont(new Font("Arial",Font.BOLD,13));
        ult.setBackground(new Color(58,58,58));
        ult.setForeground(Color.white);
        ult.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        limpar.setFont(new Font("Arial",Font.BOLD,13));
        limpar.setBackground(new Color(58,58,58));
        limpar.setForeground(Color.white);
        limpar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        Gvr.setFont(new Font("Arial",Font.BOLD,13));
        Gvr.setBackground(new Color(58,58,58));
        Gvr.setForeground(Color.white);
        Gvr.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        alt.setFont(new Font("Arial",Font.BOLD,13));
        alt.setBackground(new Color(58,58,58));
        alt.setForeground(Color.white);
        alt.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        Exc.setFont(new Font("Arial",Font.BOLD,13));
        Exc.setBackground(new Color(58,58,58));
        Exc.setForeground(Color.white);
        Exc.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        pesquisar.setFont(new Font("Arial",Font.BOLD,13));
        pesquisar.setBackground(new Color(58,58,58));
        pesquisar.setForeground(Color.white);
        pesquisar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        
        sair.setFont(new Font("Arial",Font.BOLD,13));
        sair.setBackground(new Color(58,58,58));
        sair.setForeground(Color.white);
        sair.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        tela.setBackground(new Color(50,50,50));
        
        // Configuração da JTable
        tblClientes = new javax.swing.JTable();
        scp_tabela = new javax.swing.JScrollPane();
        scp_tabela.setBounds(100,285,800,100);
        tblClientes.setBounds(100,285,900,100);          
        

        codigo.setFont(new Font("Arial",Font.BOLD,13));
        idvenda.setFont(new Font("Arial",Font.BOLD,13));
        compra.setFont(new Font("Arial",Font.BOLD,13));
        idlivro.setFont(new Font("Arial",Font.BOLD,13));
        fil.setFont(new Font("Arial",Font.BOLD,13));
        Con.setFont(new Font("Arial",Font.BOLD,20));
        tela.add(codigo);
        tela.add(idvenda);
        tela.add(idlivro);
        tela.add(compra);
        tela.add(fil);
        tela.add(Con);
        tela.add(Prx);
        tela.add(Ant);
        tela.add(Pmr);
        tela.add(ult);
        tela.add(limpar);
        tela.add(Gvr);
        tela.add(alt);
        tela.add(Exc);
        tela.add(pesquisar);
        tela.add(sair);
        tela.add(tcodigo);
        tela.add(tquantidade);
        tela.add(tidvenda);
        tela.add(tidlivro);
        tela.add(filtro);
        tela.add(tblClientes);
        tela.add(scp_tabela);
        tela.add(imagem);
           
        
        ImageIcon back = new ImageIcon("src/imagens/image.jpg");
        fundo = new JLabel(back);
        fundo.setBounds(0, 0, 800, 600);
        tela.add(fundo);
        
        //Verificar botões                 
        String td = tcodigo.getText() + tidvenda.getText() +tidlivro.getText() + tquantidade.getText();
        Prx.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {            
                try {
                     if(!con_cliente.resultset.isLast()) {
                        con_cliente.resultset.next();
                        mostrar_Dados();
                     }else {
                      JOptionPane.showMessageDialog(null, "O Último registro está selecionado, não existe registro posterior!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
   
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o próximo registro!" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        });
        Ant.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {                   
                try {
                    if (!con_cliente.resultset.isFirst()) {
                        con_cliente.resultset.previous();
                        mostrar_Dados();
                    } else {                        
                        JOptionPane.showMessageDialog(null, "Primeiro registro está selecionado, não existe registro anterior!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);                        
                    }
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o registro anterior!" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            
    }
});

        Pmr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {      
                    try {
                        con_cliente.resultset.first();
                        mostrar_Dados();
                    } catch (SQLException erro) {
                        JOptionPane.showMessageDialog(null, "Não foi possível acessar o primeiro registro!" + erro,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }                              
            }
        });
        ult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               try {
                    con_cliente.resultset.last();
                    mostrar_Dados();
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Não foi possível acessar o ùltimo registro!" + erro,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                } 
            }
        });
        limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                tcodigo.setText("");
                tidvenda.setText("");
                tidlivro.setText("");
                tquantidade.setText("");
               
           
            }
        });
        Gvr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = tcodigo.getText();
                String venda = tidvenda.getText();     
                String livro = tidlivro.getText();
                String quant = tquantidade.getText();
                       
                try {
                    if(td.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar gravação pois os campos estão vazios!","Mensagem do Programa", JOptionPane.WARNING_MESSAGE);
                        con_cliente.executaSQL("select * from compra order by Cod_Comp");
                        preencherTabela();
                    }else{
                        String insert_sql="insert into compra (Id_Ven,Id_Liv, Qtd_com) values ('"  + venda + "','" + livro + "','"+ quant+ "')";
                        con_cliente.statement.executeUpdate(insert_sql);
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    con_cliente.executaSQL("select * from compra order by Cod_Comp");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "Erro na gravação: " + errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        alt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {      
                String codigo = tcodigo.getText();
                String venda = tidvenda.getText();    
                String livro = tidlivro.getText();
                String quant= tquantidade.getText();
                String sql;
                String msg ="";
                
                       
                try {                   
                    if(td.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar alteração pois os campos estão vazios!","Mensagem do Programa", JOptionPane.WARNING_MESSAGE);
                        con_cliente.executaSQL("select * from compra order by Cod_Comp");
                        preencherTabela();
                    }else{
                        if(tcodigo.getText().equals("")){
                            sql="insert into compra (Id_Ven,Id_Liv, Qtd_com) values ('" + venda + "','" + livro + "','"+ quant+ "')";
                            msg = "Gravação de um novo registro.";
                        }else{
                            sql="update compra set Id_Ven = '" + venda+ "',Id_Liv='" + livro + "', Qtd_com='" + quant+ "' where Cod_Comp = " + tcodigo.getText();
                            msg = "Alteração de um registro.";
                        }
                        con_cliente.statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    
                    
                    con_cliente.executaSQL("select * from compra order by Cod_Comp");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "Erro na gravação: " + errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        Exc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sql="";
                String cod = tcodigo.getText();

                
                try {
                    if(cod.equals("")){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar exclusão, selecione algum registro! " ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                    }else{
                        int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
                        if(resposta == 0){
                            sql = "delete from compra where Cod_Comp = " + tcodigo.getText();
                            int excluir = con_cliente.statement.executeUpdate(sql);
                            if(excluir == 1){
                               JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso! " ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                               con_cliente.executaSQL("select * from compra order by Cod_Comp");
                               con_cliente.resultset.first();
                               preencherTabela();
                               posicionarRegistro();
                            }else{
                                JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário! " ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                            }
                        }
                    }                    
                } catch (SQLException excecao) {
                    JOptionPane.showMessageDialog(null, "Erro na Exclusão: " + excecao,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        pesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
                try {
                    String f = filtro.getText();
                    if(f != null && !f.isEmpty()){
                    String pesquisa = "select * from compra where Cod_Comp = '" + filtro.getText() + "%'";
                    con_cliente.executaSQL(pesquisa);
                    }else{
                        String pesquisa = "select * from compra";
                        con_cliente.executaSQL(pesquisa);
                    }
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
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
               Menu app = new Menu();
               app.setVisible(true);
               dispose();
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
        scp_tabela.setViewportView(tblClientes);
        tblClientes.setAutoCreateRowSorter(true);
 // Ativa a classificação ordenada da tabela

        // Fim da config da jtable

        setSize(1000, 620);
        setVisible(true);
        setLocationRelativeTo(null);
        

        con_cliente.executaSQL("select * from compra order by Cod_Comp");
        preencherTabela();
        posicionarRegistro();

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
            mostrar_Dados();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }

    }
       
    public void mostrar_Dados() {
        try {
            tcodigo.setText(con_cliente.resultset.getString("Cod_Comp"));
            tidvenda.setText(con_cliente.resultset.getString("Id_Ven"));
            tidlivro.setText(con_cliente.resultset.getString("Id_Liv"));
            tquantidade.setText(con_cliente.resultset.getString("Qtd_com"));
           
        } catch (SQLException erro) {
            //JOptionPane.showMessageDialog(null, "Não há dados na tabela", "Mensagem do Programa",      JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
    