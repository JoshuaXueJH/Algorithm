package com.joshua.chapter17;

import java.util.ArrayList;
import java.util.Collections;

public class No17_8book1 {
	public static void main(String[] args) {
		ArrayList<HtWt> array = new ArrayList<HtWt>();
		array.add(new HtWt(183, 70));
		array.add(new HtWt(180, 70));
		array.add(new HtWt(170, 50));
		array.add(new HtWt(164, 45));
		array.add(new HtWt(175, 60));
		array.add(new HtWt(183, 64));

		No17_8book1 instance = new No17_8book1();
		ArrayList<HtWt> result = instance.longestIncreasingSeq(array);
		for (HtWt item : result) {
			System.out.println(item.height + "--" + item.weight);
		}
	}

	ArrayList<HtWt> longestIncreasingSeq(ArrayList<HtWt> items) {
		Collections.sort(items);
		return bestSeqAtIndex(items, new ArrayList<HtWt>(), 0);
	}

	ArrayList<HtWt> bestSeqAtIndex(ArrayList<HtWt> array, ArrayList<HtWt> sequence, int index) {
		if (index >= array.size())
			return sequence;

		HtWt value = array.get(index);

		ArrayList<HtWt> bestWith = null;
		if (canAppend(sequence, value)) {
			ArrayList<HtWt> sequenceWith = (ArrayList<HtWt>) sequence.clone();
			sequenceWith.add(value);
			bestWith = bestSeqAtIndex(array, sequenceWith, index + 1);
		}

		ArrayList<HtWt> bestWithout = bestSeqAtIndex(array, sequence, index + 1);

		if (bestWith == null || bestWithout.size() > bestWith.size()) {
			return bestWithout;
		} else {
			return bestWith;
		}
	}

	ArrayList<HtWt> max(ArrayList<HtWt> seq1, ArrayList<HtWt> seq2) {
		if (seq1 == null) {
			return seq2;
		} else if (seq2 == null) {
			return seq1;
		}
		return seq1.size() > seq2.size() ? seq1 : seq2;
	}

	boolean canAppend(ArrayList<HtWt> solution, HtWt value) {
		if (solution == null)
			return false;
		if (solution.size() == 0)
			return true;

		HtWt last = solution.get(solution.size() - 1);
		return last.isBefore(value);
	}

	public static class HtWt implements Comparable<HtWt> {
		public int height; // 为了方便测试，这里改成了public
		public int weight;

		public HtWt(int h, int w) {
			height = h;
			weight = w;
		}

		public int compareTo(HtWt second) {
			if (this.height != second.height) {
				return ((Integer) this.height).compareTo(second.height);
			} else {
				return ((Integer) this.weight).compareTo(second.weight);
			}
		}

		public boolean isBefore(HtWt other) {
			if (height < other.height && weight < other.weight) {
				return true;
			} else {
				return false;
			}
		}
	}
}
