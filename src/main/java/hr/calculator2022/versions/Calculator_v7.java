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
//new code delete
//import javax.swing.border.BevelBorder;
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
//new code
import javax.swing.ImageIcon;
//new code
import java.text.NumberFormat;

/**
 *
 * @author emeka
 */
public class Calculator_v7 {

    //new code
    public static Double operand1 = null;
    public static Double operand2 = null;
    public static String operator = null;
    //new code
    public static Double answer = null;

    public static String getOperandAsText(Double operand) {
        if (operand != null) {
            String s = operand.toString().trim();
            String[] sa = s.split(".0");
            if (sa.length > 1) {
                return s;
            } else {
                return sa[0];
            }
        }else{
            return "";
        }
    }

    public static void main(String[] args) {

        HashMap<String, JButton> calculatorButtons = new HashMap</*
                 * new code
                 */>();

        JFrame calculatorWindow = new JFrame("Calculator");
        //new code
        calculatorWindow.
                setIconImage(new ImageIcon(Calculator_v7.class.
                        getResource("/calcinterface_reduced.jpg")).getImage());
        calculatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorWindow.setSize(300, 400);

        JPanel base = new JPanel();
        base.setSize(300, 400);
        GridBagLayout gbl = new GridBagLayout();
        base.setLayout(gbl);
        Border border1 = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 4);
        base.setBorder(border1);
        base.setLocation(0, 0);

        GeneralKeyBoardActivityListener_v7 gkbal
                = new GeneralKeyBoardActivityListener_v7(calculatorButtons);
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
        Border border2 = BorderFactory.createLoweredBevelBorder();
        screen.setBorder(border2);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 5;
        base.add(screen, c);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        JButton seven = new JButton("7");
        seven.setForeground(Color.white);
        seven.setBackground(Color.black);
        NormalButtonActionListener_v7 nbal
                = new NormalButtonActionListener_v7(screen);
        seven.addActionListener(nbal);
        base.add(seven, c);
        calculatorButtons.put("7", seven);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        JButton eight = new JButton("8");
        eight.setForeground(Color.white);
        eight.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        eight.addActionListener(nbal);
        base.add(eight, c);
        calculatorButtons.put("8", eight);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        JButton nine = new JButton("9");
        nine.setForeground(Color.white);
        nine.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        nine.addActionListener(nbal);
        base.add(nine, c);
        calculatorButtons.put("9", nine);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 1;
        c.gridwidth = 1;
        JButton del = new JButton("DEL");
        del.setForeground(Color.black);
        del.setBackground(Color.red);
        DelButtonActionListener_v7 dbal
                = new DelButtonActionListener_v7(screen/*
                         * new code/ because del button might need to clear the
                         * screen at some stage, instead of repeating screen
                         * clearing code already defined in the ac button, we
                         * decided to pass as parameter the object containing
                         * all the buttons, so that the ac button can be found,
                         * and click simulated.
                         */, calculatorButtons);
        del.addActionListener(dbal);
        base.add(del, c);
        calculatorButtons.put("del", del);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 1;
        c.gridwidth = 1;
        JButton ac = new JButton("AC");
        ac.setForeground(Color.black);
        ac.setBackground(Color.red);
        ACButtonActionListener_v7 acbal
                = new ACButtonActionListener_v7(screen);
        ac.addActionListener(acbal);
        base.add(ac, c);
        calculatorButtons.put("ac", ac);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        JButton four = new JButton("4");
        four.setForeground(Color.white);
        four.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        four.addActionListener(nbal);
        base.add(four, c);
        calculatorButtons.put("4", four);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        JButton five = new JButton("5");
        five.setForeground(Color.white);
        five.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        five.addActionListener(nbal);
        base.add(five, c);
        calculatorButtons.put("5", five);

        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 2;
        c.gridwidth = 1;
        JButton six = new JButton("6");
        six.setForeground(Color.white);
        six.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        six.addActionListener(nbal);
        base.add(six, c);
        calculatorButtons.put("6", six);

