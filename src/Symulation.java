import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Symulation extends JFrame {

	static final int SLIDER_MIN = 0;
	static final int SLIDER_MAX = 100;
	static final int SLIDER_INIT = 0; 
	
	static final int SLIDER_MIN_EYE = 0;
	static final int SLIDER_MAX_EYE = 6;
	static final int SLIDER_INIT_EYE = 0;
	
	private JPanel leftPanel; 
	private JPanel wadaPanel;  //Zmienic nazwe 
	private JPanel odlegloscPanel; //Nazwa
	private JPanel rightPanelSymulation; 
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
	private JSlider eye;
	private JSlider lenghtSlider;
	private JButton buttonRun;
	private int odleglosc = 0;
	public boolean isPL = true;
	MenuCreator menuCreator;
	Translator translator;

	public static void main(String[] args) {
		Symulation okno = new Symulation();
		okno.setVisible(true);
	}

	public void updateText() {
		translator.updateText(isPL);
		this.setTitle(translator.frameTitle);
		title.setText(translator.frameTitle);
		changeRefractiveErrorLabel.setText(translator.labelRefractiveError);
		nearSightedness.setText(translator.radiobuttonNearSightedness);
		farSightedness.setText(translator.radiobuttonFarSightedness);
		wielkoscWady.setText(translator.labelWielkoscWady);
		lenghtLabel.setText(translator.labelLenght);
		labelOdleglosc.setText(translator.labelLenght);
		buttonRun.setText(translator.buttonRun);
	}

	public Symulation() {
		this.setSize(800,600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		menuCreator = new MenuCreator(this);
		translator = new Translator(this);

		Menu();
		LeftPanel();
		RightSymulationPanel();
		TopPanel();
		BottomPanel();
		updateText();
	}

	private void Menu() {
		this.setJMenuBar(menuCreator.createJMenuBar());
	}
	
	private void LeftPanel() {
		leftPanel = new JPanel(); 
		leftPanel.setLayout(new GridLayout(10,1));
		leftPanel.setBackground(new Color(102, 204, 255));

		changeRefractiveErrorLabel = new JLabel(translator.labelRefractiveError, SwingConstants.CENTER);
		changeRefractiveErrorLabel.setForeground(Color.BLUE);
		buttonGroup = new ButtonGroup();
		
		nearSightedness = new JRadioButton(translator.radiobuttonNearSightedness);
		nearSightedness.setBackground(new Color(102, 204, 255));
		farSightedness = new JRadioButton(translator.radiobuttonFarSightedness);
		farSightedness.setBackground(new Color(102, 204, 255));
		buttonGroup.add(nearSightedness);
		buttonGroup.add(farSightedness);
		
		wielkoscWady = new JLabel(translator.labelWielkoscWady, SwingConstants.CENTER);
		wielkoscWady.setForeground(Color.BLUE);
		
		wadaPanel = new JPanel(); 
		wadaPanel.setLayout(new GridLayout(1,2));

		eye = new JSlider();
		eye = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN_EYE, SLIDER_MAX_EYE, SLIDER_INIT_EYE);
		eye.setBackground(new Color(102, 204, 255));
		eye.setPreferredSize(new Dimension(100, 50)); // wielkosc suwaka
		eye.setMajorTickSpacing(1); //Co ile ma byc widoczna liczba
		eye.setPaintTicks(true); //podzia³ki
		eye.setMinorTickSpacing(1); //Co ile kreska
		eye.setPaintLabels(true); //liczby
		
		wadaPanel.add(eye, BorderLayout.LINE_START);

		lenghtLabel = new JLabel(translator.labelLenght, SwingConstants.CENTER);
		lenghtLabel.setForeground(Color.BLUE);
		
		lenghtSlider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT); 
		lenghtSlider.setBackground(new Color(102, 204, 255));
		lenghtSlider.setPreferredSize(new Dimension(200, 50)); // wielkosc suwaka
		lenghtSlider.setMajorTickSpacing(20); //Co ile ma byc widoczna liczba
		lenghtSlider.setPaintTicks(true); //podzia³ki 
		lenghtSlider.setMinorTickSpacing(5); //Co ile kreska
		lenghtSlider.setPaintLabels(true); //li 	czby
		lenghtSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				odleglosc = lenghtSlider.getValue();
				labelOdleglosc.setText(translator.labelLenght + odleglosc + "m");
			}
		});
		
		odlegloscPanel = new JPanel();
		odlegloscPanel.setLayout(new GridLayout(1,2));
		odlegloscPanel.setBackground(new Color(102, 204, 255));
		labelOdleglosc = new JLabel(translator.labelLenght + odleglosc + "m", SwingConstants.CENTER);
		labelOdleglosc.setForeground(Color.BLUE);

		odlegloscPanel.add(labelOdleglosc);
		
		buttonRun = new JButton(translator.buttonRun);
		
		leftPanel.add(changeRefractiveErrorLabel);
		leftPanel.add(nearSightedness);
		leftPanel.add(farSightedness);
		leftPanel.add(wielkoscWady);
		leftPanel.add(wadaPanel);
		leftPanel.add(lenghtLabel);
		leftPanel.add(lenghtSlider);
		leftPanel.add(odlegloscPanel);
		leftPanel.add(buttonRun);
		
		this.add(leftPanel, BorderLayout.LINE_START); 
	}
	
	private void RightSymulationPanel() {
		rightPanelSymulation = new JPanel(); 
		rightPanelSymulation.setBackground(Color.white);
		rightPanelSymulation.setSize(200, 200);
		rightPanelSymulation.setLayout(new GridLayout(2,1));
		this.add(rightPanelSymulation);
	}
	
	private void TopPanel() {
		topPanel = new JPanel();
		title = new JLabel(translator.frameTitle, SwingConstants.CENTER);
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