package oom_project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login{
    public static void main(String[] args) {
       User t=new User();
    }    
}    
    
class User implements ActionListener{
    JButton adminuser= new JButton("Admin Login");
    JButton stuser= new JButton("Student Login");
    myFrame u1= new myFrame("User","pencil.png");
    static boolean first=false;
    static boolean second=false;
    public User(){
        u1.add(adminuser);
        u1.add(stuser);
        u1.setLayout(null);
        stuser.setBounds(650,300,200,50);
        stuser.setFocusable(false);
        adminuser.addActionListener(this);
        stuser.addActionListener(this);
        adminuser.setBounds(400,300,200,50);
        adminuser.setFocusable(false);
        stuser.setEnabled(false);
        if((first==true)&&(second==true)){
            stuser.setEnabled(true);
            adminuser.setEnabled(false);
        }
    }   
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==stuser){
            u1.dispose();
            Loginpage student=new Loginpage();
        }
        else if(e.getSource()==adminuser){
            u1.dispose();
            Admin at= new Admin();
        }    
    }
}


class myFrame extends JFrame{
    myFrame(String title,String iconenter){
        setTitle(title);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        ImageIcon icon= new ImageIcon(getClass().getResource(iconenter));
        setIconImage(icon.getImage());
        getContentPane().setBackground(new Color(0x123456));
    }

}
