package Controle;

import javax.swing.*;
import java.awt.*;
import java.text.*;
import Conexao.conexao;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
        
   
        
public class CadLiv extends JFrame {
    
    conexao con_cliente;
   
    JLabel codigo, titulo, categoria, isbn, idioma,paginas,preco, qtdest, fil,fundo,Con, imagem;
    JTextField tcodigo, ttitulo, tcategoria, tidioma, tpaginas, tpreco, tqtdest, filtro;
    ImageIcon pesq;
    JButton Prx, Ant, Pmr, ult, limpar, Gvr, alt, Exc, pesquisar, sair;
    JTable tblClientes; // Datagrid
    JScrollPane scp_tabela; // Container para a datagrid
    ButtonGroup grupo;
    JFormattedTextField tisbn;
    MaskFormatter misbnn;
    public CadLiv(){
        Container tela = getContentPane();        
        tela.setLayout(null);
        tela.setBackground(new Color(148, 231, 255));
        
        ImageIcon icone = new ImageIcon("src/image/livro3.png");
        setIconImage(icone.getImage());

        ImageIcon icone1 = new ImageIcon("src/image/pilha-de-livros.png");
            imagem = new JLabel(icone1);     
            imagem.setBounds(655, -25,300,300);
            tela.add(imagem);
           

        con_cliente = new conexao(); // Inicialização do objeto
        con_cliente.conecta();

        setTitle("Manter Dados do livro");
        setResizable(false);

        
        
        codigo = new JLabel("Código Liv ");
        titulo = new JLabel("Titulo ");
        idioma = new JLabel("Idioma ");
        isbn = new JLabel("ISBN ");
        categoria = new JLabel("Categoria ");
        paginas = new JLabel("Páginas ");
        preco = new JLabel("Preço ");
        qtdest = new JLabel("Quantidade em Estoque ");
        fil = new JLabel("Pesquisar titulo ");
        
        Con = new JLabel("Manter Livros ");  
        Con.setFont(new Font("Arial",Font.BOLD,17));
        
        tcodigo = new JTextField(5);
        ttitulo = new JTextField(20);       
        tcategoria = new JTextField(25);

        tidioma = new JTextField(25);
        tpaginas = new JTextField(25);   
        tpreco = new JTextField(25);       
        tqtdest = new JTextField(15);
        filtro = new JTextField(23);
        
        try {
            misbnn = new MaskFormatter("###-##########");
            misbnn.setPlaceholderCharacter('_');
        }catch (ParseException excp) {
            
        }

        tisbn = new JFormattedTextField(misbnn);
        tisbn.setBounds(180, 160, 180, 20);
        
        
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
        titulo.setBounds(100, 10, 100, 200);
        categoria.setBounds(100, 40, 100, 200);
        isbn.setBounds(100, 70, 100, 200);
        idioma.setBounds(100, 100, 100, 200);
        paginas.setBounds(400, -20, 100, 200);
        preco.setBounds(400, 10, 100, 200);
        qtdest.setBounds(400, 40, 180, 200);
        fil.setBounds(280, 150, 220, 200);
        Con.setBounds(410, -60, 220, 200);
        
        
        
        
        
        codigo.setForeground(Color.white);
        titulo.setForeground(Color.white);
        categoria.setForeground(Color.white);
        isbn.setForeground(Color.white);
        isbn.setForeground(Color.white);
        idioma.setForeground(Color.white);
        paginas.setForeground(Color.white);
        preco.setForeground(Color.white);
        qtdest.setForeground(Color.white);
        fil.setForeground(Color.white);
        Con.setForeground(Color.white);
        
        
        
        

        tcodigo.setBounds(180, 70, 180, 20);
        ttitulo.setBounds(180, 100, 180, 20);
        tcategoria.setBounds(180, 130, 180, 20);
        tisbn.setBounds(180, 160, 180, 20);
        tidioma.setBounds(180, 190, 180, 20);
        tpaginas.setBounds(480, 70, 180, 20);
        tpreco.setBounds(480, 100, 180, 20);
        tqtdest.setBounds(565, 130, 95, 20);
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

        titulo.setFont(new Font("Arial",Font.BOLD,13));
 
        categoria.setFont(new Font("Arial",Font.BOLD,13));
        isbn.setFont(new Font("Arial",Font.BOLD,13));
        idioma.setFont(new Font("Arial",Font.BOLD,13));
        paginas.setFont(new Font("Arial",Font.BOLD,13));
        preco.setFont(new Font("Arial",Font.BOLD,13));
        qtdest.setFont(new Font("Arial",Font.BOLD,13));
        fil.setFont(new Font("Arial",Font.BOLD,13));

        Con.setFont(new Font("Arial",Font.BOLD,20));
  


        tela.add(codigo);
        tela.add(titulo);
        tela.add(idioma);
        tela.add(isbn);
        tela.add(categoria);
        tela.add(paginas);
        tela.add(preco);
        tela.add(qtdest);
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
        tela.add(tisbn);
        tela.add(ttitulo);
        tela.add(tcategoria);
        tela.add(tidioma);
        tela.add(tpaginas);
        tela.add(tpreco);
        tela.add(tqtdest);
        tela.add(filtro);

        tela.add(tblClientes);
        tela.add(scp_tabela);
           
        
        ImageIcon back = new ImageIcon("src/imagens/image.jpg");
        fundo = new JLabel(back);
        fundo.setBounds(0, 0, 800, 600);
        tela.add(fundo);
        
        //Verificar botões 
        String td = tcodigo.getText() + ttitulo.getText() + tcategoria.getText() + tidioma.getText() + tisbn.getText() + tpaginas.getText() + tpreco.getText()+ tqtdest.getText();
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
                ttitulo.setText("");
                tcategoria.setText("");
                tisbn.setText("");
                tidioma.setText("");
                tpaginas.setText("");
                tpreco.setText("");
                tqtdest.setText("");
            }
        });
        Gvr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = ttitulo.getText();
                String categoria = tcategoria.getText();
                String isbn = tisbn.getText();
                String idioma = tidioma.getText();
                String paginas = tpaginas.getText();
                String preco = tpreco.getText();
                String qtdest = tqtdest.getText();
                                    
            
                try {
                    if(td.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar gravação pois os campos estão vazios!","Mensagem do Programa", JOptionPane.WARNING_MESSAGE);
                        con_cliente.executaSQL("select * from livro order by Cod_Liv");
                        preencherTabela();
                    }else{
                        String insert_sql="insert into livro ( Titulo, Categoria, ISBN, Idioma, Qtde_Pg, Preço, Qtd_Est) values ('" + titulo + "','" + categoria + "','" + isbn + "','" + idioma + "','" + paginas + "','" + preco + "','" + qtdest + "')";
                        con_cliente.statement.executeUpdate(insert_sql);
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    con_cliente.executaSQL("select * from livro order by Cod_Liv");
                    preencherTabela();
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "Erro na gravação: " + errosql,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        alt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {      
                String titulo = ttitulo.getText();
                String categoria = tcategoria.getText();
                String isbn = tisbn.getText();
                String idioma = tidioma.getText();
                String paginas = tpaginas.getText();
                String preco = tpreco.getText();
                String qtdest = tqtdest.getText();
                String sql;
                String msg ="";
                       
                try {
                    if(td.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Não é possível realizar alteração pois os campos estão vazios!","Mensagem do Programa", JOptionPane.WARNING_MESSAGE);
                        con_cliente.executaSQL("select * from livro order by Cod_Liv");
                        preencherTabela();
                    }else{
                        if(tcodigo.getText().equals("")){
                            sql="insert into livro ( Titulo, Categoria, ISBN, Idioma, Qtde_Pg, Preço, Qtd_Est) values ('" + titulo + "','" + categoria + "','" + isbn + "','" + idioma + "','" + paginas + "','" + preco + "','" + qtdest + "')";
                            msg = "Gravação de um novo registro.";
                        }else{
                            sql="update livro set Titulo = '" + titulo + "', Categoria = '" + categoria + "',ISBN = '" + isbn + "', Idioma = '" + idioma + "',Qtde_Pg = '" + paginas + "', Preço = '" + preco + "', Qtd_Est = '" + qtdest + "' where Cod_Liv = " + tcodigo.getText();
                            msg = "Alteração de um registro.";
                        }
                        con_cliente.statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }
                    con_cliente.executaSQL("select * from livro order by Cod_Liv");
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
                            sql = "delete from livro where Cod_Liv = " + tcodigo.getText();
                            int excluir = con_cliente.statement.executeUpdate(sql);
                            if(excluir == 1){
                               JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso! " ,"Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE); 
                               con_cliente.executaSQL("select * from livro order by Cod_Liv");
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
                    String pesquisa = "select * from livro where Titulo like '" + filtro.getText() + "%'";
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
                new String[]{"Cod Livro", "Titulo", "Categoria", "ISBN", "Idioma", "Qtde_Pgs", "Preço", "Qtd_Est"}) {
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
        

        con_cliente.executaSQL("select * from livro order by Cod_Liv");
        preencherTabela();
        posicionarRegistro();

    }

    /**
     *
     */
    public void preencherTabela() {
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(10);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(120);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(90);
        tblClientes.getColumnModel().getColumn(4).setPreferredWidth(40);
        tblClientes.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblClientes.getColumnModel().getColumn(6).setPreferredWidth(30);
        tblClientes.getColumnModel().getColumn(7).setPreferredWidth(30);

        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);

        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[] {
                        con_cliente.resultset.getString("Cod_Liv"),
                        con_cliente.resultset.getString("Titulo"),
                        con_cliente.resultset.getString("Categoria"), 
                        con_cliente.resultset.getString("ISBN"),
                        con_cliente.resultset.getString("Idioma"),
                        con_cliente.resultset.getString("Qtde_Pg"),
                        con_cliente.resultset.getString("Preço"),
                        con_cliente.resultset.getString("Qtd_Est")
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
            tcodigo.setText(con_cliente.resultset.getString("Cod_Liv"));
            ttitulo.setText(con_cliente.resultset.getString("Titulo"));
            tcategoria.setText(con_cliente.resultset.getString("Categoria"));
            tisbn.setText(con_cliente.resultset.getString("ISBN"));
            tidioma.setText(con_cliente.resultset.getString("Idioma"));
            tpaginas.setText(con_cliente.resultset.getString("Qtde_Pg"));
            tpreco.setText(con_cliente.resultset.getString("Preço"));
            tqtdest.setText(con_cliente.resultset.getString("Qtd_Est"));
        } catch (SQLException erro) {
            //JOptionPane.showMessageDialog(null, "Não há dados na tabela", "Mensagem do Programa",      JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
    
