package common;

import board.model.vo.PageInfo;

public class Pagination {

	public static PageInfo getPageInfo(int currentPage, int listCount) {
		int pageLimit = 10; // 한페이지에 보여질 페이징의 수 (< 1 2 3 4 5 >)  << 게시글 밑에 있는 이거 (개발자가 지정한 변수/ 계산x)
		int maxPage; // 전체 페이징된 수 중 마지막 페이지 수
		int startPage; // 현 페이지에서 보이는 페이징 버튼의 시작
		int endPage;  // 현 페이지에서 보이는 페이징 버튼의 끝
		int boardLimit = 5; // 한 페이지에 보여질 게시글의 수 (개발자가 지정한 변수/ 계산x)
		
		maxPage = (int)Math.ceil((double)listCount/boardLimit); // Math.ceil() >> 올림메소드

		startPage = (currentPage - 1)/pageLimit*pageLimit + 1;
		// 1, 11, 21, 31, ...  => 10n + 1 (n >= 0) >> 규칙을 찾아 수열로 나타내서 코드짜면 좋다능
		// n = (cureentPage - 1)/pageLimit  >> 현재 페이지 수가 12면 -1해서 11 >> 페이지리밋으로 나누면 n을 구할 수 있다
		
		endPage = startPage + pageLimit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pi = new PageInfo(currentPage, listCount, pageLimit, maxPage, startPage, endPage, boardLimit);
		
		return pi;
	}
}
