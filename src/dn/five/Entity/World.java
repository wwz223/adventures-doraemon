package dn.five.Entity;

import javax.swing.JFrame;

import dn.five.Test.GameBoard;

public class World {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		GameBoard panel = new GameBoard();
		
		frame.add(panel);
		frame.addKeyListener(panel);
		panel.addKeyListener(panel);

		
		//设置窗口大小
		frame.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		//显示窗口
		frame.setVisible(true);
	
	}
}
