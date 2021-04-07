import java.util.List;

import po.UserEntity;
import util.ExcelUtils;

public class Test {

	public static void main(String[] args) {
		String path = "C:/Users/zhn17/Desktop/test.xls";
		
		List<UserEntity> list = ExcelUtils.importExcel(path, 1, 2, UserEntity.class);
		System.out.println(list.get(0));
	}
}
