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
    
    myFrame login= new myFrame("Login","pencil.png");
    public Loginpage(){
        JLabel usernameEnter= new JLabel("Enter the roll number:");
        login.setLayout(null);
        usernameEnter.setForeground(Color.white);
        usernameEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        login.add(usernameEnter);
        JTextField username= new JTextField();
        login.add(username);
        JLabel passwordEnter= new JLabel("Enter the password: ");
        passwordEnter.setForeground(Color.white);
        passwordEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        login.add(passwordEnter);
        JPasswordField pwd= new JPasswordField();
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
            login.dispose();
            Questiondisplay qw= new Questiondisplay(PaperSet.qpaper.get(0));
        }
    }
}

