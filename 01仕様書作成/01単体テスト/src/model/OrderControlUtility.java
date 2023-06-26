package model;

import java.util.ArrayList;

public class OrderControlUtility{
	public static String[][] customerToArray(ArrayList<ProductBean>) list{
		
		int listSize =  list.size();
		String[][] tableData = new String[listSize][4];
		
		for(int i = 0; i < listSize; i++) {
			
			ProductBean product1 = list.get(i);
			tableData[i][0] = Integer.toString(product1.getProductId());
			tableData[i][1] = product1.getProductName();
			tableData[i][2] = product1.getTel();
			tableData[i][3] = product1.getProductionArea();
		}
		
		return tableData;
	}
}