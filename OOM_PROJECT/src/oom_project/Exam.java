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
    static int quesno;
    myFrame questions= new myFrame("Questions","pencil.png");
    JButton nextq;
    JButton sube;
    JButton subq;
    JButton bookq;
    JButton panelb[];    //*****************
    JRadioButton option1;
    JRadioButton option2;
    JRadioButton option3;
    JRadioButton option4;
    int an;  //****
    int sel;  //****
    public Questiondisplay(Question s,int qn){
        quesno=qn;
        questions.setBackground(Color.blue);
        JPanel qpanel= new JPanel();
        panelb= new JButton[10];   
        for(int i=0;i<10;i++){
            String p=Integer.toString(i+1);
            panelb[i]=new JButton(p);
            panelb[i].setFocusable(false);
            panelb[i].addActionListener(this);
            if(Answers.sa.get(i)==0){  //*****
                panelb[i].setBackground(Color.green);
            }
            else if(Answers.sa.get(i)==1){
                panelb[i].setEnabled(false);
                panelb[i].setBackground(Color.gray);
            }
            else if(Answers.sa.get(i)==2){
                panelb[i].setBackground(Color.blue);
            }
        }
        qpanel.setBackground(Color.cyan);
        JLabel q= new JLabel("               Question Numbers               ");
        JLabel good=new JLabel("               Good Questions               ");
        JLabel tough=new JLabel("              Tough Questions               ");
        JLabel complex=new JLabel("               Complex Questions               ");
        qpanel.add(q);
        qpanel.add(good);
        qpanel.add(panelb[0]);
        qpanel.add(panelb[1]);
        qpanel.add(panelb[2]);
        qpanel.add(panelb[3]);
        qpanel.add(panelb[4]);
        qpanel.add(tough);
        qpanel.add(panelb[5]);
        qpanel.add(panelb[6]);
        qpanel.add(panelb[7]);
        qpanel.add(complex);
        qpanel.add(panelb[8]);
        qpanel.add(panelb[9]);

        JLabel qt=new JLabel("Q."+qn+" "+s.ques);
        qt.setBounds(100,50,500,25);
        qt.setForeground(Color.white);
        qt.setFont(new Font("Sans Serif",Font.BOLD,20));
        ButtonGroup options= new ButtonGroup();
        option1= new JRadioButton(s.opt1);
        option2= new JRadioButton(s.opt2);
        option3= new JRadioButton(s.opt3);
        option4= new JRadioButton(s.opt4);
        an=s.ans;   //*********
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
        bookq= new JButton("Bookmark question");
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
        qpanel.setBounds(1000,100,200,360);
        qpanel.setPreferredSize(new Dimension(200,200));
        qpanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        questions.setVisible(true);
        nextq.addActionListener(this);
        bookq.addActionListener(this);
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);
        option4.addActionListener(this);
        subq.addActionListener(this);
        sube.addActionListener(this);
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
            if(quesno<10){
                questions.dispose();           //****
                Questiondisplay d= new Questiondisplay(PaperSet.qpaper.get(quesno),quesno+1);  //******
            }
            else{
                JOptionPane.showMessageDialog(null,"This is the end of questions.","Message",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(e.getSource()==subq){
            Answers.sa.put((quesno-1), 1);
            panelb[quesno-1].setEnabled(false);
            if(an==sel){
                Response m= new Response(quesno,Integer.toString(sel),Integer.toString(an),"correct");
                Answers.res.put(quesno,m);
                if((quesno>=1)&&(quesno<=5)){
                    Marks.ma=Marks.ma+5;
                }
                else if((quesno>=6)&&(quesno<=8)){
                    Marks.ma=Marks.ma+10;
                }
                else if(quesno>=9){
                    Marks.ma=Marks.ma+15;
                }
            }
            else{
                Response v= new Response(quesno,Integer.toString(sel),Integer.toString(an),"incorrect");
                Answers.res.put(quesno,v);
            }    
            if(quesno<10){
                
                questions.dispose();
                Questiondisplay d= new Questiondisplay(PaperSet.qpaper.get(quesno),quesno+1);
            }
        }
        else if(e.getSource()==bookq){
            Answers.sa.put((quesno-1),2);
            if(quesno<10){
                questions.dispose();
                Questiondisplay d= new Questiondisplay(PaperSet.qpaper.get(quesno),quesno+1);
            }    
        }
        else if(e.getSource()==sube){
            questions.dispose();
            Marks m3=new Marks();
        } 
        else{
            for(int j=0;j<10;j++){
                if(e.getSource()==panelb[j]){
                    questions.dispose();
                    Questiondisplay d= new Questiondisplay(PaperSet.qpaper.get(j),j+1);
                    quesno=j+1;
                }    

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
