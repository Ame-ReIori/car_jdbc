package database.yygq.demo;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class GreetingController {
    private static User_login UserList;

    public static User_login getUserList() {
        return UserList;
    }
    public void setUserList(User_login user_login){
        this.UserList = user_login;
    }

    @RequestMapping(value = "/index")
    public String sayHello(){
        return "index";
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody User_login user) {
        System.out.println(user.getIgnored_thing());
       // System.out.println(user.);
        return "0";
    }

    @RequestMapping(value = "/test1",produces = "application/json; charset=utf-8")
    @ResponseBody
    public User_login return_info() {
        User_login user_login = new User_login();
        user_login.setUsername("ftt");
        user_login.setPassword("2323223");
        return user_login;
    }

    @RequestMapping(value = "/setcookie")
    @ResponseBody
    public String setLoginUser(@RequestBody User_login user_login, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        UserList = user_login;
        HttpSession session = httpServletRequest.getSession();
        String sessionId = session.getId();
        session.setAttribute("username",user_login.getUserName());
        session.setAttribute("password",user_login.getPassword());
        System.out.println("from setCookie:"+sessionId);
        /*
        Cookie cookie = new Cookie("newUser",sessionId);
        httpServletResponse.addCookie(cookie);*/
        return "0";
    }

    @RequestMapping(value = "/getcookie")
    public String getCookies(HttpServletRequest httpServletRequest){
        HttpSession httpSession = httpServletRequest.getSession();
        String sessionId = httpSession.getId();
        System.out.println("from getCookie:"+sessionId);
        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null) {
            for (Cookie cookie : cookies) {
                System.out.println("getName:"+ cookie.getName());
                System.out.println("getValue:"+cookie.getValue());
                //如果发现cookie中有当前会话的id
                if(cookie.getValue().equals(sessionId)){
                    System.out.println(httpSession.getAttribute("username").toString());
                    break;
                }
            }
        }
        return "index";
    }



    /*
        /*Map<String , String> map = new HashMap<String ,String>();
        map.put("username","11111");
        map.put("pwd","22222");
        System.out.println(user_login.toString());*/
    //return user_login;

}

   /*
    @RequestMapping(value="/homepage/login")
    public Map<String,String> Test1() {
        Map<String , String> map = new HashMap<String ,String>();
        map.put("username", user_login.username);
        map.put("password", user_login.password);
        return map;
    }
    /*

    public Greeting greeting( Map<String,String> map) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template,map.get("username")));
    }*/


