import java.awt.EventQueue;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Gui extends JFrame {
    JFrame f;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private static FileEncryptionExample f1;
    private JTextField textField_4;

    public static void main(String[] args) {
        // Launch the application
        f1 = new FileEncryptionExample();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gui frame = new Gui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // create frame
    public Gui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1019, 629);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel lblNewLabel = new JLabel("ENTRE PATH OF FILE ");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel.setBounds(50, 49, 281, 30);
        contentPane.add(lblNewLabel);
        JLabel lblEntrePathTo = new JLabel("ENTRE PATH TO STORE FILE");
        lblEntrePathTo.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblEntrePathTo.setBounds(50, 108, 281, 30);
        contentPane.add(lblEntrePathTo);
        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblPassword.setBounds(50, 177, 281, 30);
        contentPane.add(lblPassword);
        JLabel lblNewLabel_3 = new JLabel("ENTRE PATH OF ENCRYPTED FILE");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3.setBounds(50, 254, 281, 30);
        contentPane.add(lblNewLabel_3);
        textField = new JTextField();
        textField.setBounds(444, 54, 240, 23);
        contentPane.add(textField);
        textField.setColumns(10);
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(444, 113, 240, 23);
        contentPane.add(textField_1);
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(444, 182, 240, 23);
        contentPane.add(textField_2);
        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(444, 259, 240, 23);
        contentPane.add(textField_3);
        JButton btnNewButton = new JButton("ENCRYPT");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String inputFile = textField.getText();
                String encryptedFile = textField_1.getText();
                String password = textField_2.getText();
                // String decrypt=textField_3.getText();
                // String outputFile=textField_4.getText();
                f1.code(inputFile, encryptedFile, password);
                JOptionPane.showMessageDialog(f, "File Encrypted");
            }
        });
        btnNewButton.setBounds(246, 430, 128, 52);
        contentPane.add(btnNewButton);
        JButton btnNewButton_1 = new JButton("DECRYPT");
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(0, 0, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String pass = textField_2.getText();
                String decrypt = textField_3.getText();
                String outputFile = textField_4.getText();
                f1.code_1(decrypt, outputFile, pass);
                JOptionPane.showMessageDialog(f, "File Decrypted");
            }
        });
        btnNewButton_1.setBounds(521, 430, 128, 52);
        contentPane.add(btnNewButton_1);
        textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setBounds(444, 312, 240, 23);
        contentPane.add(textField_4);
        JLabel lblNewLabel_3_1 = new JLabel("ENTRE PATH TO STORE DECRYPTED FILE");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
        lblNewLabel_3_1.setBounds(50, 307, 281, 30);
        contentPane.add(lblNewLabel_3_1);
    }
}
