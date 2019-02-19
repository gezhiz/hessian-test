package com.worthto.common.utils;

import com.caucho.hessian.io.HessianSerializerInput;
import com.caucho.hessian.io.HessianSerializerOutput;
import com.worthto.common.exception.SerializeException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by gezz on 2019/2/18.
 */
public class HessianObjectSerializeUtil {
    /**
     *
     * 纯hessian序列化
     *
     * @param <T>
     *
     * @param object
     *
     * @return
     *
     * @throws Exception
     */

    public static <T> byte[] serialize(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        byte[] results = null;
        ByteArrayOutputStream os = null;
        HessianSerializerOutput hessianOutput = null;
        try {
            os = new ByteArrayOutputStream();
            hessianOutput = new HessianSerializerOutput(os);
            //write本身是线程安全的
            hessianOutput.writeObject(object);
            os.close();
            results = os.toByteArray();
        } catch (Exception e) {
            throw new SerializeException(e);//重新抛出异常
        } finally {
            try {
                if (os != null)
                    os.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return results;
    }

    /**
     *
     * 纯hessian反序列化
     *
     * @param bytes
     *
     * @return
     *
     * @throws Exception
     */

    public static <T> T deserialize(Class<T> resultClass, byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException();
        }
        T result = null;
        ByteArrayInputStream is = null;
        try {
            is = new ByteArrayInputStream(bytes);
            HessianSerializerInput hessianInput = new HessianSerializerInput(is);
            result = (T) hessianInput.readObject();

        } catch (Exception e) {
            throw new SerializeException(e);
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                throw new SerializeException(e);
            }
        }
        return result;

    }
}