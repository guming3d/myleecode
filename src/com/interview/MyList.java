package com.interview;

import java.util.List;

public class MyList<GF> {
	public static void mykick(List<? extends KickAssImp> list){
		list.forEach(item-> item.kickAss());
		for(KickAssImp a:list){
			a.kickAss();
		}
	}
	

}
