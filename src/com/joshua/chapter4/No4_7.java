package com.joshua.chapter4;

import java.util.ArrayList;
import java.util.HashMap;

public class No4_7 {
	Project[] findBuildOrder(String[] projects, String[][] dependencies) {
		Graph graph = buildGraph(projects, dependencies);
		return orderProjects(graph.getNodes());
	}

	public Graph buildGraph(String[] projects, String[][] dependencies) {
		Graph graph = new Graph();
		for (String project : projects) {
			graph.getOrCreateNode(project);
		}

		for (String[] dependency : dependencies) {
			graph.addEdge(dependency[0], dependency[1]);
		}
		return graph;
	}

	public Project[] orderProjects(ArrayList<Project> projects) {
		Project[] order = new Project[projects.size()];

		int offset = 0;

		for (Project project : projects) {
			if (project.getNumberDependencies() == 0) {
				order[offset] = project;
				offset++;
			}
		}

		//此处跟书中有所不同，书中单独讲方法addNonDependent()提出，并且两次调用
		for (int i = 0; i < order.length; i++) {
			Project current = order[i];
			if (current == null)
				return null;

			//此处将书中的两段合并
			for (Project child : current.getChildren()) {
				child.decrementDependencies();
				if (child.getNumberDependencies() == 0) {
					order[offset] = child;
					offset++;
				}
			}
		}
		return order;
	}

	//--------------------------------------
	public class Graph {
		private ArrayList<Project> nodes = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();

		public Project getOrCreateNode(String name) {
			if (!map.containsKey(name)) {
				Project node = new Project(name);
				nodes.add(node);
				map.put(name, node);
			}

			return map.get(name);
		}

		public void addEdge(String startName, String endName) {
			Project start = getOrCreateNode(startName);
			Project end = getOrCreateNode(endName);
			start.addNeighbor(end);
		}

		public ArrayList<Project> getNodes() {
			return nodes;
		}
	}

	public class Project {
		private ArrayList<Project> children = new ArrayList<Project>();
		private HashMap<String, Project> map = new HashMap<String, Project>();
		private String name;
		private int dependencies = 0;

		public Project(String name) {
			this.name = name;
		}

		public void addNeighbor(Project node) {
			children.add(node);
			map.put(node.getName(), node);
			node.incrementDependencies();
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencies() {
			dependencies--;
		}

		public int getNumberDependencies() {
			return dependencies;
		}

		public String getName() {
			return name;
		}

		public ArrayList<Project> getChildren() {
			return children;
		}
	}
}
