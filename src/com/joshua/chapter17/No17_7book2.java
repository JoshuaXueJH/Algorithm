package com.joshua.chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class No17_7book2 {
	public static void main(String[] args) {
		HashMap<String, Integer> list = new HashMap<String, Integer>();
		list.put("John", 10);
		list.put("Jon", 3);
		list.put("Davis", 2);
		list.put("Kari", 3);
		list.put("Johnny", 11);
		list.put("Carlton", 8);
		list.put("Carleton", 2);
		list.put("Jonathan", 9);
		list.put("Carrie", 5);

		String[][] pairs = { { "Jonathan", "John" }, { "Jon", "Johnny" }, { "Johnny", "John" }, { "Kari", "Carrie" },
				{ "Carleton", "Carlton" } };

		No17_7book2 instance = new No17_7book2();
		HashMap<String, Integer> newList = instance.trulyMostPopular(list, pairs);
		for (String key : newList.keySet()) {
			System.out.println(key + "---->" + newList.get(key));
		}
	}

	HashMap<String, Integer> trulyMostPopular(HashMap<String, Integer> names, String[][] synonyms) {
		Graph graph = constructGraph(names);
		connectEdges(graph, synonyms);

		HashMap<String, Integer> rootNames = getTrueFrequencies(graph);
		return rootNames;
	}

	Graph constructGraph(HashMap<String, Integer> names) {
		Graph graph = new Graph();
		for (Entry<String, Integer> entry : names.entrySet()) {
			String name = entry.getKey();
			int frequency = entry.getValue();
			graph.createNode(name, frequency);
		}
		return graph;
	}

	void connectEdges(Graph graph, String[][] synonyms) {
		for (String[] entry : synonyms) {
			String name1 = entry[0];
			String name2 = entry[1];
			graph.addEdge(name1, name2);
		}
	}

	HashMap<String, Integer> getTrueFrequencies(Graph graph) {
		HashMap<String, Integer> rootNames = new HashMap<String, Integer>();
		for (GraphNode node : graph.getNodes()) {
			if (!node.isVisited()) {
				int frequency = getComponentFrequency(node);
				String name = node.getName();
				rootNames.put(name, frequency);
			}
		}
		return rootNames;
	}

	int getComponentFrequency(GraphNode node) {
		if (node.isVisited()) {
			return 0;
		}

		node.setVisited(true);
		int sum = node.getFrequency();
		for (GraphNode child : node.getNeighbours()) {
			sum += getComponentFrequency(child);
		}
		return sum;
	}

	class Graph {
		private ArrayList<GraphNode> nodes = new ArrayList<GraphNode>();
		private HashMap<String, GraphNode> map = new HashMap<String, GraphNode>();

		public void createNode(String name, int frequency) {
			GraphNode node = new GraphNode(name, frequency);
			nodes.add(node);
			map.put(name, node);
		}

		public GraphNode getNode(String name) {
			if (map.containsKey(name)) {
				return map.get(name);
			}
			return null;
		}

		public void addEdge(String name1, String name2) {
			GraphNode start = getNode(name1);
			GraphNode end = getNode(name2);
			start.addNeighbour(end);
			end.addNeighbour(start); // 第一次在写的时候没有加这一步，需要双向箭头，否则在寻找相邻节点时候会少算
		}

		public ArrayList<GraphNode> getNodes() {
			return nodes;
		}
	}

	class GraphNode {
		private String name;
		private int frequency;
		private boolean visited;
		private ArrayList<GraphNode> neighbour = new ArrayList<GraphNode>();
		private HashMap<String, GraphNode> map = new HashMap<String, GraphNode>();

		public GraphNode(String name, int frequency) {
			this.name = name;
			this.frequency = frequency;
			visited = false;
		}

		public void addNeighbour(GraphNode child) {
			neighbour.add(child);
			map.put(child.getName(), child);
		}

		public ArrayList<GraphNode> getNeighbours() {
			return neighbour;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getFrequency() {
			return frequency;
		}

		public void setFrequency(int frequency) {
			this.frequency = frequency;
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}
	}
}
