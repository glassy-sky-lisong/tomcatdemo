package com.lisong.tomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lenovo
 * @package com.lisong.tomcat
 * @date 2020/5/13 16:08
 * @Description 映射配置
 */
public class ServletMappingConfig {
    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();
    static {
        servletMappingList.add(new ServletMapping("findGirl","/girl","com.lisong.tomcat.MygirlServlet"));
        servletMappingList.add(new ServletMapping("findGirl","/hello","com.lisong.tomcat.HelloWroldServlet"));
        servletMappingList.add(new ServletMapping("favicon","/favicon.ico","com.lisong.tomcat.HelloWroldServlet"));
    }
}
