package do_an_hdh;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Main extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField tfStt;
	private JTextField tfTen;
	private JTextField tfTDen;
	private JTextField tfTXuly;
	private JTextField tfKhung; 
	private JScrollPane scrollPane;
	private JButton btnAdd, btnRefress, btnReset, btnRun;
	private JComboBox cbb;
	private JScrollPane panel_9;
	private JLabel lbErr, lblTb;
	
	private ArrayList<Process> list= new ArrayList<Process>();
	private JTable table;
	private JTable tbDemo;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.---------------------------------------------------------------------------------------------------------------------------------------
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setLocationRelativeTo(null);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JPanel pnInput = new JPanel();
		tabbedPane.addTab("Input", (Icon) null, pnInput, null);
		pnInput.setLayout(new GridLayout(7, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		pnInput.add(panel_1);
		
		JLabel lblThongTin = new JLabel("Nh\u1EADp th\u00F4ng tin t\u1EEB b\u00E0n ph\u00EDm");
		lblThongTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		panel_1.add(lblThongTin);
		
		JPanel panel_2 = new JPanel();
		pnInput.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTienTrinhThu_1 = new JLabel("S\u1ED1 th\u1EE9 t\u1EF1");
		lblTienTrinhThu_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTienTrinhThu_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblTienTrinhThu_1);
		
		tfStt = new JTextField();
		tfStt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(tfStt);
		tfStt.setColumns(10);
		
		JPanel panel = new JPanel();
		pnInput.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lbldinhdanh = new JLabel("Tên tiến trình");
		lbldinhdanh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbldinhdanh.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lbldinhdanh);
		
		tfTen = new JTextField();
		tfTen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(tfTen);
		tfTen.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		pnInput.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTDen = new JLabel("Th\u1EDDi gian \u0111\u1EBFn");
		lblTDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTDen.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblTDen);
		
		tfTDen = new JTextField();
		tfTDen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(tfTDen);
		tfTDen.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		pnInput.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblTXly = new JLabel("Th\u1EDDi gian x\u1EED l\u00FD");
		lblTXly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTXly.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblTXly);
		
		tfTXuly = new JTextField();
		tfTXuly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_5.add(tfTXuly);
		tfTXuly.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		pnInput.add(panel_6);
		
		lblTb = new JLabel("");
		lblTb.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblTb.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblTb);
		
		JPanel panel_4 = new JPanel();
		pnInput.add(panel_4);
		
		btnAdd = new JButton("Th\u00EAm");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_4.add(btnAdd);
		
		JPanel pnOutput = new JPanel();
		tabbedPane.addTab("Output", null, pnOutput, null);
		pnOutput.setLayout(new BorderLayout(0, 0));
		
		btnRefress = new JButton("Refress");
		btnRefress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnOutput.add(btnRefress, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		pnOutput.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		JPanel pnDemo = new JPanel();
		tabbedPane.addTab("Demo", null, pnDemo, null);
		pnDemo.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		pnDemo.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_11 = new JPanel();
		panel_8.add(panel_11);
		panel_11.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblKhung = new JLabel("Số khung // quantum ");
		lblKhung.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_11.add(lblKhung);
		
		tfKhung = new JTextField();
		tfKhung.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_11.add(tfKhung);
		tfKhung.setColumns(3);
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		
		String str[]= {"FIFO", "RR", "SJF", "SRT"};
		 cbb = new JComboBox(str);
		cbb.setBounds(50, 50, 100, 20);
		cbb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_10.add(cbb);
		
		JPanel panel_12 = new JPanel();
		panel_8.add(panel_12);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_12.add(btnReset);
		
		btnRun = new JButton("Run");
		btnRun.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_12.add(btnRun);
		
		JScrollPane pnTable = new JScrollPane();
		pnDemo.add(pnTable, BorderLayout.CENTER);
		
		tbDemo = new JTable();
		pnTable.setViewportView(tbDemo);
		
		JPanel panel_7 = new JPanel();
		pnDemo.add(panel_7, BorderLayout.SOUTH);
		
		lbErr = new JLabel();
		lbErr.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_7.add(lbErr);
		
		
		JPanel pnInfo = new JPanel();
		tabbedPane.addTab("Info", null, pnInfo, null);
		
		JLabel lblGvHngDn = new JLabel("GV hướng dẫn  :   Ts Phạm Minh Tuấn");
		lblGvHngDn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGvHngDn.setBounds(85, 54, 265, 17);
		
		JLabel lblLpt = new JLabel("Lớp                  :   14T3");
		lblLpt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLpt.setBounds(85, 123, 232, 14);
		
		JLabel lblSvThcHin = new JLabel("SV thực hiện     :   Nguyễn Đình Nhân");
		lblSvThcHin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSvThcHin.setBounds(84, 82, 232, 30);
		
		JLabel lblMssv = new JLabel("MSSV                :   102140139");
		lblMssv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMssv.setBounds(85, 163, 232, 14);
		pnInfo.setLayout(null);
		pnInfo.add(lblGvHngDn);
		pnInfo.add(lblLpt);
		pnInfo.add(lblSvThcHin);
		pnInfo.add(lblMssv);
		
		
		btnAdd.addActionListener(this);
		btnRefress.addActionListener(this);
		btnReset.addActionListener(this);
		btnRun.addActionListener(this);
	}
