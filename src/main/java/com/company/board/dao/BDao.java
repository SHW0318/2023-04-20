package com.company.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BDao {
	
	DataSource dataSource;

	public BDao() {
		super();
		// TODO Auto-generated constructor stub
	
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String bname, String btitle, String bcontent) {
		
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO mvc_board (bid, bname, btitle, bcontent, bhit, bgroup, bstep, bindent) VALUES (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
