package do_an_hdh;

public class Process {
	private int mStt,mTden,mTxuly;
	private String mTen;
	public Process() {
		
	}
	public Process(int stt, int den, int xuly, String ten) {
		this.mStt= stt;
		this.mTden= den;
		this.mTxuly= xuly;
		this.mTen= ten;
	}
	public Process(Process p) {
		this.mStt= p.mStt;
		this.mTden= p.mTden;
		this.mTxuly= p.mTxuly;
		this.mTen= p.mTen;
	}
	
	public int getStt() {
		return mStt;
	}
	public void setSTt(int i) {
		this.mStt= i;
	}
	public int getTDen() {
		return mTden;
	}
	public void setTDen(int i) {
		this.mTden= i;
	}
	public int getTXuly() {
		return mTxuly;
	}
	public void setTXuly(int i) {
		this.mTxuly= i;
	}
	public String getTen() {
		return mTen;
	}
	public void setTen(String s) {
		this.mTen= s;
	}
	
}
