package com.datastatistics.controller.poetry;

public class Verse {

	public String Content = "";
	public int Melody = -1;
	public int RhymeCode = -1;

	public Verse() {
	}

	public Verse(String content, int rhymeCode, int melody) {
		super();
		Content = content;
		RhymeCode = rhymeCode;
		Melody = melody;
	}

}