        //layer the multiplication button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 2;
        c.gridwidth = 1;
        JButton multiplication = new JButton("\u00d7");
        multiplication.setForeground(Color.black);
        multiplication.setBackground(Color.white);
        //new code
        OperatorButtonActionListener_v7 obal
                = new OperatorButtonActionListener_v7(screen);
        multiplication.addActionListener(/*new code*/obal);
        base.add(multiplication, c);
        calculatorButtons.put("*", multiplication);

        //layer the division button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 2;
        c.gridwidth = 1;
        JButton division = new JButton("\u00f7");
        division.setForeground(Color.black);
        division.setBackground(Color.white);
        //new code
        obal = new OperatorButtonActionListener_v7(screen);
        division.addActionListener(/*
                 * new code
                 */obal);
        base.add(division, c);
        calculatorButtons.put("/", division);

        //layer the one button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        JButton one = new JButton("1");
        one.setForeground(Color.white);
        one.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        one.addActionListener(nbal);
        base.add(one, c);
        calculatorButtons.put("1", one);

        //layer the two button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        JButton two = new JButton("2");
        two.setForeground(Color.white);
        two.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        two.addActionListener(nbal);
        base.add(two, c);
        calculatorButtons.put("2", two);

        //layer the three button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 3;
        c.gridwidth = 1;
        JButton three = new JButton("3");
        three.setForeground(Color.white);
        three.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        three.addActionListener(nbal);
        base.add(three, c);
        calculatorButtons.put("3", three);

        //layer the plus button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 1;
        JButton plus = new JButton("+");
        plus.setForeground(Color.black);
        plus.setBackground(Color.white);
        //new code
        obal = new OperatorButtonActionListener_v7(screen);
        plus.addActionListener(/*
                 * new code
                 */obal);
        base.add(plus, c);
        calculatorButtons.put("+", plus);

        //layer the minus button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 3;
        c.gridwidth = 1;
        JButton minus = new JButton("-");
        minus.setForeground(Color.black);
        minus.setBackground(Color.white);
        //new code
        obal = new OperatorButtonActionListener_v7(screen);
        minus.addActionListener(/*
                 * new code
                 */obal);
        base.add(minus, c);
        calculatorButtons.put("-", minus);

        //layer the zero button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        JButton zero = new JButton("0");
        zero.setForeground(Color.white);
        zero.setBackground(Color.black);
        nbal = new NormalButtonActionListener_v7(screen);
        zero.addActionListener(nbal);
        base.add(zero, c);
        calculatorButtons.put("0", zero);

        //layer the dot button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        JButton dot = new JButton(".");
        dot.setForeground(Color.white);
        dot.setBackground(Color.black);
        //new code
        DotButtonActionListener_v7 dobal
                = new DotButtonActionListener_v7(screen);
        dot.addActionListener(/*new code*/dobal);
        base.add(dot, c);
        calculatorButtons.put(".", dot);

        //layer the EXP button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 2;
        c.gridy = 4;
        c.gridwidth = 1;
        JButton exp = new JButton("EXP");
        exp.setForeground(Color.black);
        exp.setBackground(Color.white);
        //new code
        obal = new OperatorButtonActionListener_v7(screen);
        exp.addActionListener(/*
                 * new code
                 */obal);
        base.add(exp, c);
        calculatorButtons.put("^", exp);

        //layer the Ans button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 3;
        c.gridy = 4;
        c.gridwidth = 1;
        JButton ans = new JButton("Ans");
        ans.setForeground(Color.black);
        ans.setBackground(Color.white);
        AnsButtonActionListener_v7 abal = new AnsButtonActionListener_v7(screen);
        ans.addActionListener(abal);
        base.add(ans, c);
        calculatorButtons.put("Ans", ans);

