package com.wong.jvm;

import java.util.Random;

public class Hells {
	public static void main(String[] args) {
		String str = "fiogkhowaihf;lsdnvkfdlhgieshrgojea";
		while(true) {
			str += str + new Random().nextInt(888888888) + new Random().nextInt(999999999);
		}
	}
}
