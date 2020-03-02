package com.practice.file_management_sys.controller;

import com.practice.file_management_sys.domain.JsonData;
import com.practice.file_management_sys.domain.User;
import com.practice.file_management_sys.service.UserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户管理", produces = "application/json")
public class PersonalInformationController {

    @Resource
    private UserService userService;

    @PutMapping("/update")
    @ApiOperation(value = "更新用户信息", notes = "更新用户个人信息")
    @ApiImplicitParam(name = "user", value = "用户对象", required = true, paramType = "body",dataType = "User 对象")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = User.class),
            @ApiResponse(code = 500, message = "服务器内部错误", response = JsonData.class)
    })
    public JsonData updateInfo(@RequestBody(required = true) User user){
        return userService.updatePersonalInfo(user);
    }

}
