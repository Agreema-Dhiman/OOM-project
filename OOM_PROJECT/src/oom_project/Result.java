/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package oom_project;
import java.awt.*;
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
public class Result {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
    }
}

class Marks{
    static int ma;
    public Marks(){
        myFrame t=new myFrame("Result","Pencil.png");
        t.setLayout(new FlowLayout());
        String p=Integer.toString(ma);
        JLabel mark=new JLabel(p);
        mark.setForeground(Color.white);
        mark.setFont(new Font("Sans Serif",Font.BOLD,20));
        t.add(mark);
        t.setVisible(true);     
        
    }
}