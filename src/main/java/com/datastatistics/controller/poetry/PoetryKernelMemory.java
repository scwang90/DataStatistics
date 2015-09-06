package com.datastatistics.controller.poetry;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PoetryKernelMemory {

	protected Random ra = new Random();

	public String mKey = "为你写诗";
	public int mPlace = 3;
	public int mType = 5;
	public int mVoice = 1;

	public static MemoryDao[] MemoryDaos
			 = new MemoryDao[] {
			 new MemoryDao(5),
			 new MemoryDao(7) }
			;
	public List<List<Verse>> mltVerse = new ArrayList<List<Verse>>();

	public PoetryKernelMemory() {
	}

	public List<String> getPoetry() {

		while (MemoryDaos == null) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		MemoryDao dao = MemoryDaos[mType == 5 ? 0 : 1];

		List<String> poetry = new ArrayList<String>();
		if (mPlace != 2)// 不是藏尾
		{
			switch (mVoice) {
				default:
				case 1:
					poetry = getPoetryDoubleRhyme(dao);
					break;
				case 2:
					poetry = getPoetryEvenRhyme(dao);
					break;
				case 3:
					poetry = getPoetryFullRhyme(dao);
					break;
			}
		} else {
			poetry = getPoetryHideTail(dao);
		}

		//递退第一行优化
		if(mPlace == 5){
			List<Verse> verses = dao.getWhere(mType - 1, mKey.charAt(0), 99999999);//int.MaxValue);
			if (verses.size() > 1)
			{
				Verse verse = verses.get(ra.nextInt(verses.size()));
				poetry.remove(0);
				poetry.add(0, verse.Content);
			}
		}

		//添加 "，。" 标点符号
		String marks = "，。";
		for (int i = 0; i < poetry.size(); i++) {
			poetry.set(i, poetry.get(i) + marks.charAt(i & 1));
			// poetry[i] = poetry[i] + marks[i & 1];
		}
		return poetry;
	}

	// / <summary>
	// / 藏尾诗句
	// / </summary>
	// / <param name="dao"></param>
	// / <returns></returns>
	private List<String> getPoetryHideTail(MemoryDao dao) {
		List<String> poetry = new ArrayList<String>();
		for (int i = 0; i < mKey.length(); i++) {
			List<Verse> verse = dao.getWhere(WhereIndex(i), mKey.charAt(i),
					99999999);// int.MaxValue);
			if (verse.size() > 0) {
				poetry.add(verse.get(ra.nextInt(verse.size())).Content);
			} else {
				poetry.add(FalsifyVerse(i, dao.getRandom().get(0)).Content);
			}
		}
		if ((mKey.length() & 1) == 1) {
			poetry.add(dao.getRandom().get(0).Content);
		}
		if (poetry.size() < 4) {
			List<Verse> verse = getDoubleVerseRhymeMain(dao, -1, -1);
			poetry.add(verse.get(0).Content);
			poetry.add(verse.get(1).Content);
		}
		return poetry;
	}

	// / <summary>
	// / 全句押韵
	// / </summary>
	// / <param name="dao"></param>
	// / <returns></returns>
	private List<String> getPoetryFullRhyme(MemoryDao dao) {
		List<String> poetry = new ArrayList<String>();
		if (mKey.length() > 0) {
			Verse verse = getVerse(dao, 0);
			poetry.add(verse.Content);
			for (int i = 1; i < mKey.length(); i++) {
				verse = getDeputyVerse(dao, verse, i);
				poetry.add(verse.Content);
			}
			if ((mKey.length() & 1) == 1) {
				verse = getDeputyVerse(dao, verse, -1);
				poetry.add(verse.Content);
			}
			if (poetry.size() < 4) {
				List<Verse> verses = getDoubleVerseRhymeMain(dao, -1, -1);
				poetry.add(verses.get(0).Content);
				poetry.add(verses.get(1).Content);
			}
		}
		return poetry;
	}

	// / <summary>
	// / 双句押韵(偶数行押韵)
	// / </summary>
	// / <param name="dao"></param>
	// / <returns></returns>
	private List<String> getPoetryEvenRhyme(MemoryDao dao) {
		List<String> poetry = new ArrayList<String>();
		for (int i = 0; i < mKey.length() / 4; i++) {
			poetry.add(getVerse(dao, 4 * i).Content);
			List<Verse> verse = getDoubleVerseRhyme(dao, 4 * i + 1, 4 * i + 3);
			poetry.add(verse.get(0).Content);
			poetry.add(getVerse(dao, 4 * i + 2).Content);
			poetry.add(verse.get(1).Content);
		}
		if (mKey.length() % 4 != 0) {
			int index = mKey.length() / 4, remainder = mKey.length() % 4;
			Verse three = null;
			List<Verse> verse = null;
			switch (remainder) {
				case 1:
					// 【双补句】（押韵优先，无原句）
					verse = getDoubleVerseRhymeMain(dao, -1, -1);
					three = getVerse(dao, -1);
					break;
				case 2:
					// 【row原句+押韵补句】否则【双押韵补句】
					verse = getDoubleVerseRhyme(dao, 4 * index + 1);
					three = getVerse(dao, -1);
					break;
				case 3:
					// 【row原句+押韵补句】否则【双押韵补句】
					verse = getDoubleVerseRhyme(dao, 4 * index + 1);
					three = getVerse(dao, 4 * index + 2);
					break;
			}
			poetry.add(getVerse(dao, 4 * index).Content);
			poetry.add(verse.get(0).Content);
			poetry.add(three.Content);
			poetry.add(verse.get(1).Content);
		}
		return poetry;
	}

	// / <summary>
	// / 双句一押
	// / </summary>
	// / <param name="dao"></param>
	// / <returns></returns>
	private List<String> getPoetryDoubleRhyme(MemoryDao dao) {
		List<String> poetry = new ArrayList<String>();
		for (int i = 0; i < mKey.length() / 2; i++) {
			List<Verse> verse = getDoubleVerseRhyme(dao, 2 * i, 2 * i + 1);
			poetry.add(verse.get(0).Content);
			poetry.add(verse.get(1).Content);
		}
		if ((mKey.length() & 1) == 1)// 如果key多出奇数行 要补行
		{
			int index = mKey.length() - 1;
			List<Verse> verse = getDoubleVerseRhyme(dao, index);
			poetry.add(verse.get(0).Content);
			poetry.add(verse.get(1).Content);
		}
		if (poetry.size() < 4) {
			List<Verse> verse = getDoubleVerseRhymeMain(dao, -1, -1);
			poetry.add(verse.get(0).Content);
			poetry.add(verse.get(1).Content);
		}
		return poetry;
	}

	// / <summary>
	// / 获取符合 row 条件的 诗句 【尽量原句】否则【补句伪造】
	// / 如果 row=-1 直接【补句伪造】
	// / </summary>
	// / <param name="dao"></param>
	// / <param name="row"></param>
	// / <returns></returns>
	private Verse getVerse(MemoryDao dao, int row) {
		if (row >= 0) {
			List<Verse> verse = dao.getWhere(WhereIndex(row), mKey.charAt(row),
					1);
			if (verse.size() > 0) {
				return verse.get(0);
			}
		}
		return FalsifyVerse(row, dao.getRandom(1).get(0));
	}

	// / <summary>
	// / 获取2个 Verse 尽量【row原句+押韵补句】否则【双押韵补句】
	// / </summary>
	// / <param name="dao"></param>
	// / <param name="row"></param>
	// / <returns></returns>
	private List<Verse> getDoubleVerseRhyme(MemoryDao dao, int row) {
		List<Verse> verse = dao.getWhere(WhereIndex(row), mKey.charAt(row), 1);
		if (verse.size() > 0) {
			verse.add(getDeputyVerse(dao, verse.get(0), -1));
		} else {
			List<Verse> rhyme = getDoubleVerseRhyme(dao);
			verse.add(FalsifyVerse(row, rhyme.get(0)));
			verse.add(rhyme.get(1));
		}
		return verse;
	}

	// / <summary>
	// / 获取2个 Verse 尽量【原句+押韵】否则【原句】否则【补韵】否则【补句】
	// / row1 row2 部分主次（但是 row1 优先）
	// / </summary>
	// / <param name="row1">行1</param>
	// / <param name="row2">行2</param>
	// / <returns>2个</returns>
	private List<Verse> getDoubleVerseRhyme(MemoryDao dao, int row1, int row2) {
		List<Verse> verse = new ArrayList<Verse>();
		int index = 0;
		int[][] indexs = new int[][] {
				new int[] { row1, row2 },// 以偶数行作为 主要行 获取两个押韵诗句
				new int[] { row2, row1 },// 否则奇数行为 主要行 获取两个押韵诗句
				new int[] { -1, -1 },// 否则 双补句
		};
		int count1 = dao.getCountWhere(WhereIndex(indexs[index][0]),
				mKey.charAt(indexs[index][0]));
		int count2 = dao.getCountWhere(WhereIndex(indexs[index][1]),
				mKey.charAt(indexs[index][1]));
		if (count2 < count1)// 如果奇数行总数小于偶数行
		{
			// 交换主要次序
			int[] temp = indexs[0];
			indexs[0] = indexs[1];
			indexs[1] = temp;
		}
		List<Verse> list = getDoubleVerseRhymeMain(dao, indexs[index][0],
				indexs[index][1]);
		while (list.size() == 0 && index < indexs.length - 1) {
			index++;
			list = getDoubleVerseRhymeMain(dao, indexs[index][0],
					indexs[index][1]);
		}
		if (count2 < count1 && index < 2) {
			index = 1 - index;
		}
		switch (index) {
			case 0:
			case 1:
				verse.add(list.get(index));
				verse.add(list.get(1 - index));
				break;
			default:
				verse.add(FalsifyVerse(row1, list.get(0)));
				verse.add(FalsifyVerse(row2, list.get(1)));
				break;
		}
		return verse;
	}

	// / <summary>
	// / 获取2个 Verse 尽量【原句+押韵】否则【原句】否则【补韵】否则【补句】
	// / 如果 row1 或者 row2 有一个为 -1 表示 【双补句】（押韵优先，无原句）
	// / </summary>
	// / <param name="row1">主要行，如果主行得不到原句 返回0个Verse</param>
	// / <param name="row2">次要行，迎合主要行尽量【原句+押韵】否则【原句】否则【补韵】否则【补句】</param>
	// / <returns>2个或者0个</returns>
	private List<Verse> getDoubleVerseRhymeMain(MemoryDao dao, int row1,
												int row2) {
		if (row1 == -1 || row2 == -1)// 双补充句
		{
			return getDoubleVerseRhyme(dao);
		}
		List<Verse> verse = dao
				.getWhere(WhereIndex(row1), mKey.charAt(row1), 1);
		if (verse.size() > 0) {
			verse.add(getDeputyVerse(dao, verse.get(0), row2));
		}
		return verse;
	}

	// / <summary>
	// / 迎合 verse 尽量【原句+押韵】否则【原句】否则【补韵】否则【补句】
	// / 如果 row = -1 直接【押韵补句】
	// / </summary>
	// / <param name="verse"></param>
	// / <param name="row"></param>
	// / <returns></returns>
	private Verse getDeputyVerse(MemoryDao dao, Verse verse, int row) {
		// 列出条件 1 原句+押韵 2 原句 3 押韵（补充）4 任何（补充）
		int index = 0;
		char ch = row < 0 ? ' ' : mKey.charAt(row);
		int[] indexs = new int[] { WhereIndex(row), WhereIndex(row), -1, -1 };
		int[] thymes = new int[] { verse.RhymeCode, -1, verse.RhymeCode, -1 };

		List<Verse> verse2 = dao.getRhymeWhere(indexs[index], ch,
				thymes[index], 1);
		while ((verse2.size() == 0 || verse2.get(0).Content.equals(verse.Content)) //防止双句重复
				&& index < thymes.length - 1) {
			index++;
			verse2 = dao.getRhymeWhere(indexs[index], ch, thymes[index], 1);
		}
		if (verse2.size() == 0) {
			return FalsifyVerse(row, NoFindVerse());
		} else if (index > 1)// 大于1表示不是原句 伪造原句
		{
			return FalsifyVerse(row, verse2.get(0));
		} else {
			return verse2.get(0);
		}
	}

	// / <summary>
	// / 获取2个Verse 补句 【要求押韵】
	// / </summary>
	// / <param name="dao"></param>
	// / <returns>一定返回2个Verse</returns>
	private List<Verse> getDoubleVerseRhyme(MemoryDao dao) {
		int rand = 10 * ra.nextInt(12) + 5;
		List<Verse> verse = dao.getRhyme(rand, 2);
		if (verse.size() == 0) {
			return getDoubleVerseRhyme(dao);
		}
		return verse;
	}

	// / <summary>
	// / 数据库就是找不到相关诗句 使用默认诗句
	// / </summary>
	// / <returns></returns>
	private Verse NoFindVerse() {
		return new Verse() {
			{
				Content = "太难作不出来了".substring(0, mType);
			}
		};
	}

	// / <summary>
	// / 根据行数和隐藏位置 确定匹配字符串的位置
	// / 如果 row= -1 直接返回 -1 忽略检索
	// / </summary>
	// / <param name="row"></param>
	// / <returns></returns>
	private int WhereIndex(int row) {
		if (row < 0 || row >= mKey.length()) {
			return -1;
		}
		int m = mType / 2, e = mType - 1;
		// 最多8行
		int[][] indexs = new int[][] {
				new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },// 藏头(最大32)
				new int[] { e, e, e, e, e, e, e, e, e, e, e, e, e, e, e, e, e,
						e, e, e, e, e, e, e, e, e, e, e, e, e, e, e, },// 藏尾(最大32)
				new int[] { m, m, m, m, m, m, m, m, m, m, m, m, m, m, m, m, m,
						m, m, m, m, m, m, m, m, m, m, m, m, m, m, m, },// 藏中(最大32)
				new int[] { 0, 1, 2, 3, 4, 5, 6 },// 递进(最大7)
				new int[] { mType - 1, mType - 2, mType - 3, mType - 4,
						mType - 5, mType - 6, mType - 7 },// 藏中(最大7)
		};
		try {
			return indexs[mPlace - 1][row];
		} catch (ArrayIndexOutOfBoundsException ex) {
			return -1;
		}
	}

	// / <summary>
	// / 用 verse 伪造 第row行诗句
	// / 如果 row=-1 忽略伪造
	// / </summary>
	// / <param name="row">行数</param>
	// / <param name="verse">伪造源</param>
	// / <returns></returns>
	private Verse FalsifyVerse(int row, final Verse verse) {
		if (row >= 0 && row < mKey.length()) {
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
							mType - 5, mType - 6, mType - 7 },// 递退(最大7)
			};

			final char[] versech = verse.Content.toCharArray();
			try {
				versech[indexs[mPlace - 1][row]] = mKey.charAt(row);
			} catch (ArrayIndexOutOfBoundsException ex) {
				versech[indexs[mPlace - 1][0]] = mKey.charAt(row);
			}

			return new Verse() {
				{
					Content = new String(versech);
					RhymeCode = verse.RhymeCode;
				}
			};
		}
		return verse;
	}

	// / <summary>
	// / 获取第 row 行的 where 语句 整合隐藏位置
	// / 如果 row = -1 这忽略where条件 返回 1
	// / </summary>
	// / <param name="row">行数</param>
	// / <returns></returns>
//	protected String getContentWhere(int row) {
//		if (row < mKey.length() && row >= 0 && mPlace > 0 && mPlace < 6) {
//			StringBuilder where = new StringBuilder(" (Content like ");
//			if (mPlace < 3) {
//				String[] headtail = new String[] { "'%s%%'", "'%%%s'" };
//				where.append(String.format(headtail[mPlace - 1],
//						mKey.charAt(row)));
//			} else if (mPlace < 6) {
//				char[] likech = "_______".toCharArray();
//				if (mPlace == 3)// 藏中
//				{
//					likech[mType / 2] = mKey.charAt(row);
//				} else if (mPlace == 4)// 递进
//				{
//					likech[row] = mKey.charAt(row);
//				} else if (mPlace == 5)// 递退
//				{
//					likech[mType - 1 - row] = mKey.charAt(row);
//				}
//				where.append(String
//						.format("'%s'", new String(likech, 0, mType)));
//			}
//			where.append(')');
//			return where.toString();
//		}
//		return "1";
//	}

}
