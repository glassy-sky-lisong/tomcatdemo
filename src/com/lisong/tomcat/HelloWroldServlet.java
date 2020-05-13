package com.lisong.tomcat;

import java.io.IOException;

/**
 * @author lenovo
 * @package com.lisong.tomcat
 * @date 2020/5/13 15:47
 * @Description 另一个Servlet实现类
 */
public class HelloWroldServlet extends MyServlet{
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) throws IOException {
        myResponse.write("get helloworld");
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) throws IOException {
        myResponse.write("post helloworld");
    }
}
