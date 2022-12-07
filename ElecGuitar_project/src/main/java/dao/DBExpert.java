package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Purchase;
import dto.SeInfo;


public class DBExpert {
//oracle.jdbc.OracleDriver
//jdbc:oracle:thin:@//localhost:1521/xe
	private String driver = "oracle.jdbc.OracleDriver";
	private String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	private Connection con = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	
	public boolean getPutElec(Purchase p, SeInfo s) {
		String ins1 = "insert into ele_list_tbl "
				+ "values(?,?,?,?,?)";
		String ins2 = "insert into "
				+ "sell_info_tbl values(?,?,?,?,?,?)";
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag = false;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pst=con.prepareStatement(ins1);
			pst.setString(1, p.getEle_num());
			pst.setString(2, p.getModel());
			pst.setString(3, p.getPickup());
			pst.setString(4, p.getNeck());
			pst.setInt(5, p.getPrice());
			flag1 = true;
			pst.executeUpdate();
			con.commit();
			pst=con.prepareStatement(ins2);
			pst.setString(1, p.getMad_name());
			pst.setString(2, p.getModel());
			pst.setString(3, s.getSell_name());
			pst.setString(4, s.getSell_count());
			pst.setString(5, s.getSell_addr());
			pst.setString(6, p.getSell_numb());
			pst.executeUpdate();
			flag2= true;
			con.commit();
			if(flag1 == true && flag2 == true ) {
				flag = true;
				con.commit();
			}else {
				con.rollback();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close(); con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return flag;
	}
	
	
	public ArrayList<Purchase> getTelSell(){
		String select = "select mad_name, sell_numb from sell_info_tbl";
		ArrayList<Purchase> ts = new ArrayList<Purchase>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pst = con.prepareStatement(select);
			rs = pst.executeQuery();
			while(rs.next()) {
				Purchase pc = new Purchase();
				pc.setMad_name(rs.getString(1));
				pc.setSell_numb(rs.getString(2));
				ts.add(pc);
				con.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pst.close(); con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return ts;
	}
	
	
	public ArrayList<Purchase> getEleList(){
		String select="select ele.ele_num, ele.model, ele.pickup, ele.neck, ele.price, seller.mad_name, seller.sell_numb "
				+ "from ele_list_tbl ele, sell_info_tbl seller "
				+ "where ele.model = seller.model";
		ArrayList<Purchase> pur = new ArrayList<Purchase>();
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,"hr","hr");
			pst = con.prepareStatement(select);
			rs = pst.executeQuery();
			while(rs.next()) {
				Purchase pu = new Purchase();
				pu.setEle_num(rs.getString(1));
				pu.setModel(rs.getString(2));
				pu.setPickup(rs.getString(3));
				pu.setNeck(rs.getString(4));
				pu.setPrice(rs.getInt(5));
				pu.setMad_name(rs.getString(6));
				pu.setSell_numb(rs.getString(7));
				pur.add(pu);
				con.commit();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pst.close(); con.close();
			}catch(Exception e) {e.printStackTrace();}
		}
		return pur;
	}
}
