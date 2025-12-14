package streamtest;

import java.util.Iterator;
import java.util.List;

import historypersonsort.HistoryPerson;

public class StreamTest {

	public static void main(String[] args) {

		List<HistoryPerson> people = HistoryPerson.listPeople();

		if (args.length > 0) {
			switch (args[0]) {
			case "osborn":
				System.out.println("1940年に生まれていた人は");

				people.stream().filter((p) -> (p.getBornYear() < 1540) && (true))
						.forEach((p) -> System.out.println(p.getName()));
				break;
				
			case "active":
				System.out.println("1575年に健在だった人は");

				people.stream().filter((p) -> (p.getBornYear() < 1575)).filter((p) -> (p.getDeadYear() > 1575))
						.forEach((p) -> System.out.println(p.getName()));
				break;
				
			case "foreach":
				people.forEach((p) -> System.out.println(p.getName()));
				break;
			case "veryold":
			default:

				Iterator<HistoryPerson> it = people.iterator();

				while (it.hasNext()) {
					HistoryPerson p = it.next();
					System.out.println(p.getName());
				}

			}

		} else {
			for (HistoryPerson p : people) {
				System.out.println(p.getName());
			}
		}

	}

}
