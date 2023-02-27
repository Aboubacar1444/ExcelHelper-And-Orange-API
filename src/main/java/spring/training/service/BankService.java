package spring.training.service;

import org.springframework.web.multipart.MultipartFile;
import spring.training.entity.BankEntity;

import java.util.List;

public interface BankService {

    public void save (MultipartFile file);

    public List<BankEntity> getAll();
}
