package com.vstaryw.web.controller.user;

import com.vstaryw.web.common.result.JsonResult;
import com.vstaryw.web.controller.BaseController;
import com.vstaryw.web.entity.User;
import com.vstaryw.web.service.db.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;


    @RequestMapping("{userId}")
    public JsonResult getUser(@PathVariable("userId") Integer userId){
        User user = userService.selectById(userId);
        return renderSuccess(user);
    }

}
