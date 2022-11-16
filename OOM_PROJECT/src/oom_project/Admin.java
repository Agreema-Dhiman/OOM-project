
package oom_project;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Admin {
    public Admin(){
        Adminlogin a2= new Adminlogin();
    }    
    public static void main(String args[]){
    }
}

class Adminlogin implements ActionListener{
    JButton b = new JButton("Login");
    myFrame ad= new myFrame("Login","pencil.png");
    
    static HashMap<String,String> allowedAdmin=new HashMap<>();
    boolean authenticate;
    JTextField id;
    JPasswordField apwd;
    
    public Adminlogin(){
        //----------ID----------
        JLabel idEnter= new JLabel("Enter the ID:");        
        ad.setLayout(null); //manually change the layout of the frame
        idEnter.setForeground(Color.white); //font color
        idEnter.setFont(new Font("Sans Serif",Font.BOLD,20)); //font style
        ad.add(idEnter); // frame adds label idEnter
        
        //textField
        id= new JTextField();
        ad.add(id); //adds textfield to frame
        
        //---------Password---------
        JLabel passwordEnter= new JLabel("Enter the password: ");
        passwordEnter.setForeground(Color.white);
        passwordEnter.setFont(new Font("Sans Serif",Font.BOLD,20));
        ad.add(passwordEnter);
        apwd= new JPasswordField();
        ad.add(apwd);
        
        //add Login button
        ad.add(b);
        b.setBounds(600,400,100,50);
        b.setFocusable(false); //to remove the unwanted box around the texts
        
        idEnter.setBounds(300,100,250,25);
        id.setBounds(600,100,200,25);
        passwordEnter.setBounds(300,200,200,25);
        apwd.setBounds(600,200,200,25);
        
        b.addActionListener(this);
    } 
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b){
            String pwd=String.valueOf(apwd.getPassword());
            authenticate=authorizationAdmin(id.getText(),pwd);
            if(authenticate){
                ad.dispose();
                Next n1= new Next();
            }
            else{
                JOptionPane.showMessageDialog(null,"Your ID or password is Incorrect. Try Again!","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }
    boolean authorizationAdmin(String a,String b){
        allowedAdmin.put("2021031","p@1");
        allowedAdmin.put("2021052","tt21");
        allowedAdmin.put("2021061","oy5^");
        for(HashMap.Entry<String,String> check : allowedAdmin.entrySet()){ 
            if((a.equals(check.getKey()))&&(b.equals(check.getValue()))){
                return true;
            }    
        }
        return false;           
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
        rinfo.addActionListener(this);
        if(User.first){
            setp.setEnabled(false);
        }
        if(User.second){
            rinfo.setEnabled(false);
        }
    } 
    
    public void actionPerformed( ActionEvent e){
        if(e.getSource()==setp){
            nt.dispose();
            PaperSet p1=new PaperSet();
        }
        else if(e.getSource()==rinfo){
            nt.dispose();
            Register r3=new Register();
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
        
        //correct option
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
        submit.add(sub);  //***********
        sub.addActionListener(this);
        count++;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==sub){
            String t1=q.getText();
            String t2=o1.getText();
            String t3=o2.getText();
            String t4=o3.getText();
            String t5=o4.getText();
            String t6=a.getText();
            int y=Integer.parseInt(t6);
            Question t=new Question(t1,t2,t3,t4,t5,y);
            qpaper.add(t);
            
            if(count<10){
               
               pap.dispose();
               PaperSet w=new PaperSet();
            }
            else{
                JOptionPane.showMessageDialog(null,"Exactly 10 questions have to be set. Thank You!","Message",JOptionPane.INFORMATION_MESSAGE);
                pap.dispose();
                User.first=true;
                User qwq=new User();
            }
        }    
    }
}

class Register implements ActionListener{
    static HashMap<String,String> RegisteredStudents=new HashMap<>();
    static int studentcount=0;
    myFrame r;
    JTextField rollt;
    JTextField pt;
    JButton enter;
    public Register(){
        r=new myFrame("Registering","pencil.png");
        r.setLayout(new GridLayout(3,2));
        JPanel submitd=new JPanel();
        submitd.setBackground(new Color(0x123456));
        enter=new JButton("Enroll");
        submitd.add(enter);
        JLabel roll=new JLabel("Enter student "+(studentcount+1)+" roll number: ");
        roll.setForeground(Color.white);
        roll.setFont(new Font("Sans Serif",Font.BOLD,20));
        JLabel p=new JLabel("Enter student "+(studentcount+1)+" password: ");
        p.setForeground(Color.white);
        p.setFont(new Font("Sans Serif",Font.BOLD,20));
        rollt=new JTextField();
        pt=new JTextField();
        r.add(roll);
        r.add(rollt);
        r.add(p);
        r.add(pt);
        r.add(submitd);
        studentcount++;
        enter.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enter){
            RegisteredStudents.put(rollt.getText(),pt.getText());
            if(studentcount>=3){
                JOptionPane.showMessageDialog(null,"Exactly 3 students have to be enrolled. Thank You!","Message",JOptionPane.INFORMATION_MESSAGE);
                r.dispose();
                User.second=true;
                User u3=new User();
            }
            else{
                r.dispose();
                Register r2= new Register();
            }
        }    
    }
}
