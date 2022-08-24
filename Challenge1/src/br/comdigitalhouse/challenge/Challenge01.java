package br.comdigitalhouse.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Challenge01 {

	public static boolean search(int[] values, int goal, int index, int selectedTotal, int discardedTotal,
			List<Integer> selected, List<Integer> discarded) {
		if (selected.size() == values.length / 2 && discarded.size() == values.length / 2) {
			return selectedTotal == goal;
		}
		if (selectedTotal > goal || discardedTotal > goal || index == values.length) {
			return selectedTotal == goal;
		}


		if (selected.size() < values.length / 2 && search(values, goal, index + 1, selectedTotal + values[index],
				discardedTotal, selected, discarded)) {
			selected.add(values[index]);
			return true;
		}

		if (discarded.size() < values.length / 2 && search(values, goal, index + 1, selectedTotal,
				discardedTotal + values[index], selected, discarded)) {
			discarded.add(values[index]);
			return true;
		}
		return false;
	}

	public static List<Integer> solve(int[] values) {
		Arrays.sort(values);
		int goal = IntStream.of(values).sum() / 2;
		List<Integer> selected = new ArrayList<>();
		List<Integer> discarded = new ArrayList<>();
		if (!search(values, goal, 0, 0, 0, selected, discarded)) {
			throw new IllegalArgumentException("This puzzle cannot be solved");
		}
		Collections.reverse(selected);
		Collections.reverse(discarded);
		selected.addAll(discarded);
		return selected;
	}
	
	public static void main(String[] args) {
		System.out.println(solve(new int[] {16,22,35,8,20,1,21,11}));
	}

}
