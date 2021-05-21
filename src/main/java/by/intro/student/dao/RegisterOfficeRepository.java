package by.intro.student.dao;

import by.intro.student.domain.RegisterOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterOfficeRepository extends JpaRepository<RegisterOffice, Long> {
}
