package com.datastatistics.controller.poetry;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MemoryDao {

	protected static String PATH_WUJUE = "/wujue.txt";
	protected static String PATH_QILV = "/qilv.txt";
	protected static String PATH_RHYWJ = "/jwjrhy.txt";
	protected static String PATH_RHYQL = "/jqlrhy.txt";

	protected String path = "";
	protected String rhypath = "";

	protected int wordnum;
	protected int[] rhymes;

	protected int words;
	protected int charlen;
	//	protected Verse[] verses;
	protected char[] cverses;

	protected Random random = new Random();

	protected static boolean mLoadError = false;

	public static boolean isLoadError() {
		return mLoadError;
	}

	public MemoryDao(int wnum) {
		words = wnum;
		path = (words == 5) ? PATH_WUJUE : PATH_QILV;
		rhypath = (words == 5) ? PATH_RHYWJ : PATH_RHYQL;
		try {
			rhymes = this.readRhymeIndex(rhypath);
			cverses = this.readBerseByte(path, words);
			charlen = cverses.length/words;
		} catch (Throwable e) {
			mLoadError = true;
			/**
			 * 这个异常会发生（主要是IO异常），但是概率不足1% 注释日志调用
			 */
//			ExceptionHandler.handler(e, "MemoryDao 读取失败！");
		}

//		for (int i = 0, j = 4, l = 0, k = -1; i < verses.length; i++) {
//			if (k <= i) {
//				l = j;
//				while (k <= i && j < rhymes.length - 1) {
//					j++;
//					k = rhymes[j] > k ? rhymes[j] : k;
//				}
//				k = (j < rhymes.length - 1) ? k : 99999999;// int.MaxValue;
//			}
//			// k = rhymes[++j];
//			verses[i].RhymeCode = l;
//		}
	}

	private InputStream openAssets(String path) {
		return MemoryDao.class.getResourceAsStream(path);
	}

	private char[] readBerseByte(String path, int words) throws IOException {
		InputStream stream = openAssets(path);
		byte[] bytes = new byte[stream.available()+2];
		stream.read(bytes, 2, bytes.length-2);
		bytes[0] = -1;
		bytes[1] = -2;
		Charset cs = Charset.forName ("Unicode");
		ByteBuffer bb = ByteBuffer.allocate (bytes.length);
		bb.put (bytes);
		bb.flip ();
		stream.close();
		return cs.decode (bb).array();
	}

	private int[] readRhymeIndex(String path) throws IOException {
		InputStream stream = openAssets(path);
		DataInputStream dstream = new DataInputStream(stream);
		int[] indexs = new int[128];
		for (int i = 0; i < indexs.length; i++) {
			indexs[i] = dstream.readInt();
		}
		dstream.close();
		stream.close();
		return indexs;
	}

	private int getRhymeCode(int index) {
		int last = 4;
		for (int i = 0; i < rhymes.length; i++) {
			if (rhymes[i] > 0) {
				if (rhymes[i] == index) {
					return i;
				}
				if (rhymes[i] > index) {
					return last;
				}
				last = i;
			}
		}
//		String msg = "RhymeCode 获取失败\r\nindex="+index+"\r\nrhymes="+rhymes;
//		ExceptionHandler.handler(new AfException(msg), "RhymeCode 获取失败");
		return last;
	}

	// / <summary>
	// / 随机查找一个符合 条件 int index, char ch 的 n 个 Verse
	// / 如果 index == -1 忽略条件
	// / </summary>
	// / <param name="index">条件匹配下标</param>
	// / <param name="ch">条件匹配值</param>
	// / <param name="n">获取n个结果</param>
	// / <returns>不多于n个的结果</returns>
	public List<Verse> getWhere(int index, char ch) {
		return getWhere(index, ch, 1);
	}

	public List<Verse> getWhere(int index, char ch, int n) {
		if (index < 0) {
			return getRandom(n);
		}
//		return getWhere(index, ch, 0, verses.length, n);
		return getWhere(index, ch, 0, charlen, n);
	}

	// / <summary>
	// / 获取 n 个 押rhyme韵 偏差为offset 的 Verse
	// / 如果 rhyme == -1 忽略押韵
	// / </summary>
	// / <param name="rhyme">主韵</param>
	// / <param name="n">个数</param>
	// / <param name="offset">押韵相似偏差</param>
	// / <returns>不多于 n 个 Verse</returns>
	public List<Verse> getRhyme(int rhyme) {
		return getRhyme(rhyme, 1);
	}

	public List<Verse> getRhyme(int rhyme, int n) {
		return getRhyme(rhyme, n, 2);
	}

	public List<Verse> getRhyme(int rhyme, int n, int offset) {
		if (rhyme < 0) {
			return getRandom(n);
		}

		int start = rhyme - offset, end = rhyme + offset;
		int nstart = -1, nend = -1;
		while (nstart == -1)
			nstart = rhymes[++start];
		while (nend == -1 && end < rhymes.length)
			nend = rhymes[++end];
		nend = (nend > 0) ? nend : charlen;//verses.length;
		int len = nend - nstart;

		List<Verse> verse = new ArrayList<Verse>();
		while (charlen> 0 && verse.size() < n) {
			//verse.add(verses[nstart + random.nextInt(len)]);
			verse.add(getVersesIndex(nstart + random.nextInt(len)));
		}
		return verse;
	}

	private Verse getVersesIndex(int index) {
		Verse verse = new Verse();
		if (cverses.length < 11) {
			verse.Content = "太难做不出来了".substring(0, words);
			verse.RhymeCode = 5;
		}else {
			verse.Content = new String(cverses, index*words, words);
			verse.RhymeCode = getRhymeCode(index);
		}
		return verse;
	}

	// / <summary>
	// / 获取 n 个 符合 条件 int index 且 押rhyme韵 偏差为offset 的 Verse
	// / 如果 index == -1 忽略条件
	// / </summary>
	// / <param name="index">条件匹配下标</param>
	// / <param name="ch">条件匹配值</param>
	// / <param name="rhyme">主韵</param>
	// / <param name="n">个数</param>
	// / <param name="offset">押韵相似偏差</param>
	// / <returns>不多于 n 个 Verse</returns>
	public List<Verse> getRhymeWhere(int index, char ch, int rhyme) {
		return getRhymeWhere(index, ch, rhyme, 1, 2);
	}

	public List<Verse> getRhymeWhere(int index, char ch, int rhyme, int n) {
		return getRhymeWhere(index, ch, rhyme, n, 2);
	}

	public List<Verse> getRhymeWhere(int index, char ch, int rhyme, int n,
									 int offset) {
		if (index < 0) {
			return getRhyme(rhyme, n, offset);
		}
		if (rhyme < 0) {
			return getWhere(index, ch, n);
		}

		int start = rhyme - offset, end = rhyme + offset;
		int nstart = -1, nend = -1;
		while (nstart == -1)
			nstart = rhymes[++start];
		while (nend == -1 && end < rhymes.length)
			nend = rhymes[++end];
		nend = (nend > 0) ? nend : charlen;//verses.length;

		return getWhere(index, ch, nstart, nend, n);
	}

	// / <summary>
	// / 在 start-end 范围随机查找一个符合 条件 int index, char ch 的 n 个 Verse
	// / </summary>
	// / <param name="index">条件匹配下标</param>
	// / <param name="ch">条件匹配值</param>
	// / <param name="start">押韵查找范围开始</param>
	// / <param name="end">范围结束 不包括 end </param>
	// / <param name="n">获取n个结果</param>
	// / <returns>不多于n个的结果</returns>
	protected List<Verse> getWhere(int index, char ch, int start, int end, int n) {
		List<Verse> verse = new ArrayList<Verse>();
		int k, len = end - start;
		int rand = random.nextInt(len);
		for (int i = start; i < end && verse.size() < n; i++) {
			k = i + rand;
			if (k >= end) {
				k = k - len;
			}
			if (cverses[k*words+index] == ch) {
				verse.add(getVersesIndex(k));
			}
//			if (verses[k].Content.charAt(index) == ch) {
//				verse.add(verses[k]);
//			}
		}
		return verse;
	}

	// / <summary>
	// / 快速统计 符合 条件 int index 的数量
	// / </summary>
	// / <param name="index"></param>
	// / <param name="ch"></param>
	// / <returns></returns>
	public int getCountWhere(int index, char ch) {
		int count = 0;
		for (int i = 0; i < charlen; i++) {
			if (cverses[index+i*words] == ch) {
				count++;
			}
		}
//		for (Verse item : verses) {
//			if (item.Content.charAt(index) == ch) {
//				count++;
//			}
//		}
		return count;
	}

	// / <summary>
	// / 随机获取 n 个 Verse
	// / </summary>
	// / <param name="n">获取n个结果</param>
	// / <returns>不多于n个的结果</returns>
	public List<Verse> getRandom(int n) {
		List<Verse> verse = new ArrayList<Verse>();
//		while (verses.length > 0 && verse.size() < n) {
//			verse.add(verses[random.nextInt(verses.length)]);
//		}
		while (charlen> 0 && verse.size() < n) {
			verse.add(getVersesIndex(random.nextInt(charlen)));
		}
		return verse;
	}

	public List<Verse> getRandom() {
		return getRandom(1);
	}

}
