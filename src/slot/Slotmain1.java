package slot;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Slotmain1 extends JFrame implements ActionListener, Runnable {

	JButton btnStart;
	JButton btnStop;
	JButton btnStop_1;
	JButton btnStop_2;

	boolean stop = false;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private String[] list = { ("1"), ("2"), ("3"), ("4"), ("5"), ("6"), ("7"), ("8"), ("9")

	};

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	

	public static void main(String[] args) {
		Slotmain1 i = new Slotmain1("スロットん");
		i.setVisible(true);
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Slotmain1 frame = new Slotmain1();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the frame.
	 */
	public Slotmain1(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnStart = new JButton("Start");
		btnStart.addActionListener(this);
//		btnStart.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == btnStart) {
//					stop = false;
//					
//				}
//			}
//		});
		btnStart.setBounds(12, 223, 101, 25);
		contentPane.add(btnStart);

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStop) {
					stop = true;
				}
				;
			}
		});
		btnStop.setBounds(39, 183, 101, 25);
		contentPane.add(btnStop);
		
//		btnStop_1 = new JButton("Stop2");
//		btnStop_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (e.getSource() == btnStop) {
//					stop = true;
//				}
//			}
//			
//		});
//		btnStop_1.setBounds(159, 183, 101, 25);
//		contentPane.add(btnStop_1);

		textField = new JTextField();
		textField.setBounds(29, 61, 118, 109);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(159, 61, 101, 108);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(272, 61, 111, 109);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		

//		
//		btnStop_2 = new JButton("Stop3");
//		btnStop_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnStop_2.setBounds(282, 183, 101, 25);
//		contentPane.add(btnStop_2);

	}

	@Override
	public void run() {
		Random random = new Random();
		int x = random.nextInt(list.length);
		int y = random.nextInt(list.length);
		int z = random.nextInt(list.length);

		// スロット処理
		while (true) {
			// テキストを描写
			textField.setText(list[x]);
			textField_1.setText(list[y]);
			textField_2.setText(list[z]);

			// 終了フラグ判定(stopボタンが押されたら...)
			if (stop) {
				break;
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				// TODO 自動生成された catch ブロック
			}

			x++;
			// リストの最後までいくと、0に戻す
			if (x == list.length) {
				x = 0;
			}
			x = random.nextInt(list.length);
			y = random.nextInt(list.length);
			z = random.nextInt(list.length);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (e.getSource() == btnStart) {
			stop = false;
			Thread th = new Thread(this);
			th.start();
		} else if (e.getSource() == btnStop) {
			stop = true;
			
		}
	}
	
	

}
