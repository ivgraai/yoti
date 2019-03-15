package hu.ivgraai.yoti.dao;

import hu.ivgraai.yoti.model.Payload;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Gergo Ivan
 */
public interface PayloadRepository extends JpaRepository<Payload, Integer>{

    // empty class

}
