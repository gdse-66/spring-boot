package lk.ijse.gdse66.hellospringboot.repository;

import lk.ijse.gdse66.hellospringboot.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity,String> {
}
