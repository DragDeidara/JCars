import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TP {
	static final String JDBC_DRIVER = "org.sqlite.JDBC";
	static final String DB_URL = "jdbc:sqlite:C:\\Users\\Miguel\\git\\tp-cp\\TP-Database.db";

	Connection conn =null;
	Statement stmt =null;

	private JFrame frame;
	private JTextField textField;
	private JPanel panel_1;
	private JPasswordField passwordField;
	private JList list;
	private DefaultListModel<Carro> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TP window = new TP();
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
	public TP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		try{
			Class.forName(JDBC_DRIVER);
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL);
			stmt = conn.createStatement();
			System.out.println("Quering database...");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Carro");

			while(rs.next()){
				System.out.println(rs.getString("Matricula"));

			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel);
		panel.setBackground( Color.LIGHT_GRAY );
		panel.setLayout(null);

		JLabel label = new JLabel("Login");
		label.setBounds(57, 69, 35, 14);
		panel.add(label);

		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(57, 112, 65, 14);
		panel.add(label_1);

		textField = new JTextField();
		textField.setBounds(150, 66, 86, 20);
		textField.setColumns(10);
		panel.add(textField);

		JButton button = new JButton("OK");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel.setVisible(false);
				panel_1.setVisible(true);			
			}			
		});

		button.setBounds(179, 152, 57, 23);
		panel.add(button);


		JButton button_1 = new JButton("Offline");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(true);

			}
		});
		button_1.setBounds(57, 152, 77, 23);
		panel.add(button_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(150, 109, 86, 20);
		panel.add(passwordField);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblListaVeiculos = new JLabel("Lista veiculos");
		lblListaVeiculos.setBounds(45, 25, 87, 14);
		panel_1.add(lblListaVeiculos);


		JList list = new JList();
		list.setBounds(47, 59, 345, 147);
		panel_1.add(list);

		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(43, 217, 89, 23);
		panel_1.add(btnNovo);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(174, 217, 89, 23);
		panel_1.add(btnApagar);
	}


	protected JPanel getPanel_1() {
		return panel_1;
	}
}

