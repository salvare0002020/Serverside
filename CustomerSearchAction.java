/**
 * クラス名：    CustomerSearch-Action
 * 概要　　：    顧客情報検索管理を管理する
 * 作成者名：西田有摩
 * 作成日　：2023/5/23
 * 変数名:searchCustomerDBAccess() : SCDBA
 * 修正者名：
 * 
 * 修正日　：
 */


package action;

import java.util.ArrayList;
import model.Customer;
import model.OrderControlUtility;
import dao.searchCustomerDBAccess;

public class CustomerSearchAction extends Object {
    public String[][] execute(String[] data) throws Exception {
         // 半角スペースと全角スペースを取り除く
        searchCustomerDBAccess SCDBA = new searchCustomerDBAccess();
        String tel = data[0].replaceAll("[\\s　]", "");
        String kana = data[1].replaceAll("[\\s　]", "");

        ArrayList<Customer> customerList = null;
        //
        if (!tel.equals("") && kana.equals("")) {
             // data[0]に一致する顧客情報リストを問い合わせる
            customerList = SCDBA.searchByTel(tel);

        } else if (tel.equals("") && !kana.equals("")) {
             // data[1]を含む顧客情報リストを問い合わせる
            customerList = SCDBA.searchByKana(kana);
        } else if (!tel.equals("") && !kana.equals("")) {
             // data[0]に一致し、data[1]を含む顧客情報リストを問い合わせる
            customerList = SCDBA.searchBytelAndKana(tel,kana);
        }

        if (customerList != null && kana != tel) {
             // 検索結果表示用データに変換する
            String[][] tableData = String.valueOf(tel,kana);
            return tableData;
        }
        return null;
    }
}