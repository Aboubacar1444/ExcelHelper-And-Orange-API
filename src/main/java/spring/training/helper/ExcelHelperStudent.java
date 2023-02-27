package spring.training.helper;

import com.monitorjbl.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import spring.training.entity.Student;
import spring.training.repository.StudentRepository;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelHelperStudent {
    @Autowired
    private static StudentRepository studentRepository;
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    // static String yes = sdf.format(yesterday);
    // public static String SHEET = "SAMA_BCB_"+ yesterday;
    public static Integer SHEET = 0;
    static String[] HEADERs = {
            "Mnoid", "BankName", "TransactionId", "ReferenceNumber", "TransferOn",
            "ServiceName", "EntryType", "TransferValue", "PostBalance",
            "IssuerMsisd", "ReceiverMsisd", "TransactionState"
    };
    static LocalDate today = LocalDate.now();
    static LocalDate yesterday = today.minusDays(1);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static boolean hasExcelFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType()) || Objects.equals(file.getContentType(), "text/csv");
    }

    public static List<Student> excelToStudent(InputStream is) throws IOException {


        DataFormatter dataFormatter = new DataFormatter();
        Workbook workbook = StreamingReader.builder()
                    // number of rows to keep in memory (defaults to 10)
                .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
                .open(is);

        Sheet sheet = workbook.getSheetAt(SHEET);
        Iterator<Row> rows = sheet.iterator();
        List<Student> students = new ArrayList<>();

        int rowNumber = 0;
        for (Row r : sheet) {
            Student student = new Student();
            for (Cell c : r) {

                switch (c.getRowIndex()) {

                    case 1 -> student.setMatricule(c.getStringCellValue());
                    /*case 3 -> student.setLycee(c.getStringCellValue());
                    case 4 -> student.setNom(c.getStringCellValue());
                    case 5 -> student.setPrenom(c.getStringCellValue());

                    case 2 -> student.setNumAttestation(c.getStringCellValue());
                    case 6 -> student.setSexe(c.getStringCellValue());
                    case 7 -> student.setDateNaissance(c.getStringCellValue());
                    case 8 -> student.setDateNaissanceCenou(c.getStringCellValue());
                    case 9 -> student.setLieuNaissance(c.getStringCellValue());
                    case 10 -> student.setPays_naiss(c.getStringCellValue());
                    case 11 -> student.setNationalite(c.getStringCellValue());
                    case 12 -> student.setPhone(c.getStringCellValue());
                    case 13 -> student.setNompere(c.getStringCellValue());
                    case 14 -> student.setPrenompere(c.getStringCellValue());
                    case 15 -> student.setNommere(c.getStringCellValue());
                    case 16 -> student.setPrenommere(c.getStringCellValue());
                    case 17 -> student.setMatriculeDEF(c.getStringCellValue());
                    case 18 -> student.setAnneeBac(c.getStringCellValue());
                    case 19 -> student.setSerie(c.getStringCellValue());
                    case 20 -> student.setNumPlace(c.getStringCellValue());
                    case 21 -> student.setStatut(c.getStringCellValue());
                    case 22 -> student.setCentreBac(c.getStringCellValue());
                    case 23 -> student.setAe(c.getStringCellValue());
                    case 24 -> student.setAdresseparent(c.getStringCellValue());
                    case 25 -> student.setPhone1(c.getStringCellValue());
                    case 26 -> student.setEtablissement(c.getStringCellValue());
                    case 27 -> student.setIdBanq(c.getStringCellValue());
                    case 28 -> student.setScolarite(c.getStringCellValue());
                    case 30 -> student.setBacMention(c.getStringCellValue());
                    case 31 -> student.setMoyenneEcrit(c.getStringCellValue());
                    case 32 -> student.setMoyenneAnuelle(c.getStringCellValue());
                    case 33 -> student.setMoyenneAdmission(c.getStringCellValue());
                    case 34 -> student.setAnneeNaissance(c.getStringCellValue());
                    case 35 -> student.setAnneeDEF(c.getStringCellValue());
                    case 36 -> student.setScolariteNew(c.getStringCellValue());
                    case 37 -> student.setScolariteNew2(c.getStringCellValue());
                    case 38 -> student.setAge(c.getStringCellValue());
                    case 39 -> student.setInscriptibiliteAge(c.getStringCellValue());
                    case 40 -> student.setInscriptibiliteNationale(c.getStringCellValue());
                    case 41 -> student.setInscriptibiliteGenerale(c.getStringCellValue());*/
/**/
                    default -> {
                    }
                }
            }

            //System.out.println(student.getMatricule()+"  "+student.getLycee()+" "+student.getNom()+" "+student.getPrenom()  );
            students.add(student);



        }

        workbook.close();
        return students;
    }
}
