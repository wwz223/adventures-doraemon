package dn.five.Entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import dn.five.Dao.EaterAndEnemy;
import dn.five.Test.GameBoard;

public class Enemy extends EaterAndEnemy{
	Random ran = new Random();
	
	private static final int style1 = 1;
	private static final int style2 = 2;
	private static final int style3 = 3;
	private static final int style4 = 4;
	private static final int style5 = 5;
	int style = style1;
	private static BufferedImage[] images1;
	private static BufferedImage[] images2;
	private static BufferedImage[] images3;
	private static BufferedImage[] images4;
	private static BufferedImage[] images5;
	int index1 = 0;
	int index ;
	int num = 0;
	
	//加载图片
	static {
		int i;
		images1 = new BufferedImage[16];
		images2 = new BufferedImage[16];
		images3 = new BufferedImage[16];
		images4 = new BufferedImage[16];
		images5 = new BufferedImage[16];
		for(i = 0;i<images1.length;i++) {
			images1[i] = loadImage("/img/eS1 (" + i + ").gif");
		}
		for(i = 0;i<images2.length;i++) {
			images2[i] = loadImage("/img/eS2 (" + i + ").gif");
		}
		for(i = 0;i<images3.length;i++) {
			images3[i] = loadImage("/img/eS3 (" + i + ").gif");
		}
		for(i = 0;i<images4.length;i++) {
			images4[i] = loadImage("/img/eS2 (" + i + ").gif");
		}
		for(i = 0;i<images5.length;i++) {
			images5[i] = loadImage("/img/eS3 (" + i + ").gif");
		}
	}
		
	/*加载图片的方法 fileName是图片路劲*/
	public static BufferedImage loadImage(String fileName) {
		try {
			BufferedImage img = ImageIO.read(Eater.class.getResource(fileName));
			return img;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
	/*从数组里面获取某一张图片，需要子类重写*/
	public BufferedImage getImage() {
		if(num%10==0) {
			index++;
		}
		num++;
		switch(this.style) {
			case style1:
				switch(this.direction) {
					case 1:
						return images1[index%4];
					case 2:
						return images1[index%4+4];
					case 3:
						return images1[index%4+8];
					case 4:
						return images1[index%4+12];
				}
			case style2:
				switch(this.direction) {
					case 1:
						return images2[index%4];
					case 2:
						return images2[index%4+4];
					case 3:
						return images2[index%4+8];
					case 4:
						return images2[index%4+12];
				}
			case style3:
				switch(this.direction) {
					case 1:
						return images3[index%4];
					case 2:
						return images3[index%4+4];
					case 3:
						return images3[index%4+8];
					case 4:
						return images3[index%4+12];
				}
			case style4:
				switch(this.direction) {
				case 1:
					return images4[index%4];
				case 2:
					return images4[index%4+4];
				case 3:
					return images4[index%4+8];
				case 4:
					return images4[index%4+12];
				}
			case style5:
				switch(this.direction) {
				case 1:
					return images5[index%4];
				case 2:
					return images5[index%4+4];
				case 3:
					return images5[index%4+8];
				case 4:
					return images5[index%4+12];
				}
			default:
				break;
		}
		return images2[index%4];
	}
	
	
	
	public Enemy(int x,int y ,int style) {
		this.direction=TOP;
		this.style = style;
		this.x = x + 13*this.width+GameBoard.marginX;
		this.y = y + 15*this.height+GameBoard.marginY;
	}
	
	public void paint(Graphics g) {
		g.drawImage(getImage(),x,y,null);
		
	}
	
	/*敌人运动*/
	public void move(Block[] blocks) {
		//for(;;) {
		if(this.isHitBlock(blocks)) {
			this.reStep();
			int dic;
			if(this.direction>0&&this.direction<=2) {
				dic = ran.nextInt(2)+2+1;
			}else {
				dic = ran.nextInt(2)+1;
			}
			if(canChangWay(blocks, dic)){
				this.setDirection(dic);
				this.step();
			}
		}else {
			this.step();
		}
		//}
	}
	

	/*预设是否可以改变方向*/
	public boolean canChangWay(Block[] blocks,int dic) {
		int reDic = this.getDirection();
		this.setDirection(dic);
		this.step();
		if(this.isHitBlock(blocks)) {
			this.reStep();
			this.setDirection(reDic);
			return false;
		}else {
			this.reStep();
			this.setDirection(reDic);
			return true;
		}
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

	public synchronized final int getDirection() {
		return direction;
	}

	public synchronized final void setDirection(int direction) {
		this.direction = direction;
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
