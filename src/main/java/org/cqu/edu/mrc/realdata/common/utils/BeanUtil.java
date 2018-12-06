package org.cqu.edu.mrc.realdata.common.utils;

import java.lang.reflect.Field;

/**
 * @author Vinicolor
 * @date 2018/10/6
 * <p>
 * Description:
 * 对实体类进行判断
 * 判断实体类中属性是否为空
 */
public class BeanUtil {

    public static boolean isAllFieldNull(Object obj) {
        // 得到类对象
        Class stuCla = obj.getClass();
        // 得到属性集合
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = true;
        // 遍历属性
        for (Field f : fs) {
            // 设置属性是可以访问的(私有的也可以)
            f.setAccessible(true);
            // 得到此属性的值
            Object val = null;
            try {
                val = f.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (val != null) {
                //只要有1个属性不为空,那么就不是所有的属性值都为空
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static boolean allFieldNotNull(Object obj) {
        // 得到类对象
        Class stuCla = obj.getClass();
        // 得到属性集合
        Field[] fs = stuCla.getDeclaredFields();
        // 遍历属性
        for (Field f : fs) {
            // 设置属性是可以访问的(私有的也可以)
            f.setAccessible(true);
            // 得到此属性的值
            Object val = null;
            try {
                val = f.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (val == null) {
                //只要有1个属性为空,返回false
                return false;
            }
        }
        return true;
    }
}
