package Controle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Conexao.conexao;
import java.sql.SQLException;

public class Menu extends JFrame {
    JPopupMenu opcoes1;
    JMenuBar barra;
    JMenu Sair, operacoes, fonte, cor, estilo, tamanho, Sobre, Cadastrar;
    JMenuItem en, consuVend, consuLiv, consuCli, COnsuCom, des, sair1, sobre1, limpar, ReaV, ReaC, CadC, CadL, SairI;
    JScrollPane rolagem;
    JToolBar barra1;
    JLabel backup1, backoffside, title, fundo, compra, venda, cliente, livro, backcenter1, rodapé, Funcionário;
    JButton Compr, Vend, Cli, Liv, sai;
    sobre sextajanela;
    ImageIcon imagens[], image[];
    

    JTextArea texto;
    JPanel painel;

    public Menu() {
        // definições da tela
        super("Livraria");
        Container tela = getContentPane();
        tela.setLayout(null);
        setResizable(false);
        
     
      

        // Definição do icone do prog
        ImageIcon icone = new ImageIcon("src/image/livro3.png");
        setIconImage(icone.getImage());
        ImageIcon back = new ImageIcon("src/image/RealizarCompra.png");
        compra = new JLabel(back);
        compra.setBounds(195, 160, 300, 300);
        tela.add(compra);
        
        
        
        ImageIcon back2 = new ImageIcon("src/image/RealizarVenda.png");
        venda = new JLabel(back2);
        venda.setBounds(40, 160, 300, 300);
        tela.add(venda);
        
         
        
        ImageIcon back3 = new ImageIcon("src/image/clientes2.png");
        cliente = new JLabel(back3);
        cliente.setBounds(40, -20, 300, 300);
        

        tela.add(cliente);
        ImageIcon back4 = new ImageIcon("src/image/livro45.png");
        livro = new JLabel(back4);
        livro.setBounds(195, -20, 300, 300);
        tela.add(livro);
        
        
        
        
        // Definição da barra de menu
        sai = new JButton("Sair");
        Compr = new JButton("Realizar Compra");
        Vend = new JButton("Realizar Venda");
        Cli = new JButton("Cadastrar Cliente");
        Liv = new JButton("Cadastrar Livro");

        // label
        
        
        title = new JLabel("Menu de Opções");
       

  
        sai.setBounds(225, 480, 80, 30);
       

        Compr.setBounds(280, 355, 135, 30);
        Vend.setBounds(120, 355, 135, 30);
        Cli.setBounds(120, 180, 135, 30);
        Liv.setBounds(280, 180, 135, 30);
        title.setBounds(180, 25, 450, 30);
        
        sai.setBackground(new Color(60,60,60));
        sai.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        sai.setForeground(Color.WHITE);
        
        Compr.setBackground(new Color(60,60,60));
        Compr.setForeground(Color.WHITE);
        Compr.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

        

        Vend.setBackground(new Color(60,60,60));
        Vend.setForeground(Color.WHITE);
        Vend.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

       

        Cli.setBackground(new Color(60,60,60));
        Cli.setForeground(Color.white);
        Cli.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        

        Liv.setBackground(new Color(60,60,60));
        Liv.setForeground(Color.WHITE);
        Liv.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.WHITE);
        
        

        barra = new JMenuBar();
        setJMenuBar(barra);


        Cadastrar = new JMenu("Gestionar");
        operacoes = new JMenu("Consultar");
        Sair = new JMenu("Sair");
        Sobre = new JMenu("Sobre");
        
        
        
        
        // Definições de itens do menu administrar
        CadC = new JMenuItem("Clientes");
        CadL = new JMenuItem("Livros");
        ReaV= new JMenuItem("Vendas");
        ReaC = new JMenuItem("Compras");
        
       
        // Definições de itens do menu consultas
        consuCli = new JMenuItem("Clientes");
        consuLiv = new JMenuItem("Livro");
        consuVend= new JMenuItem("Vendas");
        COnsuCom = new JMenuItem("Compras");
        
        
        
        // Definições de itens do menu sobre
        des = new JMenuItem("Desenvolvimento");
        
        
        // Definições de itens do menu sair
        SairI = new JMenuItem("Sair");

        // adicionando na barra de menu
        barra.add(Cadastrar);
        barra.add(operacoes);
        barra.add(Sobre);
        barra.add(Sair);

        
        tela.add(sai);
        tela.add(Compr);
        tela.add(Vend);
        tela.add(Cli);
        tela.add(Liv);
        tela.add(title);
      
        //tela.add(rodapé);

        // adicionando no menu opeações
        Cadastrar.add(CadC);
        Cadastrar.addSeparator();
        Cadastrar.add(CadL);
        Cadastrar.addSeparator();
        Cadastrar.add(ReaV);
        Cadastrar.addSeparator();
        Cadastrar.add(ReaC);
       
        
        operacoes.add(consuCli);
        operacoes.addSeparator();
        operacoes.add(consuLiv);
        operacoes.addSeparator();
        operacoes.add(consuVend);
        operacoes.addSeparator();
        operacoes.add(COnsuCom);
        
        
        Sobre.add(des);
        Sair.add(SairI);


