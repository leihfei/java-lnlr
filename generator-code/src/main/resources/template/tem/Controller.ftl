package ${pknController};

import com.datababys.api.${className}ApiServer;
import com.datababys.${moduleName}.service.${className}Service;
import com.datababys.common.annotation.CurrentUser;
import com.datababys.common.dto.ObjectResponse;
import com.datababys.common.dto.Response;
import com.datababys.common.dto.SuccessResponse;
import com.datababys.common.ngdto.NgData;
import com.datababys.common.ngdto.NgPager;
import com.datababys.dto.${moduleName}.entity.${className};
import com.datababys.dto.main.User;
import com.datababys.utils.OrgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
* Created by ${author} on ${.now}.
* 描述${moduleName} service api
* @author ${author}
*/

@RestController
public class ${className}Controller implements ${className}ApiServer {

    @Autowired
    private ${className}Service ${className?uncap_first}Service;

    @Override
    public Response list(@RequestBody ${className} ${className?uncap_first},@CurrentUser User user) {
        //${className?uncap_first}.setOrgId(user.getOrganization().getId());
        return new ObjectResponse<>(${className?uncap_first}Service.list(${className?uncap_first},user.getOrganization()));
    }

    @Override
    public Response search(@RequestBody NgPager ngPage,@CurrentUser User user) {
        //ngPage.getFilters().put("orgId", OrgUtils.parse2NgFilter(user.getOrganization()));
        return new ObjectResponse<>(${className?uncap_first}Service.list(ngPage));
    }

    @Override
    public NgData<${className}> page(@RequestBody NgPager ngPage,@CurrentUser User user) {
        //ngPage.getFilters().put("orgId", OrgUtils.parse2NgFilter(user.getOrganization()));
        return ${className?uncap_first}Service.page(ngPage);
    }

    @Override
    public Response create(@RequestBody ${className} ${className?uncap_first}, @CurrentUser User user) {
        return new ObjectResponse<>(${className?uncap_first}Service.create(${className?uncap_first},user));
    }

    @Override
    public Response update(@RequestBody ${className} ${className?uncap_first},@CurrentUser User user) {
        return new ObjectResponse<>(${className?uncap_first}Service.update(${className?uncap_first}));
    }


    @Override
    public Response view(@PathVariable("id") String id,@CurrentUser User user) {
        return new ObjectResponse<>(${className?uncap_first}Service.view(id));
    }


    @Override
    public Response delete(@PathVariable(name = "id") String id) {
        ${className?uncap_first}Service.delete(id);
        return new SuccessResponse();
    }

    @Override
    public Response deleteAll(@RequestBody List<${tableIdType}> ids) {
        ${className?uncap_first}Service.deleteAll(ids);
        return new SuccessResponse();
    }


}