package ${pknEntity};


<#if hasDate == true>
import java.util.Date;
</#if>
<#if hasDateTime == true>
import java.time.LocalDateTime;
import com.alibaba.fastjson.annotation.JSONField;
</#if>
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Id;
import javax.persistence.Table;

/**
* Created by ${author} on ${.now!}.
* 描述${tableName}实体类
* @author ${author}
*/

@Entity
@Table(name="${tableName}")
public class ${className} implements Serializable {

    <#list columns as column>
    /**
    * ${column.comment}
    */
    @Column(name = "${column.name}",<#if column.nullable == false>nullable = false, </#if>length = ${column.size})
    <#if column.name == 'gmt_create' || column.name = 'gmt_modified'>
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    </#if>
    <#if column.name="id">
    @Id
    @GenericGenerator(name = "systemUUID", strategy = "uuid")
    @GeneratedValue(generator = "systemUUID")
    </#if>
    private ${column.javaType} ${column.fieldName};
    </#list>

    <#list columns as column>

    /**
    * @param ${column.fieldName} the ${column.fieldName} to set
    */
    public void ${column.setMethod}(${column.javaType} ${column.fieldName}){
    this.${column.fieldName} = ${column.fieldName};
    }

    /**
    * @return the ${column.fieldName}
    */
    public ${column.javaType} ${column.getMethod}(){
    return this.${column.fieldName};
    }
    </#list>
}
