package slot;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * �����_���ɖ��O���o��
 * (�X���b�g��)
 *
 * @author kikuya
 *
 */
public class Slotmain extends JFrame implements ActionListener, Runnable {
	/** �R���e�i�C���X�^���X */
	private Container ct;
	/** ���C�A�E�g�C���X�^���X */
	private BorderLayout border;

	/** �X�^�[�g�{�^�� */
	JButton bt;
	/** �X�g�b�v�{�^�� */
	JButton btStop;
	/** �\���t�B�[���h */
	JTextField text;
	JTextField text1;
	JTextField text2
	;
	JTextField label;
	
	

	/** �\�����X�g */
	private String[] list = {
			("C:\\\\Users\\\\184002\\\\eclipse-workspace\\\\Slot\\\\img\\\\1.jpg"),
			("7"),
			("6"),
			("5"),
			("9"),
			("7"),
			("8"),
			("5"),
			//"��"

										};

	/** ����t���O */
	boolean stop = false;

	/**
	 *  �R���X�g���N�^
	 *
	 *  <br>GUI�̏����ݒ���s��
	 * @param title
	 */
	public Slotmain(String title) {
		super(title);
		// window�̊J�n�ʒu��ݒ�
		setLocation(600, 400);
		// window �̃T�C�Y��ݒ�
		setSize(500, 300);
	}

	/**
	 * ���C�����\�b�h
	 * @param args ����
	 */
	public static void main(String[] args) {
		Slotmain rm = new Slotmain("���O�����_��");
		// GUI�̐���
		rm.createGUI();
		// ������\��(true)��
		rm.setVisible(true);
	}

	/**
	 * GUI�̐���
	 */
	public void createGUI() {
		ct = getContentPane();
		// �C���X�^���X����
		border = new BorderLayout();
		ct.setLayout(border);

		// �X���b�g�쐬�p�{�^��
		bt = new JButton("�X�^�[�g");
		bt.setFont(new Font("���C���I", Font.BOLD, 20));
		bt.setForeground(Color.WHITE);
		bt.setBackground(Color.BLACK);

		btStop = new JButton("�X�g�b�v");
		btStop.setFont(new Font("���C���I", Font.BOLD, 20));
		btStop.setForeground(Color.WHITE);
		btStop.setBackground(Color.BLACK);

		// ������\���̈�
		text = new JTextField();
//		text.setFont(new Font("���C���I", Font.BOLD, 60));
//		text.setEnabled(false);
//		text.setBounds(0, 13, 126, 110);
//		text.setDisabledTextColor(Color.BLACK);
		
		text1 = new JTextField();
//		text1.setFont(new Font("���C���I", Font.BOLD, 60));
//		text1.setEnabled(false);
//		text1.setBounds(138, 13, 126, 110);
//		text1.setDisabledTextColor(Color.BLACK);
		
		text2 = new JTextField();
//		text2.setFont(new Font("���C���I", Font.BOLD, 60));
//		text2.setEnabled(false);
//		text2.setBounds(294, 13, 126, 110);
//		text2.setDisabledTextColor(Color.BLACK);

		label = new JTextField();
//		label.setFont(new Font("���C���I", Font.BOLD, 60));
//		label.setText("iiii");
//		label.setEnabled(false);


		// �A�C�e����ݒu
		ct.add(text, BorderLayout.NORTH);
		ct.add(text1, BorderLayout.NORTH);
		ct.add(text2, BorderLayout.NORTH);
		ct.add(btStop,BorderLayout.EAST);
		ct.add(label, BorderLayout.CENTER);
		ct.add(bt, BorderLayout.WEST);


		bt.addActionListener(this);
		btStop.addActionListener(this);

	}

	/**
	 * �{�^���̃��X�i�[(�����ꂽ���Ƃ����m����Ƃ��̃��\�b�h�����s�����)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bt) {
			stop = false;
			Thread th = new Thread(this);
			th.start();
		} else if (e.getSource() == btStop) {
			stop =true;
		}


	}
	/**
	 * �X���b�g�������X���b�h�����郁�\�b�h
	 */
	@Override
	public void run() {
		Random random = new Random();
		int x = random.nextInt(list.length);
		int y = random.nextInt(list.length);
		int z = random.nextInt(list.length);

		// �X���b�g����
		while(true)  {
			// �e�L�X�g��`��
			text.setText(list[x]);
			text1.setText(list[y]);
			text2.setText(list[z]);
			
			// �I���t���O����(stop�{�^���������ꂽ��...)
			if (stop) {
				break;
			}

			try {
				Thread.sleep(30);
			} catch (InterruptedException e1) {
				// TODO �����������ꂽ catch �u���b�N
			}

			x++;
			// ���X�g�̍Ō�܂ł����ƁA0�ɖ߂�
			if (x == list.length) {
				x = 0;
			}
			x = random.nextInt(list.length);
			y = random.nextInt(list.length);
			z = random.nextInt(list.length);
		}
	}
}