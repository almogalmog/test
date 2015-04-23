package Domain.User_component;
import java.util.Date;

import Domain.Forum_component.Forum;



public class MemberInForum {

	private Member member;
	private Forum forum;
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

	public MemberInForum(Member member, Forum forum){
		this.setMember(member);
		this.setForum(forum);
		this.numOfPosts=0;
		this.startDate= new Date();
		this.connected = true;
		this.type = "Basic";
		this.onlineTime= 0;
	}

	
	public Member getMember() {
		return member;
	}

	
	public void setMember(Member member) {
		this.member = member;
	}

	
	public Forum getForum() {
		return forum;
	}

	
	public void setForum(Forum forum) {
		this.forum = forum;
	}

	
	public int getNumOfPosts() {
		return numOfPosts;
	}

	
	public void addPost() {
		this.numOfPosts++;

	}

	
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
	
	public boolean getConnected(){
		return this.connected;
	}


	
	public void checkStatus(){
		Date currentDate = new Date();
		if(numOfPosts >= silverPosts && onlineTime >= silverOnline && (currentDate.getDay() - startDate.getDay() )>= silverConnected) // 1000 milsec = sec, 1 day = 86,400 sec
			this.type="Silver";
		if(numOfPosts >= goldPosts && onlineTime >= goldOnline && (currentDate.getDay() - startDate.getDay() )>= goldConnected)
			this.type = "Gold";
	}

	
	public long getOnlineTime() {
		return this.onlineTime;
	}

}





