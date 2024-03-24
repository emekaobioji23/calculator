/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.calculator2022.versions;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
/**
 *
 * @author emeka
 */
public class Calculator_v2 {
 public static void main(String[] args){

		HashMap<String,JButton> calculatorButtons = new HashMap<String,JButton>();
		
		JFrame calculatorWindow = new JFrame("Calculator");
		calculatorWindow.setDefaultCloseOperation(calculatorWindow.EXIT_ON_CLOSE);
		calculatorWindow.setSize(300, 400);

		JPanel base = new JPanel();
		base.setSize(300,400);
		GridBagLayout gbl = new GridBagLayout();
		base.setLayout(gbl);
		Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4);
		base.setBorder(border1);
		base.setLocation(0,0);
		
		GeneralKeyBoardActivityListener_v2 gkbal = new GeneralKeyBoardActivityListener_v2(calculatorButtons);
		base.addKeyListener(gkbal);
		base.setFocusable(true);
  		base.requestFocusInWindow();

		calculatorWindow.getContentPane().add(base);
		
		JLabel screen = new JLabel(" ");
		screen.setOpaque(true);
		screen.setBackground(Color.lightGray);
		screen.setForeground(Color.black);
		screen.setHorizontalAlignment(SwingConstants.RIGHT);
		Font font1 = new Font("Serif", Font.BOLD, 50);
		screen.setFont(font1);
		Border border2 = BorderFactory.createLoweredBevelBorder();;
        	screen.setBorder(border2);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 5;
		base.add(screen,c);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		JButton seven=new JButton("7");
                seven.setForeground(Color.white);
                seven.setBackground(Color.black);
		NormalButtonActionListener_v2 nbal = new NormalButtonActionListener_v2(screen);
		seven.addActionListener(nbal);
		base.add(seven,c);
		calculatorButtons.put("7",seven);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth=1;
		JButton eight=new JButton("8");
		nbal = new NormalButtonActionListener_v2(screen);
		eight.addActionListener(nbal);
		base.add(eight,c);
		calculatorButtons.put("8",eight);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth=1;
		JButton nine=new JButton("9");
		nbal = new NormalButtonActionListener_v2(screen);
		nine.addActionListener(nbal);
		base.add(nine,c);
		calculatorButtons.put("9",nine);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth=1;
		JButton del=new JButton("DEL");
		DelButtonActionListener_v2 dbal = new DelButtonActionListener_v2(screen);
		del.addActionListener(dbal);
		base.add(del,c);
		calculatorButtons.put("del",del);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth=1;
		JButton ac=new JButton("AC");
		ACButtonActionListener_v2 acbal = new ACButtonActionListener_v2(screen);
		ac.addActionListener(acbal);
		base.add(ac,c);
		calculatorButtons.put("ac",ac);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth=1;
		JButton four=new JButton("4");
		nbal = new NormalButtonActionListener_v2(screen);
		four.addActionListener(nbal);
		base.add(four,c);
		calculatorButtons.put("4",four);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth=1;
		JButton five=new JButton("5");
		nbal = new NormalButtonActionListener_v2(screen);
		five.addActionListener(nbal);
		base.add(five,c);
		calculatorButtons.put("5",five);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth=1;
		JButton division=new JButton("\u00f7");
		nbal = new NormalButtonActionListener_v2(screen);
		division.addActionListener(nbal);
		base.add(division,c);
		calculatorButtons.put("/",division);
		


		calculatorWindow.pack();
		calculatorWindow.setVisible(true);
		calculatorWindow.setResizable(false);
		
	}

}
class NormalButtonActionListener_v2 implements ActionListener{
	JLabel screen1;
	NormalButtonActionListener_v2(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		screen1.setText(screen1.getText().concat(((JButton)e.getSource()).getText())); 
        }

}
class DelButtonActionListener_v2 implements ActionListener{
	JLabel screen1;
	DelButtonActionListener_v2(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		if(screen1.getText().length()>1){
			screen1.setText(screen1.getText().substring(0,screen1.getText().length()-1)); 
		}
        }
}
class ACButtonActionListener_v2 implements ActionListener{
	JLabel screen1;
	ACButtonActionListener_v2(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		screen1.setText(" "); 
        }
}
class GeneralKeyBoardActivityListener_v2 implements KeyListener{
	//property that holds all components laid on calculatorWindow
	HashMap<String,JButton> calculatorButtons1;

	//constructor which receives as parameter a mini-database key-value pairs.
	GeneralKeyBoardActivityListener_v2(HashMap<String,JButton> calculatorButtons2){
		calculatorButtons1=calculatorButtons2;
	}
	//empty method
	public void keyPressed(KeyEvent e) {
	}
	//empty method
	public void keyReleased(KeyEvent e) {
    	}
	/*method executed whenever a key is typed. it is simple, 
	it checks if calculatorButtons already has the key and 
	gets the value, and then it calls the doClick() 
	to make it look as if the button was pressed */
    	public void keyTyped(KeyEvent e) {
        	char thekey=e.getKeyChar();
		System.out.println("the key typed = "+thekey);
		if(calculatorButtons1.containsKey(String.valueOf(thekey))){
			calculatorButtons1.get(String.valueOf(thekey)).doClick();
		}
    	}
}