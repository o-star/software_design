package student;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class Student { // singleTorn

    private static Student student;

    private String track;
    private String student_code;
    private String pw;

    public Student() {
        this.track = "";
        this.student_code = "2017091283";
        this.pw = "981230";
        setTrack();
    }

    public static Student getInstance() {
        if (student == null)
            student = new Student();
        return student;
    }

    public void getData() { // 학생의 name에 맞게 액셀파일에서 정보를 불러오는 메소드

    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        Student.student = student;
    }

    public String getTrack() {
        return this.track;
    }

    public void setTrack() {

        try {
            FileInputStream file = new FileInputStream("학생경력정보.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheetAt(0);     // sheet index
            int rows = sheet.getPhysicalNumberOfRows(); // 해당 시트의 행의 개수
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                XSSFRow row = sheet.getRow(rowIndex); // 각 행을 읽어온다
                if (row != null) {
                    XSSFCell cell = row.getCell(1);//학번 비교하기
                    String value = cell.getStringCellValue() + "";
                   // System.out.println(value);
                    if (value.equals(student_code)) {
                        XSSFCell num_cell = row.getCell(0);//몇번째 시트인지 찾기
                        String work_value = num_cell.getStringCellValue() + "";
                        XSSFSheet work_sheet = workbook.getSheetAt(Integer.parseInt(work_value));//시트 도착
                        XSSFRow work_row = work_sheet.getRow(1);             // row index
                        XSSFCell work_cell = work_row.getCell(0);
                        track = work_cell.getStringCellValue() + "";
                        break;
                    }
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }
}
