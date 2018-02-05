package main;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Frame extends JFrame {
	
	/** TODO LIST
	 * 	Graphique : 1. Liste des objets
	 * 				2. GameWindow joli
	 * 				3. MenuBar
	 * 				4. Objective
	 * 				5. Interactions
	 * 				6. Drag&drop
	 * 	Moteur :	1. Créer les objets
	 * 				2. Créer les run
	 * 				3. Gérer les interactions
	 * 				4. Gérer les sous-images
	 * 
	 * 				Balloon anim
	 */
	
	public static BufferedImage resource;
	
	
	/** state permet de charger le menu ou un niveau **/
	private JPanel contentPane;
	private int state;
	private Game game;
	private MenuController mc;
	private LSelectController lc;
	private GameWindow gameWindow;
	
	public static void main(String[] args) {
		Frame frame = new Frame();
		try {
			resource = ImageIO.read(new File("IncrMachine.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Frame() {
		this.setTitle("Incredible Machine");
		this.setSize(1200, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		state = 0;
		mc = new MenuController(this);
		lc = new LSelectController(this);
		update();
	}
	
	/** Fonction d'affichage qui va choisir entre le menu et le jeu selon state **/
	public void update() {
		contentPane.removeAll();
		if (state == 0) {
			menu();
		} else if (state == 1) {
			levelSelect();
		} else {
			game();
		}
		this.setVisible(true);
	}

	/** Fonction d'affichage de choix du niveau **/
	public void levelSelect() {
		JPanel levels = new JPanel();
		contentPane.add(levels);
		levels.setLayout(new GridLayout(3,5));
		for (int i=1;i<=15;i++) {
			JButton a = new JButton("Level "+i);
			levels.add(a);
			a.addActionListener(lc);
			
		}
	}

	/** Fonction d'affichage du jeu **/
	public void game() {
		contentPane.add(gameWindow, BorderLayout.CENTER);
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				gameWindow.repaint();
				
			}
		}, 40,40);
		gameWindow.repaint();
		JPanel objectList = new JPanel();
		objectList.setBackground(Color.YELLOW);
		contentPane.add(objectList, BorderLayout.EAST);
		JPanel objective = new JPanel();
		objective.setBackground(Color.GREEN);
		JLabel objectiveName = new JLabel("Name placeholder"/*game.getObjectiveName()*/);
		JLabel objectiveDetailed = new JLabel("Desc placeholder"/*game.getObjectiveDtails()*/);
		objectiveName.setHorizontalAlignment(SwingConstants.CENTER);
		objectiveDetailed.setHorizontalAlignment(SwingConstants.CENTER);
		objective.setLayout(new GridLayout(2,1));
		objective.add(objectiveName);
		objective.add(objectiveDetailed);
		contentPane.add(objective, BorderLayout.SOUTH);
		JPanel menubar = new JPanel();
		menubar.setBackground(Color.BLUE);
		contentPane.add(menubar, BorderLayout.NORTH);
	}

	/** Fonction d'affichage du menu **/
	public void menu() {
		JPanel menu = new JPanel();
		contentPane.add(menu);
		menu.setLayout(new FlowLayout());
		JButton play = new JButton("Play");
		play.addActionListener(mc);
		JButton exit = new JButton("Exit");
		exit.addActionListener(mc);
		menu.add(play);
		menu.add(exit);
	}
	
	public void editState(int a) {
		state = a;
	}

	public void startLevel(int l) {
		game = new Game(l);
		gameWindow = new GameWindow(game,this);
	}
	
}
