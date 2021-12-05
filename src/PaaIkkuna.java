import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JRadioButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PaaIkkuna extends JFrame {

	private JPanel contentPane;
	private JLabel Luku1;
	private JLabel Luku2;
	private JTextField KirjoitaLuku1;
	private JTextField KirjoitaLuku2;
	private JLabel Tulos;
	private JTextField TulostaTulos;
	private JButton plus;
	private JButton miinus;
	private JButton kerto;
	private JButton jako;
	private JMenuBar menuBar;
	private JMenu ValikkoNappi;
	private JButton Tyhjenn‰Nappi;
	private JButton LopetaNappi;
	private JRadioButton checkbox;

	String filename = "src/Resources/nelilaskin.txt";
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaaIkkuna frame = new PaaIkkuna();
					frame.setVisible(true);
					frame.kirjoitaTiedostoon("Ohjelma avattu");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PaaIkkuna() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Lopetetaanko ohjelma?","Lopetus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.OK_OPTION ) {
					System.out.println("Ohjelma lopetettu");
					kirjoitaTiedostoon("Ohjelma lopetettu");
					System.exit(0);
				}
				if( result == JOptionPane.NO_OPTION ) {
					System.out.println("Ohjelmaa ei lopetettu");
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 357);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		ValikkoNappi = new JMenu("Valikko");
		menuBar.add(ValikkoNappi);
		
		Tyhjenn‰Nappi = new JButton("Tyhjenn\u00E4");
		Tyhjenn‰Nappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TulostaTulos.setText("");
				KirjoitaLuku1.setText("");
				KirjoitaLuku2.setText("");
			}
		});
		ValikkoNappi.add(Tyhjenn‰Nappi);
		
		LopetaNappi = new JButton("Lopeta");
		LopetaNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "Lopetetaanko ohjelma?","Lopetus",  JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if( result == JOptionPane.OK_OPTION ) {
					System.out.println("Ohjelma lopetettu");
					kirjoitaTiedostoon("Ohjelma lopetettu");
					System.exit(0);
				}
				if( result == JOptionPane.NO_OPTION ) {
					System.out.println("Ohjelmaa ei lopetettu");
				}

			}
		});
		ValikkoNappi.add(LopetaNappi);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Luku1 = new JLabel("1. Luku");
		Luku1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Luku1.setBounds(31, 43, 53, 24);
		contentPane.add(Luku1);
		
		Luku2 = new JLabel("2. Luku");
		Luku2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Luku2.setBounds(31, 78, 53, 24);
		contentPane.add(Luku2);
		
		KirjoitaLuku1 = new JTextField();
		KirjoitaLuku1.setBounds(98, 47, 62, 20);
		contentPane.add(KirjoitaLuku1);
		KirjoitaLuku1.setColumns(10);
		
		KirjoitaLuku2 = new JTextField();
		KirjoitaLuku2.setColumns(10);
		KirjoitaLuku2.setBounds(98, 80, 62, 20);
		contentPane.add(KirjoitaLuku2);
		
		Tulos = new JLabel("Tulos:");
		Tulos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		Tulos.setBounds(205, 67, 49, 14);
		contentPane.add(Tulos);
		
		TulostaTulos = new JTextField();
		TulostaTulos.setBounds(254, 64, 89, 20);
		contentPane.add(TulostaTulos);
		TulostaTulos.setColumns(10);
		
		plus = new JButton("+");
		plus.setForeground(Color.WHITE);
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Luku1 = Integer.parseInt(KirjoitaLuku1.getText());
				int Luku2 = Integer.parseInt(KirjoitaLuku2.getText());
				int Tulos = Luku1 + Luku2;
				
				TulostaTulos.setText(Luku1 + "+" + Luku2 + "=" + Tulos);
				if (checkbox.isSelected()) {
				kirjoitaTiedostoon("Laskutoimitus: " + Luku1 + "+" + Luku2 + "=" + Tulos);
				}
			}
		});
		plus.setBackground(Color.DARK_GRAY);
		plus.setFont(new Font("Tahoma", Font.BOLD, 20));
		plus.setBounds(31, 127, 67, 48);
		contentPane.add(plus);
		
		miinus = new JButton("-");
		miinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Luku1 = Integer.parseInt(KirjoitaLuku1.getText());
				int Luku2 = Integer.parseInt(KirjoitaLuku2.getText());
				int Tulos = Luku1 - Luku2;
				
				TulostaTulos.setText(Luku1 + "-" + Luku2 + "=" + Tulos);
				if (checkbox.isSelected()) {
				kirjoitaTiedostoon("Laskutoimitus: " + Luku1 + "-" + Luku2 + "=" + Tulos);
				}
			}
		});
		miinus.setForeground(Color.WHITE);
		miinus.setBackground(Color.DARK_GRAY);
		miinus.setFont(new Font("Tahoma", Font.BOLD, 20));
		miinus.setBounds(98, 127, 67, 48);
		contentPane.add(miinus);
		
		kerto = new JButton("*");
		kerto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Luku1 = Integer.parseInt(KirjoitaLuku1.getText());
				int Luku2 = Integer.parseInt(KirjoitaLuku2.getText());
				int Tulos = Luku1 * Luku2;
				
				TulostaTulos.setText(Luku1 + "*" + Luku2 + "=" + Tulos);
				if (checkbox.isSelected()) {
				kirjoitaTiedostoon("Laskutoimitus: " + Luku1 + "*" + Luku2 + "=" + Tulos);
				}
			}
		});
		kerto.setForeground(Color.WHITE);
		kerto.setBackground(Color.DARK_GRAY);
		kerto.setFont(new Font("Tahoma", Font.BOLD, 20));
		kerto.setBounds(31, 186, 67, 48);
		contentPane.add(kerto);
		
		jako = new JButton("/");
		jako.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double Luku1 = Integer.parseInt(KirjoitaLuku1.getText());
				double Luku2 = Integer.parseInt(KirjoitaLuku2.getText());
				double Tulos = Luku1 / Luku2;
				
				TulostaTulos.setText(Luku1 + "/" + Luku2 + "=" + Tulos);
				if (checkbox.isSelected()) {
				kirjoitaTiedostoon("Laskutoimitus: " + Luku1 + "/" + Luku2 + "=" + Tulos);
				}
			}
		});
		jako.setForeground(Color.WHITE);
		jako.setBackground(Color.DARK_GRAY);
		jako.setFont(new Font("Tahoma", Font.BOLD, 20));
		jako.setBounds(98, 186, 67, 48);
		contentPane.add(jako);
		
		checkbox = new JRadioButton("Kirjoitetaan tulos tiedostoon");
		checkbox.setSelected(true);
		checkbox.setFont(new Font("Tahoma", Font.ITALIC, 16));
		checkbox.setBounds(235, 203, 235, 23);
		contentPane.add(checkbox);
	}
	
	
	//Tiedostoon kirjoittaminen
	public void kirjoitaTiedostoon(String txt) {
		try {
			java.util.Date date = new java.util.Date();
			// Valinta true lopussa aiheuttaa sen, ett‰ ei ylikirjoiteta vaan jatketaan olemassa olevan per‰‰n
			FileWriter fwriter = new FileWriter(filename, true);
			fwriter.write(date.toString() + " ");
			fwriter.write(txt + "\n");
			fwriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
