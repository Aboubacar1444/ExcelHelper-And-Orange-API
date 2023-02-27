package spring.training.helper;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import spring.training.entity.BankEntity;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    // static String yes = sdf.format(yesterday);
    // public static String SHEET = "SAMA_BCB_"+ yesterday;
    public static String SHEET = "datas";
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

    public static List<BankEntity> excelTobankEntites(InputStream is) {
        DataFormatter dataFormatter = new DataFormatter();
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();
            List<BankEntity> bankEntities = new ArrayList<>();
            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                //Skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }
                Iterator<Cell> cellsinRow = currentRow.iterator();
                BankEntity bankEntity = new BankEntity();
                int cellIdx = 0;
                while (cellsinRow.hasNext()) {
                    Cell currentCell = cellsinRow.next();
                    String cellValue = dataFormatter.formatCellValue(currentCell.getRow().getCell(cellIdx));
                    switch (cellIdx) {
                        /*case 0:
                            bankEntity.setMnoid((long) currentCell.getNumericCellValue());
                            break;*/
                        case 1 -> bankEntity.setType(currentCell.getStringCellValue());
                        case 2 -> bankEntity.setIduserSama(currentCell.getNumericCellValue());
                        case 3 -> bankEntity.setPhoneUser(currentCell.getNumericCellValue());
                        case 4 -> bankEntity.setMnoid(currentCell.getNumericCellValue());
                        case 5 -> bankEntity.setBanque(currentCell.getStringCellValue());
                        case 6 -> bankEntity.setIdtranssama(currentCell.getStringCellValue());
                        case 7 -> bankEntity.setIdTransBanque(currentCell.getNumericCellValue());
                        case 8 -> bankEntity.setTransfertAt(currentCell.getStringCellValue());
                        case 9 -> bankEntity.setServiceName(currentCell.getStringCellValue());
                        case 10 -> bankEntity.setEntryType(currentCell.getStringCellValue());
                        case 11 -> bankEntity.setMontant(currentCell.getNumericCellValue());
                        case 12 -> bankEntity.setPostBalance(currentCell.getNumericCellValue());
                        case 13 -> bankEntity.setFrais(currentCell.getNumericCellValue());
                        case 14 -> bankEntity.setImei(currentCell.getNumericCellValue());
                        case 15 -> bankEntity.setSaveAt(currentCell.getLocalDateTimeCellValue());
                        case 16 -> bankEntity.setErreur(currentCell.getStringCellValue());
                        case 17 -> bankEntity.setStatus(currentCell.getNumericCellValue());
                        case 18 -> bankEntity.setMVersClientSama(cellValue);
                        case 19 -> bankEntity.setAVersClient(cellValue);
                        default -> {
                        }
                    }
                    cellIdx++;
                }
                bankEntities.add(bankEntity);
            }
            //workbook.close();
            return bankEntities;
        } catch (IOException e) {
            throw new RuntimeException("Echec de conversion de fichier: " + e.getMessage() + ' ' + e.getCause());
        }
    }
}
