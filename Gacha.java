import java.util.Random;

class Gacha {
    static long seed = System.currentTimeMillis() + Runtime.getRuntime().freeMemory();
    static Random random = new Random(seed);

    public static void main(String[] args) {
        int t = 0;
        if (args.length >= 3) {
            System.out.println("!!引数の数がエラーです!!");
            return;
        }

        if (args.length == 0 || args[0].equals("0")) {
            t = 10;
        } else {
            for(String str : args) {
                t = Integer.parseInt(str);
            }
        }

        for (int i = 1; i <= t; i++){
            if (i != 1 && i % 10 == 0) {
                String itemName = getSpecialGachaItem(i, t);
                System.out.println(itemName);
                if (i == t) {
                    break;
                }
            } else {
                String itemName = getNormalGachaItem(i, t);
                System.out.println(itemName);
            }
        }        
    }

    public static String getSpecialGachaItem(int count, int time) {
        String itemName;
        int num = random.nextInt(101);
        System.out.println("【" + count + "連目】　(⭐️10回目確率⭐️)");

        if (0 <= num && num<= 19) {
            itemName = "★★★　星3メダロット一式";
        } else {
            itemName = "★★　星2メダロット一式";
        }
        return itemName;
    }

    public static String getNormalGachaItem(int count, int time) {
        String itemName;
        int num = random.nextInt(101);
        System.out.println("【" + count + "連目】　(通常確率)");

        if (0 <= num && num<= 2) {
            itemName = "★★★　星3メダロット一式";
        } else if (3 <= num && num <= 19) {
            itemName = "★★★　星3メダロットパーツ";
        } else if (20 <= num && num <= 31) {
            itemName = "★★　星2メダロット一式";
        } else {
            itemName = "★★　星2メダロットパーツ";
        }
        return itemName;
    }
}
