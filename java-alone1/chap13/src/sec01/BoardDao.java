package sec01;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List<Board> getBoardList() {
		List<Board> boardList = new ArrayList<>();
		boardList.add(new Board("제목1", "내용1"));
		boardList.add(new Board("제목2", "내용1"));
		boardList.add(new Board("제목3", "내용1"));
		return boardList;
	}
}