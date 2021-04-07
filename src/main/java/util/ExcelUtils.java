package util;

import java.io.File;
import java.util.List;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

/**
 * excel工具类
 *
 * @author Mark sunlightcs@gmail.com
 * @since 2018-03-24
 */
public class ExcelUtils {

	/*    *//**
			 * Excel导出
			 *
			 * @param response  response
			 * @param fileName  文件名
			 * @param list      数据List
			 * @param pojoClass 对象Class
			 */
	/*
	 * public static void exportExcel(HttpServletResponse response, String fileName,
	 * Collection<?> list, Class<?> pojoClass) throws IOException { Workbook
	 * workbook = ExcelExportUtil.exportExcel(new ExportParams(), pojoClass, list);
	 * response.setCharacterEncoding("UTF-8"); response.setHeader("content-Type",
	 * "application/vnd.ms-excel"); response.setHeader("Content-Disposition",
	 * "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
	 * ServletOutputStream out = response.getOutputStream(); workbook.write(out);
	 * out.flush(); }
	 * 
	 *//**
		 * Excel导出，先sourceList转换成List<targetClass>，再导出
		 *
		 * @param response    response
		 * @param fileName    文件名
		 * @param sourceList  原数据List
		 * @param targetClass 目标对象Class
		 *//*
			 * public static void exportExcelToTarget(HttpServletResponse response, String
			 * fileName, Collection<?> sourceList, Class<?> targetClass) throws Exception {
			 * List targetList = new ArrayList<>(sourceList.size()); for (Object source :
			 * sourceList) { Object target = targetClass.newInstance();
			 * BeanUtils.copyProperties(source, target); targetList.add(target); }
			 * 
			 * exportExcel(response, fileName, targetList, targetClass); }
			 */

	/**
	 * Excel批量导入
	 *
	 * @param filePath   文件路径
	 * @param titleRows  标题行数
	 * @param headerRows 表头行数
	 * @param pojoClass  导入实体类
	 * @param <T>
	 * @return
	 * @author cgm
	 * @date 2018-12-04 14:05:18
	 */
	public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> pojoClass) {
		/*
		 * if (StringUtils.isBlank(filePath)) { return null; }
		 */
		ImportParams params = new ImportParams();
		params.setTitleRows(titleRows);
		params.setHeadRows(headerRows);
		List<T> list = null;
		try {
			list = ExcelImportUtil.importExcel(new File(filePath), pojoClass, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Excel批量导入
	 *
	 * @param file       文件
	 * @param titleRows  标题行号
	 * @param headerRows 表头行号
	 * @param pojoClass  excel 实体类
	 * @param <T>
	 * @return
	 * @author cgm
	 * @date 2018-12-04 14:05:18
	 */
	/*
	 * public static <T> List<T> importExcel(MultipartFile file, Integer titleRows,
	 * Integer headerRows, Class<T> pojoClass) { if (file == null) { return null; }
	 * ImportParams params = new ImportParams(); params.setTitleRows(titleRows);
	 * params.setHeadRows(headerRows); List<T> list = null; try { list =
	 * ExcelImportUtil.importExcel(file.getInputStream(), pojoClass, params); }
	 * catch (Exception e) { throw new GlobalException(ResultStatus.error_excel); }
	 * return list; }
	 */

}
