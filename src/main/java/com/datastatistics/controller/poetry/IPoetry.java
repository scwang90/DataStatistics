package com.datastatistics.controller.poetry;

public abstract class IPoetry {

	public String mKey = "唯爱紫夕";
	public int mPlace = 1;
	public int mType = 5;
	public int mVoice = 1;

	public String[] places = new String[]{"藏头","藏尾","藏中"};
	public String[] types = new String[]{"五言","七言"};
	public String[] voices = new String[]{"双句一押","双句押韵","一三四押"};

	public abstract String getText();
	public abstract String getHtml();
//	public abstract String getNextText();
//	public abstract String getNextHtml();

//	public abstract boolean hasNext();
//	public abstract void versify() throws Exception;
//	public abstract void versify(String doc) throws Exception;
	public abstract void checkInput() throws Exception;
	public abstract String[] versify() throws Exception;

//	public boolean showAd(int index){
//		return false;
//	}

	public String getPlace() {
		if (mPlace > places.length) {
			mPlace = 1;
		}
		return places[mPlace-1];
	}


	public String getType() {
		return types[mType == 5 ? 0 : 1];
	}


	public String getVoice() {
		if (mVoice > voices.length) {
			mVoice = 1;
		}
		return voices[mVoice-1];
	}

	public String getTitle() {
		return mKey.length() == 0 ? "无题" : mKey;
	}

}
