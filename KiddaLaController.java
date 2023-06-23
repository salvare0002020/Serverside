
/*
 * クラス名：    Customer
  * 概要　　：    顧客情報
 * 作成者名：	 緋田竜也
 * 作成日　：	 2023/5/19
 * 修正者名：	緋田竜也
 * 修正日　：	2023/5/30
 */
package control;

import java.util.ArrayList;
import action.CustomerSearchAction;


public class KiddaLaController {
	
	
	
	public static void customerSearchDisplay(){
		
	}
	
	//data[0]電話番号	data[1]カナ
	public static String[][] customerSearch(String[] data) throws Exception {
		CustomerSearchAction CustomerSearch_Action = new CustomerSearchAction(); 
			String[][] tableData = CustomerSearch_Action.execute(data);
			return tableData;
	}
	
	public static void mainMenuDisplay() {
		
	}
	
}



