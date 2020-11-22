package cn.humblecodeukco.test.Threads;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @Author lyr
 * @Date 2020/11/22 19:10
 * @Version 1.0
 * @Description 练习Thread，实现多线程同步下载图片
 */
public class TestThread2 implements Runnable {

    private String url; // 网络图片地址
    private String name; // 保存文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://coolshell.cn/wp-content/uploads/2013/05/race_condition-300x190.jpg", "1.jpg");
        TestThread2 t2 = new TestThread2("https://coolshell.cn/wp-content/uploads/2013/05/HashMap01.jpg", "2.jpg");
        TestThread2 t3 = new TestThread2("https://coolshell.cn/wp-content/uploads/2013/05/HashMap02.jpg", "3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}

class WebDownloader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现异常");
        }
    }
}
