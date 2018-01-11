package ${pknDAO};

import com.datababys.dto.${moduleName}.entity.${className};
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* Created by ${author} on ${.now}
*/

public interface ${className}DAO extends JpaRepository<${className}, ${tableIdType}>, JpaSpecificationExecutor<${className}> {

}