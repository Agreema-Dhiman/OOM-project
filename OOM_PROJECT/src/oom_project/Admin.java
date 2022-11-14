
package oom_project;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

public class Admin {
    public Admin(){
        Adlog a2= new Adlog();
    }    
    public static void main(String args[]){
    }
}

class Adlog implements ActionListener{
    JButton b = new JButton("Login");
    myFrame ad= new myFrame("Login","pencil.png");
    public Adlog(){
        JLabel idEnter= new JLabel("Enter the ID:");
        ad.setLayout(null);
        idEnter.setForeground(Color.white);
        idEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        ad.add(idEnter);
        JTextField id= new JTextField();
        ad.add(id);
        JLabel passwordEnter= new JLabel("Enter the password: ");
        passwordEnter.setForeground(Color.white);
        passwordEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        ad.add(passwordEnter);
        JPasswordField apwd= new JPasswordField();
        ad.add(apwd);
        ad.add(b);
        b.setBounds(600,400,100,50);
        idEnter.setBounds(300,100,250,25);
        id.setBounds(600,100,200,25);
        passwordEnter.setBounds(300,200,200,25);
        apwd.setBounds(600,200,200,25);
        b.setFocusable(false);
        b.addActionListener(this);
    } 
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            ad.dispose();
            Next n1= new Next();
        }
    }
}

class Next implements ActionListener{
    JButton setp= new JButton("Set paper");
    JButton rinfo= new JButton("Enter registration information");
    myFrame nt= new myFrame("Admin actions","pencil.png");
    
    public Next(){
        nt.setLayout(null);
        nt.add(setp);
        nt.add(rinfo);
        setp.setBounds(400,300,200,50);
        setp.setFocusable(false);
        rinfo.setBounds(650,300,300,50);
        rinfo.setFocusable(false);
        setp.addActionListener(this);
    } 
    
    public void actionPerformed( ActionEvent e){
        if(e.getSource()==setp){
            nt.dispose();
            PaperSet p1=new PaperSet();
        }    
    }
}    

class PaperSet implements ActionListener{
    myFrame pap= new myFrame("Set Paper","pencil.png");
    JButton sub= new JButton("Set question");
    static ArrayList<Question> qpaper= new ArrayList<>();
    JTextField q;
    JTextField o1;
    JTextField o2;
    JTextField o3;
    JTextField o4;
    JTextField a;
    static int count=0;
    public PaperSet(){
        JLabel lq= new JLabel("Enter the question "+(count+1)+": ");
        lq.setForeground(Color.white);
        lq.setFont(new Font("Sans Serif",Font.BOLD,20));
        JLabel lo1= new JLabel("Enter the option 1:");
        lo1.setForeground(Color.white);
        lo1.setFont(new Font("Sans Serif",Font.BOLD,20));
        JLabel lo2= new JLabel("Enter the option 2:");
        lo2.setForeground(Color.white);
        lo2.setFont(new Font("Sans Serif",Font.BOLD,20));
        JLabel lo3= new JLabel("Enter the option 3:");
        lo3.setForeground(Color.white);
        lo3.setFont(new Font("Sans Serif",Font.BOLD,20));
        JLabel lo4= new JLabel("Enter the option 4:");
        lo4.setForeground(Color.white);
        lo4.setFont(new Font("Sans Serif",Font.BOLD,20));
        JLabel la= new JLabel("Enter the correct option: ");
        la.setForeground(Color.white);
        la.setFont(new Font("Sans Serif",Font.BOLD,20));
        q= new JTextField();
        o1= new JTextField();
        o2=new JTextField();
        o3=new JTextField();
        o4=new JTextField();
        a=new JTextField();
        pap.setLayout(new GridLayout(7,2));
        pap.add(lq);
        pap.add(q);
        pap.add(lo1);
        pap.add(o1);
        pap.add(lo2);
        pap.add(o2);
        pap.add(lo3);
        pap.add(o3);
        pap.add(lo4);
        pap.add(o4);
        pap.add(la);
        pap.add(a);  
        sub.setSize(100,100);
        JPanel submit= new JPanel();
        pap.add(submit);
        submit.setBackground(new Color(0x123456));
        submit.add(sub);
        sub.addActionListener(this);
        count++;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sub){
            if(count<2){
                String t1=q.getText();
                String t2=o1.getText();
                String t3=o2.getText();
                String t4=o3.getText();
                String t5=o4.getText();
                String t6=o4.getText();
                Question t=new Question(t1,t2,t3,t4,t5,t6);
                qpaper.add(t);
                pap.dispose();
                PaperSet w=new PaperSet();
            }
            else{
                String t1=q.getText();
                String t2=o1.getText();
                String t3=o2.getText();
                String t4=o3.getText();
                String t5=o4.getText();
                String t6=o4.getText();
                Question t=new Question(t1,t2,t3,t4,t5,t6);
                qpaper.add(t);
                pap.dispose();
                Questiondisplay qwq=new Questiondisplay(qpaper.get(0));
            }
        }    
    }
}
