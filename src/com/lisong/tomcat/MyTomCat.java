package com.lisong.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lenovo
 * @package com.lisong.tomcat
 * @date 2020/5/13 16:10
 * @Description 启动类
 */
public class MyTomCat {
    private int port = 8080;
    private Map<String,String> urlServletMap = new HashMap<String,String>();

    public MyTomCat(int port) {
        this.port = port;
    }

    public void start() {
        initServletMapping();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("myTomCat is Start...");

            while (true) {
                //这里是mini-tomcat的算是核心代码吧
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);
                dispatch(myRequest,myResponse);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        String clazz = urlServletMap.get(myRequest.getUrl());

        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();

            myServlet.service(myRequest,myResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void initServletMapping() {
        for (ServletMapping servletMapping: ServletMappingConfig.servletMappingList) {
            System.out.println(servletMapping.getUrl()+" "+servletMapping.getClazz());
            urlServletMap.put(servletMapping.getUrl(),servletMapping.getClazz());
        }
    }


    public static void main(String[] args) {
        MyTomCat myTomCat = new MyTomCat(8080);
        myTomCat.start();

    }
}
