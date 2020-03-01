package com.exmaple.Demo.controller;

import com.exmaple.Demo.Provide.GitHubProvide;
import com.exmaple.Demo.dto.AccessTokenDTO;
//import org.graalvm.compiler.nodes.memory.Access;
import com.exmaple.Demo.dto.GitHubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired  //自动将IOC容器中的对象填充进去
    private GitHubProvide gitHubProvide;


    @Value("${github.Redirect_uri}")
    private  String uri ;
    @Value("${github.Client_secret}")
    private  String secret ;
    @Value("${github.Client_id}")
    private  String id ;

    @GetMapping("/callback")
    public String callback(@RequestParam (name = "code") String code ,  //@RequestParam  接收参数
                            @RequestParam (name = "state") String state ){


        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);                                              //填写五个信息去通过AccessTokenAPI获取AccessToken
        accessTokenDTO.setState(state);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setClient_id(id);
        accessTokenDTO.setClient_secret(secret);
        String accessToken = gitHubProvide.getAccessToken(accessTokenDTO);  //post方式获取token
        GitHubUser user = gitHubProvide.getuser(accessToken);  //get方式获取个人信息
        System.out.println(user.getName());
        System.out.println("asas");
        return "index";
    }
}
