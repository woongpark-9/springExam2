package tommy.spring.web.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import tommy.spring.web.board.BoardVO;
import tommy.spring.web.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) "
			+ "values((select nvl(max(seq), 0)+1 from myboard), ?, ?, ?)";
			private final String BOARD_UPDATE = "update myboard set title=?, "
			+ "content=? where seq=?";
			private final String BOARD_DELETE = "delete myboard where seq=?";
			private final String BOARD_GET = "select * from myboard where seq=?";
			private final String BOARD_LIST = "select * from myboard order by seq desc"; 
	
	public void insertBoard(BoardVO vo) {
		System.out.println("insertBoard 扁瓷贸府");
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(BOARD_INSERT);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getWriter());
			ps.setString(3, vo.getContent());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, con);
		}
	}
	public void updateBoard(BoardVO vo) {
		System.out.println("updateBoard 扁瓷贸府");
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(BOARD_UPDATE);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3,vo.getSeq());
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, con);
		}
	}
	public void deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard 扁瓷 贸府");
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(BOARD_DELETE);
			ps.setInt(1, vo.getSeq());
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(ps, con);
		}
	}
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		System.out.println("getBoard 扁瓷 贸府");
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(BOARD_GET);
			ps.setInt(1, vo.getSeq());
			rs = ps.executeQuery();
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, con);
		}
		return board;
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("getBoardList 扁瓷贸府");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(BOARD_LIST);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegDate(rs.getDate("regdate"));
				board.setCnt(rs.getInt("cnt"));
				boardList.add(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, con);
		}
		return boardList;
	}

}
