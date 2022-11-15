/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package oom_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;
/**
 *
 * @author 91807
 */
public class Student {

    
    public static void main(String args[]) {
        
    }
}

class Loginpage implements ActionListener{
    JButton button = new JButton("Login");
    JTextField username;
    JPasswordField pwd;
    myFrame login= new myFrame("Login","pencil.png");
    public Loginpage(){
        JLabel usernameEnter= new JLabel("Enter the roll number:");
        login.setLayout(null);
        usernameEnter.setForeground(Color.white);
        usernameEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        login.add(usernameEnter);
        username= new JTextField();
        login.add(username);
        JLabel passwordEnter= new JLabel("Enter the password: ");
        passwordEnter.setForeground(Color.white);
        passwordEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        login.add(passwordEnter);
        pwd= new JPasswordField();
        login.add(pwd);
        login.add(button);
        button.setBounds(600,400,100,50);
        usernameEnter.setBounds(300,100,250,25);
        username.setBounds(600,100,200,25);
        passwordEnter.setBounds(300,200,200,25);
        pwd.setBounds(600,200,200,25);
        button.setFocusable(false);
        button.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            String p=String.valueOf(pwd.getPassword());
            boolean verify=authenticate(username.getText(),p);
            if(verify){
                login.dispose();
                Instructions i1=new Instructions();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your Roll Number or password is Incorrect. Try Again!","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    boolean authenticate(String a,String b){
        for(HashMap.Entry<String,String> ver : Register.RegisteredStudents.entrySet()){ 
            if((a.equals(ver.getKey()))&&(b.equals(ver.getValue()))){
                return true;
            }    
        }
        return false;
    }
}

class Instructions implements ActionListener{
    JButton proceed;
    myFrame iframe;
    public Instructions(){
        proceed=new JButton("Proceed");
        iframe=new myFrame("Instructions","pencil.png");
        iframe.setLayout(new GridLayout(7,1));
        JPanel p2=new JPanel();
        p2.add(proceed);
        p2.setBackground(new Color(0x123456));
        JLabel ins1=new JLabel("You have 5 good(Q1-5), 3 tough(Q6-8) and 2 complex questions(Q9-10) for your exam.");
        JLabel ins2=new JLabel("Each good question carries 5 marks, Each tough question carries 10 marks and Each complex question carries 15 marks.");
        JLabel ins3=new JLabel("You can submit your answer by clicking on Submit Question.");
        JLabel ins4=new JLabel("To review a question later, click on Bookmark Question.");
        JLabel ins5=new JLabel("To exit the exam, click on Submit Exam.");
        JLabel ins6=new JLabel("The testb will begin as you click on Proceed. All the best!");
        ins1.setForeground(Color.white);
        ins1.setFont(new Font("Sans Serif",Font.BOLD,20));
        ins2.setForeground(Color.white);
        ins2.setFont(new Font("Sans Serif",Font.BOLD,20));
        ins3.setForeground(Color.white);
        ins3.setFont(new Font("Sans Serif",Font.BOLD,20));
        ins4.setForeground(Color.white);
        ins4.setFont(new Font("Sans Serif",Font.BOLD,20));
        ins5.setForeground(Color.white);
        ins5.setFont(new Font("Sans Serif",Font.BOLD,20));
        ins6.setForeground(Color.white);
        ins6.setFont(new Font("Sans Serif",Font.BOLD,20));
        iframe.add(ins1);
        iframe.add(ins2);
        iframe.add(ins3);
        iframe.add(ins4);
        iframe.add(ins5);
        iframe.add(ins6);
        iframe.add(p2);
        Answers a1=new Answers();
        proceed.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==proceed){
            iframe.dispose();
            Questiondisplay qw= new Questiondisplay(PaperSet.qpaper.get(0),1);
        }
    }    
}

class Answers{
    static HashMap<Integer,Integer> sa;
    public Answers(){
        sa=new HashMap<>();
        for(int i=0;i<10;i++){
            sa.put(i,0);
        }
    }
}