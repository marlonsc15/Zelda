package com.santos.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Menu {

	public String[] options = {"novo jogo","carregar jogo","sair" };
	
	public int currentOption = 0;
	public int maxOption = options.length - 1;
	
	public boolean up,down,enter;
	
	public boolean pause = false;
	
	public void tick(){
		if (up) {
			up = false;
			currentOption--;
			if(currentOption < 0)
				currentOption = maxOption;
			}
		
		if(down) {
			down = false;
			currentOption++;
			if(currentOption > maxOption)
				currentOption = 0;
			}
		if(enter) {
			enter = false;
			if(options[currentOption] == "novo jogo" || options[currentOption] == "continuar") {
				Game.gameState = "NORMAL";
				pause = false;
			}else if(options[currentOption] == "sair") {
				System.exit(1);
			}
		}
		}
	
    
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(0,0,0,100));
		g.fillRect(0, 0, Game.WIDTH*Game.SCALE, Game.HEIGHT*Game.SCALE);
		g.setColor (Color.RED );
		g.setFont(new Font ("arial",Font.BOLD,20));
		g.drawString("ABACAXI O JOGO", (Game.WIDTH*Game.SCALE) / 2 -90, (Game.HEIGHT*Game.SCALE)/ 2 -130);
	
		
		//Opçoes de menu
		g.setColor (Color.WHITE);
		g.setFont(new Font ("arial",Font.BOLD,24));
		if(pause == false)
		g.drawString("Novo jogo", (Game.WIDTH*Game.SCALE) / 2 -60, 200);
		else
			g.drawString("resumir", (Game.WIDTH*Game.SCALE) / 2 -45, 200);
		g.drawString("Carregar jogo", (Game.WIDTH*Game.SCALE) / 2 -80, 250);
		g.drawString("Sair", (Game.WIDTH*Game.SCALE) / 2 -25, 300);
	
		
		if(options[currentOption] == "novo jogo") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 -90, 200);
		}else if(options[currentOption] == "carregar jogo") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 -110, 250);
		}else if(options[currentOption] == "sair") {
			g.drawString(">", (Game.WIDTH*Game.SCALE) / 2 -50, 300);
	
	}

	}

}


