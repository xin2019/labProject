package com.yangtze.laboratory.oil.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

//接收第一列数据值
public class ReadXLSX{

    public static Double[]  readXlsx(String filename) {
        Double[] res=null;
        int index=0;
        String temp=null;
        try {
            //创建工作簿对象
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(filename));
            //获取工作簿下sheet的个数
            int sheetNum = xssfWorkbook.getNumberOfSheets();
            System.out.println("该excel文件中总共有："+sheetNum+"个sheet");
            //遍历工作簿中的所有数据
            for(int i = 0;i<sheetNum;i++) {
                //读取第i个工作表
                System.out.println("读取第"+(i+1)+"个sheet");
                XSSFSheet sheet = xssfWorkbook.getSheetAt(i);
                //获取最后一行的num，即总行数。此处从0开始
                int maxRow = sheet.getLastRowNum();
                System.out.println("总行数为=》"+maxRow);
                res=new Double[maxRow];
                for (int row = 1; row <=maxRow; row++) {//第一行为列名，从下标1开始
                    //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
                    int maxRol = sheet.getRow(row).getLastCellNum();
                    temp=""+sheet.getRow(row).getCell(0);
                    res[index++]= Double.parseDouble(temp);
//                    System.out.println("--------第" + row + "行的数据如下--------");
//                    for (int rol = 0; rol < maxRol; rol++){
//                        System.out.print(sheet.getRow(row).getCell(rol) + "  ");
//                    }
//                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    return res;
    }

}