//------------------------------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnAdd&& checkInput()) {
			list.add(new Process( 1 ,  0 , 4 , "a"  ));
			list.add(new Process( 2 ,  2 ,  7 ,  "s"  ));
			list.add(new Process( 3 ,  6 , 2  ,  "c"  ));
			list.add(new Process( 4 ,  8 , 5  ,  "d"  ));
//			list.add(new Process( 5 , 9  ,  9 ,  "e"  ));
//			list.add(new Process( 6 , 11  , 3  ,  "r"  ));
//			list.add(new Process(7  , 17  ,  7 ,  "t"  ));
			list.add(new Process(Integer.parseInt(tfStt.getText()), Integer.parseInt(tfTDen.getText()), 
					Integer.parseInt(tfTXuly.getText()), tfTen.getText().toString()));
			tfStt.setText(String.valueOf(Integer.parseInt(tfStt.getText())   +1));
			tfTDen.setText("");
			tfTen.setText("");
			tfTXuly.setText("");
			lblTb.setText("Đã thêm");
		}
		if(e.getSource()==btnRefress) {
			DefaultTableModel modelrefress= new DefaultTableModel(
					showOutput(),
					new String[] {
						"STT", "Tên", "TG Đến", "TG Xử Lý"
					}
				);
				table.setModel(modelrefress);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
		}
		if(e.getSource()==btnReset) {
			tfKhung.setText("");
		}
		if(e.getSource()==btnRun ) {
			lbErr.setText("");
			if(cbb.getSelectedIndex()==0 && checkKhung()) {		//fifo
//				JOptionPane.showMessageDialog(this, "fifo","Error", JOptionPane.INFORMATION_MESSAGE);
				FIFO();
			}
			if(cbb.getSelectedIndex()==1  && checkKhung()) {		//RR
				RR();
						}
			if(cbb.getSelectedIndex()==2) {		//SJF
				SJF();
			}
			if(cbb.getSelectedIndex()==3) {		//srt
				SRT();
			}	
		}
	}
	//--------------------------------------------------------------------------------------------------------------------------------
	private void FIFO() {
		int n=Integer.parseInt(tfKhung.getText());
		String[] tbData= new String[list.size()];
		for (int i=0; i<list.size(); i++) {
				tbData[i]= list.get(i).getTen();
			}
		Object[][] data= new Object[n+1][list.size()];
		
		data[0][0]= list.get(0).getTen();	// gan vi tri dau cho p0
		for(int x= 1; x<n; x++) {			//cac hang sau rong
			data[x][0]= " "; 
		}
		data[n][0]="*";
		int k=1;		//vi tri cot thu k dang duoc xu ly
		int i=1;		//vi tri hang se duoc thay the
		boolean kt= false;
		while(k<list.size()) {
			//kiem tra ==
			for(int x=0; x<n; x++) { 	//chay tu hang 1 den hang cuoi
				if(list.get(k).getTen().equals(data[x][k-1])) {	//neu ten vi tri k khac 
					kt=true;
				}else {
					kt= false;
				}
			}
			if(kt) {		//neu co trung
				for(int x= 0; x <n ; x++) {
					data[x][k]= data[x][k-1];		//vi tri i ko doi
				}
				data[n][k]=" ";
			}else {			//khong co trung
				for(int x= 0; x <n ; x++) {
					data[x][k]= data[x][k-1];		
				}
				data[i][k]= list.get(k).getTen(); //thay doi vi tri i
				data[n][k]="*";
				if(i<(n-1)) {
					i++;
				}else {
					i=0;
				}
			}			
			k++;//ket thuc 1 cot k tang sang cot ben canh 
		}
		DefaultTableModel modelfifo= new DefaultTableModel(data , tbData);
		tbDemo.setModel(modelfifo);
		int y=0;
		for(int x=0; x<list.size(); x++) {
			if(data[n][i].equals("*")) y++;
		}
		lbErr.setText("Tổng số trang lối là: " + y + " trang");
	}
	//-------------------------------------------------------------------------------------------------------------------------------------
	private void RR() {
		int n=Integer.parseInt(tfKhung.getText());		//quantum
		ArrayList<Process> DS= new ArrayList<Process>();
		for (Process p : list) {
			DS.add(new Process(p));
		}
		int sum=0;
		for(int x=0; x<list.size(); x++) {
			sum+= list.get(x).getTXuly();
		}
		int t= (int)(sum/n)+n;
		Object[][] data= new Object[2][t];
		int k=DS.size();
		for(int x = 0; x< t; x++) {  		//thoi gian thu x
			if(x>=k) {
				break;
			}else if(DS.get(x).getTXuly()<= n) {		//t xu li con lai <= quantum
				data[0][x]= DS.get(x).getTen();
				data[1][x]= String.valueOf(DS.get(x).getTXuly());
			}else if(DS.get(x).getTXuly()> n) {
				k++;
				data[0][x]= DS.get(x).getTen();
				data[1][x]= String.valueOf(n);
				DS.add(new Process(DS.get(x).getStt(), DS.get(x).getTDen() + x , DS.get(x).getTXuly()-n , DS.get(x).getTen() ));
			}
		}
		String[] tbData= new String[t];
		for(int x=0; x<t; x++) {
			tbData[x]= String.valueOf(x);
		}
		DefaultTableModel modelRR= new DefaultTableModel(data,tbData);
		tbDemo.setModel(modelRR);
	}
	//----------------------------------------------------------------------------------------------------------------------------------------------
	private void SRT() {
		ArrayList<Process> DS= new ArrayList<Process>(list.size());
		int sum=0;
		for (Process p : list) {
			DS.add(new Process(p));
			sum+=p.getTXuly();
		}
		String[] tbData= new String[sum];
		for(int x=0; x<sum; x++) {
			tbData[x]= String.valueOf(x);
		}
		Object[][] data= new Object[1][sum];
		data[0][0]= DS.get(0).getTen();
		DS.get(0).setTXuly( DS.get(0).getTXuly() -1 );
		for(int x= 1; x<sum; x++) {
			int k= getMin(x, DS);
			if(k== 100) {
				break;
			}else {
				data[0][x]= DS.get(k).getTen();
				DS.get(k).setTXuly( DS.get(k).getTXuly() -1 );
			}
		}
		DefaultTableModel modelsrt= new DefaultTableModel(data,tbData);
		tbDemo.setModel(modelsrt);
		//-----------------------------------------------------------------------------------------------------
	}
	private void SJF() {
		ArrayList<Process> DS= new ArrayList<Process>(list.size());
		int sum=0;
		for (Process p : list) {
			DS.add(new Process(p));
			sum+= p.getTXuly();
		}
		String[] tbData= new String[sum];
		for(int x=0; x<sum; x++) {
			tbData[x]= String.valueOf(x);
		}
		Object[][] data= new Object[1][sum];
		int i=0;
		int k=0; //vi tri trong DS
		while(i<sum) {
			
			for(int x= i ; x < i+DS.get(k).getTXuly() ; x++) {
				data[0][x]= DS.get(k).getTen();
			}
			i+=DS.get(k).getTXuly();
			DS.get(k).setTXuly(0);

			k=getMin(i, DS);
		}
		
		DefaultTableModel modelsjf= new DefaultTableModel(data,tbData);
		tbDemo.setModel(modelsjf);
	}
