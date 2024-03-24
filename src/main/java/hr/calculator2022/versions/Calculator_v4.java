/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.calculator2022.versions;

import hr.calculator2022.*;
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
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
/**
 *
 * @author emeka
 */
public class Calculator_v4 {
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
		
		GeneralKeyBoardActivityListener_v5 gkbal = new GeneralKeyBoardActivityListener_v5(calculatorButtons);
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
		NormalButtonActionListener_v5 nbal = new NormalButtonActionListener_v5(screen);
		seven.addActionListener(nbal);
		base.add(seven,c);
		calculatorButtons.put("7",seven);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		c.gridwidth=1;
		JButton eight=new JButton("8");
                eight.setForeground(Color.white);
                eight.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		eight.addActionListener(nbal);
		base.add(eight,c);
		calculatorButtons.put("8",eight);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth=1;
		JButton nine=new JButton("9");
                nine.setForeground(Color.white);
                nine.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		nine.addActionListener(nbal);
		base.add(nine,c);
		calculatorButtons.put("9",nine);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 1;
		c.gridwidth=1;
		JButton del=new JButton("DEL");
                del.setForeground(Color.black);
                del.setBackground(Color.red);
		DelButtonActionListener_v5 dbal = new DelButtonActionListener_v5(screen);
		del.addActionListener(dbal);
		base.add(del,c);
		calculatorButtons.put("del",del);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 1;
		c.gridwidth=1;
		JButton ac=new JButton("AC");
                ac.setForeground(Color.black);
                ac.setBackground(Color.red);
		ACButtonActionListener_v51 acbal = new ACButtonActionListener_v51(screen);
		ac.addActionListener(acbal);
		base.add(ac,c);
		calculatorButtons.put("ac",ac);

		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth=1;
		JButton four=new JButton("4");
                four.setForeground(Color.white);
                four.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		four.addActionListener(nbal);
		base.add(four,c);
		calculatorButtons.put("4",four);
		
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth=1;
		JButton five=new JButton("5");
                five.setForeground(Color.white);
                five.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		five.addActionListener(nbal);
		base.add(five,c);
		calculatorButtons.put("5",five);
                
                c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth=1;
		JButton six=new JButton("6");
                six.setForeground(Color.white);
                six.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		six.addActionListener(nbal);
		base.add(six,c);
		calculatorButtons.put("6",six);
                
                //layer the multiplication button
                c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth=1;
		JButton multiplication=new JButton("\u00d7");
                multiplication.setForeground(Color.black);
                multiplication.setBackground(Color.white);
		nbal = new NormalButtonActionListener_v5(screen);
		multiplication.addActionListener(nbal);
		base.add(multiplication,c);
		calculatorButtons.put("*",multiplication);
                
                //layer the division button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth=1;
		JButton division=new JButton("\u00f7");
                division.setForeground(Color.black);
                division.setBackground(Color.white);
		nbal = new NormalButtonActionListener_v5(screen);
		division.addActionListener(nbal);
		base.add(division,c);
		calculatorButtons.put("/",division);
		
                //layer the one button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth=1;
		JButton one=new JButton("1");
                one.setForeground(Color.white);
                one.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		one.addActionListener(nbal);
		base.add(one,c);
		calculatorButtons.put("1",one);
                
                //layer the two button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth=1;
		JButton two=new JButton("2");
                two.setForeground(Color.white);
                two.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		two.addActionListener(nbal);
		base.add(two,c);
		calculatorButtons.put("2",two);
                
                //layer the three button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth=1;
		JButton three=new JButton("3");
                three.setForeground(Color.white);
                three.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		three.addActionListener(nbal);
		base.add(three,c);
		calculatorButtons.put("3",three);
                
                //layer the plus button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth=1;
		JButton plus=new JButton("+");
                plus.setForeground(Color.black);
                plus.setBackground(Color.white);
		nbal = new NormalButtonActionListener_v5(screen);
		plus.addActionListener(nbal);
		base.add(plus,c);
		calculatorButtons.put("+",three);
                
