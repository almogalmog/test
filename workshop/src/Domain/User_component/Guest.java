package Domain.User_component;

import Domain.Forum_component.Forum;

public class Guest extends User {
	private Forum forum;

	public Guest(Forum forum, int guest_num) {
		super("guest" + guest_num + "");
		this.forum = forum;
	}

	public Forum getForum() {
		return forum;
	}
}