//-----------------------------------------------------------------------------------------------------

	private int getMin(int x, ArrayList<Process> DS) {
		ArrayList<Process> TG= new ArrayList<Process>();
		for (Process p : DS) {
			if(p.getTDen() <= x && p.getTXuly()>0) {
				TG.add(p);
			}
		}
		Process pMin;
		if(TG.size()>0) {
			pMin= TG.get(0);
		}else {
			return 100;
		}
		for (Process p : TG) {
			if(p.getTXuly() < pMin.getTXuly()) {
				pMin= p;
			}
		}
		for(int i= 0; i<DS.size(); i++) {
			if(pMin== DS.get(i)) {
				return i;
			}
		}
		return 100;
	}
	
	private boolean checkInput() {
		if(tfTen.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập tên tiến trình.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(tfTDen.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập Tg hình thành.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
			try {
				Integer.parseInt(tfTDen.getText().toString());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Nhập TG hình thành Sai Định Dạng.","Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(tfTXuly.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập Tg xử lý.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
			try {
				Integer.parseInt(tfTXuly.getText().toString());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Nhập Tg xử lý Sai Định Dạng.","Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(tfStt.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Hãy Nhập STT.","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}else {
			try {
				Integer.parseInt(tfStt.getText().toString());
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Nhập STT Sai Định Dạng.","Error", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		return true;
	}
	private boolean checkKhung() {
		try {
			int n= Integer.parseInt(tfKhung.getText());
			if(n> 0) {
				return true;
			}else {
				JOptionPane.showMessageDialog(this, "hãy nhập số lớn hơn 0.","Error", JOptionPane.INFORMATION_MESSAGE);
				return false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Nhập  sai định dạng ","Error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
	private Object[][] showOutput() {

	    Object row[][]= new Object[20][4];
		for(int i=0; i<list.size(); i++) {
			row[i][0]= list.get(i).getStt();
			row[i][1]= list.get(i).getTen();
			row[i][2]= list.get(i).getTDen();
			row[i][3]= list.get(i).getTXuly();
		}
		return row;
	}

}


