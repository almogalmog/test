package Domain.User_component;
import java.util.Date;

import Domain.Forum_component.I_Forum;



public class MemberInForum implements I_MIF {

	private Member member;
	private I_Forum forum;
	private int numOfPosts;
	private Date loginTime;
	private Date logoutTime;
	private long onlineTime;
	private Date startDate;
	private Boolean connected;
	private String type;
	private final int silverPosts = 80;
	private final long silverOnline = 1000*86400*20; // 1000 milsec = sec, 1 day = 86,400 sec
	private final long silverConnected= 120;
	private final int goldPosts= 160;
	private final long goldOnline= 1000*86400*50; // 1000 milsec = sec, 1 day = 86,400 sec
	private final long goldConnected=  240;

	public MemberInForum(Member member, I_Forum forum){
		this.setMember(member);
		this.setForum(forum);
		this.numOfPosts=0;
		this.startDate= new Date();
		this.connected = true;
		this.type = "Basic";
		this.onlineTime= 0;
	}

	@Override
	public Member getMember() {
		return member;
	}

	@Override
	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public I_Forum getForum() {
		return forum;
	}

	@Override
	public void setForum(I_Forum forum) {
		this.forum = forum;
	}

	@Override
	public int getNumOfPosts() {
		return numOfPosts;
	}

	@Override
	public void addPost() {
		this.numOfPosts++;

	}

	@Override
	public void setConnected(Boolean connected) {
		if (connected ==false){
			this.connected = false;
			logoutTime= new Date();
			onlineTime = onlineTime + (logoutTime.getTime() - loginTime.getTime());
		}
		else {
			this.connected = true;
			loginTime = new Date();
		}
		checkStatus();
	}
	@Override
	public boolean getConnected(){
		return this.connected;
	}


	@Override
	public void checkStatus(){
		Date currentDate = new Date();
		if(numOfPosts >= silverPosts && onlineTime >= silverOnline && (currentDate.getDay() - startDate.getDay() )>= silverConnected) // 1000 milsec = sec, 1 day = 86,400 sec
			this.type="Silver";
		if(numOfPosts >= goldPosts && onlineTime >= goldOnline && (currentDate.getDay() - startDate.getDay() )>= goldConnected)
			this.type = "Gold";
	}

	@Override
	public long getOnlineTime() {
		return this.onlineTime;
	}

}





