package com.lisong.tomcat;

import java.io.IOException;

/**
 * @author lenovo
 * @package com.lisong.tomcat
 * @date 2020/5/13 15:34
 * @Description Servlet抽象类
 */
public abstract class MyServlet {
    public abstract void doGet(MyRequest myRequest, MyResponse myResponse) throws IOException;
    public abstract void doPost(MyRequest myRequest, MyResponse myResponse) throws IOException;

    public void service(MyRequest myRequest, MyResponse myResponse) {
        if (myRequest.getMethod().equalsIgnoreCase("POST")){
            try {
                doPost(myRequest,myResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (myRequest.getMethod().equalsIgnoreCase("GET")) {
            try {
                doGet(myRequest,myResponse);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