        //layer the equal button
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 4;
        c.gridy = 4;
        c.gridwidth = 1;
        JButton equal = new JButton("=");
        equal.setForeground(Color.black);
        equal.setBackground(Color.white);
        EqualsButtonActionListener_v7 eqbal = new EqualsButtonActionListener_v7(screen);
        equal.addActionListener(eqbal);
        base.add(equal, c);
        calculatorButtons.put("=", equal);

        //set screen size
        screen.setPreferredSize(new Dimension(seven.getWidth()
                + eight.getWidth() + nine.getWidth() + del.getWidth()
                + ac.getWidth(), 100));

        /*
         * remove the bug of after a button is clicked, the key listening
         * ability disappears because the base (JPanel) that listens for key
         * actions looses focus. Since, all the buttons are in calculatorButtons
         * (HashMap), using a for loop call setFocusable(false) on all buttons.
         */
        calculatorButtons.forEach((symbol, jbutton) -> {
            jbutton.setFocusable(false);
        });

        calculatorWindow.pack();
        calculatorWindow.setVisible(true);
        calculatorWindow.setResizable(false);

    }

}

class NormalButtonActionListener_v7 implements ActionListener {

    JLabel screen1;

    NormalButtonActionListener_v7(JLabel screen2) {
        screen1 = screen2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //new code
        String valueKeyPressed;
        Double number;
        if (Calculator_v7.operand1 == null) {
            valueKeyPressed = ((JButton) e.getSource()).getText();
            number = Double.parseDouble(valueKeyPressed);
            Calculator_v7.operand1 = number;
            screen1.setText(valueKeyPressed);
        } else {
            if (Calculator_v7.operator == null) {
                valueKeyPressed = ((JButton) e.getSource()).getText();
                valueKeyPressed = screen1.getText().concat(valueKeyPressed);
                number = Double.parseDouble(valueKeyPressed);
                Calculator_v7.operand1 = number;
                screen1.setText(valueKeyPressed);
            } else {
                if (Calculator_v7.operand2 == null) {
                    valueKeyPressed = ((JButton) e.getSource()).getText();
                    number = Double.parseDouble(valueKeyPressed);
                    Calculator_v7.operand2 = number;
                    screen1.setText(screen1.getText().concat(valueKeyPressed));
                } else {
                    valueKeyPressed = ((JButton) e.getSource()).getText();
                    valueKeyPressed = screen1.getText().concat(valueKeyPressed);
                    String slicer = Calculator_v7.operator;
                    if (Calculator_v7.operator.equalsIgnoreCase("/")) {
                        slicer = "\\u00f7";
                    }
                    if (Calculator_v7.operator.equalsIgnoreCase("*")) {
                        slicer = "\\u00d7";
                    }
                    if (Calculator_v7.operator.equalsIgnoreCase("+")) {
                        slicer = "\\u002b";
                    }
                    if (Calculator_v7.operator.equalsIgnoreCase("^")) {
                        slicer = "\\u005e";
                    }
                    System.out.println("screen content ["
                            + screen1.getText()
                            + "] before split with " + slicer);
                    number = Double.
                            parseDouble(valueKeyPressed.split(slicer)[1]);
                    Calculator_v7.operand2 = number;
                    screen1.setText(valueKeyPressed);
                    System.out.println("operand1 = " + Calculator_v7.operand1);
                    System.out.println("operand2 = " + Calculator_v7.operand2);
                    System.out.println("operator = " + Calculator_v7.operator);
                }
            }
        }
    }

}

class DelButtonActionListener_v7 implements ActionListener {
    //new code
    //property that holds all components laid on calculatorWindow
    HashMap<String, JButton> calculatorButtons1;
    /*
     * the property screen1 is a reference to the calculator screen at the
     * moment of creation of this class the constructor points this property to
     * the calculator screen
     */
    JLabel screen1;
    /*
     * the constructor of this class, the only method or function that has the
     * same name as the class. Notice that it has a parameter screen2 which is
     * assigned to screen1. If you go to where an object of this class is
     * created in the main(String[] args) method, you will notice that the
     * Calculator screen is what is in place of screen2 DelButtonActionListener
     * dbal = new DelButtonActionListener(screen);
     */
    DelButtonActionListener_v7(JLabel screen2, /*new code*/ 
            HashMap<String, JButton> calculatorButtons2) {
        screen1 = screen2;
        //new code
        calculatorButtons1 = calculatorButtons2;
    }

