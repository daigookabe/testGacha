import java.util.Random;

class Gacha {
    static long seed = System.currentTimeMillis() + Runtime.getRuntime().freeMemory();
    static Random random = new Random(seed);

    public static void main(String[] args) {
        // argsのnullチェック
        if (args.length == 0) {
            System.out.println("!!引数を設定してください!!");
            return;
        }

        int normalCount = Integer.parseInt(args[0]);
        int specialCount = Integer.parseInt(args[1]);

        if (args.length != 2) {
            System.out.println("!!引数の数がエラーです!!");
            return;
        } else if (Integer.parseInt(args[0]) + Integer.parseInt(args[1]) == 0) {
            System.out.println("!!引数に1以上を設定してください!!");
            return;           
        } else {
             normalCount = Integer.parseInt(args[0]);
             specialCount = Integer.parseInt(args[1]);
        }

        // ノーマルチケットを使った場合
        if (normalCount == 0){
            System.out.println("---ノーマルチケット結果---\nチケットを使用していません");
        } else {  
            for (int iNormal = 1; iNormal <= normalCount; iNormal++){
                if (iNormal != 1 && iNormal % 10 == 0) {
                    String itemName = getSpecialGachaItem(iNormal, normalCount);
                    System.out.println(itemName);
                    if (iNormal == normalCount) {
                        break;
                    }          
                } else {
                    String itemName = getNormalGachaItem(iNormal, normalCount);
                    System.out.println(itemName);
                }
            } 
        }

        // スペシャルチケットを使った場合
        if (specialCount == 0){
            System.out.println("\n---スペシャルチケット結果---\nチケットを使用していません");
        } else {
            System.out.println("\n---スペシャルチケット結果---");
            for (int iSpecial = 1; iSpecial <= specialCount; iSpecial++){
                String itemName = getSpecialGachaItem(iSpecial, specialCount);
                System.out.println(itemName);
            }
        } 
    }

    // ノーマルガチャのオッズ
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

    // スペシャルガチャのオッズ
    public static String getSpecialGachaItem(int count, int time) {
        String itemName;
        int num = random.nextInt(101);
        System.out.println("【" + count + "連目】　(⭐️スペシャルオッズ⭐️)");

        if (0 <= num && num<= 19) {
            itemName = "★★★　星3メダロット一式";
        } else {
            itemName = "★★　星2メダロット一式";
        }
        return itemName;
    }
}
