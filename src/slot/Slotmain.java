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
 * ランダムに名前を出力
 * (スロット風)
 *
 * @author kikuya
 *
 */
public class Slotmain extends JFrame implements ActionListener, Runnable {
	/** コンテナインスタンス */
	private Container ct;
	/** レイアウトインスタンス */
	private BorderLayout border;

	/** スタートボタン */
	JButton bt;
	/** ストップボタン */
	JButton btStop;
	/** 表示フィールド */
	JTextField text;
	JTextField text1;
	JTextField text2
	;
	JTextField label;
	
	

	/** 表示リスト */
	private String[] list = {
			("C:\\\\Users\\\\184002\\\\eclipse-workspace\\\\Slot\\\\img\\\\1.jpg"),
			("7"),
			("6"),
			("5"),
			("9"),
			("7"),
			("8"),
			("5"),
			//"う"

										};

	/** 判定フラグ */
	boolean stop = false;

	/**
	 *  コンストラクタ
	 *
	 *  <br>GUIの初期設定を行う
	 * @param title
	 */
	public Slotmain(String title) {
		super(title);
		// windowの開始位置を設定
		setLocation(600, 400);
		// window のサイズを設定
		setSize(500, 300);
	}

	/**
	 * メインメソッド
	 * @param args 引数
	 */
	public static void main(String[] args) {
		Slotmain rm = new Slotmain("名前ランダム");
		// GUIの生成
		rm.createGUI();
		// 可視性を表示(true)に
		rm.setVisible(true);
	}

	/**
	 * GUIの生成
	 */
	public void createGUI() {
		ct = getContentPane();
		// インスタンス生成
		border = new BorderLayout();
		ct.setLayout(border);

		// スロット作成用ボタン
		bt = new JButton("スタート");
		bt.setFont(new Font("メイリオ", Font.BOLD, 20));
		bt.setForeground(Color.WHITE);
		bt.setBackground(Color.BLACK);

		btStop = new JButton("ストップ");
		btStop.setFont(new Font("メイリオ", Font.BOLD, 20));
		btStop.setForeground(Color.WHITE);
		btStop.setBackground(Color.BLACK);

		// 文字列表示領域
		text = new JTextField();
//		text.setFont(new Font("メイリオ", Font.BOLD, 60));
//		text.setEnabled(false);
//		text.setBounds(0, 13, 126, 110);
//		text.setDisabledTextColor(Color.BLACK);
		
		text1 = new JTextField();
//		text1.setFont(new Font("メイリオ", Font.BOLD, 60));
//		text1.setEnabled(false);
//		text1.setBounds(138, 13, 126, 110);
//		text1.setDisabledTextColor(Color.BLACK);
		
		text2 = new JTextField();
//		text2.setFont(new Font("メイリオ", Font.BOLD, 60));
//		text2.setEnabled(false);
//		text2.setBounds(294, 13, 126, 110);
//		text2.setDisabledTextColor(Color.BLACK);

		label = new JTextField();
//		label.setFont(new Font("メイリオ", Font.BOLD, 60));
//		label.setText("iiii");
//		label.setEnabled(false);


		// アイテムを設置
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
	 * ボタンのリスナー(押されたことを検知するとこのメソッドが実行される)
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
	 * スロット処理をスレッド化するメソッド
	 */
	@Override
	public void run() {
		Random random = new Random();
		int x = random.nextInt(list.length);
		int y = random.nextInt(list.length);
		int z = random.nextInt(list.length);

		// スロット処理
		while(true)  {
			// テキストを描写
			text.setText(list[x]);
			text1.setText(list[y]);
			text2.setText(list[z]);
			
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
}