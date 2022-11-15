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
    myFrame t;
    JButton exit;
    JButton another;
    JLabel[] answs;
    public Marks(){
        t=new myFrame("Result","Pencil.png");
        t.setLayout(new GridLayout(5,1));
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
        display();
        b1.add(exit);
        b2.add(another);
        t.add(mark);
        t.add(grade);
        JPanel b4=new JPanel();
        b4.setLayout(new GridLayout(10,1));
        b4.setBackground(new Color(0x123456));
        for(int j=0;j<10;j++){
            b4.add(answs[j]);
        }
        t.add(b4);
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
    public void display(){
        answs=new JLabel[10];
        int i=0;
        for(HashMap.Entry<Integer,Response>r : Answers.res.entrySet()){ 
            answs[i]= new JLabel("For Q."+r.getKey()+",You selected option "+r.getValue().selected+" and the answer is option "+r.getValue().correct+".Thus, your answer is "+r.getValue().state);
            answs[i].setForeground(Color.white);
            answs[i].setFont(new Font("Sans Serif",Font.BOLD,15));
            i++;
        }
    }
}


    
    