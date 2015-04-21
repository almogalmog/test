package Domain.User_component;

import Domain.Forum_component.I_Forum;

public interface I_MIF {

	public abstract Member getMember();

	public abstract void setMember(Member member);

	public abstract I_Forum getForum();

	public abstract void setForum(I_Forum forum);

	public abstract int getNumOfPosts();

	public abstract void addPost();

	public abstract void setConnected(Boolean connected);

	public abstract boolean getConnected();

	public abstract void checkStatus();

	public abstract long getOnlineTime();

}