package com.lisong.tomcat;

import java.io.IOException;

/**
 * @author lenovo
 * @package com.lisong.tomcat
 * @date 2020/5/13 15:44
 * @Description myServlet实现类
 */
public class MygirlServlet extends MyServlet{
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) throws IOException {
        myResponse.write("get girl");
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) throws IOException {
        myResponse.write("post girl");
    }
}