    /*
     * whenever the del button or any button that has an object of this class as
     * listener is pressed this is the method or function that is executed. When
     * the button is pressed, an event object e is created and passed as
     * parameter to this method or function. This e object contains the the name
     * of the button that was pressed. The button pressed is obtained via
     * (JButton)e.getSource() The text on the button is obtained via .getText()
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //new code
        /*
         * if the operand2 is not null, convert it to text/String as op2string.
         * if op2string ends in "...NN.0" remove the "...N.0" if the length of
         * op2string is greater than 1, remove the last character, convert it to
         * double, update operand2, and update what is on the screen remembering
         * to adjust for the unicode values of the operator, else set operand2 =
         * null, and update the screen with operand1 and the operator
         * remembering to adjust for the unicode values of the operator. else if
         * the operator is not null, make the operator null and update the
         * screen with the operand1 else if operand1 is not null, if op1string
         * ends in "...NN.0" remove the "...N.0" if length of operand1 as string
         * is greater than 1 remove last character, update operand1, and display
         * it on screen, else set operand1 null and trigger the AC button. else
         * do nothing
         */
        if (Calculator_v7.operand2 != null) {
            //op2string = operand2 as string
            String op2string = Calculator_v7.operand2.toString();
            /*
             * when last 2 characters of operand2 is NNN...NN.0 set op2string
             * equal to NNN...N.0; e.g.: if op2string = 567..89.0; the new
             * op2string will be 567..8.0
             */
            if (op2string.substring(op2string.length() - 2).
                    equalsIgnoreCase(".0")) {
                op2string = op2string.substring(0, op2string.length() - 2);
            }
            if (op2string.length() > 1) {
                op2string = op2string.substring(0, op2string.length() - 1);
                Calculator_v7.operand2 = Double.parseDouble(op2string);
                /*
                 * op2disp = format of operator to display for operators whose
                 * display does not rhyme with their use.
                 */
                String op2disp = Calculator_v7.operator;
                if (Calculator_v7.operator.equalsIgnoreCase("/")) {
                    op2disp = "\u00f7";
                }
                if (Calculator_v7.operator.equalsIgnoreCase("*")) {
                    op2disp = "\u00d7";
                }
                if (Calculator_v7.operator.equalsIgnoreCase("+")) {
                    op2disp = "\u002b";
                }
                if (Calculator_v7.operator.equalsIgnoreCase("^")) {
                    op2disp = "\u005e";
                }
                screen1.setText(Calculator_v7.operand1 + op2disp + 
                        Calculator_v7.operand2);
            } else {
                Calculator_v7.operand2 = null;
                /*
                 * op2disp = format of operator to display for operators whose
                 * display does not rhyme with their use.
                 */
                String op2disp = Calculator_v7.operator;
                if (Calculator_v7.operator.equalsIgnoreCase("/")) {
                    op2disp = "\u00f7";
                }
                if (Calculator_v7.operator.equalsIgnoreCase("*")) {
                    op2disp = "\u00d7";
                }
                if (Calculator_v7.operator.equalsIgnoreCase("+")) {
                    op2disp = "\u002b";
                }
                if (Calculator_v7.operator.equalsIgnoreCase("^")) {
                    op2disp = "\u005e";
                }
                screen1.setText(Calculator_v7.operand1 + op2disp);
            }
        } else {
            if (Calculator_v7.operator != null) {
                Calculator_v7.operator = null;
                screen1.setText(Calculator_v7.operand1.toString());
            } else {
                if (Calculator_v7.operand1 != null) {
                    //op1string = operand1 as string
                    String op1string = Calculator_v7.operand1.toString();
                    /*
                     * when last 2 characters of operand1 is NNN...NN.0 set
                     * op1string equal to NNN...N.0; e.g.: if op2string =
                     * 567..89.0; the new op1string will be 567..8.0
                     */
                    if (op1string.substring(op1string.length() - 2).
                            equalsIgnoreCase(".0")) {
                        op1string = op1string.substring(0, 
                                op1string.length() - 2);
                    }
                    if (op1string.length() > 1) {
                        op1string = op1string.substring(0, 
                                op1string.length() - 1);
                        Calculator_v7.operand1 = Double.parseDouble(op1string);
                        screen1.setText(Calculator_v7.operand1.toString());
                    } else {
                        //trigger AC button click
                        calculatorButtons1.get("ac").doClick();
                        Calculator_v7.operand1 = null;
                        Calculator_v7.operand2 = null;
                        Calculator_v7.operator = null;
                    }
                }
            }
        }
    }
}

