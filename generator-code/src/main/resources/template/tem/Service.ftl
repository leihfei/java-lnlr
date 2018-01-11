package ${pknService};


import com.datababys.common.ngdto.NgData;
import com.datababys.common.ngdto.NgPager;
import com.datababys.dto.main.Organization;
import com.datababys.dto.main.User;
import com.datababys.dto.${moduleName}.entity.${className};
import org.springframework.data.domain.Sort;

import java.util.List;

/**
* Created by ${author} on ${.now}.
* 描述${moduleName} 服务接口
* @author ${author}
*/

public interface ${className}Service {
    /**
    * 按条件查询 默认等于，字符串默认 模糊
    * @param ${className?uncap_first} 查询条件
    * @return 返回 ${className} 实体集合
    */
    List<${className}> list(${className} ${className?uncap_first}, Organization organization);

    /**
    * 按条件查询 默认等于，字符串默认 模糊
    * 带有 排序
    * @param ${className?uncap_first} 查询条件
    * @param sort  排序
    * @return 返回 ${className} 实体集合
    */
    List<${className}> list(${className} ${className?uncap_first}, Sort sort,Organization organization);

    /**
    * 按自定义条件查询
    * 带有 排序
    * @param ngPager 查询条件
    * @return 返回 ${className} 实体集合
    */
    List<${className}> list(NgPager ngPager);

    /**
    * 按自定义条件查询
    * 带有 排序
    * @param ngPage 查询条件
    * @return 返回 ${className} 实体分页集合
    */
    NgData<${className}> page(NgPager ngPage);

    /**
    * 添加 实体
    * @param ${className?uncap_first}
    * @return
    */
    ${className} create(${className} ${className?uncap_first}, User user);

    /**
    * 更新 实体
    * @param ${className?uncap_first}
    * @return
    */
    ${className} update(${className} ${className?uncap_first});

    /**
    * 删除
    * @param id
    */
    void delete(String id);

    /**
    * 根据 id 查询
    * @param id
    * @return
    */
    ${className} view(String id);

    /**
    * 根据id删除所有对象
    * @param ids
    */
    void deleteAll(List<String> ids);

    /**
    * 查询单个对象
    * @param ${className?uncap_first}
    * @return
    */
    ${className} findOne(${className} ${className?uncap_first});

    /**
    * 查询所有
    * @param ${className?uncap_first}
    * @return
    */
    List<${className}> findAll(${className} ${className?uncap_first});

}