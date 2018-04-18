package com.thread;

import com.squareup.okhttp.*;

import java.io.IOException;

public class Queue {

    public static void main(String[] args) {

//        String content = "{\n" +
//                "    \"msgtype\": \"link\", \n" +
//                "    \"link\": {\n" +
//                "        \"text\":\"点击查看\", \n" +
//                "       \"title\": \"xxxx您有一条新分配的合同，请注意查收\", \n" +
//                "        \"picUrl\": \"\", \n" +
//                "        \"messageUrl\": \"http://10.0.0.7/manager/index.html#/operation_my_contract\"\n" + "}" + "," +
//                "     \"at\": {\n" +
//                "         \"isAtAll\": true\n" +
//                "     }\n" +
//                "}";

//        String content3 = "{\"msgtype\": \"link\",\"link\":{\"text\":\"点击查看\",\"title\":\"xxxx您有一条新分配的合同，请注意查收@田磊\",\"messageUrl\":\"http://10.0.0.7/manager/index.html#/operation_my_contract\"},\"at\":{\"isAtAll\":1}}";

//                String content3 = "{\"msgtype\": \"markdown\",\"markdown\":{\"title\":\"xxxx您有一条新分配的合同，请注意查收\",\"text\":\"#### xxxx您有一条新分配的合同，请注意查收 \n [点击查看](http://10.0.0.7/manager/index.html#/operation_my_contract）\"},\"at\":{\"isAtAll\":1}}";



        String content1 = "  {\n" +
                "     \"msgtype\": \"text\",\n" +
                "     \"text\": {\n" +
                "         \"content\": "
                + "姓名：xx,您有一条新分配的合同请注意查收" +
                "     },\n" +
                "     \"at\": {\n" +
                "         \"isAtAll\": true\n" +
                "     }\n" +
                " }";

//        String content3 = "{\"msgtype\": \"text\",\"text\":{\"content\":\"test\"},\"at\":{\"isAtAll\":1}}";
        String content3 = "{\"msgtype\": \"text\",\"text\":{\"content\":\"xx,您有一条新分配的合同请注意查收。 http://10.0.0.7/manager/index.html#/operation_my_contract @田磊 \"},\"at\":{\"isAtAll\":0}}";


        RequestBody body = RequestBody.create(MediaType.parse("raw"), content3);
        Request request = new Request.Builder()
                .addHeader("Content-Type", "application/json")
                .url("https://oapi.dingtalk.com/robot/send?access_token=9c8b416da0e87f2d9cf4699d3d4082b3f36982f6c6237ab19da59fda380553ad")
                .post(body)
                .build();
        try {
            //异步发送
            new OkHttpClient().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {
                    System.out.println("123");
                }
            });


        } catch (Exception e) {

        }

//        ThreadLocal
//        ConcurrentHashMap
//        //
//        LinkedBlockingQueue linkedBlockingQueue =  new LinkedBlockingQueue<String>(2);
//
//        try {
//
////            Collections.synchronizedMap()
//
//            // 没有空位 会等待
//            linkedBlockingQueue.put("first");
//            linkedBlockingQueue.put("second");
//
//            linkedBlockingQueue.offer("third",10, TimeUnit.SECONDS);
//
//
//            // 没有东西会等待 take
//            linkedBlockingQueue.take();
//
//        } catch (Exception expection){
//
//        }


    }
}