class ACButtonActionListener_v7 implements ActionListener {

    JLabel screen1;

    ACButtonActionListener_v7(JLabel screen2) {
        screen1 = screen2;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        screen1.setText(" ");
        //new code
        Calculator_v7.operand1 = null;
        Calculator_v7.operator = null;
        Calculator_v7.operand2 = null;
    }
}

class GeneralKeyBoardActivityListener_v7 implements KeyListener {

    //property that holds all components laid on calculatorWindow
    HashMap<String, JButton> calculatorButtons1;

    //constructor which receives as parameter a mini-database key-value pairs.
    GeneralKeyBoardActivityListener_v7(HashMap<String, JButton> calculatorButtons2) {
        calculatorButtons1 = calculatorButtons2;
    }
    //empty method

    @Override
    public void keyPressed(KeyEvent e) {
    }
    //empty method

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /*
     * method executed whenever a key is typed. it is simple, it checks if
     * calculatorButtons already has the key and gets the value, and then it
     * calls the doClick() to make it look as if the button was pressed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        char thekey = e.getKeyChar();
        System.out.println("the key typed = " + thekey);
        if (calculatorButtons1.containsKey(String.valueOf(thekey))) {
            calculatorButtons1.get(String.valueOf(thekey)).doClick();
        }
    }
}
//new code EXPButtonActionListener deleted
/*
 * class EXPButtonActionListener implements ActionListener {
 *
 * JLabel screen1;
 *
 * EXPButtonActionListener(JLabel screen2) { screen1 = screen2; }
 *
 * public void actionPerformed(ActionEvent e) { if (screen1.getText().length() >
 * 1) { screen1.setText(screen1.getText().concat("^")); } } }
 */

class AnsButtonActionListener_v7 implements ActionListener {
    JLabel screen1;
    AnsButtonActionListener_v7(JLabel screen2) {
        screen1 = screen2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Calculator_v7.answer != null){
            Calculator_v7.operand2 = null;
            Calculator_v7.operator = null;
            Calculator_v7.operand1 = Calculator_v7.answer;
            screen1.setText(""+Calculator_v7.operand1);
        }
    }
}

