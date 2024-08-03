import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

class MyFrame extends JFrame implements ActionListener {

    JLabel display;
    JPanel buttonsPanel;
    JButton C;
    JButton backspaceButton;
    JLabel invisible1;
    JButton equals;
    JButton seven;
    JButton eight;
    JButton nine;
    JButton plus;
    JButton four;
    JButton five;
    JButton six;
    JButton minus;
    JButton one;
    JButton two;
    JButton three;
    JButton multiply;
    JButton dot;
    JButton zero;
    JButton modulus;
    JButton divide;
    ImageIcon backspaceImage = new ImageIcon("backspace.png");

    double n1=0, n2=0;
    char ch;

    MyFrame() {

        this.setSize(359, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Calculator");

        display = new JLabel();
        display.setPreferredSize(new Dimension(260, 100));
        display.setText("");
        display.setFont(new Font("Consolas",Font.BOLD, 50));

        C = new JButton("C");
        C.addActionListener(this);
        C.setFont(new Font("Consolas",Font.BOLD, 27));
        C.setFocusable(false);
        C.setBackground(new Color(255, 55, 55));
        backspaceButton = new JButton();
        backspaceButton.addActionListener(this);
        backspaceButton.setFocusable(false);
        backspaceButton.setIcon(backspaceImage);
        backspaceButton.setBackground(new Color(255, 55, 55));
        invisible1 = new JLabel();
        equals = new JButton("=");
        equals.addActionListener(this);
        equals.setFont(new Font("Consolas",Font.BOLD, 27));
        equals.setFocusable(false);
        equals.setBackground(new Color(0, 255, 0));
        seven = new JButton("7");
        seven.addActionListener(this);
        seven.setFont(new Font("Consolas",Font.BOLD, 27));
        seven.setFocusable(false);
        seven.setBackground(new Color(224, 224, 224));
        eight = new JButton("8");
        eight.addActionListener(this);
        eight.setFont(new Font("Consolas",Font.BOLD, 27));
        eight.setFocusable(false);
        eight.setBackground(new Color(224, 224, 224));
        nine = new JButton("9");
        nine.addActionListener(this);
        nine.setFont(new Font("Consolas",Font.BOLD, 27));
        nine.setFocusable(false);
        nine.setBackground(new Color(224, 224, 224));
        plus = new JButton("+");
        plus.addActionListener(this);
        plus.setFont(new Font("Consolas",Font.BOLD, 27));
        plus.setFocusable(false);
        plus.setBackground(new Color(255, 255, 0));
        four = new JButton("4");
        four.addActionListener(this);
        four.setFont(new Font("Consolas",Font.BOLD, 27));
        four.setFocusable(false);
        four.setBackground(new Color(224, 224, 224));
        five = new JButton("5");
        five.addActionListener(this);
        five.setFont(new Font("Consolas",Font.BOLD, 27));
        five.setFocusable(false);
        five.setBackground(new Color(224, 224, 224));
        six = new JButton("6");
        six.addActionListener(this);
        six.setFont(new Font("Consolas",Font.BOLD, 27));
        six.setFocusable(false);
        six.setBackground(new Color(224, 224, 224));
        minus = new JButton("-");
        minus.addActionListener(this);
        minus.setFont(new Font("Consolas",Font.BOLD, 27));
        minus.setFocusable(false);
        minus.setBackground(new Color(255, 255, 0));
        one = new JButton("1");
        one.addActionListener(this);
        one.setFont(new Font("Consolas",Font.BOLD, 27));
        one.setFocusable(false);
        one.setBackground(new Color(224, 224, 224));
        two = new JButton("2");
        two.addActionListener(this);
        two.setFont(new Font("Consolas",Font.BOLD, 27));
        two.setFocusable(false);
        two.setBackground(new Color(224, 224, 224));
        three = new JButton("3");
        three.addActionListener(this);
        three.setFont(new Font("Consolas",Font.BOLD, 27));
        three.setFocusable(false);
        three.setBackground(new Color(224, 224, 224));
        multiply = new JButton("*");
        multiply.addActionListener(this);
        multiply.setFont(new Font("Consolas",Font.BOLD, 27));
        multiply.setFocusable(false);
        multiply.setBackground(new Color(255, 255, 0));
        dot = new JButton(".");
        dot.addActionListener(this);
        dot.setFont(new Font("Consolas",Font.BOLD, 27));
        dot.setFocusable(false);
        dot.setBackground(new Color(224, 224, 224));
        zero = new JButton("0");
        zero.addActionListener(this);
        zero.setFont(new Font("Consolas",Font.BOLD, 27));
        zero.setFocusable(false);
        zero.setBackground(new Color(224, 224, 224));
        modulus = new JButton("%");
        modulus.addActionListener(this);
        modulus.setFont(new Font("Consolas",Font.BOLD, 27));
        modulus.setFocusable(false);
        modulus.setBackground(new Color(255, 255, 0));
        divide = new JButton("/");
        divide.addActionListener(this);
        divide.setFont(new Font("Consolas",Font.BOLD, 27));
        divide.setFocusable(false);
        divide.setBackground(new Color(255, 255, 0));

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(5, 4, 20, 20));
        buttonsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        buttonsPanel.setBackground(new Color(255, 255, 255));
        buttonsPanel.add(C);
        buttonsPanel.add(backspaceButton);
        buttonsPanel.add(invisible1);
        buttonsPanel.add(equals);
        buttonsPanel.add(seven);
        buttonsPanel.add(eight);
        buttonsPanel.add(nine);
        buttonsPanel.add(plus);
        buttonsPanel.add(four);
        buttonsPanel.add(five);
        buttonsPanel.add(six);
        buttonsPanel.add(minus);
        buttonsPanel.add(one);
        buttonsPanel.add(two);
        buttonsPanel.add(three);
        buttonsPanel.add(multiply);
        buttonsPanel.add(dot);
        buttonsPanel.add(zero);
        buttonsPanel.add(modulus);
        buttonsPanel.add(divide);

        this.setLayout(new BorderLayout());
        this.add(display, BorderLayout.NORTH);
        this.add(buttonsPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == C) {
            display.setText("");
        }
        else if (e.getSource() == backspaceButton) {
            if (!display.getText().equals("")) {
                char lastChar = display.getText().charAt(display.getText().length() - 1);
                if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/') {
                    if (n1 == (int) n1) {
                        display.setText("" + (int)n1);
                    }
                    else {
                        display.setText("" + n1);
                    }
                } 
                else {
                    display.setText(display.getText().substring(0, display.getText().length() - 1));
                }
            }
        }

