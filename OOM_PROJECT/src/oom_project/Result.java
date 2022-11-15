package oom_project;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.HashMap;
public class Result {

    public static void main(String args[]) {
    }
}

class Marks implements ActionListener{
    static int ma;
    static HashMap<Integer,Response> res=new HashMap<>();
    myFrame t;
    JButton exit;
    JButton another;
    public Marks(){
        t=new myFrame("Result","Pencil.png");
        t.setLayout(new GridLayout(4,1));
        String p=Integer.toString(ma);
        JLabel mark=new JLabel("Your total is "+ p);
        mark.setForeground(Color.white);
        mark.setFont(new Font("Sans Serif",Font.BOLD,20));
        t.setVisible(true);
        String a;
        if(ma>=70){
            a="Very Good Score- Grade A+";
        }
        else if((ma<70)&&(ma>=55)){
            a="Good Score- Grade A";
        }
        else if((ma<55)&&(ma>=40)){
            a="Decent Score- Grade B+";
        }
        else if((ma<40)&&(ma>=25)){
            a="Try Harder- Grade B";
        }
        else{
            a="Bad Score- Grade C";
        }
        JLabel grade=new JLabel(a);
        grade.setForeground(Color.white);
        grade.setFont(new Font("Sans Serif",Font.BOLD,20));
        JPanel b1=new JPanel();
        JPanel b2=new JPanel();
        JPanel b3=new JPanel();
        b1.setBackground(new Color(0x123456));
        b2.setBackground(new Color(0x123456));
        exit=new JButton("Exit");
        another=new JButton("Another student");
        b1.add(exit);
        b2.add(another);
        t.add(mark);
        t.add(grade);
        t.add(b1);
        t.add(b2);
        exit.addActionListener(this);
        another.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            t.dispose();
        }   
        else if(e.getSource()==another){
            t.dispose();
            User a1=new User();
        }
    }    
}

class Response{
    int quest;
    String selected;
    String correct;
    String state;
    public Response(int q,String s,String c,String st){
        quest=q;
        selected=s;
        correct=c;
        state=st;
    }
        
}
    
    