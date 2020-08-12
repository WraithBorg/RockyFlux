package com.dddcs.dddcs.utils;

public class TestUtils {
    public static void main(String[] args) {
        String pattern = "%05d"; // 格式化字串，整數，長度10，不足部分左邊補0
        String str = String.format(pattern, 111);
        System.out.println(str);

    }
}
