package org.cqu.edu.msc.annihilation.campephilus.module.instrument.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * campephilus
 *
 * @author lx
 * @date 2019/11/18
 * @email vinicolor.violet.end@gmail.com
 * Description:
 */
class ParseJsonUtilTest {

    @Test
    void getTObject() {
        try {
            ParseJsonUtil.getTObject(Integer.class, "sss");
        } catch (RuntimeException e) {
            System.out.println(e.getCause());
        }
    }
}