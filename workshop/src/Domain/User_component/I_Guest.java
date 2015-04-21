package Domain.User_component;

import Domain.Forum_component.I_Forum;

public interface I_Guest extends I_User{

	public abstract I_Forum getForum();

}