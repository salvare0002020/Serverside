public class Main {
    public static void main(String[] args) {
        String input1 = "日本語ﾃﾞ　遊ボ";
        String input2 = "123  456 789";

        String output1 = removeSpaces(input1);
        String output2 = removeSpaces(input2);

        System.out.println(output1); // 出力: "TesttestTest"
        System.out.println(output2); // 出力: "123456789"
    }

    public static String removeSpaces(String input) {
        return input.replaceAll("[\\s　]", "");
    }
}
