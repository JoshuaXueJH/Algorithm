package com.joshua.chapter17;

public class No17_11book1 {
	public static void main(String[] args) {
		String file = "aa 000 bb 111 cc dd 000 ff ee gg 000 ss 000 oo ll 111 hs sd ge we sd we gr we gw 111 we gr hr";
		No17_11book1 instance = new No17_11book1();
		LocationPair pair = instance.findClosest(file.split(" "), "000", "111");
		System.out.println(pair.location1 + "--" + pair.location2);
	}

	LocationPair findClosest(String[] words, String word1, String word2) {
		LocationPair best = new LocationPair(-1, -1);
		LocationPair current = new LocationPair(-1, -1);

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word.equals(word1)) {
				current.location1 = i;
				best.updateWithMin(current);
			} else if (word.equals(word2)) {
				current.location2 = i;
				best.updateWithMin(current);
			}
		}

		return best;
	}

	public class LocationPair {
		public int location1, location2;

		public LocationPair(int first, int second) {
			setLocations(first, second);
		}

		public void setLocations(int first, int second) {
			this.location1 = first;
			this.location2 = second;
		}

		public void setLocations(LocationPair loc) {
			setLocations(loc.location1, loc.location2);
		}

		public int distance() {
			return Math.abs(location1 - location2);
		}

		public boolean isValid() {
			return location1 >= 0 && location2 >= 0;
		}

		public void updateWithMin(LocationPair loc) {
			if (!isValid() || loc.distance() < distance()) {
				setLocations(loc);
			}
		}
	}
}
