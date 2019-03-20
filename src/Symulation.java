import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class Symulation extends JFrame{

	static final int SLIDER_MIN = 0;
	static final int SLIDER_MAX = 100;
	static final int SLIDER_INIT = 0; 
	
	static final int SLIDER_MIN_EYE1 = 0;
	static final int SLIDER_MAX_EYE1 = 6;
	static final int SLIDER_INIT_EYE1 = 0; 
	
	static final int SLIDER_MIN_EYE2 = 0;
	static final int SLIDER_MAX_EYE2 = 6;
	static final int SLIDER_INIT_EYE2 = 0; 
	
	private JPanel leftPanel; 
	private JPanel wadaPanel;  //Zmienic nazwe 
	private JPanel odlegloscPanel; //Nazwa
	private JPanel rightPanel; 
	private JPanel rightPanelSymulation; 
	private JPanel rightPanelPicture; 
	private JPanel topPanel; 
	private JPanel bottomPanel; 
	private JLabel changeRefractiveErrorLabel;
	private JLabel wielkoscWady; // Zmienic nazwe 
	private JLabel eyes; 
	private JLabel lenghtLabel; 
	private JLabel labelOdleglosc; 
	private JLabel title; 
	private JRadioButton nearSightedness; 
	private JRadioButton farSightedness;
	private ButtonGroup buttonGroup;
	private JSlider eye1;
	private JSlider eye2;
	private JTextField textfieldOdleglosc; //nazwa
	private JSlider lenghtSlider; 
	private JButton buttonStart; 
	
	public static void main(String[] args) {
		Symulation okno = new Symulation(); 
		okno.setVisible(true);
	}
	
	public Symulation() {
		this.setSize(800,600);
		this.setTitle("Symulacja ogniskowania obrawu w oku w przypadkach ametropii");
		Menu();
		LeftPanel();
		RightPanel();
		TopPanel();
		BottomPanel();
	}

	private void Menu() {
		JMenuBar MenuBar = new JMenuBar();
		this.setJMenuBar(MenuBar); 
		
		JMenu menu = new JMenu("Menu: ");
		MenuBar.add(menu); 
		
		JMenu submenu = new JMenu("Jêzyk "); 
		menu.add(submenu);
		
		JMenuItem menuItemEnglish = new JMenuItem("Angielski");
		submenu.add(menuItemEnglish);
		JMenuItem menuItemPolish = new JMenuItem("Polski");
		submenu.add(menuItemPolish);
		
		JMenuItem menuItemColor = new JMenuItem("Kolor"); 
		menu.add(menuItemColor);
		
		JMenuItem menuItemSave = new JMenuItem("Zapisz dane"); 
		menu.add(menuItemSave); 
		
		JMenuItem menuExit = new JMenuItem("Wyjdz"); 
		menu.add(menuExit); 
		menuExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});	
	}
	
	private void LeftPanel() {
		leftPanel = new JPanel(); 
		leftPanel.setLayout(new GridLayout(10,1));
		leftPanel.setBackground(new Color(102, 204, 255));
		
		changeRefractiveErrorLabel = new JLabel("WYBIERZ RODZAJ AMETROPII "); 
		changeRefractiveErrorLabel.setForeground(Color.BLUE);
		buttonGroup = new ButtonGroup();
		
		nearSightedness = new JRadioButton("KRÓTKOWZROCZNOŒÆ"); 
		nearSightedness.setBackground(new Color(102, 204, 255));
		farSightedness = new JRadioButton("DALEKOWZROCZNOŒÆ");
		farSightedness.setBackground(new Color(102, 204, 255));
		buttonGroup.add(nearSightedness);
		buttonGroup.add(farSightedness);
		
		wielkoscWady = new JLabel("WPISZ WIELKOŒÆ AMETROPII");
		wielkoscWady.setForeground(Color.BLUE);
		
		wadaPanel = new JPanel(); 
//		wadaPanel.setBackground(new Color(102, 204, 255));
		wadaPanel.setLayout(new GridLayout(1,2));
		
		eyes = new JLabel("OKO LEWE             OKO PRAWE"); 
		eyes.setForeground(Color.BLUE);
		
		eye1 = new JSlider();
		eye1 = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_EYE1, SLIDER_MAX_EYE1, SLIDER_INIT_EYE1); 
		eye1.setBackground(new Color(102, 204, 255));
		eye1.setPreferredSize(new Dimension(100, 50)); // wielkosc suwaka
		eye1.setMajorTickSpacing(1); //Co ile ma byc widoczna liczba
		eye1.setPaintTicks(true); //podzia³ki 
		eye1.setMinorTickSpacing(1); //Co ile kreska
		eye1.setPaintLabels(true); //liczby
		
		eye2 = new JSlider(); 
		eye2 = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_EYE2, SLIDER_MAX_EYE2, SLIDER_INIT_EYE2); 
		eye2.setBackground(new Color(102, 204, 255));
		eye2.setPreferredSize(new Dimension(100, 50)); // wielkosc suwaka
		eye2.setMajorTickSpacing(1); //Co ile ma byc widoczna liczba
		eye2.setPaintTicks(true); //podzia³ki 
		eye2.setMinorTickSpacing(1); //Co ile kreska
		eye2.setPaintLabels(true); //liczby
		
		wadaPanel.add(eye1, BorderLayout.LINE_START);
		wadaPanel.add(eye2, BorderLayout.LINE_END);
		
		lenghtLabel = new JLabel("ODLEG£OŒÆ OD OBIEKTU"); 
		lenghtLabel.setForeground(Color.BLUE);
		
		lenghtSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT); 
		lenghtSlider.setBackground(new Color(102, 204, 255));
		lenghtSlider.setPreferredSize(new Dimension(200, 50)); // wielkosc suwaka
		lenghtSlider.setMajorTickSpacing(20); //Co ile ma byc widoczna liczba
		lenghtSlider.setPaintTicks(true); //podzia³ki 
		lenghtSlider.setMinorTickSpacing(5); //Co ile kreska
		lenghtSlider.setPaintLabels(true); //liczby
		
		odlegloscPanel = new JPanel();
		odlegloscPanel.setLayout(new GridLayout(1,2));
		odlegloscPanel.setBackground(new Color(102, 204, 255));
		labelOdleglosc = new JLabel("ODLEG£OŒÆ: "); 
		labelOdleglosc.setForeground(Color.BLUE);
		textfieldOdleglosc = new JTextField();
		odlegloscPanel.add(labelOdleglosc);
		odlegloscPanel.add(textfieldOdleglosc);
		
		buttonStart = new JButton("ON"); 
		
		leftPanel.add(changeRefractiveErrorLabel); 
		leftPanel.add(nearSightedness);
		leftPanel.add(farSightedness);
		leftPanel.add(wielkoscWady);
		leftPanel.add(eyes); 
		leftPanel.add(wadaPanel);
		leftPanel.add(lenghtLabel);
		leftPanel.add(lenghtSlider);
		leftPanel.add(odlegloscPanel);
		leftPanel.add(buttonStart);
		
		this.add(leftPanel, BorderLayout.LINE_START); 
	}
	
	private void RightPanel() {
		rightPanel = new JPanel(); 
		rightPanel.setBackground(Color.BLACK);
		rightPanel.setSize(300, 400);
		
		rightPanelSymulation = new JPanel();
		rightPanelSymulation.setBackground(Color.RED);
		rightPanelSymulation.setSize(150, 200);
		
		rightPanelPicture = new JPanel();
		rightPanelPicture.setBackground(Color.CYAN);
		rightPanel.add(rightPanelSymulation, BorderLayout.LINE_START); 
		rightPanel.add(rightPanelPicture, BorderLayout.LINE_END);
		
		this.add(rightPanel); 
	}
	
	private void TopPanel() {
		topPanel = new JPanel();
		title = new JLabel("SYMULACJA OGNISKOWANIA OBRAZU W OKU W PRZYPADKACH AMETROPII");
		title.setForeground(Color.BLUE);
		topPanel.add(title); 
		topPanel.setBackground(new Color(102, 204, 255));
		
		this.add(topPanel,BorderLayout.PAGE_START); 
	}
	
	private void BottomPanel() {
		bottomPanel = new JPanel(); 
		bottomPanel.setBackground(new Color(102, 204, 255));
		
		this.add(bottomPanel, BorderLayout.PAGE_END); 
	}
}
