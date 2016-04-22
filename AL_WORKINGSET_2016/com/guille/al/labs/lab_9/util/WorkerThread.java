package com.guille.al.labs.lab_9.util;

import java.util.ArrayList;

import com.guille.al.labs.lab_9.util.Node;
import com.guille.anotations.Beta;

@Beta
public class WorkerThread extends Thread {
    // private static Logger log = LoggerFactory.getLogger(WorkerThread.class);

    @Override
    public void run() {
	// log.debug(Thread.currentThread().getName() + " - STARTING");
	// long l1 = System.currentTimeMillis();

	while (!BranchAndBoundThreads.ds.empty()
		&& BranchAndBoundThreads.ds.estimateBest() < BranchAndBoundThreads.pruneLimit) {
	    Node node = BranchAndBoundThreads.ds.extractBestNode();

	    ArrayList<Node> children = node.expand();

	    for (Node child : children)
		if (child.isSolution()) {
		    int cost = child.getHeuristicValue();
		    if (cost < BranchAndBoundThreads.pruneLimit) {
			BranchAndBoundThreads.pruneLimit = cost;
			BranchAndBoundThreads.bestNode = child;
		    }
		} else if (child.getHeuristicValue() < BranchAndBoundThreads.pruneLimit) {
		    BranchAndBoundThreads.ds.insert(child);
		}
	} // while
	  // long l2 = System.currentTimeMillis();
	  // log.debug(Thread.currentThread().getName() + " - FINISHING AFTER "
	  // + (l2 - l1) + " milliseconds");
    }

}