class EqualsButtonActionListener_v7 implements ActionListener {
    JLabel screen1;
    EqualsButtonActionListener_v7(JLabel screen2) {
        screen1 = screen2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //new code
        if(Calculator_v7.operand1!=null&&
                Calculator_v7.operator!=null&&Calculator_v7.operand2!=null){
            if(Calculator_v7.operator.equalsIgnoreCase("^")){
                Calculator_v7.answer=Math.
                        pow(Calculator_v7.operand1,Calculator_v7.operand2);
            }
            if(Calculator_v7.operator.equalsIgnoreCase("+")){
                Calculator_v7.answer=Calculator_v7.operand1+Calculator_v7.operand2;
            }
            if(Calculator_v7.operator.equalsIgnoreCase("-")){
                NumberFormat nf = NumberFormat.getNumberInstance();
                Calculator_v7.answer= Double.parseDouble(nf.
                        format(Calculator_v7.operand1-Calculator_v7.operand2));
            }
            if(Calculator_v7.operator.equalsIgnoreCase("*")){
                Calculator_v7.answer=Calculator_v7.operand1*Calculator_v7.operand2;
            }
            if(Calculator_v7.operator.equalsIgnoreCase("/")){
                if(Calculator_v7.operand2!=0){
                    Calculator_v7.answer=Calculator_v7.operand1/Calculator_v7.operand2;
                }else{
                    Calculator_v7.answer = 0.0;
                }
            }
            Calculator_v7.operand2 = null;
            Calculator_v7.operator = null;
            Calculator_v7.operand1 = Calculator_v7.answer;
            screen1.setText(""+Calculator_v7.operand1);
        }
    }
}
//new code
class OperatorButtonActionListener_v7 implements ActionListener {
    JLabel screen1;
    OperatorButtonActionListener_v7(JLabel screen2) {
        screen1 = screen2;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String valueKeyPressed;
        if (Calculator_v7.operand1 != null && Calculator_v7.operand2 == null) {
            valueKeyPressed = ((JButton) e.getSource()).getText();
            if (valueKeyPressed.equalsIgnoreCase("exp")) {
                Calculator_v7.operator = "^";
                screen1.setText(Calculator_v7.operand1.toString()
                        .concat(Calculator_v7.operator));
            } else {
                if (valueKeyPressed.equalsIgnoreCase("\u00f7")) {
                    Calculator_v7.operator = "/";
                    screen1.setText(Calculator_v7.operand1.toString()
                            .concat("\u00f7"));
                } else {
                    if (valueKeyPressed.equalsIgnoreCase("\u00d7")) {
                        Calculator_v7.operator = "*";
                        screen1.setText(Calculator_v7.operand1.toString()
                                .concat("\u00d7"));
                    } else {
                        Calculator_v7.operator = valueKeyPressed;
                        screen1.setText(Calculator_v7.operand1.toString()
                                .concat(Calculator_v7.operator));
                    }
                }
            }
        }
        if (Calculator_v7.operand1 != null && Calculator_v7.operand2 != null) {
            valueKeyPressed = ((JButton) e.getSource()).getText();
            if (valueKeyPressed.equalsIgnoreCase("exp")) {
                Calculator_v7.operator = "^";
                screen1.setText(Calculator_v7.operand1 + "" 
                        + Calculator_v7.operator + Calculator_v7.operand2);
            } else {
                if (valueKeyPressed.equalsIgnoreCase("\u00f7")) {
                    Calculator_v7.operator = "/";
                    screen1.setText(Calculator_v7.operand1.toString()
                            .concat("\u00f7") + Calculator_v7.operand2);
                } else {
                    if (valueKeyPressed.equalsIgnoreCase("\u00d7")) {
                        Calculator_v7.operator = "*";
                        screen1.setText(Calculator_v7.operand1.toString()
                                .concat("\u00d7") + Calculator_v7.operand2);
                    } else {
                        Calculator_v7.operator = valueKeyPressed;
                        screen1.setText(Calculator_v7.operand1.toString()
                                .concat(Calculator_v7.operator) + 
                                Calculator_v7.operand2);
                    }
                }
            }
        }

    }

}
//new code
/*
 * this class is attached to the dot button and is responsible for coordinating
 * the display and values of operand1, operand2 when the dot button is pressed
 */
