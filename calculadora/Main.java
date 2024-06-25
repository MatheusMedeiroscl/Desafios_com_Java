import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Main extends JFrame {
    final private Font mainFont = new Font("Poppins", Font.BOLD, 18);
    JLabel lblNumber1, lblNumber2, lblResult;
    JTextField tfNumber1, tfNumber2;
    JButton btnSum, btnSub, btnClear;



    public void inicialize(){
        /*AREA DO FORMULÁRIO */
        lblNumber1 = new JLabel("Digite o primeiro numero:"); 
        lblNumber1.setFont(mainFont);

        tfNumber1 = new JTextField();
        tfNumber1.setFont(mainFont);

        lblNumber2 = new JLabel("Digite o segundo numero:");
        lblNumber2.setFont(mainFont);

        tfNumber2 = new JTextField();
        tfNumber2.setFont(mainFont);


        //Painel do formulário 
        JPanel mainForm = new JPanel();
        mainForm.setOpaque(false);
        mainForm.setLayout(new GridLayout(4,1,5,5));
        mainForm.add(lblNumber1); // a ordem o ".add" influencia na ordem dos obj 
        mainForm.add(tfNumber1);
        mainForm.add(lblNumber2);
        mainForm.add(tfNumber2);

        /*AREA DA RESPOSTA */
        lblResult = new JLabel();
        lblResult.setFont(mainFont);
    


        /*AREA DOS BOTÕES */
        btnSum = new JButton("Somar");
        btnSum.setFont(mainFont);

        // Criando a ação de "click" do btnSub
        btnSum.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(tfNumber1.getText());
                    int num2 = Integer.parseInt(tfNumber2.getText());
                    lblResult.setText("Resultado: " + (num1 + num2));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Por favor, insira números válidos.");
                }
            }
        });

        btnSub = new JButton("Subtrair");
        btnSub.setFont(mainFont);

        // Criando a ação de "click" do btnSum
        btnSub.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int num1 = Integer.parseInt(tfNumber1.getText());
                    int num2 = Integer.parseInt(tfNumber2.getText());
                    lblResult.setText("Resultado: " + (num1 - num2));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Por favor, insira números válidos.");
                }
            }
        });

        btnClear = new JButton("Limpar");
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                tfNumber1.setText("");
                tfNumber2.setText("");
                lblResult.setText("");
            }
        });
        JPanel btnArea = new JPanel();
        btnArea.setOpaque(false);
        btnArea.setLayout(new GridLayout(1,3,5,5));
        btnArea.add(btnSum);
        btnArea.add(btnSub);
        btnArea.add(btnClear);





        /*PAINEL PRINCIPAL*/
        JPanel mainFrame = new JPanel();
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(mainForm, BorderLayout.NORTH);
        mainFrame.add(lblResult, BorderLayout.CENTER);
        mainFrame.add(btnArea, BorderLayout.SOUTH);
        add(mainFrame);

        // Caracteristicas do painel principal
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    

    public static void main(String[] args) {
        Main calc = new Main();
        calc.inicialize();
    }
}
