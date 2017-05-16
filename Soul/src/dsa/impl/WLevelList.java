package dsa.impl;

import java.util.ArrayList;

public class WLevelList extends ArrayList<WNode> {

	private static final long serialVersionUID = 1L;

	public void addNode(WNode node) {
		WNode now = node;
		for (int i = 0; i < size(); i++) {
			if (now.compareToNode((WNode) this.toArray()[i]) <= 0) {
				add(i, now);
				return;
			}
		}
		add(size(), now);

	}

	public void addM(WNode node) {
		WNode now = node;
		for (int i = 0; i < size(); i++) {
			if (now.getValueG() < ((WNode) this.toArray()[i]).getValueG()) {
				add(i, now);
				return;
			}
		}
		add(size(), now);
	}
}
