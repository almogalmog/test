package Domain.User_component;
import java.util.Vector;

import Domain.Forum_component.I_Forum;
import Domain.Forum_component.Sub_Forum;


public class Member extends User implements I_Member{
	private String password;
	private Vector <Member> friends;
	private Boolean connected;
	private Boolean isActive;
	private Vector <MemberInForum> mifs;
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
		this.mifs = new Vector<MemberInForum>();
		this.SubForumsPosted=new Vector<Sub_Forum>();
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Vector<Member> getFriends() {
		return friends;
	}

	@Override
	public void setFriends(Vector<Member> friends) {
		this.friends = friends;
	}

	@Override
	public Boolean getConnected() {
		return connected;
	}

	@Override
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	@Override
	public Boolean getIsActive() {
		return isActive;
	}

	@Override
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public void add_mif(MemberInForum mif) {
		this.mifs.add(mif);
		
	}

	@Override
	public void addFriend(Member f) {
		this.friends.add(f);
	}


	@Override
	public Vector <Sub_Forum> getSubForumsPosted() {
		return SubForumsPosted;
	}

	@Override
	public void addSubForumsPosted(Sub_Forum subForumsPosted) {
		SubForumsPosted.add(subForumsPosted);
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public double getAge() {
		return age;
	}

	@Override
	public void setAge(double age) {
		this.age = age;
	}
	@Override
	public Vector<MemberInForum> getMembersInForum(){
		return mifs;
	}
	
	@Override
	public I_MIF get_mif(I_Forum f){
		for(I_MIF mif: this.mifs)
			if(mif.getForum()==f)
				return mif;
		return null;
	}
}