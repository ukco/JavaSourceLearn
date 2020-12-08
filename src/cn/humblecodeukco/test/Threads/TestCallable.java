package cn.humblecodeukco.test.Threads;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @Author lyr
 * @Date 2020/12/8 18:56
 * @Version 1.0
 * @Description 线程创建方式三：实现callable接口
 * callable的好处
 * 1. 可以定义返回值
 * 2. 可以跑出异常
 */
public class TestCallable implements Callable<Boolean> {
    /**
     * 网络图片地址
     */
    private String url;
    /**
     * 保存文件名
     */
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    /**
     * 下载图片线程的执行体
     * @return
     */
    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://coolshell.cn/wp-content/uploads/2013/05/race_condition-300x190.jpg", "1.jpg");
        TestCallable t2 = new TestCallable("https://coolshell.cn/wp-content/uploads/2013/05/HashMap01.jpg", "2.jpg");
        TestCallable t3 = new TestCallable("https://coolshell.cn/wp-content/uploads/2013/05/HashMap02.jpg", "3.jpg");

        // 创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        // 关闭服务
        ser.shutdownNow();
    }
}