                //layer the minus button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 3;
		c.gridwidth=1;
		JButton minus=new JButton("-");
                minus.setForeground(Color.black);
                minus.setBackground(Color.white);
		nbal = new NormalButtonActionListener_v5(screen);
		minus.addActionListener(nbal);
		base.add(minus,c);
		calculatorButtons.put("-",minus);
                
                //layer the zero button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth=1;
		JButton zero=new JButton("0");
                zero.setForeground(Color.white);
                zero.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		zero.addActionListener(nbal);
		base.add(zero,c);
		calculatorButtons.put("0",zero);
                
                //layer the dot button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth=1;
		JButton dot=new JButton(".");
                dot.setForeground(Color.white);
                dot.setBackground(Color.black);
		nbal = new NormalButtonActionListener_v5(screen);
		dot.addActionListener(nbal);
		base.add(dot,c);
		calculatorButtons.put(".",dot);
                
                //layer the EXP button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth=1;
		JButton exp=new JButton("EXP");
                exp.setForeground(Color.black);
                exp.setBackground(Color.white);
		EXPButtonActionListener ebal = new EXPButtonActionListener(screen);
		exp.addActionListener(ebal);
		base.add(exp,c);
		calculatorButtons.put("EXP",exp);
                
                //layer the Ans button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth=1;
		JButton ans=new JButton("Ans");
                ans.setForeground(Color.black);
                ans.setBackground(Color.white);
		AnsButtonActionListener_v51 abal = new AnsButtonActionListener_v51(screen);
		ans.addActionListener(abal);
		base.add(ans,c);
		calculatorButtons.put("Ans",ans);
                
                //layer the equal button
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 4;
		c.gridy = 4;
		c.gridwidth=1;
		JButton equal=new JButton("=");
                equal.setForeground(Color.black);
                equal.setBackground(Color.white);
		EqualsButtonActionListener_v5 eqbal = new EqualsButtonActionListener_v5(screen);
		equal.addActionListener(eqbal);
		base.add(equal,c);
		calculatorButtons.put("=",equal);
                
                //set screen size
                screen.setPreferredSize(new Dimension(seven.getWidth()
                        +eight.getWidth()+nine.getWidth()+del.getWidth()
                        +ac.getWidth(), 100));

		calculatorWindow.pack();
		calculatorWindow.setVisible(true);
		calculatorWindow.setResizable(false);
		
	}

}
class NormalButtonActionListener_v5 implements ActionListener{
	JLabel screen1;
	NormalButtonActionListener_v5(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		screen1.setText(screen1.getText().concat(((JButton)e.getSource()).getText())); 
        }

}
class DelButtonActionListener_v5 implements ActionListener{
	JLabel screen1;
	DelButtonActionListener_v5(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		if(screen1.getText().length()>1){
			screen1.setText(screen1.getText().substring(0,screen1.getText().length()-1)); 
		}
        }
}
class ACButtonActionListener_v51 implements ActionListener{
	JLabel screen1;
	ACButtonActionListener_v51(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		screen1.setText(" "); 
        }
}
class GeneralKeyBoardActivityListener_v5 implements KeyListener{
	//property that holds all components laid on calculatorWindow
	HashMap<String,JButton> calculatorButtons1;

	//constructor which receives as parameter a mini-database key-value pairs.
	GeneralKeyBoardActivityListener_v5(HashMap<String,JButton> calculatorButtons2){
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
class EXPButtonActionListener implements ActionListener{
	JLabel screen1;
	EXPButtonActionListener(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		if(screen1.getText().length()>1){
			screen1.setText(screen1.getText().concat("^")); 
		}
        }
}
class AnsButtonActionListener_v51 implements ActionListener{
	JLabel screen1;
	AnsButtonActionListener_v51(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		
        }
}
class EqualsButtonActionListener_v5 implements ActionListener{
	JLabel screen1;
	EqualsButtonActionListener_v5(JLabel screen2){
		screen1=screen2;
	}
	public void actionPerformed(ActionEvent e) {
		
        }
}