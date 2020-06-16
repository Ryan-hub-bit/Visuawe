package com.visuaweProject;

import com.visuaweProject.dao.UserDOMapper;
import com.visuaweProject.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */
//@EnableAutoConfiguration//将启动类作为一个可以自动配置的beans，进行自动装配，并且可以开启整个springboot的自动化配置的类
@SpringBootApplication(scanBasePackages={"com.visuaweProject"})
@RestController
@MapperScan("com.visuaweProject.dao")
public class App 
{
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String home()
    {
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO  == null)
        {
            return "no object";
        }
        else{
            return userDO.getName();
        }

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(App.class,args);
    }
}
