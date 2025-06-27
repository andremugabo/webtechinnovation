package rw.ac.auca.ecommerce.core.customer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import rw.ac.auca.ecommerce.core.customer.model.Customer;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {
    @Query("SELECT c FROM Customer c WHERE c.id =: id AND c.active =: active")
    Optional<Customer> findCustomerByIdWithNamedQuery(@Param("id") UUID id, @Param("active") Boolean active);
    Optional<Customer> findByIdAndActive(UUID id, Boolean active);
    Optional<Customer> findByEmailAndActive(String email, Boolean active);
    List<Customer> findAllByActive(Boolean active);
}
