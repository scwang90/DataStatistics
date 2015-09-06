package com.datastatistics.controller.poetry;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PoetryKernelSuper extends IPoetry {

	private List<String> mltVerse= new ArrayList<String>();
	private PoetryKernelMemory kernel = new PoetryKernelMemory();

	public PoetryKernelSuper() {
		places = new String[] { "藏头", "藏尾", "藏中", "递进", "递退" };
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(2014, 9-1, 11);
//		if (!new Date().after(calendar.getTime())) {
//			mKey = "老师辛苦啦";
//		}
//		calendar.set(2014, 9-1, 8);
//		if (!new Date().after(calendar.getTime())) {
//			mKey = "中秋快乐";
//		}
	}

	@Override
	public void checkInput() throws Exception {
		if (mKey == null || mKey.length() == 0) {
			mKey = "为你写诗";
			// throw new AfToastException("隐藏内容不能为空噢");
		}
		if (mPlace >= 3) {//递进退 限制最大字数
			if (mKey.length() > mType) {
				mKey = mKey.substring(0, mType);
			}
		}else {
			if (mKey.length() > 30) {//限制最大字数 30
				mKey = mKey.substring(0, 30);
			}
		}
	}

	@Override
	public String getText() {
		StringBuilder builder = new StringBuilder();
		if (mltVerse.size() > 0) {
			int index = 0;
			for (String verse : mltVerse) {
				builder.append(verse);
				if ((++index&1)==0) {
					builder.append("\r\n");
				}
			}
			builder.delete(builder.length() - 2, builder.length());
		}
		return builder.toString();
	}

	@Override
	public String getHtml() {
		StringBuilder builder = new StringBuilder("");
		for (int i = 0; i < mltVerse.size(); i++) {
			builder.append(remark(mltVerse.get(i), i));
			// "<font color=red>为</font>你写诗，<br/>";
			if (i < mltVerse.size() - 1) {
//				builder.append("<br/>");
				builder.append("<br/>\r\n");
			}
		}
		return builder.toString();
	}

	private String remark(String verse, int row) {
		if (row < mKey.length()) {
			// 最多8行
			int m = mType / 2, e = mType - 1;
			// 最多8行
			int[][] indexs = new int[][] {
					new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
							0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },// 藏头(最大32)
					new int[] { e, e, e, e, e, e, e, e, e, e, e, e, e, e, e, e,
							e, e, e, e, e, e, e, e, e, e, e, e, e, e, e, e, },// 藏尾(最大32)
					new int[] { m, m, m, m, m, m, m, m, m, m, m, m, m, m, m, m,
							m, m, m, m, m, m, m, m, m, m, m, m, m, m, m, m, },// 藏中(最大32)
					new int[] { 0, 1, 2, 3, 4, 5, 6 },// 递进(最大7)
					new int[] { mType - 1, mType - 2, mType - 3, mType - 4,
							mType - 5, mType - 6, mType - 7 },// 藏中(最大7)
			};
			StringBuilder builder = new StringBuilder();
			if (indexs[mPlace - 1].length <= row)
			{
				return verse;
			}
			int index = indexs[mPlace - 1][row];
			char[] list = verse.toCharArray();
			for (int i = 0; i < list.length; i++) {
				if (i == index) {
					builder.append("<font color=\"red\">");
				}
				builder.append(list[i]);
				if (i == index) {
					builder.append("</font>");
				}
			}
			return builder.toString();
		}
		return verse;
	}

	@Override
	public String[] versify() throws Exception {
		kernel.mKey = mKey;
		kernel.mPlace = mPlace;
		kernel.mType = mType;
		kernel.mVoice = mVoice;
		mltVerse = kernel.getPoetry();
		return mltVerse.toArray(new String[0]);
	}

}
