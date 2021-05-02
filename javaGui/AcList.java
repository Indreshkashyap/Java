import javax.swing.*;      
public class AcList{    
AcList(){    
JFrame f=new JFrame("AcList");            
JButton b=new JButton(new ImageIcon("D:\\download.jpg"));    
b.setBounds(100,100,100, 40);    
f.add(b);    
f.setSize(300,400);    
f.setLayout(null);    
f.setVisible(true);    
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
    }         
public static void main(String[] args) {    
    new ButtonExample();    
}    
}  
