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
/**
 *
 * @author 91807
 */
public class Student {

    /**
     * @param args the command line arguments
     */
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
                Questiondisplay qw= new Questiondisplay(PaperSet.qpaper.get(0));
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

