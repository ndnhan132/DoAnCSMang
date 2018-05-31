
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

import javax.sound.sampled.Port;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Server extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea taMessage;
	private JButton btnSave;
	private JTextField tfIp;
	private JTextField tfPort;
	private JButton btnRun;
	private JTextField tfFolder;
	private JButton btnFolder;
	
	private int port;
	private InetAddress ip;
	private DatagramSocket serverDatagramSocket;
	private String fileName; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
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
	public Server() {
		setTitle("SERVER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "SERVER", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
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
		FlowLayout fl_pnPort = new FlowLayout(FlowLayout.LEFT, 12, 7);
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
		tfIp.setColumns(12);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPort.add(lblPort);
		
		tfPort = new JTextField();
//		tfPort.setText("5555");
		tfPort.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPort.add(tfPort);
		tfPort.setColumns(6);
		
		btnRun = new JButton("Run");
		btnRun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnPort.add(btnRun);
		btnRun.addActionListener(this);
		
		JPanel pnFolder = new JPanel();
		pnFolder.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		GridBagConstraints gbc_pnFolder = new GridBagConstraints();
		gbc_pnFolder.gridwidth = 0;
		gbc_pnFolder.fill = GridBagConstraints.HORIZONTAL;
		gbc_pnFolder.insets = new Insets(0, 0, 5, 0);
		gbc_pnFolder.gridx = 0;
		gbc_pnFolder.gridy = 1;
		contentPane.add(pnFolder, gbc_pnFolder);
		pnFolder.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 7));
		
		tfFolder = new JTextField();
//		tfFolder.setText("C:\\Users\\PHI LONG\\Documents\\save-here");
		tfFolder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnFolder.add(tfFolder);
		tfFolder.setColumns(22);
		
		btnFolder = new JButton("Folder");
		btnFolder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnFolder.add(btnFolder);
		btnFolder.addActionListener(this);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnFolder.add(btnSave);
		btnSave.addActionListener(this);
		
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRun && checkEmpty()) {
			start();
		}
		if(e.getSource()==btnFolder) {
			selectFolder();
		}
		if(e.getSource()==btnSave&& checkEmpty()) {
			saveFile();
		}
	}
	
	private void start() {
		try {	
			port = Integer.parseInt(tfPort.getText().toString());
//			ip= InetAddress.getByName(tfIp.getText().toString());
			serverDatagramSocket = new DatagramSocket(port);
			taMessage.setText(taMessage.getText().toString()+"-> Server đang chạy."+"\n");
		} catch (Exception e) {
			// TODO: handle exception
			taMessage.setText(taMessage.getText().toString()+"-> Không khởi động được Server."+"\n");
		}
	}
	private void receiveFile() {
		try {
			while(true) {
//nhan file name				
				byte[] receiveFileName = new byte[10240];
				DatagramPacket reFileNamePacket = new DatagramPacket(receiveFileName, receiveFileName.length);
				serverDatagramSocket.receive(reFileNamePacket);
				fileName=new String(reFileNamePacket.getData(), 0, reFileNamePacket.getLength());
				if(!fileName.equals("")) {
					port= reFileNamePacket.getPort();
					ip= reFileNamePacket.getAddress();
					tfFolder.setText(tfFolder.getText().toString() + "\\" + fileName);
					taMessage.setText(taMessage.getText().toString()+"-> Đã nhận tên file: "+ fileName +"\n");
//thong bao nhan file name					
					String sendStr= "danhan";
					byte[] sendData1= new byte[10240];
					sendData1= sendStr.getBytes();
					DatagramPacket sendPacket1= new DatagramPacket(sendData1, sendStr.length(), ip, port);
					serverDatagramSocket.send(sendPacket1);
					taMessage.setText(taMessage.getText().toString()+"-> Gửi thông báo nhận tên file." +"\n");
					break;
				}	
			}
			
			while(true) {
//nhan file
				byte[] fileData= new byte[10240];
				DatagramPacket receiveFile= new DatagramPacket(fileData, fileData.length);
				serverDatagramSocket.receive(receiveFile);
				byte[]  reData=receiveFile.getData();
				if(reData.length>0) {
					Path path= Paths.get(tfFolder.getText().toString());
					Files.write(path, reData);
//gui thong bao ket thuc	;			
					port= receiveFile.getPort();
					ip= receiveFile.getAddress();				
					String sendStr2= "danhanfile";
					byte[] sendData2= new byte[10240];
					sendData2= sendStr2.getBytes();
					DatagramPacket sendPacketFile= new DatagramPacket(sendData2, sendStr2.length(), ip, port);
					serverDatagramSocket.send(sendPacketFile);
					taMessage.setText(taMessage.getText().toString()+"-> Đã nhận được file." +"\n");
					break;
				}
			}
			JOptionPane.showMessageDialog(this, "Lưu Thành Công","SAVE", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			taMessage.setText(taMessage.getText().toString()+"-> Lỗi khi nhận file." +"\n");
		}
	}
	
	private void saveFile() {
		try {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog (null, "Bạn có muốn lưu file đã nhận","SAVE",dialogButton);
			if(dialogResult == JOptionPane.YES_OPTION){
			  receiveFile();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private boolean checkEmpty() {
		if(tfIp.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập IP","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(tfPort.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập PORT","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
			try {
				Integer.parseInt(tfPort.getText().toString());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Nhập PORT Sai Định Dạng","Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(tfFolder.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy chọn thư mục lưu trữ","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void selectFolder() {
		JFileChooser fileDialog= new JFileChooser();
		fileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);			
		int x= fileDialog.showSaveDialog(this);
		if(x==JFileChooser.APPROVE_OPTION) {
			File file= fileDialog.getSelectedFile();
			tfFolder.setText(file.getPath());
			taMessage.setText(taMessage.getText().toString()+"Đã chọn folder: "+ tfFolder.getText().toString()+"\n");
		}
	}
}
