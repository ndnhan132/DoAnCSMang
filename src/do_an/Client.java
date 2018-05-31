package do_an;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Client extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfFile;
	private JTextField tfIp;
	private JTextField tfPort;
	private JButton btnFile;
	private JButton btnSend;
	private JTextArea taMessage;
	
	private int port;
	private InetAddress ip;
	private DatagramSocket clientDatagramSocket;
//	private DatagramPacket clientDatagramPacket;
	private String fileName= "Text.txt";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		setResizable(false);
		setBackground(UIManager.getColor("Menu.selectionBackground"));
		setTitle("CLIENT");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "CLIENT", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {472, 0};
		gbl_contentPane.rowHeights = new int[] {50, 50, 100, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel pnPort = new JPanel();
		pnPort.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_pnPort = new GridBagConstraints();
		gbc_pnPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnPort.insets = new Insets(0, 0, 5, 0);
		gbc_pnPort.gridx = 0;
		gbc_pnPort.gridy = 0;
		contentPane.add(pnPort, gbc_pnPort);
		FlowLayout fl_pnPort = new FlowLayout(FlowLayout.LEFT, 23, 7);
		pnPort.setLayout(fl_pnPort);		
		
		JLabel lblIp = new JLabel("IP Server");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIp.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblIp.setHorizontalAlignment(SwingConstants.LEFT);
		pnPort.add(lblIp);
		
		tfIp = new JTextField();
//		tfIp.setText("localhost");
		tfIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPort.add(tfIp);
		tfIp.setColumns(13);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPort.add(lblPort);
		
		tfPort = new JTextField();
//		tfPort.setText("5555");
		tfPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPort.add(tfPort);
		tfPort.setColumns(8);
		
		JPanel pnFile = new JPanel();
		pnFile.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_pnFile = new GridBagConstraints();
		gbc_pnFile.gridwidth = 0;
		gbc_pnFile.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnFile.insets = new Insets(0, 0, 5, 0);
		gbc_pnFile.gridx = 0;
		gbc_pnFile.gridy = 1;
		contentPane.add(pnFile, gbc_pnFile);
		pnFile.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 7));
		
		tfFile = new JTextField();
//		tfFile.setText("C:\\Users\\PHI LONG\\Documents\\Text.txt");
		tfFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnFile.add(tfFile);
		tfFile.setColumns(22);
		
		btnFile = new JButton("File");
		btnFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnFile.add(btnFile);
		btnFile.addActionListener(this);
		
		btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnFile.add(btnSend);
		btnSend.addActionListener(this);
		
		JPanel pnMessage = new JPanel();
		pnMessage.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, new Color(255, 200, 0), new Color(255, 255, 0), new Color(255, 200, 0), new Color(255, 255, 0)), "MESSAGE", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		GridBagConstraints gbc_pnMessage = new GridBagConstraints();
		gbc_pnMessage.fill = GridBagConstraints.BOTH;
		gbc_pnMessage.gridx = 0;
		gbc_pnMessage.gridy = 2;
		contentPane.add(pnMessage, gbc_pnMessage);
		pnMessage.setLayout(new GridLayout(1, 1, 20, 20));
		
		taMessage = new JTextArea();
		taMessage.setEditable(false);
		taMessage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		pnMessage.add(taMessage);
		taMessage.setText(null);
		taMessage.setText("-> Client dang chay...\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnFile) {
			selectFile();
		}
		if(e.getSource()==btnSend && checkEmpty()) {
			sendFile();
		}
	}
	
	private void sendFile() {
		try {
			port= Integer.parseInt(tfPort.getText());
			ip= InetAddress.getByName(tfIp.getText().toString());	
			clientDatagramSocket = new DatagramSocket();
			byte[] sendData= new byte[10240];
			byte[] receiveData= new byte[10240];
			while(true) {
//gui file name				
				taMessage.setText(taMessage.getText().toString()+"-> Tiến hành gửi file."+ fileName +"\n");
				sendData= fileName.getBytes();
				DatagramPacket clientDatagramPacket =new DatagramPacket(sendData, fileName.length(), ip, port);	
				clientDatagramSocket.send(clientDatagramPacket);
//nhan thong bao				
				DatagramPacket receivePacket= new DatagramPacket(receiveData, receiveData.length);
				clientDatagramSocket.receive(receivePacket);
				String receiveStr= new String(receivePacket.getData(),0 , receivePacket.getLength());
				if(receiveStr.equals("danhan")) {
					taMessage.setText(taMessage.getText().toString()+"->  Gửi tên file thành công."+"\n");
					ip=receivePacket.getAddress();
					port= receivePacket.getPort();
					break;
				}				
			}				
//gui  file
		while (true) {
			taMessage.setText(taMessage.getText().toString()+"->  Tiến hành gửi file."+"\n");
			Path path = Paths.get(tfFile.getText().toString());
			byte[] sendFile= Files.readAllBytes(path);
			DatagramPacket sendFilePacket= new DatagramPacket(sendFile, sendFile.length,ip, port );
			clientDatagramSocket.send(sendFilePacket);
			
			
			DatagramPacket receivePacketFile= new DatagramPacket(receiveData, receiveData.length);
			clientDatagramSocket.receive(receivePacketFile);
			String receiveStr= new String(receivePacketFile.getData(),0 , receivePacketFile.getLength());
			if(receiveStr.equals("danhanfile")) {
				taMessage.setText(taMessage.getText().toString()+"->  Gửi file Thành công."+"\n");
				break;
			}	
		}
			
//nhan thong bao va ket thuc				
		clientDatagramSocket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private void selectFile() {
		JFileChooser fileDialog= new JFileChooser();
		int x= fileDialog.showOpenDialog(this);
		if(x==JFileChooser.APPROVE_OPTION) {
			File file= fileDialog.getSelectedFile();
			tfFile.setText(file.getPath());
			fileName= file.getName();
			taMessage.setText(taMessage.getText().toString()+"-> Đã chọn file: "+ fileName+"\n");
		}
	}
	private boolean checkEmpty() {
		if(tfIp.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập IP.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(tfPort.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập PORT.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
			try {
				Integer.parseInt(tfPort.getText().toString());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Nhập PORT Sai Định Dạng.","Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(tfFile.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Chọn File Trước Khi Gửi.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
}
