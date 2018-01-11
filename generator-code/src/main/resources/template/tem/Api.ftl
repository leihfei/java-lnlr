package com.datababys.api;

import com.datababys.common.annotation.CurrentUser;
import com.datababys.common.dto.Response;
import com.datababys.common.ngdto.NgData;
import com.datababys.common.ngdto.NgPager;
import com.datababys.dto.main.User;
import com.datababys.dto.${moduleName}.entity.${className};
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
* Created by ${author} on ${.now}.
* 描述${tableName} api
* @author ${author}
*/

@RequestMapping("/${moduleName}")
public interface ${className}ApiServer {

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    Response list(@RequestBody ${className} ${className?uncap_first}, @CurrentUser User user);

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    Response search(@RequestBody NgPager ngPage, @CurrentUser User user);

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    NgData<${className}> page(@RequestBody NgPager ngPage, @CurrentUser User user);

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Response create(@RequestBody ${className} ${className?uncap_first}, @CurrentUser User user);

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    Response update(@RequestBody ${className} ${className?uncap_first}, @CurrentUser User user);

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    Response delete(@PathVariable("id") String id);

    @RequestMapping(value = "/view/{id}", method = RequestMethod.POST)
    Response view(@PathVariable("id") String id, @CurrentUser User user);

    @RequestMapping(value = "/deleteAll", method = RequestMethod.POST)
    Response deleteAll(@RequestBody List<String> ids);
}

