package util;

public class PageIndex {
	public static String pageList(int page, int totpage, String url, String addtag) {
		int idx_pre, idx_start;

		String s_pre = "";
		String s_idx = "";
		String s_next = "";

		idx_start = ((page - 1) / 10) * 10 + 1;
		idx_pre = ((page - 1) / 10);

		// Prev 표시 부분
		if (idx_pre > 0) {
			s_pre = "<a href='" + url + "&page=" + (idx_pre * 10) + addtag + "'>" + "[이전]</a>";
		} else {
			s_pre = "[이전]";
		}

		// 번호 표시 부분
		for (int i = 0; i < 10; i++, idx_start++) {
			if (idx_start > totpage)
				break;
			if (idx_start == page)
				s_idx = s_idx + " " + idx_start + " ";
			else {
				s_idx = s_idx + "<a href='" + url + "&page=" + idx_start;
				s_idx = s_idx + addtag + "'>" + idx_start + "</a>";
			}
		}
		// Next 표시부분
		if (idx_start <= totpage) {
			s_next = "<a href ='" + url + "&page=" + idx_start + addtag + "'>" + "[다음]</a>";
		} else {
			s_next = "[다음]";
		}
		String outHtml = s_pre + s_idx + s_next; // Html 문 조합
		return outHtml;
	}
}