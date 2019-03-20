package com.example.demo.common.thread;

import org.springframework.context.ApplicationContext;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author houlei
 * @DESC:CyicBarrclier测试
 * @create 2019-01-17 15:50
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int n=4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(n);
        for (int i = 0; i < 4; i++) {
            new TestCyicBarrclier(cyclicBarrier).start();
        }


    }

    static class TestCyicBarrclier extends Thread{
        private CyclicBarrier cyclicBarrier;

        public TestCyicBarrclier(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("开始进行TestCyicBarrclier测试 "+Thread.currentThread().getName());
            try {
                Thread.sleep(500);
                System.out.println("线程"+Thread.currentThread().getName()+" 写入完毕 !正在等待其他线程！");
                cyclicBarrier.await();
                System.out.println("所有线程执行完毕 ");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



    protected  void initSrategies(ApplicationContext applicationContext){
        //用于处理上传请求 处理方法是将普通的request进行包装集成
        initMultipartResolver(applicationContext);
        //springmvc主要两个地方用到了Local 一是 viewResoler视图解析的时候 二是用到了国际化资源或者主题的时候
        initLocalResolver(applicationContext);
        //用于解析主题 springMVC中 一个主题对应一个主题文件 里面存放着当前主题所有相关的资源
        initTheamResolver(applicationContext);
        //用来查找handler
        initHandlerMapping(applicationContext);
        //其他组件是用来干活的 这个组件是处理异常的
        initHandlerExceptionsResolver(applicationContext);
        //有的handler没有设置name也没有设置viewName，这时就需要从request获取Name
        initRequestToViewNameTranslator(applicationContext);
        //viewResolver用来将string类型的视图名解析为view类型的视图
        initViewResolver(applicationContext);
        //用来管理FlashMap的 FalshMap用来传递redirect重定向中的参数
        initFlashMapManager(applicationContext);

    }

    private void initFlashMapManager(ApplicationContext applicationContext) {

    }

    private void initViewResolver(ApplicationContext applicationContext) {

    }

    private void initRequestToViewNameTranslator(ApplicationContext applicationContext) {

    }

    private void initHandlerExceptionsResolver(ApplicationContext applicationContext) {


    }

    private void initHandlerMapping(ApplicationContext applicationContext) {



    }

    private void initTheamResolver(ApplicationContext applicationContext) {
    }

    private void initLocalResolver(ApplicationContext applicationContext) {
    }

    private void initMultipartResolver(ApplicationContext applicationContext) {
    }

}
