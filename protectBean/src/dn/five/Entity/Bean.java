package dn.five.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dn.five.Test.GameBoard;

public class Bean {
	
	private static final int style1 = 1;
	private static final int style2 = 2;
	private static final int style3 = 3;
	private static final int style4 = 4;
	private static final int style5 = 5;
	private static final int styleKey = 6;
	
	private int style = style1;
	private int i;
	private int j;
	private int x;
	private int y;
	private int width = 15;
	private int height = 15;
	private boolean haveEaten = false;
	
	private static BufferedImage[] images;
	//加载图片
	static {
		images = new BufferedImage[6];
		for(int i = 0;i<images.length;i++) {
			images[i] = loadImage("/img/bean" + i + ".png");
		}
	}
	/*加载图片的方法 fileName是图片路劲*/
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(Bean.class.getResource(fileName));
			return img;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	/*根据状态获取相应的图片*/
	public BufferedImage getImage() {
		return images[this.style-1];		
	}
	//构造方法
	public Bean(int i,int j,int style) {
		this.i = i;
		this.j = j;
		this.x = j*20+GameBoard.marginX;
		this.y = i*20+GameBoard.marginY;
		this.style = style;
	}
	public void paint(Graphics g) {
		g.drawImage(getImage(),x,y,null);
	}
	
	public void setStyle(int style) {
		this.style = style;
	}
	
	public synchronized final boolean isHaveEaten() {
		return haveEaten;
	}
	public synchronized final void setHaveEaten(boolean haveEaten) {
		this.haveEaten = haveEaten;
	}
	public synchronized final int getI() {
		return i;
	}
	public synchronized final void setI(int i) {
		this.i = i;
	}
	public synchronized final int getJ() {
		return j;
	}
	public synchronized final void setJ(int j) {
		this.j = j;
	}
	public synchronized final int getX() {
		return x;
	}
	public synchronized final void setX(int x) {
		this.x = x;
	}
	public synchronized final int getY() {
		return y;
	}
	public synchronized final void setY(int y) {
		this.y = y;
	}
	public synchronized final int getWidth() {
		return width;
	}
	public synchronized final void setWidth(int width) {
		this.width = width;
	}
	public synchronized final int getHeight() {
		return height;
	}
	public synchronized final void setHeight(int height) {
		this.height = height;
	}
}
