package map;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.embed.swing.JFXPanel;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Window.Type;

public class MapUI extends JFXPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5591425161840969955L;
	private JFXPanel contentPane;
	private JFrame frame;
	private JLabel[][] map;
	private GridBagConstraints[][] gbc;
	private int[][] mapIndex;
	private int cols;
	private BufferedImage img;
//	private SpriteUI spriteUI;
	
	public static final int TILE_WIDTH = 32;
	public static final int TILE_HEIGHT = 32;
	public static final int MAP_WIDTH = 1600;
	public static final int MAP_HEIGHT = 896;
	public static final int WIDTH = MAP_WIDTH / (2*TILE_WIDTH);
	public static final int HEIGHT = MAP_HEIGHT / (2*TILE_HEIGHT);
    public static final int SPRITE_WIDTH = 32;
	public static final int SPRITE_HEIGHT = 48;
	
	private static String MAPURL = "resource/pic/map/043-Cave01.png";
	private static String DATAURL = "resource/data/map/map1.txt";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MapUI window = new MapUI(MAPURL, DATAURL);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} 

	/**
	 * Create the application.
	 */
	public MapUI(String picURL, String dataURL) {
		contentPane = new JFXPanel();
		
		map = new JLabel[HEIGHT][WIDTH];
		gbc = new GridBagConstraints[HEIGHT][WIDTH];
		mapIndex = new int[HEIGHT][WIDTH];
		setMapIndex(dataURL);
		File image = new File(MAPURL);
		try {
			img = ImageIO.read(image);
		} catch(Exception e) {
			e.printStackTrace();
		}
		cols = (int) (img.getWidth() / TILE_WIDTH);
		initialize();
		Dimension screenSize=java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize= frame.getSize();
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		
	}
	
	public void load() {
//		 spriteUI = new SpriteUI(600, 180, SPRITE_WIDTH, SPRITE_HEIGHT, "xpchar51.png");
		 
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setTitle("Soul of Hero");
		frame.setBounds(100, 100, MAP_WIDTH, MAP_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[WIDTH + 1];
		gbl_contentPane.rowHeights = new int[HEIGHT + 1];
		gbl_contentPane.columnWeights = new double[WIDTH + 1];
		gbl_contentPane.rowWeights = new double[HEIGHT + 1];
		for(int i = 0; i < WIDTH; i++) {
			gbl_contentPane.columnWidths[i] = 32;
			gbl_contentPane.columnWeights[i] = 1.0;
		}
		for(int i = 0; i < HEIGHT; i++) {
			gbl_contentPane.rowHeights[i] = 32;
			gbl_contentPane.rowWeights[i] = 1.0;
		}
		gbl_contentPane.columnWeights[WIDTH] = Double.MIN_VALUE;
		gbl_contentPane.rowWeights[HEIGHT] = Double.MIN_VALUE;
		contentPane.setLayout(gbl_contentPane);
		
		map = new JLabel[HEIGHT][WIDTH];
		gbc = new GridBagConstraints[HEIGHT][WIDTH];
		for(int y = 0; y < HEIGHT; y++) {
			for(int x = 0; x < WIDTH; x++) {
				map[y][x] = new JLabel();
				gbc[y][x] = new GridBagConstraints();
				gbc[y][x].insets = new Insets(0,0,0,0);
				gbc[y][x].gridx = x;
				gbc[y][x].gridy = y;
				gbc[y][x].fill = GridBagConstraints.HORIZONTAL;
				gbc[y][x].fill = GridBagConstraints.VERTICAL;
				contentPane.add(map[y][x],gbc[y][x]);
				int px = mapIndex[y][x] % cols;
				int py = mapIndex[y][x] / cols;
				BufferedImage outImg = img.getSubimage(px * TILE_WIDTH, py * TILE_HEIGHT, TILE_WIDTH, TILE_HEIGHT);
				ImageIcon icon = new ImageIcon(outImg);
				icon.setImage(icon.getImage().getScaledInstance(2 * TILE_WIDTH, 2 * TILE_HEIGHT, Image.SCALE_SMOOTH));
				map[y][x].setIcon(icon);
				contentPane.add(map[y][x], gbc[y][x]);
			}
			frame.setContentPane(contentPane);
		}
	}
	
	public void setMapIndex(String url) {
		String[] map = new String[MAP_HEIGHT];
		try(BufferedReader br = new BufferedReader(new FileReader(url))) {
			int locEnd;
			int locStart = 0;
			for(int y = 0; y < HEIGHT; y++) {
				map[y] = br.readLine();
				locStart = 0;
				for(int x = 0; x < WIDTH; x++) {
					locEnd = map[y].indexOf(" ", locStart);
					System.out.println("locStart:" + locStart);
					mapIndex[y][x] = Integer.parseInt(map[y].substring(locStart, locEnd));
					locStart = locEnd + 1;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
