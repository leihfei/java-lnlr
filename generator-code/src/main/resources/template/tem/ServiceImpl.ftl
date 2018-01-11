package ${pknServiceImpl};

import com.datababys.${moduleName}.service.${className}Service;
import com.datababys.common.constants.Constants;
import com.datababys.common.ngdto.NgData;
import com.datababys.common.ngdto.NgPager;
import com.datababys.common.ngdto.NgTempUtils;
import com.datababys.common.ngdto.SearchFilterUtils;
import com.datababys.common.utils.DynamicSpecifications;
import com.datababys.dto.${moduleName}.dao.${className}DAO;
import com.datababys.dto.${moduleName}.entity.${className};
import com.datababys.dto.main.Organization;
import com.datababys.dto.main.User;
import com.datababys.utils.OrgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.util.List;

/**
* Created by ${author} on ${.now}.
* 描述${moduleName} 服务接口
* @author ${author}
*/

@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}DAO ${className?uncap_first}DAO;

    /**
    * 按条件查询 默认等于，字符串默认 模糊
    * @param ${className?uncap_first} 查询条件
    * @return 返回 ${className} 实体集合
    */
    @Override
    public List<${className}> list(${className} ${className?uncap_first}, Organization organization) {
        return list(${className?uncap_first}, null, organization);
    }

    /**
    * 按条件查询 默认等于，字符串默认 模糊
    * 带有 排序
    * @param ${className?uncap_first} 查询条件
    * @param sort  排序
    * @return 返回 ${className} 实体集合
    */
    @Override
    public List<${className}> list(${className} ${className?uncap_first}, Sort sort, Organization organization) {
        return ${className?uncap_first}DAO.findAll(DynamicSpecifications.bySearchFilter(${className}.class,
            SearchFilterUtils.build(${className?uncap_first})), sort);
    }


    /**
    * 按自定义条件查询
    * 带有 排序
    * @param ngPager 查询条件
    * @return 返回 ${className} 实体集合
    */
    @Override
    public List<${className}> list(NgPager ngPager) {
        return ${className?uncap_first}DAO.findAll(DynamicSpecifications.bySearchFilter(${className}.class,
        NgTempUtils.buildWhereClause(ngPager)), NgTempUtils.buildSort(ngPager));
    }


    /**
    * 按自定义条件查询
    * 带有 排序
    * @param ngPage 查询条件
    * @return 返回 ${className} 实体分页集合
    */
    @Override
    public NgData<${className}> page(NgPager ngPage) {
        return new NgData<>(
            ${className?uncap_first}DAO.findAll(
            DynamicSpecifications.bySearchFilter(${className}.class, NgTempUtils.buildWhereClause(ngPage)),
            NgTempUtils.buildPageRequest(ngPage)),
            ngPage);
     }


    /**
    * 添加 实体
    * @param ${className?uncap_first}
    * @return 返回新建的对象
    */
    @Override
    public ${className} create(${className} ${className?uncap_first}, User user) {
        Assert.notNull(${className?uncap_first}, Constants.ENTITY_MUST_NOT_BE_NULL);
        Assert.isNull(${className?uncap_first}.getId(), Constants.ID_MUST_BE_NULL);
        ${className?uncap_first}.setGmtCreate(LocalDateTime.now());
        ${className?uncap_first}.setGmtModified(LocalDateTime.now());
        return ${className?uncap_first}DAO.save(${className?uncap_first});
    }

    /**
    * 更新 实体
    * @param ${className?uncap_first}
    * @return 更新后的对象
    */
    @Override
    public ${className} update(${className} ${className?uncap_first}) {
        Assert.notNull(${className?uncap_first}, Constants.ENTITY_MUST_NOT_BE_NULL);
        Assert.notNull(${className?uncap_first}.getId(), Constants.ID_MUST_NOT_BE_NULL);
        ${className?uncap_first}.setGmtModified(LocalDateTime.now());
        return ${className?uncap_first}DAO.save(${className?uncap_first});
    }


    /**
    * 删除单个对象
    * @param id
    */
    @Override
    public void delete(String id) {
        Assert.notNull(id, Constants.ID_MUST_NOT_BE_NULL);
        ${className?uncap_first}DAO.deleteById(id);
    }

    /**
    * 根据 id 查询 ，未找到返回空
    * @param id
    * @return
    */
    @Override
    public ${className} view(String id) {
        Assert.notNull(id, Constants.ID_MUST_NOT_BE_NULL);
        return ${className?uncap_first}DAO.findById(id).orElse(null);
    }

    /**
    * 根据id删除所有对象
    * @param ids
    */
    @Override
    public void deleteAll(List<String> ids) {
         List<${className}> all = ${className?uncap_first}DAO.findAllById(ids);
        ${className?uncap_first}DAO.deleteAll(all);
    }


    /**
    * 查询单个对象
    * @param ${className?uncap_first}
    * @return
    */
    @Override
    public ${className} findOne(${className} ${className?uncap_first}) {
        return ${className?uncap_first}DAO.findOne(DynamicSpecifications.bySearchFilter(${className}.class,
        SearchFilterUtils.build(${className?uncap_first}))).orElse(null);
    }

    /**
    * 查询所有
    * @param ${className?uncap_first}
    * @return
    */
    @Override
    public List<${className}> findAll(${className} ${className?uncap_first}) {
        return ${className?uncap_first}DAO.findAll(DynamicSpecifications.bySearchFilter(${className}.class, SearchFilterUtils.build(${className?uncap_first})));
     }

}