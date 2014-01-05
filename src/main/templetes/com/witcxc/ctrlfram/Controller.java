package com.witcxc.ctrlfram;

import java.util.ArrayList;
import java.util.List;
import static com.witcxc.io.utils.Print.*;

public class Controller {
	private List<Event> eventList = new ArrayList<Event>();

	public void addEvent(Event c) {
		eventList.add(c);
	}

	public void run() {
		while (eventList.size() > 0) {
			for (Event e : new ArrayList<Event>(eventList)) {
				if (e.ready()) {
					print(e);
					e.action();
					eventList.remove(e);
				}
			}

		}

	}
}
