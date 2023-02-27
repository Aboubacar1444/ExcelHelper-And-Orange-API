package spring.training.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.training.entity.BankEntity;
import spring.training.helper.ExcelHelper;
import spring.training.repository.BankRepository;
import spring.training.service.BankService;

import java.io.IOException;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

   
    @Override
    public void save(MultipartFile file) {

        try {
            List<BankEntity> bankEntities = ExcelHelper.excelTobankEntites(file.getInputStream());
            bankRepository.saveAll(bankEntities);

        }catch (IOException e) {
            throw new RuntimeException("Echec d'enregistrement: " + e.getMessage());
        }
    }

    @Override
    public List<BankEntity> getAll() {
      return bankRepository.findAll();
    }
}
