package Domain.User_component;

import Domain.Forum_component.I_Forum;


public class Guest extends User implements I_Guest{
	private I_Forum forum; 
	
	public Guest(I_Forum forum, int guest_num){
		super("guest"+guest_num+"");
		this.forum = forum;
	}

	@Override
	public I_Forum getForum() {
		return forum;
	}
}
