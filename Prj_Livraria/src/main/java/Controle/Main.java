package Controle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Conexao.conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.net.URI;


public class Main extends JFrame {

    conexao con_cliente;

    JLabel title, user, senha,fundo,Con, imagem, conta, IconPass, IconUser, IconLogo, IconInsta, IconFace, IconTwitter, Entrar;
    JTextField tuser;
    JPasswordField tsenha;   
    JButton  sair, logar, Cadastrar;    
    private int chances = 0; // Definir o número de tentativas permitidas
    public String algo;
    public String algo2 = "b";
    public Main() {
        
        
        Container tela = getContentPane();        
       
        tela.setLayout(null);
       
        Icon IconP =  new ImageIcon("src/image/cadeado.png");
        Icon IconU =  new ImageIcon("src/image/userlogin.png");
       
        Icon IconF =  new ImageIcon("src/image/facebook.png");
        Icon IconI =  new ImageIcon("src/image/instagram.png");
        Icon IconT =   new ImageIcon("src/image/twitter.png");

            
        JLabel IconPass = new JLabel();
        IconPass.setIcon(IconP);
        JLabel IconUser = new JLabel();
        IconUser.setIcon(IconU);
        JLabel IconInsta = new JLabel();
        IconInsta.setIcon(IconI);
        JLabel IconFace = new JLabel();
        IconFace.setIcon(IconF);
        JLabel IconTwitter = new JLabel();
        IconTwitter.setIcon(IconT);
        
        IconPass.setBounds(150, 193, 32, 32);
        IconUser.setBounds(155, 110, 32, 32);
        IconFace.setBounds(260, 349, 64, 64);
        IconInsta.setBounds(290, 350, 64, 64);
        IconTwitter.setBounds(325, 351, 64, 64);
        tela.add(IconPass);
        tela.add(IconUser);
        tela.add(IconFace);
        tela.add(IconInsta);
        tela.add(IconTwitter);

        

        ImageIcon icone = new ImageIcon("src/image/livro2.png");
        setIconImage(icone.getImage());
        
        con_cliente = new conexao(); // Inicialização do objeto
        con_cliente.conecta();
        

        setTitle("Livrarias GCG");
        setResizable(false);

        Entrar = new JLabel("Entrar");
        title = new JLabel("Livraria GCG");
        user = new JLabel("Usuário ");
        senha = new JLabel("Senha ");
   
        
        tuser = new JTextField(30);
        tsenha = new JPasswordField(20);
        
        tuser.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tuser.setBackground(new Color(50,50,50));
        tuser.setForeground(Color.white);
        tuser.setCaretColor(Color.white);
        
        tsenha.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.white));
        tsenha.setBackground(new Color(50,50,50));
        tsenha.setForeground(Color.white);
        tsenha.setCaretColor(Color.white);
     
        sair = new JButton("Sair");
        logar = new JButton("Entrar");
        
        Entrar.setBounds(270, 0, 450, 90);
        title.setBounds(245, 305, 450, 90);
        user.setBounds(200, 0, 100, 200);
        senha.setBounds(200, 80, 100, 200);
        
        tuser.setBounds(200, 120, 205, 30);
        tsenha.setBounds(200, 200, 205, 30);
        logar.setBounds(200, 280, 205, 30);
        sair.setBounds(500, 320, 100, 25);
        
        Entrar.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        title.setFont(new Font("Arial",Font.PLAIN,20));
        user.setFont(new Font("Arial",Font.BOLD,18));
        senha.setFont(new Font("Arial",Font.BOLD,18)); 
        logar.setFont(new Font("Arial",Font.BOLD,14));        
        sair.setFont(new Font("Arial",Font.BOLD,14));
        
        
        Entrar.setForeground(Color.white);
        title.setForeground(Color.white);
        user.setForeground(Color.white);
        senha.setForeground(Color.white);
        logar.setBackground(new Color(58,58,58));
        sair.setBackground(Color.white);
        tela.setBackground(new Color(50,50,50));
        logar.setBorder(javax.swing.BorderFactory.createLineBorder(Color.white));
        logar.setForeground(Color.white);
        
        
        tela.add(Entrar);
        tela.add(title);
        tela.add(user);
        tela.add(senha);
        
        tela.add(tuser);
        tela.add(tsenha);
        
        tela.add(logar);
        
       
       
        
    

        
        
        
        sair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
                System.exit(0);
            }
        });
        logar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
               
                String us = tuser.getText();
                String  se = tsenha.getText();
              
                
                
                try {
                    if(us.isEmpty() || se.isEmpty()){
                        JOptionPane.showMessageDialog(null, "\n Você não inseriu dados, por favor digite os dados para realizar o acesso.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        
                        String pesquisa = "SELECT * FROM funcionario WHERE Usuario = '" + tuser.getText() + "' AND Senha = '" + tsenha.getText() + "'";
                        con_cliente.executaSQL(pesquisa);
                     
                        
                        
                        if (con_cliente.resultset.first()) {
                            
                            
                            Menu app = new Menu();
                            app.setVisible(true);
                            dispose();
                        } else {
                            chances++;
                            if (chances < 3) {
                                JOptionPane.showMessageDialog(null, "\n O usuário ou senha digitado está incorreto. Você tem " + (3-chances) + " chances restantes.", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(null, "\n Você excedeu o número máximo de tentativas. O programa será encerrado.", "Mensagem do Programa", JOptionPane.ERROR_MESSAGE);
                                dispose();
                            }
                        }
                    }
                } catch (SQLException errosql) {
                    JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados!! :\n " + errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
               }
                
            }
        });
         

 
        
       
        setSize(650,440);
        setVisible(true);
        setLocationRelativeTo(null);      
    }

  

    public static void main(String[] args) {
       Main app = new Main();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}




  