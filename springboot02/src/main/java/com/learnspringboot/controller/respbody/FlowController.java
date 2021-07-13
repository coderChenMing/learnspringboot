package com.learnspringboot.controller.respbody;/*
 * Project: springboot03
 * File Created at 2021-07-07 22:15:22:15
 * @Type FlowController.java
 * @Desc
 * @author <a href="mailto:chenming1@eversec.cn">chenming</a>
 * @date 2021/7/7 0007 22:15
 * @version 1.0.0
 */

import com.learnspringboot.check.anno.IntegerCheck;
import com.learnspringboot.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("/flow")
@Validated
public class FlowController {

    @RequestMapping("/execute")
    @ResponseBody
    public Response flow(@NotNull  @IntegerCheck(value = {2,3}) @RequestBody Integer nodeId) {

        Response response=new Response(nodeId);
        return response;
    }
}
