package dn.five.Dao;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import dn.five.Entity.Block;


public class EaterAndEnemy {
	protected static int TOP = 1;
	protected static int BOTTOM = 2;
	protected static int LEFT = 3;
	protected static int RIGHT = 4;
	protected int width = 40;
	protected int height = 40;
	protected int direction = LEFT;
	
	protected int step = 2;
	
	protected int x;
	protected int y;
	
	

	
	public void paint(Graphics g) {
	}
	/*运动*/
	public void move() {

	}
	
	/*沿着当前方向走一步*/
	public void step() {
		if(this.getDirection() == 1) {
			this.x += 0;
			this.y += -step;
		}else if(this.getDirection() == 2) {
			this.x += 0;
			this.y += step;
		}else if(this.getDirection() == 3) {
			this.x += -step;
			this.y += 0;
		}else if(this.getDirection() == 4) {
			this.x += step;
			this.y += 0;
		}else {	
		}
	}
	/*撤回一步*/
	public void reStep() {
		if(this.getDirection() == 1) {
			this.x += 0;
			this.y += step;
		}else if(this.getDirection() == 2) {
			this.x += 0;
			this.y += -step;
		}else if(this.getDirection() == 3) {
			this.x += step;
			this.y += 0;
		}else if(this.getDirection() == 4) {
			this.x += -step;
			this.y += 0;
		}else {	
		}
	}
	
	/*判断是否与墙发生接触*/
	public boolean hitBlock(Block block) {
		int x1 = this.x - block.getWidth();
		int x2 = this.x + this.width;
		int y1 = this.y - block.getHeight();
		int y2 = this.y + this.height;
		int blockX = block.getX();
		int blockY = block.getY();
		
		if(blockX>x1 && blockX<x2 && blockY>y1 && blockY<y2 && !block.isCanGo()) {
			return true;
		}else {
			return false;
		}
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
	
	/*是否发生接触*/
	public Boolean isHitBlock(Block[] blocks) {
		for(int i = 0;i<blocks.length;i++) {
			if(this.hitBlock(blocks[i])) {
				return true;
			}
		}
		return false;
	}
	
	public int getDirection() {
		// TODO 自动生成的方法存根
		return this.direction;
	}
	public void setDirection(int dic) {
		// TODO 自动生成的方法存根
		this.direction = dic;
	}
	
	
}
