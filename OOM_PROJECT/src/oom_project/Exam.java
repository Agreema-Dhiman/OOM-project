package oom_project;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Exam {

    public static void main(String args[]) {
        
        
    }
}

class Questiondisplay implements ActionListener{
    myFrame questions= new myFrame("Questions","pencil.png");
    JButton nextq;
    JButton sube;
    JButton subq;
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;
    static int c=0;
    int an;
    int sel;
    public Questiondisplay(Question s){
        questions.setBackground(Color.blue);
        JPanel qpanel= new JPanel();
        qpanel.setBackground(Color.cyan);
        JLabel q= new JLabel("               Question Numbers               ");
        JButton q1=new JButton("1");
        JButton q2=new JButton("2");
        JButton q3=new JButton("3");
        JButton q4=new JButton("4");
        JButton q5=new JButton("5");
        JButton q6=new JButton("6");
        JButton q7=new JButton("7");
        JButton q8=new JButton("8");
        JButton q9=new JButton("9");
        JButton q10=new JButton("10");
        qpanel.add(q);
        qpanel.add(q1);
        qpanel.add(q2);
        qpanel.add(q3);
        qpanel.add(q4);
        qpanel.add(q5);
        qpanel.add(q6);
        qpanel.add(q7);
        qpanel.add(q8);
        qpanel.add(q9);
        qpanel.add(q10);
        JLabel qt=new JLabel(s.ques);
        qt.setBounds(100,50,500,25);
        qt.setForeground(Color.white);
        qt.setFont(new Font("Sans Serif",Font.BOLD,20));
        ButtonGroup options= new ButtonGroup();
        option1= new JRadioButton(s.opt1);
        option2= new JRadioButton(s.opt2);
        option3= new JRadioButton(s.opt3);
        option4= new JRadioButton(s.opt4);
        an=s.ans;
        option1.setBounds(100,150,200,25);
        option2.setBounds(100,200,200,25);
        option3.setBounds(100,250,200,25);
        option4.setBounds(100,300,200,25);
        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);
        nextq=new JButton("Next question");
        subq= new JButton("Submit answer");
        sube=new JButton("Submit Exam");
        JButton bookq= new JButton("Bookmark question");
        nextq.setBounds(30,500,200,25);
        subq.setBounds(250,500,200,25);
        bookq.setBounds(470,500,200,25);
        sube.setBounds(690,500,200,25);
        questions.add(nextq);
        questions.add(subq);
        questions.add(bookq);
        questions.add(sube);
        questions.add(option1);
        questions.add(option2);
        questions.add(option3);
        questions.add(option4);
        questions.add(qt);
        questions.add(qpanel);
        questions.setLayout(null);
        qpanel.setBounds(1000,200,200,200);
        qpanel.setPreferredSize(new Dimension(200,200));
        qpanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        questions.setVisible(true);
        c++;
        nextq.addActionListener(this);
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);
        subq.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(option1.isSelected()){
            sel=1;
        }
        else if(option2.isSelected()){
            sel=2;
        }
        else if(option3.isSelected()){
            sel=3;
        }
        else if(option4.isSelected()){
            sel=4;
        }
                       
        if(e.getSource()==nextq){
            if(c<2){
                questions.dispose();
                Questiondisplay d= new Questiondisplay(PaperSet.qpaper.get(c));
            }
            else{
                questions.dispose();
                User p=new User();
            }
        }
        else if(e.getSource()==subq){
            if(an==sel){
                Marks.ma=Marks.ma+1;
            }
            
            if(c<2){
                
                questions.dispose();
                Questiondisplay d= new Questiondisplay(PaperSet.qpaper.get(c));
            }
            else{
                questions.dispose();
                Marks i=new Marks();
            }
        }    
    }
}    

class Question{
    String ques;
    String opt1;
    String opt2;
    String opt3;
    String opt4;
    int ans;
    public Question(String a,String b,String c,String d,String e,int f){
        ques=a;
        opt1=b;
        opt2=c;
        opt3=d;
        opt4=e;
        ans=f;
    }    
}