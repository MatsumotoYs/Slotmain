package slot;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

public class Slotmain1 extends JFrame implements ActionListener, Runnable {




	JButton btnStart;
	JButton btnStop;
	JButton btnStop_1;
	JButton btnStop_2;

	//	boolean stop = false;
	boolean stop1;
	boolean stop2;
	boolean stop3;

	private JPanel contentPane;

	//	private Container ct;

	/**
	 * Launch the application.
	 */


	private String[] list = { ("0"), ("1"), ("2"), ("3"), ("4"), ("5"), ("6"), ("7"), ("8"), ("9")

	};

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnExit;



	public static void main(String[] args) {
		Slotmain1 i = new Slotmain1("JAVAスロット");
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
		setBounds(100, 100, 452, 350);
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
		btnStart.setBounds(160, 256, 110, 25);
		contentPane.add(btnStart);

		btnStop = new JButton("Stop");										// stopボタン１
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStop) {
					stop1 = true;
				}
				;
			}
		});
		btnStop.setBounds(25, 220, 110, 25);
		contentPane.add(btnStop);

		btnStop_1 = new JButton("Stop2");									// stopボタン2
		btnStop_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStop_1) {
					stop2 = true;
				}
			}

		});
		btnStop_1.setBounds(160, 220, 110, 25);
		contentPane.add(btnStop_1);



		btnStop_2 = new JButton("Stop3");									// stopボタン３
		btnStop_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnStop_2) {
					stop3 = true;
				}
			}
		});
		btnStop_2.setBounds(295, 220, 110, 25);
		contentPane.add(btnStop_2);


		textField = new JTextField();
		textField.setHorizontalAlignment(JTextField.CENTER);
		textField.setBounds(25, 80, 110, 110);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(JTextField.CENTER);
		textField_1.setBounds(160, 80, 110, 110);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(JTextField.CENTER);
		textField_2.setBounds(295, 80, 110, 110);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();		// スコア表示
		textField_3.setHorizontalAlignment(JTextField.CENTER);
		textField_3.setBounds(25, 34, 106, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setBounds(354, 267, 68, 25);
		contentPane.add(btnExit);





	}

	@Override
	public void run() {
		//		ct = getContentPane();
		textField.setFont(new Font("MS ゴシック",Font.BOLD,100));
		textField_1.setFont(new Font("MS ゴシック",Font.BOLD,100));
		textField_2.setFont(new Font("MS ゴシック",Font.BOLD,100));



		//		ct.add(textField, SwingConstants.CENTER);
		//		ct.add(textField_1, SwingConstants.CENTER);
		//		ct.add(textField_2, SwingConstants.CENTER);

		Random random = new Random();
		int x = random.nextInt(list.length);
		int y = random.nextInt(list.length);
		int z = random.nextInt(list.length);

		btnStop.setEnabled(true);
		btnStop_1.setEnabled(true);
		btnStop_2.setEnabled(true);

		stop1 = false;
		stop2 = false;
		stop3 = false;

		while(true)	{
			x++;
			if(x == list.length)
				x = 1;

			y++;
			if(y == list.length)
				y = 1;

			z++;
			if(z == list.length)
				z = 1;

			if(!(stop1))textField.setText(Integer.toString(x));
			if(!(stop2))textField_1.setText(Integer.toString(y));
			if(!(stop3))textField_2.setText(Integer.toString(z));



			if(stop1 && stop2 && stop3)	{
				break;
			}

			try	{
				Thread.sleep(200);
			} catch (InterruptedException e1)	{

			}



		}


		if(textField.getText().equals(textField_1.getText()) && textField.getText().equals(textField_2.getText())){
			JOptionPane.showMessageDialog(null, "当たり!!!!");
		}else {
			JOptionPane.showMessageDialog(null, "はずれ!");
		}


		//		// スロット処理
		//		while (true) {
		//			// テキストを描写
		//			textField.setText(list[x]);
		//			textField_1.setText(list[y]);
		//			textField_2.setText(list[z]);
		//
		//			// 終了フラグ判定(stopボタンが押されたら...)
		//			if (stop) {
		//				break;
		//
		//			}
		//
		//			try {
		//				Thread.sleep(300);
		//			} catch (InterruptedException e1) {
		//				// TODO 自動生成された catch ブロック
		//			}
		//
		//			x++;
		//			// リストの最後までいくと、0に戻す
		//			if (x == list.length) {
		//				x = 0;
		//			}
		//
		//			y++;
		//			if (y == list.length)	{
		//				y = 0;
		//			}
		//
		//			z++;
		//			if (z == list.length)	{
		//				z = 0;
		//			}
		//
		////			x = random.nextInt(list.length);
		////			y = random.nextInt(list.length);
		////			z = random.nextInt(list.length);
		////			x++;
		//
		//		}
		//	}
		//
		//
		//	@Override
		//	public void actionPerformed(ActionEvent e) {
		//		// TODO 自動生成されたメソッド・スタブ
		//		if (e.getSource() == btnStart) {
		//			stop = false;
		//			Thread th = new Thread(this);
		//			th.start();
		//		} else if (e.getSource() == btnStop) {
		//			stop = true;
		//
		//		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		if (e.getSource() == btnStart) {
			stop1 = false;
			Thread th = new Thread(this);
			th.start();
		} else if (e.getSource() == btnStop) {
			stop1 = true;

		}

	}
}
