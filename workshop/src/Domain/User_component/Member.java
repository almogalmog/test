package Domain.User_component;
import java.util.Vector;

import Domain.Forum_component.Forum;
import Domain.Forum_component.Sub_Forum;


public class Member extends User{
	private String password;
	private Vector <Member> friends;
	private Boolean connected;
	private Boolean isActive;
	private Vector <MemberInForum> MemberInForums;
	private Vector <Sub_Forum> SubForumsPosted;
	private String email;
	private double age;
	
	public Member(String username, String password,String email,double age){
		super(username);
		this.setPassword(password);
		this.setAge(age);
		this.setEmail(email);
		this.setFriends(new Vector<Member>());
		this.setConnected(true);
		this.setIsActive(true);
		this.MemberInForums = new Vector<MemberInForum>();
		this.SubForumsPosted=new Vector<Sub_Forum>();
	}

	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	
	public Vector<Member> getFriends() {
		return friends;
	}

	
	public void setFriends(Vector<Member> friends) {
		this.friends = friends;
	}

	
	public Boolean getConnected() {
		return connected;
	}

	
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	
	public Boolean getIsActive() {
		return isActive;
	}

	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	public void add_MemberInForum(MemberInForum MemberInForum) {
		this.MemberInForums.add(MemberInForum);
		
	}

	
	public void addFriend(Member f) {
		this.friends.add(f);
	}


	
	public Vector <Sub_Forum> getSubForumsPosted() {
		return SubForumsPosted;
	}

	
	public void addSubForumsPosted(Sub_Forum subForumsPosted) {
		SubForumsPosted.add(subForumsPosted);
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public double getAge() {
		return age;
	}

	
	public void setAge(double age) {
		this.age = age;
	}
	
	public Vector<MemberInForum> getMembersInForum(){
		return MemberInForums;
	}
	
	public MemberInForum getMembersInForum(Forum f){
		for(MemberInForum mif : this.MemberInForums)
			if(mif.getForum() == f)
				return mif;
		 return null;
	}
	
	
	public MemberInForum get_MemberInForum(Forum f){
		for(MemberInForum MemberInForum: this.MemberInForums)
			if(MemberInForum.getForum()==f)
				return MemberInForum;
		return null;
	}
}