        sair1 = new JMenuItem("Sair");
        sobre1 = new JMenuItem("Sobre");
        sair1.setMnemonic(KeyEvent.VK_R);
        sobre1.setMnemonic(KeyEvent.VK_C);
        
          
        
        // Botoes imagens declaraçoes

        Cli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadCli app = new CadCli();
                setVisible(true);
                dispose();
            }
        });

        // Barra com imagens
        barra1 = new JToolBar("Barra de Ferramentas");
        UIManager.put("ToolTip.background", SystemColor.info);
        UIManager.put("ToolTip.foreground", Color.blue);

        Compr.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReaCom app = new ReaCom();
                setVisible(true);
                dispose();
            }
        });

        Liv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               CadLiv app = new CadLiv();
               setVisible(true);
               dispose();
            }
        });
        Vend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReaVen app = new ReaVen();
                setVisible(true);
                dispose();
            }
        });
        
        ReaV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReaVen app = new ReaVen();
                setVisible(true);
                dispose();
            }
            
        });
        ReaC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ReaCom app = new ReaCom();
                setVisible(true);
                dispose();
            }
        });
        CadC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadCli app = new CadCli();
                setVisible(true);
                dispose();
            }
        });
        CadL.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CadLiv app = new CadLiv();
                setVisible(true);
                dispose();
            }
        });
        
        SairI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
       
            }
        });
        
        
         COnsuCom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsuCom app = new ConsuCom();
                setVisible(true);
                dispose();
            }
        });
        consuCli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 ConsuCli app = new ConsuCli();
                setVisible(true);
                dispose();
            }
        });
        consuLiv.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsuLiv app = new ConsuLiv();
                setVisible(true);
                dispose();
            }
        });
        consuVend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConsVend app = new ConsVend();
                setVisible(true);
                dispose();
            }
        });
        

        // Sobre
        des.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sextajanela = new sobre(null, "Sobre", true);
                sextajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                sextajanela.setVisible(true);
            }
        });
        
         sai.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
         
          ImageIcon backup2 = new ImageIcon("src/image/lendo.png");
        backoffside = new JLabel(backup2);
        backoffside.setBounds(450, 60, 512, 512);
        tela.add(backoffside);
         ImageIcon backup = new ImageIcon("src/image/5.png");
        backup1 = new JLabel(backup);
        backup1.setBounds(30, 90, 500, 500);
        tela.add(backup1);
       
       
       
        tela.setBackground(new Color(50,50,50));
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // **********************************main principal

    // *******************************************************

    // ******************************************************************************Menu
    // de opção sobre********************************************

    private class sobre extends JDialog {
        JButton sair;
        JLabel rotulo, rotulo1, rotulo2, rotulo3, exibir;

        public sobre(Frame owner, String title, boolean modal) {
            super(owner, title, modal);
            Container tela1 = getContentPane();

            // icone
            ImageIcon icone1 = new ImageIcon("src/image/livro3.png");
            setIconImage(icone1.getImage());

            // cor
            tela1.setBackground(new Color(58,58,58));

            tela1.setLayout(null);
            // layout do formulário
            
            rotulo = new JLabel("Desenvolvedores");
            rotulo.setFont(new Font("Arial",Font.BOLD,24));
            rotulo.setForeground(Color.white);
            
          
            rotulo2 = new JLabel("Gabriela Lujan Alves Severo Dos Santos");
            rotulo2.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,12));
            rotulo2.setForeground(Color.white);
            rotulo3 = new JLabel("Lucas Santos Marçal");
            rotulo3.setFont(new Font("Arial",Font.LAYOUT_LEFT_TO_RIGHT,12));
            rotulo3.setForeground(Color.white);
            exibir = new JLabel("3º Desenvolvimento de Sistemas - A");
            exibir.setForeground(Color.white);


            rotulo.setBounds(90, 20, 250, 20);
      
            rotulo2.setBounds(70, 85, 250, 20);
            rotulo3.setBounds(70, 110, 200, 20);
            exibir.setBounds(10, 180, 280, 20);

            tela1.add(rotulo);
         
            tela1.add(rotulo2);
            tela1.add(rotulo3);
            tela1.add(exibir);

            sair = new JButton("Voltar");
            sair.setBackground(new Color(58,58,58));
            sair.setForeground(Color.white);
            sair.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));

            sair.setBounds(145, 230, 100, 20);
            Sair5 tsair = new Sair5();
            sair.addActionListener(tsair);
            tela1.add(sair);
            setSize(400, 300);
            setLocationRelativeTo(null);
        }
    }

    // ****************************************************************fim*******************************************
    private class Sair5 implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            sextajanela.setVisible(false);
            sextajanela.dispose();
        }
    }
}
