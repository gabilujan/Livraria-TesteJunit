package Controle;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import Conexao.conexao;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
        
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;        
        
public class CadCli extends JFrame {
    
    conexao con_cliente;
   
    JLabel codigo, nome, cpf, telefone, email,fil,fundo,Con, imagem;
    JTextField tcodigo, tnome, temail,filtro;
    ImageIcon pesq;
    JFormattedTextField tel, dat;
    MaskFormatter mTel, mcpf;
    JButton Prx, Ant, Pmr, ult, limpar, Gvr, alt, Exc, pesquisar, sair;
    JTable tblClientes; // Datagrid
    JScrollPane scp_tabela; // Container para a datagrid
    ButtonGroup grupo;
    public CadCli(){
        Container tela = getContentPane();        
        tela.setLayout(null);
        tela.setBackground(new Color(148, 231, 255));
        
        ImageIcon icone = new ImageIcon("src/image/livro3.png");
        setIconImage(icone.getImage());

        ImageIcon icone1 = new ImageIcon("src/image/cliente11.png");
        imagem = new JLabel(icone1);     
        imagem.setBounds(675, -25,300,300);
        tela.add(imagem);
           

        con_cliente = new conexao(); // Inicialização do objeto
        con_cliente.conecta();

        setTitle("Manter Dados de Clientes");
        setResizable(false);
        
        codigo = new JLabel("Código Cli ");
        nome = new JLabel("Nome ");
        email = new JLabel("Email ");
        telefone = new JLabel("Telefone ");
        cpf = new JLabel("CPF ");
        fil = new JLabel("Pesquisar nome ");
        
        Con = new JLabel("Manter Clientes ");  
        Con.setFont(new Font("Arial",Font.BOLD,17));
        
        tcodigo = new JTextField(5);
        tnome = new JTextField(20);
        temail = new JTextField(25);
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
        
        codigo.setBounds(100, -20, 100, 200);
        nome.setBounds(100, 10, 100, 200);
        cpf.setBounds(100, 40, 100, 200);
        telefone.setBounds(100, 70, 100, 200);
        email.setBounds(100, 100, 100, 200);
        fil.setBounds(280, 150, 220, 200);
        Con.setBounds(410, -60, 220, 200);
        
        
        codigo.setForeground(Color.white);
        nome.setForeground(Color.white);
        cpf.setForeground(Color.white);
        telefone.setForeground(Color.white);
        email.setForeground(Color.white);
        fil.setForeground(Color.white);
        Con.setForeground(Color.white);

        
       

        tcodigo.setBounds(180, 70, 180, 20);
        tnome.setBounds(180, 100, 180, 20);
        temail.setBounds(180, 190, 180, 20);
        filtro.setBounds(390, 240, 180, 20);

        Prx.setBounds(250, 400, 100, 20);
        Ant.setBounds(370, 400, 100, 20);
        Pmr.setBounds(490, 400, 100, 20);
        ult.setBounds(610, 400, 100, 20);
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
        

        try {
            mcpf = new MaskFormatter("###.###.###-##");
            mTel = new MaskFormatter("(##) #####-####");
            mTel.setPlaceholderCharacter('_');
            mcpf.setPlaceholderCharacter('_');
        } catch (ParseException excp) {
        }

        tel = new JFormattedTextField(mTel);
        dat = new JFormattedTextField(mcpf);

        dat.setBounds(180, 130, 180, 20);
        tel.setBounds(180, 160, 180, 20);
        

        codigo.setFont(new Font("Arial",Font.BOLD,13));

        nome.setFont(new Font("Arial",Font.BOLD,13));
 
        cpf.setFont(new Font("Arial",Font.BOLD,13));
        telefone.setFont(new Font("Arial",Font.BOLD,13));
        email.setFont(new Font("Arial",Font.BOLD,13));
        fil.setFont(new Font("Arial",Font.BOLD,13));

        Con.setFont(new Font("Arial",Font.BOLD,20));
  
        tela.add(tel);
        tela.add(dat);

        tela.add(codigo);
        tela.add(nome);
        tela.add(email);
        tela.add(telefone);
        tela.add(cpf);
        tela.add(fil);
        tela.add(Con); tela.add(Prx); tela.add(Ant);
        tela.add(Pmr);
        tela.add(ult);
        tela.add(limpar);
        tela.add(Gvr);
        tela.add(alt);
        tela.add(Exc);
        tela.add(pesquisar);
  tela.add(sair);
        tela.add(tcodigo);
        tela.add(tnome);
        tela.add(temail);
        tela.add(filtro);
        tela.add(tblClientes);
        tela.add(scp_tabela);
        ImageIcon back = new ImageIcon("src/imagens/image.jpg");
        fundo = new JLabel(back);
        fundo.setBounds(0, 0, 800, 600);
        tela.add(fundo);
        
        //Verificar botões 
        String td = tcodigo.getText() + tel.getText() + temail.getText() + tnome.getText()+ dat.getText();
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
                tnome.setText("");
                dat.setText("");
                tel.setText("");
                temail.setText("");
            }
        });
        Gvr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = tnome.getText();
                String Cpf = dat.getText();
                String telefone = tel.getText();
                String email = temail.getText();
                       
                try {
                     if(td.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar gravação pois os campos estão vazios!","Mensagem do Programa", JOptionPane.WARNING_MESSAGE);
                        con_cliente.executaSQL("select * from cliente order by Cod_Cli");
                        preencherTabela();
                    }else{
                        String insert_sql="insert into cliente (Nome_Cli, Tel_Cli,Email_Cli, CPF_Cli) values ('" + nome + "','" + telefone + "','" + email + "','" + Cpf + "')";
                        con_cliente.statement.executeUpdate(insert_sql);
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                     }
                    con_cliente.executaSQL("select * from cliente order by Cod_Cli");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "Erro na gravação: " + errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        alt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {      
                String nome = tnome.getText();
                String Cpf = dat.getText();
                String telefone = tel.getText();
                String email = temail.getText();
                String sql;
                String msg ="";
                       
                try {
                    if(td.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar alteração pois os campos estão vazios!","Mensagem do Programa", JOptionPane.WARNING_MESSAGE);
                        con_cliente.executaSQL("select * from cliente order by Cod_Cli");
                        preencherTabela();
                    }else{
                        if(tcodigo.getText().equals("")){
                            sql="insert into cliente (Nome_Cli, Tel_Cli,Email_Cli, CPF_Cli) values ('" + nome + "','" + telefone + "','" + email + "','" + Cpf + "')";
                            msg = "Gravação de um novo registro.";
                        }else{
                            sql="update cliente set Nome_Cli = '" + nome + "', Tel_Cli = '" + telefone + "',Email_Cli='" + email + "', CPF_Cli='" + Cpf+ "' where Cod_Cli = " + tcodigo.getText();
                            msg = "Alteração de um registro.";
                        }
                    
                        con_cliente.statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }                    
                    con_cliente.executaSQL("select * from cliente order by Cod_Cli");
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
                            sql = "delete from cliente where Cod_Cli = " + tcodigo.getText();
                            int excluir = con_cliente.statement.executeUpdate(sql);
                            if(excluir == 1){
                               JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso! " ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                               con_cliente.executaSQL("select * from cliente order by Cod_Cli");
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
                    String pesquisa = "select * from cliente where Nome_Cli like '" + filtro.getText() + "%'";
                    con_cliente.executaSQL(pesquisa);
                    System.out.println(pesquisa);
                    
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
                new String[]{"Cod Cliente", "Nome", "Telefone", "Email", "CPF"}) {
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
        

        con_cliente.executaSQL("select * from cliente order by Cod_Cli");
        preencherTabela();
        posicionarRegistro();

    }

    public void preencherTabela() {
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(80);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(65);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(105);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(40);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[] {
                        con_cliente.resultset.getString("Cod_Cli"),
                        con_cliente.resultset.getString("Nome_Cli"),
                        con_cliente.resultset.getString("Tel_Cli"), 
                        con_cliente.resultset.getString("Email_Cli"),
                        con_cliente.resultset.getString("CPF_Cli")
                });
            }
        } catch (SQLException erro) {
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
            tcodigo.setText(con_cliente.resultset.getString("Cod_Cli"));
            tnome.setText(con_cliente.resultset.getString("Nome_Cli"));
            temail.setText(con_cliente.resultset.getString("Email_Cli"));
            tel.setText(con_cliente.resultset.getString("Tel_Cli"));
            dat.setText(con_cliente.resultset.getString("CPF_Cli"));
        } catch (SQLException erro) {
            //JOptionPane.showMessageDialog(null, "Não há dados na tabela", "Mensagem do Programa",      JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
    
