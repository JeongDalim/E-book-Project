package action.excel;

import java.io.File;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.member.AdminDAO;
import model.member.PublisherVO;

public class plistexcel {
	public void testexcel() {
		// 엑셀파일 객체 생성
		WritableWorkbook workbook = null;

		// 시트 객체 생성
		WritableSheet sheet = null;

		// 셀 객체 생성
		Label label = null;

		// 저장할 파일 객체 생성
		File file = new File("C:\\excel\\plistexcel.xls");
		System.out.println(file.isDirectory());
		// 테스트 데이터
		List<PublisherVO> list = null;
		AdminDAO dao = AdminDAO.getInstance();
		list = dao.agreeList();

		try {

			// 파일 생성
			workbook = Workbook.createWorkbook(file);

			// 시트 생성
			workbook.createSheet("sheet1", 0);
			sheet = workbook.getSheet(0);

			// 셀에 쓰기
			label = new Label(0, 0, "id");
			sheet.addCell(label);

			label = new Label(1, 0, "name");
			sheet.addCell(label);

			label = new Label(2, 0, "bno");
			sheet.addCell(label);

			label = new Label(3, 0, "email");
			sheet.addCell(label);

			label = new Label(4, 0, "tel");
			sheet.addCell(label);

			label = new Label(5, 0, "bfile");
			sheet.addCell(label);

			label = new Label(6, 0, "agree");
			sheet.addCell(label);
			// 데이터 삽입
			for (int i = 0; i < list.size(); i++) {
				PublisherVO vo = list.get(i);

				label = new Label(0, (i + 1), vo.getId());
				sheet.addCell(label);

				label = new Label(1, (i + 1), vo.getName());
				sheet.addCell(label);

				label = new Label(2, (i + 1), vo.getBno());
				sheet.addCell(label);

				label = new Label(3, (i + 1), vo.getEmail());
				sheet.addCell(label);

				label = new Label(4, (i + 1), vo.getTel());
				sheet.addCell(label);

				label = new Label(5, (i + 1), vo.getBfile());
				sheet.addCell(label);

				String agree = "";
				if (vo.getAgree() == 2) {
					agree = "승인";
				} else if (vo.getAgree() == 1) {
					agree = "대기";
				} else if (vo.getAgree() == 3) {
					agree = "거절";
				}

				label = new Label(6, (i + 1), agree);
				sheet.addCell(label);
			}

			workbook.write();
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("test");

	}

}