        else if(e.getSource() == equals) {
            calculateDisp();
            for(int i = 0; i < display.getText().length(); i++) {
            }
        }
        else if(e.getSource() == plus) {
            if(
                display.getText().charAt(0) == '+' ||
                display.getText().charAt(0) == '-' ||
                display.getText().charAt(0) == '*' ||
                display.getText().charAt(0) == '/' ||
                display.getText().charAt(0) == '%'
            ) {
                calculateDisp();
            }
            n1=Double.parseDouble(display.getText());
            ch='+';
            display.setText("+");
        }
        else if(e.getSource() == minus) {
            if(
                display.getText().charAt(0) == '+' ||
                display.getText().charAt(0) == '-' ||
                display.getText().charAt(0) == '*' ||
                display.getText().charAt(0) == '/' ||
                display.getText().charAt(0) == '%'
            ) {
                calculateDisp();
            }
            n1=Double.parseDouble(display.getText());
            ch='-';
            display.setText("-");
        }
        else if(e.getSource() == multiply) {
            if(
                display.getText().charAt(0) == '+' ||
                display.getText().charAt(0) == '-' ||
                display.getText().charAt(0) == '*' ||
                display.getText().charAt(0) == '/' ||
                display.getText().charAt(0) == '%'
            ) {
                calculateDisp();
            }
            n1=Double.parseDouble(display.getText());
            ch='*';
            display.setText("*");
        }
        else if(e.getSource() == divide) {
            if(
                display.getText().charAt(0) == '+' ||
                display.getText().charAt(0) == '-' ||
                display.getText().charAt(0) == '*' ||
                display.getText().charAt(0) == '/' ||
                display.getText().charAt(0) == '%'
            ) {
                calculateDisp();
            }
            n1=Double.parseDouble(display.getText());
            ch='/';
            display.setText("/");
        }
        else if(e.getSource() == modulus) {
            if(display.getText().charAt(0) == '+' || display.getText().charAt(0) == '-' || display.getText().charAt(0) == '*' || display.getText().charAt(0) == '/' || display.getText().charAt(0) == '%') {
                calculateDisp();
            }
            n1=Double.parseDouble(display.getText());
            ch='%';
            display.setText("%");
        }
        else if(e.getSource() == dot) {
            if(display.getText().contains(".")) {
            } else {
                display.setText(display.getText() + ".");
            }
        }
        else if(e.getSource() == zero) {
            display.setText(display.getText() + "0");
        }
        else if(e.getSource() == one) {
            display.setText(display.getText() + "1");
        }
        else if(e.getSource() == two) {
            display.setText(display.getText() + "2");
        }
        else if(e.getSource() == three) {
            display.setText(display.getText() + "3");
        }
        else if(e.getSource() == four) {
            display.setText(display.getText() + "4");
        }
        else if(e.getSource() == five) {
            display.setText(display.getText() + "5");
        }
        else if(e.getSource() == six) {
            display.setText(display.getText() + "6");
        }
        else if(e.getSource() == seven) {
            display.setText(display.getText() + "7");
        }
        else if(e.getSource() == eight) {
            display.setText(display.getText() + "8");
        }
        else if(e.getSource() == nine) {
            display.setText(display.getText() + "9");
        }
    }

    void calculateDisp() {
        if(n1 != 0) {
            n2=Double.parseDouble(display.getText().substring(1));
            double ans=0;
            switch(ch) {
                case '+':
                    ans = n1 + n2;
                    break;
                case '-':
                    ans = n1 - n2;
                    break;
                case '*':
                    ans = n1 * n2;
                    break;
                case '/':
                    ans = n1 / n2;
                    break;
                case '%':
                    ans = n1 % n2;
                    break;
            }
            if(ans == (int) ans) {
                display.setText("" + (int)ans);
            }
            else {
                display.setText("" + ans);
            }
        }
    }

}

class Main {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }
}