package PL;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import BL.filemain;
import BL.filemaininterface;
import DAL.sql;
import DAL.sqlinterface;
public class home {
    private JButton create;
    private JButton open;
    private JButton importfile;
    private JButton viewall;
    private filemain o;
    private JFrame frame;
    filemaininterface obj;
    home(filemaininterface obj) {
    	importfile=new JButton("Import File");
    	this.obj=obj;
    	viewall =new JButton("View all files");
        create = new JButton("Create a new file");
        open=new JButton("Open existing File");
        frame = new JFrame();
        frame.setTitle("Home Page");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setLayout(new FlowLayout());  
        frame.add(create); 
        frame.add(open);
        frame.add(viewall);
        frame.add(importfile);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new create(obj);
				frame.dispose();
			}
        });
        open.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		        String fileName = JOptionPane.showInputDialog(frame, "Enter file name:", "Open a File", JOptionPane.PLAIN_MESSAGE);
                new open(obj,fileName);
                frame.dispose();
				// TODO Auto-generated method stub
				//o.op
				//frame.dispose();
			}
        });
        viewall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new viewall(obj);
				 frame.dispose();
			}
        	
        });
        importfile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new importing(obj);
				 frame.dispose();
			}
        });
    }
    public static void main(String args[]) {
        sqlinterface data=new sql();
        filemaininterface logic=new filemain(data);
        new home(logic);
        
    }
}
