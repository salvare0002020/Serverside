package unittst.uc01;
import action.CustomerSearchAction;


public class CustomerSearchActionTest {
    public static void main(String[] args) {
        CustomerSearchAction action = new CustomerSearchAction();
        
        // テストケース1
        String[] data1 = {"09045678123", ""};
        String[][] expected1 = {{"５",""},{"鈴木弘"}};
        testAction(action, data1, expected1);
        
        // テストケース2
        String[] data2 = {"", "タカハシミホ"};
        String[][] expected2 = {{"6", ""},{"高橋美帆",""}};
        testAction(action, data2, expected2);
        
        // テストケース3
        String[] data3 = {"0314142135", "ワタナベ"};
        String[][] expected3 = {{"15", ""},{"15","渡部香生子"}};
        testAction(action, data3, expected3);
        
        // テストケース4
        String[] data4 = {"0120500500", ""};
        String[][] expected4 = null;
        testAction(action, data4, expected4);
        
        // テストケース5
        String[] data5 = {"", "イワサキキョウコ"};
        String[][] expected5 = null;
        testAction(action, data5, expected5);
        
        // テストケース6
        String[] data6 = {"", ""};
        String[][] expected6 = null;
        testAction(action, data6, expected6);
    }
    /*1単体テスト仕様書通りのデータを配置
     * 2.テスト対象のデータを引数として引っ張ってくる関数の作成し①と比較
     * 3.②の比較結果に応じて成果の出力を明示
     */
    private static void testAction(CustomerSearchAction action, String[] data, String[][] expected) {
        try {
            String[][] result = action.execute(data);
            
            // 結果の比較
            if (result == null && expected == null) {
                System.out.println("Test Passed!");
            } else if (result != null && expected != null && result.length == expected.length) {
                boolean passed = true;
                for (int i = 0; i < result.length; i++) {
                    if (!result[i][0].equals(expected[i][0]) || !result[i][1].equals(expected[i][1])) {
                        passed = false;
                        break;
                    }
                }
                if (passed) {
                    System.out.println("Test Passed!");
                } else {
                    System.out.println("Test Failed!");
                }
            } else {
                System.out.println("Test Failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
