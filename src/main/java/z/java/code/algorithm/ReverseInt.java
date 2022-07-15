package z.java.code.algorithm;

import z.java.code.LogUtils;

public class ReverseInt {

    public static void main(String[] args) {

        int num = -2147483412;

        LogUtils.d("reverseInt", "" + Integer.MAX_VALUE);
        LogUtils.d("reverseInt", "" + Integer.MIN_VALUE);
        LogUtils.d("reverseInt", "" + -5 % 10);
        LogUtils.d("reverseInt", num + " => " + reverseInt(num));
    }

    private static int reverseInt(int num) {
        int ret = 0;
        int s = 0;
        while (num != 0) {
            // 先判断，防止在最后一步 Integer.MAX_VALUE === ret 多走一步计算
            if (Integer.MAX_VALUE / 10 < ret
                    || Integer.MIN_VALUE / 10 > ret) {
                return 0;
            }

            s = num % 10;
            num = num / 10;
            ret = ret * 10 + s;
        }
        return ret;
    }

}
