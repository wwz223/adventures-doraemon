package dn.five.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dn.five.Test.GameBoard;


public class Block {
	private static final int style1 = 1;
	private static final int style2 = 2;
	private static final int style3 = 3;
	private static final int style4 = 4;
	private static final int style5 = 5;
	private int style = style1;
	private static BufferedImage[] images;
	
	private boolean canGo = false;
	//坐标
	private int x;
	private int y;
	//下标
	private int i;
	private int j;
	//大小
	private int width = 20;
	private int height = 20;
	
	
	
	//加载图片
	static {
		images = new BufferedImage[5];
		for(int i = 0;i<images.length;i++) {
			images[i] = loadImage("/img/blockStyle" + i + ".png");
		}
	}
	/*加载图片的方法 fileName是图片路劲*/
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(Block.class.getResource(fileName));
			return img;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	/*根据状态获取相应的图片*/
	public BufferedImage getImage() {
		BufferedImage img = images[this.style-1];
		return img;
	}
	
	public Block(int i, int j,int style) {
		this.style=style;
		this.i = i;
		this.j = j;
		this.x = j*20+GameBoard.marginX;
		this.y = i*20+GameBoard.marginY;
		
	}
	



	public void paint(Graphics g) {
		switch(style) {
		case style1:
			g.drawImage(getImage(),x,y,null);
			break;
		case style2:
			g.drawImage(getImage(),x,y,null);
			break;
		case style3:
			g.drawImage(getImage(),x,y,null);
			break;
		case style4:
			g.drawImage(getImage(),x,y,null);
		
		case style5:
			g.drawImage(getImage(),x,y,null);
		default:
			break;
		}
		//g.fillRect(x, y, width, height);
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}

	public boolean isCanGo() {
		return canGo;
	}
	public void setCanGo(boolean canGo) {
		this.canGo = canGo;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public int getJ() {
		return j;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	
}
