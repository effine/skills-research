/**
 * @author effine
 * @Date 2015年9月15日  上午11:04:44
 * @email verphen#gmail.com
 * @site http://www.effine.cn
 */

package cn.effine.rabbitmq;

import java.util.HashMap;

/**
 * 队列测试类
 * 参考链接：http://www.oschina.net/translate/getting-started-with-rabbitmq-in-java
 */
public class QueueTest {
	public QueueTest() throws Exception {
		QueueConsumer consumer = new QueueConsumer("queue");
		Thread consumerThread = new Thread(consumer);
		consumerThread.start();

		Producer producer = new Producer("queue");

		for (int i = 0; i < 100000; i++) {
			HashMap<String,Object> message = new HashMap<String,Object>();
			message.put("message number", i);
			producer.sendMessage(message);
			System.out.println("Message Number " + i + " sent.");
		}
	}

	public static void main(String[] args) throws Exception {
		new QueueTest();
	}
}
