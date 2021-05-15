package com.wong.thread;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class TestThread2 extends Thread{
	private String url;
	private String name;
	
	public TestThread2(String url, String name) {
		this.url = url;
		this.name = name;
	}
	
	public void rum() {
		WebDownloader webDownloader = new WebDownloader();
		webDownloader.downloader(url, name);
		System.out.println("download file name : "+name);
	}
	
	public static void main(String[] args) {
		TestThread2 t1 = new TestThread2("https://media.sproutsocial.com/uploads/2017/02/10x-featured-social-media-image-size.png", "image1");
		t1.start();
	}
}

class WebDownloader{
	public void downloader(String url, String name) {
		try {
			FileUtils.copyURLToFile(new URL(url), new File(name));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
