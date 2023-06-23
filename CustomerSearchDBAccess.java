/**
 * クラス名：    Customer
 * 概要　　：    顧客情報
 * 作成者名：    福島佳織
 * 作成日　：	 2023/05/23
 * 修正者名：
 * 修正日　：
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerSearchDBAccess {

	private static Connection crieateConnection() throws Exception{
		Connection con = null;
		
		try {
			//Class.forName("com.sql.cj.jdbc.KiddaLaController");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/KIDDA_LA"
					, "user1" , "pass1");
		
		} catch (Exception e) {
			throw new Exception("DB接続処理に失敗しました！");
		}
//			} catch(Exception e) {
//				throw new Exception("DB接続処理に失敗しました！");
//			}
//			
		return con;
	}

	
	
	private static void closeConnection(Connection con) throws Exception {
		// データベースとの接続切断
		try {
			con.close();
			
		}catch(SQLException e) {
			throw new Exception("DB接続処理に失敗しました！");
		}
	}
	
	
	//telでDB検索
	public ArrayList<Customer> serchCustomerByTel(String tel) throws Exception {
		System.out.println("searchCustomerByTel");
		Connection con = crieateConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("ArrayListインスタンス");
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
				pstmt = con.prepareStatement("SELECT CUSTID , CUSTNAME , KANA , ADDRESS FROM CUSTOMER "
						+ "WHERE TEL = ? ;");
				pstmt.setString(1 , tel);
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int custId = rs.getInt("CUSTID");
					String custName = rs.getString("CUSTNAME");
					String kana = rs.getString("KANA");
					String address = rs.getString("ADDRESS");
					Customer customer = new Customer(custId , custName , kana , tel , address);
					list.add(customer);				
			}
			
		} catch (SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		closeConnection(con);
		//ArrayListインスタンスの参照返却
		return list;
	}


	//kanaでDB検索
	public ArrayList<Customer> serchCustomerByKana(String kana) throws Exception {
		System.out.println("searchCustomerByKana");
		Connection con = crieateConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			
				pstmt = con.prepareStatement("SELECT CUSTID , CUSTNAME , KANA , TEL ,  ADDRESS FROM CUSTOMER "
						+ "WHERE KANA LIKE ? ;");
				//kanaの曖昧検索
				pstmt.setString(1 , "%" + kana + "%");
				rs = pstmt.executeQuery();
				while(rs.next() == true) {
					int custId = rs.getInt("CUSTID");
					String custName = rs.getString("CUSTNAME");
					kana = rs.getString("KANA");
					String tel = rs.getString("TEL");
					String address = rs.getString("ADDRESS");
					Customer customer = new Customer(custId , custName , kana , tel , address);
					list.add(customer);
				
				
			}
			
		} catch (SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
					
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		closeConnection(con);
		//ArrayListインスタンスの参照返却
		return list;
	}
	
	
	//telとkanaでDB検索
	public ArrayList<Customer> serchCustomer(String tel , String kana) throws Exception {
		//System.out.println("serchCustomer");
		Connection con = crieateConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			
				pstmt = con.prepareStatement("SELECT CUSTID , CUSTNAME , KANA , ADDRESS FROM CUSTOMER "
						+ "WHERE TEL = ? AND KANA LIKE ? ;");
				//telの完全一致検索
				pstmt.setString(1 , tel);
				//kanaの曖昧検索
				pstmt.setString(2 , "%" + kana + "%");
				rs = pstmt.executeQuery();
				
				while(rs.next() == true) {
					int custId = rs.getInt("CUSTID");
					String custName = rs.getString("CUSTNAME");
					String address = rs.getString("ADDRESS");
					Customer customer = new Customer(custId , custName , kana , tel , address);
					list.add(customer);
				
			}
			
		} catch (SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		closeConnection(con);
		//ArrayListインスタンスの参照返却
		return list;
	}

}


