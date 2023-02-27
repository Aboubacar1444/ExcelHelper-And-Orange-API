package spring.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import spring.training.entity.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, Integer>, JpaSpecificationExecutor<BankEntity> {
}