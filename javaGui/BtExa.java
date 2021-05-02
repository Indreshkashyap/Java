import javax.swing.*;    
public class BtExa {  
public static void main(String[] args) {  
    JFrame.setDefaultLookAndFeelDecorated(true);

	JFrame f=new JFrame("BtExa");  
    JButton b=new JButton("Click Here");  
    b.setBounds(50,100,200,30);  
    f.add(b);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
}  
