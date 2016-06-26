import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javafx.scene.layout.Pane;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;


public class TP {

	static final String JDBC_DRIVER = "org.sqlite.JDBC";
	static final String DB_URL = "jdbc:sqlite:C:\\Users\\Miguel\\git\\tp-cp\\TP-Database.db";

	Connection conn =null;
	Statement stmt =null;

	private JFrame frame;
	private JTextField textField;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPasswordField passwordField;
	private static JList<Carro> list;
	private DefaultListModel<Carro> listModel;
	private JTextField MARCA;
	private JTextField MODELO;
	private JTextField CILINDRADA;
	private JTextField MATRICULA;
	private JTextField ANO;
	private JTextField PRECO;
	private JRadioButton rdbtnGasolina;
	private JRadioButton rdbtnGasolio;
	private JRadioButton rdbtnGpl;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComponent panel;
	private JTextField CODIGO;
	private JTextField OFICINA;
	private JTextField DATA;
	private JTextField OBSERVACOES;
	private JTextField VALOR;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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


		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_606776246522716");
		panel.setBackground( Color.LIGHT_GRAY );
		panel.setLayout(null);

		JLabel label = new JLabel("Login");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(223, 91, 65, 17);
		panel.add(label);

		JLabel label_1 = new JLabel("Password");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_1.setBounds(223, 161, 65, 17);
		panel.add(label_1);

		textField = new JTextField();
		textField.setBounds(376, 86, 112, 30);
		textField.setColumns(10);
		panel.add(textField);


		JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try{
					
				String username = textField.getText().trim();
				String password = passwordField.getText().trim();

				String sql = "select Username,Password from utilizador where Username='" + username + "'and Password = '"+ password +"'";
				ResultSet  rs=stmt.executeQuery(sql);
				
				int cont = 0;

				while(rs.next())
				{
					cont=cont+1; 
				}
				if(cont==1){

					JOptionPane.showMessageDialog(null, "Login efetuado com sucesso");
					panel.setVisible(false);
					panel_1.setVisible(true);
				}
				else if(textField.getText().isEmpty() || passwordField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Campos em falta");
				}
				else{

					JOptionPane.showMessageDialog(null, "Utilizador não existe");
				}
			}catch(Exception e1){
			
		}

			}
			
		});
		button.addMouseListener(new MouseAdapter() {
			
			
				
				
			
			
		});
		button.setBounds(434, 226, 57, 23);
		panel.add(button);



		JButton button_1 = new JButton("Offline");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(false);
				panel_1.setVisible(true);

			}
		});
		button_1.setBounds(223, 226, 77, 23);
		panel.add(button_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(376, 148, 112, 30);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		Image imagens = new ImageIcon(this.getClass().getResource("/cars-icon.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imagens));
		lblNewLabel.setBounds(38, 95, 128, 128);
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
	 	frame.getContentPane().add(panel_1, "name_606776259909658");
		panel_1.setLayout(null);

		JLabel lblListaVeiculos = new JLabel("Lista de carros");
		lblListaVeiculos.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		lblListaVeiculos.setBounds(248, 25, 144, 14);
		panel_1.add(lblListaVeiculos);
		listModel = new DefaultListModel<Carro>(); 
		fillList("SELECT * FROM Carro");
		list = new JList<Carro>(listModel);

		JList<Carro> list = new JList<Carro>(listModel);
		list.setBounds(55, 60, 523, 147);
		panel_1.add(list);

		JButton btnNovo = new JButton("Novo");
		btnNovo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				panel_1.setVisible(false);
				panel_2.setVisible(true);

			}
		});

		btnNovo.setBounds(72, 229, 104, 33);
		panel_1.add(btnNovo);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int Button = JOptionPane.YES_NO_OPTION;
				Button = JOptionPane.showConfirmDialog (null, "Tem a certeza?","Aviso", Button);
				if(Button == JOptionPane.YES_OPTION) {
					DefaultListModel<Carro> model = (DefaultListModel<Carro>) list.getModel();

					int selectedIndex = list.getSelectedIndex();
					Carro c=model.getElementAt(selectedIndex);
					try {
						stmt.executeUpdate("delete FROM Carro WHERE Matricula ='" + c.getMatricula()+"'");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (selectedIndex != -1) {
						model.remove(selectedIndex);

					}
				}
				if(Button == JOptionPane.NO_OPTION) {
					panel_1.setVisible(true);
				}
			}	
		});

		btnApagar.setBounds(270, 229, 99, 33);
		panel_1.add(btnApagar);
		
		JButton btnTaxa = new JButton("Taxa");
		btnTaxa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panel_1.setVisible(false);
				panel_4.setVisible(true);
				
			}
		});
		btnTaxa.setBounds(470, 229, 89, 33);
		panel_1.add(btnTaxa);

		panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, "name_606776269732388");
		panel_2.setLayout(null);


		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(76, 46, 46, 14);
		panel_2.add(lblMarca);

		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(76, 71, 46, 14);
		panel_2.add(lblModelo);

		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(76, 96, 46, 14);
		panel_2.add(lblCor);

		JLabel lblCilindrada = new JLabel("Cilindrada");
		lblCilindrada.setBounds(76, 132, 66, 14);
		panel_2.add(lblCilindrada);

		MARCA = new JTextField();
		MARCA.setBounds(223, 37, 203, 20);
		panel_2.add(MARCA);
		MARCA.setColumns(10);

		MODELO = new JTextField();
		MODELO.setBounds(223, 68, 203, 20);
		panel_2.add(MODELO);
		MODELO.setColumns(10);

		CILINDRADA = new JTextField();
		CILINDRADA.setBounds(223, 129, 203, 20);
		panel_2.add(CILINDRADA);
		CILINDRADA.setColumns(10);

		JComboBox COR = new JComboBox();
		COR.addItem("Amarelo");
		COR.addItem("Rosa");
		COR.addItem("Branco");
		COR.addItem("Preto");
		COR.addItem("Verde");
		COR.addItem("Vermelho");
		COR.addItem("Azul");
		COR.setBounds(223, 98, 74, 20);
		panel_2.add(COR);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(76, 163, 56, 14);
		panel_2.add(lblMatricula);

		JLabel lblCombustivel = new JLabel("Combustivel");
		lblCombustivel.setBounds(76, 196, 88, 14);
		panel_2.add(lblCombustivel);

		JLabel lblAnoaquisio = new JLabel("Ano Aquisi\u00E7\u00E3o");
		lblAnoaquisio.setBounds(76, 229, 88, 14);
		panel_2.add(lblAnoaquisio);

		JLabel lblPreoAquisio = new JLabel("Pre\u00E7o Aquisi\u00E7\u00E3o");
		lblPreoAquisio.setBounds(76, 260, 103, 14);
		panel_2.add(lblPreoAquisio);

		rdbtnGasolio = new JRadioButton("Gasolio");
		buttonGroup.add(rdbtnGasolio);
		rdbtnGasolio.setBounds(223, 192, 74, 23);
		panel_2.add(rdbtnGasolio);

		rdbtnGasolina = new JRadioButton("Gasolina");
		buttonGroup.add(rdbtnGasolina);
		rdbtnGasolina.setBounds(303, 192, 88, 23);
		panel_2.add(rdbtnGasolina);

		rdbtnGpl = new JRadioButton("GPL");
		buttonGroup.add(rdbtnGpl);
		rdbtnGpl.setBounds(393, 192, 66, 23);
		panel_2.add(rdbtnGpl);

		MATRICULA = new JTextField();
		MATRICULA.setBounds(223, 160, 203, 20);
		panel_2.add(MATRICULA);
		MATRICULA.setColumns(10);

		ANO = new JTextField();
		ANO.setBounds(223, 226, 203, 20);
		panel_2.add(ANO);
		ANO.setColumns(10);

		PRECO = new JTextField();
		PRECO.setBounds(223, 257, 203, 20);
		panel_2.add(PRECO);
		PRECO.setColumns(10);

		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_2.setVisible(false);
				panel_1.setVisible(true);
			}
		});

		btnSair.setBounds(421, 288, 89, 23);
		panel_2.add(btnSair);

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				if(MARCA.getText().isEmpty() || MODELO.getText().isEmpty() || CILINDRADA.getText().isEmpty() 
						|| MATRICULA.getText().isEmpty() || ANO.getText().isEmpty() || PRECO.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Campos em falta");
				}
				else{
					
				panel_2.setVisible(false);
				panel_3.setVisible(true);

				String radioB = null;

				if (rdbtnGasolio.isSelected()){
					radioB="Gasolio";
				}
				if (rdbtnGasolina.isSelected()){
					radioB="Gasolina";
				}

				if (rdbtnGpl.isSelected()){
					radioB="GPL";
				}
				String sql= "INSERT INTO Carro(Marca, Modelo, Cor, Cilindrada, Matricula, Combustivel, AnoAquisição, PreçoAquisição) VALUES "
						+ " ('"+ MARCA.getText() + "','" + MODELO.getText() + "','" + COR.getSelectedItem().toString() + "'," + CILINDRADA.getText() + ",'" + MATRICULA.getText() + "','" + radioB + "','" + ANO.getText() + "'," + PRECO.getText()+")"; 
				System.out.println(sql);
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			}
		});

		btnConfirmar.setBounds(223, 288, 103, 23);
		panel_2.add(btnConfirmar);
		
		JLabel lblNovoCarro = new JLabel("A criar novo carro");
		lblNovoCarro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNovoCarro.setBounds(233, 0, 135, 42);
		panel_2.add(lblNovoCarro);
		
		panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, "name_786155060182742");
		panel_3.setLayout(null);
		
		JLabel lblCodigoReviso = new JLabel("Codigo revis\u00E3o");
		lblCodigoReviso.setBounds(103, 48, 86, 14);
		panel_3.add(lblCodigoReviso);
		
		CODIGO = new JTextField();
		CODIGO.setBounds(216, 45, 111, 20);
		panel_3.add(CODIGO);
		CODIGO.setColumns(10);
		
		JLabel lblOficina = new JLabel("Oficina");
		lblOficina.setBounds(103, 91, 46, 14);
		panel_3.add(lblOficina);
		
		OFICINA = new JTextField();
		OFICINA.setBounds(216, 88, 111, 20);
		panel_3.add(OFICINA);
		OFICINA.setColumns(10);
		
		JLabel lblDataDaReviso = new JLabel("Data da revis\u00E3o");
		lblDataDaReviso.setBounds(103, 133, 86, 14);
		panel_3.add(lblDataDaReviso);
		
		DATA = new JTextField();
		DATA.setBounds(216, 130, 111, 20);
		panel_3.add(DATA);
		DATA.setColumns(10);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setBounds(103, 178, 86, 14);
		panel_3.add(lblObservaes);
		
		OBSERVACOES = new JTextField();
		OBSERVACOES.setBounds(216, 175, 237, 20);
		panel_3.add(OBSERVACOES);
		OBSERVACOES.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(103, 218, 46, 14);
		panel_3.add(lblValor);
		
		VALOR = new JTextField();
		VALOR.setBounds(216, 215, 111, 20);
		panel_3.add(VALOR);
		VALOR.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(CODIGO.getText().isEmpty() || OFICINA.getText().isEmpty() || DATA.getText().isEmpty() 
						|| OBSERVACOES.getText().isEmpty() || VALOR.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Campos em falta");
				}
					
					else{
				panel_3.setVisible(false);
				panel_1.setVisible(true);
				
				String sql= "INSERT INTO Revisao(codigoRevisão, Oficina, DataRevisão, Observações, Valor) VALUES "
						+ " ('"+ CODIGO.getText() + "','" + OFICINA.getText() + "','" + DATA.getText() + "','" + OBSERVACOES.getText() + "','" + VALOR.getText()+"')"; 
				System.out.println(sql);
				try {
					stmt.executeUpdate(sql);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}					
		});
		btnNewButton.setBounds(103, 265, 89, 23);
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				panel_3.setVisible(false);
				panel_2.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(238, 265, 89, 23);
		panel_3.add(btnNewButton_1);
		
		JButton btnSair_1 = new JButton("Sair");
		btnSair_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_3.setVisible(false);
				panel_1.setVisible(true);
			}
		});
		btnSair_1.setBounds(364, 265, 89, 23);
		panel_3.add(btnSair_1);
		
	    panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, "name_154598225556850");
		panel_4.setLayout(null);
		
		JLabel lblMatricula_1 = new JLabel("Matricula");
		lblMatricula_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMatricula_1.setBounds(90, 56, 80, 14);
		panel_4.add(lblMatricula_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(240, 55, 177, 20);
		panel_4.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblValor_1 = new JLabel("Valor");
		lblValor_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor_1.setBounds(91, 107, 46, 14);
		panel_4.add(lblValor_1);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(91, 159, 46, 14);
		panel_4.add(lblData);
		
		JLabel lblValidade = new JLabel("Validade");
		lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValidade.setBounds(90, 209, 80, 14);
		panel_4.add(lblValidade);
		
		textField_2 = new JTextField();
		textField_2.setBounds(240, 106, 177, 20);
		panel_4.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(240, 158, 177, 20);
		panel_4.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(240, 208, 177, 20);
		panel_4.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnConfirmar_1 = new JButton("Confirmar");
		btnConfirmar_1.setBounds(81, 268, 89, 23);
		panel_4.add(btnConfirmar_1);
		
		JButton btnSair_2 = new JButton("Sair");
		btnSair_2.setBounds(328, 268, 89, 23);
		panel_4.add(btnSair_2);
		

		panel_2.setVisible(false);
		panel_1.setVisible(false);

	}
	


			
				
	private void fillList(String sql){
		try{
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Carro cl = new Carro(
						rs.getString("Marca"),
						rs.getString("Modelo"),
						rs.getString("Cor"),
						rs.getInt("Cilindrada"),
						rs.getString("Matricula"),
						rs.getString("Combustivel"),
						rs.getString("AnoAquisição"),
						rs.getFloat("PreçoAquisição"));

				listModel.addElement(cl);
			};
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

	}



	protected JPanel getPanel_1() {
		return panel_1;
	}
}

