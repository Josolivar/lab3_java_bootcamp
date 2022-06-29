package sala_de_reuniao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sala_de_reuniao.model.Sala;

@Repository
public interface Repository_Sala extends JpaRepository<Sala, Long> {

}