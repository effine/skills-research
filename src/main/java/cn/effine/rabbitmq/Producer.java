/**
 * @author effine
 * @Date 2015年9月15日  上午11:02:42
 * @email verphen#gmail.com
 * @site http://www.effine.cn
 */

package cn.effine.rabbitmq;

import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

/**
 * 队列生产者
 */
public class Producer extends EndPoint {

	public Producer(String endPointName) throws IOException {
		super(endPointName);
	}

	public void sendMessage(Serializable object) throws IOException {
		channel.basicPublish("", endPointName, null,
				SerializationUtils.serialize(object));
	}
}