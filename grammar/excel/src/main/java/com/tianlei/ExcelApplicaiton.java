package com.tianlei;

//import jxl.Sheet;
//import jxl.Workbook;

//import jxl.Workbook;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@SpringBootApplication
public class ExcelApplicaiton {

    /**
     * cell0 cell1 cell2
     * row0   --    --    --
     * row1   --    --    --
     * row2   --    --    --
     */
    public static void main(String[] args) {
        SpringApplication.run(ExcelApplicaiton.class);
    }


    @PostMapping("/excel")
    public void read(@RequestParam MultipartFile file) {

        try {


            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
            Row row = sheet.getRow(0);
            HSSFCell cell = (HSSFCell) row.getCell(0);
            // 获取内容
            String content = cell.getStringCellValue();
            int a = 10;

        } catch (Exception e) {

        }


    }

    @GetMapping
    public void write() {

    }

    @GetMapping("/create")
    public void createExcel(HttpServletResponse response) {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("mySheet");
        sheet.setDefaultColumnWidth(20);

        {
            //创建头部
            String[] heads = {"name", "age", "sex"};
            Row headRow = sheet.createRow(0);
            CellStyle headStyle = workbook.createCellStyle();

            //背景色
            headStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREEN.getIndex());
            headStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            //设置字体
            Font font = workbook.createFont();
            font.setFontName("Arial");
            font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
            headStyle.setFont(font);

            for (int i = 0; i < heads.length; i++) {

                Cell cell = headRow.createCell(i);
                cell.setCellValue(heads[i]);
                cell.setCellStyle(headStyle);

            }

        }

        {
            //设置 垂直 和 水平 位置
            HSSFCellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            // 设置内容
            String[] contents = {"田磊", "18", "男"};
            Row contentRow = sheet.createRow(1);
            for (int i = 0; i < contents.length; i++) {

                Cell cell = contentRow.createCell(i);
                cell.setCellValue(contents[i]);
                cell.setCellStyle(cellStyle);

            }

        }


        String fileName = "test.xls";

        try {


            //导出文件
//            FileOutputStream fileOutputStream = new FileOutputStream("/Users/leitian/Desktop/test.xls");
//            workbook.write(fileOutputStream);
//            workbook.close();


            //
            response.setContentType("application/octet-stream");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.flushBuffer();

            workbook.write(response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
            ;
        }


    }

}
