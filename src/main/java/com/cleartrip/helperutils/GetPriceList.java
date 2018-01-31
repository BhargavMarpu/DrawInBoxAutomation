package com.cleartrip.helperutils;

import java.util.Collections;
import java.util.List;

public class GetPriceList {

	public String getSecondHighestValue(List<String> priceList){
		Collections.sort(priceList);
		return priceList.get(1);
	}
}
