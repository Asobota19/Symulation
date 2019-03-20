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
	private JLabel lenghtLabel; 
	private JLabel labelOdleglosc; 
	private JLabel title; 
	private JRadioButton nearSightedness; 
	private JRadioButton farSightedness;
	private ButtonGroup buttonGroup;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfieldOdleglosc; //nazwa
	private JSlider lenghtSlider; 
	private JButton buttonStart; 
	
	public static void main(String[] args) {
		Symulation okno = new Symulation(); 
		okno.setVisible(true);
	}
	
	public Symulation() {
		this.setSize(800,600);
		this.setTitle("Symulation");
		this.setIconImage(null);
		Menu();
		LeftPanel();
		RightPanel();
		TopPanel();
		BottomPanel();
	}

	private void Menu() {
		JMenuBar MenuBar = new JMenuBar();
		MenuBar.setBackground(Color.BLUE);
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
		leftPanel.setLayout(new GridLayout(9,1));
		leftPanel.setBackground(Color.BLUE);
		
		changeRefractiveErrorLabel = new JLabel("WYBIERZ RODZAJ AMETROPII "); 
		changeRefractiveErrorLabel.setForeground(Color.WHITE);
		buttonGroup = new ButtonGroup();
		
		nearSightedness = new JRadioButton("KRÓTKOWZROCZNOŒÆ"); 
		farSightedness = new JRadioButton("DALEKOWZROCZNOŒÆ");
		buttonGroup.add(nearSightedness);
		buttonGroup.add(farSightedness);
		
		wielkoscWady = new JLabel("WPISZ WIELKOŒÆ AMETROPII");
		wielkoscWady.setForeground(Color.WHITE);
		wadaPanel = new JPanel(); 
		wadaPanel.setLayout(new GridLayout(1,2));
		textfield1 = new JTextField(); 
		textfield2 = new JTextField();
		wadaPanel.add(textfield1, BorderLayout.LINE_START);
		wadaPanel.add(textfield2, BorderLayout.LINE_END);
		
		lenghtLabel = new JLabel("ODLEG£OŒÆ OD OBIEKTU"); 
		lenghtLabel.setForeground(Color.WHITE);
		lenghtSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT); 
		lenghtSlider.setPreferredSize(new Dimension(200, 50)); // wielkosc suwaka
		lenghtSlider.setMajorTickSpacing(20); //Co ile ma byc widoczna liczba
		lenghtSlider.setPaintTicks(true); //podzia³ki 
		lenghtSlider.setMinorTickSpacing(5); //Co ile kreska
		lenghtSlider.setPaintLabels(true); //liczby
		
		odlegloscPanel = new JPanel();
		odlegloscPanel.setLayout(new GridLayout(1,2));
		odlegloscPanel.setBackground(Color.BLUE);
		labelOdleglosc = new JLabel("ODLEG£OŒÆ: "); 
		labelOdleglosc.setForeground(Color.WHITE);
		textfieldOdleglosc = new JTextField();
		odlegloscPanel.add(labelOdleglosc);
		odlegloscPanel.add(textfieldOdleglosc);
		
		buttonStart = new JButton("ON/OFF"); 
		
		leftPanel.add(changeRefractiveErrorLabel); 
		leftPanel.add(nearSightedness);
		leftPanel.add(farSightedness);
		leftPanel.add(wielkoscWady);
		leftPanel.add(wadaPanel);
		leftPanel.add(lenghtLabel);
		leftPanel.add(lenghtSlider);
		leftPanel.add(odlegloscPanel);
		leftPanel.add(buttonStart);
		
		this.add(leftPanel, BorderLayout.LINE_START); 
	}
	
	private void RightPanel() {
		rightPanel = new JPanel(); 
		//rightPanel.setLayout(new GridLayout(200,10));
		rightPanelSymulation = new JPanel();
		rightPanelSymulation.setBackground(Color.RED);
		rightPanelPicture = new JPanel();
		rightPanelPicture.setBackground(Color.CYAN);
		rightPanel.add(rightPanelSymulation, BorderLayout.PAGE_START); 
		rightPanel.add(rightPanelPicture, BorderLayout.PAGE_END); 
		
		this.add(rightPanel, BorderLayout.LINE_END); 
	}
	
	private void TopPanel() {
		topPanel = new JPanel();
		title = new JLabel("SYMULACJA OGNISKOWANIA OBRAZU W OKU W PRZYPADKACH AMETROPII");
		title.setForeground(Color.WHITE);
		topPanel.add(title); 
		topPanel.setBackground(Color.blue);
		
		this.add(topPanel,BorderLayout.PAGE_START); 
	}
	
	private void BottomPanel() {
		bottomPanel = new JPanel(); 
		bottomPanel.setBackground(Color.BLUE);
		
		this.add(bottomPanel, BorderLayout.PAGE_END); 
	}
}