class DotButtonActionListener_v7 implements ActionListener {
    /*
     * the property screen1 is a reference to the calculator screen.
     * At the moment of creation of this class the constructor linkd
     * this property to the calculator screen
     */
    JLabel screen1;
    /*
     * the constructor of this class is the only method or function that has the
     * same name as the class. 
     * Notice that it has a parameter screen2 which is assigned to screen1. 
     * If one goes to where an object of this class is created in the 
     * main(String[] args) method, one will notice that the Calculator screen 
     * is what is in place of screen2 i.e.,
     * DotButtonActionListener dobal = new DotButtonActionListener(screen); 
     * when dobal an object of DotButtonActionListener is created, its screen1
     * reference is set to the Calculator screen
     */
    DotButtonActionListener_v7(JLabel screen2) {
        screen1 = screen2;
    }
    /*
     * whenever the dot button or any button that has an object of this class as
     * listener is pressed this is the method or function that is executed. 
     * When the dot JButton is pressed, an ActionEvent object e is created and 
     * passed as parameter to the actionPerformed method or function. 
     * This e object contains the the name of the button that was pressed. 
     * The button pressed is obtained via (JButton)e.getSource() 
     * The text on the button is obtained via .getText()
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //get the text of the button pressed
        String valueKeyPressed = ((JButton) e.getSource()).getText();
        /*
         * if operand1 has been initialized but operator not yet pressed, and
         * operand1 does not have a decimal point, then it is added
         */
        if (Calculator_v7.operand1 != null) {
            if (Calculator_v7.operator == null) {
                if (screen1.getText().contains(valueKeyPressed) == false) {
                    if (screen1.getText().endsWith(".") == false) {
                        valueKeyPressed = screen1.getText()
                                .concat(valueKeyPressed);
                        Calculator_v7.operand1 = Double.
                                parseDouble(valueKeyPressed);
                        screen1.setText(valueKeyPressed);
                    }
                }
            } else {
                /*
                 * if operand2 has been initialized and does not have a decimal
                 * point, then it is added. 
                 * However, if the operand2 is retrieved from the screen rather 
                 * than from the property/varaible/field operand2. 
                 * Since some operators are displayed differently, and on the 
                 * screen it is the operator that separates both operands, 
                 * to get each operand from the screen, one needs to split the 
                 * screen text by the operator. 
                 * But since the operator value and its display value 
                 * for *,/,^,+ differ, at the momment of splitting the
                 * displayed text, one has to remember to use their
                 * corresponding operator unicodes. 
                 * After splitting the displayed text the operand2 is
                 * saved in a String named temp. 
                 * For example, if one has a text "56.7+89.0" on the screen, 
                 * it means that operand1=56.7, operator="+", and operand2=89.0 
                 * However, one cannot split by "+" because what is displayed
                 * has unicode "\\u002b". 
                 * On splitting by "\\u002b", an array[56.7][89.0] is created
                 * where array[0]=56.7 and array[1]=89.0 
                 * Splitting by "+" will cause an error.
                 */
                if (Calculator_v7.operand2 != null) {
                    String temp = "";
                    if (Calculator_v7.operator.equalsIgnoreCase("*")) {
                        /*
                         * get the text on the screen via screen1.getText() 
                         * split the text by the unicode of "*" 
                         * screen1.getText().split("\\u00d7") 
                         * an array is created. 
                         * screen1.getText().split("\\u00d7")[1] gives
                         * access to operand2 which is saved in temp
                         */
                        temp = screen1.getText().split("\\u00d7")[1];
                    } else {
                        if (Calculator_v7.operator.equalsIgnoreCase("/")) {
                            temp = screen1.getText().split("\\u00f7")[1];
                        } else {
                            if (Calculator_v7.operator.equalsIgnoreCase("+")) {
                                temp = screen1.getText().split("\\u002b")[1];
                            } else {
                                if (Calculator_v7.operator.equalsIgnoreCase("^")) {
                                    temp = screen1.getText().
                                            split("\\u005e")[1];
                                } else {
                                    temp = (screen1.getText().
                                            split(Calculator_v7.operator))[1];
                                }
                            }
                        }
                    }
                    /*
                     * if temp does not already contain a dot, then a dot is
                     * appended
                     */
                    if (temp.contains(valueKeyPressed) == false) {
                        if (temp.endsWith(".") == false) {
                            temp = temp.concat(valueKeyPressed);
                            valueKeyPressed = screen1.getText().
                                    concat(valueKeyPressed);
                            Calculator_v7.operand2 = Double.parseDouble(temp);
                            screen1.setText(valueKeyPressed);
                        }
                    }
                }
            }
        }
    }

}
