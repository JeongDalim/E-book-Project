package action.excel;

import java.io.File;
import java.util.List;


import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import model.sales.SalesVO;

public class psaleslistexcel {
	public void testexcel(List<SalesVO> list,int year,int month, String company) {		
		// �뿊���뙆�씪 媛앹껜 �깮�꽦
		WritableWorkbook workbook = null;

		// �떆�듃 媛앹껜 �깮�꽦
		WritableSheet sheet = null;

		// �� 媛앹껜 �깮�꽦
		Label label = null;

		// ���옣�븷 �뙆�씪 媛앹껜 �깮�꽦
		File file = new File("C:\\excel\\"+company+"saleslistexcel.xls");

		// �뀒�뒪�듃 �뜲�씠�꽣

		try {

			// �뙆�씪 �깮�꽦
			workbook = Workbook.createWorkbook(file);

			// �떆�듃 �깮�꽦
			workbook.createSheet(year+"-"+month, 0);
			sheet = workbook.getSheet(0);
			
			// ���뿉 �벐湲�
			label = new Label(0, 0, "id");
			sheet.addCell(label);

			label = new Label(1, 0, "name");
			sheet.addCell(label);
		
			// �뜲�씠�꽣 �궫�엯
			for (int i = 0; i < list.size(); i++) {
				SalesVO vo = list.get(i);

				label = new Label(0, (i + 1), vo.getName());
				sheet.addCell(label);

				label = new Label(1, (i + 1), vo.getSales()+"");
				sheet.addCell(label);
			
			}

			workbook.write();
			workbook.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
