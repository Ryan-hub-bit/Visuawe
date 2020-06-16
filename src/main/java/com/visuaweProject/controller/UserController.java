package com.visuaweProject.controller;

import com.visuaweProject.controller.viewObject.UserVO;
import com.visuaweProject.error.BusinessException;
import com.visuaweProject.error.CommonError;
import com.visuaweProject.error.EmBusinessError;
import com.visuaweProject.response.CommonReturnType;
import com.visuaweProject.service.UserService;
import com.visuaweProject.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller("user")
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    public UserService userService;


    @RequestMapping("/get")
    @ResponseBody
    public CommonReturnType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        // 调取service 服务获取对应的id的用户对象被返回给前端
        UserModel userModel = userService.getUserById(id);

        // if the user doesn't exist throw a new business exception with EmBusinessError
        if(userModel == null)
        {
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);

        }

        UserVO userVO = convertFromModel(userModel);
        return CommonReturnType.create(userVO);
    }
    public UserVO convertFromModel(UserModel userModel)
    {
        UserVO userVO = new UserVO();
        if(userModel == null)
        {
            return null;
        }
        BeanUtils.copyProperties(userModel,userVO);
        return userVO;

    }


}
