package com.joshua.interview;

public class YHClass {
	private char[] chs;
	private int partition;

	public YHClass(char[] chs, int partition) {
		this.chs = chs;
		this.partition = partition;
	}

	public char[] getChs() {
		return chs;
	}

	public void setChs(char[] chs) {
		this.chs = chs;
	}

	public int getPartition() {
		return partition;
	}

	public void setPartition(int partition) {
		this.partition = partition;
	}

}
