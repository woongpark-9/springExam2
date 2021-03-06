package tommy.spring.web.board.impl;

import java.util.List;

import org.apache.tomcat.util.http.LegacyCookieProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tommy.spring.web.board.BoardService;
import tommy.spring.web.board.BoardVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	
	@Override
	public void insertBoard(BoardVO vo) {
		// TODO Auto-generated method stub
//		if(vo.getSeq() == 0) {
//			
//		}
	
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
	}
	

	@Override
	public BoardVO getBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.getBoardList(vo);
	}

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0; 
	}

}
