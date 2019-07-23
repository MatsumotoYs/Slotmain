package slot;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Slotstart1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Slotstart1 frame = new Slotstart1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Slotstart1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJava = new JLabel("JAVA\u30B9\u30ED\u30C3\u30C8");
		lblJava.setFont(new Font("MS ゴシック",Font.BOLD,50));
		lblJava.setHorizontalAlignment(JTextField.CENTER);
		lblJava.setBounds(0, 13, 434, 155);
		contentPane.add(lblJava);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Slotmain1 slotmain = new Slotmain1("JAVAスロット");
				slotmain.setVisible(true);
				setVisible(false);
				
			}
		});
		btnStart.setBounds(163, 212, 101, 25);
		contentPane.add(btnStart);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(163, 267, 101, 25);
		contentPane.add(btnExit);
	}
}
