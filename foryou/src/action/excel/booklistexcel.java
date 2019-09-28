package action.excel;

import java.io.File;
import java.util.List;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.book.BookDAO;
import model.book.BookVO;

public class booklistexcel {
	public void testexcel(String id) {		
		// �뿊���뙆�씪 媛앹껜 �깮�꽦
		WritableWorkbook workbook = null;

		// �떆�듃 媛앹껜 �깮�꽦
		WritableSheet sheet = null;

		// �� 媛앹껜 �깮�꽦
		Label label = null;

		// ���옣�븷 �뙆�씪 媛앹껜 �깮�꽦
		File file = new File("C:\\excel\\booklistexcel.xls");

		// �뀒�뒪�듃 �뜲�씠�꽣
		BookDAO dao = BookDAO.getInstance();
		String company = dao.campanysearch(id);
		List<BookVO> list = dao.my_insert_list(company);

		try {

			// �뙆�씪 �깮�꽦
			workbook = Workbook.createWorkbook(file);

			// �떆�듃 �깮�꽦
			workbook.createSheet("sheet1", 0);
			sheet = workbook.getSheet(0);
			
			// ���뿉 �벐湲�
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
		
			// �뜲�씠�꽣 �궫�엯
			for (int i = 0; i < list.size(); i++) {
				BookVO vo = list.get(i);

				label = new Label(0, (i + 1), vo.getFileName());
				sheet.addCell(label);

				label = new Label(1, (i + 1), vo.getBookName());
				sheet.addCell(label);

				label = new Label(2, (i + 1), vo.getWriter());
				sheet.addCell(label);
				
				label = new Label(3, (i + 1), vo.getCompany());
				sheet.addCell(label);

				label = new Label(4, (i + 1), vo.getIndate());
				sheet.addCell(label);
				
				label = new Label(5, (i + 1), vo.getPublished());
				sheet.addCell(label);
			
			}

			workbook.write();
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
