package com.qian.suanfa;

public class ZhiShu {

    
        public static void main(String args[]) {
            int i = 0;
            math mymath = new math();
            for (i = 2; i <= 200; i++)
                if (mymath.iszhishu(i) == true)
                    System.out.println(i);
        }
    }

    class math {


        public boolean iszhishu(int x) {
            for (int i = 2; i <= x / 2; i++)
                if (x % 2 == 0)
                    return false;
            return true;
        }
    }

