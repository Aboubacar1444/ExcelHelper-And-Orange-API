package spring.training.service.impl;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.training.entity.Student;
import spring.training.helper.ExcelHelperStudent;
import spring.training.repository.StudentRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public void save (MultipartFile file){
        if (!file.isEmpty()) {
            List<Student> students = new ArrayList<>();
            Integer rowIndex = 0;
                try {
                    Workbook workBook = StreamingReader.builder()
                            .bufferSize((int) file.getSize())
                            .rowCacheSize(200)
                            .open(file.getInputStream());

                    Sheet sheet = workBook.getSheetAt(0);
                    // looping through each row

                    for (Row r : sheet){
                        if (rowIndex == 0){
                            rowIndex++;
                            continue;
                        }
                        Student student = new Student();

                        for (Cell c : r){
                            switch (c.getColumnIndex()){
                                case 1 -> student.setMatricule(c.getStringCellValue());
                                case 3 -> student.setLycee(c.getStringCellValue());
                                case 4 -> student.setNom(c.getStringCellValue());
                                case 5 -> student.setPrenom(c.getStringCellValue());
                                default -> {}
                            }
                           // System.out.println(student.getMatricule()+" "+student.getLycee()+" "+student.getNom()+" "+student.getPrenom());
                        }
                        studentRepository.save(student);

                        students.add(student);
                    }


                } catch (IOException e) {
                    e.getStackTrace();
                }


           // if (!students.isEmpty()) {
                // save to database
              //  studentRepository.saveAll(students);
           // }
        }

    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    private Object getValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((int) cell.getNumericCellValue());
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case ERROR:
                return cell.getErrorCellValue();
            case FORMULA:
                return cell.getCellFormula();
            case BLANK:
                return null;
            case _NONE:
                return null;
            default:
                break;
        }
        return null;
    }

    public static int getNumberOfNonEmptyCells(Sheet sheet, int columnIndex) {
        int numOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row != null) {
                Cell cell = row.getCell(columnIndex);
                    numOfNonEmptyCells++;
            }
        }
        return numOfNonEmptyCells;
    }
}
