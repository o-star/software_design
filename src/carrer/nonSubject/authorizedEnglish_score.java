package carrer.nonSubject;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Data.Data_nonSubject;


import java.io.*;

public class authorizedEnglish_score extends nonSubjectActivity{

    private boolean authorizedEnglish_check = false;
    private int examScore;
    private double essential_score;

    Data_nonSubject data= Data_nonSubject.getInstance();


    authorizedEnglish_score(){
        this.scan_nonSubjectActivity();
    }

    @Override
    public void scan_nonSubjectActivity(){ // 액셀 파일에서 정보를 가져오는 메소드
        this.examScore=data.getExamScore();
    }

    @Override
    public void change_nonSubjectActivity(int count){ // 액셀 파일에서 정보를 수정하는 메소드

        Data_nonSubject data = Data_nonSubject.getInstance();
        int changed_score = count;
        try {
            FileInputStream stu_file = new FileInputStream("학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(stu_file);
            XSSFSheet sheet_workbook = workbook.getSheetAt(0);     // sheet index

            boolean condition = true;
            int i = 1;

            while (condition) { // ##### iterator로 수정할 필요..
                XSSFRow row_workbook = sheet_workbook.getRow(i);             // row index
                XSSFCell cell_workbook = row_workbook.getCell(1);            // cell index
                if ((cell_workbook.getStringCellValue() + "").equals(user.getStudent_code()) == true) {
                    XSSFSheet sheet_student = workbook.getSheetAt(i);     // sheet index
                    XSSFRow row_student = sheet_student.getRow(1);             // row index
                    XSSFCell cell_student = row_student.getCell(10);            // cell index
                    cell_student.setCellValue(Integer.toString(changed_score)); // 수정된 상담횟수를 문자열로 다시 입력
                    examScore = changed_score;

                    try {
                        FileOutputStream fileoutputstream = new FileOutputStream("학생경력정보.xlsx");
                        workbook.write(fileoutputstream);
                        fileoutputstream.close();
                        System.out.println("엑셀파일생성성공");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("엑셀파일생성실패");
                    }
                    condition = false;
                }
                i++; // #### 마찬가지로 수정해야함
            }
            data.read_alldata();
            stu_file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean check_career(){ // 경력 조건 인정
        essential_score=graduation.getEnglish_grade();
        if(essential_score <= examScore) // essential_score 는 인트형으로 바뀔예정
        {
            authorizedEnglish_check = true;
        }

        return authorizedEnglish_check;
    }
}